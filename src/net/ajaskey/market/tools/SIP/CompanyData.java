
package net.ajaskey.market.tools.SIP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

		QuarterlyData.init();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/SP500-BALANCESHEETQTR.TXT"))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					CompanyData cd = CompanyData.setCompanyInfo(fld);
					System.out.println(cd);
				}

			}
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
		cd.sector = fld[3].trim();
		cd.industry = fld[4].trim();

		cd.cash.parse(fld);
		cd.stInvestments.parse(fld);
		cd.acctRx.parse(fld);
		cd.inventory.parse(fld);
		cd.otherAssets.parse(fld);
		cd.currentAssets.parse(fld);
		cd.fixedAssets.parse(fld);
		cd.ltInvestments.parse(fld);
		cd.goodwill.parse(fld);

		return cd;

	}

	public String					name;
	public String					ticker;
	public String					exchange;
	public String					sector;
	public String					industry;
	public QuarterlyData	cash;
	public QuarterlyData	stInvestments;
	public QuarterlyData	acctRx;
	public QuarterlyData	inventory;
	public QuarterlyData	otherAssets;
	public QuarterlyData	currentAssets;
	public QuarterlyData	fixedAssets;
	public QuarterlyData	ltInvestments;
	public QuarterlyData	goodwill;

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
		this.acctRx = new QuarterlyData("acctRx");
		this.inventory = new QuarterlyData("inventory");
		this.otherAssets = new QuarterlyData("otherAssets");
		this.currentAssets = new QuarterlyData("currentAssets");
		this.fixedAssets = new QuarterlyData("fixedAssets");
		this.ltInvestments = new QuarterlyData("ltInvestments");
		this.goodwill = new QuarterlyData("goodwill");
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
		ret += TAB + this.acctRx;
		ret += TAB + this.inventory;
		ret += TAB + this.otherAssets;
		ret += TAB + this.currentAssets;
		ret += TAB + this.fixedAssets;
		ret += TAB + this.ltInvestments;
		ret += TAB + this.goodwill;
		return ret;
	}

}
