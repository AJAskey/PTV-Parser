
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
