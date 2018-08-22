
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

	private static List<CompanyData> companyList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		QuarterlyData.init();

		final TotalData td = new TotalData();

		// Read balance sheet
		try (BufferedReader reader = new BufferedReader(new FileReader("data/SP500-BALANCESHEETQTR.TXT"))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final CompanyData cd = setCompanyInfo(fld);
					cd.bsd = BalanceSheetData.setBalanceSheetInfo(fld);
					companyList.add(cd);
				}
			}
		}

		// Read income statement
		try (BufferedReader reader = new BufferedReader(new FileReader("data/SP500-INCOMESTMTQTR.TXT"))) {
			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {

					
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					String ticker = fld[1].trim();
					CompanyData cd = getCompany(ticker);
					if (cd != null) {
						cd.id = IncomeData.setIncomeData(fld);
					}
				}
			}
		}
		for (final CompanyData cd : companyList) {
			System.out.println(cd);
			td.add(cd);
		}

		td.sum();

		System.out.println(td);
	}

	/**
	 * net.ajaskey.market.tools.SIP.getCompany
	 *
	 * @param ticker
	 * @return
	 */
	private static CompanyData getCompany(String ticker) {

		for (final CompanyData cd : companyList) {
			if (cd.ticker.equalsIgnoreCase(ticker)) {
				return cd;
			}
		}
		return null;
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
		cd.sector = CompanyData.setSecInd(fld[3]);
		cd.industry = CompanyData.setSecInd(fld[4]);

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
		final String str = secind.trim();
		final int pos = secind.indexOf(" - ");
		if (pos > 0) {
			ret = str.substring(pos + 3, str.length()).trim();
		} else {
			ret = str;
		}
		return ret;
	}

	public String						name;
	public String						ticker;
	public String						exchange;
	public String						sector;
	public String						industry;
	public BalanceSheetData	bsd;
	public IncomeData				id;

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
		ret += this.bsd;
		ret += this.id;

		return ret;
	}

}
