
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

	final private String				fmtStr		= "\t%10s\t%9d\t%9d\t%10.1f%%%n";

	final private String				fmtDate		= "%s\t\t%s\t%s%n";

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsQuarterly() {
		this.complete = false;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsQuarterly(int year) {
		this.set(year);
	}

	public double getChg(long y1, long y2) {
		final double chg = (double) (y2 - y1) / (double) y1;
		return chg;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.set
	 *
	 * @param year
	 * @return
	 */
	public DtsQuarterly set(int year) {
		final DtsQuarterly dq = new DtsQuarterly();

		final DtsData jan = DtsData.findLastReportOfMonth(Calendar.JANUARY, year);
		final DtsData feb = DtsData.findLastReportOfMonth(Calendar.FEBRUARY, year);
		final DtsData mar = DtsData.findLastReportOfMonth(Calendar.MARCH, year);
		final DtsData apr = DtsData.findLastReportOfMonth(Calendar.APRIL, year);
		final DtsData may = DtsData.findLastReportOfMonth(Calendar.MAY, year);
		final DtsData jun = DtsData.findLastReportOfMonth(Calendar.JUNE, year);
		final DtsData jul = DtsData.findLastReportOfMonth(Calendar.JULY, year);
		final DtsData aug = DtsData.findLastReportOfMonth(Calendar.AUGUST, year);
		final DtsData sep = DtsData.findLastReportOfMonth(Calendar.SEPTEMBER, year);
		final DtsData oct = DtsData.findLastReportOfMonth(Calendar.OCTOBER, year);
		final DtsData nov = DtsData.findLastReportOfMonth(Calendar.NOVEMBER, year);
		final DtsData dec = DtsData.findLastReportOfMonth(Calendar.DECEMBER, year);

		// System.out.println(jan);
		// System.out.println(feb);
		// System.out.println(mar);

		if ((jan != null) && (feb != null) && (mar != null)) {
			this.q1 = this.combineQuarterly(jan, feb, mar);
		}

		// System.out.println("\n" + q1);

		if ((apr != null) && (may != null) && (jun != null)) {
			this.q2 = this.combineQuarterly(apr, may, jun);
		}

		if ((jul != null) && (aug != null) && (sep != null)) {
			this.q3 = this.combineQuarterly(jul, aug, sep);
		}

		if ((oct != null) && (nov != null) && (dec != null)) {
			this.q4 = this.combineQuarterly(oct, nov, dec);
		}

		return dq;
	}

	public String toCombinedString(DtsQuarterly y2) {
		String ret = "";
		if (y2 != null) {
			ret += this.qToString("Q1", this.q1, y2.q1);
		}
		if (y2 != null) {
			ret += this.qToString("Q2", this.q2, y2.q2);

		}
		if (y2 != null) {
			ret += this.qToString("Q3", this.q3, y2.q3);
		}
		if (y2 != null) {
			ret += this.qToString("Q4", this.q4, y2.q4);
		}
		return ret;
	}

	@Override
	public String toString() {
		String ret = "";
		if (this.q1 != null) {
			ret += "Q1 : " + DtsData.formatDate(this.q1.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", this.q1.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", this.q1.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", this.q1.getCorp().monthly);
			final long tot = this.q1.getWith().monthly + this.q1.getInd().monthly + this.q1.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (this.q2 != null) {
			ret += "Q2 : " + DtsData.formatDate(this.q2.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", this.q2.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", this.q2.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", this.q2.getCorp().monthly);
			final long tot = this.q2.getWith().monthly + this.q2.getInd().monthly + this.q2.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (this.q3 != null) {
			ret += "Q3 : " + DtsData.formatDate(this.q3.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", this.q3.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", this.q3.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", this.q3.getCorp().monthly);
			final long tot = this.q3.getWith().monthly + this.q3.getInd().monthly + this.q3.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		if (this.q4 != null) {
			ret += "Q4 : " + DtsData.formatDate(this.q4.getDate()) + NL;
			ret += String.format("\tWithheld   : %9d%n", this.q4.getWith().monthly);
			ret += String.format("\tIndividual : %9d%n", this.q4.getInd().monthly);
			ret += String.format("\tCorporate  : %9d%n", this.q4.getCorp().monthly);
			final long tot = this.q4.getWith().monthly + this.q4.getInd().monthly + this.q4.getCorp().monthly;
			ret += String.format("\tTotal      : %9d%n", tot);
		}
		return ret;
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
		final DtsData dc = new DtsData(d3.getDate());
		dc.getCorp().monthly = d1.getCorp().monthly + d2.getCorp().monthly + d3.getCorp().monthly;
		dc.getInd().monthly = d2.getInd().monthly + d2.getInd().monthly + d3.getInd().monthly;
		dc.getWith().monthly = d3.getWith().monthly + d2.getWith().monthly + d3.getWith().monthly;
		dc.getUnEmp().monthly = d3.getUnEmp().monthly + d2.getUnEmp().monthly + d3.getUnEmp().monthly;

		return dc;
	}

	private String qToString(String str, DtsData d1, DtsData d2) {
		String ret = "";
		double chg = 0;
		if ((d1 != null) && (d2 != null)) {
			ret += String.format(this.fmtDate, str, Utils.getString(d1.getDate()), Utils.getString(d2.getDate()));

			chg = this.getChg(d1.getWith().monthly, d2.getWith().monthly) * 100.0;
			ret += String.format(this.fmtStr, "Withheld", d1.getWith().monthly, d2.getWith().monthly, chg);

			chg = this.getChg(d1.getInd().monthly, d2.getInd().monthly) * 100.0;
			ret += String.format(this.fmtStr, "Individual", d1.getInd().monthly, d2.getInd().monthly, chg);

			chg = this.getChg(d1.getCorp().monthly, d2.getCorp().monthly) * 100.0;
			ret += String.format(this.fmtStr, "Corporate", d1.getCorp().monthly, d2.getCorp().monthly, chg);

			final long tot1 = d1.getWith().monthly + d1.getInd().monthly + d1.getCorp().monthly;
			final long tot2 = d2.getWith().monthly + d2.getInd().monthly + d2.getCorp().monthly;
			chg = this.getChg(tot1, tot2) * 100.0;
			ret += String.format(this.fmtStr, "Total", tot1, tot2, chg);
		}
		return ret;
	}

}
