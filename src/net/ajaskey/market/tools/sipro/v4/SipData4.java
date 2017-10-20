
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

	private static int companyKnt = 0;

	//static String path = "output\\SIP\\";
	static String path = OptumaCommon.optumaPath+"\\SIP\\";

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

		SipData4.readDataFile_1("data/SP-STOCKS.txt");
		SipData4.readDataFile_2("data/SP-STOCKS-B.txt");

		SipData4.processData("500");
		//SipData4.processData("MidCap 400");
		//SipData4.processData("SmallCap 600");
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
		} else if (index.equalsIgnoreCase("MidCap 400")) {
			SipData4.indexPrices = LongTermOHLCV.getData("SP400");
			prefix = "SP400";
		} else if (index.equalsIgnoreCase("SmallCap 600")) {
			SipData4.indexPrices = LongTermOHLCV.getData("SP600");
			prefix = "SP600";
		} else {
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

		//		final List<DataSet4> mcap = new ArrayList<>();
		//		for (int i = 0; i < companyKnt; i++) {
		//			final double pr = ClosingPrices.getPrice(prices.get(i).ticker);
		//			final DataSet4 value = prices.get(i);
		//			value.q1 = pr;
		//			final DataSet4 ds = DataSet4.mult(value, shares.get(i));
		//			mcap.add(ds);
		//		}
		//		final DataSet4 totMktCap = DataSet4.sum(mcap, index);

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
		//SipData4.write(totMktCap, prefix + " Market Cap v4", dates);

		SipData4.writeEps(totIncome, totShr, prefix + " EPS v4", prefix + " EPS Annual v4", prefix + " PE v4", dates,
		    dsPrices);

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
	private static void writeEps(DataSet4 totIncome, DataSet4 totShr, String epsStr, String epsannualStr, String peStr,
	    DateSet dates, DataSet4 dsPrices) throws FileNotFoundException {

		final DataSet4 totEps = DataSet4.scale(DataSet4.div(totIncome, totShr), 36.0);
		SipData4.write(totEps, epsStr, dates);

		totEps.mode = DataSet4.dMode.SEQUENTIAL;
		SipData4.write(totEps, epsannualStr, dates);

		final DataSet4 totPE = DataSet4.scale(DataSet4.div(dsPrices, totEps), 1.0);
		totPE.mode = DataSet4.dMode.SEQUENTIAL;
		SipData4.write(totPE, peStr, dates);

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
				if (line != null && line.length() > 0) {

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

	public static void readDataFile_2(String filename) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			final SipCommon sc = new SipCommon("\t", 14, 4);

			while (line != null) {
				line = br.readLine();
				if (line != null && line.length() > 0) {

					sc.reset();

					SipData4.interest.add(sc.getData4("interest", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));
					SipData4.resDev.add(sc.getData4("R and D", line, DataSet4.dMode.ACCUMULATION, SipCommon.MILLION));

					SipData4.bookValue.add(sc.getData4("Book Value per Share", line, DataSet4.dMode.SEQUENTIAL, 1.0));
					SipData4.prices.add(sc.getData4("Prices", line, DataSet4.dMode.SEQUENTIAL, 1.0));
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
	public static void write(DataSet4 ds, String fname, DateSet dates) throws FileNotFoundException {

		if (ds.mode == DataSet4.dMode.SEQUENTIAL) {
			SipData4.writeDataSequential(ds, fname, dates);
		} else {
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
	private static void writeAvgQtr(PrintWriter pw, DateSet.Quarters y1, DateSet.Quarters y0, double q8, double q7,
	    double q6, double q5, double q4, double q3, double q2, double q1) {

		double tmp = q8 * 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q1.date.getTime()), tmp);

		tmp = q8 * 3.0 + q7;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q2.date.getTime()), tmp);

		tmp = q8 * 2.0 + q7 + q6;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q3.date.getTime()), tmp);

		tmp = q8 + q7 + q6 + q5;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y1.q4.date.getTime()), tmp);

		tmp = q7 + q6 + q5 + q4;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q1.date.getTime()), tmp);

		tmp = q6 + q5 + q4 + q3;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q2.date.getTime()), tmp);

		tmp = q5 + q4 + q3 + q2;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q3.date.getTime()), tmp);

		tmp = q4 + q3 + q2 + q1;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(y0.q4.date.getTime()), tmp);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.write
	 *
	 * @param pw
	 * @param q
	 * @param val
	 */
	private static void write(PrintWriter pw, DateSet.Quarters q, double val) {

		final double qval = val / 4.0;
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q1.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q2.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q3.date.getTime()), qval);
		pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(q.q4.date.getTime()), qval);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.writeDataAccumulate
	 *
	 * @param ds
	 * @param fname
	 */
	private static void writeDataAccumulate(DataSet4 ds, String fname, DateSet dates) {

		try (PrintWriter pw = new PrintWriter(SipData4.path + fname + ".csv")) {

			SipData4.write(pw, dates.y7, ds.y7);
			SipData4.write(pw, dates.y6, ds.y6);
			SipData4.write(pw, dates.y5, ds.y5);
			SipData4.write(pw, dates.y4, ds.y4);
			SipData4.write(pw, dates.y3, ds.y3);
			SipData4.write(pw, dates.y2, ds.y3);
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
	private static void writeDataSequential(DataSet4 ds, String fname, DateSet dates) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(SipData4.path + fname + ".csv")) {

			//SipData4.write(pw, dates.y1, dates.y0, ds.q8, ds.q7, ds.q6, ds.q5, ds.q4, ds.q3, ds.q2, ds.q1);

			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y7.q4.date.getTime()), ds.y7);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y6.q4.date.getTime()), ds.y6);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y5.q4.date.getTime()), ds.y5);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y4.q4.date.getTime()), ds.y4);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y3.q4.date.getTime()), ds.y3);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y2.q4.date.getTime()), ds.y2);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y1.q4.date.getTime()), ds.y1);
			pw.printf("%s,%.2f%n", SipData4.sdfOptuma.format(dates.y0.q4.date.getTime()), ds.y0);

			//			SipData4.write(pw, dates.y7, ds.y7);
			//			SipData4.write(pw, dates.y6, ds.y6);
			//			SipData4.write(pw, dates.y5, ds.y5);
			//			SipData4.write(pw, dates.y4, ds.y4);
			//			SipData4.write(pw, dates.y3, ds.y3);
			//			SipData4.write(pw, dates.y2, ds.y2);
			//			SipData4.write(pw, dates.y1, ds.y1);
			//			SipData4.write(pw, dates.y0, ds.y0);

		}
	}

}
