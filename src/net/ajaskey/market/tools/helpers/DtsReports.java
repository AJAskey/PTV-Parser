
package net.ajaskey.market.tools.helpers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;

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

	public static enum DTS_TYPE {
		CORPORATE, INDIVIDUAL, WITHHELD, COMBINED
	}

	public static enum REPORT_RANGE {
		MONTH, YEAR
	}

	final static private String	NL			= System.getProperty("line.separator");
	final static private String	TAB			= "\t";
	final static private String	COMMA		= ",";

	final static private String	COMMA2	= ",,";

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
		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, 0, 0);
		String str = "DTS as of ==> " + Utils.stringDate2(cal) + NL;
		final int dmonth = DtsData.getNumReportsInMonth(cal);
		final int dyear = DtsData.getNumReportsInYear(cal);
		str += TAB + "Reports in " + Utils.getMonthName(cal) + " : " + dmonth + NL;
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

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
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
			e.printStackTrace();
		}
	}

	public static void dumpCompareIndividualMonths(int yearRecent, int yearPast, int month) {

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
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

		DtsReports.dumpCompareWithheldMonths(yearRecent, yearPast, month);
		DtsReports.dumpCompareIndividualMonths(yearRecent, yearPast, month);
		DtsReports.dumpCompareCorporateMonths(yearRecent, yearPast, month);

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
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
			e.printStackTrace();
		}
	}

	public static void dumpCompareWithheldMonths(int yearRecent, int yearPast, int month) {

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
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
			e.printStackTrace();
		}
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

		final double chgDayWith = ((double) (dRecent.getWith().daily - dOlder.getWith().daily)
		    / (double) dOlder.getWith().daily) * 100.0;
		final double chgMonthWith = ((double) (dRecent.getWith().monthly - dOlder.getWith().monthly)
		    / (double) dOlder.getWith().monthly) * 100.0;
		final double chgYearWith = ((double) (dRecent.getWith().yearly - dOlder.getWith().yearly)
		    / (double) dOlder.getWith().yearly) * 100.0;

		final double chgDayInd = ((double) (dRecent.getInd().daily - dOlder.getInd().daily)
		    / (double) dOlder.getInd().daily) * 100.0;
		final double chgMonthInd = ((double) (dRecent.getInd().monthly - dOlder.getInd().monthly)
		    / (double) dOlder.getInd().monthly) * 100.0;
		final double chgYearInd = ((double) (dRecent.getInd().yearly - dOlder.getInd().yearly)
		    / (double) dOlder.getInd().yearly) * 100.0;

		final double chgDayCorp = ((double) (dRecent.getCorp().daily - dOlder.getCorp().daily)
		    / (double) dOlder.getCorp().daily) * 100.0;
		final double chgMonthCorp = ((double) (dRecent.getCorp().monthly - dOlder.getCorp().monthly)
		    / (double) dOlder.getCorp().monthly) * 100.0;
		final double chgYearCorp = ((double) (dRecent.getCorp().yearly - dOlder.getCorp().yearly)
		    / (double) dOlder.getCorp().yearly) * 100.0;

		String s = String.format("\tChange     ==>%18sMTD:%9.2f%%   YTD:%10.2f%%%n", " ", chgMon, chgTot);

		s += String.format("\t  Withheld   =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayWith, chgMonthWith, chgYearWith);
		s += String.format("\t  Individual =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayInd, chgMonthInd, chgYearInd);
		s += String.format("\t  Corporate  =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayCorp, chgMonthCorp, chgYearCorp);

		ret += s;

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.genLastDataDayReport
	 *
	 * @return
	 */
	public static String genLastReport(REPORT_RANGE rr) {

		String ret = "Most recent DTS report : " + rr + " ==>" + NL;

		final DtsData dLast = DtsData.dtsList.get(DtsData.dtsList.size() - 1);

		int knt = 0;

		DtsData dPrevious = null;

		final int yr = dLast.getDate().get(Calendar.YEAR) - 1;

		switch (rr) {
			case MONTH:
				knt = DtsData.getNumReportsInMonth(dLast.getDate());
				dPrevious = DtsData.findData(knt, dLast.getDate().get(Calendar.MONTH), yr);
				break;
			case YEAR:
				knt = DtsData.getNumReportsInYear(dLast.getDate());
				dPrevious = DtsData.findData(knt, yr);
				break;
		}

		ret += DtsReports.genDiffReport(dPrevious, dLast);

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.genTallyDiffReport
	 *
	 * @param dOlder
	 * @param dRecent
	 * @return
	 */
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
	 * net.ajaskey.market.tools.helpers.printFiscalYear
	 *
	 * @param fname
	 * @param type
	 * @throws FileNotFoundException
	 */
	private static void printFiscalYear(String fname, DTS_TYPE type) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		double ema = 0;
		double sma = 0;
		final int emaLen = 5;
		final double emaMult = 2.0 / (emaLen + 1);
		int knt = 0;

		try (PrintWriter pw = new PrintWriter(fname)) {
			final Calendar cal = Calendar.getInstance();
			final int yr = cal.get(Calendar.YEAR) - 2;
			cal.set(yr, Calendar.OCTOBER, 1);
			Utils.printCalendar(cal);

			final Calendar tomorrow = Calendar.getInstance();
			tomorrow.add(Calendar.DATE, 1);
			Utils.printCalendar(tomorrow);

			while (cal.before(tomorrow)) {

				final DtsData d = DtsData.findData(cal);

				if (d != null) {

					final Calendar pCal = Utils.makeCopy(cal);
					pCal.add(Calendar.YEAR, -1);
					final DtsData p = DtsData.findData(pCal);
					if (p != null) {
						long pVal = 0;
						long dVal = 0;

						switch (type) {
							case COMBINED:
								pVal = p.getCorp().yearly + p.getWith().yearly + p.getInd().yearly;
								dVal = d.getCorp().yearly + d.getWith().yearly + d.getInd().yearly;
								break;
							case CORPORATE:
								pVal = p.getCorp().yearly;
								dVal = d.getCorp().yearly;
								break;
							case INDIVIDUAL:
								pVal = p.getInd().yearly;
								dVal = d.getInd().yearly;
								break;
							case WITHHELD:
								pVal = p.getWith().yearly;
								dVal = d.getWith().yearly;
								break;
						}

						double chg = 0;
						if (pVal > 0.0) {
							chg = (double) (dVal - pVal) / (double) pVal;
						}

						if (knt < emaLen) {
							knt++;
							sma += chg;
						} else if (knt == emaLen) {
							knt++;
							sma += chg;
							sma /= emaLen;
							ema = sma;
						} else {
							final double pEma = ema;
							ema = ((chg - pEma) * emaMult) + pEma;
						}

						final String d1 = p.getDatePlus();
						final String d2 = d.getDatePlus();

						final DecimalFormat fmt = new DecimalFormat("#.##");
						String sEma = null;

						if (knt <= emaLen) {
							sEma = "";
						} else {
							sEma = fmt.format(ema);
						}

						final String str = String.format("%s\t%s\t%10d\t%10d\t%10.2f\t%s%n", d1, d2, pVal, dVal, chg, sEma);

						pw.printf("%s", str);

						cal.set(d.getDate().get(Calendar.YEAR), d.getDate().get(Calendar.MONTH), d.getDate().get(Calendar.DATE));
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

	/**
	 * net.ajaskey.market.tools.helpers.printQuarterly
	 *
	 * @param pw
	 * @param q2014
	 * @param q2015
	 */
	private static void printQuarterly(PrintWriter pw, DtsQuarterly y1, DtsQuarterly y2) {
		pw.println(y1.toCombinedString(y2));

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeEomCsv
	 *
	 * @param startDate
	 */
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

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeFiscalYear
	 *
	 * @param fname
	 * @throws FileNotFoundException
	 */
	public static void writeFiscalYear(String fname) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		DtsReports.printFiscalYear("out\\" + fname + "_tot.txt", DTS_TYPE.COMBINED);
		DtsReports.printFiscalYear("out\\" + fname + "_corp.txt", DTS_TYPE.CORPORATE);
		DtsReports.printFiscalYear("out\\" + fname + "_ind.txt", DTS_TYPE.INDIVIDUAL);
		DtsReports.printFiscalYear("out\\" + fname + "_with.txt", DTS_TYPE.WITHHELD);

	}

	public static void writeQuarterly(String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("out\\" + fname + ".txt")) {

			new DtsQuarterly(2013);
			new DtsQuarterly(2014);
			final DtsQuarterly q2015 = new DtsQuarterly(2015);
			final DtsQuarterly q2016 = new DtsQuarterly(2016);

			DtsReports.printQuarterly(pw, q2015, q2016);

		}
	}

}
