
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

	private static File[] existingFiles = null;

	private static List<DataSeriesInfo> prop_names = null;

	public static final Logger LOGGER = Logger.getLogger(FredDataDownloader.class.getName());

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

		//Handler consoleHandler = null;
		Handler fileHandler = null;
		Formatter simpleFormatter = null;

		try {

			//consoleHandler = new ConsoleHandler();

			LogManager.getLogManager().reset();

			fileHandler = new FileHandler("./FredDataDownloader.log");

			//Assigning handlers to LOGGER object
			//LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);

			simpleFormatter = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormatter);

			//Setting levels to handlers and LOGGER
			//consoleHandler.setLevel(Level.SEVERE);
			fileHandler.setLevel(Level.ALL);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Debug.pwDbg = new PrintWriter("download-fred.dbg");
		tryAgainFile = new PrintWriter("fred-try-again.txt");

		Utils.makeDir(FredCommon.fredPath);

		final File folder = new File(FredCommon.fredPath);
		existingFiles = folder.listFiles();

		List<String> codeNames = new ArrayList<>();
		//List<String> codeNames2 = new ArrayList<>();

		codeNames = FredCommon.readSeriesList(FredCommon.fredPath + "/fred-series-new-names.txt");
		Collections.sort(codeNames);
		for (final String s : codeNames) {
			Debug.pwDbg.println(s);
		}
		Debug.pwDbg.println("\n----------------------------------------------------------\n");
		Debug.pwDbg.flush();

		//codeNames = FredCommon.readSeriesList(FredCommon.fredPath + "/fred-series-info.txt", codeNames);
		//		Collections.sort(codeNames);
		//		for (String s : codeNames) {
		//			Debug.pwDbg.println(s);
		//		}

		Utils.sleep(1000);

		final List<DataSeriesInfo> allNames = FredCommon.queryFredDsi(codeNames);

		Debug.pwDbg.println("\n----------------------------------------------------------\n");

		for (final DataSeriesInfo dsi : allNames) {
			//Debug.pwDbg.println(dsi);
			FredDataDownloader.process(dsi);
		}

		//		final List<DataSeriesInfo> new_names = FredCommon
		//		    .readSeriesNames(FredCommon.fredPath + "/fred-series-new-names.txt");
		//		final List<DataSeriesInfo> saved_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-series-info.txt");
		//
		//		prop_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-propagate.txt");
		//
		//		final List<DataSeriesInfo> allNames = new ArrayList<>();
		//
		//		for (DataSeriesInfo dsi : saved_names) {
		//			allNames.add(dsi);
		//		}
		//
		//		for (final DataSeriesInfo dsi : new_names) {
		//			//System.out.println(dsi);
		//			if (FredDataDownloader.isNew(saved_names, dsi)) {
		//				allNames.add(dsi);
		//			}
		//		}
		//
		//		Collections.sort(allNames, new DsiAbcSorter());
		//
		//		for (final DataSeriesInfo dsi : allNames) {
		//			final String s = dsi.getName().trim();
		//			Debug.pwDbg.println(s);
		//			//FredDataDownloader.process(dsi, 0.0, true, false, ResponseType.LIN);
		//		}

		//FredCommon.addSeries(allNames);

		Debug.pwDbg.close();
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

		Debug.pwDbg.println("\n~~~~~\nQuerying for data values ...\n");

		List<DataValues> dvList = null;
		for (int i = 0; i <= maxRetries; i++) {
			Utils.sleep((1000 * (5*i)) + 250);
			dvList = ds.getValues(0.0, false, false);
			if (dvList.size() > 0) {
				retryCount = 0;
				break;
			}
			retryCount++;
			if (i < maxRetries) {
				Debug.pwDbg.println("\tQuery dvList retry...");
				Debug.pwDbg.flush();
				FredDataDownloader.LOGGER.info(String.format("\tQuery dvList retry for %s ...%n", seriesDsi.getName()));
			}
		}

		if (dvList.size() > 0) {

			Debug.pwDbg.printf("%nWriting to Optuma:%n%s%nvalues : %d%n", ds, dvList.size());
			FredDataDownloader.LOGGER.info(String.format("%nWriting to Optuma:%n%s%nvalues : %d%n", ds, dvList.size()));

			final String outname = FredCommon.toFullFileName(seriesDsi.getName(), seriesDsi.getTitle());

			FredCommon.writeToOptuma(dvList, outname, seriesDsi.getName(), seriesDsi.getUnits(), seriesDsi.getFrequency(),
			    false);

			//Debug.pwDbg.println(ds);
		} else {
			Debug.pwDbg.printf("%nZero Data Values: %s : %s%n", seriesDsi.getName(), seriesDsi.getTitle());
			FredDataDownloader.LOGGER
			    .info(String.format("%nZero Data Values: %s : %s%n", seriesDsi.getName(), seriesDsi.getTitle()));

			tryAgainFile.println(seriesDsi.getName());
			tryAgainFile.flush();
			if (retryCount > consecutiveRetryFailures) {
				Debug.pwDbg.printf("Too many retries (%d). Sleeping %d seconds.%n", retryCount, (longSleep / 1000));
				Debug.pwDbg.flush();
				FredDataDownloader.LOGGER
				    .info(String.format("Too many retries (%d). Sleeping %d seconds.%n", retryCount, (longSleep / 1000)));

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
					Debug.pwDbg.println(ds);
					Debug.pwDbg.println(futureChg);

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
