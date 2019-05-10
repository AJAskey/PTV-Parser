
package net.ajaskey.market.tools.SIP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.text.WordUtils;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.misc.Debug;

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

	public final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public static List<CompanyData>	companyList	= new ArrayList<>();
	public static List<CompanyData>	buybackList	= new ArrayList<>();

	private static double	totalMarketCap	= 0.0;
	private static double	totalBuyBacks		= 0.0;
	private static double	totalNewShares	= 0.0;
	private static double	totalEps				= 0.0;

	/**
	 * net.ajaskey.market.tools.SIP.getCompany
	 *
	 * @param ticker
	 * @return
	 */
	static CompanyData getCompany(final String ticker) {

		for (final CompanyData cd : companyList) {
			if (cd.ticker.equalsIgnoreCase(ticker)) {
				return cd;
			}
		}
		return null;
	}

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {

		Debug.init("CompanyData.log");

		final double spxPrice = 0.0;

		QuarterlyData.init();

		final TotalData td = new TotalData();

		// Read last price

		// Read balance sheet
		//try (BufferedReader reader = new BufferedReader(new FileReader("data/test-bs.TXT"))) {

		CompanyData.readBsdData("data/US-STOCKS-BALANCESHEETQTR.TXT");
		CompanyData.readIdData("data/US-STOCKS-INCOMESTMTQTR.TXT");
		CompanyData.readCashData("data/US-STOCKS-CASH.TXT");
		CompanyData.readMiscData("data/US-STOCKS-MISC.TXT");

		for (final CompanyData cd : companyList) {
			cd.partOfTotalCap = cd.marketCap / totalMarketCap;
			final double te = (cd.id.epsDilCont.getMostRecent() * Math.min(0.01, cd.partOfTotalCap)) * 100.0;
			totalEps += te;
			//System.out.printf("%f\t%f\t%f%n", cd.id.eps.getMostRecent(), cd.partOfTotalCap * 100.0, te);
		}
		final double spxPE = spxPrice / totalEps;

		// Calculate statistics
		final Statistics bvpsStats = new Statistics("Book Value per Share");
		final Statistics salesStats = new Statistics("Sales");
		final Statistics epsStats = new Statistics("Earnings per Share");
		final Statistics netIncomeStats = new Statistics("Net Income");
		final Statistics inventoryStats = new Statistics("Inventory");
		final Statistics peStats = new Statistics("Price / Earnings");
		final Statistics psStats = new Statistics("Price / Sales");
		final Statistics opMarginStats = new Statistics("Operations Margin");
		final Statistics taxRateStats = new Statistics("Tax Rate");
		final Statistics interestRateStats = new Statistics("Interest Rate");
		final Statistics divYldStats = new Statistics("Dividend Yield");
		final Statistics epsYldStats = new Statistics("Earnings Yield");

		final List<Statistics> statList = new ArrayList<>();
		statList.add(bvpsStats);
		statList.add(salesStats);
		statList.add(epsStats);
		statList.add(netIncomeStats);
		statList.add(inventoryStats);
		statList.add(peStats);
		statList.add(psStats);
		statList.add(opMarginStats);
		statList.add(taxRateStats);
		statList.add(interestRateStats);
		statList.add(divYldStats);
		statList.add(epsYldStats);

		try (PrintWriter pw = new PrintWriter("data/spx-stocks.txt")) {
			for (final CompanyData cd : companyList) {
				pw.println(cd.ticker);
				//System.out.println(cd);
				td.add(cd);
				bvpsStats.addValues(cd.bsd.bvps);
				salesStats.addValues(cd.id.sales);
				epsStats.addValues(cd.id.eps);
				netIncomeStats.addValues(cd.id.netIncome);
				inventoryStats.addValues(cd.bsd.inventory);
				peStats.addValue(cd.pe);
				psStats.addValue(cd.psales);
				opMarginStats.addValue(cd.opMargin);
				taxRateStats.addValue(cd.taxRate);
				interestRateStats.addValue(cd.interestRate);
				divYldStats.addValue(cd.divYld);
				epsYldStats.addValue(cd.epsYld);
			}
		}

		td.sum();

		// output data
		try (PrintWriter pw = new PrintWriter("out/companystats.dbg")) {

			for (final CompanyData cd : companyList) {
				pw.println(cd);
			}

			pw.println(td);

			pw.println(bvpsStats);
			pw.println(salesStats);
			pw.println(epsStats);
			pw.println(netIncomeStats);
			pw.println(inventoryStats);
			pw.println(peStats);
			pw.println(psStats);
			pw.println(opMarginStats);
			pw.println(taxRateStats);
			pw.println(interestRateStats);
			pw.println(divYldStats);
			pw.println(epsYldStats);
			pw.println("Total Market Cap :" + QuarterlyData.fmt(totalMarketCap, 20));
			pw.println("Total EPS        :" + QuarterlyData.fmt(totalEps, 20));
			pw.println("SPX PE           :" + QuarterlyData.fmt(spxPE, 20));

		}

		final List<CompanyData> filteredList = new ArrayList<>();
		//		final Calendar endCal = Utils.buildCalendar(2017, Calendar.NOVEMBER, 30);
		final DateTime endDt = new DateTime(2017, DateTime.NOVEMBER, 30);
		for (final CompanyData cd : companyList) {
			final DateTime dt = new DateTime(cd.eoq);
			if (dt.isGreaterThanOrEqual(endDt)) {
				filteredList.add(cd);
			}
		}

		final Reports reports = new Reports(filteredList);
		reports.WriteBestFinancial();
		reports.WriteZombies();

		final Reports tdReport = new Reports(companyList);
		tdReport.WriteCompanyReports();

		System.out.printf("Total Buyback Estimate   :  $%sB%n", QuarterlyData.fmt(totalBuyBacks / 1000.0, 2));
		System.out.printf("Total New Share Estimate :  $%sB%n", QuarterlyData.fmt(totalNewShares / 1000.0, 2));

		try (PrintWriter pw = new PrintWriter("out/buybacks.txt")) {
			pw.println("Ticker\tShares(M)\tEst Cost(M)");
			for (final CompanyData cd : buybackList) {
				final double sc = DerivedData.calcShareChange(cd);
				final double bbest = Math.abs(sc) * cd.avgPrice;
				pw.printf("%s\t%.2f\t%.2f%n", cd.ticker, sc, bbest);
			}
		}

		final List<CompanyData> spxList = new ArrayList<>();
		for (final CompanyData cd : companyList) {
			if (cd.spIndex.equals("SP500")) {
				spxList.add(cd);
			}
		}
		System.out.println(spxList.size());
		//	WriteOptumaFiles.processData(spxList);
	}

	/**
	 * net.ajaskey.market.tools.SIP.readBsdData
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	static void readBsdData(final String fname) throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final CompanyData cd = CompanyData.setCompanyInfo(fld);
					cd.bsd = BalanceSheetData.setBalanceSheetInfo(fld);
					//System.out.println(cd.bsd);
					companyList.add(cd);
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.SIP.readCashData
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	static void readCashData(final String fname) throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.replaceAll("\"", "").trim();
				if (str.length() > 1) {

					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final String ticker = fld[0].trim();
					final CompanyData cd = CompanyData.getCompany(ticker);
					if (cd != null) {
						cd.cashData = CashData.setCashDataInfo(fld);
						//System.out.println(ticker);
						//System.out.println(cd.cashData);
					}
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.SIP.readIdData
	 *
	 * @param string
	 * @throws IOException
	 */
	static void readIdData(final String fname) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {

					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final String ticker = fld[1].trim();
					final CompanyData cd = CompanyData.getCompany(ticker);
					if (cd != null) {
						cd.id = IncomeData.setIncomeData(fld);
						//System.out.println(cd.id);
					}
				}
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.readMiscData
	 *
	 * @param fname
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readMiscData(final String fname) throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.replaceAll("\"", "").trim();
				if (str.length() > 1) {

					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final String ticker = fld[0].trim();
					final CompanyData cd = CompanyData.getCompany(ticker);
					if (cd != null) {
						cd.numEmp = (int) Double.parseDouble((fld[2].trim()));
						try {
							cd.eoq = sdf.parse(fld[3].trim());
						} catch (final ParseException e) {
							cd.eoq = null;
						}
						final String s = fld[1].trim();
						if (s.length() > 0) {
							if (s.contains("500")) {
								cd.spIndex = "SP500";
							}
							else if (s.contains("400")) {
								cd.spIndex = "SP400";
							}
							else if (s.contains("600")) {
								cd.spIndex = "SP600";
							}
						}
						cd.lastPrice = QuarterlyData.parseDouble(fld[4].trim());
						cd.avgPrice = QuarterlyData.parseDouble(fld[5].trim());
						cd.high52wk = QuarterlyData.parseDouble(fld[6].trim());
						cd.insiders = QuarterlyData.parseDouble(fld[7].trim());
						cd.inst = QuarterlyData.parseDouble(fld[8].trim());
						cd.adv = (int) QuarterlyData.parseDouble(fld[9].trim()) * 1000;
						cd.floatShares = QuarterlyData.parseDouble(fld[10].trim());
						//cd.capEx = QuarterlyData.parseDouble(fld[11].trim());
						cd.cashFlow = QuarterlyData.parseDouble(fld[12].trim());
						//cd.cashFromOps = QuarterlyData.parseDouble(fld[13].trim());
						//cd.cashFromFin = QuarterlyData.parseDouble(fld[14].trim());
						//cd.cashFromInv = QuarterlyData.parseDouble(fld[15].trim());
						cd.opInc3yrGrowth = QuarterlyData.parseDouble(fld[16].trim());
						cd.city = fld[17].trim();
						cd.state = fld[18].trim();
						//						if (cd.ticker.equalsIgnoreCase("MAXR")) {
						//							System.out.println(cd);
						//						}
						cd.shares.parse(fld);

						if (cd.adv > 0.0) {
							cd.turnover = (cd.floatShares * 1000000.0) / cd.adv;
						}

						final double shr = cd.shares.getTtm();
						if ((shr == 0.0) && (cd.id.eps.getMostRecent() != 0.0)) {
							cd.shares.q1 = Math.abs(cd.id.netIncome.getMostRecent() / cd.id.eps.getMostRecent());
						}

						cd.pe = DerivedData.calcPE(cd.id, cd.lastPrice);
						cd.psales = DerivedData.calcPSales(cd);
						cd.opMargin = DerivedData.calcOpMargin(cd.id);
						cd.netMargin = DerivedData.calcNetMargin(cd.id);
						cd.roe = DerivedData.calcRoe(cd);
						cd.taxRate = DerivedData.calcTaxRate(cd.id);
						cd.interestRate = DerivedData.calcInterestRate(cd.id);
						cd.divYld = DerivedData.calcDividendYield(cd);
						cd.epsYld = DerivedData.calcEarningsYield(cd);
						cd.ltDebtEquity = DerivedData.calcDebtToEquity(cd.bsd);
						cd.stDebtOpIncome = DerivedData.calcStDebtToOpIncome(cd);
						cd.debtCash = DerivedData.calcDebtToCash(cd.bsd);
						cd.marketCap = DerivedData.calcMarketCap(cd);
						cd.freeCashFlow = DerivedData.calcFreeCashFlow(cd);
						cd.workingCashFlow = DerivedData.calcWorkingCashFlow(cd);
						cd.sumCurrAssets = DerivedData.calcCurrAssets(cd);
						cd.sumCurrLiab = DerivedData.calcCurrLiabilities(cd);
						cd.currentRatio = DerivedData.calcCurrentRatio(cd);
						cd.workingCapital = DerivedData.calcWorkingCapital(cd);
						cd.netCashFlow = DerivedData.calcNetCashFlow(cd);
						cd.totalCashFlow = DerivedData.calcTotalCashFlow(cd);

						cd.pricePercOff52High = DerivedData.calc52weekHighPercent(cd);

						//cd.zd.calc(cd);

						if (cd.spIndex.equals("SP500")) {
							final double sc = DerivedData.calcShareChange(cd);
							final double bbest = Math.abs(sc) * cd.avgPrice;
							if (sc < 0.0) {
								totalBuyBacks += bbest;
								buybackList.add(cd);
							}
							else {
								totalNewShares += bbest;
							}
						}

						totalMarketCap += cd.marketCap;
					}
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.SIP.setCompanyInfo
	 *
	 * @param fld
	 */
	private static CompanyData setCompanyInfo(final String[] fld) {

		final CompanyData cd = new CompanyData();
		cd.name = fld[0].trim();
		cd.ticker = fld[1].trim();
		cd.exchange = fld[2].trim();
		cd.sector = CompanyData.setSecInd(fld[3].trim());
		final String s = CompanyData.setSecInd(fld[4].trim());
		cd.industry = WordUtils.capitalizeFully(s);
		return cd;

	}

	/**
	 * net.ajaskey.market.tools.SIP.setSecInd
	 *
	 * @param string
	 * @return
	 */
	private static String setSecInd(final String secind) {

		String ret = "";
		final String str = secind.trim();
		final int pos = secind.indexOf(" - ");
		if (pos > 0) {
			ret = str.substring(pos + 3, str.length()).trim();
		}
		else {
			ret = str;
		}
		return ret;
	}

	// from data
	public String	name;
	public String	city;
	public String	state;
	public String	ticker;
	public String	exchange;
	public String	sector;
	public String	industry;
	public String	spIndex;
	public int		numEmp;
	public Date		eoq;
	public double	insiders;
	public double	inst;
	public int		adv;
	public double	turnover;
	public double	floatShares;
	public double	opInc3yrGrowth;
	//public double					capEx;
	public double cashFlow;
	//	public double					cashFromOps;
	//	public double					cashFromFin;
	//	public double					cashFromInv;
	public QuarterlyData shares;

	// aggregate data
	public BalanceSheetData	bsd;
	public IncomeData				id;
	public CashData					cashData;

	public double	lastPrice;
	public double	avgPrice;
	public double	pricePercOff52High;

	// derived data
	public double	pe;
	public double	psales;
	public double	opMargin;
	public double	netMargin;
	public double	roe;
	public double	taxRate;
	public double	interestRate;
	public double	divYld;
	public double	epsYld;

	public double	freeCashFlow;
	public double	workingCashFlow;
	public double	ltDebtEquity;
	public double	stDebtOpIncome;
	public double	debtCash;
	public double	marketCap;
	public double	partOfTotalCap;

	public double	sumCurrAssets;
	public double	sumCurrLiab;
	public double	currentRatio;
	public double	workingCapital;
	public double	netCashFlow;
	public double	totalCashFlow;

	public double high52wk;

	public ZombieScore zscore;

	//public ZombieData zd;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public CompanyData() {

		this.name = "";
		this.city = "";
		this.state = "";
		this.ticker = "";
		this.exchange = "";
		this.sector = "";
		this.industry = "";
		this.spIndex = "";
		this.numEmp = 0;
		this.insiders = 0.0;
		this.inst = 0.0;
		this.turnover = 0.0;
		this.adv = 0;
		this.eoq = null;
		this.floatShares = 0.0;
		this.opInc3yrGrowth = 0.0;
		this.cashFlow = 0.0;
		//		this.capEx = 0.0;
		//		this.cashFromOps = 0.0;
		//		this.cashFromFin = 0.0;
		//		this.cashFromInv = 0.0;
		this.shares = new QuarterlyData("shares");

		this.lastPrice = 0.0;
		this.avgPrice = 0.0;
		this.pricePercOff52High = 0.0;
		this.pe = 0.0;
		this.psales = 0.0;
		this.opMargin = 0.0;
		this.netMargin = 0.0;
		this.roe = 0.0;
		this.taxRate = 0.0;
		this.interestRate = 0.0;
		this.divYld = 0.0;
		this.epsYld = 0.0;
		this.freeCashFlow = 0.0;
		this.workingCashFlow = 0.0;
		this.ltDebtEquity = 0.0;
		this.stDebtOpIncome = 0.0;
		this.debtCash = 0.0;
		this.marketCap = 0.0;
		this.partOfTotalCap = 0.0;

		this.sumCurrAssets = 0.0;
		this.sumCurrLiab = 0.0;
		this.currentRatio = 0.0;
		this.workingCapital = 0.0;
		this.netCashFlow = 0.0;
		this.totalCashFlow = 0.0;

		this.high52wk = 0.0;

		//this.zd = new ZombieData();

	}

	/**
	 * This method serves as a constructor for the class. Used for test setup.
	 *
	 * @param string
	 */
	public CompanyData(final String code) {

		this.ticker = code;
		this.shares = new QuarterlyData("shares");
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
		ret += TAB + "Number Employees  : " + String.format("%15d", this.numEmp) + NL;
		try {
			ret += TAB + "End of Quarter    : " + String.format("%15s", sdf.format(this.eoq)) + NL;
		} catch (final Exception e) {
			ret += TAB + "End of Quarter    : ERROR" + NL;
		}
		ret += TAB + "Insiders Own      : " + QuarterlyData.fmt(this.insiders) + NL;
		ret += TAB + "Float             : " + QuarterlyData.fmt(this.floatShares) + NL;
		ret += TAB + "Outstanding       : " + QuarterlyData.fmt(this.shares.getMostRecent()) + NL;
		ret += TAB + "Market Cap        : " + QuarterlyData.fmt(this.marketCap)
		    + String.format("  %s", String.format("(%3.5f%%)", (this.partOfTotalCap * 100.0))) + NL;

		ret += TAB + "Last Price        : " + QuarterlyData.fmt(this.lastPrice) + NL;
		ret += TAB + "Average Price     : " + QuarterlyData.fmt(this.avgPrice) + NL;
		ret += TAB + "PE                : " + QuarterlyData.fmt(this.pe) + NL;
		ret += TAB + "Price/Sales       : " + QuarterlyData.fmt(this.psales) + NL;
		ret += TAB + "Op Margin         : " + QuarterlyData.fmt(this.opMargin) + NL;
		ret += TAB + "Net Margin        : " + QuarterlyData.fmt(this.netMargin) + NL;
		ret += TAB + "ROE               : " + QuarterlyData.fmt(this.roe) + NL;
		ret += TAB + "Tax Rate          : " + QuarterlyData.fmt(this.taxRate) + NL;
		ret += TAB + "Interest Rate     : " + QuarterlyData.fmt(this.interestRate) + NL;
		ret += TAB + "Dividend Yield    : " + QuarterlyData.fmt(this.divYld) + NL;
		ret += TAB + "Earnings Yield    : " + QuarterlyData.fmt(this.epsYld) + NL;
		ret += TAB + "LT Debt to Equity : " + QuarterlyData.fmt(this.ltDebtEquity) + NL;
		ret += TAB + "ST Debt to OpInc  : " + QuarterlyData.fmt(this.stDebtOpIncome) + NL;
		ret += TAB + "Debt to Cash      : " + QuarterlyData.fmt(this.debtCash) + NL;
		ret += this.bsd;
		ret += this.id;
		//ret += this.zd;

		return ret;
	}

}
