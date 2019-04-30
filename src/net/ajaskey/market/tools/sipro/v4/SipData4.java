
package net.ajaskey.market.tools.sipro.v4;

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
public class SipData4 {

	public static List<DataSet4>	sales				= new ArrayList<>();
	public static List<DataSet4>	ebit				= new ArrayList<>();
	public static List<DataSet4>	taxes				= new ArrayList<>();
	public static List<DataSet4>	incomeEps		= new ArrayList<>();
	public static List<DataSet4>	cashOps			= new ArrayList<>();
	public static List<DataSet4>	cashFin			= new ArrayList<>();
	public static List<DataSet4>	cashInv			= new ArrayList<>();
	public static List<DataSet4>	dividend		= new ArrayList<>();
	public static List<DataSet4>	shares			= new ArrayList<>();
	public static List<DataSet4>	cash				= new ArrayList<>();
	public static List<DataSet4>	assets			= new ArrayList<>();
	public static List<DataSet4>	liabilities	= new ArrayList<>();
	public static List<DataSet4>	accTx				= new ArrayList<>();
	public static List<DataSet4>	accRx				= new ArrayList<>();
	public static List<DataSet4>	goodwill		= new ArrayList<>();
	public static List<DataSet4>	ltDebt			= new ArrayList<>();
	public static List<DataSet4>	capEx				= new ArrayList<>();
	public static List<DataSet4>	equity			= new ArrayList<>();
	public static List<DataSet4>	interest		= new ArrayList<>();
	public static List<DataSet4>	resDev			= new ArrayList<>();
	public static List<DataSet4>	bookValue		= new ArrayList<>();
	public static List<DataSet4>	prices			= new ArrayList<>();

	public static List<DataSet4> eps = new ArrayList<>();

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	public static List<LongTermOHLCV> indexPrices = null;

	private static int companyKnt = 0;

	static String path = OptumaCommon.optumaPath + "SIP/";

