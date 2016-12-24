
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
	 */
	public static void main(String[] args) {

		final List<String> seriesNames = new ArrayList<>();
		//seriesNames.add("PCEC96 0.1 false");
		//seriesNames.add("DSPIC96 0.1 false");
		//seriesNames.add("A576RC1 0.1 false");
		//seriesNames.add("PSAVERT 0.1 false");
		//seriesNames.add("TTLCON 0.1 false");
		//seriesNames.add("USSLIND 0.1 false");
		//seriesNames.add("USPHCI 0.1 false");
		
		//seriesNames.add("TOTBUSSMNSA 0.1 false");
		//seriesNames.add("GFDEBTN 0.1 false");
		//seriesNames.add("TREAST 0.1 false");

		seriesNames.add("RMFNS -0.1 false");
		
		//seriesNames.add("SP500 0.0 true");
		//seriesNames.add("WILL5000IND 0.0 true");

		//seriesNames.add("GDPC1 0.4");
		//seriesNames.add("CP -0.25");
		//seriesNames.add("CNP16OV 0.1");

		//
		for (final String s : seriesNames) {
			String fld[] = s.split(" ");
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

		final DataSeries ds = new DataSeries(series);

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			ds.setRespType(ResponseType.LIN);

			final List<DataValues> dvList = ds.getValues(futureChg, noZeroValues);

			FredCommon.writeToOptuma(dvList, ds.getName());
			System.out.println(ds);
			System.out.println(futureChg);
		}
	}

}
