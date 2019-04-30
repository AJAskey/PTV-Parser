
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
import net.ajaskey.market.ta.input.LongTermOHLCV;
import net.ajaskey.market.tools.optuma.OptumaCommon;

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
public class SipDataUS {

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
	//	private static void archiveData(Calendar latest) {
	//
	//		final List<String> dir = new ArrayList<>();
	//		dir.add(path);
	//		final List<String> fil = new ArrayList<>();
	//		fil.add("data\\US-Stocks.txt");
	//		fil.add("data\\US-Stocks-B.txt");
	//
	//		//final String fname = "SIP-" + Utils.stringDate(latest) + "_" + Utils.stringDate(Calendar.getInstance()) + ".zip";
	//		//Zip.create(dir, fil, "archive", fname);
	//
	//	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {

		SipDataUS.readDataFile_1("data/US-STOCKS.txt");
		final Calendar latest = SipDataUS.readDataFile_2("data/US-STOCKS-B.txt");

		System.out.println(Utils.stringDate(latest));

		SipDataUS.processData("US");
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
	public static void processData(final String index) throws FileNotFoundException, IOException, ParseException {

		final DataSet5 totSales = DataSet5.sum(SipDataUS.sales, index);
		final DataSet5 totEbit = DataSet5.sum(SipDataUS.ebit, index);
		final DataSet5 totTax = DataSet5.sum(SipDataUS.taxes, index);
		final DataSet5 totIncome = DataSet5.sum(SipDataUS.incomeEps, index);
		final DataSet5 totCops = DataSet5.sum(SipDataUS.cashOps, index);
		final DataSet5 totCfin = DataSet5.sum(SipDataUS.cashFin, index);
		final DataSet5 totCinv = DataSet5.sum(SipDataUS.cashInv, index);
		final DataSet5 totShr = DataSet5.sum(SipDataUS.shares, index);
		final DataSet5 totCash = DataSet5.sum(SipDataUS.cash, index);
		final DataSet5 totAssets = DataSet5.sum(SipDataUS.assets, index);
		final DataSet5 totLiab = DataSet5.sum(SipDataUS.liabilities, index);
		final DataSet5 totAccRx = DataSet5.sum(SipDataUS.accRx, index);
		final DataSet5 totAccTx = DataSet5.sum(SipDataUS.accTx, index);
		final DataSet5 totGoodwill = DataSet5.sum(SipDataUS.goodwill, index);
		final DataSet5 totLtDebt = DataSet5.sum(SipDataUS.ltDebt, index);
		final DataSet5 totCapEx = DataSet5.sum(SipDataUS.capEx, index);
		final DataSet5 totEquity = DataSet5.sum(SipDataUS.equity, index);
		final DataSet5 totInterest = DataSet5.sum(SipDataUS.interest, index);
		final DataSet5 totResDev = DataSet5.sum(SipDataUS.resDev, index);
		final DataSet5 totInventory = DataSet5.sum(SipDataUS.inventoryValue, index);
		final DataSet5 totEnterprise = DataSet5.sum(SipDataUS.enterpriseValue, index);
		final DataSet5 totFcf = DataSet5.sum(SipDataUS.fcf, index);

		final String prefix = "US";

		final DateSet dates = new DateSet(SipDataUS.indexPrices);
		final DataSet5 dsPrices = new DataSet5(dates, prefix);

		final List<DataSet5> divDollar = new ArrayList<>();
		for (int i = 0; i < SipDataUS.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipDataUS.dividend.get(i), SipDataUS.shares.get(i));
			divDollar.add(ds);
		}
		final DataSet5 totDivDollar = DataSet5.sum(divDollar, index);

