
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

	public static List<DataSet3>	sales			= new ArrayList<>();
	public static List<DataSet3>	ebit			= new ArrayList<>();
	public static List<DataSet3>	taxes			= new ArrayList<>();
	public static List<DataSet3>	incomeEps	= new ArrayList<>();
	public static List<DataSet3>	cashOps		= new ArrayList<>();
	public static List<DataSet3>	cashFin		= new ArrayList<>();
	public static List<DataSet3>	cashInv		= new ArrayList<>();
	public static List<DataSet3>	dividend	= new ArrayList<>();
	public static List<DataSet3>	shares		= new ArrayList<>();

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

		SipData3.read("data/SP500-SIP3.csv", "SPX");
		//SipData.read("data/NDX-SIP.csv", "NDX");

	}

	private static int	ptr	= 0;
	final static int		INC	= 14;

	private static DataSet3 getData(String name, String[] fld, DataSet3.dMode mode) {

		final DataSet3 dsRet = new DataSet3(name, fld[0], fld, ptr, mode);
		//System.out.println(dsRet);
		ptr += INC;
		return dsRet;
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

					ptr = 0;

					sales.add(getData("sales", fld, DataSet3.dMode.ACCUMULATION));
					ebit.add(getData("ebit", fld, DataSet3.dMode.ACCUMULATION));
					taxes.add(getData("taxes", fld, DataSet3.dMode.ACCUMULATION));
					incomeEps.add(getData("incomeEps", fld, DataSet3.dMode.ACCUMULATION));
					cashOps.add(getData("cashOps", fld, DataSet3.dMode.ACCUMULATION));
					cashInv.add(getData("cashInv", fld, DataSet3.dMode.ACCUMULATION));
					cashFin.add(getData("cashFin", fld, DataSet3.dMode.ACCUMULATION));
					dividend.add(getData("dividend", fld, DataSet3.dMode.ACCUMULATION));

					shares.add(getData("shares", fld, DataSet3.dMode.SEQUENTIAL));

				}
			}
		}

		final DataSet3 totSales = DataSet3.sum(sales);
		final DataSet3 totEbit = DataSet3.sum(ebit);
		final DataSet3 totTax = DataSet3.sum(taxes);
		final DataSet3 totIncome = DataSet3.sum(incomeEps);
		final DataSet3 totCops = DataSet3.sum(cashOps);
		final DataSet3 totCfin = DataSet3.sum(cashFin);
		final DataSet3 totCinv = DataSet3.sum(cashInv);
		final DataSet3 totDiv = DataSet3.sum(dividend);
		final DataSet3 totShr = DataSet3.sum(shares);

		if (src.equalsIgnoreCase("SPX")) {
			SipData3.write(totSales, "SPX Sales v3");
			SipData3.write(totEbit, "SPX EBIT v3");
			SipData3.write(totTax, "SPX Taxes v3");
			SipData3.write(totIncome, "SPX Income for EPS v3");
			SipData3.write(totCops, "SPX Cash from Operations v3");
			SipData3.write(totCfin, "SPX Cash from Financing v3");
			SipData3.write(totCinv, "SPX Cash from Investing v3");
			SipData3.write(totDiv, "SPX Dividends v3");
			SipData3.write(totShr, "SPX Shares v3");
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

	private static void write(DataSet3 ds, String fname) throws FileNotFoundException {

		if (ds.mode == DataSet3.dMode.SEQUENTIAL) {
			writeDataSequential(ds, fname);
		} else {
			writeData(ds, fname);
		}
	}

	private static void writeDataSequential(DataSet3 ds, String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			write(pw, dates.y7, ds.y7);
			write(pw, dates.y6, ds.y6);
			write(pw, dates.y5, ds.y5);
			write(pw, dates.y4, ds.y4);
			write(pw, dates.y3, ds.y3);
			write(pw, dates.y2, ds.y2);
			write(pw, dates.y1, ds.q5);
			double y = ds.q1;
			if (y == 0.0) {
				y = ds.q2;
			}
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), y);

		}
	}

	private static void writeData(DataSet3 ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			write(pw, dates.y7, ds.y7);
			write(pw, dates.y6, ds.y6);
			write(pw, dates.y5, ds.y5);
			write(pw, dates.y4, ds.y4);
			write(pw, dates.y3, ds.y3);
			write(pw, dates.y2, ds.y2);
			Double[] qtrly = new Double[4];
			qtrly[0] = ds.q8 + ds.q7 + ds.q6 + ds.q5;
			qtrly[1] = ds.q7 + ds.q6 + ds.q5 + ds.q4;
			qtrly[2] = ds.q6 + ds.q5 + ds.q4 + ds.q3;
			qtrly[3] = ds.q5 + ds.q4 + ds.q3 + ds.q2;
			write(pw, dates.y1, qtrly);
			double ttm = +ds.q4 + ds.q3 + ds.q2 + ds.q1;
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
