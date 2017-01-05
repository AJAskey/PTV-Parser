
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

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Debug.pwDbg = new PrintWriter("download-fred.dbg");

		final List<String> seriesNames = FredCommon.readSeriesNames("fred-series.dat");

		//
		for (final String s : seriesNames) {
			final String fld[] = s.split(" ");
			double chg = 0;
			boolean noZeros = false;
			if (fld.length == 1) {
				chg = 0.0;
				noZeros = false;
			} else if (fld.length == 2) {
				chg = Double.parseDouble(fld[1].trim());
				noZeros = false;
			} else if (fld.length >= 3) {
				chg = Double.parseDouble(fld[1].trim());
				noZeros = Boolean.parseBoolean(fld[2].trim());
			}
			FredDataDownloader.process(fld[0].trim(), chg, noZeros);
		}

		Debug.pwDbg.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param series
	 * @param futureChg
	 * @param noZeroValues
	 */
	private static void process(String series, double futureChg, boolean noZeroValues) {
		
		String fname = FredCommon.optumaPath+series + ".csv";
		if (new File(fname).exists()) {
			return;
		}

		final DataSeries ds = new DataSeries(series);

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			ds.setRespType(ResponseType.LIN);

			final List<DataValues> dvList = ds.getValues(futureChg, noZeroValues);

			FredCommon.writeToOptuma(dvList, ds.getName());
			Debug.pwDbg.println(ds);
			Debug.pwDbg.println(futureChg);

			String title = FredCommon.getShortTitle(ds.getInfo().getTitle());

			System.out.println(ds.getName() + "," + ds.getName() + "," + title);
		}
	}

}
