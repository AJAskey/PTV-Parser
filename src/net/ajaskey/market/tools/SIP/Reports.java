
package net.ajaskey.market.tools.SIP;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
public class Reports {

	private List<CompanyData> companyList = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Reports(List<CompanyData> list) {

		companyList = list;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.DumpCompanyReports
	 *
	 */
	public void DumpCompanyReports() {

		Utils.makeDir("out/CompanyReports");

		for (CompanyData cd : companyList) {

			try (PrintWriter pw = new PrintWriter("out/CompanyReports/" + cd.ticker + ".txt")) {
				pw.println(cd.ticker);
				pw.printf("\t%s%n", cd.name);
				pw.printf("\t%s%n", cd.sector);
				pw.printf("\t%s%n", cd.industry);
				
				pw.printf("%n\tShares     : %s M%n", QuarterlyData.fmt(cd.shares.q1, 15));
				pw.printf("\tMarket Cap : %s M%n", QuarterlyData.fmt(cd.marketCap, 15));
				

				pw.printf("%n\tLast Price : %s%n", QuarterlyData.fmt(cd.lastPrice, 15));
				pw.printf("\tPE         : %s%n", QuarterlyData.fmt(cd.pe, 15));
				pw.printf("\tOp Margin  : %s%n", QuarterlyData.fmt(cd.opMargin, 15));
				pw.printf("\tNet Margin : %s%n", QuarterlyData.fmt(cd.netMargin, 15));

				pw.printf("%n\tLast Sales      : %s M\t(QoQ=%s%%)%n", QuarterlyData.fmt(cd.id.sales.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.id.sales.dd.qoqGrowth, 7));
				pw.printf("\tLast Net Income : %s M\t(QoQ=%s%%)%n", QuarterlyData.fmt(cd.id.netIncome.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.id.netIncome.dd.qoqGrowth, 7));
				pw.printf("\tLast EPS        : %s  \t(QoQ=%s%%)%n", QuarterlyData.fmt(cd.id.epsDilCont.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.id.epsDilCont.dd.qoqGrowth, 7));

				pw.printf("%n\t12m Sales       : %s M\t(YoY=%s%%)%n", QuarterlyData.fmt(cd.id.sales.getTtm(), 15),
				    QuarterlyData.fmt(cd.id.sales.dd.yoyGrowth, 7));
				pw.printf("\t12m Net Income  : %s M\t(YoY=%s%%)%n", QuarterlyData.fmt(cd.id.netIncome.getTtm(), 15),
				    QuarterlyData.fmt(cd.id.netIncome.dd.yoyGrowth, 7));
				pw.printf("\t12m EPS         : %s  \t(YoY=%s%%)%n", QuarterlyData.fmt(cd.id.epsDilCont.getTtm(), 15),
				    QuarterlyData.fmt(cd.id.epsDilCont.dd.yoyGrowth, 7));

				pw.printf("%n\tLT Debt           : %s M\t(Seq=%s%%)%n", QuarterlyData.fmt(cd.bsd.ltDebt.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.bsd.ltDebt.dd.seqGrowth, 7));
				pw.printf("\tEquity            : %s M\t(Seq=%s%%)%n", QuarterlyData.fmt(cd.bsd.equity.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.bsd.equity.dd.seqGrowth, 7));
				pw.printf("\tLT Debt to Equity : %s%n", QuarterlyData.fmt(cd.ltDebtEquity, 15));

				pw.printf("%n\tST Debt           : %s M\t(Seq=%s%%)%n", QuarterlyData.fmt(cd.bsd.stDebt.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.bsd.stDebt.dd.seqGrowth, 7));
				pw.printf("\tOperating Income  : %s M\t(Seq=%s%%)%n", QuarterlyData.fmt(cd.id.grossOpIncome.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.id.grossOpIncome.dd.seqGrowth, 7));
				pw.printf("\tST Debt to OpInc  : %s%n", QuarterlyData.fmt(cd.stDebtOpIncome, 15));
				
				pw.printf("%n\tCash              : %s M\t(Seq=%s%%)%n", QuarterlyData.fmt(cd.bsd.cash.getMostRecent(), 15),
				    QuarterlyData.fmt(cd.bsd.cash.dd.seqGrowth, 7));
				pw.printf("\tDebt to Cash      : %s%n", QuarterlyData.fmt(cd.debtCash, 15));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
