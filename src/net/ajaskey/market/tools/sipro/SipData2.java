
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
public class SipData2 {

	public static List<DataSet>	sales			= new ArrayList<>();
	public static List<DataSet>	ebit			= new ArrayList<>();
	public static List<DataSet>	taxes			= new ArrayList<>();
	public static List<DataSet>	incomeEps	= new ArrayList<>();
	public static List<DataSet>	cashOps		= new ArrayList<>();
	public static List<DataSet>	cashFin		= new ArrayList<>();
	public static List<DataSet>	cashInv		= new ArrayList<>();
	public static List<DataSet>	dividend	= new ArrayList<>();
	public static List<DataSet>	divDollar	= new ArrayList<>();
	public static List<DataSet>	shares		= new ArrayList<>();

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 *
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		SipData2.read("data/SP500-SIP2.csv", "SPX");
		//SipData.read("data/NDX-SIP.csv", "NDX");

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void read(String filename, String src) throws FileNotFoundException, IOException {

		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					final String fld[] = line.split(",");

					knt++;
					System.out.println(knt + " : " + fld[0]);

					final DataSet sale = new DataSet("sales", fld[0], fld, 0, "quarter");
					sales.add(sale);
					//System.out.println(sale);

					final DataSet eb = new DataSet("ebit", fld[0], fld, 14, "quarter");
					ebit.add(eb);
					//System.out.println(ebit);

					final DataSet tx = new DataSet("taxes", fld[0], fld, 28, "quarter");
					taxes.add(tx);
					//System.out.println(tx);

					final DataSet incEps = new DataSet("Income for EPS", fld[0], fld, 42, "quarter");
					incomeEps.add(incEps);
					//System.out.println(incEps);

					final DataSet ops = new DataSet("Cash From Operations", fld[0], fld, 56, "quarter");
					cashOps.add(ops);
					//System.out.println(cashOps);

					final DataSet inv = new DataSet("Cash From Investing", fld[0], fld, 70, "quarter");
					cashInv.add(inv);
					//System.out.println(cashInv);

					final DataSet fin = new DataSet("Cash From Financing", fld[0], fld, 84, "quarter");
					cashFin.add(fin);
					//System.out.println(cashFin);

					final DataSet div = new DataSet("Dividend", fld[0], fld, 98, "quarter");
					dividend.add(div);
					//System.out.println(dividend);

					final DataSet shr = new DataSet("Shares", fld[0], fld, 112);
					shares.add(shr);
					//System.out.println(shares);

					final double cpyKnt = 1.0 / knt;
					final DataSet companies = new DataSet(cpyKnt);
					for (int i = 0; i < dividend.size(); i++) {
						final DataSet ds = DataSet.mult(dividend.get(i), shares.get(i));
						final DataSet ds1 = DataSet.mult(ds, companies);
						divDollar.add(ds1);
					}
				}
			}
		}

		final DataSet totSales = DataSet.sum(sales);
		final DataSet totEbit = DataSet.sum(ebit);
		final DataSet totTaxes = DataSet.sum(taxes);
		final DataSet totIncomeEps = DataSet.sum(incomeEps);
		final DataSet totCashOps = DataSet.sum(cashOps);
		final DataSet totCashFin = DataSet.sum(cashFin);
		final DataSet totCashInv = DataSet.sum(cashInv);
		final DataSet totDiv = DataSet.sum(divDollar);

		if (src.equalsIgnoreCase("SPX")) {
			SipData2.writeData(totSales, "SPX Sales v2");
			SipData2.writeData(totEbit, "SPX EBIT v2");
			SipData2.writeData(totTaxes, "SPX Taxes v2");
			SipData2.writeData(totIncomeEps, "SPX Income for EPS v2");
			SipData2.writeData(totCashOps, "SPX Cash From Operations v2");
			SipData2.writeData(totCashFin, "SPX Cash From Financing v2");
			SipData2.writeData(totCashInv, "SPX Cash From Investing v2");
			SipData2.writeData(totDiv, "SPX Dividends v2");
		}
	}

	private static void write(PrintWriter pw, DateSet.Quarter q, double val) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val);
	}

	private static void writeData(DataSet ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			SipData2.write(pw, dates.y7, ds.y7);
			SipData2.write(pw, dates.y6, ds.y6);
			SipData2.write(pw, dates.y5, ds.y5);
			SipData2.write(pw, dates.y4, ds.y4);
			SipData2.write(pw, dates.y3, ds.y3);
			SipData2.write(pw, dates.y2, ds.y2);
			SipData2.write(pw, dates.y1, ds.y1);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ds.ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
