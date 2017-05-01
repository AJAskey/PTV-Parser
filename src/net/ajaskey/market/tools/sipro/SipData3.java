
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

		SipData3.read("data/SP500-SIP2.csv", "SPX");
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

			final int INC = 14;
			
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					final String fld[] = line.split(",");

					knt++;
					System.out.println(knt + " : " + fld[0]);
					
					int ptr = 0;

					final DataSet3 sale = new DataSet3("sales", fld[0], fld, ptr);
					sales.add(sale);
					System.out.println(sale);

					ptr += INC;

				}
			}
		}
		
		final DataSet3 totSales = DataSet3.sum(sales);


		if (src.equalsIgnoreCase("SPX")) {
			SipData3.writeData(totSales, "SPX Sales v3");
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
			double ttm = + ds.q4 + ds.q3 + ds.q2 + ds.q1;
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
