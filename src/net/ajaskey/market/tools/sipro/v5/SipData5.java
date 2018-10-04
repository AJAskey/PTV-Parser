
package net.ajaskey.market.tools.sipro.v5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.misc.Zip;
import net.ajaskey.market.ta.input.LongTermOHLCV;
import net.ajaskey.market.tools.optuma.OptumaCommon;
import net.ajaskey.market.tools.sipro.v5.DateSet;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SipData5 {

	public static List<DataSet5>	sales						= new ArrayList<>();
	public static List<DataSet5>	ebit						= new ArrayList<>();
	public static List<DataSet5>	taxes						= new ArrayList<>();
	public static List<DataSet5>	incomeEps				= new ArrayList<>();
	public static List<DataSet5>	cashOps					= new ArrayList<>();
	public static List<DataSet5>	cashFin					= new ArrayList<>();
	public static List<DataSet5>	cashInv					= new ArrayList<>();
	public static List<DataSet5>	dividend				= new ArrayList<>();
	public static List<DataSet5>	shares					= new ArrayList<>();
	public static List<DataSet5>	cash						= new ArrayList<>();
	public static List<DataSet5>	assets					= new ArrayList<>();
	public static List<DataSet5>	liabilities			= new ArrayList<>();
	public static List<DataSet5>	accTx						= new ArrayList<>();
	public static List<DataSet5>	accRx						= new ArrayList<>();
	public static List<DataSet5>	goodwill				= new ArrayList<>();
	public static List<DataSet5>	ltDebt					= new ArrayList<>();
	public static List<DataSet5>	capEx						= new ArrayList<>();
	public static List<DataSet5>	equity					= new ArrayList<>();
	public static List<DataSet5>	interest				= new ArrayList<>();
	public static List<DataSet5>	resDev					= new ArrayList<>();
	public static List<DataSet5>	bookValue				= new ArrayList<>();
	public static List<DataSet5>	inventoryValue	= new ArrayList<>();
	public static List<DataSet5>	enterpriseValue	= new ArrayList<>();
	public static List<DataSet5>	prices					= new ArrayList<>();
	public static List<DataSet5>	fcf							= new ArrayList<>();

	public static List<DataSet5> eps = new ArrayList<>();

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	public static List<LongTermOHLCV> indexPrices = null;

	private static int companyKnt = 0;

	static String path = OptumaCommon.optumaPath + "SIP\\";

	/**
	 * net.ajaskey.market.tools.sipro.v4.archiveData
	 *
	 */
	private static void archiveData(Calendar latest) {

		final List<String> dir = new ArrayList<>();
		dir.add(path);
		final List<String> fil = new ArrayList<>();
		fil.add("data\\SP-Stocks.txt");
		fil.add("data\\SP-Stocks-B.txt");

		final String fname = "SIP-" + Utils.stringDate(latest) + "_" + Utils.stringDate(Calendar.getInstance()) + ".zip";
		Zip.create(dir, fil, "archive", fname);

	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		SipData5.readDataFile_1("data/SP-STOCKS.txt");
		final Calendar latest = SipData5.readDataFile_2("data/SP-STOCKS-B.txt");

		System.out.println(Utils.stringDate(latest));

		SipData5.processData("500");
		SipData5.processData("MidCap 400");
		SipData5.processData("SmallCap 600");

		SipData5.processSector("500", "06  - Energy");
		SipData5.processSector("500", "10  - Technology");

		SipData5.archiveData(latest);

	}

	/**
	 * net.ajaskey.market.tools.sipro.v5.processSector
	 *
	 * @param string
	 * @param string2
	 * @throws FileNotFoundException
	 */
	private static void processSector(String index, String sector) throws FileNotFoundException {

		final DataSet5 totSales = DataSet5.sum(SipData5.sales, index, sector);
		final DataSet5 totTax = DataSet5.sum(SipData5.taxes, index, sector);
		final DataSet5 totIncome = DataSet5.sum(SipData5.incomeEps, index, sector);
		final DataSet5 totCops = DataSet5.sum(SipData5.cashOps, index, sector);
		final DataSet5 totShr = DataSet5.sum(SipData5.shares, index, sector);
		final DataSet5 totCash = DataSet5.sum(SipData5.cash, index, sector);
		final DataSet5 totAssets = DataSet5.sum(SipData5.assets, index, sector);
		final DataSet5 totLiab = DataSet5.sum(SipData5.liabilities, index, sector);
		final DataSet5 totAccRx = DataSet5.sum(SipData5.accRx, index, sector);
		final DataSet5 totAccTx = DataSet5.sum(SipData5.accTx, index, sector);
		final DataSet5 totGoodwill = DataSet5.sum(SipData5.goodwill, index, sector);
		final DataSet5 totLtDebt = DataSet5.sum(SipData5.ltDebt, index, sector);
		final DataSet5 totCapEx = DataSet5.sum(SipData5.capEx, index, sector);
		final DataSet5 totEquity = DataSet5.sum(SipData5.equity, index, sector);
		final DataSet5 totInterest = DataSet5.sum(SipData5.interest, index, sector);
		final DataSet5 totResDev = DataSet5.sum(SipData5.resDev, index, sector);
		final DataSet5 totInventory = DataSet5.sum(SipData5.inventoryValue, index, sector);
		final DataSet5 totEnterprise = DataSet5.sum(SipData5.enterpriseValue, index, sector);
		final DataSet5 totFcf = DataSet5.sum(SipData5.fcf, index, sector);

		String sec = sector.replaceAll("[^A-Za-z]", "");
		String prefix = "";
		if (index.equalsIgnoreCase("500")) {
			prefix = "SPX_" + sec;
		} else if (index.equalsIgnoreCase("MidCap 400")) {
			prefix = "SP400_" + sec;
		} else if (index.equalsIgnoreCase("SmallCap 600")) {
			prefix = "SP600_" + sec;
		} else {
			return;
		}

		final DateSet dates = new DateSet(SipData5.indexPrices);
		//final DataSet5 dsPrices = new DataSet5(dates, prefix);

		final List<DataSet5> divDollar = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.dividend.get(i), SipData5.shares.get(i));
			divDollar.add(ds);
		}
		final DataSet5 totDivDollar = DataSet5.sum(divDollar, index);

		final List<DataSet5> bvDollar = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.bookValue.get(i), SipData5.shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet5 totBvDollar = DataSet5.sum(bvDollar, index);

		final DataSet5 totBVminusGW = DataSet5.sub(totBvDollar, totGoodwill);

		final List<DataSet5> mcap = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.prices.get(i), SipData5.shares.get(i));
			mcap.add(ds);
		}
		final DataSet5 totMktCap = DataSet5.sum(mcap, index);
		totMktCap.mode = DataSet5.dMode.SEQUENTIAL;

		SipData5.write(totSales, prefix + " Sales", dates, false);
		SipData5.write(totTax, prefix + " Taxes", dates, false);
		SipData5.write(totCops, prefix + " Cash from Operations", dates, false);
		SipData5.write(totDivDollar, prefix + " Dividends", dates, false);
		SipData5.write(totShr, prefix + " Shares", dates, false);
		SipData5.write(totCash, prefix + " Cash", dates, false);
		SipData5.write(totAssets, prefix + " Assets", dates, false);
		SipData5.write(totLiab, prefix + " Liabilities", dates, false);
		SipData5.write(totAccRx, prefix + " Accounts Receivable", dates, false);
		SipData5.write(totAccTx, prefix + " Accounts Payable", dates, false);
		SipData5.write(totGoodwill, prefix + " Goodwill", dates, false);
		SipData5.write(totLtDebt, prefix + " LT Debt", dates, false);
		SipData5.write(totCapEx, prefix + " CapEx", dates, false);
		SipData5.write(totEquity, prefix + " Common Equity", dates, false);
		SipData5.write(totInterest, prefix + " Interest Paid", dates, false);
		SipData5.write(totResDev, prefix + " Research and Development", dates, false);
		SipData5.write(totBvDollar, prefix + " Book Value", dates, false);
		SipData5.write(totBVminusGW, prefix + " Book Value less Goodwill", dates, false);
		SipData5.write(totMktCap, prefix + " Market Cap", dates, false);
		SipData5.write(totInventory, prefix + " Inventory", dates, false);
		SipData5.write(totEnterprise, prefix + " Enterprise", dates, false);
		SipData5.write(totFcf, prefix + " FCFps", dates, false);

		//-----------------------------------------

		//		final DataSet5 totMktCapShr = DataSet5.ratio(totMktCap, totShr);
		//		SipData5.write(totMktCapShr, prefix + " Market Cap to Shares v4", dates, false);
		//
		//		final DataSet5 totMargin = DataSet5.scale(DataSet5.ratio(totIncome, totSales), 100.0);
		//		SipData5.write(totMargin, prefix + " Margin v4", dates, false);
		//
		//		final DataSet5 totROE = DataSet5.scale(DataSet5.ratio(totIncome, totEquity), 100.0);
		//		SipData5.write(totROE, prefix + " ROE v4", dates, false);
		//
		//		final DataSet5 totTaxMargin = DataSet5.scale(DataSet5.ratio(totTax, totSales), 100.0);
		//		SipData5.write(totTaxMargin, prefix + " Tax Margin v4", dates, false);
		//
		//		final DataSet5 totBVtoCap = DataSet5.scale(DataSet5.ratio(totBvDollar, totMktCap), 100.0);
		//		SipData5.write(totBVtoCap, prefix + " BV over Market Cap v4", dates, false);
		//
		//		final DataSet5 totBVmGWtoCap = DataSet5.scale(DataSet5.ratio(totBVminusGW, totMktCap), 100.0);
		//		SipData5.write(totBVmGWtoCap, prefix + " BV Minus Goodwill over Market Cap v4", dates, false);
		//
		//		final DataSet5 totGWtoAsset = DataSet5.scale(DataSet5.ratio(totGoodwill, totAssets), 100.0);
		//		SipData5.write(totGWtoAsset, prefix + " Goodwill over Assets v4", dates, false);
		//
		//		SipData5.writePriceToDate(dates, totSales, prefix + " Price to Sales v4", 100000000000.0);
		//		SipData5.writePriceToDate(dates, totIncome, prefix + " Price to Income v4", 10000000000.0);
		//		SipData5.writePriceToDate(dates, totCash, prefix + " Price to Cash v4", 10000000000.0);
		//		SipData5.writePriceToDate(dates, totBvDollar, prefix + " Price to BV v4", 100000000000.0);
		//
		//		SipData5.writeEps(totIncome, totShr, prefix + " EPS v4", prefix + " EPS Annual v4", prefix + " PE v4", dates,
		//		    dsPrices);

	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.processData
	 *
	 * @param index
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void processData(String index) throws FileNotFoundException, IOException, ParseException {

		final DataSet5 totSales = DataSet5.sum(SipData5.sales, index);
		final DataSet5 totEbit = DataSet5.sum(SipData5.ebit, index);
		final DataSet5 totTax = DataSet5.sum(SipData5.taxes, index);
		final DataSet5 totIncome = DataSet5.sum(SipData5.incomeEps, index);
		final DataSet5 totCops = DataSet5.sum(SipData5.cashOps, index);
		final DataSet5 totCfin = DataSet5.sum(SipData5.cashFin, index);
		final DataSet5 totCinv = DataSet5.sum(SipData5.cashInv, index);
		final DataSet5 totShr = DataSet5.sum(SipData5.shares, index);
		final DataSet5 totCash = DataSet5.sum(SipData5.cash, index);
		final DataSet5 totAssets = DataSet5.sum(SipData5.assets, index);
		final DataSet5 totLiab = DataSet5.sum(SipData5.liabilities, index);
		final DataSet5 totAccRx = DataSet5.sum(SipData5.accRx, index);
		final DataSet5 totAccTx = DataSet5.sum(SipData5.accTx, index);
		final DataSet5 totGoodwill = DataSet5.sum(SipData5.goodwill, index);
		final DataSet5 totLtDebt = DataSet5.sum(SipData5.ltDebt, index);
		final DataSet5 totCapEx = DataSet5.sum(SipData5.capEx, index);
		final DataSet5 totEquity = DataSet5.sum(SipData5.equity, index);
		final DataSet5 totInterest = DataSet5.sum(SipData5.interest, index);
		final DataSet5 totResDev = DataSet5.sum(SipData5.resDev, index);
		final DataSet5 totInventory = DataSet5.sum(SipData5.inventoryValue, index);
		final DataSet5 totEnterprise = DataSet5.sum(SipData5.enterpriseValue, index);
		final DataSet5 totFcf = DataSet5.sum(SipData5.fcf, index);

		String prefix = "";

		if (index.equalsIgnoreCase("500")) {
			SipData5.indexPrices = LongTermOHLCV.getData("SP500");
			prefix = "SPX";
		} else if (index.equalsIgnoreCase("MidCap 400")) {
			SipData5.indexPrices = LongTermOHLCV.getData("SP400");
			prefix = "SP400";
		} else if (index.equalsIgnoreCase("SmallCap 600")) {
			SipData5.indexPrices = LongTermOHLCV.getData("SP600");
			prefix = "SP600";
		} else {
			return;
		}

		final DateSet dates = new DateSet(SipData5.indexPrices);
		final DataSet5 dsPrices = new DataSet5(dates, prefix);

		final List<DataSet5> divDollar = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.dividend.get(i), SipData5.shares.get(i));
			divDollar.add(ds);
		}
		final DataSet5 totDivDollar = DataSet5.sum(divDollar, index);

		final List<DataSet5> bvDollar = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.bookValue.get(i), SipData5.shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet5 totBvDollar = DataSet5.sum(bvDollar, index);

		final DataSet5 totBVminusGW = DataSet5.sub(totBvDollar, totGoodwill);

		final List<DataSet5> mcap = new ArrayList<>();
		for (int i = 0; i < SipData5.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipData5.prices.get(i), SipData5.shares.get(i));
			mcap.add(ds);
		}
		final DataSet5 totMktCap = DataSet5.sum(mcap, index);
		totMktCap.mode = DataSet5.dMode.SEQUENTIAL;

		SipData5.write(totSales, prefix + " Sales v4", dates, false);
		SipData5.write(totEbit, prefix + " EBIT v4", dates, false);
		SipData5.write(totTax, prefix + " Taxes v4", dates, false);
		SipData5.write(totIncome, prefix + " Income for EPS v4", dates, false);
		SipData5.write(totCops, prefix + " Cash from Operations v4", dates, false);
		SipData5.write(totCfin, prefix + " Cash from Financing v4", dates, false);
		SipData5.write(totCinv, prefix + " Cash from Investing v4", dates, false);
		SipData5.write(totDivDollar, prefix + " Dividends v4", dates, false);
		SipData5.write(totShr, prefix + " Shares v4", dates, false);
		SipData5.write(totCash, prefix + " Cash v4", dates, false);
		SipData5.write(totAssets, prefix + " Assets v4", dates, false);
		SipData5.write(totLiab, prefix + " Liabilities v4", dates, false);
		SipData5.write(totAccRx, prefix + " Accounts Receivable v4", dates, false);
		SipData5.write(totAccTx, prefix + " Accounts Payable v4", dates, false);
		SipData5.write(totGoodwill, prefix + " Goodwill v4", dates, false);
		SipData5.write(totLtDebt, prefix + " LT Debt v4", dates, false);
		SipData5.write(totCapEx, prefix + " CapEx v4", dates, false);
		SipData5.write(totEquity, prefix + " Common Equity v4", dates, false);
		SipData5.write(totInterest, prefix + " Interest Paid v4", dates, false);
		SipData5.write(totResDev, prefix + " Research and Development v4", dates, false);
		SipData5.write(totBvDollar, prefix + " Book Value v4", dates, false);
		SipData5.write(totBVminusGW, prefix + " Book Value less Goodwill v4", dates, false);
		SipData5.write(totMktCap, prefix + " Market Cap v4", dates, false);
		SipData5.write(totInventory, prefix + " Inventory v4", dates, false);
		SipData5.write(totEnterprise, prefix + " Enterprise v4", dates, false);
		SipData5.write(totFcf, prefix + " FCFps v4", dates, false);

		//-----------------------------------------

		final DataSet5 totMktCapShr = DataSet5.ratio(totMktCap, totShr);
		SipData5.write(totMktCapShr, prefix + " Market Cap to Shares v4", dates, false);

		final DataSet5 totMargin = DataSet5.scale(DataSet5.ratio(totIncome, totSales), 100.0);
		SipData5.write(totMargin, prefix + " Margin v4", dates, false);

		final DataSet5 totROE = DataSet5.scale(DataSet5.ratio(totIncome, totEquity), 100.0);
		SipData5.write(totROE, prefix + " ROE v4", dates, false);

		final DataSet5 totTaxMargin = DataSet5.scale(DataSet5.ratio(totTax, totSales), 100.0);
		SipData5.write(totTaxMargin, prefix + " Tax Margin v4", dates, false);

		final DataSet5 totBVtoCap = DataSet5.scale(DataSet5.ratio(totBvDollar, totMktCap), 100.0);
		SipData5.write(totBVtoCap, prefix + " BV over Market Cap v4", dates, false);

		final DataSet5 totBVmGWtoCap = DataSet5.scale(DataSet5.ratio(totBVminusGW, totMktCap), 100.0);
		SipData5.write(totBVmGWtoCap, prefix + " BV Minus Goodwill over Market Cap v4", dates, false);

		final DataSet5 totGWtoAsset = DataSet5.scale(DataSet5.ratio(totGoodwill, totAssets), 100.0);
		SipData5.write(totGWtoAsset, prefix + " Goodwill over Assets v4", dates, false);

		SipData5.writePriceToDate(dates, totSales, prefix + " Price to Sales v4", 100000000000.0);
		SipData5.writePriceToDate(dates, totIncome, prefix + " Price to Income v4", 10000000000.0);
		SipData5.writePriceToDate(dates, totCash, prefix + " Price to Cash v4", 10000000000.0);
		SipData5.writePriceToDate(dates, totBvDollar, prefix + " Price to BV v4", 100000000000.0);

		SipData5.writeEps(totIncome, totShr, prefix + " EPS v4", prefix + " EPS Annual v4", prefix + " PE v4", dates,
		    dsPrices);

	}

	/**
	 * 
	 * net.ajaskey.market.tools.sipro.v5.writeEps
	 *
	 * @param totIncome
	 * @param totShr
	 * @param epsStr
	 * @param epsannualStr
	 * @param peStr
	 * @param dates
	 * @param dsPrices
	 * @throws FileNotFoundException
	 */
	private static void writeEps(DataSet5 totIncome, DataSet5 totShr, String epsStr, String epsannualStr, String peStr,
	    DateSet dates, DataSet5 dsPrices) throws FileNotFoundException {

		final DataSet5 totEps = DataSet5.scale(DataSet5.div(totIncome, totShr), 40.0);
		SipData5.write(totEps, epsStr, dates, false);

		//		totEps.mode = DataSet5.dMode.SEQUENTIAL;
		//		SipData5.write(totEps, epsannualStr, dates, false);

		//		final DataSet5 totPE = DataSet5.scale(DataSet5.div(dsPrices, totEps), 1.0);
		//		totPE.mode = DataSet5.dMode.SEQUENTIAL;
		//		SipData5.write(totPE, peStr, dates, false);

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void readDataFile_1(String filename) throws FileNotFoundException, IOException {

		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			System.out.println("Reading file : " + filename);

			String line = "";

			//line = br.readLine(); // read header
			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0) && (!line.contains("BRK.A"))) {

					knt++;
					sc.reset();

					SipData5.sales.add(sc.getData5("sales", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.ebit.add(sc.getData5("ebit", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.taxes.add(sc.getData5("taxes", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.incomeEps.add(sc.getData5("incomeEps", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.cashOps.add(sc.getData5("cashOps", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.cashInv.add(sc.getData5("cashInv", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.cashFin.add(sc.getData5("cashFin", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));

					SipData5.dividend.add(sc.getData5("dividend", line, DataSet5.dMode.ACCUMULATION, 1.0));

					SipData5.capEx.add(sc.getData5("capEx", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					final DataSet5 s = sc.getData5("shares", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION);
					SipData5.shares.add(s);

					SipData5.cash.add(sc.getData5("cash", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.assets.add(sc.getData5("assets", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.liabilities.add(sc.getData5("liabilities", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.accRx.add(sc.getData5("Accounts Receivable", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.accTx.add(sc.getData5("Accounts Payable", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.goodwill.add(sc.getData5("Goodwill", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.ltDebt.add(sc.getData5("LT Debt", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
				}
			}
		}
		SipData5.companyKnt = knt;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.readDataFile_2
	 *
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Calendar readDataFile_2(String filename) throws FileNotFoundException, IOException {

		final Calendar latestDate = Calendar.getInstance();
		latestDate.add(Calendar.YEAR, -5);

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0) && (!line.contains("BRK.A"))) {

					sc.reset();

					SipData5.equity.add(sc.getData5("Common Equity", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData5.interest.add(sc.getData5("interest", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.resDev.add(sc.getData5("R and D", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData5.bookValue.add(sc.getData5("Book Value per Share", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipData5.inventoryValue.add(sc.getData5("Inventory", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipData5.enterpriseValue.add(sc.getData5("Enterprice", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipData5.prices.add(sc.getData5("Prices", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipData5.fcf.add(sc.getData5("FCF", line, DataSet5.dMode.SEQUENTIAL, 1.0));

					try {
						final Calendar date = sc.getDate(line);
						if (date.after(latestDate)) {
							latestDate.setTime(date.getTime());
						}
					} catch (final ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return latestDate;
	}

	private static double[] sumQuarters(DataSet5 ds) {

		final double ret[] = new double[8];

		if (ds.mode == DataSet5.dMode.SEQUENTIAL) {
			ret[7] = ds.q8;
			ret[6] = ds.q7;
			ret[5] = ds.q6;
			ret[4] = ds.q5;
			ret[3] = ds.q4;
			ret[2] = ds.q3;
			ret[1] = ds.q2;
			ret[0] = ds.q1;
		} else {
			ret[7] = ds.q8 * 4.0;
			ret[6] = (ds.q8 * 3.0) + ds.q7;
			ret[5] = (ds.q8 * 2.0) + ds.q7 + ds.q6;
			ret[4] = ds.q8 + ds.q7 + ds.q6 + ds.q5;
			ret[3] = ds.q7 + ds.q6 + ds.q5 + ds.q4;
			ret[2] = ds.q6 + ds.q5 + ds.q4 + ds.q3;
			ret[1] = ds.q5 + ds.q4 + ds.q3 + ds.q2;
			ret[0] = ds.q4 + ds.q3 + ds.q2 + ds.q1;
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param ds
	 * @param fname
	 * @throws FileNotFoundException
	 */
	public static void write(DataSet5 ds, String fname, DateSet dates, boolean printAnnual) throws FileNotFoundException {

		if (ds.mode == DataSet5.dMode.SEQUENTIAL) {
			SipData5.writeDataSequential(ds, fname, dates, printAnnual);
		} else {
			SipData5.writeDataAccumulate(ds, fname, dates);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void write(PrintWriter pw, DateSet.Quarters q, double val, double divisor) {

		final double qval = val / divisor;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(q.q1.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(q.q2.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(q.q3.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(q.q4.date.getTime()), qval);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void writeAvgQtr(PrintWriter pw, DateSet.Quarters y1, DateSet.Quarters y0, double q8, double q7,
	    double q6, double q5, double q4, double q3, double q2, double q1) {

		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y1.q1.date.getTime()), q8);

		double tmp = ((q8 * 3.0) + q7) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y1.q2.date.getTime()), tmp);

		tmp = ((q8 * 2.0) + q7 + q6) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y1.q3.date.getTime()), tmp);

		tmp = (q8 + q7 + q6 + q5) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y1.q4.date.getTime()), tmp);

		tmp = (q7 + q6 + q5 + q4) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y0.q1.date.getTime()), tmp);

		tmp = (q6 + q5 + q4 + q3) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y0.q2.date.getTime()), tmp);

		tmp = (q5 + q4 + q3 + q2) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y0.q3.date.getTime()), tmp);

		tmp = (q4 + q3 + q2 + q1) / 4.0;
		pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(y0.q4.date.getTime()), tmp);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataAccumulate
	 *
	 * @param ds
	 * @param fname
	 */
	private static void writeDataAccumulate(DataSet5 ds, String fname, DateSet dates) {

		try (PrintWriter pw = new PrintWriter(SipData5.path + fname + ".csv")) {

			SipData5.write(pw, dates.y7, ds.y7, 4.0);
			SipData5.write(pw, dates.y6, ds.y6, 4.0);
			SipData5.write(pw, dates.y5, ds.y5, 4.0);
			SipData5.write(pw, dates.y4, ds.y4, 4.0);
			SipData5.write(pw, dates.y3, ds.y3, 4.0);
			SipData5.write(pw, dates.y2, ds.y2, 4.0);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q1.date.getTime()), ds.q8);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q2.date.getTime()), ds.q7);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q3.date.getTime()), ds.q6);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.q5);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q1.date.getTime()), ds.q4);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q2.date.getTime()), ds.q3);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q3.date.getTime()), ds.q2);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.q1);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataSequential
	 *
	 * @param ds
	 * @param fname
	 * @throws FileNotFoundException
	 */
	private static void writeDataSequential(DataSet5 ds, String fname, DateSet dates, boolean printAnnual)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipData5.path + fname + ".csv")) {

			//SipData5.write(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);

			if (printAnnual) {

				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y7.q4.date.getTime()), ds.y7);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y6.q4.date.getTime()), ds.y6);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y5.q4.date.getTime()), ds.y5);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y4.q4.date.getTime()), ds.y4);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y3.q4.date.getTime()), ds.y3);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y2.q4.date.getTime()), ds.y2);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.y1);
				pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.y0);
			} else {

				SipData5.write(pw, dates.y7, ds.y7, 1.0);
				SipData5.write(pw, dates.y6, ds.y6, 1.0);
				SipData5.write(pw, dates.y5, ds.y5, 1.0);
				SipData5.write(pw, dates.y4, ds.y4, 1.0);
				SipData5.write(pw, dates.y3, ds.y3, 1.0);
				SipData5.write(pw, dates.y2, ds.y2, 1.0);
				SipData5.writeAvgQtr(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);
			}
		}
	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.writePriceToDate
	 *
	 * @param dates
	 * @param scaler
	 * @param totSales
	 * @throws FileNotFoundException
	 */
	private static void writePriceToDate(DateSet dates, DataSet5 ds, String fname, double scaler)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipData5.path + fname + ".csv")) {

			SipData5.write(pw, dates.y7, (dates.y7.q4.value / ds.y7) * scaler, 1.0);
			SipData5.write(pw, dates.y6, (dates.y6.q4.value / ds.y6) * scaler, 1.0);
			SipData5.write(pw, dates.y5, (dates.y5.q4.value / ds.y5) * scaler, 1.0);
			SipData5.write(pw, dates.y4, (dates.y4.q4.value / ds.y4) * scaler, 1.0);
			SipData5.write(pw, dates.y3, (dates.y3.q4.value / ds.y3) * scaler, 1.0);
			SipData5.write(pw, dates.y2, (dates.y2.q4.value / ds.y2) * scaler, 1.0);

			final double q[] = SipData5.sumQuarters(ds);

			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q1.date.getTime()),
			    (dates.y1.q1.value / q[7]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q2.date.getTime()),
			    (dates.y1.q2.value / q[6]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q3.date.getTime()),
			    (dates.y1.q3.value / q[5]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y1.q4.date.getTime()),
			    (dates.y1.q4.value / q[4]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q1.date.getTime()),
			    (dates.y0.q1.value / q[3]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q2.date.getTime()),
			    (dates.y0.q2.value / q[2]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q3.date.getTime()),
			    (dates.y0.q3.value / q[1]) * scaler);
			pw.printf("%s,%.2f%n", SipData5.sdfOptuma.format(dates.y0.q4.date.getTime()),
			    (dates.y0.q4.value / q[0]) * scaler);
		}
	}

}
