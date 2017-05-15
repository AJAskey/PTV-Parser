
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
public class SipData3 {

	public static List<DataSet3>	sales				= new ArrayList<>();
	public static List<DataSet3>	ebit				= new ArrayList<>();
	public static List<DataSet3>	taxes				= new ArrayList<>();
	public static List<DataSet3>	incomeEps		= new ArrayList<>();
	public static List<DataSet3>	cashOps			= new ArrayList<>();
	public static List<DataSet3>	cashFin			= new ArrayList<>();
	public static List<DataSet3>	cashInv			= new ArrayList<>();
	public static List<DataSet3>	dividend		= new ArrayList<>();
	public static List<DataSet3>	shares			= new ArrayList<>();
	public static List<DataSet3>	cash				= new ArrayList<>();
	public static List<DataSet3>	assets			= new ArrayList<>();
	public static List<DataSet3>	liabilities	= new ArrayList<>();
	public static List<DataSet3>	accTx				= new ArrayList<>();
	public static List<DataSet3>	accRx				= new ArrayList<>();
	public static List<DataSet3>	goodwill		= new ArrayList<>();
	public static List<DataSet3>	ltDebt			= new ArrayList<>();
	public static List<DataSet3>	capEx				= new ArrayList<>();
	public static List<DataSet3>	equity			= new ArrayList<>();
	public static List<DataSet3>	interest		= new ArrayList<>();
	public static List<DataSet3>	resDev			= new ArrayList<>();
	public static List<DataSet3>	bookValue		= new ArrayList<>();
	public static List<DataSet3>	prices			= new ArrayList<>();

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	public static List<ClosingPrices> lastPrice = new ArrayList<>();

	private static int					companyKnt	= 0;

