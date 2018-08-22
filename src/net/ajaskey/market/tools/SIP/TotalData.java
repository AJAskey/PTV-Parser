
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

	public String					name;
	public String					sector;
	public String					industry;
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

	public QuarterlyData bvps;

	DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public TotalData() {

		this.name = "";
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

		return ret;
	}

}
