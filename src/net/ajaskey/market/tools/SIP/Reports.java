
package net.ajaskey.market.tools.SIP;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Debug;
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

	private static final double MILLION = 1000000.0;

	private static final String NL = "\n";

	private static final double	intToSalesHWM	= 10.0;
	private static final double	cratioLWM			= 0.75;
	private static final double	lteHWM				= 5.0;

	/**
	 *
	 * net.ajaskey.market.tools.SIP.checkMaxValue
	 *
	 * @param ticker
	 * @param desc
	 * @param val
	 * @param max
	 * @return
	 */
	private static boolean checkMaxValue(String ticker, String desc, double val, double max) {

		boolean ret = true;

		if (val > max) {
			final String s = ticker + desc;
			Debug.log(String.format("  %-15s Value : %.2f is greater than Max : %.2f%n", s, val, max));
			ret = false;
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.checkMinValue
	 *
	 * @param ticker
	 * @param desc
	 * @param val
	 * @param min
	 * @return
	 */
	private static boolean checkMinValue(String ticker, String desc, double val, double min) {

		boolean ret = true;

		if (val < min) {
			final String s = ticker + desc;
			Debug.log(String.format("  %-15s Value : %.2f is less than Min : %.2f%n", s, val, min));
			ret = false;
		}

		return ret;
	}

	private List<CompanyData> companyList = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Reports(List<CompanyData> list) {

		this.companyList = list;
	}

	/**
	 * net.ajaskey.market.tools.SIP.addStr
	 *
	 * @param ticker
	 * @param str
	 */
	private String addStr(String ticker, String str) {

		str += " " + ticker;
		final int len = str.length() - str.lastIndexOf(NL);
		if (len > 85) {
			str += NL;
		}
		return str;
	}

	/**
	 * net.ajaskey.market.tools.SIP.printState
	 *
	 * @param pw
	 * @param cd
	 */
	private String getState(CompanyData cd) {

		String ret = String.format("%n\t%s State -->%n", cd.ticker);

		boolean goodState = true;

		final double fcfwc = cd.freeCashFlow + cd.workingCapital;

		if ((cd.cashData.cashFromOps.getTtm() < cd.workingCapital) && (cd.workingCapital < 0.0)) {
			ret += String.format("\t  Cash from Operations less than Working Capital deficit%n");
			goodState = false;
		}

		if ((fcfwc < 0.0) && (cd.id.dividend.getTtm() <= 0.0)) {
			ret += String.format("\t  Free Cash Flow plus Working Capital is negative (%.2f)%n",
			    (cd.freeCashFlow + cd.workingCapital));
			goodState = false;
		}

		if ((fcfwc < 0.0) && (cd.id.dividend.getTtm() > 0.0)) {
			ret += String.format("\t  Free Cash Flow plus Working Capital is negative (%.2f) with dividend paid %.2f.%n",
			    (fcfwc), (cd.id.dividend.getTtm() * cd.shares.getTtmAvg()));
			goodState = false;
		}

		if ((cd.currentRatio < cratioLWM) && (cd.totalCashFlow < 0.0)) {
			ret += String.format("\t  Current Ratio less than %.2f and Cash Flow less than 0.%n", cratioLWM);
			goodState = false;
		}

		if ((fcfwc < 0.0) && (cd.cashData.cashFromFin.getTtm() > 0.0)
		    && (cd.cashData.cashFromFin.getTtm() > Math.abs(fcfwc))) {
			ret += String.format(
			    "\t  Running company with Financing. Cash from Financing greater than FCF plus Working Capital.%n",
			    cratioLWM);
			goodState = false;
		}

		if ((cd.id.interestExpNonOp.getTtm() > 0.0) && (cd.interestRate > intToSalesHWM)) {
			ret += String.format("\t  Interest payments to sales is high at %.2f%%.%n", cd.interestRate);
			goodState = false;
		}

		if (cd.bsd.equity.getMostRecent() <= 0.0) {
			ret += String.format("\t  Shareholders have no equity.%n");
			goodState = false;
		} else {
			final double dte = cd.bsd.ltDebt.getMostRecent() / cd.bsd.equity.getMostRecent();
			if (dte > lteHWM) {
				ret += String.format("\t  LT debt to equity of %.2f is high.%n", dte);
				goodState = false;
			}
		}

		//		if (cd.zd.zIsZombie) {
		//			pw.println("\t  Is a Zombie by algorithm.");
		//			goodState = false;
		//		}

		if (goodState) {
			ret += String.format("\t  Good shape - no red flags.%n");
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.print1QtrData
	 *
	 * @param pw
	 * @param q1
	 * @param heading
	 */
	private void print1QtrData(PrintWriter pw, double q1, String heading) {

		final String s1 = QuarterlyData.fmt(q1, 15);
		pw.printf("\t  %-15s: %s%n", heading, s1);
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.print4QtrData
	 *
	 * @param pw
	 * @param qd
	 * @param heading
	 */
	private void print4QtrData(PrintWriter pw, QuarterlyData qd, String heading) {

		double q1, q2, q3, q4;
		if (Math.abs(qd.q1) > 0.0) {
			q1 = qd.q1;
			q2 = qd.q2;
			q3 = qd.q3;
			q4 = qd.q4;
		} else {
			q1 = qd.q2;
			q2 = qd.q3;
			q3 = qd.q4;
			q4 = qd.q5;
		}
		final String s1 = QuarterlyData.fmt(q1, 15);
		final String s2 = QuarterlyData.fmt(q2, 15);
		final String s3 = QuarterlyData.fmt(q3, 15);
		final String s4 = QuarterlyData.fmt(q4, 15);
		pw.printf("\t  %-15s: %s %s %s %s%n", heading, s1, s2, s3, s4);
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.printData
	 *
	 * @param pw
	 * @param cd
	 */
	private void printData(PrintWriter pw, CompanyData cd) {

		this.printHeaderData(pw, cd);

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
		pw.printf("\t12m Cash from Ops     : %s M%n", QuarterlyData.fmt(cd.cashData.cashFromOps.getTtm(), 15));
		pw.printf("\t12m Dividends         : %s M%n",
		    QuarterlyData.fmt((cd.id.dividend.getTtm() * cd.shares.getTtmAvg()), 15));
		pw.printf("\t12m CapEx             : %s M%n", QuarterlyData.fmt(cd.cashData.capEx.getTtm(), 15));
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
			    QuarterlyData.fmt((cd.bsd.goodwill.getMostRecent() / cd.bsd.totalAssets.getMostRecent()) * 100.0), 15);
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
			final String s = QuarterlyData.fmt(((cd.id.grossOpIncome.getTtm() / cd.numEmp) * MILLION));
			pw.printf("%n\tOpInc per Emp : $%s%n", s.trim(), 15);
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.printHeaderData
	 *
	 * @param pw
	 * @param cd
	 */
	private void printHeaderData(PrintWriter pw, CompanyData cd) {

		pw.println(" " + cd.ticker);
		pw.printf("\t%s : %s, %s%n", cd.name, cd.city, cd.state);

		String index = "";
		if (cd.spIndex.length() > 0) {
			index = ", " + cd.spIndex;
		}

		pw.printf("\t%s, %s%s%n", cd.sector, cd.industry, index);
		//pw.printf("\t%s%n", cd.industry);
		String sNumEmp = "?";
		if (cd.numEmp > 0) {
			sNumEmp = QuarterlyData.ifmt(cd.numEmp, 12);
		}
		pw.printf("\tEmployees     : %s%n", sNumEmp);
		if (cd.numEmp > 0) {
			final double d = (cd.id.grossOpIncome.getTtm() / cd.numEmp) * MILLION;
			final int i = (int) d;
			pw.printf("\tOpInc per Emp : $%s%n", QuarterlyData.ifmt(i, 11));
		}

		final String dat = Utils.stringDate(cd.eoq);
		pw.printf("\t10Q Date      :  %s%n", dat);

		//this.printState(pw, cd);

		//		if (cd.ticker.equalsIgnoreCase("MAXR")) {
		//			System.out.println(cd);
		//		}
		pw.printf("%n\tMarket Cap        : %s M%n", QuarterlyData.fmt(cd.marketCap, 13));
		pw.println(cd.shares.fmtGrowth1Q("Shares"));

		final double sc = DerivedData.calcShareChange(cd);
		if (sc < -0.250) {
			final double bbest = Math.abs(sc) * cd.avgPrice;
			pw.printf("\tShare Change 12m  : %s M (Buyback Est= $%sM)%n", QuarterlyData.fmt(sc, 13),
			    QuarterlyData.fmt(bbest, 1));
		}

		pw.println("\n" + cd.id.sales.fmtGrowth4Q("Sales 12m"));
		pw.println(cd.id.grossOpIncome.fmtGrowth4Q("Ops Income 12m"));
		pw.println(cd.id.netIncome.fmtGrowth4Q("Net Income 12m"));
		pw.println(cd.id.totalInterest.fmtGrowth4Q("Interest Paid 12m"));

		pw.println("\n" + cd.cashData.cashFromOps.fmtGrowth4Q("Cash <- Ops 12m"));
		pw.println(cd.cashData.capEx.fmtGrowth4Q("  CapEx 12m"));
		if (cd.id.dividend.getTtm() > 0.0) {
			pw.printf("\t  Dividends 12m   : %s M (Yield=%.2f%%)%n",
			    QuarterlyData.fmt((cd.id.dividend.getTtm() * cd.shares.getTtmAvg()), 13), cd.divYld);

		} else {
			pw.printf("\t  Dividends 12m   : %s M%n",
			    QuarterlyData.fmt((cd.id.dividend.getTtm() * cd.shares.getTtmAvg()), 13));
		}
		pw.printf("\t    FCF 12m       : %s M %s%n", QuarterlyData.fmt(cd.freeCashFlow, 13),
		    "[Cash from Operations - CapEx - Dividends]");
		pw.printf("\tCash <- Fin 12m   : %s M %s%n", QuarterlyData.fmt(cd.cashData.cashFromFin.getTtm(), 13),
		    "[Movement of cash between a firm and its owners/creditors : borrowing, debt repayment, dividend paid, equity financing.]");
		pw.printf("\t  Net Cash 12m    : %s M %s%n", QuarterlyData.fmt(cd.netCashFlow, 13),
		    "[Cash from Ops + Cash from Financing]");
		pw.printf("\tCash <- Inv 12m   : %s M %s%n", QuarterlyData.fmt(cd.cashData.cashFromInv.getTtm(), 13),
		    "[Purchases and sales of long-term assets such as plant and machinery - assumed infrequent.]");
		pw.printf("\t  Cash Flow 12m   : %s M %s%n",
		    QuarterlyData.fmt(cd.netCashFlow + cd.cashData.cashFromInv.getTtm(), 13),
		    "[Cash from Ops + Cash from Financing + Cash from Investing]");

		pw.println("\n" + cd.bsd.cash.fmtGrowth1Q("Cash Available"));

		if (cd.bsd.currentAssets.getMostRecent() > 0.0) {
			pw.println(NL + cd.bsd.currentAssets.fmtGrowth1Q("Current Assets"));
			pw.println(cd.bsd.currLiab.fmtGrowth1Q("Current Liabs"));
		} else {
			pw.printf("%n\tCurrent Assets    : %s M%n", QuarterlyData.fmt(cd.sumCurrAssets, 13));
			pw.printf("\tCurrent Liabs     : %s M%n", QuarterlyData.fmt(cd.sumCurrLiab, 13));
		}
		pw.printf("\tWorking Capital   : %s M (Ratio=%.2f)%n", QuarterlyData.fmt((cd.workingCapital), 13), cd.currentRatio);

		pw.println("\n" + cd.bsd.equity.fmtGrowth1Q("Shareholder Equity"));
		pw.println(cd.bsd.ltDebt.fmtGrowth1Q("LT Debt"));

		if (cd.bsd.equity.getMostRecent() > 0.0) {
			pw.printf("\tLT Debt to Equity : %s%n",
			    QuarterlyData.fmt(cd.bsd.ltDebt.getMostRecent() / cd.bsd.equity.getMostRecent(), 13));
		}

		pw.printf("%n\tLast Price          : %s : (52wkHi= %.2f %%offHigh=%d%%)%n", QuarterlyData.fmt(cd.lastPrice, 11),
		    cd.high52wk, (int) cd.pricePercOff52High);
		pw.printf("\tPE                  : %s%n", QuarterlyData.fmt(cd.pe, 11));
		pw.printf("\tOp Margin           : %s%%%n", QuarterlyData.fmt(cd.opMargin, 11));
		pw.printf("\tNet Margin          : %s%%%n", QuarterlyData.fmt(cd.netMargin, 11));
		pw.printf("\tROE                 : %s%%%n", QuarterlyData.fmt(cd.roe, 11));
		pw.printf("\tInterest %% of sales : %s%%%n", QuarterlyData.fmt(cd.interestRate, 11));
		if (cd.id.epsDilCont.getTtm() > 0.0) {
			pw.printf("\tEPS Yield           : %s%% ($%.2f)%n", QuarterlyData.fmt(cd.epsYld, 11), cd.id.epsDilCont.getTtm(),
			    2);
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.WriteBestFinancial
	 *
	 * @throws FileNotFoundException
	 */
	public void WriteBestFinancial() throws FileNotFoundException {

		Utils.makeDir("out/CompanyReports");

		final List<CompanyData> bestList = new ArrayList<>();

		/**
		 *
		 */
		int knt = 0;
		try (PrintWriter pw = new PrintWriter("out/BestCompanies.txt")) {

			pw.printf("Created : %s\t%s%n", Utils.getCurrentDateStr(), "This file is subject to change without notice.");
			pw.println("Pre-filtered for US companies over $5 and average trading volume of at least 100K." + NL);

			pw.println("Seq : this quarter versus last quarter.");
			pw.println("QoQ : this quarter versus same quarter a year ago.");
			pw.println("YoY : last 12m versus 12m a year ago.\n\n--------------------------");

			for (final CompanyData cd : this.companyList) {

				if (!Reports.checkMinValue(cd.ticker, " Sales QoQ", cd.id.sales.dd.qoqGrowth, 10.0)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " Sales YoY", cd.id.sales.dd.yoyGrowth, 10.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " GrossOpIncome", cd.id.grossOpIncome.getMostRecent(), 0.01)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " OpMargin", cd.opMargin, 10.0)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " NetMargin", cd.netMargin, 10.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " Cash from Operations", cd.cashData.cashFromOps.getTtm(), 0.01)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " Equity", cd.bsd.equity.getMostRecent(), 0.0)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " ROE", cd.roe, 10.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " NetIncome", cd.id.netIncome.getMostRecent(), 0.01)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " NetIncome QoQ", cd.id.netIncome.dd.qoqGrowth, 25.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " IncomeEPS QoQ", cd.id.incomeEps.dd.qoqGrowth, 25.0)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " IncomeEPS YoY", cd.id.incomeEps.dd.yoyGrowth, 25.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " Sharehold Equity", cd.bsd.equity.getMostRecent(), 1.0)) {
					continue;
				}
				if (!Reports.checkMinValue(cd.ticker, " Sharehold Equity Growth", cd.bsd.equity.dd.qoqGrowth, 5.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " Insiders", cd.insiders, 1.0)) {
					continue;
				}

				if (!Reports.checkMaxValue(cd.ticker, " Interest Paid", cd.interestRate, 5.0)) {
					continue;
				}

				if (!Reports.checkMinValue(cd.ticker, " OpInc Growth 3Yr", cd.opInc3yrGrowth, 0.0)) {
					continue;
				}

				final double fcfwc = cd.freeCashFlow + cd.workingCapital;
				if (!Reports.checkMinValue(cd.ticker, " FCFWS", fcfwc, 0.01)) {
					continue;
				}

				if (!Reports.checkMaxValue(cd.ticker, " SupplyDemand", cd.turnover, 90.0)) {
					continue;
				}

				if (!Reports.checkMaxValue(cd.ticker, " Price vs 52 Week High", cd.pricePercOff52High, 50.0)) {
					continue;
				}

				this.printHeaderData(pw, cd);
				this.WriteShareData(pw, cd);
				pw.println();

				pw.println(cd.id.sales.fmtGrowthQY("Sales 12m"));
				pw.println(cd.id.incomeEps.fmtGrowthQY("Income EPS 12m"));
				pw.printf("\tOpInc Growth 3Y   : %13.2f%%%n", cd.opInc3yrGrowth);
				pw.println();

				bestList.add(cd);

				knt++;

			}
		}
		System.out.printf("Total Best Companies found : %d%n", knt);

		try (PrintWriter pw = new PrintWriter("out/best-list.txt")) {
			for (final CompanyData cd : bestList) {
				pw.printf(" $%s", cd.ticker);
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
	public void WriteCompanyReports() throws FileNotFoundException {

		Utils.makeDir("out/CompanyReports");

		final PrintWriter pwAll = new PrintWriter("out/CompanyReports.txt");

		for (final CompanyData cd : this.companyList) {
			try (PrintWriter pw = new PrintWriter("out/CompanyReports/" + cd.ticker + ".txt")) {
				this.printHeaderData(pw, cd);
				this.WriteShareData(pw, cd);

				this.printHeaderData(pwAll, cd);

				this.WriteShareData(pwAll, cd);
				pw.println();

				pwAll.println(cd.id.sales.fmtGrowthQY("Sales 12m"));
				pwAll.println(cd.id.incomeEps.fmtGrowthQY("Income EPS 12m"));
				pwAll.printf("\tOpInc Growth 3Y   : %13.2f%%%n", cd.opInc3yrGrowth);
				pwAll.println();

			} catch (final FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		pwAll.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.WriteShareData
	 *
	 * @param pw
	 * @param cd
	 */
	private void WriteShareData(PrintWriter pw, CompanyData cd) {

		pw.printf("%n\tFloat             : %s M%n", QuarterlyData.fmt(cd.floatShares, 13));
		double d = (cd.insiders * cd.floatShares) / 100.0;
		pw.printf("\tInsiders          : %s M (%s%%)%n", QuarterlyData.fmt(d, 13), QuarterlyData.fmt(cd.insiders, 5));
		d = (cd.inst * cd.floatShares) / 100.0;
		pw.printf("\tInstitutions      : %s M (%s%%)%n", QuarterlyData.fmt(d, 13), QuarterlyData.fmt(cd.inst, 5));
		pw.printf("\tAvg Daily Vol     : %s%n", QuarterlyData.ifmt(cd.adv, 13));
		pw.printf("\tTurnover Float    : %s days%n", QuarterlyData.fmt(cd.turnover, 13));

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.WriteZombies
	 *
	 * @throws FileNotFoundException
	 */
	public void WriteZombies() throws FileNotFoundException {

		Utils.makeDir("out/CompanyReports");

		final List<CompanyData> zombieList = new ArrayList<>();
		for (final CompanyData cd : this.companyList) {
			if (!cd.sector.equalsIgnoreCase("Financials")) {
				final String state = this.getState(cd);
				if (!state.contains("Good shape - no red flags")) {
					cd.zscore = ZombieScore.calculate(cd);
					if (cd.zscore.score > 50.0) {
						zombieList.add(cd);
					}
				}
			}
		}

		try (PrintWriter pw = new PrintWriter("out/Zombies.txt")) {

			pw.printf("Created : %s\t%s%n", Utils.getCurrentDateStr(), "This file is subject to change without notice.");
			pw.println("Pre-filtered for US companies over $5 and average trading volume of at least 100K.");

			pw.printf("%nList of tickers with Cash from Operations less than Working Capital deficit.%n");
			String str = "";
			for (final CompanyData cd : zombieList) {
				System.out.println(cd.ticker);
				if ((cd.cashData.cashFromOps.getTtm() < cd.workingCapital) && (cd.workingCapital < 0.0)) {
					str = this.addStr(cd.ticker, str);
				}
			}
			pw.println(str);

			pw.printf("%nList of tickers with Current Ratio < %.2f and paying more than %.1f%% of Sales to Interest.%n", 1.0,
			    intToSalesHWM);
			str = "";
			for (final CompanyData cd : zombieList) {
				System.out.println(cd.ticker);
				if ((cd.currentRatio < 1.0) && (cd.interestRate > intToSalesHWM)) {
					str = this.addStr(cd.ticker, str);
				}
			}
			pw.println(str);

			pw.printf(
			    "%nList of tickers with FCF + Working Capital less than 0.%n*Paid a dividend -- may need to cut dividend.%n");
			str = "";
			for (final CompanyData cd : zombieList) {
				String div = "";
				if ((cd.freeCashFlow + cd.workingCapital) < 0.0) {
					if (cd.id.dividend.getTtm() > 0.0) {
						div += "*";
					}
					str = this.addStr(cd.ticker + div, str);
				}
			}
			pw.println(str);

			pw.printf("%nList of tickers with negative Cash from Ops and Cash Flow with no Shareholder Equity.%n");
			str = "";
			for (final CompanyData cd : zombieList) {
				if ((cd.cashData.cashFromOps.getTtm() < 0.0) && (cd.bsd.equity.getMostRecent() < 0.0) && (cd.cashFlow < 0.0)) {
					str = this.addStr(cd.ticker, str);
				}
			}
			pw.println(str);

			pw.printf("%nList of tickers with big buybacks and an available cash flow deficit.%n");
			str = "";
			for (final CompanyData cd : zombieList) {

				final double sc = DerivedData.calcShareChange(cd);
				if (sc < -0.25) {
					final double fcfwc = cd.freeCashFlow + cd.workingCapital;
					if ((fcfwc < 0.0) && ((Math.abs(sc) * cd.avgPrice) > Math.abs(fcfwc))) {
						str = this.addStr(cd.ticker, str);
					}
				}
			}
			pw.println(str);

			pw.println("\nSeq : this quarter versus last quarter.");
			pw.println("QoQ : this quarter versus same quarter a year ago.");
			pw.println("YoY : last 12m versus 12m a year ago.\n\n--------------------------");

			Collections.sort(zombieList, new SortScore());

			int knt = 1;
			try (PrintWriter pwCode = new PrintWriter("out/zombie-list.txt")) {
				for (final CompanyData cd : zombieList) {

					final String state = this.getState(cd);
					pw.printf("%nRank : %d%n", knt++);
					this.printHeaderData(pw, cd);
					pw.printf("%s", state);
					pw.printf("%s%n", cd.zscore);

					if (cd.zscore.score > 80.0) {
						pwCode.printf(" $%s", cd.ticker);
					}

					if (knt > 100) {
						break;
					}
				}
			}
		}

	}

}
