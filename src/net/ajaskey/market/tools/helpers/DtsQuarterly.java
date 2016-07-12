
package net.ajaskey.market.tools.helpers;

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
public class DtsQuarterly {

	final static private String	NL				= System.getProperty("line.separator");

	public DtsData							q1				= null;
	public DtsData							q2				= null;
	public DtsData							q3				= null;
	public DtsData							q4				= null;
	public boolean							complete	= false;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsQuarterly() {
		complete = false;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsQuarterly(int year) {
		set(year);
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.set
	 *
	 * @param year
	 * @return
	 */
	public DtsQuarterly set(int year) {
		DtsQuarterly dq = new DtsQuarterly();

		DtsData jan = DtsData.findLastReportOfMonth(Calendar.JANUARY, year);
		DtsData feb = DtsData.findLastReportOfMonth(Calendar.FEBRUARY, year);
		DtsData mar = DtsData.findLastReportOfMonth(Calendar.MARCH, year);
		DtsData apr = DtsData.findLastReportOfMonth(Calendar.APRIL, year);
		DtsData may = DtsData.findLastReportOfMonth(Calendar.MAY, year);
		DtsData jun = DtsData.findLastReportOfMonth(Calendar.JUNE, year);
		DtsData jul = DtsData.findLastReportOfMonth(Calendar.JULY, year);
		DtsData aug = DtsData.findLastReportOfMonth(Calendar.AUGUST, year);
		DtsData sep = DtsData.findLastReportOfMonth(Calendar.SEPTEMBER, year);
		DtsData oct = DtsData.findLastReportOfMonth(Calendar.OCTOBER, year);
		DtsData nov = DtsData.findLastReportOfMonth(Calendar.NOVEMBER, year);
		DtsData dec = DtsData.findLastReportOfMonth(Calendar.DECEMBER, year);

		// System.out.println(jan);
		// System.out.println(feb);
		// System.out.println(mar);

		if ((jan != null) && (feb != null) && (mar != null)) {
			q1 = combineQuarterly(jan, feb, mar);
		}

		// System.out.println("\n" + q1);

		if ((apr != null) && (may != null) && (jun != null)) {
			q2 = combineQuarterly(apr, may, jun);
		}

		if ((jul != null) && (aug != null) && (sep != null)) {
			q3 = combineQuarterly(jul, aug, sep);
		}

		if ((oct != null) && (nov != null) && (dec != null)) {
			q4 = combineQuarterly(oct, nov, dec);
		}

		return dq;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.combineQuarterly
	 *
	 * @param d1
	 * @param d2
	 * @param d3
	 * @return
	 */
	private DtsData combineQuarterly(DtsData d1, DtsData d2, DtsData d3) {
		DtsData dc = new DtsData(d3.getDate());
		dc.getCorp().monthly = d1.getCorp().monthly + d2.getCorp().monthly + d3.getCorp().monthly;
		dc.getInd().monthly = d2.getInd().monthly + d2.getInd().monthly + d3.getInd().monthly;
		dc.getWith().monthly = d3.getWith().monthly + d2.getWith().monthly + d3.getWith().monthly;

		return dc;
	}

	final private String	fmtStr	= "\t%s\t%9d\t%9d\t%10.2f%n";
	final private String	fmtDate	= "%s\t\t%s\t%s%n";

	public double getChg(long y1, long y2) {
		double chg = (double) (y2 - y1) / (double) y1;
		return chg;
	}

	private String qToString(String str, DtsData d1, DtsData d2) {
		String ret = "";
		double chg = 0;
		if ((d1 != null) && (d2 != null)) {
			ret += String.format(fmtDate, str, Utils.getString(d1.getDate()), Utils.getString(d2.getDate()));
			chg = getChg(d1.getWith().monthly, d2.getWith().monthly);
			ret += String.format(fmtStr, "Withheld", d1.getWith().monthly, d2.getWith().monthly, chg);
			chg = getChg(d1.getInd().monthly, d2.getInd().monthly);
			ret += String.format(fmtStr, "Individual", d1.getInd().monthly, d2.getInd().monthly, chg);
			chg = getChg(d1.getCorp().monthly, d2.getCorp().monthly);
			ret += String.format(fmtStr, "Corporate", d1.getCorp().monthly, d2.getCorp().monthly, chg);
			long tot1 = d1.getWith().monthly + d1.getInd().monthly + d1.getCorp().monthly;
			long tot2 = d2.getWith().monthly + d2.getInd().monthly + d2.getCorp().monthly;
			chg = getChg(tot1, tot2);
			ret += String.format(fmtStr, "Total", tot1, tot2, chg);
		}
		return ret;
	}

	public String toCombinedString(DtsQuarterly y2) {
		String ret = "";
		if (y2 != null) {
			ret += qToString("Q1", q1, y2.q1);
		}
		if (y2 != null) {
			ret += qToString("Q2", q2, y2.q2);

		}
		if (y2 != null) {
			ret += qToString("Q3", q3, y2.q3);
		}
		if (y2 != null) {
			ret += qToString("Q4", q4, y2.q4);
		}
		return ret;
	}

	@Override
	public String toString() {
		String ret = "";
		if (q1 != null) {
			ret += "Q1 : " + DtsData.formatDate(q1.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", q1.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", q1.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", q1.getCorp().monthly);
			long tot = q1.getWith().monthly + q1.getInd().monthly + q1.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (q2 != null) {
			ret += "Q2 : " + DtsData.formatDate(q2.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", q2.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", q2.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", q2.getCorp().monthly);
			long tot = q2.getWith().monthly + q2.getInd().monthly + q2.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (q3 != null) {
			ret += "Q3 : " + DtsData.formatDate(q3.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", q3.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", q3.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", q3.getCorp().monthly);
			long tot = q3.getWith().monthly + q3.getInd().monthly + q3.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (q4 != null) {
			ret += "Q4 : " + DtsData.formatDate(q4.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", q4.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", q4.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", q4.getCorp().monthly);
			long tot = q4.getWith().monthly + q4.getInd().monthly + q4.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		return ret;
	}

}
