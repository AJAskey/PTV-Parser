
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
import java.util.Locale;
import java.util.Map;

import net.ajaskey.market.ta.Utils;
import net.ajaskey.market.tools.helpers.DtsData;
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

	final static private String					url								= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";

	final static private String					urlA							= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=a&fname=";

	final static private String					folderPath				= "d:/temp/dts";
	final static private Charset				charset						= Charset.forName("UTF-8");

	final static private Locale					locale						= Locale.getDefault();

	static public Map<String, Integer>	mNames						= null;

	static public Map<String, Integer>	mDays							= null;

	public static final List<DtsData>		dtsList						= new ArrayList<>();

	private static final int						avgWin						= 1;

	final static public int							webDownloadYear		= 2016;
	final static public int							webDownloadMonth	= Calendar.JUNE;
	final static public int							webDownloadDay		= 1;

	/**
	 *
	 * net.ajaskey.market.tools.findName
	 *
	 * @param map
	 * @param key
	 * @return
	 */
	public static String findName(Map<String, Integer> map, Integer key) {
		for (final Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == key) {
				return entry.getKey();
			}
		}
		return "NotFound";
	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		final Calendar baseCal = Calendar.getInstance();

		mNames = baseCal.getDisplayNames(Calendar.MONTH, Calendar.LONG, locale);
		mDays = baseCal.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);

		ProcessDTS.updateDtsFiles();
		ProcessDTS.readAndProcess();

		Collections.sort(dtsList, new DtsSorter());

		ProcessDTS.calculateAverages();

		DtsData recent = dtsList.get(dtsList.size() - avgWin - 1);
		DtsData yrAgo = ProcessDTS.findYearAgoData(recent.getDate());

		final double yChg = ProcessDTS.findYearlyChangeTotal(yrAgo, recent);
		final double mChg = ProcessDTS.findMonthlyChangeTotal(yrAgo, recent);
		System.out.println(yrAgo);
		System.out.println(recent);
		String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%", " ", mChg, yChg);

		System.out.println(s + "\n\n");

		try {
			ProcessDTS.dumpReport1();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompareReport(2016, Calendar.JUNE, 9);

		DtsData d1 = findData(newCalendar(2016, Calendar.JUNE, 9));
		DtsData d2 = findData(newCalendar(2015, Calendar.JUNE, 9));
		System.out.println("\n\n"+d1);
		System.out.println(d2);
		
	}

	private static Calendar newCalendar(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, 1, 2, 3);
		return cal;
	}
	
	/**
	 * net.ajaskey.market.tools.CalculateAverage
	 *
	 */
	private static void calculateAverages() {
		final int len = dtsList.size() - avgWin;
		final double winSize = (2.0 * avgWin) + 1.0;

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += dtsList.get(j).getWith().daily;
				mtot += dtsList.get(j).getWith().monthly;
				ytot += dtsList.get(j).getWith().yearly;
			}
			double a = tot / winSize;
			dtsList.get(i).getWith().dailyAvg = a;

			a = mtot / winSize;
			dtsList.get(i).getWith().monthlyAvg = a;

			a = ytot / winSize;
			dtsList.get(i).getWith().yearlyAvg = a;
		}

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += dtsList.get(j).getInd().daily;
				mtot += dtsList.get(j).getInd().monthly;
				ytot += dtsList.get(j).getInd().yearly;
			}
			double a = tot / winSize;
			dtsList.get(i).getInd().dailyAvg = a;

			a = mtot / winSize;
			dtsList.get(i).getInd().monthlyAvg = a;

			a = ytot / winSize;
			dtsList.get(i).getInd().yearlyAvg = a;
		}

		for (int i = avgWin; i < len; i++) {
			long tot = 0;
			long mtot = 0;
			long ytot = 0;
			for (int j = i - avgWin; j < (i + avgWin); j++) {
				tot += dtsList.get(j).getCorp().daily;
				mtot += dtsList.get(j).getCorp().monthly;
				ytot += dtsList.get(j).getCorp().yearly;
			}
			double a = tot / winSize;
			dtsList.get(i).getCorp().dailyAvg = a;

			a = mtot / winSize;
			dtsList.get(i).getCorp().monthlyAvg = a;

			a = ytot / winSize;
			dtsList.get(i).getCorp().yearlyAvg = a;
		}

	}

	/**
	 * 
	 * net.ajaskey.market.tools.dumpReport1
	 * 
	 * @throws FileNotFoundException
	 *
	 */
	private static void dumpReport1() throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("out/dts-out.txt")) {

			final Calendar tommorrow = Calendar.getInstance();
			tommorrow.add(Calendar.DATE, 1);

			final Calendar cal = Calendar.getInstance();
			cal.set(2015, Calendar.JANUARY, 1);

			while (cal.before(tommorrow)) {

				final int dom = cal.get(Calendar.DAY_OF_MONTH);

				/**
				 * Account for weekend and holiday
				 */
				if (dom == 6) {

					final DtsData dRecent = ProcessDTS.findYearsAgoData(cal, 0);
					final DtsData dYrAgo = ProcessDTS.findYearsAgoData(dRecent.getDate(), 1);

					// Utils.printCalendar(dNow.getDate());
					// Utils.printCalendar(cal);
					final double yChg = ProcessDTS.findYearlyChangeTotal(dYrAgo, dRecent);
					final double mChg = ProcessDTS.findMonthlyChangeTotal(dYrAgo, dRecent);
					pw.println(dYrAgo);
					pw.println(dRecent);
					String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%%n", " ", mChg, yChg);
					pw.println(s);
					cal.add(Calendar.DATE, 15);
				}

				cal.add(Calendar.DATE, 1);

			}
		}
	}

	private static void CompareReport(int year, int olderMonth, int olderDay) {
		CompareReport(year, olderMonth, olderDay, year, olderMonth, olderDay);
	}

	private static void CompareReport(int olderYr, int olderMonth, int olderDay, int recentYr, int recentMonth,
	    int recentDay) {
		Calendar older = Calendar.getInstance();
		older.set(olderYr, olderMonth, olderDay, 1, 1, 1);
		final DtsData dOlder = ProcessDTS.findYearsAgoData(older, 1);

		Calendar recent = Calendar.getInstance();
		recent.set(recentYr, recentMonth, recentDay, 1, 1, 1);
		final DtsData dRecent = ProcessDTS.findYearsAgoData(recent, 0);

		final double yChg = ProcessDTS.findYearlyChangeTotal(dOlder, dRecent);
		final double mChg = ProcessDTS.findMonthlyChangeTotal(dOlder, dRecent);

		System.out.println(dOlder);
		System.out.println(dRecent);
		String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%%n", " ", mChg, yChg);
		System.out.println(s);

	}

	/**
	 *
	 * net.ajaskey.market.tools.findDate
	 *
	 * @param cal
	 * @return
	 */
	private static DtsData findYearAgoData(Calendar cal) {
		return ProcessDTS.findYearsAgoData(cal, 1);
	}

	private static double findYearlyChangeCorporate(DtsData older, DtsData newer) {
		final double chg = (newer.getCorp().yearlyAvg - older.getCorp().yearlyAvg) / older.getCorp().yearlyAvg;
		return chg * 100.0;
	}

	private static double findYearlyChangeIndividual(DtsData older, DtsData newer) {
		final double chg = (newer.getInd().yearlyAvg - older.getInd().yearlyAvg) / older.getInd().yearlyAvg;
		return chg * 100.0;
	}

	private static double findYearlyChangeTotal(DtsData older, DtsData newer) {
		final double newTot = newer.getWith().yearlyAvg + newer.getInd().yearlyAvg + newer.getCorp().yearlyAvg;
		final double oldTot = older.getWith().yearlyAvg + older.getInd().yearlyAvg + older.getCorp().yearlyAvg;
		final double chg = (newTot - oldTot) / oldTot;
		return chg * 100.0;
	}

	private static double findYearlyChangeWithheld(DtsData older, DtsData newer) {
		final double chg = (newer.getWith().yearlyAvg - older.getWith().yearlyAvg) / older.getWith().yearlyAvg;
		return chg * 100.0;
	}
	
	private static DtsData findData(Calendar cal) {
		if (cal != null) {
			for (final DtsData d : dtsList) {
				if (d.getDate().equals(cal)) {
					return d;
				} else if (d.getDate().after(cal)) {
					return d;
				}
			}
		}
		return null;
	}
	

	/**
	 *
	 * net.ajaskey.market.tools.findYearsAgoData
	 *
	 * @param cal
	 * @param lookBackYears
	 * @return
	 */
	private static DtsData findYearsAgoData(Calendar cal, int lookBackYears) {
		if (cal != null) {
			final int previousDoy = cal.get(Calendar.DAY_OF_YEAR);
			final int previousYr = cal.get(Calendar.YEAR) - lookBackYears;
			for (final DtsData d : dtsList) {
				final int doy = d.getDate().get(Calendar.DAY_OF_YEAR);
				final int yr = d.getDate().get(Calendar.YEAR);
				if (yr == previousYr) {
					if (previousDoy <= doy) {
						return d;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.findMonthlyChangeTotal
	 *
	 * @param older
	 * @param newer
	 * @return
	 */
	private static double findMonthlyChangeTotal(DtsData older, DtsData newer) {
		final double newTot = newer.getWith().monthlyAvg + newer.getInd().monthlyAvg + newer.getCorp().monthlyAvg;
		final double oldTot = older.getWith().monthlyAvg + older.getInd().monthlyAvg + older.getCorp().monthlyAvg;
		final double chg = (newTot - oldTot) / oldTot;
		return chg * 100.0;
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
					dtsList.add(d);

				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
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
