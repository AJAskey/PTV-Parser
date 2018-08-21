
package net.ajaskey.market.tools.SIP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class CompanyData {

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		List<CompanyData> companyList = new ArrayList<>();

		QuarterlyData.init();
		
		TotalData td = new TotalData();


		try (BufferedReader reader = new BufferedReader(new FileReader("data/SP500-BALANCESHEETQTR.TXT"))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					CompanyData cd = CompanyData.setCompanyInfo(fld);
					companyList.add(cd);
				}

			}
			
			for (CompanyData cd : companyList) {
				System.out.println(cd);
				td.add(cd);
			}
			System.out.println(td);
		}

	}

	/**
	 * net.ajaskey.market.tools.SIP.setCompanyInfo
	 *
	 * @param fld
	 */
	private static CompanyData setCompanyInfo(String[] fld) {

		final CompanyData cd = new CompanyData();
		cd.name = fld[0].trim();
		cd.ticker = fld[1].trim();
		cd.exchange = fld[2].trim();
		cd.sector = setSecInd(fld[3]);
		cd.industry = setSecInd(fld[4]);

		cd.cash.parse(fld);
		cd.stInvestments.parse(fld);
		cd.acctReceiveable.parse(fld);
		cd.inventory.parse(fld);
		cd.otherAssets.parse(fld);
		cd.currentAssets.parse(fld);
		cd.fixedAssets.parse(fld);
		cd.ltInvestments.parse(fld);
		cd.goodwill.parse(fld);
		cd.otherLtAssets.parse(fld);
		cd.totalAssets.parse(fld);
		cd.acctPayable.parse(fld);
		cd.stDebt.parse(fld);
		cd.otherCurrLiab.parse(fld);
		cd.currLiab.parse(fld);
		cd.ltDebt.parse(fld);
		cd.otherLtLiab.parse(fld);
		cd.totalLiab.parse(fld);
		cd.prefStock.parse(fld);
		cd.equity.parse(fld);
		cd.liabEquity.parse(fld);
		cd.bvps.parse(fld);

		return cd;

	}

	/**
	 * net.ajaskey.market.tools.SIP.setSecInd
	 *
	 * @param string
	 * @return
	 */
	private static String setSecInd(String secind) {

		String ret = "";
		String str = secind.trim();
		int pos = secind.indexOf(" - ");
		if (pos > 0) {
			ret = str.substring(pos + 3, str.length()).trim();
		} else {
			ret = str;
		}
		return ret;
	}

	public String					name;
	public String					ticker;
	public String					exchange;
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
	public CompanyData() {

		this.name = "";
		this.ticker = "";
		this.exchange = "";
		this.sector = "";
		this.industry = "";
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

		String ret = this.ticker + NL;
		ret += TAB + this.name + NL;
		ret += TAB + this.exchange + NL;
		ret += TAB + this.sector + NL;
		ret += TAB + this.industry + NL;
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
