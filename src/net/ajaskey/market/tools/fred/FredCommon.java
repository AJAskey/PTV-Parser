
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

	public final static String fredPath = OptumaCommon.optumaPath + "FRED-Download\\";

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

	final static String infoHeader = "Name\tTitle\tOptuma File\tFrequency\tUnits\tType\tLast Download\tLast Observation";

	final private static double BILLION = 1E9;

	final private static double MILLION = 1E6;

	final private static double THOUSAND = 1E3;

	public static List<DataSeriesInfo> legacyDsi = null;

	/**
	 * net.ajaskey.market.tools.fred.addSeries
	 *
	 * @param new_names
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void addSeries(List<String> newSeries) throws FileNotFoundException, IOException {

		final List<String> data = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FredCommon.fredPath + "/fred-series-info.txt"))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				if (line != null) {
					if (!line.equalsIgnoreCase(infoHeader)) {
						data.add(line.trim());
					}
				}
			}
		} catch (final FileNotFoundException e) {
			data.clear();
		}

		Collections.sort(data);

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "/fred-series-info.txt")) {
			pw.println(infoHeader);
			for (final String str : data) {
				pw.println(str);
			}
			//"Name\tTitle\tOptuma File\tFrequency\tUnits\tType\tLast Download\tLast Observation";
			for (final String str : newSeries) {
				final DataSeriesInfo dsi = new DataSeriesInfo(str.trim());
				FredCommon.writeSeriesInfo(dsi, pw);
				//				System.out.println(dsi);
				//				pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", str, dsi.getTitle(), dum, dsi.getFrequency(), dsi.getUnits(),
				//				    dsi.getType(), sdf.format(dsi.getLastUpdate().getTime()), dum);
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.fred.cleanTitle
	 *
	 * @param title
	 * @return
	 */
	public static String cleanTitle(String title) {

		String sn = title.trim();
		//sn = FredCommon.replace(sn, "\\)", "");
		sn = sn.replaceAll("[/\\)\\(:,;\"]", " ");
		sn = sn.replaceAll("U.S.", "US");
		sn = FredCommon.replace(sn, "-Year", "Y");
		sn = FredCommon.replace(sn, "-Month", "M");
		sn = FredCommon.replace(sn, " -", "");
		sn = FredCommon.replace(sn, "Contributions to percent change in GDPNow", "");
		sn = FredCommon.replace(sn, "Except Manufacturers' Sales Branches and Offices Sales", "");
		sn = FredCommon.replace(sn, "Commercial Paper", "CP");
		sn = FredCommon.replace(sn, "Durable Goods", "DG");
		sn = FredCommon.replace(sn, "Nondurable Goods", "NDG");
		sn = FredCommon.replace(sn, "United States", "US");
		sn = FredCommon.replace(sn, "Real Change of", "RChg");
		sn = FredCommon.replace(sn, "Federal Funds Rate", "FFR");
		sn = FredCommon.replace(sn, "Personal Consumption Expenditures", "PCE");
		sn = FredCommon.replace(sn, "Nonfinancial", "NonFin");
		sn = FredCommon.replace(sn, "Government", "Govt");
		sn = FredCommon.replace(sn, "London Interbank Offered Rate", "");
		sn = FredCommon.replace(sn, "Owned and Securitized", "OwnedSecured");
		sn = FredCommon.replace(sn, "Private Domestic", "Priv Dom");
		sn = FredCommon.replace(sn, "Capacity Utilization", "CapUtil");
		sn = FredCommon.replace(sn, "Transportation", "Transport");
		sn = FredCommon.replace(sn, "Durable Manufacturing", "Dur Manufacturing");
		sn = FredCommon.replace(sn, "Nondurable Manufacturing", "NonDur Manufacturing");
		sn = FredCommon.replace(sn, "miscellaneous", "Misc");
		sn = FredCommon.replace(sn, "Equipment", "Equip");
		sn = FredCommon.replace(sn, "Corporate", "Corp");
		sn = FredCommon.replace(sn, "Information", "Info");
		sn = FredCommon.replace(sn, "Organizations", "Orgs");
		sn = FredCommon.replace(sn, "Diffusion", "Diff");
		sn = FredCommon.replace(sn, "Investment", "Invest");
		sn = FredCommon.replace(sn, "Capital Goods", "CapGoods");
		sn = FredCommon.replace(sn, "development", "Devel");
		sn = FredCommon.replace(sn, "Consumer Price Index", "CPI");
		sn = FredCommon.replace(sn, "Producer Price Index", "PPI");
		sn = FredCommon.toSentenceCase(sn);
		sn = sn.trim();

		return sn.trim();
	}

	public static DataSeriesInfo findDsi(String series) {

		final String s = series.trim();
		for (final DataSeriesInfo dsi : legacyDsi) {
			if (dsi.getName().trim().equalsIgnoreCase(s)) {
				return dsi;
			}
		}
		return null;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.fred.fromFullFileName
	 *
	 * @param fname
	 * @return
	 */
	public static String fromFullFileName(String fname) {

		final String ret = "";
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.getScaler
	 *
	 * @param seriesName
	 * @return
	 */
	private static double getScaler(String unt) {

		String units = unt.trim().toLowerCase();
		double ret = 1.0;
		
		if (units.contains("billion")) {
			ret = BILLION;
		} else if (units.contains("million")) {
			ret = MILLION;
		} else if (units.contains("thousand")) {
			ret = THOUSAND;
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.getShortTitle
	 *
	 * @param title
	 * @return
	 */
//	public static String getShortTitle(String title) {
//
//		final String s1 = title.replaceAll("Disposable Personal Income", "DPI")
//		    .replaceAll("Personal Consumption Expenditures", "PCE").replaceAll("London Interbank Offered Rate", "");
//		final String s2 = s1.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(", based on U.S. Dollar", "");
//		final String s3 = s2.replaceAll("Compensation of Employees, Received: ", "");
//		final String s4 = s3.replaceAll("\\s+", "");
//		return s4.trim();
//	}

	private static boolean isArticle(String word) {

		if (word.equalsIgnoreCase("the")) {
			return true;
		} else if (word.equalsIgnoreCase("and")) {
			return true;
		} else if (word.equalsIgnoreCase("except")) {
			return true;
		} else if (word.equalsIgnoreCase("for")) {
			return true;
		} else if (word.equalsIgnoreCase("of")) {
			return true;
		} else if (word.equalsIgnoreCase("with")) {
			return true;
		} else if (word.equalsIgnoreCase("to")) {
			return true;
		} else if (word.equalsIgnoreCase("on")) {
			return true;
		}
		return false;
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
						final String fld[] = str.split("\t");
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
	 * net.ajaskey.market.tools.fred.replace
	 *
	 * @param in
	 * @param fnd
	 * @param rep
	 * @return
	 */
	private static String replace(String in, String fnd, String rep) {

		final String ret = in.replaceAll(fnd, rep).replaceAll(fnd.toUpperCase(), rep).replaceAll(fnd.toLowerCase(), rep)
		    .trim();
		return ret;
	}

	public static String toFullFileName(String series, String title) {

		final String titl = FredCommon.cleanTitle(title);
		String ret = fredPath + "[" + series + "] - " + titl;
		final int len = ret.length();
		if (len > 250) {
			ret = ret.substring(0, 250).trim();
		}
		return ret + ".csv";
	}

	public static String toSentenceCase(String title) {

		final StringBuilder sb = new StringBuilder();

		final String fld[] = title.split("\\s+");

		for (final String s : fld) {
			if (!FredCommon.isArticle(s)) {
				sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
				sb.append(" ");
			} else {
				sb.append(s + " ");
			}
		}

		String ret = sb.toString().replaceAll("\\s+", " ").trim();

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.writeSeriesInfo
	 *
	 * @param ds
	 * @param pw
	 * @throws FileNotFoundException
	 */
	public static void writeSeriesInfo(DataSeriesInfo ds, PrintWriter pw) {

		if ((pw != null) && (ds != null)) {
			pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", ds.getName(), ds.getTitle(), ds.getRefChart(), ds.getFrequency(),
			    ds.getUnits(), ds.getType(), sdf.format(ds.getLastUpdate().getTime()),
			    sdf.format(ds.getLastObservation().getTime()));
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.writeSeriesInfo
	 *
	 * @param dsList
	 * @throws FileNotFoundException
	 */
	public static void writeSeriesInfo(List<DataSeriesInfo> dsList) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "/fred-series-info.txt")) {
			pw.println(infoHeader);
			for (final DataSeriesInfo ds : dsList) {
				//System.out.println(ds);
				pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", ds.getName(), ds.getTitle(), ds.getRefChart(), ds.getFrequency(),
				    ds.getUnits(), ds.getType(), sdf.format(ds.getLastUpdate().getTime()),
				    sdf.format(ds.getLastObservation().getTime()));
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.writeToOptuma
	 *
	 * @param data
	 * @param seriesName
	 */
	public static void writeToOptuma(List<DataValues> data, String fullFileName, String seriesName, String units) {

		final double scaler = FredCommon.getScaler(units);

		final File file = new File(fullFileName);
		//System.out.println(file.getAbsolutePath());
		try (PrintWriter pw = new PrintWriter(file)) {
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

}
