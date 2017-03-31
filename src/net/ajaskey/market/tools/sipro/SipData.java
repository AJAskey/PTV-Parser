
package net.ajaskey.market.tools.sipro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.ConvertOHLCV;
import net.ajaskey.market.tools.helpers.OhlcvData;

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
public class SipData {

	private static final int MAX_FIELDS = 19;

	public static List<DataSet>	grossIncome		= new ArrayList<>();
	public static List<DataSet>	unusualIncome	= new ArrayList<>();

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void read(String filename) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";
			line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if (line != null && line.length() > 0) {

					final String fld[] = line.split(",");
					if (fld.length == MAX_FIELDS) {
						
						String[] s = Arrays.copyOfRange(fld, 0, 10);

						DataSet gi = new DataSet(s);
						// gi = new DataSet(fld[0], fld[1], fld[2], fld[3], fld[4], fld[5], fld[6], fld[7], fld[8], fld[9]);
						System.out.println(gi);
						grossIncome.add(gi);

						s = Arrays.copyOfRange(fld, 10, 20);
						DataSet ui = new DataSet(s);
						System.out.println(ui);
						unusualIncome.add(ui);
					}
				}
			}
		}
		DataSet totGI = DataSet.sum(grossIncome);
		System.out.println("GI : \n" + totGI);
		DataSet totUI = DataSet.sum(unusualIncome);
		System.out.println("UI : \n" + totUI);

		DataSet net = DataSet.sub(totGI, totUI);
		System.out.println("Net : \n" + net);
		
		writeData(totGI, "tmp");

	}

	private static void writeData(DataSet ds, String fname) {

		try (PrintWriter pw = new PrintWriter(ConvertOHLCV.shortPath + "\\" + fname + ".csv")) {

			DateSet dates = new DateSet();

			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y8.getTime()), ds.y8);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y7.getTime()), ds.y7);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y6.getTime()), ds.y6);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y5.getTime()), ds.y5);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y4.getTime()), ds.y4);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y3.getTime()), ds.y3);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y2.getTime()), ds.y2);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y1.getTime()), ds.y1);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ds.ttm);

		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		read("data/data.csv");

	}

}
