
package net.ajaskey.market.tools.SIP;

import java.text.DecimalFormatSymbols;

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
public class TotalData {

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//public String					name;
	//public String					sector;
	//public String					industry;
	
	// Balance Sheet
	public QuarterlyData	cash;
	public QuarterlyData	stInvestments;
	public QuarterlyData	acctReceiveable;
	public QuarterlyData	inventory;
	public QuarterlyData	otherAssets;
	public QuarterlyData	currentAssets;
	public QuarterlyData	fixedAssets;
	public QuarterlyData	ltInvestments;
	public QuarterlyData	goodwill;
	public QuarterlyData	otherLtAssets;
	public QuarterlyData	totalAssets;
	public QuarterlyData	acctPayable;
	public QuarterlyData	stDebt;
	public QuarterlyData	otherCurrLiab;
	public QuarterlyData	currLiab;
	public QuarterlyData	ltDebt;
	public QuarterlyData	otherLtLiab;
	public QuarterlyData	totalLiab;
	public QuarterlyData	prefStock;
	public QuarterlyData	equity;
	public QuarterlyData	liabEquity;
	public QuarterlyData	bvps;

	// Income Statement
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

	DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public TotalData() {

		//this.name = "";
		this.cash = new QuarterlyData("cash");
		this.stInvestments = new QuarterlyData("stInvestments");
		this.acctReceiveable = new QuarterlyData("acctReceiveable");
		this.inventory = new QuarterlyData("inventory");
		this.otherAssets = new QuarterlyData("otherAssets");
		this.currentAssets = new QuarterlyData("currentAssets");
		this.fixedAssets = new QuarterlyData("fixedAssets");
		this.ltInvestments = new QuarterlyData("ltInvestments");
		this.goodwill = new QuarterlyData("goodwill");
		this.otherLtAssets = new QuarterlyData("otherLtAssets");
		this.totalAssets = new QuarterlyData("totalAssets");
		this.acctPayable = new QuarterlyData("acctPayable");
		this.stDebt = new QuarterlyData("stDebt");
		this.otherCurrLiab = new QuarterlyData("otherCurrLiab");
		this.currLiab = new QuarterlyData("currLiab");
		this.ltDebt = new QuarterlyData("ltDebt");
		this.otherLtLiab = new QuarterlyData("otherLtLiab");
		this.totalLiab = new QuarterlyData("totalLiab");
		this.prefStock = new QuarterlyData("prefStock");
		this.equity = new QuarterlyData("equity");
		this.liabEquity = new QuarterlyData("liabEquity");
		this.bvps = new QuarterlyData("bvps");

		this.sales = new QuarterlyData("sales");
		this.cogs = new QuarterlyData("cogs");
		this.grossIncome = new QuarterlyData("grossIncome");
		this.rd = new QuarterlyData("rd");
		this.depreciation = new QuarterlyData("depreciation");
		this.interestExp = new QuarterlyData("interestExp");
		this.grossOpIncome = new QuarterlyData("grossOpIncome");
		this.unusualIncome = new QuarterlyData("unusualIncome");
		this.totalOpExp = new QuarterlyData("totalOpExp");
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
	}

	/**
	 * net.ajaskey.market.tools.SIP.add
	 *
	 * @param bsd
	 */
	public void add(CompanyData cd) {

		this.acctReceiveable.sum(cd.bsd.acctReceiveable);
		this.acctPayable.sum(cd.bsd.acctPayable);
		this.bvps.sum(cd.bsd.bvps);
		this.cash.sum(cd.bsd.cash);
		this.currentAssets.sum(cd.bsd.currentAssets);
		this.currLiab.sum(cd.bsd.currLiab);
		this.equity.sum(cd.bsd.equity);
		this.fixedAssets.sum(cd.bsd.fixedAssets);
		this.goodwill.sum(cd.bsd.goodwill);
		this.inventory.sum(cd.bsd.inventory);
		this.liabEquity.sum(cd.bsd.liabEquity);
		this.ltDebt.sum(cd.bsd.ltDebt);
		this.ltInvestments.sum(cd.bsd.ltInvestments);
		this.otherAssets.sum(cd.bsd.otherAssets);
		this.otherCurrLiab.sum(cd.bsd.otherCurrLiab);
		this.otherLtAssets.sum(cd.bsd.otherLtAssets);
		this.otherLtLiab.sum(cd.bsd.otherLtLiab);
		this.prefStock.sum(cd.bsd.prefStock);
		this.stDebt.sum(cd.bsd.stDebt);
		this.stInvestments.sum(cd.bsd.stInvestments);
		this.totalAssets.sum(cd.bsd.totalAssets);
		this.totalLiab.sum(cd.bsd.totalLiab);

		this.sales.sum(cd.id.sales);
		this.cogs.sum(cd.id.cogs);
		this.grossIncome.sum(cd.id.grossIncome);
		this.rd.sum(cd.id.rd);
		this.depreciation.sum(cd.id.depreciation);
		this.interestExp.sum(cd.id.interestExp);
		this.unusualIncome.sum(cd.id.unusualIncome);
		this.totalOpExp.sum(cd.id.totalOpExp);
		this.grossOpIncome.sum(cd.id.grossOpIncome);
		this.interestExpNonOp.sum(cd.id.interestExpNonOp);
		this.otherIncome.sum(cd.id.otherIncome);
		this.pretaxIncome.sum(cd.id.pretaxIncome);
		this.incomeTax.sum(cd.id.incomeTax);
		this.incomeAfterTaxes.sum(cd.id.incomeAfterTaxes);
		this.adjustments.sum(cd.id.adjustments);
		this.incomeEps.sum(cd.id.incomeEps);
		this.nonrecurring.sum(cd.id.nonrecurring);
		this.netIncome.sum(cd.id.netIncome);
		this.eps.sum(cd.id.eps);
		this.epsContinuing.sum(cd.id.epsContinuing);
		this.epsDiluted.sum(cd.id.epsDiluted);
		this.epsDilCont.sum(cd.id.epsDilCont);
		this.dividend.sum(cd.id.dividend);

	}

