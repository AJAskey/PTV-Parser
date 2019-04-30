
package net.ajaskey.market.tools.bigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import net.ajaskey.market.tools.optuma.OptumaCommon;

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

	public enum Direction {
		NORMAL, REVERSE
	}

	enum Frequency {
		DAILY, WEEKLY, MONTHLY
	}

	private static final int MAX_DATA_VALUES = 10000;

	final private static String TAB = "\t";

	final static public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");;

	final static public SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyyMMdd");;

	/**
	 * net.ajaskey.market.tools.bigo.CreateVixData
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void CreateVixData(final String fname) throws FileNotFoundException, IOException {

		final int MA_KNT = 500;

		final DescriptiveStatistics ds = new DescriptiveStatistics(MA_KNT);

		try (BufferedReader reader = new BufferedReader(new FileReader(fname)); PrintWriter pw = new PrintWriter("data/vix.txt")) {

			//skip header
			String line = "";

			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(",");

					final Calendar cal = Calendar.getInstance();
					try {
						cal.setTime(sdfOptuma.parse(fld[1].trim()));
						// High value used
						final double d = Double.parseDouble(fld[3].trim());
						ds.addValue(d);
						if (ds.getN() == MA_KNT) {
							final String fstr = String.format("%s\t%.2f", sdf.format(cal.getTime()), d);
							pw.println(fstr);
						}
					} catch (final ParseException e) {
						System.out.println(fname + "  -- Invalid data found : " + str);
					}
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.bigo.CreateWilshireData
	 *
	 * @param string
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private static void CreateWilshireData(final String fname) throws NumberFormatException, IOException {

		final int MA_KNT = 500;

		final DescriptiveStatistics ds = new DescriptiveStatistics(MA_KNT);

		try (BufferedReader reader = new BufferedReader(new FileReader(fname)); PrintWriter pw = new PrintWriter("data/wilshire.txt")) {

			//skip header
			String line = "";

			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(",");

					final Calendar cal = Calendar.getInstance();
					try {
						cal.setTime(sdfOptuma.parse(fld[1].trim()));
						final double d = Double.parseDouble(fld[5].trim());
						ds.addValue(d);
						if (ds.getN() == MA_KNT) {
							final double delta = (d / ds.getMean()) * 100.0;
							final String fstr = String.format("%s\t%.2f", sdf.format(cal.getTime()), delta);
							pw.println(fstr);
						}
					} catch (final ParseException e) {
						System.out.println(fname + "  -- Invalid data found : " + str);
					}
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.bigo.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {

		BigO.CreateWilshireData(OptumaCommon.optumaPricePath + "World Indices\\D\\DWC.csv");
		BigO.CreateVixData(OptumaCommon.optumaPricePath + "World Indices\\V\\VIX.csv");

		final SeriesData[] dwc = BigO.processData("data/Wilshire.txt", 500, Direction.NORMAL, Frequency.DAILY);
		BigO.write("wilshire", dwc);

		final SeriesData[] rydex = BigO.processData("data/RydexData.txt", 500, Direction.NORMAL, Frequency.DAILY);
		BigO.write("rydex", rydex);

		final SeriesData[] aaii = BigO.processData("data/AAIIBull.txt", 104, Direction.NORMAL, Frequency.WEEKLY);
		BigO.write("aaii", aaii);

		final SeriesData[] vix = BigO.processData("data/VIX.txt", 104, Direction.REVERSE, Frequency.DAILY);
		BigO.write("vix", vix);

		final SeriesData[] spread = BigO.processData("data/aaii-spread.txt", 104, Direction.NORMAL, Frequency.WEEKLY);
		BigO.write("aaii_spread", spread);

		final SeriesData[] pe = BigO.processData("data/SP500PE.txt", 600, Direction.NORMAL, Frequency.MONTHLY);
		BigO.write("sp500pe", pe);

		System.out.println("Done.");

	}

	/**
	 *
	 * net.ajaskey.market.tools.bigo.processData
	 *
	 * @param fname
	 * @param window
	 * @param freq
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static SeriesData[] processData(final String fname, final int window, final Direction direction, final Frequency freq)
	    throws FileNotFoundException, IOException {

		System.out.println("Processing : " + fname);

		final DescriptiveStatistics ds = new DescriptiveStatistics(window);

		final SeriesData[] sd = BigO.read(fname);
		BigO.setToWeekly(sd, freq);
		for (final SeriesData s : sd) {
			ds.addValue(s.value);
			s.knt = ds.getN();
			if (ds.getN() == window) {
				s.setStats(ds, direction);
			}
		}

		return sd;
	}

	/**
	 *
	 * net.ajaskey.market.tools.bigo.read
	 *
	 * @param fname
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static SeriesData[] read(final String fname) throws FileNotFoundException, IOException {

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
						System.out.println(fname + "  -- Invalid data found : " + str);
					}
				}
			}
		}

		final SeriesData[] ret = new SeriesData[knt];
		System.arraycopy(data, 0, ret, 0, knt);
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.bigo.setToWeekly
	 *
	 * @param sd
	 * @param freq
	 * @return
	 */
	private static SeriesData[] setToWeekly(final SeriesData[] sd, final Frequency freq) {

		// TODO Auto-generated method stub
		return null;
	}

	public static void write(final String prefix, final SeriesData[] data) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "/Quandl/" + prefix + "_value.csv")) {
			for (final SeriesData s : data) {
				if (s.mean > 0.0) {
					pw.println(sdf.format(s.date.getTime()) + String.format(", %.2f", s.value));
				}
			}
		}

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "/Quandl/" + prefix + "_median.csv")) {
			for (final SeriesData s : data) {
				if (s.mean > 0.0) {
					pw.println(sdf.format(s.date.getTime()) + String.format(", %.2f", s.median));
				}
			}
		}

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "/Quandl/" + prefix + "_score.csv")) {
			for (final SeriesData s : data) {
				if (s.mean > 0.0) {
					pw.println(sdf.format(s.date.getTime()) + String.format(", %.2f", s.score));
				}
			}
		}

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "/Quandl/" + prefix + "_delta.csv")) {
			for (final SeriesData s : data) {
				if (s.mean > 0.0) {
					pw.println(sdf.format(s.date.getTime()) + String.format(", %.2f", s.delta));
				}
			}
		}
	}

}
