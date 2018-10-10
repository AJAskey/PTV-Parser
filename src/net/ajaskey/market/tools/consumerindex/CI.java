
package net.ajaskey.market.tools.consumerindex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.optuma.OptumaCommon;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class CI {

	final static public SimpleDateFormat	sdf				= new SimpleDateFormat("MM/dd/yyyy");
	final static public SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * net.ajaskey.market.tools.consumerindex.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			processIndex("data/indexdata.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Calendar getDate(String fld) {

		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(fld));
		} catch (ParseException e) {
			cal = null;
		}
		return cal;
	}

	private static double parseDouble(String fld) {

		try {
			double d = Double.parseDouble(fld.trim());
			return d;
		} catch (Exception e) {
			return 0.0;
		}
	}

	private static void processIndex(String fname) throws FileNotFoundException, IOException {

		/**
		 * 
		 * Date,Automotive,Entertainment,Financial,Health,Household,Housing,Recreation,Retail,Technology,Travel,Composite,
		 * 91-Day %,183-Day %,365-Day %,91-Day Growth,183-Day Growth,365-Day Growth
		 * 
		 */
		try (BufferedReader reader = new BufferedReader(new FileReader(fname));
		    PrintWriter pw01 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "auto_ci.csv");
		    PrintWriter pw02 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "entertain_ci.csv");
		    PrintWriter pw03 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "finance_ci.csv");
		    PrintWriter pw04 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "health_ci.csv");
		    PrintWriter pw05 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "household_ci.csv");
		    PrintWriter pw06 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "housing_ci.csv");
		    PrintWriter pw07 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "rec_ci.csv");
		    PrintWriter pw08 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "retail_ci.csv");
		    PrintWriter pw09 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "tech_ci.csv");
		    PrintWriter pw10 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "travel_ci.csv");
		    PrintWriter pw11 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "composite_ci.csv");
		    PrintWriter pw12 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "composite_g91_ci.csv");
		    PrintWriter pw13 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "composite_g183_ci.csv");
		    PrintWriter pw14 = new PrintWriter(OptumaCommon.optumaPath + "/CI/" + "composite_g365_ci.csv")) {

			//skip header
			String line = reader.readLine();

			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				String fld[] = str.split(",");
				Calendar currdate = getDate(fld[0].trim());
				if (currdate != null) {
					double d = parseDouble(fld[1]);
					String date = sdfOptuma.format(currdate.getTime());
					pw01.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[2]);
					pw02.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[3]);
					pw03.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[4]);
					pw04.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[5]);
					pw05.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[6]);
					pw06.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[7]);
					pw07.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[8]);
					pw08.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[9]);
					pw09.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[10]);
					pw10.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[11]);
					pw11.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[15]);
					pw12.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[16]);
					pw13.printf("%s, %.2f%n", date, d);

					d = parseDouble(fld[17]);
					pw14.printf("%s, %.2f%n", date, d);

				} else {
					break;
				}
			}
		}

	}

}
