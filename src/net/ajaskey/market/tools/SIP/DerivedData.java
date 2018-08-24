
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

	final private static double MAX_PE = 275.0;

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.calcDebtToEquity
	 *
	 * @param bsd
	 * @return
	 */
	public static double calcDebtToEquity(BalanceSheetData bsd) {

		double ret = 0.0;
		if (bsd.equity.q1 > 0.0) {
			ret = bsd.ltDebt.q1 / bsd.equity.q1;
		} else if (bsd.equity.q2 > 0.0) {
			ret = bsd.ltDebt.q2 / bsd.equity.q2;
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcDividendYield
	 *
	 * @param id
	 * @param price
	 * @return
	 */
	public static double calcDividendYield(IncomeData id, double price) {

		double ret = 0.0;
		if (price > 0.0) {
			double d1 = id.dividend.q1 + id.dividend.q2 + id.dividend.q3 + id.dividend.q4;
			if (id.dividend.q1 == 0.0) {
				d1 += id.dividend.q5;
			}
			ret = (d1 / price) * 100.0;
		}
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcEarningsYield
	 *
	 * @param id
	 * @param price
	 * @return
	 */
	public static double calcEarningsYield(IncomeData id, double price) {

		double ret = 0.0;
		if (price > 0.0) {
			double e1 = id.epsDilCont.q1 + id.epsDilCont.q2 + id.epsDilCont.q3 + id.epsDilCont.q4;
			if (id.epsDilCont.q1 == 0.0) {
				e1 += id.epsDilCont.q5;
			}
			ret = (e1 / price) * 100.0;
		}
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcInterestRate
	 *
	 * @param id
	 * @return
	 */
	public static double calcInterestRate(IncomeData id) {

		double ret = 0.0;
		final double i1 = id.interestExp.q1 + id.interestExpNonOp.q1;
		final double s1 = id.sales.q1;
		if (s1 > 0.0) {
			ret = (i1 / s1) * 100.0;
		}
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcNetMargin
	 *
	 * @param id
	 * @return
	 */
	public static double calcNetMargin(IncomeData id) {

		double ret = 0.0;
		double n1 = id.netIncome.q1;
		double s1 = id.sales.q1;
		if (n1 == 0.0) {
			n1 = id.netIncome.q2;
			s1 = id.sales.q2;
		}
		if (s1 > 0.0) {
			ret = (n1 / s1) * 100.0;
		}
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcOpMargin
	 *
	 * @param id
	 * @return
	 */
	public static double calcOpMargin(IncomeData id) {

		double ret = 0.0;
		double g1 = id.grossOpIncome.q1;
		double s1 = id.sales.q1;
		if (g1 == 0.0) {
			g1 = id.grossOpIncome.q2;
			s1 = id.sales.q2;
		}
		if (s1 > 0.0) {
			ret = (g1 / s1) * 100.0;
		}
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcPE
	 *
	 * @param id
	 * @param price
	 * @return
	 */
	public static double calcPE(IncomeData id, double price) {

		double ret = MAX_PE;
		double e1 = id.epsDilCont.q1 + id.epsDilCont.q2 + id.epsDilCont.q3 + id.epsDilCont.q4;
		if (id.eps.q1 == 0.0) {
			e1 += id.epsDilCont.q5;
		}
		if (e1 > 0.0) {
			ret = price / e1;
		}
		ret = Math.min(MAX_PE, ret);
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcPSales
	 *
	 * @param id
	 * @param price
	 * @return
	 */
	public static double calcPSales(IncomeData id, double price) {

		double ret = MAX_PE;
		double s1 = id.sales.q1;
		if (s1 == 0.0) {
			s1 = id.sales.q2 / 1000000.0;
		}
		if (s1 > 0.0) {
			ret = (price / s1) * 1000.0;
		}
		ret = Math.min(MAX_PE, ret);
		return ret;

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.calcTaxRate
	 *
	 * @param id
	 * @return
	 */
	public static double calcTaxRate(IncomeData id) {

		double ret = 0.0;
		double t1 = id.incomeTax.q1;
		double s1 = id.sales.q1;
		if (t1 == 0.0) {
			t1 = id.incomeTax.q2;
			s1 = id.sales.q2;
		}
		if (s1 > 0.0) {
			ret = (t1 / s1) * 100.0;
		}
		return ret;

	}

	public double qoqGrowth;

	public double seqGrowth;

	public double yoyGrowth;

	public double ttm;

	private QuarterlyData qd;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DerivedData() {

		this.qoqGrowth = 0.0;
		this.seqGrowth = 0.0;
		this.yoyGrowth = 0.0;
		this.ttm = 0.0;
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
		this.setTtmEps();
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

	/**
	 *
	 * net.ajaskey.market.tools.SIP.setSeqGrowth
	 *
	 */
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

	/**
	 * net.ajaskey.market.tools.SIP.setTtmEps
	 *
	 */
	private void setTtmEps() {

		double e1 = this.qd.q1 + this.qd.q2 + this.qd.q3 + this.qd.q4;
		if (this.qd.q1 == 0.0) {
			e1 += this.qd.q5;
		}
		this.ttm = e1;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.setYoyGrowth
	 *
	 */
	private void setYoyGrowth() {

		final double yr1 = this.qd.q1 + this.qd.q2 + this.qd.q3 + this.qd.q4;
		final double yr2 = this.qd.q5 + this.qd.q6 + this.qd.q7 + this.qd.q8;

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
		ret += TAB + TAB + TAB + String.format("Seq Growth : %5.2f%%", this.seqGrowth) + NL;
		ret += TAB + TAB + TAB + String.format("Q/Q Growth : %15.2f%%", this.qoqGrowth) + NL;
		ret += TAB + TAB + TAB + String.format("Y/Y Growth : %15.2f%%", this.yoyGrowth) + NL;
		ret += TAB + TAB + TAB + "12m Total  : " + QuarterlyData.fmt(this.ttm) + " (avg= "
		    + QuarterlyData.fmt(this.ttm / 4.0, 1) + ")" + NL;
		return ret;
	}

}
