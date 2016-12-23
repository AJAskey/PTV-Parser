
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.fred.DataSeries.AggregationMethodType;
import net.ajaskey.market.tools.fred.DataSeries.ResponseType;

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
public class FredDataDownloader {

	private static String path = "C:/Users/ajask_000/Documents/Market Analyst 8/CSV Data/FRED/";

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final List<String> seriesNames = new ArrayList<>();
		seriesNames.add("PCE");
		seriesNames.add("GDPC1");
		seriesNames.add("CP");

		for (final String s : seriesNames) {
			FredDataDownloader.process(s, 1.0);
		}

	}

	/**
	 * 
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param series
	 * @param futureChg
	 */
	private static void process(String series, double futureChg) {
		final DataSeries ds = new DataSeries(series);

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			ds.setRespType(ResponseType.LIN);
			final List<DataValues> dvList = ds.getValues(futureChg);
			FredDataDownloader.writeToOptuma(dvList, ds.getName());
			System.out.println(ds);
		}
	}

	/**
	 * 
	 * net.ajaskey.market.tools.fred.writeToOptuma
	 *
	 * @param data
	 * @param seriesName
	 */
	private static void writeToOptuma(List<DataValues> data, String seriesName) {
		try (PrintWriter pw = new PrintWriter(new File(path + seriesName + ".csv"))) {
			pw.println("Date," + seriesName);
			for (final DataValues dv : data) {
				final String date = DataValues.sdf.format(dv.getDate().getTime());
				pw.println(date + "," + dv.getValue());
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
