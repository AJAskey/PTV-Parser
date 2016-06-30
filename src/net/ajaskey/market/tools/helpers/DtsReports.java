
package net.ajaskey.market.tools.helpers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
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
public class DtsReports {

	private static boolean							initialized	= false;

	static private Map<String, Integer>	mNames			= null;
	static private Map<String, Integer>	mDays				= null;
	final static private Locale					locale			= Locale.getDefault();
	final static private String					NL					= System.getProperty("line.separator");
	final static private String					TAB					= "\t";
	final static private String					COMMA				= ",";
	final static private String					COMMA2			= ",,";

	/**
	 *
	 * net.ajaskey.market.tools.helpers.dtsToDate
	 *
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static String dtsToDate(int day, int month, int year) {
		DtsReports.init();
		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, 0, 0);
		String str = "DTS as of ==> " + Utils.stringDate2(cal) + NL;
		final int dmonth = DtsData.getDataDaysInMonth(day, month, year);
		final int dyear = DtsData.getDataDaysInYear(day, month, year);
		str += TAB + "Reports in " + DtsReports.findName(mNames, month) + " : " + dmonth + NL;
		str += TAB + "Reports in " + year + " : " + dyear;
		return str;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.dumpCompareCorporateMonths
	 *
	 * @param yearRecent
	 * @param yearPast
	 * @param month
	 */
	public static void dumpCompareCorporateMonths(int yearRecent, int yearPast, int month) {
		DtsReports.init();

		int lastDay = 0;
		final String monStr = DtsReports.findName(mNames, month);
		try (PrintWriter pw = new PrintWriter("out/dts-corporate-" + monStr + ".txt")) {
			pw.println("Corporate data =>" + NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += NL + DtsData.formatDate(dRecent.getDate()) + NL;
						pw.println(str + DtsReports.genTallyDiffReport(dPast.getCorp(), dRecent.getCorp()));
						lastDay = cDay;
					}
				}
			}

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dumpCompareIndividualMonths(int yearRecent, int yearPast, int month) {
		DtsReports.init();

		int lastDay = 0;
		final String monStr = DtsReports.findName(mNames, month);
		try (PrintWriter pw = new PrintWriter("out/dts-individual-" + monStr + ".txt")) {
			pw.println("Individual data =>" + NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += NL + DtsData.formatDate(dRecent.getDate()) + NL;
						pw.println(str + DtsReports.genTallyDiffReport(dPast.getInd(), dRecent.getInd()));
						lastDay = cDay;
					}
				}
			}

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.dumpCompareMonths
	 *
	 * @param yearRecent
	 * @param yearPast
	 * @param month
	 */
	public static void dumpCompareMonths(int yearRecent, int yearPast, int month) {
		DtsReports.init();

		DtsReports.dumpCompareWithheldMonths(yearRecent, yearPast, month);
		DtsReports.dumpCompareIndividualMonths(yearRecent, yearPast, month);
		DtsReports.dumpCompareCorporateMonths(yearRecent, yearPast, month);

		int lastDay = 0;
		final String monStr = DtsReports.findName(mNames, month);
		try (PrintWriter pw = new PrintWriter("out/dts-combined-" + monStr + ".txt")) {
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						pw.println(DtsReports.genDiffReport(dPast, dRecent));
						pw.println(NL);
						lastDay = cDay;
					}
				}

			}

			// Last Day of Month
			pw.println(NL + NL + "Last day of month comparison.");
			final DtsData dRecent = DtsData.findLastOfMonthData(month, 2016);
			final DtsData dPast = DtsData.findLastOfMonthData(month, 2015);
			pw.println(DtsReports.genDiffReport(dPast, dRecent));

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dumpCompareWithheldMonths(int yearRecent, int yearPast, int month) {
		DtsReports.init();

		int lastDay = 0;
		final String monStr = DtsReports.findName(mNames, month);
		try (PrintWriter pw = new PrintWriter("out/dts-withheld-" + monStr + ".txt")) {
			pw.println("Withheld data =>" + NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += NL + DtsData.formatDate(dRecent.getDate()) + NL;
						pw.println(str + DtsReports.genTallyDiffReport(dPast.getWith(), dRecent.getWith()));
						lastDay = cDay;
					}
				}
			}

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public static String genCsvData(DtsData d) {
		String ret = Utils.stringDate(d.getDate());
		ret += COMMA2 + d.getWith().monthly + COMMA2 + d.getWith().yearly;
		ret += COMMA2 + d.getInd().monthly + COMMA2 + d.getInd().yearly;
		ret += COMMA2 + d.getCorp().monthly + COMMA2 + d.getCorp().yearly;
		final long tot = d.getWith().yearly + d.getInd().yearly + d.getCorp().yearly;
		ret += COMMA2 + tot;

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.genDiffReport
	 *
	 * @param dOlder
	 * @param dRecent
	 * @return
	 */
	public static String genDiffReport(DtsData dOlder, DtsData dRecent) {

		if ((dOlder == null) || (dRecent == null)) {
			return "Invalid data!";
		}

		// Utils.printCalendar(dOlder.getDate());
		// Utils.printCalendar(dRecent.getDate());

		String ret = dOlder.toString() + NL + dRecent.toString() + NL;

		final double newMon = dRecent.getWith().monthly + dRecent.getInd().monthly + dRecent.getCorp().monthly;
		final double oldMon = dOlder.getWith().monthly + dOlder.getInd().monthly + dOlder.getCorp().monthly;
		final double chgMon = ((newMon - oldMon) / oldMon) * 100.0;

		// System.out.println(newMon+TAB+oldMon+TAB+chgMon);

		final double newTot = dRecent.getWith().yearly + dRecent.getInd().yearly + dRecent.getCorp().yearly;
		final double oldTot = dOlder.getWith().yearly + dOlder.getInd().yearly + dOlder.getCorp().yearly;
		final double chgTot = ((newTot - oldTot) / oldTot) * 100.0;

		final String s = String.format("\tChange     ==>%18sMTD:%9.2f%%   YTD:%10.2f%%%n", " ", chgMon, chgTot);

		ret += s;

		return ret;
	}

	public static String genLastDataDayReport() {
		String ret = "Last DTS report ==>" + NL;

		final DtsData dLast = DtsData.dtsList.get(DtsData.dtsList.size() - 1);
		final Calendar cal = Calendar.getInstance();
		cal.set(dLast.getDate().get(Calendar.YEAR), dLast.getDate().get(Calendar.MONTH),
		    dLast.getDate().get(Calendar.DATE));
		cal.add(Calendar.YEAR, -1);
		final DtsData dLastYr = DtsData.findData(cal);
		ret += DtsReports.genDiffReport(dLastYr, dLast);

		return ret;
	}

	public static String genTallyDiffReport(DtsDataTally dOlder, DtsDataTally dRecent) {

		if ((dOlder == null) || (dRecent == null)) {
			return "Invalid data!";
		}

		String ret = dOlder.toString() + NL + dRecent.toString() + NL;

		final double chgMon = ((double) (dRecent.monthly - dOlder.monthly) / (double) dOlder.monthly) * 100.0;
		final double chgYr = ((double) (dRecent.yearly - dOlder.yearly) / (double) dOlder.yearly) * 100.0;

		final String s = String.format("Change ==>%7sMTD:%9.2f%%   YTD:%10.2f%%%n", " ", chgMon, chgYr);

		ret += s;

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.init
	 *
	 */
	private static void init() {

		if (!initialized) {
			final Calendar baseCal = Calendar.getInstance();
			mNames = baseCal.getDisplayNames(Calendar.MONTH, Calendar.LONG, locale);
			mDays = baseCal.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
			initialized = true;
		}
	}

	public static void writeEomCsv(Calendar startDate) {

		try (PrintWriter pw = new PrintWriter("out/dts.csv")) {

			pw.println(",,Withheld,,,,Individual,,,,Corporate,,,,Total");
			pw.println("Date,,EOM,,YTD,,EOM,,YTD,,EOM,,YTD,,YTD");

			DtsData d = DtsData.findLastOfMonthData(startDate.get(Calendar.MONTH), startDate.get(Calendar.YEAR));

			while (d != null) {
				pw.println(DtsReports.genCsvData(d));
				final Calendar cal = Calendar.getInstance();
				cal.set(d.getDate().get(Calendar.YEAR), d.getDate().get(Calendar.MONTH), d.getDate().get(Calendar.DATE));
				cal.add(Calendar.MONTH, 1);
				d = DtsData.findLastOfMonthData(cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));

			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
