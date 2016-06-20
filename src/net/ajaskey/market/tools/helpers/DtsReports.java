
package net.ajaskey.market.tools.helpers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import net.ajaskey.market.ta.Utils;

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

	/**
	 *
	 * net.ajaskey.market.tools.helpers.CompareReport
	 *
	 * @param year
	 * @param olderMonth
	 * @param olderDay
	 */
	public static void CompareReport(int year, int olderMonth, int olderDay) {
		DtsReports.CompareReport(year, olderMonth, olderDay, year, olderMonth, olderDay);
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.CompareReport
	 *
	 * @param olderYr
	 * @param olderMonth
	 * @param olderDay
	 * @param recentYr
	 * @param recentMonth
	 * @param recentDay
	 */
	public static void CompareReport(int olderYr, int olderMonth, int olderDay, int recentYr, int recentMonth,
	    int recentDay) {
		final Calendar older = Calendar.getInstance();
		older.set(olderYr, olderMonth, olderDay, 1, 1, 1);
		final DtsData dOlder = DtsData.findYearsAgoData(older, 1);

		final Calendar recent = Calendar.getInstance();
		recent.set(recentYr, recentMonth, recentDay, 1, 1, 1);
		final DtsData dRecent = DtsData.findYearsAgoData(recent, 0);

		final double yChg = DtsData.findYearlyChangeTotal(dOlder, dRecent);
		final double mChg = DtsData.findMonthlyChangeTotal(dOlder, dRecent);

		System.out.println(dOlder);
		System.out.println(dRecent);
		String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%%n", " ", mChg, yChg);
		s += DtsReports.dtsToDate(olderDay, olderMonth, olderYr - 1) + NL;
		s += DtsReports.dtsToDate(recentDay, recentMonth, recentYr);
		System.out.println(s);
	}

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
		String str = "DTS as of ==> " + Utils.stringCalendar(cal) + NL;
		final int dmonth = DtsData.getDataDaysInMonth(day, month, year);
		final int dyear = DtsData.getDataDaysInYear(day, month, year);
		str += TAB + "Reports in " + DtsReports.findName(mNames, month) + " : " + dmonth + NL;
		str += TAB + "Reports in " + year + " : " + dyear;
		return str;
	}

	/**
	 *
	 * net.ajaskey.market.tools.dumpReport1
	 *
	 * @throws FileNotFoundException
	 *
	 */
	public static void dumpReport1() throws FileNotFoundException {

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

					final DtsData dRecent = DtsData.findYearsAgoData(cal, 0);
					final DtsData dYrAgo = DtsData.findYearsAgoData(dRecent.getDate(), 1);

					// Utils.printCalendar(dNow.getDate());
					// Utils.printCalendar(cal);
					final double yChg = DtsData.findYearlyChangeTotal(dYrAgo, dRecent);
					final double mChg = DtsData.findMonthlyChangeTotal(dYrAgo, dRecent);
					pw.println(dYrAgo);
					pw.println(dRecent);
					final String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%%n", " ", mChg, yChg);
					pw.println(s);
					cal.add(Calendar.DATE, 15);
				}

				cal.add(Calendar.DATE, 1);

			}
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

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.genDiffReport
	 *
	 * @param dOlder
	 * @param dRecent
	 * @return
	 */
	public static String genDiffReport(DtsData dOlder, DtsData dRecent) {
		
		if ( (dOlder == null) || (dRecent == null) )
			return "Invalid data!";
		
		String ret = dOlder.toString() + NL + dRecent.toString() + NL;

		final double newMon = dRecent.getWith().monthlyAvg + dRecent.getInd().monthlyAvg + dRecent.getCorp().monthlyAvg;
		final double oldMon = dOlder.getWith().monthlyAvg + dOlder.getInd().monthlyAvg + dOlder.getCorp().monthlyAvg;
		final double chgMon = ((newMon - oldMon) / oldMon) * 100.0;

		final double newTot = dRecent.getWith().yearlyAvg + dRecent.getInd().yearlyAvg + dRecent.getCorp().yearlyAvg;
		final double oldTot = dOlder.getWith().yearlyAvg + dOlder.getInd().yearlyAvg + dOlder.getCorp().yearlyAvg;
		final double chgTot = ((newTot - oldTot) / oldTot) * 100.0;

		final String s = String.format("\tChange     ==>%69sMonthlyAvg:%11.2f%%  YTDAvg:%11.2f%%%n", " ", chgMon, chgTot);

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

}
