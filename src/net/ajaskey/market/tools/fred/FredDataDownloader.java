
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

	final private static boolean UpdateAll = false;

	private static File[] existingFiles = null;

	private static List<DataSeriesInfo> prop_names = null;

	/**
	 * 
	 * net.ajaskey.market.tools.fred.isNew
	 *
	 * @param dsiList
	 * @param newDsi
	 * @return
	 */
	private static boolean isNew(List<DataSeriesInfo> dsiList, DataSeriesInfo newDsi) {

		for (final DataSeriesInfo dsi : dsiList) {

			if (dsi.getName().equalsIgnoreCase(newDsi.getName())) {
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

		File folder = new File(FredCommon.fredPath);
		existingFiles = folder.listFiles();

		final List<DataSeriesInfo> new_names = FredCommon
		    .readSeriesNames(FredCommon.fredPath + "/fred-series-new-names.txt");
		final List<DataSeriesInfo> saved_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-series-info.txt");

		prop_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-propagate.txt");

		final List<DataSeriesInfo> allNames = new ArrayList<>();

		for (DataSeriesInfo dsi : saved_names) {
			allNames.add(dsi);
		}

		for (final DataSeriesInfo dsi : new_names) {
			//System.out.println(dsi);
			if (FredDataDownloader.isNew(saved_names, dsi)) {
				allNames.add(dsi);
			}
		}

		for (final DataSeriesInfo dsi : allNames) {
			final String s = dsi.getName().trim();
			System.out.println(s);
			FredDataDownloader.process(dsi, 0.0, true, false, ResponseType.LIN);
		}

		FredCommon.addSeries(allNames);

		Debug.pwDbg.close();

		System.out.println("Done.");
	}

	/**
	 * 
	 * net.ajaskey.market.tools.fred.seriesFileExists
	 *
	 * @param fname
	 * @return
	 */
	private static boolean seriesFileExists(String fname) {

		for (File f : existingFiles) {
			String ename = FredCommon.fromFullFileName(f.getName());
			if (fname.equalsIgnoreCase(ename)) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param seriesDsi
	 * @param futureChg
	 * @param noZeroValues
	 * @param estimateData
	 */
	private static void process(DataSeriesInfo seriesDsi, double futureChg, boolean noZeroValues, boolean estimateData,
	    DataSeries.ResponseType unit) {

		if ((seriesDsi == null) || (seriesDsi.getName().length() < 2)) {
			return;
		}

		boolean propFile = false;
		try {
			String fname = seriesDsi.getName().trim() + ".csv";
			propFile = FredCommon.doPropagate(prop_names, seriesDsi.getName().trim());
			if ((!UpdateAll) && (!propFile)) {
				//System.out.println(seriesDsi);
				if (!seriesDsi.getTitle().equalsIgnoreCase("Title")) {
					if (seriesFileExists(fname)) {
						return;
					}
				}
			}

			if (propFile) {
				System.out.println("updating propogation for series : " + fname);
			} else {
				System.out.println("new series : " + fname);
			}

			final DataSeries ds = new DataSeries(seriesDsi.getName().trim());
			if (seriesDsi.getTitle().length() == 0) {
				seriesDsi = new DataSeriesInfo(seriesDsi.getName());
			}

			if (ds.isValid()) {

				try {

					ds.setAggType(AggregationMethodType.EOP);
					ds.setRespType(unit);

					final List<DataValues> dvList = ds.getValues(futureChg, noZeroValues, estimateData);

					boolean propagate = FredCommon.doPropagate(prop_names, seriesDsi.getName());

					String outname = FredCommon.toFullFileName(seriesDsi.getName(), seriesDsi.getTitle());
					//System.out.println(Utils.getString(dvList.get(dvList.size()-1).getDate()));
					FredCommon.writeToOptuma(dvList, outname, seriesDsi.getName(), seriesDsi.getUnits(), seriesDsi.getFrequency(),
					    propagate);
					Debug.pwDbg.println(ds);
					Debug.pwDbg.println(futureChg);

					final String title = FredCommon.cleanTitle(ds.getInfo().getTitle());
					System.out.println(ds.getName() + "\t" + ds.getName() + "\t" + title);

				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