	/**
	 *
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		readClosingPrices("data/closing_price.txt");

		final String group = "SML";

		if (group.contains("SPX")) {
			SipData3.readDataFile_1("data/SP500-SIP3.txt");
			SipData3.readDataFile_2("data/SP500-SIP3b.txt");
		} else if (group.contains("SML")) {
			SipData3.readDataFile_1("data/SP600-SIP3.txt");
			SipData3.readDataFile_2("data/SP600-SIP3b.txt");
		} else {
			return;
		}

		processData(group);
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
					String fld[] = line.split("\t");
					new ClosingPrices(fld[0].trim(), fld[1].trim());
				} catch (Exception e) {
				}
			}
		}

		for (ClosingPrices cp : ClosingPrices.priceList) {
			System.out.println(cp);
		}

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
			String line = "";

			//line = br.readLine(); // read header
			SipCommon sc = new SipCommon("\t", 14);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

//					final String fld[] = line.split("\t");
//					System.out.println(knt + " : " + fld[0]);

					knt++;
					sc.reset();

					sales.add(sc.getData("sales", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					ebit.add(sc.getData("ebit", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					taxes.add(sc.getData("taxes", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					incomeEps.add(sc.getData("incomeEps", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					cashOps.add(sc.getData("cashOps", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					cashInv.add(sc.getData("cashInv", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					cashFin.add(sc.getData("cashFin", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));

					dividend.add(sc.getData("dividend", line, DataSet3.dMode.ACCUMULATION, 1.0));

					capEx.add(sc.getData("capEx", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					DataSet3 s = sc.getData("shares", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
					shares.add(s);

					cash.add(sc.getData("cash", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					assets.add(sc.getData("assets", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					liabilities.add(sc.getData("liabilities", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					accRx.add(sc.getData("Accounts Receivable", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					accTx.add(sc.getData("Accounts Payable", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					goodwill.add(sc.getData("Goodwill", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					ltDebt.add(sc.getData("LT Debt", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					equity.add(sc.getData("Common Equity", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));

				}
			}
		}
		companyKnt = knt;
	}

	public static void readDataFile_2(String filename) throws FileNotFoundException, IOException {

		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			SipCommon sc = new SipCommon("\t", 14);

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					sc.reset();

					knt++;

					interest.add(sc.getData("interest", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					resDev.add(sc.getData("R and D", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));

					bookValue.add(sc.getData("Book Value per Share", line, DataSet3.dMode.SEQUENTIAL, 1.0));
					prices.add(sc.getData("Prices", line, DataSet3.dMode.SEQUENTIAL, 1.0));

				}
			}
		}
	}

	public static void processData(String src) throws FileNotFoundException, IOException {

		final DataSet3 totSales = DataSet3.sum(sales);
		final DataSet3 totEbit = DataSet3.sum(ebit);
		final DataSet3 totTax = DataSet3.sum(taxes);
		final DataSet3 totIncome = DataSet3.sum(incomeEps);
		final DataSet3 totCops = DataSet3.sum(cashOps);
		final DataSet3 totCfin = DataSet3.sum(cashFin);
		final DataSet3 totCinv = DataSet3.sum(cashInv);
		final DataSet3 totShr = DataSet3.sum(shares);
		final DataSet3 totCash = DataSet3.sum(cash);
		final DataSet3 totAssets = DataSet3.sum(assets);
		final DataSet3 totLiab = DataSet3.sum(liabilities);
		final DataSet3 totAccRx = DataSet3.sum(accRx);
		final DataSet3 totAccTx = DataSet3.sum(accTx);
		final DataSet3 totGoodwill = DataSet3.sum(goodwill);
		final DataSet3 totLtDebt = DataSet3.sum(ltDebt);
		final DataSet3 totCapEx = DataSet3.sum(capEx);
		final DataSet3 totEquity = DataSet3.sum(equity);
		final DataSet3 totInterest = DataSet3.sum(interest);
		final DataSet3 totResDev = DataSet3.sum(resDev);

		List<DataSet3> divDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			DataSet3 ds = DataSet3.mult(dividend.get(i), shares.get(i));
			divDollar.add(ds);
		}
		final DataSet3 totDivDollar = DataSet3.sum(divDollar);

		List<DataSet3> bvDollar = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			DataSet3 ds = DataSet3.mult(bookValue.get(i), shares.get(i));
			bvDollar.add(ds);
		}
		final DataSet3 totBvDollar = DataSet3.sum(bvDollar);

		final DataSet3 totBVminusGW = DataSet3.sub(totBvDollar, totGoodwill);

		List<DataSet3> mcap = new ArrayList<>();
		for (int i = 0; i < companyKnt; i++) {
			double pr = ClosingPrices.getPrice(prices.get(i).ticker);
			DataSet3 price = prices.get(i);
			price.q1 = pr;
			DataSet3 ds = DataSet3.mult(price, shares.get(i));
			mcap.add(ds);
		}
		final DataSet3 totMktCap = DataSet3.sum(mcap);

		if (src.equalsIgnoreCase("SPX")) {
			SipData3.write(totSales, "SPX Sales v3");
			SipData3.write(totEbit, "SPX EBIT v3");
			SipData3.write(totTax, "SPX Taxes v3");
			SipData3.write(totIncome, "SPX Income for EPS v3");
			SipData3.write(totCops, "SPX Cash from Operations v3");
			SipData3.write(totCfin, "SPX Cash from Financing v3");
			SipData3.write(totCinv, "SPX Cash from Investing v3");
			SipData3.write(totDivDollar, "SPX Dividends v3");
			SipData3.write(totShr, "SPX Shares v3");
			SipData3.write(totCash, "SPX Cash v3");
			SipData3.write(totAssets, "SPX Assets v3");
			SipData3.write(totLiab, "SPX Liabilities v3");
			SipData3.write(totAccRx, "SPX Accounts Receivable v3");
			SipData3.write(totAccTx, "SPX Accounts Payable v3");
			SipData3.write(totGoodwill, "SPX Goodwill v3");
			SipData3.write(totLtDebt, "SPX LT Debt v3");
			SipData3.write(totCapEx, "SPX CapEx v3");
			SipData3.write(totEquity, "SPX Common Equity v3");
			SipData3.write(totInterest, "SPX Interest Paid v3");
			SipData3.write(totResDev, "SPX Research and Development v3");
			SipData3.write(totBvDollar, "SPX Book Value v3");
			SipData3.write(totBVminusGW, "SPX Book Value less Goodwill v3");
			SipData3.write(totMktCap, "SPX Market Cap v3");
		} else if (src.equalsIgnoreCase("SML")) {
			SipData3.write(totSales, "SP600 Sales");
			SipData3.write(totTax, "SP600 Taxes");
			SipData3.write(totIncome, "SP600 Income for EPS");
			SipData3.write(totCops, "SP600 Cash from Operations");
			SipData3.write(totCfin, "SP600 Cash from Financing");
			SipData3.write(totCinv, "SP600 Cash from Investing");
			SipData3.write(totShr, "SP600 Shares");
			SipData3.write(totCash, "SP600 Cash");
			SipData3.write(totAccRx, "SP600 Accounts Receivable");
			SipData3.write(totAccTx, "SP600 Accounts Payable");
			SipData3.write(totLtDebt, "SP600 LT Debt");
			SipData3.write(totEquity, "SP600 Common Equity");
			SipData3.write(totInterest, "SP600 Interest Paid");
			SipData3.write(totBvDollar, "SP600 Book Value");
			SipData3.write(totMktCap, "SP600 Market Cap");
		}
	}

//	private static DataSet3 getData(String name, String[] fld, DataSet3.dMode mode, double scaler) {
//
//		final int INC = 14;
//
//		final DataSet3 ds = new DataSet3(name, fld[0].trim(), fld, ptr, mode);
//		DataSet3 dsRet = DataSet3.scale(ds, scaler);
//		//System.out.println(dsRet);
//		ptr += INC;
//		return dsRet;
//	}

	public static void write(DataSet3 ds, String fname) throws FileNotFoundException {

		if (ds.mode == DataSet3.dMode.SEQUENTIAL) {
			SipData3.writeDataSequential(ds, fname);
		} else {
			SipData3.writeDataAccumulate(ds, fname);
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

	private static void writeDataAccumulate(DataSet3 ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			SipData3.write(pw, dates.y7, ds.y7);
			SipData3.write(pw, dates.y6, ds.y6);
			SipData3.write(pw, dates.y5, ds.y5);
			SipData3.write(pw, dates.y4, ds.y4);
			SipData3.write(pw, dates.y3, ds.y3);
			SipData3.write(pw, dates.y2, ds.y2);
			final Double[] qtrly = new Double[4];
			qtrly[0] = ds.q8 + ds.q7 + ds.q6 + ds.q5;
			qtrly[1] = ds.q7 + ds.q6 + ds.q5 + ds.q4;
			qtrly[2] = ds.q6 + ds.q5 + ds.q4 + ds.q3;
			qtrly[3] = ds.q5 + ds.q4 + ds.q3 + ds.q2;
			SipData3.write(pw, dates.y1, qtrly);
			final double ttm = +ds.q4 + ds.q3 + ds.q2 + ds.q1;
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeDataSequential(DataSet3 ds, String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			SipData3.write(pw, dates.y7, ds.y7);
			SipData3.write(pw, dates.y6, ds.y6);
			SipData3.write(pw, dates.y5, ds.y5);
			SipData3.write(pw, dates.y4, ds.y4);
			SipData3.write(pw, dates.y3, ds.y3);
			SipData3.write(pw, dates.y2, ds.y2);
			SipData3.write(pw, dates.y1, ds.q5);
			double y = ds.q1;
			if (y == 0.0) {
				y = ds.q2;
			}
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), y);

		}
	}

}
