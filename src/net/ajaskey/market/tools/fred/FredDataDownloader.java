
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.Utils;
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

	final private static boolean UpdateAll = true;

	private static boolean isNew(List<String> names, String name) {

		for (final String n : names) {
			System.out.println(n + " " + name);
			if (n.equalsIgnoreCase(name)) {
				return UpdateAll;
			}
		}
		return true;
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Debug.pwDbg = new PrintWriter("download-fred.dbg");

		Utils.makeDir(FredCommon.fredPath);

		final List<String> new_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-series-new-names.txt");
		final List<String> names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-series-info.txt");

		final List<String> newNames = new ArrayList<>();
		for (final String name : new_names) {
			//System.out.println(name);
			if (FredDataDownloader.isNew(names, name)) {
				names.add(name);
				newNames.add(name);
			}
		}

		for (final String name : names) {
			final String s = name.trim();
			if (!s.equalsIgnoreCase("name")) {
				//System.out.println(s);
				FredDataDownloader.process(s, 0.0, true, false, ResponseType.LIN);
			}
		}

		FredCommon.addSeries(newNames);

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

		if (!UpdateAll) {
			if (new File(fname).exists()) {
				return;
			}
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
