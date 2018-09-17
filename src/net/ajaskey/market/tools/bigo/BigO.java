
package net.ajaskey.market.tools.bigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class BigO {

	private static final int MAX_DATA_VALUES = 10000;

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";

	final static public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * net.ajaskey.market.tools.bigo.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		DescriptiveStatistics ds = new DescriptiveStatistics(250);

		final SeriesData[] sd = BigO.read("data/RydexData.txt");
		for (final SeriesData s : sd) {
			ds.addValue(s.value);
			s.knt = ds.getN();
			if (ds.getN() == 250) {
				s.mean = ds.getMean();
				s.median = ds.getPercentile(50.0);
				s.stddev = ds.getStandardDeviation();
				s.min = ds.getMin();
				s.max = ds.getMax();
				s.setStats(ds);
			}
			System.out.println(s);
		}
		System.out.println(sd.length);

	}

	/**
	 *
	 * net.ajaskey.market.tools.bigo.read
	 *
	 * @param fname
	 * @return
	 */
	public static SeriesData[] read(String fname) {

		int knt = 0;
		final SeriesData[] data = new SeriesData[MAX_DATA_VALUES];

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			//skip header
			String line = "";

			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);

					final Calendar cal = Calendar.getInstance();
					try {
						cal.setTime(sdf.parse(fld[0].trim()));
						final double d = Double.parseDouble(fld[1].trim());
						data[knt] = new SeriesData(cal, d);
						knt++;
					} catch (final ParseException e) {
						//e.printStackTrace();
					}

				}
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		final SeriesData[] ret = new SeriesData[knt];
		System.arraycopy(data, 0, ret, 0, knt);
		return ret;
	}

}
