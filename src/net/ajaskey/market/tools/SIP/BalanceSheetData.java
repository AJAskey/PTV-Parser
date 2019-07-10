
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

	final private static String TAB = "\t";

	public static BalanceSheetData setBalanceSheetInfo(final String[] fld) {

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
		
		//Derived
		calcAssetsMinusGW(bsd);

		return bsd;

	}

	/** 
	 * net.ajaskey.market.tools.SIP.calcAssetsMinusGW
	 *
	 * @param bsd
	 * @return
	 */
	private static void calcAssetsMinusGW(BalanceSheetData bsd) {
		
		bsd.assetsMinusGW.q1 = bsd.totalAssets.q1 - bsd.goodwill.q1;
		bsd.assetsMinusGW.q2 = bsd.totalAssets.q2 - bsd.goodwill.q2;
		bsd.assetsMinusGW.q3 = bsd.totalAssets.q3 - bsd.goodwill.q3;
		bsd.assetsMinusGW.q4 = bsd.totalAssets.q4 - bsd.goodwill.q4;
		bsd.assetsMinusGW.q5 = bsd.totalAssets.q5 - bsd.goodwill.q5;
		bsd.assetsMinusGW.q6 = bsd.totalAssets.q6 - bsd.goodwill.q6;
		bsd.assetsMinusGW.q7 = bsd.totalAssets.q7 - bsd.goodwill.q7;
		bsd.assetsMinusGW.q8 = bsd.totalAssets.q8 - bsd.goodwill.q8;
		
		bsd.assetsMinusGW.dd.calculate(bsd.assetsMinusGW);

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
	public QuarterlyData	liabEquity;
	public QuarterlyData	bvps;
	
	//Derived
	public QuarterlyData  assetsMinusGW;

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
		
		this.assetsMinusGW = new QuarterlyData("assetsMinusGW");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "";
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
