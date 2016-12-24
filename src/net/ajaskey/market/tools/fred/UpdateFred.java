
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final File list[] = file.listFiles();

		try (PrintWriter pw = new PrintWriter(FredCommon.optumaPath + "readme.txt")) {
			for (final File f : list) {

				final String name = f.getName();
				final String ext = name.substring(name.length() - 3);

				if (ext.equalsIgnoreCase("csv")) {

					final String series = name.substring(0, name.length() - 4);

					final long modTime = f.lastModified();
					final Calendar lastModTime = Calendar.getInstance();
					lastModTime.setTimeInMillis(modTime);

					//System.out.println(name + "  " + series + "  \t" + sdf.format(cal.getTime()));
					System.out.printf("%-15s %-12s%s%n", name, series, sdf.format(lastModTime.getTime()));

					final DataSeriesInfo dsi = new DataSeriesInfo(series);

					if (lastModTime.after(dsi.getLastUpdate())) {
						System.out.println("Local file created After    " + sdf.format(dsi.getLastUpdate().getTime()) + Utils.NL);
					} else {
						System.out.println("Local file created Before   " + sdf.format(dsi.getLastUpdate().getTime()) + Utils.NL);
						final DataSeries ds = new DataSeries(series);

						FredCommon.writeToOptuma(ds.getValues(0.0, UpdateFred.noZerosCheck(series)), series);
					}

					pw.println(dsi);

				}
			}
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean noZerosCheck(String sname) {

		if ((sname.equalsIgnoreCase("sp500") || (sname.equalsIgnoreCase("WILL5000IND")))) {
			return true;
		}
		return false;
	}

}
