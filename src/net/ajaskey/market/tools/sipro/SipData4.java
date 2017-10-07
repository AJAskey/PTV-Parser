
package net.ajaskey.market.tools.sipro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	public static List<ClosingPrices> lastPrice = new ArrayList<>();

	private static int companyKnt = 0;

	/**
	 *
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		SipData4.readClosingPrices("data/closing_price.txt");

		SipData4.readDataFile_1("data/SP-STOCKS.txt", "500");
		SipData4.readDataFile_2("data/SP-STOCKS-B.txt", "500");

		SipData4.processData();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.sipro.processData
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void processData() throws FileNotFoundException, IOException {

		final DataSet4 totSales = DataSet4.sum(sales);
		final DataSet4 totEbit = DataSet4.sum(ebit);
		final DataSet4 totTax = DataSet4.sum(taxes);
		final DataSet4 totIncome = DataSet4.sum(incomeEps);
		final DataSet4 totCops = DataSet4.sum(cashOps);
		final DataSet4 totCfin = DataSet4.sum(cashFin);
		final DataSet4 totCinv = DataSet4.sum(cashInv);
		final DataSet4 totShr = DataSet4.sum(shares);
		final DataSet4 totCash = DataSet4.sum(cash);
		final DataSet4 totAssets = DataSet4.sum(assets);
		final DataSet4 totLiab = DataSet4.sum(liabilities);
		final DataSet4 totAccRx = DataSet4.sum(accRx);
		final DataSet4 totAccTx = DataSet4.sum(accTx);
		final DataSet4 totGoodwill = DataSet4.sum(goodwill);
		final DataSet4 totLtDebt = DataSet4.sum(ltDebt);
		final DataSet4 totCapEx = DataSet4.sum(capEx);
		final DataSet4 totEquity = DataSet4.sum(equity);
		final DataSet4 totInterest = DataSet4.sum(interest);
		final DataSet4 totResDev = DataSet4.sum(resDev);

		final List<DataSet4> divDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(dividend.get(i), shares.get(i));
			divDollar.add(ds);
		}
		final DataSet4 totDivDollar = DataSet4.sum(divDollar);

		final List<DataSet4> bvDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final DataSet4 ds = DataSet4.mult(bookValue.get(i), shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet4 totBvDollar = DataSet4.sum(bvDollar);

		final DataSet4 totBVminusGW = DataSet4.sub(totBvDollar, totGoodwill);

		final List<DataSet4> mcap = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			final double pr = ClosingPrices.getPrice(prices.get(i).ticker);
			final DataSet4 price = prices.get(i);
			price.q1 = pr;
			final DataSet4 ds = DataSet4.mult(price, shares.get(i));
			mcap.add(ds);
		}
		final DataSet4 totMktCap = DataSet4.sum(mcap);

		SipData4.write(totSales, "SPX Sales v4");
		SipData4.write(totEbit, "SPX EBIT v4");
		SipData4.write(totTax, "SPX Taxes v4");
		SipData4.write(totIncome, "SPX Income for EPS v4");
		SipData4.write(totCops, "SPX Cash from Operations v4");
		SipData4.write(totCfin, "SPX Cash from Financing v4");
		SipData4.write(totCinv, "SPX Cash from Investing v4");
		SipData4.write(totDivDollar, "SPX Dividends v4");
		SipData4.write(totShr, "SPX Shares v4");
		SipData4.write(totCash, "SPX Cash v4");
		SipData4.write(totAssets, "SPX Assets v4");
		SipData4.write(totLiab, "SPX Liabilities v4");
		SipData4.write(totAccRx, "SPX Accounts Receivable v4");
		SipData4.write(totAccTx, "SPX Accounts Payable v4");
		SipData4.write(totGoodwill, "SPX Goodwill v4");
		SipData4.write(totLtDebt, "SPX LT Debt v4");
		SipData4.write(totCapEx, "SPX CapEx v4");
		SipData4.write(totEquity, "SPX Common Equity v4");
		SipData4.write(totInterest, "SPX Interest Paid v4");
		SipData4.write(totResDev, "SPX Research and Development v4");
		SipData4.write(totBvDollar, "SPX Book Value v4");
		SipData4.write(totBVminusGW, "SPX Book Value less Goodwill v4");
		SipData4.write(totMktCap, "SPX Market Cap v4");

	}

	/**
	 * net.ajaskey.market.tools.sipro.readClosingPrices
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void readClosingPrices(String filename) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			while (line != null) {
				line = br.readLine();
				try {
					final String fld[] = line.split("\t");
					new ClosingPrices(fld[0].trim(), fld[1].trim());
				} catch (final Exception e) {
				}
			}
		}

		//for (final ClosingPrices cp : ClosingPrices.priceList) {
		//	System.out.println(cp);
		//}

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void readDataFile_1(String filename, String index) throws FileNotFoundException, IOException {

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

	public static void readDataFile_2(String filename, String index) throws FileNotFoundException, IOException {

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

	//	private static DataSet4 getData(String name, String[] fld, DataSet4.dMode mode, double scaler) {
	//
	//		final int INC = 14;
	//
	//		final DataSet4 ds = new DataSet4(name, fld[0].trim(), fld, ptr, mode);
	//		DataSet4 dsRet = DataSet4.scale(ds, scaler);
	//		//System.out.println(dsRet);
	//		ptr += INC;
	//		return dsRet;
	//	}

	public static void write(DataSet4 ds, String fname) throws FileNotFoundException {

		if (ds.mode == DataSet4.dMode.SEQUENTIAL) {
			SipData4.writeDataSequential(ds, fname);
		} else {
			SipData4.writeDataAccumulate(ds, fname);
		}
	}

	private static void write(PrintWriter pw, DateSet.Quarter q, double val) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val);
	}

	private static void write(PrintWriter pw, DateSet.Quarter q, Double val[]) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val[0]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val[1]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val[2]);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val[3]);
	}

	private static void writeDataAccumulate(DataSet4 ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

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
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeDataSequential(DataSet4 ds, String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

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
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), y);

		}
	}

}
