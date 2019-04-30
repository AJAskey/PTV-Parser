
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Debug;
import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.optuma.OptumaCommon;

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
public class UpdateFred {

	public final static SimpleDateFormat	sdf		= new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
	public final static File							file	= new File(FredCommon.fredPath);

	private static List<DataSeriesInfo> dsList = new ArrayList<>();

	private static List<DataSeriesInfo> prop_names = null;

	/**
	 *
	 * net.ajaskey.market.tools.fred.dumpRates
	 *
	 * @param seriesName
	 * @param dv
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void dumpRates() throws FileNotFoundException, IOException {

		final List<String> rateFiles = new ArrayList<>();

		rateFiles.add("[DGS3MO] - 3M Treasury Constant Maturity Rate");
		rateFiles.add("[DGS6MO] - 6M Treasury Constant Maturity Rate");
		rateFiles.add("[DGS2] - 2Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS3] - 3Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS5] - 5Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS7] - 7Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS10] - 10Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS20] - 20Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS30] - 30Y Treasury Constant Maturity Rate");

		for (final String fil : rateFiles) {
			final String line = UpdateFred.getLastLine(fil + ".csv");
			System.out.println(fil + "," + line);
		}
	}

	private static String getLastLine(final String fname) throws FileNotFoundException, IOException {

		String ret = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(OptumaCommon.optumaPath + "FRED-Download\\" + fname))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					ret = str;
				}
			}
		}

		return ret.trim();
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {

		Debug.init("update-fred.dbg");

		Utils.makeDir(FredCommon.fredPath);

		FredCommon.legacyDsi = FredCommon.readSeriesInfo(FredCommon.fredPath + "/fred-series-info.txt");

		prop_names = FredCommon.readSeriesNames(FredCommon.fredPath + "/fred-propagate.txt");

		final File list[] = file.listFiles();

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "FRED-readme.txt")) {

			int knt = 0;

			for (final File f : list) {

				final String name = f.getName();
				final String ext = name.substring(name.length() - 3);

				if ((ext.equalsIgnoreCase("csv")) && (name.substring(0, 1).equals("["))) {

					final String series = FredCommon.fromFullFileNameToSeries(name);

					//final InputRecord ir = UpdateFred.findInputRecord(series);
					final DataSeriesInfo ldsi = FredCommon.findDsi(series);

					//System.out.println(ir);

					if ((ldsi != null) && (ldsi.getName().length() > 0)) {

						//System.out.println(series);

						final long modTime = f.lastModified();
						final Calendar lastModTime = Calendar.getInstance();
						lastModTime.setTimeInMillis(modTime);

						Debug.log(String.format("%-29s %-25s%s%n", name, series, sdf.format(lastModTime.getTime())));

						final DataSeriesInfo dsi = new DataSeriesInfo(series);

						if ((dsi != null) && (dsi.getTitle() != null)) {

							dsi.setType(ldsi.getType().toString());
							dsi.setRefChart(ldsi.getRefChart());

							dsList.add(dsi);

							final boolean propagate = FredCommon.doPropagate(prop_names, series);

							if ((!series.equalsIgnoreCase("SP500")) && (!propagate) && (lastModTime.after(dsi.getLastUpdate()))) {
								Debug.log("Local file created After                               " + dsi.getLastUpdate().toString() + Utils.TAB
								    + dsi.getTitle() + Utils.NL);
								if (knt < 100) {
									System.out.print(".");
									knt++;
								}
								else {
									System.out.println(".");
									knt = 0;
								}
							}
							else {
								try {
									try {
										Debug.log("Local file created Before                              " + dsi.getLastUpdate().toString() + Utils.TAB
										    + dsi.getTitle() + Utils.NL);
									} catch (final Exception ee) {
										ee.printStackTrace();
									}
									final DataSeries ds = new DataSeries(series);

									if ((knt > 0) && (!propagate)) {
										System.out.print("\n");
									}
									System.out.println(series);
									knt = 0;

									final String filename = FredCommon.toFullFileName(series, dsi.getTitle()); // "[" + series + "] - " + dsi.getTitle();
									//FredCommon.writeToOptuma(ds.getValues(ir.change, ir.noZeros, ir.estimateData), series);
									FredCommon.writeToOptuma(ds.getValues(0.0, true, false), filename, series, dsi.getUnits(), dsi.getFrequency(), propagate);

								} catch (final Exception e) {
									e.printStackTrace();
								}
							}

							pw.println(dsi);
						}
					}

				}
			}

			final List<String> always = new ArrayList<>();
			always.add("SP500");

			for (final String series : always) {
				try {

					System.out.println("\n" + series);
					final DataSeriesInfo dsi = new DataSeriesInfo(series);
					if ((dsi != null) && (dsi.getTitle() != null)) {
						final DataSeries ds = new DataSeries(series);
						final String filename = FredCommon.toFullFileName(series, dsi.getTitle());
						final List<DataValues> ldv = ds.getValues(0.0, true, false);
						FredCommon.writeToOptuma(ldv, filename, series, dsi.getUnits(), dsi.getFrequency(), false);
					}
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("");
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			Collections.sort(dsList, new DsiSorter());
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "last-update.txt")) {
			for (final DataSeriesInfo ds : dsList) {
				try {
					pw.printf("%-28s %-25s %6s   %20s %12s    %s%n", ds.getName(), ds.getFrequency(), ds.getUnits(), ds.getLastUpdate().toString(),
					    ds.getLastObservation().toString(), ds.getTitle());
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		}

		Collections.sort(dsList, new DsiAbcSorter());
		FredCommon.writeSeriesInfo(dsList, FredCommon.fredPath + "/fred-series-info.txt");

		UpdateFred.dumpRates();

		System.out.println("Done.");

	}

	/**
	 * net.ajaskey.market.tools.fred.findDsi
	 *
	 * @param series
	 * @return
	 */
	//	private static DataSeriesInfo findDsi(String series) {
	//
	//		String s = series.trim();
	//		for (final DataSeriesInfo dsi : legacyDsi) {
	//			if (dsi.getName().trim().equalsIgnoreCase(s)) {
	//				return dsi;
	//			}
	//		}
	//		return null;
	//	}

	/**
	 * net.ajaskey.market.tools.fred.findInputRecord
	 *
	 * @param series
	 * @return
	 */
	//	private static InputRecord findInputRecord(String series) {
	//
	//		for (final InputRecord ir : records) {
	//			if (ir.series.equalsIgnoreCase(series)) {
	//				return ir;
	//			}
	//		}
	//		return null;
	//	}
}
