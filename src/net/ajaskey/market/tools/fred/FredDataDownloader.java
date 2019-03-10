
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import net.ajaskey.market.misc.Utils;
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

	public static final int consecutiveRetryFailures = 9;

	public static final int longSleep = 35000;

	public static final int maxRetries = 1;

	private static final String NL = "\n";

	private static File[] existingFiles = null;

	private static List<DataSeriesInfo> prop_names = null;

	//public static final Logger LOGGER = Logger.getLogger(FredDataDownloader.class.getName());

	public static PrintWriter	tryAgainFile	= null;
	public static int					retryCount		= 0;

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

		Debug.init("FredDataDownloader.log");

		tryAgainFile = new PrintWriter("fred-try-again.txt");

		Utils.makeDir(FredCommon.fredPath);

		final File folder = new File(FredCommon.fredPath);
		existingFiles = folder.listFiles();

		List<String> codeNames = new ArrayList<>();

		codeNames = FredCommon.readSeriesList(FredCommon.fredPath + "/fred-series-new-names.txt");
		Collections.sort(codeNames);
		String codes = "Processing codes :" + NL;
		for (final String s : codeNames) {
			codes += s + NL;
		}
		Debug.log(codes);

		Utils.sleep(1000);

		final List<DataSeriesInfo> allNames = FredCommon.queryFredDsi(codeNames);

		Debug.log("\n----------------------------------------------------------\n");

		for (final DataSeriesInfo dsi : allNames) {
			FredDataDownloader.process(dsi);
		}

		tryAgainFile.close();

		System.out.println("Done.");
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param seriesDsi
	 */
	private static void process(DataSeriesInfo seriesDsi) {

		final DataSeries ds = new DataSeries(seriesDsi.getName().trim());

		ds.setAggType(AggregationMethodType.EOP);
		ds.setRespType(DataSeries.ResponseType.LIN);

		Debug.log("Querying for data values ...\n");

		List<DataValues> dvList = null;
		for (int i = 0; i <= maxRetries; i++) {
			Utils.sleep((1000 * (5 * i)) + 250);
			dvList = ds.getValues(0.0, false, false);
			if (dvList.size() > 0) {
				System.out.println(seriesDsi.getName());
				retryCount = 0;
				break;
			}
			retryCount++;
			if (i < maxRetries) {
				Debug.log(String.format("\tQuery dvList retry for %s ...%n", seriesDsi.getName()));
			}
		}

		if ((dvList != null) && (dvList.size() > 0)) {

			Debug.log(String.format("Writing to Optuma%n%s%nvalues : %d%n", ds, dvList.size()));

			final String outname = FredCommon.toFullFileName(seriesDsi.getName(), seriesDsi.getTitle());

			FredCommon.writeToOptuma(dvList, outname, seriesDsi.getName(), seriesDsi.getUnits(), seriesDsi.getFrequency(),
			    false);

			//Debug.pwDbg.println(ds);
		} else {
			Debug.log(String.format("%nZero Data Values: %s : %s%n", seriesDsi.getName(), seriesDsi.getTitle()));

			tryAgainFile.println(seriesDsi.getName());
			tryAgainFile.flush();
			if (retryCount > consecutiveRetryFailures) {
				Debug.log(String.format("Too many retries (%d). Sleeping %d seconds.%n", retryCount, (longSleep / 1000)));

				Utils.sleep(longSleep);
				retryCount = 0;
			}
		}

		//for (DataValues dv : dvList) {
		//System.out.println(dv);

		//final String title = FredCommon.cleanTitle(ds.getInfo().getTitle());
		//System.out.println(ds.getName() + "\t" + ds.getName() + "\t" + title);
		//}
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
			final String fname = seriesDsi.getName().trim() + ".csv";
			propFile = FredCommon.doPropagate(prop_names, seriesDsi.getName().trim());
			if ((!UpdateAll) && (!propFile)) {
				//System.out.println(seriesDsi);
				if (!seriesDsi.getTitle().equalsIgnoreCase("Title")) {
					if (FredDataDownloader.seriesFileExists(fname)) {
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

					final boolean propagate = false; //FredCommon.doPropagate(prop_names, seriesDsi.getName());

					final String outname = FredCommon.toFullFileName(seriesDsi.getName(), seriesDsi.getTitle());
					//System.out.println(Utils.getString(dvList.get(dvList.size()-1).getDate()));
					FredCommon.writeToOptuma(dvList, outname, seriesDsi.getName(), seriesDsi.getUnits(), seriesDsi.getFrequency(),
					    propagate);
					Debug.log(ds.toString());

					final String title = FredCommon.cleanTitle(ds.getInfo().getTitle());
					System.out.println(ds.getName() + "\t" + ds.getName() + "\t" + title);

				} catch (final Exception e) {
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.seriesFileExists
	 *
	 * @param fname
	 * @return
	 */
	private static boolean seriesFileExists(String fname) {

		for (final File f : existingFiles) {
			final String ename = FredCommon.fromFullFileName(f.getName());
			if (fname.equalsIgnoreCase(ename)) {
				return true;
			}
		}
		return false;
	}
}
