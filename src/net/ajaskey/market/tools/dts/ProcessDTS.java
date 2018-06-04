
package net.ajaskey.market.tools.dts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.dts.DtsReports.DTS_TYPE;
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
public class ProcessDTS {
 
	final static private String	url		= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";
	final static private String	urlA	= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=a&fname=";

	final static private String folderPath = "c:/data/dts";
	// final static private String folderPath = "d:/temp/dts-lt";
	//final static private Charset charset = Charset.forName("UTF-8");

	final static public int	webDownloadYear		= 2018;
	final static public int	webDownloadMonth	= Calendar.MAY;
	final static public int	webDownloadDay		= 20;

	/**
	 *
	 * net.ajaskey.market.tools.getDateName
	 *
	 * @param c
	 * @return
	 */
	private static String getDateName(Calendar c) {

		if (c != null) {
			return DtsData.sdf.format(c.getTime()) + "00";
		}
		return "";
	}

	/**
	 * net.ajaskey.market.tools.getSPX
	 *
	 */
	private static void getSPX() {

		DtsData.dtsList.get(0).getDate();

	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {

		Utils.makeDir("out");
		Utils.makeDir("out/optuma");

		ProcessDTS.updateDtsFiles();

		ProcessDTS.readAndProcess();

		ProcessDTS.getSPX();

		DtsReports.writeYY(DTS_TYPE.CORPORATE);
		DtsReports.writeYY(DTS_TYPE.INDIVIDUAL);
		DtsReports.writeYY(DTS_TYPE.WITHHELD);
		DtsReports.writeYY(DTS_TYPE.COMBINED);

		try {
			DtsReports.dumpRaw("dump", Utils.buildCalendar(2014, Calendar.JANUARY, 1));

			DtsReports.writeSumDaily(DTS_TYPE.CORPORATE);
			DtsReports.writeSumDaily(DTS_TYPE.INDIVIDUAL);
			DtsReports.writeSumDaily(DTS_TYPE.WITHHELD);
			DtsReports.writeSumDaily(DTS_TYPE.COMBINED);

			DtsReports.writeUnemploymentTaxes("unemployment");
			DtsReports.writeFiscalYear("fy");
			DtsReports.writeQuarterly("quarterly");
			DtsReports.writeEomCsv(Utils.buildCalendar(2013, Calendar.OCTOBER, 1));
			DtsReports.writeOptuma();
			System.out.println(DtsReports.genLastReport(DtsReports.REPORT_RANGE.YEAR));
			System.out.println(DtsReports.genLastReport(DtsReports.REPORT_RANGE.MONTH));
			System.out.println(DtsReports.genLastReport(DtsReports.REPORT_RANGE.DAY));

			DtsReports.dumpCompareMonths(2017, 2016, Calendar.JULY);
			DtsReports.dumpCompareMonths(2017, 2016, Calendar.AUGUST);
			DtsReports.dumpCompareMonths(2017, 2016, Calendar.SEPTEMBER);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

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
				file.toPath();
				// try (BufferedReader reader = Files.newBufferedReader(path, charset))
				// {
				try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {

					String line;
					final DtsData d = new DtsData(file.getName());
					// Utils.printCalendar(d.getDate());
					while ((line = reader.readLine()) != null) {

						// System.out.println(line);
						if (line.length() > 10) {
							if (line.contains("Withheld Income and Employment Taxes")) {
								d.setWith(line);
								if (d.getDate().get(Calendar.YEAR) > lastYr) {
									knt = 0;
									lastYr = d.getDate().get(Calendar.YEAR);
								}
								knt++;
								d.setRptKnt(knt);
							} else if (line.contains("Individual Income Taxes")) {
								d.setInd(line);
							} else if (line.contains("Corporation Income Taxes")) {
								d.setCorp(line);
							} else if (line.contains("Federal Unemployment Taxes")) {
								d.setUnEmp(line);
							}

						}
					}

					DtsData.dtsList.add(d);

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

			final String fname = ProcessDTS.getDateName(cal);

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
			} else if (day.contains("SUN")) {
				cal.add(Calendar.DATE, 1);
			}
		}
	}

}
