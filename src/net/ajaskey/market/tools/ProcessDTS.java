
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.ta.Utils;
import net.ajaskey.market.tools.helpers.DtsData;
import net.ajaskey.market.tools.helpers.DtsReports;
import net.ajaskey.market.tools.helpers.DtsSorter;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2016, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
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
 *         </p>
 *
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class ProcessDTS {

	final static private String		url								= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";

	final static private String		urlA							= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=a&fname=";

	final static private String		folderPath				= "d:/temp/dts";
	final static private Charset	charset						= Charset.forName("UTF-8");

	private static final int			avgWin						= 1;

	final static public int				webDownloadYear		= 2016;
	final static public int				webDownloadMonth	= Calendar.JUNE;
	final static public int				webDownloadDay		= 1;

	/**
	 * net.ajaskey.market.tools.CalculateAverage
	 *
	 */
	private static void calculateAverages() {
		final int len = DtsData.dtsList.size() - avgWin;
		final double winSize = (2.0 * avgWin) + 1.0;

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += DtsData.dtsList.get(j).getWith().daily;
				mtot += DtsData.dtsList.get(j).getWith().monthly;
				ytot += DtsData.dtsList.get(j).getWith().yearly;
			}
			double a = tot / winSize;
			DtsData.dtsList.get(i).getWith().dailyAvg = a;

			a = mtot / winSize;
			DtsData.dtsList.get(i).getWith().monthlyAvg = a;

			a = ytot / winSize;
			DtsData.dtsList.get(i).getWith().yearlyAvg = a;
		}

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += DtsData.dtsList.get(j).getInd().daily;
				mtot += DtsData.dtsList.get(j).getInd().monthly;
				ytot += DtsData.dtsList.get(j).getInd().yearly;
			}
			double a = tot / winSize;
			DtsData.dtsList.get(i).getInd().dailyAvg = a;

			a = mtot / winSize;
			DtsData.dtsList.get(i).getInd().monthlyAvg = a;

			a = ytot / winSize;
			DtsData.dtsList.get(i).getInd().yearlyAvg = a;
		}

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += DtsData.dtsList.get(j).getCorp().daily;
				mtot += DtsData.dtsList.get(j).getCorp().monthly;
				ytot += DtsData.dtsList.get(j).getCorp().yearly;
			}
			double a = tot / winSize;
			DtsData.dtsList.get(i).getCorp().dailyAvg = a;

			a = mtot / winSize;
			DtsData.dtsList.get(i).getCorp().monthlyAvg = a;

			a = ytot / winSize;
			DtsData.dtsList.get(i).getCorp().yearlyAvg = a;
		}

	}

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
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {

		ProcessDTS.updateDtsFiles();

		ProcessDTS.readAndProcess();

		ProcessDTS.calculateAverages();

		// DtsReports.CompareReport(2016, Calendar.JUNE, 9);

		// final DtsData d2 = DtsData.findData(9, Calendar.JUNE, 2016);
		// final DtsData d1 = DtsData.findData(9, Calendar.JUNE, 2015);
		final DtsData d1 = DtsData.findData(113, 2015);
		final DtsData d2 = DtsData.findData(114, 2016);
		System.out.println(DtsReports.genDiffReport(d1, d2));

		DtsData dLast = DtsData.dtsList.get(DtsData.dtsList.size() - 1);
		System.out.println("\n\nLast DTS report ==>\n" + dLast);

	}

	/**
	 *
	 * net.ajaskey.market.tools.readAndProcess
	 *
	 */
	private static void readAndProcess() {
		final File allFiles = new File(folderPath);
		final File[] listOfFiles = allFiles.listFiles();

		for (final File file : listOfFiles) {
			if (file.isFile()) {
				// System.out.println(file.getName());
				final Path path = file.toPath();
				try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
					String line;
					final DtsData d = new DtsData(file.getName());
					// Utils.printCalendar(d.getDate());
					while ((line = reader.readLine()) != null) {
						if (line.contains("Withheld Income and Employment Taxes")) {
							d.setWith(line);
						} else if (line.contains("Individual Income Taxes")) {
							d.setInd(line);
						} else if (line.contains("Corporation Income Taxes")) {
							d.setCorp(line);
						}
					}
					DtsData.dtsList.add(d);

				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

		Collections.sort(DtsData.dtsList, new DtsSorter());

	}

	/**
	 *
	 * net.ajaskey.market.tools.updateDtsFiles
	 *
	 */
	@SuppressWarnings("unused")
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

					System.out.println(Utils.stringCalendar(cal));
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
			final String day = Utils.getDayOfWeek(cal);
			if (day.contains("SAT")) {
				cal.add(Calendar.DATE, 2);
			} else if (day.contains("SUN")) {
				cal.add(Calendar.DATE, 1);
			}
		}
	}

}
