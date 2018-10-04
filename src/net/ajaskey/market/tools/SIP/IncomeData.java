
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
public class IncomeData {

	final private static String TAB = "\t";

	public static IncomeData setBalanceSheetInfo(String[] fld) {

		final IncomeData id = new IncomeData();

		id.sales.parse(fld);
		id.cogs.parse(fld);
		id.grossIncome.parse(fld);
		id.rd.parse(fld);
		id.depreciation.parse(fld);
		id.interestExp.parse(fld);
		id.unusualIncome.parse(fld);
		id.totalOpExp.parse(fld);
		id.grossOpIncome.parse(fld);
		id.interestExpNonOp.parse(fld);
		id.otherIncome.parse(fld);
		id.pretaxIncome.parse(fld);
		id.incomeTax.parse(fld);
		id.incomeAfterTaxes.parse(fld);
		id.adjustments.parse(fld);
		id.incomeEps.parse(fld);
		id.nonrecurring.parse(fld);
		id.netIncome.parse(fld);
		id.eps.parse(fld);
		id.epsContinuing.parse(fld);
		id.epsDiluted.parse(fld);
		id.epsDilCont.parse(fld);
		id.dividend.parse(fld);

		return id;

	}

	/**
	 * net.ajaskey.market.tools.SIP.setIncomeData
	 *
	 * @param fld
	 * @return
	 */
	public static IncomeData setIncomeData(String[] fld) {

		final IncomeData id = new IncomeData();

		id.sales.parse(fld);
		id.cogs.parse(fld);
		id.grossIncome.parse(fld);
		id.rd.parse(fld);
		id.depreciation.parse(fld);
		id.interestExp.parse(fld);
		id.unusualIncome.parse(fld);
		id.totalOpExp.parse(fld);
		id.grossOpIncome.parse(fld);
		id.interestExpNonOp.parse(fld);
		id.otherIncome.parse(fld);
		id.pretaxIncome.parse(fld);
		id.incomeTax.parse(fld);
		id.incomeAfterTaxes.parse(fld);
		id.adjustments.parse(fld);
		id.incomeEps.parse(fld);
		id.nonrecurring.parse(fld);
		id.netIncome.parse(fld);
		id.eps.parse(fld);
		id.epsContinuing.parse(fld);
		id.epsDiluted.parse(fld);
		id.epsDilCont.parse(fld);
		id.dividend.parse(fld);

		id.totalInterest.sum(id.interestExp);
		id.totalInterest.sum(id.interestExpNonOp);
		id.totalInterest.dd.calculate(id.totalInterest);

		return id;
	}

	public QuarterlyData	sales;
	public QuarterlyData	cogs;
	public QuarterlyData	grossIncome;
	public QuarterlyData	rd;
	public QuarterlyData	depreciation;
	public QuarterlyData	interestExp;
	public QuarterlyData	unusualIncome;
	public QuarterlyData	totalOpExp;
	public QuarterlyData	grossOpIncome;
	public QuarterlyData	interestExpNonOp;
	public QuarterlyData	otherIncome;
	public QuarterlyData	pretaxIncome;
	public QuarterlyData	incomeTax;
	public QuarterlyData	incomeAfterTaxes;
	public QuarterlyData	adjustments;
	public QuarterlyData	incomeEps;
	public QuarterlyData	nonrecurring;
	public QuarterlyData	netIncome;
	public QuarterlyData	eps;
	public QuarterlyData	epsContinuing;
	public QuarterlyData	epsDiluted;
	public QuarterlyData	epsDilCont;
	public QuarterlyData	dividend;
	public QuarterlyData	totalInterest;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public IncomeData() {

		this.sales = new QuarterlyData("sales");
		this.cogs = new QuarterlyData("cogs");
		this.grossIncome = new QuarterlyData("grossIncome");
		this.rd = new QuarterlyData("rd");
		this.depreciation = new QuarterlyData("depreciation");
		this.interestExp = new QuarterlyData("interestExp");
		this.unusualIncome = new QuarterlyData("unusualIncome");
		this.totalOpExp = new QuarterlyData("totalOpExp");
		this.grossOpIncome = new QuarterlyData("grossOpIncome");
		this.interestExpNonOp = new QuarterlyData("interestExpNonOp");
		this.otherIncome = new QuarterlyData("otherIncome");
		this.pretaxIncome = new QuarterlyData("pretaxIncome");
		this.incomeTax = new QuarterlyData("incomeTax");
		this.incomeAfterTaxes = new QuarterlyData("incomeAfterTaxes");
		this.adjustments = new QuarterlyData("adjustments");
		this.incomeEps = new QuarterlyData("incomeEps");
		this.nonrecurring = new QuarterlyData("nonrecurring");
		this.netIncome = new QuarterlyData("netIncome");
		this.eps = new QuarterlyData("eps");
		this.epsContinuing = new QuarterlyData("epsContinuing");
		this.epsDiluted = new QuarterlyData("epsDiluted");
		this.epsDilCont = new QuarterlyData("epsDilCont");
		this.dividend = new QuarterlyData("dividend");
		this.totalInterest = new QuarterlyData("totalInterest");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "";
		ret += TAB + this.sales;
		ret += TAB + this.cogs;
		ret += TAB + this.grossIncome;
		ret += TAB + this.rd;
		ret += TAB + this.depreciation;
		ret += TAB + this.unusualIncome;

		ret += TAB + this.totalOpExp;
		ret += TAB + this.grossOpIncome;
		ret += TAB + this.interestExp;
		ret += TAB + this.interestExpNonOp;
		ret += TAB + this.totalInterest;
		ret += TAB + this.otherIncome;
		ret += TAB + this.pretaxIncome;
		ret += TAB + this.incomeTax;
		ret += TAB + this.incomeAfterTaxes;

		ret += TAB + this.adjustments;
		ret += TAB + this.incomeEps;

		ret += TAB + this.nonrecurring;
		ret += TAB + this.netIncome;

		ret += TAB + this.eps;
		ret += TAB + this.epsContinuing;
		ret += TAB + this.epsDiluted;
		ret += TAB + this.epsDilCont;
		ret += TAB + this.dividend;
		return ret;
	}
}
