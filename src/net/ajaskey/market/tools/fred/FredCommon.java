
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class FredCommon {

	public final static String optumaPath = "C:/Users/ajask_000/Documents/Market Analyst 8/CSV Data/FRED/";

	/**
	 * net.ajaskey.market.tools.fred.getShortTitle
	 *
	 * @param title
	 * @return
	 */
	public static String getShortTitle(String title) {

		final String s1 = title.replaceAll("Disposable Personal Income", "DPI")
		    .replaceAll("Personal Consumption Expenditures", "PCE").replaceAll("London Interbank Offered Rate", "");
		final String s2 = s1.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(", based on U.S. Dollar", "")
		    .replaceAll("  ", " ");
		final String s3 = s2.replaceAll("Compensation of Employees, Received: ", "");
		final String s4 = s3.replaceAll("\\s+", "");
		return s4.trim();
	}

	/**
	 * net.ajaskey.market.tools.fred.readSeriesNames
	 *
	 * @param string
	 * @return
	 */
	public static List<String> readSeriesNames(String fname) {

		final List<String> retList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					final String s = str.substring(0, 1);
					if (!s.contains("#")) {
						retList.add(str);
					}
				}

			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.writeToOptuma
	 *
	 * @param data
	 * @param seriesName
	 */
	public static void writeToOptuma(List<DataValues> data, String seriesName) {

		try (PrintWriter pw = new PrintWriter(new File(optumaPath + seriesName + ".csv"))) {
			pw.println("Date," + seriesName);
			for (final DataValues dv : data) {
				final String date = DataValues.sdf.format(dv.getDate().getTime());
				pw.printf("%s,%.2f%n", date, dv.getValue());
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
