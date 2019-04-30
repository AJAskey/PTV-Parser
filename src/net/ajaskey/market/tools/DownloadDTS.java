
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.dts.DtsData;
import net.ajaskey.market.tools.dts.DtsSorter;
import net.ajaskey.market.tools.helpers.WebGet;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2016, Andy Askey. All rights
 *         reserved. </p> <p> Permission is hereby granted, free of charge, to
 *         any person obtaining a copy of this software and associated
 *         documentation files (the "Software"), to deal in the Software without
 *         restriction, including without limitation the rights to use, copy,
 *         modify, merge, publish, distribute, sublicense, and/or sell copies of
 *         the Software, and to permit persons to whom the Software is furnished
 *         to do so, subject to the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software. </p>
 *
 *         <p> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE. </p>
 *
 */
public class DownloadDTS {

	final static private String url = "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";

	final static private String	urlA				= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=a&fname=";
	final static private String	folderPath	= "d:/temp/dts-lt";

	final static private Charset	charset					= Charset.forName("UTF-8");
	static public int							webDownloadYear	= 0;

	static public int											webDownloadMonth	= 0;
	static public int											webDownloadDay		= 0;
	final private static SimpleDateFormat	sdf								= new SimpleDateFormat("yyyy-MMM-dd");

	/**
	 *
	 * net.ajaskey.market.tools.getDateName
	 *
	 * @param c
	 * @return
	 */
	private static String getDateName(final Calendar c) {

		if (c != null) {
			return DtsData.sdf.format(c.getTime()) + "00";
		}
		return "";
	}