	/**
	 * net.ajaskey.market.tools.sipro.v4.archiveData
	 *
	 */
	private static void archiveData(final Calendar latest) {

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
	public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {

		SipData4.readDataFile_1("data/SP-STOCKS.txt");
		final Calendar latest = SipData4.readDataFile_2("data/SP-STOCKS-B.txt");

		System.out.println(Utils.stringDate(latest));

		SipData4.processData("500");
		//SipData4.processData("MidCap 400");
		//SipData4.processData("SmallCap 600");

		SipData4.archiveData(latest);

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

		final DataSet4 totSales = DataSet4.sum(SipData4.sales, index);
		final DataSet4 totEbit = DataSet4.sum(SipData4.ebit, index);
		final DataSet4 totTax = DataSet4.sum(SipData4.taxes, index);
		final DataSet4 totIncome = DataSet4.sum(SipData4.incomeEps, index);
		final DataSet4 totCops = DataSet4.sum(SipData4.cashOps, index);
		final DataSet4 totCfin = DataSet4.sum(SipData4.cashFin, index);
		final DataSet4 totCinv = DataSet4.sum(SipData4.cashInv, index);
		final DataSet4 totShr = DataSet4.sum(SipData4.shares, index);
		final DataSet4 totCash = DataSet4.sum(SipData4.cash, index);
		final DataSet4 totAssets = DataSet4.sum(SipData4.assets, index);
		final DataSet4 totLiab = DataSet4.sum(SipData4.liabilities, index);
		final DataSet4 totAccRx = DataSet4.sum(SipData4.accRx, index);
		final DataSet4 totAccTx = DataSet4.sum(SipData4.accTx, index);
		final DataSet4 totGoodwill = DataSet4.sum(SipData4.goodwill, index);
		final DataSet4 totLtDebt = DataSet4.sum(SipData4.ltDebt, index);
		final DataSet4 totCapEx = DataSet4.sum(SipData4.capEx, index);
		final DataSet4 totEquity = DataSet4.sum(SipData4.equity, index);
		final DataSet4 totInterest = DataSet4.sum(SipData4.interest, index);
		final DataSet4 totResDev = DataSet4.sum(SipData4.resDev, index);

		String prefix = "";

		if (index.equalsIgnoreCase("500")) {
			SipData4.indexPrices = LongTermOHLCV.getData("SP500");
			prefix = "SPX";
		}
		else if (index.equalsIgnoreCase("MidCap 400")) {
			SipData4.indexPrices = LongTermOHLCV.getData("SP400");
			prefix = "SP400";
		}
		else if (index.equalsIgnoreCase("SmallCap 600")) {
			SipData4.indexPrices = LongTermOHLCV.getData("SP600");
			prefix = "SP600";
		}
		else {
			return;
		}

		final DateSet dates = new DateSet(SipData4.indexPrices);
		final DataSet4 dsPrices = new DataSet4(dates, prefix);

		final List<DataSet4> divDollar = new ArrayList<>();
		for (int i = 0; i < SipData4.companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(SipData4.dividend.get(i), SipData4.shares.get(i));
			divDollar.add(ds);
		}
		final DataSet4 totDivDollar = DataSet4.sum(divDollar, index);

		final List<DataSet4> bvDollar = new ArrayList<>();
		for (int i = 0; i < SipData4.companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(SipData4.bookValue.get(i), SipData4.shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet4 totBvDollar = DataSet4.sum(bvDollar, index);

		final DataSet4 totBVminusGW = DataSet4.sub(totBvDollar, totGoodwill);

		final List<DataSet4> mcap = new ArrayList<>();
		for (int i = 0; i < SipData4.companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(SipData4.prices.get(i), SipData4.shares.get(i));
			mcap.add(ds);
		}
		final DataSet4 totMktCap = DataSet4.sum(mcap, index);
		totMktCap.mode = DataSet4.dMode.SEQUENTIAL;

		SipData4.write(totSales, prefix + " Sales v4", dates, false);
		SipData4.write(totEbit, prefix + " EBIT v4", dates, false);
		SipData4.write(totTax, prefix + " Taxes v4", dates, false);
		SipData4.write(totIncome, prefix + " Income for EPS v4", dates, false);
		SipData4.write(totCops, prefix + " Cash from Operations v4", dates, false);
		SipData4.write(totCfin, prefix + " Cash from Financing v4", dates, false);
		SipData4.write(totCinv, prefix + " Cash from Investing v4", dates, false);
		SipData4.write(totDivDollar, prefix + " Dividends v4", dates, false);
		SipData4.write(totShr, prefix + " Shares v4", dates, false);
		SipData4.write(totCash, prefix + " Cash v4", dates, false);
		SipData4.write(totAssets, prefix + " Assets v4", dates, false);
		SipData4.write(totLiab, prefix + " Liabilities v4", dates, false);
		SipData4.write(totAccRx, prefix + " Accounts Receivable v4", dates, false);
		SipData4.write(totAccTx, prefix + " Accounts Payable v4", dates, false);
		SipData4.write(totGoodwill, prefix + " Goodwill v4", dates, false);
		SipData4.write(totLtDebt, prefix + " LT Debt v4", dates, false);
		SipData4.write(totCapEx, prefix + " CapEx v4", dates, false);
		SipData4.write(totEquity, prefix + " Common Equity v4", dates, false);
		SipData4.write(totInterest, prefix + " Interest Paid v4", dates, false);
		SipData4.write(totResDev, prefix + " Research and Development v4", dates, false);
		SipData4.write(totBvDollar, prefix + " Book Value v4", dates, false);
		SipData4.write(totBVminusGW, prefix + " Book Value less Goodwill v4", dates, false);
		SipData4.write(totMktCap, prefix + " Market Cap v4", dates, false);

		//-----------------------------------------

		final DataSet4 totMktCapShr = DataSet4.ratio(totMktCap, totShr);
		SipData4.write(totMktCapShr, prefix + " Market Cap to Shares v4", dates, false);

		final DataSet4 totMargin = DataSet4.scale(DataSet4.ratio(totIncome, totSales), 100.0);
		SipData4.write(totMargin, prefix + " Margin v4", dates, false);

		final DataSet4 totROE = DataSet4.scale(DataSet4.ratio(totIncome, totEquity), 100.0);
		SipData4.write(totROE, prefix + " ROE v4", dates, false);

		final DataSet4 totTaxMargin = DataSet4.scale(DataSet4.ratio(totTax, totSales), 100.0);
		SipData4.write(totTaxMargin, prefix + " Tax Margin v4", dates, false);

		final DataSet4 totBVtoCap = DataSet4.scale(DataSet4.ratio(totBvDollar, totMktCap), 100.0);
		SipData4.write(totBVtoCap, prefix + " BV over Market Cap v4", dates, false);

		final DataSet4 totBVmGWtoCap = DataSet4.scale(DataSet4.ratio(totBVminusGW, totMktCap), 100.0);
		SipData4.write(totBVmGWtoCap, prefix + " BV Minus Goodwill over Market Cap v4", dates, false);

		final DataSet4 totGWtoAsset = DataSet4.scale(DataSet4.ratio(totGoodwill, totAssets), 100.0);
		SipData4.write(totGWtoAsset, prefix + " Goodwill over Assets v4", dates, false);

		SipData4.writeEps(totIncome, totShr, prefix + " EPS v4", prefix + " EPS Annual v4", prefix + " PE v4", dates, dsPrices);

		SipData4.writePriceToDate(dates, totSales, prefix + " Price to Sales v4", 100000000000.0);
		SipData4.writePriceToDate(dates, totIncome, prefix + " Price to Income v4", 10000000000.0);
		SipData4.writePriceToDate(dates, totCash, prefix + " Price to Cash v4", 10000000000.0);
		SipData4.writePriceToDate(dates, totBvDollar, prefix + " Price to BV v4", 100000000000.0);

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

					SipData4.sales.add(sc.getData4("sales", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.ebit.add(sc.getData4("ebit", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.taxes.add(sc.getData4("taxes", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.incomeEps.add(sc.getData4("incomeEps", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.cashOps.add(sc.getData4("cashOps", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.cashInv.add(sc.getData4("cashInv", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.cashFin.add(sc.getData4("cashFin", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));

					SipData4.dividend.add(sc.getData4("dividend", line, DataSet4.dMode.ACCUMULATION, 1.0));

					SipData4.capEx.add(sc.getData4("capEx", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					final DataSet4 s = sc.getData4("shares", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION);
					SipData4.shares.add(s);

					SipData4.cash.add(sc.getData4("cash", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.assets.add(sc.getData4("assets", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.liabilities.add(sc.getData4("liabilities", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.accRx.add(sc.getData4("Accounts Receivable", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.accTx.add(sc.getData4("Accounts Payable", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.goodwill.add(sc.getData4("Goodwill", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.ltDebt.add(sc.getData4("LT Debt", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					SipData4.equity.add(sc.getData4("Common Equity", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
				}
			}
		}
		SipData4.companyKnt = knt;
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

					SipData4.interest.add(sc.getData4("interest", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.resDev.add(sc.getData4("R and D", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));

					SipData4.bookValue.add(sc.getData4("Book Value per Share", line, DataSet4.dMode.SEQUENTIAL, 1.0));
					SipData4.prices.add(sc.getData4("Prices", line, DataSet4.dMode.SEQUENTIAL, 1.0));

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

	private static double[] sumQuarters(final DataSet4 ds) {

		final double ret[] = new double[8];

		if (ds.mode == DataSet4.dMode.SEQUENTIAL) {
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
	public static void write(final DataSet4 ds, final String fname, final DateSet dates, final boolean printAnnual)
	    throws FileNotFoundException {

		if (ds.mode == DataSet4.dMode.SEQUENTIAL) {
			SipData4.writeDataSequential(ds, fname, dates, printAnnual);
		}
		else {
			SipData4.writeDataAccumulate(ds, fname, dates);
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
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q1.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q2.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q3.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q4.date.getTime()), qval);
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

		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q1.date.getTime()), q8);

		double tmp = ((q8 * 3.0) + q7) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q2.date.getTime()), tmp);

		tmp = ((q8 * 2.0) + q7 + q6) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q3.date.getTime()), tmp);

		tmp = (q8 + q7 + q6 + q5) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q4.date.getTime()), tmp);

		tmp = (q7 + q6 + q5 + q4) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q1.date.getTime()), tmp);

		tmp = (q6 + q5 + q4 + q3) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q2.date.getTime()), tmp);

		tmp = (q5 + q4 + q3 + q2) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q3.date.getTime()), tmp);

		tmp = (q4 + q3 + q2 + q1) / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q4.date.getTime()), tmp);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataAccumulate
	 *
	 * @param ds
	 * @param fname
	 */
	private static void writeDataAccumulate(final DataSet4 ds, final String fname, final DateSet dates) {

		try (PrintWriter pw = new PrintWriter(SipData4.path + fname + ".csv")) {

			SipData4.write(pw, dates.y7, ds.y7, 4.0);
			SipData4.write(pw, dates.y6, ds.y6, 4.0);
			SipData4.write(pw, dates.y5, ds.y5, 4.0);
			SipData4.write(pw, dates.y4, ds.y4, 4.0);
			SipData4.write(pw, dates.y3, ds.y3, 4.0);
			SipData4.write(pw, dates.y2, ds.y2, 4.0);
			SipData4.writeAvgQtr(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);
			//write(pw, dates.y0, ds.y0);

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
	private static void writeDataSequential(final DataSet4 ds, final String fname, final DateSet dates, final boolean printAnnual)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipData4.path + fname + ".csv")) {

			//SipData4.write(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);

			if (printAnnual) {

				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y7.q4.date.getTime()), ds.y7);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y6.q4.date.getTime()), ds.y6);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y5.q4.date.getTime()), ds.y5);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y4.q4.date.getTime()), ds.y4);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y3.q4.date.getTime()), ds.y3);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y2.q4.date.getTime()), ds.y2);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.y1);
				pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.y0);
			}
			else {

				SipData4.write(pw, dates.y7, ds.y7, 1.0);
				SipData4.write(pw, dates.y6, ds.y6, 1.0);
				SipData4.write(pw, dates.y5, ds.y5, 1.0);
				SipData4.write(pw, dates.y4, ds.y4, 1.0);
				SipData4.write(pw, dates.y3, ds.y3, 1.0);
				SipData4.write(pw, dates.y2, ds.y2, 1.0);
				//SipData4.write(pw, dates.y2, ds.y1, 1.0);
				//SipData4.write(pw, dates.y2, ds.y0, 1.0);
				SipData4.writeAvgQtr(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);
			}
		}
	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.writeEps
	 *
	 * @param totIncome
	 * @param totShr
	 * @param string
	 * @param string2
	 * @param string3
	 * @param dates
	 * @throws FileNotFoundException
	 */
	private static void writeEps(final DataSet4 totIncome, final DataSet4 totShr, final String epsStr, final String epsannualStr,
	    final String peStr, final DateSet dates, final DataSet4 dsPrices) throws FileNotFoundException {

		final DataSet4 totEps = DataSet4.scale(DataSet4.div(totIncome, totShr), 36.0);
		SipData4.write(totEps, epsStr, dates, false);

		totEps.mode = DataSet4.dMode.SEQUENTIAL;
		SipData4.write(totEps, epsannualStr, dates, false);

		final DataSet4 totPE = DataSet4.scale(DataSet4.div(dsPrices, totEps), 1.0);
		totPE.mode = DataSet4.dMode.SEQUENTIAL;
		SipData4.write(totPE, peStr, dates, false);

	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.writePriceToDate
	 *
	 * @param dates
	 * @param scaler
	 * @param totSales
	 * @throws FileNotFoundException
	 */
	private static void writePriceToDate(final DateSet dates, final DataSet4 ds, final String fname, final double scaler)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipData4.path + fname + ".csv")) {

			SipData4.write(pw, dates.y7, (dates.y7.q4.value / ds.y7) * scaler, 1.0);
			SipData4.write(pw, dates.y6, (dates.y6.q4.value / ds.y6) * scaler, 1.0);
			SipData4.write(pw, dates.y5, (dates.y5.q4.value / ds.y5) * scaler, 1.0);
			SipData4.write(pw, dates.y4, (dates.y4.q4.value / ds.y4) * scaler, 1.0);
			SipData4.write(pw, dates.y3, (dates.y3.q4.value / ds.y3) * scaler, 1.0);
			SipData4.write(pw, dates.y2, (dates.y2.q4.value / ds.y2) * scaler, 1.0);
			final double q[] = SipData4.sumQuarters(ds);
			System.out.println(ds.y7);
			System.out.println(ds.y6);
			System.out.println(ds.y5);
			System.out.println(ds.y4);
			System.out.println(ds.y3);
			System.out.println(ds.y2);
			System.out.println(ds.y1);
			System.out.println(ds.y0 + "\n");
			System.out.println(q[7]);
			System.out.println(q[6]);
			System.out.println(q[5]);
			System.out.println(q[4]);
			System.out.println(q[3]);
			System.out.println(q[2]);
			System.out.println(q[1]);
			System.out.println(q[0]);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q1.date.getTime()), (dates.y1.q1.value / q[7]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q2.date.getTime()), (dates.y1.q2.value / q[6]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q3.date.getTime()), (dates.y1.q3.value / q[5]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q4.date.getTime()), (dates.y1.q4.value / q[4]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q1.date.getTime()), (dates.y0.q1.value / q[3]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q2.date.getTime()), (dates.y0.q2.value / q[2]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q3.date.getTime()), (dates.y0.q3.value / q[1]) * scaler);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q4.date.getTime()), (dates.y0.q4.value / q[0]) * scaler);

			//      SipData4.write(pw, dates.y1, dates.y1.q1.value / q[7] * scaler, 1.0);
			//			SipData4.write(pw, dates.y1, dates.y1.q2.value / q[6] * scaler, 1.0);
			//			SipData4.write(pw, dates.y1, dates.y1.q3.value / q[5] * scaler, 1.0);
			//			SipData4.write(pw, dates.y1, dates.y1.q4.value / q[4] * scaler, 1.0);
			//			SipData4.write(pw, dates.y0, dates.y0.q1.value / q[3] * scaler, 1.0);
			//			SipData4.write(pw, dates.y0, dates.y0.q2.value / q[2] * scaler, 1.0);
			//			SipData4.write(pw, dates.y0, dates.y0.q3.value / q[1] * scaler, 1.0);
			//			SipData4.write(pw, dates.y0, dates.y0.q4.value / q[0] * scaler, 1.0);
		}
	}

}
