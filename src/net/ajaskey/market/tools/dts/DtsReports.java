
package net.ajaskey.market.tools.dts;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.methods.EmaContinuousSeries;
import net.ajaskey.market.tools.optuma.OptumaCommon;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
 *         MERCHANUtils.TABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE. </p>
 *
 */
public class DtsReports {

	public static enum DTS_TYPE {
		CORPORATE, INDIVIDUAL, WITHHELD, COMBINED
	}

	public static enum REPORT_RANGE {
		DAY, MONTH, YEAR
	}

	final static private String COMMA2 = ",,";

	final static private String DtsPath = OptumaCommon.optumaPath + "DTS/";

	/**
	 *
	 * net.ajaskey.market.tools.helpers.dtsToDate
	 *
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static String dtsToDate(final int day, final int month, final int year) {

		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, 0, 0);
		String str = "DTS as of ==> " + Utils.stringDate2(cal) + Utils.NL;
		final int dmonth = DtsData.getNumReportsInMonth(cal);
		final int dyear = DtsData.getNumReportsInYear(cal);
		str += Utils.TAB + "Reports in " + Utils.getMonthName(cal) + " : " + dmonth + Utils.NL;
		str += Utils.TAB + "Reports in " + year + " : " + dyear;
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
	public static void dumpCompareCorporateMonths(final int yearRecent, final int yearPast, final int month) {

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
		try (PrintWriter pw = new PrintWriter("out/dts-corporate-" + monStr + ".txt")) {
			pw.println("Corporate data =>" + Utils.NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += Utils.NL + DtsData.formatDate(dRecent.getDate()) + Utils.NL;
						pw.println(str + DtsReports.genTallyDiffReport(dPast.getCorp(), dRecent.getCorp()));
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
	 * net.ajaskey.market.tools.helpers.dumpCompareIndividualMonths
	 *
	 * @param yearRecent
	 * @param yearPast
	 * @param month
	 */
	public static void dumpCompareIndividualMonths(final int yearRecent, final int yearPast, final int month) {

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
		try (PrintWriter pw = new PrintWriter("out/dts-individual-" + monStr + ".txt")) {
			pw.println("Individual data =>" + Utils.NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += Utils.NL + DtsData.formatDate(dRecent.getDate()) + Utils.NL;
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
	public static void dumpCompareMonths(final int yearRecent, final int yearPast, final int month) {

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
						pw.println(Utils.NL);
						lastDay = cDay;
					}
				}

			}

			// Last Day of Month
			pw.println(Utils.NL + Utils.NL + "Last day of month comparison.");
			final DtsData dRecent = DtsData.findLastOfMonthData(month, yearRecent);
			final DtsData dPast = DtsData.findLastOfMonthData(month, yearRecent - 1);
			pw.println(DtsReports.genDiffReport(dPast, dRecent));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void dumpCompareWithheldMonths(final int yearRecent, final int yearPast, final int month) {

		int lastDay = 0;
		final String monStr = Utils.getMonthName(month);
		try (PrintWriter pw = new PrintWriter("out/dts-withheld-" + monStr + ".txt")) {
			pw.println("Withheld data =>" + Utils.NL);
			for (int i = 0; i < 23; i++) {
				final DtsData dRecent = DtsData.findData(i, month, yearRecent);
				final DtsData dPast = DtsData.findData(i, month, yearPast);
				if ((dRecent != null) && (dPast != null)) {
					final int cDay = dRecent.getDate().get(Calendar.DAY_OF_MONTH);
					if (cDay > lastDay) {
						String str = DtsData.formatDate(dPast.getDate());
						str += Utils.NL + DtsData.formatDate(dRecent.getDate()) + Utils.NL;
						pw.println(str + DtsReports.genTallyDiffReport(dPast.getWith(), dRecent.getWith()));
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
	 * net.ajaskey.market.tools.helpers.dumpRaw
	 *
	 * @param fname
	 * @param cal
	 * @throws FileNotFoundException
	 */
	public static void dumpRaw(final String fname, final Calendar cal) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("out\\" + fname + "_raw.txt")) {
			for (final DtsData d : DtsData.dtsList) {
				if ((Utils.sameDate(d.getDate(), cal)) || (d.getDate().after(cal))) {
					pw.println(d);
				}
			}
		}
	}

	public static String genCsvData(final DtsData d) {

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
	public static String genDiffReport(final DtsData dOlder, final DtsData dRecent) {

		if ((dOlder == null) || (dRecent == null)) {
			return "Invalid data!";
		}

		// Utils.printCalendar(dOlder.getDate());
		// Utils.printCalendar(dRecent.getDate());

		String ret = dOlder.toString() + Utils.NL + dRecent.toString() + Utils.NL;

		final double newMon = dRecent.getWith().monthly + dRecent.getInd().monthly + dRecent.getCorp().monthly;
		final double oldMon = dOlder.getWith().monthly + dOlder.getInd().monthly + dOlder.getCorp().monthly;
		final double chgMon = ((newMon - oldMon) / oldMon) * 100.0;

		// System.out.println(newMon+Utils.TAB+oldMon+Utils.TAB+chgMon);

		final double newTot = dRecent.getWith().yearly + dRecent.getInd().yearly + dRecent.getCorp().yearly;
		final double oldTot = dOlder.getWith().yearly + dOlder.getInd().yearly + dOlder.getCorp().yearly;
		final double chgTot = ((newTot - oldTot) / oldTot) * 100.0;

		final double chgDayWith = ((double) (dRecent.getWith().daily - dOlder.getWith().daily) / (double) dOlder.getWith().daily) * 100.0;
		final double chgMonthWith = ((double) (dRecent.getWith().monthly - dOlder.getWith().monthly) / (double) dOlder.getWith().monthly)
		    * 100.0;
		final double chgYearWith = ((double) (dRecent.getWith().yearly - dOlder.getWith().yearly) / (double) dOlder.getWith().yearly) * 100.0;

		final double chgDayInd = ((double) (dRecent.getInd().daily - dOlder.getInd().daily) / (double) dOlder.getInd().daily) * 100.0;
		final double chgMonthInd = ((double) (dRecent.getInd().monthly - dOlder.getInd().monthly) / (double) dOlder.getInd().monthly) * 100.0;
		final double chgYearInd = ((double) (dRecent.getInd().yearly - dOlder.getInd().yearly) / (double) dOlder.getInd().yearly) * 100.0;

		final double chgDayCorp = ((double) (dRecent.getCorp().daily - dOlder.getCorp().daily) / (double) dOlder.getCorp().daily) * 100.0;
		final double chgMonthCorp = ((double) (dRecent.getCorp().monthly - dOlder.getCorp().monthly) / (double) dOlder.getCorp().monthly)
		    * 100.0;
		final double chgYearCorp = ((double) (dRecent.getCorp().yearly - dOlder.getCorp().yearly) / (double) dOlder.getCorp().yearly) * 100.0;

		String s = String.format("\tChange     ==>%18sMTD:%9.2f%%   YTD:%10.2f%%%n", " ", chgMon, chgTot);

		s += String.format("\t  Withheld   =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayWith, chgMonthWith, chgYearWith);
		s += String.format("\t  Individual =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayInd, chgMonthInd, chgYearInd);
		s += String.format("\t  Corporate  =>%12.2f%%     %12.2f%%     %12.2f%% %n", chgDayCorp, chgMonthCorp, chgYearCorp);

		ret += s;

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.geUtils.NLastDataDayReport
	 *
	 * @return
	 */
	public static String genLastReport(final REPORT_RANGE rr) {

		String ret = "Most recent DTS report : " + rr + " ==>" + Utils.NL;

		final DtsData dLast = DtsData.dtsList.get(DtsData.dtsList.size() - 1);

		int knt = 0;

		DtsData dPrevious = null;

		final int yr = dLast.getDate().get(Calendar.YEAR) - 1;

		switch (rr) {
			case DAY:
				final Calendar cal = Utils.makeCopy(dLast.getDate());
				cal.add(Calendar.YEAR, -1);
				dPrevious = DtsData.findData(cal);
				break;
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
	public static String genTallyDiffReport(final DtsDataTally dOlder, final DtsDataTally dRecent) {

		if ((dOlder == null) || (dRecent == null)) {
			return "Invalid data!";
		}

		String ret = dOlder.toString() + Utils.NL + dRecent.toString() + Utils.NL;

		final double chgMon = ((double) (dRecent.monthly - dOlder.monthly) / (double) dOlder.monthly) * 100.0;
		final double chgYr = ((double) (dRecent.yearly - dOlder.yearly) / (double) dOlder.yearly) * 100.0;

		final String s = String.format("Change ==>%7sMTD:%9.2f%%   YTD:%10.2f%%%n", " ", chgMon, chgYr);

		ret += s;

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.helpers.getChg
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	private static double getChg(final int dVal, final int pVal) {

		double chg = 0.0;
		if (pVal > 0.0) {
			chg = (double) (dVal - pVal) / (double) pVal;
		}
		return chg;
	}

	private static int getIndex(final List<Calendar> date, final int idx) {

		final Calendar cal = Utils.buildCalendar(date.get(idx).get(Calendar.YEAR), date.get(idx).get(Calendar.MONTH),
		    date.get(idx).get(Calendar.DATE));
		cal.add(Calendar.YEAR, 1);

		int index = -1;
		for (final Calendar c : date) {
			index++;
			if (Utils.sameDate(cal, c)) {
				break;
			}
			else if (c.after(cal)) {
				break;
			}
		}
		return index;
	}

	private static long getTotal(final long[] vals) {

		long tot = 0;
		for (final long i : vals) {
			tot += i;
		}
		return tot;
	}

	/**
	 * net.ajaskey.market.tools.helpers.printDailyCompare
	 *
	 * @param string
	 * @throws FileNotFoundException
	 */
	private static void printDailyCompare(final String fname) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		final EmaContinuousSeries wEma = new EmaContinuousSeries(7);
		final EmaContinuousSeries iEma = new EmaContinuousSeries(7);
		final EmaContinuousSeries cEma = new EmaContinuousSeries(7);
		final EmaContinuousSeries tEma = new EmaContinuousSeries(7);

		try (PrintWriter pw = new PrintWriter(fname)) {

			pw.println(Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + "Date" + Utils.TAB + Utils.TAB + Utils.TAB
			    + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + "Withheld" + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + "Individual"
			    + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + "Corporate" + Utils.TAB + Utils.TAB + Utils.TAB + Utils.TAB + "Total");

			final Calendar cal = Calendar.getInstance();
			final int yr = cal.get(Calendar.YEAR) - 2;
			cal.set(yr, Calendar.OCTOBER, 1);
			// Utils.printCalendar(cal);

			final Calendar tomorrow = Calendar.getInstance();
			tomorrow.add(Calendar.DATE, 1);
			// Utils.printCalendar(tomorrow);

			while (cal.before(tomorrow)) {

				final DtsData d = DtsData.findData(cal);

				if (d != null) {

					final Calendar pCal = Utils.makeCopy(cal);
					pCal.add(Calendar.YEAR, -1);
					final DtsData p = DtsData.findData(pCal);

					if (p != null) {

						final double withChg = DtsReports.getChg(d.getWith().yearly, p.getWith().yearly);
						final double indChg = DtsReports.getChg(d.getInd().yearly, p.getInd().yearly);
						final double corpChg = DtsReports.getChg(d.getCorp().yearly, p.getCorp().yearly);

						final int totD = d.getWith().yearly + d.getInd().yearly + d.getCorp().yearly;
						final int totP = p.getWith().yearly + p.getInd().yearly + p.getCorp().yearly;
						final double totChg = DtsReports.getChg(totD, totP);

						final double withEma = wEma.addValue(withChg);
						final double indEma = iEma.addValue(indChg);
						final double corpEma = cEma.addValue(corpChg);
						final double totEma = tEma.addValue(totChg);

						String d1 = p.getDatePlus();
						d1 = d1.replaceAll(" ", "\t");
						String d2 = d.getDatePlus();
						d2 = d2.replaceAll(" ", "\t");

						final String str = String.format(
						    "%s\t%s\t%10d\t%10d\t%5.2f\t%5.2f\t%10d\t%10d\t%5.2f\t%5.2f\t%10d\t%10d\t%7.4f\t%7.4f\t%10d\t%10d\t%7.4f\t%7.4f%n", d1, d2,
						    p.getWith().yearly, d.getWith().yearly, withChg, withEma, p.getInd().yearly, d.getInd().yearly, indChg, indEma,
						    p.getCorp().yearly, d.getCorp().yearly, corpChg, corpEma, totP, totD, totChg, totEma);

						pw.printf("%s", str);

						cal.set(d.getDate().get(Calendar.YEAR), d.getDate().get(Calendar.MONTH), d.getDate().get(Calendar.DATE));
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

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.printFiscalYear
	 *
	 * @param fname
	 * @param type
	 * @throws FileNotFoundException
	 */
	private static void printFiscalYear(final String fname, final DTS_TYPE type) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		try (PrintWriter pw = new PrintWriter(fname)) {
			final Calendar cal = Calendar.getInstance();
			final int yr = cal.get(Calendar.YEAR) - 2;
			cal.set(yr, Calendar.OCTOBER, 1);
			// Utils.printCalendar(cal);

			final Calendar tomorrow = Calendar.getInstance();
			tomorrow.add(Calendar.DATE, 1);
			// Utils.printCalendar(tomorrow);

			final EmaContinuousSeries ema = new EmaContinuousSeries(7);

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
						ema.addValue(chg);

						final String d1 = p.getDatePlus();
						final String d2 = d.getDatePlus();

						final String str = String.format("%s\t%s\t%10d\t%10d\t%7.4f\t%7.4f%n", d1, d2, pVal, dVal, chg, ema.getEma());

						pw.printf("%s", str);

						cal.set(d.getDate().get(Calendar.YEAR), d.getDate().get(Calendar.MONTH), d.getDate().get(Calendar.DATE));
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
	}

	/**
	 * net.ajaskey.market.tools.helpers.printQuarterly
	 *
	 * @param pw
	 * @param q2014
	 * @param q2015
	 */
	private static void printQuarterly(final PrintWriter pw, final DtsQuarterly y1, final DtsQuarterly y2) {

		pw.println(y1.toCombinedString(y2));
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeEomCsv
	 *
	 * @param startDate
	 */
	public static void writeEomCsv(final Calendar startDate) {

		new SimpleDateFormat("yyyy-MM-dd");

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
	public static void writeFiscalYear(final String fname) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		DtsReports.printDailyCompare("out\\" + fname + "_daily-compare.txt");

		DtsReports.printFiscalYear("out\\" + fname + "_tot.txt", DTS_TYPE.COMBINED);
		DtsReports.printFiscalYear("out\\" + fname + "_corp.txt", DTS_TYPE.CORPORATE);
		DtsReports.printFiscalYear("out\\" + fname + "_ind.txt", DTS_TYPE.INDIVIDUAL);
		DtsReports.printFiscalYear("out\\" + fname + "_with.txt", DTS_TYPE.WITHHELD);

	}

	public static void writeOptuma() throws FileNotFoundException {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try (PrintWriter pwWith = new PrintWriter(DtsPath + "\\dts-withheld-optuma.csv")) {
			pwWith.println("Date,Withheld");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwWith.printf("%s,%d%n", theDate, d.getWith().yearly);
			}
		}
		try (PrintWriter pwInd = new PrintWriter(DtsPath + "\\dts-individual-optuma.csv")) {
			pwInd.println("Date,Individual");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwInd.printf("%s,%d%n", theDate, d.getInd().yearly);
			}
		}
		try (PrintWriter pwCorp = new PrintWriter(DtsPath + "\\dts-corporate-optuma.csv")) {
			pwCorp.println("Date,Corporate");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwCorp.printf("%s,%d%n", theDate, d.getCorp().yearly);
			}
		}
		try (PrintWriter pwTotal = new PrintWriter(DtsPath + "\\dts-total-optuma.csv")) {
			pwTotal.println("Date,Total");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwTotal.printf("%s,%d%n", theDate, d.getWith().yearly + d.getInd().yearly + d.getCorp().yearly);
			}
		}
		try (PrintWriter pwUnemp = new PrintWriter(DtsPath + "\\dts-unemp-optuma.csv")) {
			pwUnemp.println("Date,Unemployment");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwUnemp.printf("%s,%d%n", theDate, d.getUnEmp().yearly);
			}
		}

		try (PrintWriter pwWith = new PrintWriter(DtsPath + "\\dts-withheld-daily.csv")) {
			pwWith.println("Date,Withheld");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwWith.printf("%s,%d%n", theDate, d.getWith().daily);
			}
		}
		try (PrintWriter pwInd = new PrintWriter(DtsPath + "\\dts-individual-daily.csv")) {
			pwInd.println("Date,Individual");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwInd.printf("%s,%d%n", theDate, d.getInd().daily);
			}
		}
		try (PrintWriter pwCorp = new PrintWriter(DtsPath + "\\dts-corporate-daily.csv")) {
			pwCorp.println("Date,Corporate");
			for (final DtsData d : DtsData.dtsList) {
				final String theDate = sdf.format(d.getDate().getTime());
				pwCorp.printf("%s,%d%n", theDate, d.getCorp().daily);
			}
		}
	}

	public static void writeQuarterly(final String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("out\\" + fname + ".txt")) {

			final DtsQuarterly q2013 = new DtsQuarterly(2013);
			final DtsQuarterly q2014 = new DtsQuarterly(2014);
			final DtsQuarterly q2015 = new DtsQuarterly(2015);
			final DtsQuarterly q2016 = new DtsQuarterly(2016);
			final DtsQuarterly q2017 = new DtsQuarterly(2017);

			DtsReports.printQuarterly(pw, q2013, q2014);
			DtsReports.printQuarterly(pw, q2014, q2015);
			DtsReports.printQuarterly(pw, q2015, q2016);
			DtsReports.printQuarterly(pw, q2016, q2017);

		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeCumulative
	 *
	 * @param type
	 * @throws FileNotFoundException
	 */
	public static void writeSumDaily(final DTS_TYPE type) throws FileNotFoundException {

		final int range = 250;
		final long sum[] = new long[range];
		int ptr = 0;

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String fname = DtsPath;

		if (type == DTS_TYPE.CORPORATE) {
			fname += "dts-sum-corporate.csv";
		}
		else if (type == DTS_TYPE.INDIVIDUAL) {
			fname += "dts-sum-individual.csv";
		}
		else if (type == DTS_TYPE.WITHHELD) {
			fname += "dts-sum-withheld.csv";
		}
		else {
			fname += "dts-sum-combined.csv";
		}

		try (PrintWriter pw = new PrintWriter(fname)) {

			pw.println("Date,Change");

			boolean filled = false;

			for (final DtsData dts : DtsData.dtsList) {
				if (type == DTS_TYPE.CORPORATE) {
					sum[ptr] = dts.getCorp().daily;
				}
				else if (type == DTS_TYPE.INDIVIDUAL) {
					sum[ptr] = dts.getInd().daily;
				}
				else if (type == DTS_TYPE.WITHHELD) {
					sum[ptr] = dts.getWith().daily;
				}
				else {
					sum[ptr] = dts.getCorp().daily + dts.getInd().daily + dts.getWith().daily;
				}
				ptr++;
				if (ptr > (range - 1)) {
					filled = true;
					ptr = 0;
				}
				if (filled) {
					final String theDate = sdf.format(dts.getDate().getTime());
					// System.out.printf("%s,%.2f%n", theDate, total);
					pw.printf("%s,%d%n", theDate, DtsReports.getTotal(sum));

				}
			}
		}

	}

	public static void writeUnemploymentTaxes(final String fname) throws FileNotFoundException {

		if (fname.length() < 1) {
			return;
		}

		final EmaContinuousSeries ema = new EmaContinuousSeries(7);

		try (PrintWriter pw = new PrintWriter("out\\" + fname + ".txt")) {

			pw.println("Date" + Utils.TAB + "Change" + Utils.TAB + "EMA");

			final Calendar cal = Calendar.getInstance();
			final int yr = cal.get(Calendar.YEAR) - 2;
			cal.set(yr, Calendar.OCTOBER, 1);

			final Calendar tomorrow = Calendar.getInstance();
			tomorrow.add(Calendar.DATE, 1);

			while (cal.before(tomorrow)) {

				final DtsData d = DtsData.findData(cal);

				if (d != null) {

					final Calendar pCal = Utils.makeCopy(cal);
					pCal.add(Calendar.YEAR, -1);
					final DtsData p = DtsData.findData(pCal);

					if (p != null) {

						final double chgT = DtsReports.getChg(d.getUnEmp().yearly, p.getUnEmp().yearly);
						double chg = 0;
						if (chgT > 0.0) {
							chg = Math.min(chgT, 0.25);
						}
						else if (chgT < 0.0) {
							chg = Math.max(chgT, -0.25);
						}

						final double emaVal = ema.addValue(chg);

						String d1 = p.getDatePlus();
						d1 = d1.replaceAll(" ", "\t");
						String d2 = d.getDatePlus();
						d2 = d2.replaceAll(" ", "\t");

						final String str = String.format("%s\t%s\t%5.2f\t%5.2f%n", d1, d2, chg, emaVal);

						pw.printf("%s", str);

						cal.set(d.getDate().get(Calendar.YEAR), d.getDate().get(Calendar.MONTH), d.getDate().get(Calendar.DATE));
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
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeYY
	 *
	 * @param type
	 */
	public static void writeYY(final DTS_TYPE type) {

		final List<Integer> ytd = new ArrayList<>();
		final List<Calendar> date = new ArrayList<>();
		String fname = DtsPath;

		if (type == DTS_TYPE.CORPORATE) {
			fname += "dts-yy-corporate.csv";
		}
		else if (type == DTS_TYPE.INDIVIDUAL) {
			fname += "dts-yy-individual.csv";
		}
		else if (type == DTS_TYPE.WITHHELD) {
			fname += "dts-yy-withheld.csv";
		}
		else {
			fname += "dts-yy-combined.csv";
		}

		for (final DtsData dts : DtsData.dtsList) {
			if (type == DTS_TYPE.CORPORATE) {
				ytd.add(dts.getCorp().yearly);
			}
			else if (type == DTS_TYPE.INDIVIDUAL) {
				ytd.add(dts.getInd().yearly);
			}
			else if (type == DTS_TYPE.WITHHELD) {
				ytd.add(dts.getWith().yearly);
			}
			else {
				ytd.add(dts.getCorp().yearly + dts.getInd().yearly + dts.getWith().yearly);
			}
			date.add(dts.getDate());
		}
		final Calendar cal = Utils.buildCalendar(date.get(0).get(Calendar.YEAR), date.get(0).get(Calendar.MONTH),
		    date.get(0).get(Calendar.DATE));
		cal.add(Calendar.YEAR, 1);

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try (PrintWriter pw = new PrintWriter(fname)) {

			pw.println("Date,Change");

			final int len = date.size();
			double chg = 0;
			for (int i = 0; i < len; i++) {
				final int idx = DtsReports.getIndex(date, i);

				if (i > 10) {
					// double lastChg = Math.abs(chg * 2.0);
					chg = ((double) (ytd.get(idx) - ytd.get(i)) / (double) ytd.get(i)) * 100.0;
					// if (chg > 5.0) {
					// if (Math.abs(chg) > lastChg) {
					// chg /= 10.0;
					// }
					// }
				}
				else {
					chg = ((double) (ytd.get(idx) - ytd.get(i)) / (double) ytd.get(i)) * 100.0;
				}

				final String theDate = sdf.format(date.get(idx).getTime());
				// System.out.printf("%s,%.2f%n", theDate, chg);
				pw.printf("%s,%.2f%n", theDate, chg);
				if (idx >= (len - 1)) {
					break;
				}
			}
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