	/**
	 * net.ajaskey.market.tools.getRecentDate
	 *
	 * @return
	 */
	private static String getRecentDate(final Calendar cal) {

		String sdate;
		cal.add(Calendar.MONTH, -1);
		sdate = sdf.format(cal.getTime());
		return sdate;
	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws ParseException {

		String sDate = null;
		try {
			Date date = null;
			final Calendar cal = Calendar.getInstance();

			if (args.length > 0) {

				if (args[0].toLowerCase().contains("help")) {
					DownloadDTS.printHelp();
					return;
				}
				else if (args[0].toLowerCase().contains("recent")) {
					sDate = DownloadDTS.getRecentDate(cal);
				}
				else {
					System.out.println(args[0]);
					sDate = args[0];
				}

			}
			else {
				System.out.println("Enter RECENT or start date in format yyyy-MMM-dd : ");
				try (final Scanner scan = new Scanner(System.in)) {
					sDate = scan.next();

					if (sDate.toLowerCase().contains("recent")) {

						sDate = DownloadDTS.getRecentDate(cal);
					}
				}
			}

			System.out.println(sDate);
			date = sdf.parse(sDate);
			cal.setTime(date);
			webDownloadYear = cal.get(Calendar.YEAR);
			webDownloadMonth = cal.get(Calendar.MONTH);
			webDownloadDay = cal.get(Calendar.DATE);
		} catch (final Exception e) {
			System.out.println("Invalid date format : " + sDate);
			DownloadDTS.printHelp();
			return;
		}

		System.out.println("Processing DTS from from : " + sDate);

		Utils.makeDir("dts-data");

		System.out.println("Downloading non-existing local files...");

		DownloadDTS.updateDtsFiles();

		System.out.println("Processing data files...");

		DownloadDTS.readAndProcess();

		/*
		 * System.out.println("Write data files to CSV files...");
		 *
		 * try (PrintWriter pw = new PrintWriter("dts-daily.csv"); PrintWriter pwMtd
		 * = new PrintWriter("dts-mtd.csv"); PrintWriter pwYtd = new
		 * PrintWriter("dts-ytd.csv")) {
		 *
		 * pw.printf("Date,Withheld,Individual,Corporate%n");
		 * pwMtd.printf("Date,Withheld,Individual,Corporate%n");
		 * pwYtd.printf("Date,Withheld,Individual,Corporate%n");
		 *
		 * for (DtsData d : DtsData.dtsList) {
		 *
		 * String date = sdf.format(d.getDate().getTime());
		 * pw.printf("%s,%d,%d,%d%n", date, d.getWith().daily, d.getInd().daily,
		 * d.getCorp().daily); pwMtd.printf("%s,%d,%d,%d%n", date,
		 * d.getWith().monthly, d.getInd().monthly, d.getCorp().monthly);
		 * pwYtd.printf("%s,%d,%d,%d%n", date, d.getWith().yearly,
		 * d.getInd().yearly, d.getCorp().yearly);
		 *
		 * } } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		System.out.println("Done.");

	}

	/**
	 * net.ajaskey.market.tools.printHelp
	 *
	 */
	private static void printHelp() {

		String s = "DownloadDTS program\n";
		s += "  Options:\n";
		s += "    Command line : java -jar DownloadDTS.jar yyyy-MMM-dd\n";
		s += "    At prompt : Enter RECENT to download last month of data.\n";
		s += "    At prompt : Enter yyyy-MMM-dd.\n\n";
		s += "  Example: java -jar DownloadDTS.jar RECENT \n";
		s += "  Example: java -jar DownloadDTS.jar 2015-Mar-10 \n";
		s += "  Example: java -jar DownloadDTS.jar\n             (and then enter RECENT or yyyy-MMM-dd at prompt)\n";
		System.out.println(s);
	}

	/**
	 *
	 * net.ajaskey.market.tools.readAndProcess
	 *
	 */
	private static void readAndProcess() {

		final File allFiles = new File(folderPath);
		final File[] listOfFiles = allFiles.listFiles();

		int knt = 0;
		int lastYr = 0;
		for (final File file : listOfFiles) {
			if (file.isFile()) {
				// System.out.println(file.getName());
				try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
					String line;
					final DtsData d = new DtsData(file.getName());
					// Utils.printCalendar(d.getDate());
					while ((line = reader.readLine()) != null) {
						if (line.length() > 10) {
							line = DtsData.cleanString(line, 0);
							if (line.contains("Withheld Income and Employment Taxes   ")) {
								d.setWith(line);
								if (d.getDate().get(Calendar.YEAR) > lastYr) {
									knt = 0;
									lastYr = d.getDate().get(Calendar.YEAR);
								}
								knt++;
								d.setRptKnt(knt);
							}
							else if (line.contains("Individual Income Taxes")) {
								d.setInd(line);
							}
							else if (line.contains("Corporation Income Taxes")) {
								d.setCorp(line);
							}
							else if (line.contains("Federal Unemployment Taxes")) {
								d.setUnEmp(line);
							}

							DtsData.dtsList.add(d);
						}
					}
				} catch (final IOException e) {
					System.out.println(file.getName());
					e.printStackTrace();
				}
			}
		}

		// Sort the list from oldest to newest for future processing.
		Collections.sort(DtsData.dtsList, new DtsSorter());

	}

	/**
	 *
	 * net.ajaskey.market.tools.updateDtsFiles
	 *
	 */
	private static void updateDtsFiles() {

		Utils.makeDir(folderPath);

		final Calendar tommorrow = Calendar.getInstance();
		tommorrow.add(Calendar.DATE, 1);

		final Calendar cal = Calendar.getInstance();
		cal.set(webDownloadYear, webDownloadMonth, webDownloadDay);

		while (cal.before(tommorrow)) {

			List<String> resp = new ArrayList<>();

			final String fname = DownloadDTS.getDateName(cal);

			final String fileName = fname + ".txt";

			final File fTest = new File(folderPath + "/" + fileName);
			if (!fTest.exists()) {

				resp = WebGet.getSPDR(urlA + fileName);

				if (resp == null) {
					resp = WebGet.getSPDR(url + fileName);
				}

				if (resp != null) {

					System.out.println(Utils.stringDate2(cal));
					try (PrintWriter pw = new PrintWriter(folderPath + "/" + fileName)) {
						for (final String s : resp) {
							pw.println(s);
						}
					} catch (final FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			cal.add(Calendar.DATE, 1);
			final String day = Utils.getDayName(cal);
			if (day.contains("SAT")) {
				cal.add(Calendar.DATE, 2);
			}
			else if (day.contains("SUN")) {
				cal.add(Calendar.DATE, 1);
			}
		}
	}

	public DownloadDTS() {

	}

}
