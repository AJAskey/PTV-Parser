
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

	final private static double MILLION = 1000000.0;

	private List<CompanyData> companyList = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Reports(List<CompanyData> list) {

		this.companyList = list;
	}

	public void DumpBestFinancial() throws FileNotFoundException {

		Utils.makeDir("out/CompanyReports");

		try (PrintWriter pw = new PrintWriter("out/BestCompanies.txt")) {

			for (final CompanyData cd : this.companyList)
				if ((cd.opMargin > 10.0) && (cd.netMargin > 10.0) && (cd.roe > 10.0) && (cd.bsd.equity.getMostRecent() > 0.0)
				    && (cd.workingCashFlow > 0.0) && (cd.id.sales.dd.qoqGrowth > 10.0) && (cd.id.sales.dd.yoyGrowth > 10.0)
				    && (cd.id.netIncome.dd.qoqGrowth > 10.0) && (cd.id.netIncome.dd.yoyGrowth > 10.0)) {
					this.printData(pw, cd);
					pw.println();
				}

		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.DumpCompanyReports
	 *
	 * @throws FileNotFoundException
	 *
	 */
	public void DumpCompanyReports() throws FileNotFoundException {

		Utils.makeDir("out/CompanyReports");

		final PrintWriter pwAll = new PrintWriter("out/CompanyReports.txt");
		for (final CompanyData cd : this.companyList)
			try (PrintWriter pw = new PrintWriter("out/CompanyReports/" + cd.ticker + ".txt")) {
				this.printData(pw, cd);
				this.printData(pwAll, cd);
				pwAll.println();

			} catch (final FileNotFoundException e) {
				e.printStackTrace();
			}
		pwAll.close();
	}

	private void printData(PrintWriter pw, CompanyData cd) {

		pw.println(cd.ticker);
		pw.printf("\t%s%n", cd.name);
		pw.printf("\t%s%n", cd.sector);
		pw.printf("\t%s%n", cd.industry);
		pw.printf("\tEmployees: %d%n", cd.numEmp);

		pw.printf("%n\tShares     : %s M\t(Seq= %s%% : YoY= %s%%)%n", QuarterlyData.fmt(cd.shares.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.shares.dd.seqGrowth, 7), QuarterlyData.fmt(cd.shares.dd.qoqGrowth, 7));
		pw.printf("\tMarket Cap : %s M%n", QuarterlyData.fmt(cd.marketCap, 15));
		pw.printf("\tEquity     : %s M%n", QuarterlyData.fmt(cd.bsd.equity.getMostRecent(), 15));
		pw.printf("\tBVPS       : %s%n", QuarterlyData.fmt(cd.bsd.bvps.getMostRecent(), 15));

		pw.printf("%n\tLast Price    : %s%n", QuarterlyData.fmt(cd.lastPrice, 15));
		pw.printf("\tPE            : %s%n", QuarterlyData.fmt(cd.pe, 15));
		pw.printf("\tPS            : %s%n", QuarterlyData.fmt(cd.psales, 15));
		pw.printf("\tOp Margin     : %s%n", QuarterlyData.fmt(cd.opMargin, 15));
		pw.printf("\tNet Margin    : %s%n", QuarterlyData.fmt(cd.netMargin, 15));
		pw.printf("\tROE           : %s%n", QuarterlyData.fmt(cd.roe, 15));

		pw.printf("%n\tLast Sales        : %s M\t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.sales.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.sales.dd.qoqGrowth, 7));
		pw.printf("\tLast Op Income    : %s M\t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.grossOpIncome.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.grossOpIncome.dd.qoqGrowth, 7));
		pw.printf("\tLast Interest     : %s M\t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.totalInterest.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.totalInterest.dd.qoqGrowth, 7));
		pw.printf("\tLast Taxes        : %s M\t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.incomeTax.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.incomeTax.dd.qoqGrowth, 7));
		pw.printf("\tLast Net Income   : %s M\t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.netIncome.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.netIncome.dd.qoqGrowth, 7));
		pw.printf("\tLast EPS          : %s  \t(QoQ= %s%%)%n", QuarterlyData.fmt(cd.id.epsDilCont.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.id.epsDilCont.dd.qoqGrowth, 7));

		pw.printf("%n\t12m Sales             : %s M\t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.sales.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.sales.dd.yoyGrowth, 7));
		pw.printf("\t12m Op Income         : %s M\t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.grossOpIncome.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.grossOpIncome.dd.yoyGrowth, 7));
		pw.printf("\t12m Interest          : %s M\t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.totalInterest.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.totalInterest.dd.yoyGrowth, 7));
		pw.printf("\t12m Taxes             : %s M\t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.incomeTax.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.incomeTax.dd.yoyGrowth, 7));
		pw.printf("\t12m Net Income        : %s M\t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.netIncome.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.netIncome.dd.yoyGrowth, 7));
		pw.printf("\t12m EPS               : %s  \t(YoY= %s%%)%n", QuarterlyData.fmt(cd.id.epsDilCont.getTtm(), 15),
		    QuarterlyData.fmt(cd.id.epsDilCont.dd.yoyGrowth, 7));
		pw.printf("\t12m Cash from Ops     : %s M%n", QuarterlyData.fmt(cd.cashFromOps, 15));
		pw.printf("\t12m Dividends         : %s M%n",
		    QuarterlyData.fmt((cd.id.dividend.getTtm() * cd.shares.getTtmAvg()), 15));
		pw.printf("\t12m CapEx             : %s M%n", QuarterlyData.fmt(cd.capEx, 15));
		pw.printf("\t12m Free Cash Flow    : %s M%n", QuarterlyData.fmt(cd.freeCashFlow, 15));
		pw.printf("\t12m Working Cash Flow : %s M%n", QuarterlyData.fmt(cd.workingCashFlow, 15));
		pw.printf("\t12m Cash Flow         : %s M%n", QuarterlyData.fmt(cd.cashFlow, 15));

		pw.printf("%n\tLT Debt           : %s M\t(Seq= %s%% : YoY= %s%%)%n",
		    QuarterlyData.fmt(cd.bsd.ltDebt.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.ltDebt.dd.seqGrowth, 7),
		    QuarterlyData.fmt(cd.bsd.ltDebt.dd.qoqGrowth, 7));
		pw.printf("\tEquity            : %s M\t(Seq= %s%% : YoY= %s%%)%n",
		    QuarterlyData.fmt(cd.bsd.equity.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.equity.dd.seqGrowth, 7),
		    QuarterlyData.fmt(cd.bsd.equity.dd.qoqGrowth, 7));
		pw.printf("\tLT Debt / Equity  : %s%n", QuarterlyData.fmt(cd.ltDebtEquity, 15));
		pw.printf("\tGoodwill          : %s M\t(Seq= %s%% : YoY= %s%%)%n",
		    QuarterlyData.fmt(cd.bsd.goodwill.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.goodwill.dd.seqGrowth, 7),
		    QuarterlyData.fmt(cd.bsd.goodwill.dd.qoqGrowth, 7));
		pw.printf("\tDebt / Equity'    : %s%n",
		    QuarterlyData.fmt((cd.bsd.ltDebt.getMostRecent() + cd.bsd.stDebt.getMostRecent())
		        / (cd.bsd.equity.getMostRecent() - cd.bsd.goodwill.getMostRecent())),
		    15);
		if (cd.bsd.goodwill.getMostRecent() > 0.0) {
			pw.printf("\tGoodwill / Assets : %s%%%n",
			    QuarterlyData.fmt(cd.bsd.goodwill.getMostRecent() / cd.bsd.totalAssets.getMostRecent() * 100.0), 15);
		}

		pw.printf("%n\tST Debt           : %s M\t(Seq=%s%% : YoY= %s%%)%n",
		    QuarterlyData.fmt(cd.bsd.stDebt.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.stDebt.dd.seqGrowth, 7),
		    QuarterlyData.fmt(cd.bsd.stDebt.dd.qoqGrowth, 7));
		pw.printf("\tST Debt / OpInc   : %s%n", QuarterlyData.fmt(cd.stDebtOpIncome, 15));

		pw.printf("%n\tCash              : %s M\t(Seq= %s%% : YoY= %s%%)%n",
		    QuarterlyData.fmt(cd.bsd.cash.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.cash.dd.seqGrowth, 7),
		    QuarterlyData.fmt(cd.bsd.cash.dd.qoqGrowth, 7));
		pw.printf("\tDebt / Cash       : %s%n", QuarterlyData.fmt(cd.debtCash, 15));

		if (cd.numEmp > 0) {
			String s = QuarterlyData.fmt((cd.id.grossOpIncome.getTtm() / (double) cd.numEmp * MILLION));
			pw.printf("%n\tOpInc per Emp : $%s%n", s.trim(), 15);
		}

	}

	/** 
	 * net.ajaskey.market.tools.SIP.dumpStats
	 *
	 * @param statList
	 * @param td
	 */
	public static void dumpStats(List<Statistics> statList, TotalData td) {

		// TODO Auto-generated method stub
		
	}

}
