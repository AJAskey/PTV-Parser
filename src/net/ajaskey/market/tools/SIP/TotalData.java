
package net.ajaskey.market.tools.SIP;

import java.text.DecimalFormat;
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
	public QuarterlyData	bvps;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public TotalData() {

		name = "";
		cash = new QuarterlyData("cash");
		stInvestments = new QuarterlyData("stInvestments");
		acctReceiveable = new QuarterlyData("acctReceiveable");
		inventory = new QuarterlyData("inventory");
		otherAssets = new QuarterlyData("otherAssets");
		currentAssets = new QuarterlyData("currentAssets");
		fixedAssets = new QuarterlyData("fixedAssets");
		ltInvestments = new QuarterlyData("ltInvestments");
		goodwill = new QuarterlyData("goodwill");
		otherLtAssets = new QuarterlyData("otherLtAssets");
		totalAssets = new QuarterlyData("totalAssets");
		acctPayable = new QuarterlyData("acctPayable");
		stDebt = new QuarterlyData("stDebt");
		otherCurrLiab = new QuarterlyData("otherCurrLiab");
		currLiab = new QuarterlyData("currLiab");
		ltDebt = new QuarterlyData("ltDebt");
		otherLtLiab = new QuarterlyData("otherLtLiab");
		totalLiab = new QuarterlyData("totalLiab");
		prefStock = new QuarterlyData("prefStock");
		equity = new QuarterlyData("equity");
		liabEquity = new QuarterlyData("liabEquity");
		bvps = new QuarterlyData("bvps");
	}

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * net.ajaskey.market.tools.SIP.add
	 *
	 * @param cd
	 */
	public void add(CompanyData cd) {

		this.acctReceiveable.sum(cd.acctReceiveable);
		this.acctPayable.sum(cd.acctPayable);
		this.bvps.sum(cd.bvps);
		this.cash.sum(cd.cash);
		this.currentAssets.sum(cd.currentAssets);
		this.currLiab.sum(cd.currLiab);
		this.equity.sum(cd.equity);
		this.fixedAssets.sum(cd.fixedAssets);
		this.goodwill.sum(cd.goodwill);
		this.inventory.sum(cd.inventory);
		this.liabEquity.sum(cd.liabEquity);
		this.ltDebt.sum(cd.ltDebt);
		this.ltInvestments.sum(cd.ltInvestments);
		this.otherAssets.sum(cd.otherAssets);
		this.otherCurrLiab.sum(cd.otherCurrLiab);
		this.otherLtAssets.sum(cd.otherLtAssets);
		this.otherLtLiab.sum(cd.otherLtLiab);
		this.prefStock.sum(cd.prefStock);
		this.stDebt.sum(cd.stDebt);
		this.stInvestments.sum(cd.stInvestments);
		this.totalAssets.sum(cd.totalAssets);
		this.totalLiab.sum(cd.totalLiab);

	}
	
	DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = "Totals ==>" + NL;
		ret += TAB + this.cash;
		ret += TAB + this.stInvestments;
		ret += TAB + this.acctReceiveable;
		ret += TAB + this.inventory;
		ret += TAB + this.otherAssets;
		ret += TAB + this.currentAssets;
		ret += TAB + this.fixedAssets;
		ret += TAB + this.ltInvestments;
		ret += TAB + this.goodwill;
		ret += TAB + this.otherLtAssets;
		ret += TAB + this.totalAssets;
		ret += TAB + this.acctPayable;
		ret += TAB + this.stDebt;
		ret += TAB + this.otherCurrLiab;
		ret += TAB + this.currLiab;
		ret += TAB + this.ltDebt;
		ret += TAB + this.otherLtLiab;
		ret += TAB + this.totalLiab;
		ret += TAB + this.prefStock;
		ret += TAB + this.equity;
		ret += TAB + this.liabEquity;
		ret += TAB + this.bvps;
		return ret;
	}

}
