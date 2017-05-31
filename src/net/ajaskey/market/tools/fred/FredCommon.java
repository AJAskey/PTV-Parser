
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class FredCommon {

	public final static String fredPath = OptumaCommon.optumaPath + "FRED/";

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

	final static String infoHeader = "Name\tTitle\tOptuma File\tFrequency\tUnits\tType\tLast Download\tLast Observation";

	final private static double BILLION = 1E9;

	final private static double MILLION = 1E6;

	final private static double THOUSAND = 1E3;

	/**
	 * net.ajaskey.market.tools.fred.getShortTitle
	 *
	 * @param title
	 * @return
	 */
	public static String getShortTitle(String title) {

		final String s1 = title.replaceAll("Disposable Personal Income", "DPI")
		    .replaceAll("Personal Consumption Expenditures", "PCE").replaceAll("London Interbank Offered Rate", "");
		final String s2 = s1.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(", based on U.S. Dollar", "")
		    .replaceAll("  ", " ");
		final String s3 = s2.replaceAll("Compensation of Employees, Received: ", "");
		final String s4 = s3.replaceAll("\\s+", "");
		return s4.trim();
	}

	public static List<DataSeriesInfo> readSeriesInfo(String fname) throws FileNotFoundException, IOException {

		final List<DataSeriesInfo> retList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line = reader.readLine(); //header line

			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					final String s = str.substring(0, 1);
					if (!s.contains("#")) {
						final String fld[] = str.split("\t");
						final DataSeriesInfo dsi = new DataSeriesInfo(fld);
						retList.add(dsi);
					}
				}

			}
		}
		return retList;
	}

	/**
	 * net.ajaskey.market.tools.fred.readSeriesNames
	 *
	 * @param string
	 * @return
	 */
	public static List<String> readSeriesNames(String fname) {

		final List<String> retList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					final String s = str.substring(0, 1);
					if (!s.contains("#")) {
						String fld[] = str.split("\t");
						retList.add(fld[0].trim());
					}
				}

			}
		} catch (final IOException e) {
			retList.clear();
		}
		return retList;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.writeToOptuma
	 *
	 * @param data
	 * @param seriesName
	 */
	public static void writeToOptuma(List<DataValues> data, String seriesName) {

		final double scaler = FredCommon.getScaler(seriesName);

		try (PrintWriter pw = new PrintWriter(new File(fredPath + seriesName + ".csv"))) {
			pw.println("Date," + seriesName);
			for (final DataValues dv : data) {
				final String date = DataValues.sdf.format(dv.getDate().getTime());
				final double d = dv.getValue() * scaler;
				pw.printf("%s,%.2f%n", date, d);
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.getScaler
	 *
	 * @param seriesName
	 * @return
	 */
	private static double getScaler(String seriesName) {

		double ret = 1.0;
		if (seriesName.equalsIgnoreCase("gdpc1")) {
			ret = BILLION;
		} else if (seriesName.equalsIgnoreCase("gdp")) {
			ret = BILLION;
		} else if (seriesName.contains("JTS")) {
			ret = THOUSAND;
		} else if (seriesName.contains("JTU")) {
			ret = THOUSAND;
		} else if (seriesName.equalsIgnoreCase("BOGMBASE")) {
			ret = MILLION;
		} else if (seriesName.equalsIgnoreCase("GFDEBTN")) {
			ret = MILLION;
		} else if (seriesName.equalsIgnoreCase("TREAST")) {
			ret = MILLION;
		}
		return ret;
	}

	public static List<DataSeriesInfo> legacyDsi = null;

	public static DataSeriesInfo findDsi(String series) {

		String s = series.trim();
		for (final DataSeriesInfo dsi : legacyDsi) {
			if (dsi.getName().trim().equalsIgnoreCase(s)) {
				return dsi;
			}
		}
		return null;
	}

	/**
	 * net.ajaskey.market.tools.fred.addSeries
	 *
	 * @param new_names
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void addSeries(List<String> newSeries) throws FileNotFoundException, IOException {

		List<String> data = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/fred-series-info.txt"))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				if (line != null) {
					if (!line.equalsIgnoreCase(infoHeader)) {
						data.add(line.trim());
					}
				}
			}
		}

		Collections.sort(data);

		final String dum = "DUMMY";
		try (PrintWriter pw = new PrintWriter("data/fred-series-info.txt")) {
			pw.println(infoHeader);
			for (String str : data) {
				pw.println(str);
			}
			for (String str : newSeries) {
				pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", str, dum, dum, dum, dum, "LIN", dum, dum);
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.fred.writeSeriesInfo
	 *
	 * @param dsList
	 * @throws FileNotFoundException
	 */
	public static void writeSeriesInfo(List<DataSeriesInfo> dsList) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("data/fred-series-info.txt")) {
			pw.println(infoHeader);
			for (final DataSeriesInfo ds : dsList) {
				//System.out.println(ds);
				pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", ds.getName(), ds.getTitle(), ds.getRefChart(), ds.getFrequency(),
				    ds.getUnits(), ds.getType(), sdf.format(ds.getLastUpdate().getTime()),
				    sdf.format(ds.getLastObservation().getTime()));
			}
		}
	}

}
