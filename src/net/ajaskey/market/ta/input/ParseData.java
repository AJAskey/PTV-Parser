
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.InterdayData;
import net.ajaskey.market.ta.TickerData;

/**
 *
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class ParseData {

	private static List<String>	validTickers	= new ArrayList<>();
	private static double				MIN_PRICE			= 0.0;
	private static int					MIN_VOLUME		= 0;
	private static int					GET_ALL_DATA	= 999999;

	/**
	 *
	 *
	 * Procedure clearValidTickers. ;
	 */
	public static void clearValidTickers() {

		validTickers.clear();
	}

	/**
	 * @return the mIN_PRICE
	 */
	public static double getMIN_PRICE() {

		return MIN_PRICE;
	}

	/**
	 * @return the mIN_VOLUME
	 */
	public static int getMIN_VOLUME() {

		return MIN_VOLUME;
	}

	/**
	 *
	 * Procedure getTickerList
	 *
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> getTickerList(String filename) throws FileNotFoundException, IOException {

		final List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			String line = "";
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {
					final String sline = line.trim().substring(0, Math.min(10, line.length())).toLowerCase();
					if (!sline.contains("ticker") && !sline.contains("symbol")) {
						final String fld[] = line.trim().split("[,\\s+]");
						if (fld[0].trim().length() > 0) {
							list.add(fld[0].trim().replaceAll("\"", ""));
							// System.out.println(fld[0]);
						}
					}
				}
			}
		}
		return list;
	}

	static public int getValidTickerCount() {

		return validTickers.size();
	}

	/**
	 * net.ajaskey.market.ta.input.isCurrent
	 *
	 * @param f
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean isCurrent(File f) {

		boolean current = false;
		if (f.exists()) {
			final long modtime = f.lastModified();
			final Calendar calFile = Calendar.getInstance();
			calFile.setTimeInMillis(modtime);
			final int fileDoy = calFile.get(Calendar.DAY_OF_YEAR);

			final Calendar cal = Calendar.getInstance();
			final int doy = cal.get(Calendar.DAY_OF_YEAR);

			current = (fileDoy != doy);
		}
		return current;
	}

	/**
	 *
	 * @param ticker
	 * @return
	 */
	static public boolean isTickerValid(String ticker) {

		return TickerFullName.isValid(ticker.trim());
	}

	public static void main(String[] args) {

		try {
			final List<String> l = ParseData.getTickerList("data/SP500-SIP3.CSV");
			for (final String s : l) {
				System.out.println(s);
			}
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.mergeLists
	 *
	 * @param mainList
	 * @param newList
	 */
	private static void mergeLists(List<TickerData> mainList, List<TickerData> newList) {

		for (final TickerData tdNew : newList) {
			boolean found = false;
			for (final TickerData tdMain : mainList) {
				if (tdNew.getTicker().equalsIgnoreCase(tdMain.getTicker())) {
					// tdMain.getData().addAll(tdNew.getData());
					TickerData.mergeData(tdMain, tdNew);
					found = true;
					break;
				}
			}
			if (!found) {
				mainList.add(tdNew);
			}
		}
	}

	/**
	 *
	 * @param file
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public List<TickerData> parseFile(File file) throws ParseException, FileNotFoundException {

		if ((validTickers == null) || (validTickers.size() == 0)) {
			return null;
		}

		final List<TickerData> tdList = new ArrayList<>();

		try {

			if (file == null) {
				throw new FileNotFoundException();
			}

			boolean processAll = false;
			if (validTickers.get(0).equals("PROCESS_ALL_TICKERS")) {
				processAll = true;
			}

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				String line = br.readLine();

				if ((line == null) || (line.length() < 1)) {
					throw new ParseException("no data", 1);
				}

				while (line != null) {
					line = br.readLine();

					if ((line != null) && (line.length() > 10)) {
						final String fld[] = line.split(",");

						if ((processAll) || (validTickers.contains(fld[0]))) {

							// System.out.println("\t" + line);

							if ((fld.length == 7) || ((fld.length == 8) && (fld[0].contains("OEX.XO")))) {

								double oi = 0;
								if (fld.length == 8) {
									oi = ParseData.toDouble(fld[7]);
								}

								final TickerData tdCheck = TickerData.getFromList(fld[0], tdList);

								final DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
								final Calendar cal = Calendar.getInstance();
								cal.setTime(df.parse(fld[1]));
								TickerData td;
								if (tdCheck != null) {
									final DailyData dd = new DailyData(cal, ParseData.toDouble(fld[2]), ParseData.toDouble(fld[3]),
									    ParseData.toDouble(fld[4]), ParseData.toDouble(fld[5]), ParseData.toDouble(fld[6]), oi);
									tdCheck.addData(dd);
								} else {
									td = new TickerData(fld[0], cal, ParseData.toDouble(fld[2]), ParseData.toDouble(fld[3]),
									    ParseData.toDouble(fld[4]), ParseData.toDouble(fld[5]), ParseData.toDouble(fld[6]), oi);

									final String exch = file.getParent();
									final int idx = exch.lastIndexOf("\\");
									td.setTickerExchange(exch.substring(idx + 1));

									tdList.add(td);
									// System.out.println("Added : " + fld[0]);
								}

							} else {
								throw new ParseException("bad data", 1);
							}
						}
					}
				}
			}

		} catch (final FileNotFoundException e1) {
			System.out.printf("ERROR - Input file \"%s\" not found in ParseFile()!%n", file);
			throw e1;
		} catch (final Exception e2) {
			System.out.printf("ERROR - Processing issues in ParseFile()!%n");
			throw new ParseException("bad data", 1);
		}
		return tdList;

	}

	/**
	 *
	 * @param fileNames
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public List<TickerData> parseFiles(List<String> fileNames) throws ParseException, FileNotFoundException {

		return ParseData.parseFiles(fileNames, 36500);
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parseFiles
	 *
	 * @param directoryNames
	 * @param calendarDays
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static List<TickerData> parseFiles(List<String> directoryNames, int calendarDays)
	    throws FileNotFoundException, ParseException {

		final List<TickerData> tdList = new ArrayList<>();

		final Calendar cal = Calendar.getInstance();
		// System.out.println(Utils.calendarToString(cal));
		final int day = cal.get(Calendar.DAY_OF_YEAR);
		final int newDay = day - calendarDays;
		cal.set(Calendar.DAY_OF_YEAR, newDay);
		// System.out.println(Utils.calendarToString(cal));

		if (directoryNames == null) {
			System.out.println("List of files is null in parseFiles");
			throw new FileNotFoundException();
		}

		for (final String fname : directoryNames) {

			final File flist = new File(fname);

			if (!flist.exists()) {
				tdList.clear();
				return tdList;
			}

			for (final File f : flist.listFiles()) {

				final String fn = f.getName();

				if (fn.contains(".csv")) {

					final int idx1 = fn.lastIndexOf("_") + 1;
					final int idx2 = fn.lastIndexOf(".");

					final String sDate = fn.substring(idx1, idx2);
					final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					final Date d = sdf.parse(sDate);
					final Calendar c = Calendar.getInstance();
					c.setTime(d);

					if (c.after(cal)) {

						// System.out.println(f.getName());

						final List<TickerData> td = ParseData.parseFile(f);

						if (td != null) {
							ParseData.mergeLists(tdList, td);
						}
					}
				}
			}
		}

		return tdList;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parseInterdayFile
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	static public List<InterdayData> parseInterdayFile(File file)
	    throws IOException, FileNotFoundException, ParseException {

		String tkr = "";
		double open = 0;
		double high = 0;
		double low = 0;
		double close = 0;
		double volume = 0;

		final List<InterdayData> data = new ArrayList<>();

		if (file == null) {
			throw new FileNotFoundException();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = "";
			while (line != null) {
				line = br.readLine();

				if ((line != null) && (line.length() > 10) && (!line.contains("Symbol,"))) {
					final String fld[] = line.split(",");

					if (fld.length == 7) {
						tkr = fld[0].trim();
						open = ParseData.toDouble(fld[2].trim());
						high = ParseData.toDouble(fld[3].trim());
						low = ParseData.toDouble(fld[4].trim());
						close = ParseData.toDouble(fld[5].trim());
						volume = ParseData.toDouble(fld[6].trim());

						InterdayData theData = null;
						for (final InterdayData id : data) {
							if (tkr.equalsIgnoreCase(id.getTicker())) {
								theData = id;
								break;
							}
						}
						if (theData == null) {
							theData = new InterdayData();
							theData.setTicker(tkr);
							data.add(theData);
						}
						theData.addData(open, high, low, close, volume);
					}
				}
			}
		}

		return data;

	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parseOneFile
	 *
	 * @param fname
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public TickerData parseOneFile(String fname) throws ParseException, FileNotFoundException {

		return ParseData.parseOneFile(fname, GET_ALL_DATA);
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parseOneFile
	 *
	 * @param fname
	 * @param days
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public TickerData parseOneFile(String fname, int days) throws ParseException, FileNotFoundException {

		final TickerData tickerData = new TickerData();
		try {

			if (fname == null) {
				throw new FileNotFoundException();
			}

			try (BufferedReader br = new BufferedReader(new FileReader(fname))) {

				String line = br.readLine();
				if ((line == null) || (line.length() < 1)) {
					throw new ParseException("no data", 1);
				}

				final String tkr = line.trim();

				line = br.readLine();
				if ((line == null) || (line.length() < 1)) {
					throw new ParseException("no data", 1);
				}

				while (line != null) {
					line = br.readLine();

					if ((line != null) && (line.length() > 10)) {
						final String fld[] = line.split(",");

						final DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
						final Calendar cal = Calendar.getInstance();
						cal.setTime(df.parse(fld[0]));

						tickerData.setTicker(tkr);
						final double o = ParseData.toDouble(fld[1].trim());
						final double h = ParseData.toDouble(fld[2].trim());
						final double l = ParseData.toDouble(fld[3].trim());
						final double c = ParseData.toDouble(fld[4].trim());
						final double v = ParseData.toDouble(fld[5].trim());
						final DailyData d = new DailyData(cal, o, h, l, c, v, 0);
						tickerData.addData(d);
						if (tickerData.getDataCount() >= days) {
							line = null; // break from read loop
						}
					}
				}
			}
		} catch (final FileNotFoundException e1) {
			System.out.printf("ERROR - Input file \"%s\" not found in ParseOneFile!%n", fname);
			throw e1;
		} catch (final Exception e2) {
			System.out.printf("ERROR - Processing issues in ParseOneFile!%n");
			throw new ParseException("bad data", 1);
		}

		tickerData.generateDerived(false);

		return tickerData;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parsePTVData
	 *
	 * @param dirStr
	 * @return
	 */
	public static List<TickerData> parsePTVData(String dirStr) {

		return ParseData.parsePTVData(dirStr, GET_ALL_DATA);
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.parsePTVData
	 *
	 * @param dirStr
	 * @param days
	 * @return
	 */
	public static List<TickerData> parsePTVData(String dirStr, int days) {

		final List<TickerData> tdList = new ArrayList<>();
		final File dir = new File(dirStr);
		final File[] files = dir.listFiles();

		boolean processAll = false;
		if (validTickers.get(0).equals("PROCESS_ALL_TICKERS")) {
			processAll = true;
		}

		for (final File f : files) {
			try {
				final TickerData td = ParseData.parseOneFile(f.getAbsolutePath(), days);
				if ((td != null) && ((days == GET_ALL_DATA) || (td.getDataCount() >= days))) {
					if ((processAll) || (validTickers.contains(td.getTicker()))) {
						tdList.add(td);
					}
				}
			} catch (final Exception e) {
				System.out.println("Invalid file found : " + f.getAbsolutePath());
			}
		}

		return tdList;
	}

	/**
	 * @param mIN_PRICE
	 *          the mIN_PRICE to set
	 */
	public static void setMIN_PRICE(double mIN_PRICE) {

		MIN_PRICE = mIN_PRICE;
	}

	/**
	 * @param mIN_VOLUME
	 *          the mIN_VOLUME to set
	 */
	public static void setMIN_VOLUME(int mIN_VOLUME) {

		MIN_VOLUME = mIN_VOLUME;
	}

	/**
	 *
	 * @param ticker
	 */
	public static void setValidTicker(String ticker) {

		if (ticker != null) {
			validTickers.add(ticker.trim().toUpperCase());
		}
	}

	/**
	 *
	 * @param tickers
	 */
	public static void setValidTickers(List<String> tickers) {

		for (final String t : tickers) {
			ParseData.setValidTicker(t);
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.toDouble
	 *
	 * @param str
	 * @return
	 */
	private static Double toDouble(String str) {

		String dStr;
		try {
			final int idx = str.indexOf(".");
			if (idx > 0) {
				dStr = str;
			} else {
				dStr = str + ".0";
			}
		} catch (final Exception e) {
			dStr = "0.0";
		}
		// System.out.println(str + "\t" + dStr);
		return Double.parseDouble(dStr);
	}

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private ParseData() {
	}

}
