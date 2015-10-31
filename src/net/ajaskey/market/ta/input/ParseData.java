
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
import java.util.List;

import net.ajaskey.market.ta.DailyData;
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

	private static List<String> validTickers = new ArrayList<String>();

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private ParseData() {
	}

	/**
	 *
	 *
	 * Procedure clearValidTickers. ;
	 */
	public static void clearValidTickers() {
		validTickers.clear();
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
		final List<String> list = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {
					String fld[] = line.trim().split("\\s+");
					if (fld[0].length() > 0) {
						list.add(fld[0]);
						//System.out.println(fld[0]);
					}
				}
			}
		}
		return list;
	}

	/**
	 *
	 * @param ticker
	 * @return
	 */
	static public boolean isTickerValid(String ticker) {
		return TickerFullName.isValid(ticker);
	}

	/**
	 *
	 * @param file
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public List<TickerData> parseFile(File file) throws ParseException, FileNotFoundException {

		final List<TickerData> tdList = new ArrayList<TickerData>();

		try {

			if (file == null) {
				throw new FileNotFoundException();
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

						if (validTickers.contains(fld[0])) {

							if (fld.length == 7) {

								final TickerData tdCheck = TickerData.getFromList(fld[0], tdList);

								final DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
								final Calendar cal = Calendar.getInstance();
								cal.setTime(df.parse(fld[1]));
								TickerData td;
								if (tdCheck != null) {
									final DailyData dd = new DailyData(cal, ParseData.toDouble(fld[2]), ParseData.toDouble(fld[3]),
									    ParseData.toDouble(fld[4]), ParseData.toDouble(fld[5]), ParseData.toDouble(fld[6]));
									tdCheck.addData(dd);
								} else {
									td = new TickerData(fld[0], cal, ParseData.toDouble(fld[2]), ParseData.toDouble(fld[3]),
									    ParseData.toDouble(fld[4]), ParseData.toDouble(fld[5]), ParseData.toDouble(fld[6]));

									tdList.add(td);
									// System.out.println("\n");
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
		final List<TickerData> tdList = new ArrayList<TickerData>();

		if (fileNames == null) {
			System.out.println("List of files is null in parseFiles");
			throw new FileNotFoundException();
		}

		for (final String fname : fileNames) {

			final File flist = new File(fname);

			for (final File f : flist.listFiles()) {

				if (f.getName().contains(".csv")) {

					final List<TickerData> td = ParseData.parseFile(f);

					ParseData.mergeLists(tdList, td);
				}
			}
		}

		return tdList;
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
						final DailyData d = new DailyData(cal, o, h, l, c, v);
						tickerData.addData(d);
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

		tickerData.generateDerived();
		;
		return tickerData;
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
					tdMain.getData().addAll(tdNew.getData());
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
	 * net.ajaskey.market.ta.input.toDouble
	 *
	 * @param str
	 * @return
	 */
	private static Double toDouble(String str) {
		final int idx = str.indexOf(".");
		String dStr;
		if (idx > 0) {
			dStr = str;
		} else {
			dStr = str + ".0";
		}
		// System.out.println(str + "\t" + dStr);
		return Double.parseDouble(dStr);
	}

}