		final List<DataSet5> bvDollar = new ArrayList<>();
		for (int i = 0; i < SipDataUS.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipDataUS.bookValue.get(i), SipDataUS.shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet5 totBvDollar = DataSet5.sum(bvDollar, index);

		final DataSet5 totBVminusGW = DataSet5.sub(totBvDollar, totGoodwill);

		final List<DataSet5> mcap = new ArrayList<>();
		for (int i = 0; i < SipDataUS.companyKnt; i++) {
			final DataSet5 ds = DataSet5.mult(SipDataUS.prices.get(i), SipDataUS.shares.get(i));
			mcap.add(ds);
		}
		final DataSet5 totMktCap = DataSet5.sum(mcap, index);
		totMktCap.mode = DataSet5.dMode.SEQUENTIAL;

		SipDataUS.write(totSales, prefix + " Sales v4", dates, false);
		SipDataUS.write(totEbit, prefix + " EBIT v4", dates, false);
		SipDataUS.write(totTax, prefix + " Taxes v4", dates, false);
		SipDataUS.write(totIncome, prefix + " Income for EPS v4", dates, false);
		SipDataUS.write(totCops, prefix + " Cash from Operations v4", dates, false);
		SipDataUS.write(totCfin, prefix + " Cash from Financing v4", dates, false);
		SipDataUS.write(totCinv, prefix + " Cash from Investing v4", dates, false);
		SipDataUS.write(totDivDollar, prefix + " Dividends v4", dates, false);
		SipDataUS.write(totShr, prefix + " Shares v4", dates, false);
		SipDataUS.write(totCash, prefix + " Cash v4", dates, false);
		SipDataUS.write(totAssets, prefix + " Assets v4", dates, false);
		SipDataUS.write(totLiab, prefix + " Liabilities v4", dates, false);
		SipDataUS.write(totAccRx, prefix + " Accounts Receivable v4", dates, false);
		SipDataUS.write(totAccTx, prefix + " Accounts Payable v4", dates, false);
		SipDataUS.write(totGoodwill, prefix + " Goodwill v4", dates, false);
		SipDataUS.write(totLtDebt, prefix + " LT Debt v4", dates, false);
		SipDataUS.write(totCapEx, prefix + " CapEx v4", dates, false);
		SipDataUS.write(totEquity, prefix + " Common Equity v4", dates, false);
		SipDataUS.write(totInterest, prefix + " Interest Paid v4", dates, false);
		SipDataUS.write(totResDev, prefix + " Research and Development v4", dates, false);
		SipDataUS.write(totBvDollar, prefix + " Book Value v4", dates, false);
		SipDataUS.write(totBVminusGW, prefix + " Book Value less Goodwill v4", dates, false);
		SipDataUS.write(totMktCap, prefix + " Market Cap v4", dates, false);
		SipDataUS.write(totInventory, prefix + " Inventory v4", dates, false);
		SipDataUS.write(totEnterprise, prefix + " Enterprise v4", dates, false);
		SipDataUS.write(totFcf, prefix + " FCFps v4", dates, false);

		//-----------------------------------------

		final DataSet5 totMktCapShr = DataSet5.ratio(totMktCap, totShr);
		SipDataUS.write(totMktCapShr, prefix + " Market Cap to Shares v4", dates, false);

		final DataSet5 totMargin = DataSet5.scale(DataSet5.ratio(totIncome, totSales), 100.0);
		SipDataUS.write(totMargin, prefix + " Margin v4", dates, false);

		final DataSet5 totROE = DataSet5.scale(DataSet5.ratio(totIncome, totEquity), 100.0);
		SipDataUS.write(totROE, prefix + " ROE v4", dates, false);

		final DataSet5 totTaxMargin = DataSet5.scale(DataSet5.ratio(totTax, totSales), 100.0);
		SipDataUS.write(totTaxMargin, prefix + " Tax Margin v4", dates, false);

		final DataSet5 totBVtoCap = DataSet5.scale(DataSet5.ratio(totBvDollar, totMktCap), 100.0);
		SipDataUS.write(totBVtoCap, prefix + " BV over Market Cap v4", dates, false);

		final DataSet5 totBVmGWtoCap = DataSet5.scale(DataSet5.ratio(totBVminusGW, totMktCap), 100.0);
		SipDataUS.write(totBVmGWtoCap, prefix + " BV Minus Goodwill over Market Cap v4", dates, false);

		final DataSet5 totGWtoAsset = DataSet5.scale(DataSet5.ratio(totGoodwill, totAssets), 100.0);
		SipDataUS.write(totGWtoAsset, prefix + " Goodwill over Assets v4", dates, false);

		SipDataUS.writePriceToDate(dates, totSales, prefix + " Price to Sales v4", 100000000000.0);
		SipDataUS.writePriceToDate(dates, totIncome, prefix + " Price to Income v4", 10000000000.0);
		SipDataUS.writePriceToDate(dates, totCash, prefix + " Price to Cash v4", 10000000000.0);
		SipDataUS.writePriceToDate(dates, totBvDollar, prefix + " Price to BV v4", 100000000000.0);

		SipDataUS.writeEps(totIncome, totShr, prefix + " EPS v4", prefix + " EPS Annual v4", prefix + " PE v4", dates, dsPrices);

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void readDataFile_1(final String filename) throws FileNotFoundException, IOException {

		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			System.out.println("Reading file : " + filename);

			String line = "";

			//line = br.readLine(); // read header
			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					knt++;
					sc.reset();

					SipDataUS.sales.add(sc.getData5("sales", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.ebit.add(sc.getData5("ebit", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.taxes.add(sc.getData5("taxes", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.incomeEps.add(sc.getData5("incomeEps", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.cashOps.add(sc.getData5("cashOps", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.cashInv.add(sc.getData5("cashInv", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.cashFin.add(sc.getData5("cashFin", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));

					SipDataUS.dividend.add(sc.getData5("dividend", line, DataSet5.dMode.ACCUMULATION, 1.0));

					SipDataUS.capEx.add(sc.getData5("capEx", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					final DataSet5 s = sc.getData5("shares", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION);
					SipDataUS.shares.add(s);

					SipDataUS.cash.add(sc.getData5("cash", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.assets.add(sc.getData5("assets", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.liabilities.add(sc.getData5("liabilities", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.accRx.add(sc.getData5("Accounts Receivable", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.accTx.add(sc.getData5("Accounts Payable", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.goodwill.add(sc.getData5("Goodwill", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.ltDebt.add(sc.getData5("LT Debt", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
				}
			}
		}
		SipDataUS.companyKnt = knt;
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
	public static Calendar readDataFile_2(final String filename) throws FileNotFoundException, IOException {

		final Calendar latestDate = Calendar.getInstance();
		latestDate.add(Calendar.YEAR, -5);

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					sc.reset();

					SipDataUS.equity.add(sc.getUsData5("Common Equity", line, DataSet5.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipDataUS.interest.add(sc.getUsData5("interest", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.resDev.add(sc.getUsData5("R and D", line, DataSet5.dMode.ACCUMULATION, SipCommon.MILLION));
					SipDataUS.bookValue.add(sc.getUsData5("Book Value per Share", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipDataUS.inventoryValue.add(sc.getUsData5("Inventory", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipDataUS.enterpriseValue.add(sc.getUsData5("Enterprice", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipDataUS.prices.add(sc.getUsData5("Prices", line, DataSet5.dMode.SEQUENTIAL, 1.0));
					SipDataUS.fcf.add(sc.getUsData5("FCF", line, DataSet5.dMode.SEQUENTIAL, 1.0));

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

	private static double[] sumQuarters(final DataSet5 ds) {

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
		}
		else {
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
	public static void write(final DataSet5 ds, final String fname, final DateSet dates, final boolean printAnnual)
	    throws FileNotFoundException {

		if (ds.mode == DataSet5.dMode.SEQUENTIAL) {
			SipDataUS.writeDataSequential(ds, fname, dates, printAnnual);
		}
		else {
			SipDataUS.writeDataAccumulate(ds, fname, dates);
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
	private static void write(final PrintWriter pw, final DateSet.Quarters q, final double val, final double divisor) {

		final double qval = val / divisor;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(q.q1.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(q.q2.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(q.q3.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(q.q4.date.getTime()), qval);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void writeAvgQtr(final PrintWriter pw, final DateSet.Quarters y1, final DateSet.Quarters y0, final double q8,
	    final double q7, final double q6, final double q5, final double q4, final double q3, final double q2, final double q1) {

		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y1.q1.date.getTime()), q8);

		double tmp = ((q8 * 3.0) + q7) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y1.q2.date.getTime()), tmp);

		tmp = ((q8 * 2.0) + q7 + q6) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y1.q3.date.getTime()), tmp);

		tmp = (q8 + q7 + q6 + q5) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y1.q4.date.getTime()), tmp);

		tmp = (q7 + q6 + q5 + q4) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y0.q1.date.getTime()), tmp);

		tmp = (q6 + q5 + q4 + q3) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y0.q2.date.getTime()), tmp);

		tmp = (q5 + q4 + q3 + q2) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y0.q3.date.getTime()), tmp);

		tmp = (q4 + q3 + q2 + q1) / 4.0;
		pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(y0.q4.date.getTime()), tmp);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataAccumulate
	 *
	 * @param ds
	 * @param fname
	 */
	private static void writeDataAccumulate(final DataSet5 ds, final String fname, final DateSet dates) {

		try (PrintWriter pw = new PrintWriter(SipDataUS.path + fname + ".csv")) {

			SipDataUS.write(pw, dates.y7, ds.y7, 4.0);
			SipDataUS.write(pw, dates.y6, ds.y6, 4.0);
			SipDataUS.write(pw, dates.y5, ds.y5, 4.0);
			SipDataUS.write(pw, dates.y4, ds.y4, 4.0);
			SipDataUS.write(pw, dates.y3, ds.y3, 4.0);
			SipDataUS.write(pw, dates.y2, ds.y2, 4.0);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q1.date.getTime()), ds.q8);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q2.date.getTime()), ds.q7);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q3.date.getTime()), ds.q6);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.q5);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q1.date.getTime()), ds.q4);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q2.date.getTime()), ds.q3);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q3.date.getTime()), ds.q2);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.q1);

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
	private static void writeDataSequential(final DataSet5 ds, final String fname, final DateSet dates, final boolean printAnnual)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipDataUS.path + fname + ".csv")) {

			//SipData5.write(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);

			if (printAnnual) {

				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y7.q4.date.getTime()), ds.y7);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y6.q4.date.getTime()), ds.y6);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y5.q4.date.getTime()), ds.y5);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y4.q4.date.getTime()), ds.y4);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y3.q4.date.getTime()), ds.y3);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y2.q4.date.getTime()), ds.y2);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.y1);
				pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.y0);
			}
			else {

				SipDataUS.write(pw, dates.y7, ds.y7, 1.0);
				SipDataUS.write(pw, dates.y6, ds.y6, 1.0);
				SipDataUS.write(pw, dates.y5, ds.y5, 1.0);
				SipDataUS.write(pw, dates.y4, ds.y4, 1.0);
				SipDataUS.write(pw, dates.y3, ds.y3, 1.0);
				SipDataUS.write(pw, dates.y2, ds.y2, 1.0);
				SipDataUS.writeAvgQtr(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);
			}
		}
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
	private static void writeEps(final DataSet5 totIncome, final DataSet5 totShr, final String epsStr, final String epsannualStr,
	    final String peStr, final DateSet dates, final DataSet5 dsPrices) throws FileNotFoundException {

		final DataSet5 totEps = DataSet5.scale(DataSet5.div(totIncome, totShr), 40.0);
		SipDataUS.write(totEps, epsStr, dates, false);

		//		totEps.mode = DataSet5.dMode.SEQUENTIAL;
		//		SipData5.write(totEps, epsannualStr, dates, false);

		//		final DataSet5 totPE = DataSet5.scale(DataSet5.div(dsPrices, totEps), 1.0);
		//		totPE.mode = DataSet5.dMode.SEQUENTIAL;
		//		SipData5.write(totPE, peStr, dates, false);

	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.writePriceToDate
	 *
	 * @param dates
	 * @param scaler
	 * @param totSales
	 * @throws FileNotFoundException
	 */
	private static void writePriceToDate(final DateSet dates, final DataSet5 ds, final String fname, final double scaler)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipDataUS.path + fname + ".csv")) {

			SipDataUS.write(pw, dates.y7, (dates.y7.q4.value / ds.y7) * scaler, 1.0);
			SipDataUS.write(pw, dates.y6, (dates.y6.q4.value / ds.y6) * scaler, 1.0);
			SipDataUS.write(pw, dates.y5, (dates.y5.q4.value / ds.y5) * scaler, 1.0);
			SipDataUS.write(pw, dates.y4, (dates.y4.q4.value / ds.y4) * scaler, 1.0);
			SipDataUS.write(pw, dates.y3, (dates.y3.q4.value / ds.y3) * scaler, 1.0);
			SipDataUS.write(pw, dates.y2, (dates.y2.q4.value / ds.y2) * scaler, 1.0);

			final double q[] = SipDataUS.sumQuarters(ds);

			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q1.date.getTime()), (dates.y1.q1.value / q[7]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q2.date.getTime()), (dates.y1.q2.value / q[6]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q3.date.getTime()), (dates.y1.q3.value / q[5]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y1.q4.date.getTime()), (dates.y1.q4.value / q[4]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q1.date.getTime()), (dates.y0.q1.value / q[3]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q2.date.getTime()), (dates.y0.q2.value / q[2]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q3.date.getTime()), (dates.y0.q3.value / q[1]) * scaler);
			pw.printf("%s,%.2f%n", SipDataUS.sdfOptuma.format(dates.y0.q4.date.getTime()), (dates.y0.q4.value / q[0]) * scaler);
		}
	}

}
