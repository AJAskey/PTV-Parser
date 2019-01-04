
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

		try (PrintWriter pw = new PrintWriter("out/Zombies.txt"); PrintWriter zpw = new PrintWriter("out/zCompanies.txt")) {

			for (final CompanyData cd : this.companyList) {
				//		if (cd.zd.zIsZombie || cd.zd.zState == ZombieStates.NNET_NINC_DIVCUT
				//		    || cd.zd.zState == ZombieStates.NNET_PINC_DIVCUT || cd.zd.zState == ZombieStates.PNET_NINC_DIVCUT) {
				//String rpt = "";// cd.zd.zStatus();

				if (cd.ticker.equalsIgnoreCase("QTNT")) {
					System.out.println(cd.zd);
				}
				if (!cd.sector.equalsIgnoreCase("Financials")) {
					this.printZombieData(pw, cd);
				}

				//	}
				//cd.zd.report(cd.ticker, cd.sector);
				//				if (rpt.length() > 0) {
				//					zpw.println("");
				//					this.printData(zpw, cd);
				//					zpw.println(rpt);
				//				}
			}
			System.out.println("Zombie Count : " + ZombieData.zKnt);
			System.out.println(ZombieData.zStr);
		}

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

	private void printHeaderData(PrintWriter pw, CompanyData cd) {

		pw.println(cd.ticker);
		pw.printf("\t%s%n", cd.name);
		pw.printf("\t%s, %s%n", cd.sector, cd.industry);
		//pw.printf("\t%s%n", cd.industry);
		String sNumEmp = String.format("%,d", cd.numEmp);
		pw.printf("\tEmployees: %s%n", sNumEmp);

		pw.printf("%n\tShares        : %s M\t(Seq= %s%% : YoY= %s%%)%n", QuarterlyData.fmt(cd.shares.getMostRecent(), 15),
		    QuarterlyData.fmt(cd.shares.dd.seqGrowth, 7), QuarterlyData.fmt(cd.shares.dd.qoqGrowth, 7));
		pw.printf("\tMarket Cap    : %s M%n", QuarterlyData.fmt(cd.marketCap, 15));
		pw.printf("\tEquity        : %s M%n", QuarterlyData.fmt(cd.bsd.equity.getMostRecent(), 15));
		pw.printf("\tBVPS          : %s%n", QuarterlyData.fmt(cd.bsd.bvps.getMostRecent(), 15));

		pw.printf("%n\tLast Price    : %s%n", QuarterlyData.fmt(cd.lastPrice, 15));
		pw.printf("\tPE            : %s%n", QuarterlyData.fmt(cd.pe, 15));
		pw.printf("\tPS            : %s%n", QuarterlyData.fmt(cd.psales, 15));
		pw.printf("\tOp Margin     : %s%n", QuarterlyData.fmt(cd.opMargin, 15));
		pw.printf("\tNet Margin    : %s%n", QuarterlyData.fmt(cd.netMargin, 15));
		pw.printf("\tROE           : %s%n", QuarterlyData.fmt(cd.roe, 15));

	}

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
		String s1 = QuarterlyData.fmt(q1, 15);
		String s2 = QuarterlyData.fmt(q2, 15);
		String s3 = QuarterlyData.fmt(q3, 15);
		String s4 = QuarterlyData.fmt(q4, 15);
		pw.printf("\t  %-15s: %s %s %s %s%n", heading, s1, s2, s3, s4);
	}

	private void print1QtrData(PrintWriter pw, double q1, String heading) {

		String s1 = QuarterlyData.fmt(q1, 15);
		pw.printf("\t  %-15s: %s%n", heading, s1);
	}

	private void printZombieData(PrintWriter pw, CompanyData cd) {

		if (cd.ticker.equalsIgnoreCase("abc")) {
			System.out.println(cd.ticker);
		}

		switch (cd.zd.zState) {
			//			case PNET_PINC:
			//			case NNET_PINC_DIVCUT:
			//			case NNET_NINC_DIVCUT:
			//			case PNET_NINC_ENUFCASH:
			//			case UNKNOWN:
			//				return;
			default:

				pw.println("");
				this.printHeaderData(pw, cd);

				pw.printf("\tLT Debt       : %s M\t(Seq= %s%% : YoY= %s%%)%n",
				    QuarterlyData.fmt(cd.bsd.ltDebt.getMostRecent(), 15), QuarterlyData.fmt(cd.bsd.ltDebt.dd.seqGrowth, 7),
				    QuarterlyData.fmt(cd.bsd.ltDebt.dd.qoqGrowth, 7));

				pw.printf("%n\tZombie Cash      : %s%n", QuarterlyData.fmt(cd.zd.zCash, 15));
				print1QtrData(pw, cd.bsd.cash.getMostRecent(), "Cash");
				String str = String.format("%d%% AcctRx", (int) (ZombieData.arKnob * 100.0));
				print1QtrData(pw, (cd.bsd.acctReceiveable.getMostRecent() * ZombieData.arKnob), str);

				str = String.format("%d%% ST Invest", (int) (ZombieData.stInvestmentsKnob * 100.0));
				print1QtrData(pw, (cd.bsd.stInvestments.getMostRecent() * ZombieData.stInvestmentsKnob), str);

				//System.out.printf("%s\t%.2f\t%.2f%n", cd.ticker, cd.bsd.stInvestments.getMostRecent(),
				//    (cd.bsd.stInvestments.getMostRecent() * ZombieData.stInvestmentsKnob));

				str = String.format("%d%% ST Assets", (int) (ZombieData.stAssetsKnob * 100.0));
				print1QtrData(pw, (cd.bsd.otherAssets.getMostRecent() * ZombieData.stAssetsKnob), str);

				str = String.format("%d%% Inventory", (int) (ZombieData.inventoryKnob * 100.0));
				print1QtrData(pw, (cd.bsd.inventory.getMostRecent() * ZombieData.inventoryKnob), str);

				str = String.format("%d%% LT Invest", (int) (ZombieData.ltInvestmentsKnob * 100.0));
				print1QtrData(pw, (cd.bsd.ltInvestments.getMostRecent() * ZombieData.ltAssetsKnob), str);

				str = String.format("%d%% LT Assets", (int) (ZombieData.ltAssetsKnob * 100.0));
				print1QtrData(pw, (cd.bsd.otherLtAssets.getMostRecent() * ZombieData.ltAssetsKnob), str);

				str = String.format("%d%% Goodwill", (int) (ZombieData.gwKnob * 100.0));
				print1QtrData(pw, (cd.bsd.goodwill.getMostRecent() * ZombieData.gwKnob), str);

				pw.printf("\tZombie Debt      : %s%n", QuarterlyData.fmt(cd.zd.zDebt, 15));
				print1QtrData(pw, cd.bsd.acctPayable.getMostRecent(), "Acct Payable");
				print1QtrData(pw, cd.bsd.stDebt.getMostRecent(), "ST Debt");
				print1QtrData(pw, cd.bsd.otherCurrLiab.getMostRecent(), "Other ST Liab");

				pw.printf("\t*Net Cash        : %s\t[Zombie Cash minus Zombie Debt]%n", QuarterlyData.fmt(cd.zd.zNet, 15));

				pw.printf("\t*Zombie Income   : %s\t[Average PreTax Income w/o Unusual Expenses]%n",
				    QuarterlyData.fmt(cd.zd.zIncome, 15));
				print4QtrData(pw, (cd.id.pretaxIncome), "4Q Pretax");
				print4QtrData(pw, (cd.id.unusualIncome), "4Q Unusual Exp");
				//				double avgpre = cd.id.pretaxIncome.q1 + cd.id.pretaxIncome.q2 + cd.id.pretaxIncome.q3 + cd.id.pretaxIncome.q4;
				//				if (Math.abs(cd.id.pretaxIncome.q1) == 0.0) {
				//					avgpre += cd.id.pretaxIncome.q5;
				//				}
				//				avgpre /= 4.0;
				print1QtrData(pw, cd.zd.zIncome, "Avg Pretax");

				pw.printf("\t*Zombie Score    : %s%n", QuarterlyData.fmt(cd.zd.zScore, 15));
				print1QtrData(pw, cd.zd.zDividend, "Dividends");
				pw.printf("\tAdj Income       : %s  [Income with Dividends Added Back In]%n",
				    QuarterlyData.fmt(cd.zd.zAdjInc, 15));
				pw.printf("\t*Ops Cost / Qtr  : %s  [%.2f/8.0 + %.2f]%n", QuarterlyData.fmt(cd.zd.zKeepItRunning, 15),
				    cd.zd.zDebt, Math.abs(cd.zd.zIncome));
				pw.printf("\t*Zombie Adj Scr  : %s%n", QuarterlyData.fmt(cd.zd.zAdjScr, 15));
				pw.printf("\tZombie State     : %15s%n", cd.zd.zState);

				String rpt = cd.zd.zStatus();
				if (rpt.length() > 0) pw.println(rpt);
				if (cd.zd.zIsZombie) {
					pw.printf("\t%s Is Zombie!%n", cd.ticker);
					if (cd.zd.zAdjScr < 4.0) pw.println("\tDead Zombie!");
				}
		}
	}

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
