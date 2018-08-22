
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
public class BalanceSheetData {

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";

	public static BalanceSheetData setBalanceSheetInfo(String[] fld) {

		final BalanceSheetData bsd = new BalanceSheetData();

		bsd.cash.parse(fld);
		bsd.stInvestments.parse(fld);
		bsd.acctReceiveable.parse(fld);
		bsd.inventory.parse(fld);
		bsd.otherAssets.parse(fld);
		bsd.currentAssets.parse(fld);
		bsd.fixedAssets.parse(fld);
		bsd.ltInvestments.parse(fld);
		bsd.goodwill.parse(fld);
		bsd.otherLtAssets.parse(fld);
		bsd.totalAssets.parse(fld);
		bsd.acctPayable.parse(fld);
		bsd.stDebt.parse(fld);
		bsd.otherCurrLiab.parse(fld);
		bsd.currLiab.parse(fld);
		bsd.ltDebt.parse(fld);
		bsd.otherLtLiab.parse(fld);
		bsd.totalLiab.parse(fld);
		bsd.prefStock.parse(fld);
		bsd.equity.parse(fld);
		bsd.liabEquity.parse(fld);
		bsd.bvps.parse(fld);

		return bsd;

	}

	/**
	 * net.ajaskey.market.tools.SIP.setSecInd
	 *
	 * @param string
	 * @return
	 */
	private static String setSecInd(String secind) {

		String ret = "";
		final String str = secind.trim();
		final int pos = secind.indexOf(" - ");
		if (pos > 0) {
			ret = str.substring(pos + 3, str.length()).trim();
		} else {
			ret = str;
		}
		return ret;
	}

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
	public QuarterlyData liabEquity;
	public QuarterlyData bvps;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public BalanceSheetData() {

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = ""; 
		ret += TAB + this.cash;
		ret += TAB + this.stInvestments;
		ret += TAB + this.acctReceiveable;
		ret += TAB + this.acctPayable;
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