	/**
	 * net.ajaskey.market.tools.SIP.sum
	 *
	 */
	public void sum() {

		this.acctReceiveable.dd.calculate(this.acctReceiveable);
		this.acctPayable.dd.calculate(this.acctPayable);
		this.bvps.dd.calculate(this.bvps);
		this.cash.dd.calculate(this.cash);
		this.currentAssets.dd.calculate(this.currentAssets);
		this.currLiab.dd.calculate(this.currLiab);
		this.equity.dd.calculate(this.equity);
		this.fixedAssets.dd.calculate(this.fixedAssets);
		this.goodwill.dd.calculate(this.goodwill);
		this.inventory.dd.calculate(this.inventory);
		this.liabEquity.dd.calculate(this.liabEquity);
		this.ltDebt.dd.calculate(this.ltDebt);
		this.ltInvestments.dd.calculate(this.ltInvestments);
		this.otherAssets.dd.calculate(this.otherAssets);
		this.otherCurrLiab.dd.calculate(this.otherCurrLiab);
		this.otherLtAssets.dd.calculate(this.otherLtAssets);
		this.otherLtLiab.dd.calculate(this.otherLtLiab);
		this.prefStock.dd.calculate(this.prefStock);
		this.stDebt.dd.calculate(this.stDebt);
		this.stInvestments.dd.calculate(this.stInvestments);
		this.totalAssets.dd.calculate(this.totalAssets);
		this.totalLiab.dd.calculate(this.totalLiab);

		this.sales.dd.calculate(this.sales);
		this.cogs.dd.calculate(this.cogs);
		this.grossIncome.dd.calculate(this.grossIncome);
		this.rd.dd.calculate(this.rd);
		this.depreciation.dd.calculate(this.depreciation);
		this.interestExp.dd.calculate(this.interestExp);
		this.unusualIncome.dd.calculate(this.unusualIncome);
		this.totalOpExp.dd.calculate(this.totalOpExp);
		this.interestExpNonOp.dd.calculate(this.interestExpNonOp);
		this.otherIncome.dd.calculate(this.otherIncome);
		this.pretaxIncome.dd.calculate(this.pretaxIncome);
		this.incomeTax.dd.calculate(this.incomeTax);
		this.incomeAfterTaxes.dd.calculate(this.incomeAfterTaxes);
		this.adjustments.dd.calculate(this.adjustments);
		this.incomeEps.dd.calculate(this.incomeEps);
		this.nonrecurring.dd.calculate(this.nonrecurring);
		this.netIncome.dd.calculate(this.netIncome);
		this.eps.dd.calculate(this.eps);
		this.epsContinuing.dd.calculate(this.epsContinuing);
		this.epsDiluted.dd.calculate(this.epsDiluted);
		this.epsDilCont.dd.calculate(this.epsDilCont);
		this.dividend.dd.calculate(this.dividend);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "Totals ==>" + NL;
		ret += TAB + this.acctPayable;
		ret += TAB + this.acctReceiveable;
		ret += TAB + this.bvps;
		ret += TAB + this.cash;
		ret += TAB + this.equity;
		ret += TAB + this.inventory;
		ret += TAB + this.prefStock;

		ret += TAB + this.currentAssets;
		ret += TAB + this.fixedAssets;
		ret += TAB + this.otherLtAssets;
		ret += TAB + this.otherAssets;
		ret += TAB + this.goodwill;
		ret += TAB + this.totalAssets;

		ret += TAB + this.stInvestments;
		ret += TAB + this.ltInvestments;

		ret += TAB + this.stDebt;
		ret += TAB + this.ltDebt;

		ret += TAB + this.currLiab;
		ret += TAB + this.liabEquity;
		ret += TAB + this.otherCurrLiab;
		ret += TAB + this.otherLtLiab;
		ret += TAB + this.totalLiab;

		ret += TAB + this.sales;
		ret += TAB + this.cogs;
		ret += TAB + this.grossIncome;
		ret += TAB + this.rd;
		ret += TAB + this.depreciation;
		ret += TAB + this.interestExp;
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
