
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import net.ajaskey.market.tools.fred.DataSeries.AggregationMethodType;

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
			final InputRecord ir = new InputRecord(s);
			if (ir.series.length() > 0) {
				System.out.println(ir);
				FredDataDownloader.process(ir.series, ir.change, ir.noZeros, ir.estimateData, ir.type);
			}
		}

		Debug.pwDbg.close();

		System.out.println("Done.");
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param series
	 * @param futureChg
	 * @param noZeroValues
	 * @param estimateData
	 */
	private static void process(String series, double futureChg, boolean noZeroValues, boolean estimateData,
	    DataSeries.ResponseType unit) {

		final String fname = FredCommon.fredPath + series + ".csv";
		if (new File(fname).exists()) {
			return;
		}

		final DataSeries ds = new DataSeries(series);

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			ds.setRespType(unit);

			final List<DataValues> dvList = ds.getValues(futureChg, noZeroValues, estimateData);

			FredCommon.writeToOptuma(dvList, ds.getName());
			Debug.pwDbg.println(ds);
			Debug.pwDbg.println(futureChg);

			final String title = FredCommon.getShortTitle(ds.getInfo().getTitle());

			System.out.println(ds.getName() + "," + ds.getName() + "," + title);
		}
	}

}
