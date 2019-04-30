
package net.ajaskey.market.tools.sipro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

	//public static List<ClosingPrices> lastPrice = new ArrayList<>();

	private static int companyKnt = 0;

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

		//SipData4.readClosingPrices("data/closing_price.txt");

		SipData4.readDataFile_1("data/SP-STOCKS.txt");
		SipData4.readDataFile_2("data/SP-STOCKS-B.txt");

		SipData4.processData("500");
		SipData4.processData("MidCap 400");
		SipData4.processData("SmallCap 600");
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

		final DataSet4 totSales = DataSet4.sum(sales, index);
		final DataSet4 totEbit = DataSet4.sum(ebit, index);
		final DataSet4 totTax = DataSet4.sum(taxes, index);
		final DataSet4 totIncome = DataSet4.sum(incomeEps, index);
		final DataSet4 totCops = DataSet4.sum(cashOps, index);
		final DataSet4 totCfin = DataSet4.sum(cashFin, index);
		final DataSet4 totCinv = DataSet4.sum(cashInv, index);
		final DataSet4 totShr = DataSet4.sum(shares, index);
		final DataSet4 totCash = DataSet4.sum(cash, index);
		final DataSet4 totAssets = DataSet4.sum(assets, index);
		final DataSet4 totLiab = DataSet4.sum(liabilities, index);
		final DataSet4 totAccRx = DataSet4.sum(accRx, index);
		final DataSet4 totAccTx = DataSet4.sum(accTx, index);
		final DataSet4 totGoodwill = DataSet4.sum(goodwill, index);
		final DataSet4 totLtDebt = DataSet4.sum(ltDebt, index);
		final DataSet4 totCapEx = DataSet4.sum(capEx, index);
		final DataSet4 totEquity = DataSet4.sum(equity, index);
		final DataSet4 totInterest = DataSet4.sum(interest, index);
		final DataSet4 totResDev = DataSet4.sum(resDev, index);

		String prefix = "";

		if (index.equalsIgnoreCase("500")) {
			indexPrices = LongTermOHLCV.getData("SP500");
			prefix = "SPX";
		}
		else if (index.equalsIgnoreCase("MidCap 400")) {
			indexPrices = LongTermOHLCV.getData("SP400");
			prefix = "SP400";
		}
		else if (index.equalsIgnoreCase("SmallCap 600")) {
			indexPrices = LongTermOHLCV.getData("SP600");
			prefix = "SP600";
		}
		else {
			return;
		}

		final DateSet dates = new DateSet(indexPrices);
		final DataSet4 dsPrices = new DataSet4(dates, prefix);

		final DataSet4 totEps = DataSet4.scale(DataSet4.div(totIncome, totShr), 10.0);
		final DataSet4 epsForPE = new DataSet4(totEps);
		epsForPE.q8 = totEps.q8 * 4.0;
		epsForPE.q7 = totEps.q8 + (totEps.q7 * 3.0);
		epsForPE.q6 = totEps.q8 + totEps.q7 + (totEps.q6 * 2.0);
		epsForPE.q5 = totEps.q8 + totEps.q7 + totEps.q6 + totEps.q5;
		epsForPE.q4 = totEps.q7 + totEps.q6 + totEps.q5 + totEps.q4;
		epsForPE.q3 = totEps.q6 + totEps.q5 + totEps.q4 + totEps.q3;
		epsForPE.q2 = totEps.q5 + totEps.q4 + totEps.q3 + totEps.q2;
		epsForPE.q1 = totEps.q4 + totEps.q3 + totEps.q2 + totEps.q1;

		final DataSet4 totPE = DataSet4.scale(DataSet4.div(dsPrices, epsForPE), 1.0);

		final List<DataSet4> divDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(dividend.get(i), shares.get(i));
			divDollar.add(ds);
		}
		final DataSet4 totDivDollar = DataSet4.sum(divDollar, index);

		final List<DataSet4> bvDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(bookValue.get(i), shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet4 totBvDollar = DataSet4.sum(bvDollar, index);

		final DataSet4 totBVminusGW = DataSet4.sub(totBvDollar, totGoodwill);

		final List<DataSet4> mcap = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final double pr = ClosingPrices.getPrice(prices.get(i).ticker);
			final DataSet4 price = prices.get(i);
			price.q1 = pr;
			final DataSet4 ds = DataSet4.mult(price, shares.get(i));
			mcap.add(ds);
		}
		final DataSet4 totMktCap = DataSet4.sum(mcap, index);

		SipData4.write(totSales, prefix + " Sales v4", dates);
		SipData4.write(totEbit, prefix + " EBIT v4", dates);
		SipData4.write(totTax, prefix + " Taxes v4", dates);
		SipData4.write(totIncome, prefix + " Income for EPS v4", dates);
		SipData4.write(totCops, prefix + " Cash from Operations v4", dates);
		SipData4.write(totCfin, prefix + " Cash from Financing v4", dates);
		SipData4.write(totCinv, prefix + " Cash from Investing v4", dates);
		SipData4.write(totDivDollar, prefix + " Dividends v4", dates);
		SipData4.write(totShr, prefix + " Shares v4", dates);
		SipData4.write(totCash, prefix + " Cash v4", dates);
		SipData4.write(totAssets, prefix + " Assets v4", dates);
		SipData4.write(totLiab, prefix + " Liabilities v4", dates);
		SipData4.write(totAccRx, prefix + " Accounts Receivable v4", dates);
		SipData4.write(totAccTx, prefix + " Accounts Payable v4", dates);
		SipData4.write(totGoodwill, prefix + " Goodwill v4", dates);
		SipData4.write(totLtDebt, prefix + " LT Debt v4", dates);
		SipData4.write(totCapEx, prefix + " CapEx v4", dates);
		SipData4.write(totEquity, prefix + " Common Equity v4", dates);
		SipData4.write(totInterest, prefix + " Interest Paid v4", dates);
		SipData4.write(totResDev, prefix + " Research and Development v4", dates);
		SipData4.write(totBvDollar, prefix + " Book Value v4", dates);
		SipData4.write(totBVminusGW, prefix + " Book Value less Goodwill v4", dates);
		SipData4.write(totMktCap, prefix + " Market Cap v4", dates);

		SipData4.write(totEps, prefix + " EPS v4", dates);
		SipData4.write(totPE, prefix + " PE v4", dates);

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

					sales.add(sc.getData4("sales", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					ebit.add(sc.getData4("ebit", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					taxes.add(sc.getData4("taxes", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					incomeEps.add(sc.getData4("incomeEps", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					cashOps.add(sc.getData4("cashOps", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					cashInv.add(sc.getData4("cashInv", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					cashFin.add(sc.getData4("cashFin", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));

					dividend.add(sc.getData4("dividend", line, DataSet4.dMode.ACCUMULATION, 1.0));

					capEx.add(sc.getData4("capEx", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					final DataSet4 s = sc.getData4("shares", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION);
					shares.add(s);

					cash.add(sc.getData4("cash", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					assets.add(sc.getData4("assets", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					liabilities.add(sc.getData4("liabilities", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					accRx.add(sc.getData4("Accounts Receivable", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					accTx.add(sc.getData4("Accounts Payable", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					goodwill.add(sc.getData4("Goodwill", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					ltDebt.add(sc.getData4("LT Debt", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
					equity.add(sc.getData4("Common Equity", line, DataSet4.dMode.SEQUENTIAL, SipCommon.MILLION));
				}
			}
		}
		companyKnt = knt;
	}

	public static void readDataFile_2(final String filename) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					sc.reset();

					interest.add(sc.getData4("interest", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					resDev.add(sc.getData4("R and D", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));

					bookValue.add(sc.getData4("Book Value per Share", line, DataSet4.dMode.SEQUENTIAL, 1.0));
					prices.add(sc.getData4("Prices", line, DataSet4.dMode.SEQUENTIAL, 1.0));
				}
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param ds
	 * @param fname
	 * @throws FileNotFoundException
	 */
	public static void write(final DataSet4 ds, final String fname, final DateSet dates) throws FileNotFoundException {

		if (ds.mode == DataSet4.dMode.SEQUENTIAL) {
			SipData4.writeDataSequential(ds, fname, dates);
		}
		else {
			SipData4.writeDataAccumulate(ds, fname, dates);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void write(final PrintWriter pw, final DateSet.Quarter q, final double val) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void write(final PrintWriter pw, final DateSet.Quarter q, final Double val[]) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val[0]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val[1]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val[2]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val[3]);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataAccumulate
	 *
	 * @param ds
	 * @param fname
	 */
	private static void writeDataAccumulate(final DataSet4 ds, final String fname, final DateSet dates) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			SipData4.write(pw, dates.y7, ds.y7);
			SipData4.write(pw, dates.y6, ds.y6);
			SipData4.write(pw, dates.y5, ds.y5);
			SipData4.write(pw, dates.y4, ds.y4);
			SipData4.write(pw, dates.y3, ds.y3);
			SipData4.write(pw, dates.y2, ds.y2);
			final Double[] qtrly = new Double[4];
			qtrly[0] = ds.q8 + ds.q7 + ds.q6 + ds.q5;
			qtrly[1] = ds.q7 + ds.q6 + ds.q5 + ds.q4;
			qtrly[2] = ds.q6 + ds.q5 + ds.q4 + ds.q3;
			qtrly[3] = ds.q5 + ds.q4 + ds.q3 + ds.q2;
			SipData4.write(pw, dates.y1, qtrly);
			final double ttm = +ds.q4 + ds.q3 + ds.q2 + ds.q1;
			if (dates.y0.q1.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q1.getTime()), qtrly[0]);
			}
			if (dates.y0.q2.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q2.getTime()), qtrly[1]);
			}
			if (dates.y0.q3.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q3.getTime()), qtrly[2]);
			}
			if (dates.y0.q4.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q4.getTime()), qtrly[3]);
			}

			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ttm);

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
	private static void writeDataSequential(final DataSet4 ds, final String fname, final DateSet dates) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			SipData4.write(pw, dates.y7, ds.y7);
			SipData4.write(pw, dates.y6, ds.y6);
			SipData4.write(pw, dates.y5, ds.y5);
			SipData4.write(pw, dates.y4, ds.y4);
			SipData4.write(pw, dates.y3, ds.y3);
			SipData4.write(pw, dates.y2, ds.y2);
			SipData4.write(pw, dates.y1, ds.q5);

			double y = ds.q1;
			if (y == 0.0) {
				y = ds.q2;
			}
			if (dates.y0.q1.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q1.getTime()), ds.q4);
			}
			if (dates.y0.q2.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q2.getTime()), ds.q3);
			}
			if (dates.y0.q3.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q3.getTime()), ds.q2);
			}
			if (dates.y0.q4.before(dates.ttm)) {
				pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y0.q4.getTime()), ds.q1);
			}
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), y);

		}
	}

}
