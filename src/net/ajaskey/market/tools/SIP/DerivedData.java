
package net.ajaskey.market.tools.SIP;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class DerivedData {

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";
	
	final private static double MAX_PE = 250.0;

	public double					qoqGrowth;
	public double					seqGrowth;
	public double					yoyGrowth;
	private QuarterlyData	qd;
	
	public static double calcPE(IncomeData id, double price) {
		double ret = MAX_PE;
		double e1 = id.eps.q1;
		if (e1 == 0.0) {
			e1 = id.eps.q2;
		}
		if (e1 > 0.0) {
			ret = price / e1;
		}
		ret = Math.min(MAX_PE, ret);
		return ret;
		
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DerivedData() {

		this.qoqGrowth = 0.0;
		this.seqGrowth = 0.0;
		this.yoyGrowth = 0.0;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calculate
	 *
	 */
	public void calculate(QuarterlyData qdata) {

		this.qd = qdata;
		this.setQoQGrowth();
		this.setSeqGrowth();
		this.setYoyGrowth();
	}

	/**
	 * net.ajaskey.market.tools.SIP.setYoYGrowth
	 *
	 */
	private void setQoQGrowth() {

		double qtr1;
		double qtr5;
		if (this.qd.q1 != 0.0) {
			qtr1 = this.qd.q1;
			qtr5 = this.qd.q5;
		} else {
			qtr1 = this.qd.q2;
			qtr5 = this.qd.q6;
		}
		if (qtr5 != 0.0) {
			this.qoqGrowth = ((qtr1 - qtr5) / Math.abs(qtr5)) * 100.0;
		}
	}

	private void setSeqGrowth() {

		double qtr1;
		double qtr2;
		if (this.qd.q1 != 0.0) {
			qtr1 = this.qd.q1;
			qtr2 = this.qd.q2;
		} else {
			qtr1 = this.qd.q2;
			qtr2 = this.qd.q3;
		}
		if (qtr2 != 0.0) {
			this.seqGrowth = ((qtr1 - qtr2) / Math.abs(qtr2)) * 100.0;
		}
	}

	private void setYoyGrowth() {

		double yr1 = this.qd.q1 + this.qd.q2 + this.qd.q3 + this.qd.q4;
		double yr2 = this.qd.q5 + this.qd.q6 + this.qd.q7 + this.qd.q8;

		if (yr2 != 0.0) {
			this.yoyGrowth = ((yr1 - yr2) / Math.abs(yr2)) * 100.0;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = TAB + TAB + "Derived ==>" + NL;
		ret += TAB + TAB + TAB + String.format("Seq Growth : %9.2f%%", this.seqGrowth) + NL;
		ret += TAB + TAB + TAB + String.format("Q/Q Growth : %9.2f%%", this.qoqGrowth) + NL;
		ret += TAB + TAB + TAB + String.format("Y/Y Growth : %9.2f%%", this.yoyGrowth) + NL;
		return ret;
	}

}
