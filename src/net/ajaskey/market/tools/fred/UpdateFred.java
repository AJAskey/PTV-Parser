
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
	public final static File							file	= new File(FredCommon.optumaPath);

	private static List<DataSeriesInfo> dsList = new ArrayList<>();

	private static List<InputRecord> records = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Debug.pwDbg = new PrintWriter("update-fred.dbg");

		final List<String> seriesNames = FredCommon.readSeriesNames("fred-series.dat");
		for (final String s : seriesNames) {
			final InputRecord ir = new InputRecord(s);
			//System.out.println(ir);
			records.add(ir);
		}

		final File list[] = file.listFiles();

		try (PrintWriter pw = new PrintWriter(FredCommon.optumaPath + "readme.txt")) {
			for (final File f : list) {

				final String name = f.getName();
				final String ext = name.substring(name.length() - 3);

				if (ext.equalsIgnoreCase("csv")) {

					final String series = name.substring(0, name.length() - 4);

					final InputRecord ir = UpdateFred.findInputRecord(series);

					//System.out.println(ir);

					if ((ir != null) && (ir.series.length() > 0)) {

						System.out.println(series);

						final long modTime = f.lastModified();
						final Calendar lastModTime = Calendar.getInstance();
						lastModTime.setTimeInMillis(modTime);

						Debug.pwDbg.printf("%-29s %-25s%s%n", name, series, sdf.format(lastModTime.getTime()));

						final DataSeriesInfo dsi = new DataSeriesInfo(series);

						dsList.add(dsi);

						if (lastModTime.after(dsi.getLastUpdate())) {
							Debug.pwDbg.println("Local file created After                               "
							    + sdf.format(dsi.getLastUpdate().getTime()) + Utils.TAB + dsi.getTitle() + Utils.NL);
						} else {
							Debug.pwDbg.println("Local file created Before                              "
							    + sdf.format(dsi.getLastUpdate().getTime()) + Utils.TAB + dsi.getTitle() + Utils.NL);
							final DataSeries ds = new DataSeries(series);

							FredCommon.writeToOptuma(ds.getValues(ir.change, ir.noZeros, ir.estimateData), series);
						}

						pw.println(dsi);
					}

				}
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

		Debug.pwDbg.close();

		Collections.sort(dsList, new DsiSorter());

		try (PrintWriter pw = new PrintWriter(FredCommon.optumaPath + "last-update.txt")) {
			for (final DataSeriesInfo ds : dsList) {
				pw.printf("%-28s %-25s %20s    %s%n", ds.getName(), ds.getFrequency(), sdf.format(ds.getLastUpdate().getTime()),
				    ds.getTitle());
			}
		}

		System.out.println("Done.");

	}

	/**
	 * net.ajaskey.market.tools.fred.findInputRecord
	 *
	 * @param series
	 * @return
	 */
	private static InputRecord findInputRecord(String series) {

		for (final InputRecord ir : records) {
			if (ir.series.equalsIgnoreCase(series)) {
				return ir;
			}
		}
		return null;
	}
}
