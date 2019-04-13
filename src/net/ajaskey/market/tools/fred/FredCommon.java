
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.stat.regression.SimpleRegression;

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
public class FredCommon {

	public final static String fredPath = OptumaCommon.optumaPath + "FRED-Download\\";

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

	final static String infoHeader = "Name\tTitle\tMethod\tFrequency\tUnits\tType\tLast Download\tLast Observation";

	final public static double BILLION = 1E9;

	final public static double MILLION = 1E6;

	final public static double THOUSAND = 1E3;

	public static List<DataSeriesInfo> legacyDsi = null;

	public static void addSeries(List<DataSeriesInfo> allSeries) throws FileNotFoundException, IOException {

		final List<String> data = new ArrayList<>();

		for (DataSeriesInfo dsi : allSeries) {
			try {
				if (dsi.getTitle().length() == 0) {
					dsi = new DataSeriesInfo(dsi.getName());
				}
				final String s = FredCommon.toSeriesInfo(dsi);
				data.add(s);
			} catch (final Exception e) {
			}
		}

		Collections.sort(data);

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "/fred-series-info.txt")) {
			pw.println(infoHeader);

			for (final String s : data) {
				System.out.print(s);
				pw.print(s);
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

		sn = sn.replaceAll("[/\\)\\(:,;\"]", " ");
		sn = sn.replaceAll("U.S.", "US");
		sn = FredCommon.replace(sn, "-Year", "Y");
		sn = FredCommon.replace(sn, "-Month", "M");
		sn = FredCommon.replace(sn, " -", "");

		sn = FredCommon.replace(sn, "Control", "Ctrl");
		sn = FredCommon.replace(sn, "Value of Manufacturers'", "Value");
		sn = FredCommon.replace(sn, "Components", "Comp");
		sn = FredCommon.replace(sn, "Ventilation  Heating  Air-Conditioning", "HVAC");
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
		sn = FredCommon.replace(sn, "Industries", "Ind");
		sn = FredCommon.replace(sn, "Nondefense", "NonDef");

		sn = FredCommon.toSentenceCase(sn);

		return sn;
	}

	/**
	 * net.ajaskey.market.tools.fred.copyToSimpleFileNames
	 *
	 */
	public static void copyToSimpleFileNames() {

		FredCommon.copyToSimpleFileNames("");

	}

	public static void copyToSimpleFileNames(String toDir) {

		int len = toDir.trim().length();

		String toDirectory = FredCommon.fredPath;
		if (len > 0) {
			toDirectory = toDir.trim();
		}

		len = toDirectory.length();
		final String eos = toDirectory.substring(len - 1, len);

		if (!eos.equals("\\")) {
			toDirectory += "\\";
		}
		System.out.println(toDirectory);

		final List<String> copy_names = FredCommon.readTextNames(FredCommon.fredPath + "fred-copy-names.txt");

		final File folder = new File(FredCommon.fredPath);
		final File[] existingFiles = folder.listFiles();

		for (final String s : copy_names) {
			System.out.println(s);
		}

		for (final File from : existingFiles) {
			final String name = from.getName();
			if (name.contains("[")) {
				final String ename = FredCommon.fromFullFileNameToSeries(name);
				for (final String s : copy_names) {
					if (ename.equalsIgnoreCase(s)) {
						final File to = new File(toDirectory + ename + ".csv");
						System.out.println(to.getAbsolutePath());
						try {
							Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} catch (final IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.doPropagate
	 *
	 * @param name
	 * @return
	 */
	public static boolean doPropagate(List<DataSeriesInfo> p_list, String name) {

		for (final DataSeriesInfo dsi : p_list) {
			if (name.equalsIgnoreCase(dsi.getName())) {
				System.out.println("\nPropagating : " + name);
				return true;
			}
		}
		return false;
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

		String ret = "";
		if ((fname != null) && (fname.trim().length() > 2)) {
			final int idx = fname.lastIndexOf(".");
			if (idx > 0) {
				final String ext = fname.substring(idx);
				if (ext.equalsIgnoreCase(".csv")) {
					final String fld[] = fname.trim().split("]");
					if (fld.length > 1) {
						ret = fld[0].replaceAll("\\[", "").trim();
						ret += ext;
					}
				}
			}
		}
		return ret;
	}

	public static String fromFullFileNameToSeries(String fname) {

		String ret = "";
		final String str = FredCommon.fromFullFileName(fname);
		if (str.length() > 0) {
			final int idx = str.lastIndexOf(".");
			if (idx > 0) {
				ret = str.substring(0, idx);
			} else {
				ret = str;
			}
		}

		return ret;
	}

	private static double getGrowth(String freq, double lastVal, double nextLastVal, double factor) {

		double ret = 0.0;
		try {
			ret = ((lastVal - nextLastVal) / nextLastVal) * factor;
		} catch (final Exception e) {
			ret = 0.0;
		}
		return ret;
	}

	private static double getGrowthValue(String freq, double lastVal, double nextLastVal, double baseVal, double factor) {

		double ret = 0.0;

		System.out.printf("Growth : %s\t%f\t%f\t%f %n", freq, lastVal, nextLastVal, baseVal);

		try {
			final double growth = ((lastVal - nextLastVal) / nextLastVal) * factor;
			ret = baseVal + (baseVal * growth);
		} catch (final Exception e) {
			ret = lastVal;
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.getScaler
	 *
	 * @param seriesName
	 * @return
	 */
	private static double getScaler(String unt) {

		final String units = unt.trim().toLowerCase();
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

	private static List<DataValues> propagate(List<DataValues> data, String freq) {

		final List<DataValues> retProp = new ArrayList<>();

		try {
			final Calendar lastDate = data.get(data.size() - 1).getDate();
			final Calendar today = Calendar.getInstance();
			//System.out.printf("%s\t%s\t Last Date%n", Utils.getString(lastDate), freq);
			boolean doit = true;

			final Calendar next = Utils.buildCalendar(lastDate);
			data.get(data.size() - 1).getValue();

			if (freq.trim().toUpperCase().contains("QUARTER")) {

				int regKnt = 18;
				final SimpleRegression reg = FredCommon.regression(data, regKnt);
				if (reg == null) {
					return retProp;
				}

				while (doit) {
					next.add(Calendar.MONTH, 3);
					//System.out.printf("%s\t%f%n", Utils.getString(next), lval);
					if (next.before(today)) {

						final double newVal = reg.predict(regKnt++);

						final DataValues newDv = new DataValues(Utils.buildCalendar(next), newVal);
						//System.out.printf("%s\t%s\t%f\t%f%n", Utils.getString(next), freq, lval, newVal);
						retProp.add(newDv);
					} else {
						final Calendar cal = Calendar.getInstance();
						final double newVal = reg.predict(regKnt - 0.5);
						final DataValues newDv = new DataValues(cal, newVal);
						retProp.add(newDv);
						doit = false;
					}
				}
			} else if (freq.trim().toUpperCase().contains("MONTH")) {

				int regKnt = 12;
				final SimpleRegression reg = FredCommon.regression(data, regKnt);
				if (reg == null) {
					return retProp;
				}

				while (doit) {
					next.add(Calendar.MONTH, 1);
					//System.out.printf("%s\t%f%n", Utils.getString(next), lval);
					if (next.before(today)) {

						final double newVal = reg.predict(regKnt++);

						final DataValues newDv = new DataValues(Utils.buildCalendar(next), newVal);
						retProp.add(newDv);
					} else {

						final Calendar cal = Calendar.getInstance();
						final int dom = cal.get(Calendar.DAY_OF_MONTH);
						final double monthFactor = dom / 30.0;
						regKnt--;
						final double newVal = reg.predict(regKnt + monthFactor);

						final DataValues newDv = new DataValues(cal, newVal);
						retProp.add(newDv);
						doit = false;
					}
				}
			} else if (freq.trim().toUpperCase().contains("WEEK")) {

				int regKnt = 13;
				final SimpleRegression reg = FredCommon.regression(data, regKnt);
				if (reg == null) {
					return retProp;
				}

				while (doit) {
					next.add(Calendar.DATE, 7);
					if (next.before(today)) {

						final double newVal = reg.predict(regKnt++);

						final DataValues newDv = new DataValues(Utils.buildCalendar(next), newVal);
						retProp.add(newDv);
					} else {

						final Calendar cal = Calendar.getInstance();
						final int dow = cal.get(Calendar.DAY_OF_WEEK);
						final double weekFactor = dow / 7.0;
						regKnt--;
						final double newVal = reg.predict(regKnt + weekFactor);

						final DataValues newDv = new DataValues(cal, newVal);
						retProp.add(newDv);
						doit = false;
					}
				}
			} else if (freq.trim().toUpperCase().contains("ANNUAL")) {

				int regKnt = 10;
				final SimpleRegression reg = FredCommon.regression(data, regKnt);
				if (reg == null) {
					return retProp;
				}

				while (doit) {
					next.add(Calendar.YEAR, 1);
					//System.out.printf("%s\t%f%n", Utils.getString(next), lval);
					if (next.before(today)) {

						final double newVal = reg.predict(regKnt++);

						final DataValues newDv = new DataValues(Utils.buildCalendar(next), newVal);
						retProp.add(newDv);
					} else {

						final Calendar cal = Calendar.getInstance();
						final int doy = cal.get(Calendar.DAY_OF_YEAR);
						final double yearFactor = doy / 365.0;
						regKnt--;
						final double newVal = reg.predict(regKnt + yearFactor);

						final DataValues newDv = new DataValues(cal, newVal);
						retProp.add(newDv);
						doit = false;
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
			retProp.clear();
		}
		return retProp;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.fred.queryFredDsi
	 *
	 * @param codeNames
	 * @return
	 */
	public static List<DataSeriesInfo> queryFredDsi(List<String> codeNames) {

		final List<DataSeriesInfo> ret = new ArrayList<>();

		for (final String code : codeNames) {
			File f = new File(FredCommon.fredPath + "/" + code + ".csv");
			Calendar cLastUpdate = Calendar.getInstance();
			cLastUpdate.setTimeInMillis(f.lastModified());
			String lastUpdate = sdf.format(f.lastModified());
			
			DataSeriesInfo dsi = queryFredDsi(code, lastUpdate);
			if (dsi != null) {
				ret.add(dsi);
			}
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.queryFredDsi
	 *
	 * @param code
	 * @return
	 */
	public static DataSeriesInfo queryFredDsi(String code, String lastUpdate) {

		for (int i = 0; i <= FredDataDownloader.maxRetries; i++) {
			Utils.sleep((1000 * (5 * i)) + 250);
			final DataSeriesInfo dsi = new DataSeriesInfo(code);
			if (dsi != null) {
				if ((dsi.getResponse() != null) && (dsi.getResponse().length() > 0)) {
					if (dsi.getTitle() != null) {
						FredDataDownloader.retryCount = 0;
						//Debug.pwDbg.printf("Received data for %s%n", code);
						Debug.log(
						    String.format("Received data for %s%n%s%nLast Update : %s%n", code, dsi.getResponse(), lastUpdate));
						return dsi;
					}
				}
			}
			FredDataDownloader.retryCount++;
			if (i < FredDataDownloader.maxRetries) {
				Debug.log(String.format("Retrying DSI query for %s", code));
			} else if (i == FredDataDownloader.maxRetries) {
				FredDataDownloader.tryAgainFile.println(code);
				FredDataDownloader.tryAgainFile.flush();
			}
		}

		if (FredDataDownloader.retryCount > FredDataDownloader.consecutiveRetryFailures) {
			Debug.log(String.format("Too many retries (%d). Sleeping %d seconds.", FredDataDownloader.retryCount,
			    (FredDataDownloader.longSleep / 1000)));

			Utils.sleep(FredDataDownloader.longSleep);
			FredDataDownloader.retryCount = 0;
		}

		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.readFromOptuma
	 *
	 * @param fname
	 * @return
	 */
	public static List<DataValues> readFromOptuma(String fname) {

		final List<DataValues> ret = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if ((str.length() > 4) && (!str.toLowerCase().contains("date"))) {
					final String fld[] = str.split(",");
					final Calendar cal = Calendar.getInstance();
					final Date d = DataValues.sdf.parse(fld[0].trim());
					cal.setTime(d);
					final double val = Double.parseDouble(fld[1].trim());
					final DataValues dv = new DataValues(cal, val);
					ret.add(dv);
				}

			}
		} catch (final FileNotFoundException e) {
			ret.clear();
		} catch (final IOException e) {
			ret.clear();
		} catch (final ParseException e) {
			ret.clear();
		}

		return ret;

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
	 * net.ajaskey.market.tools.fred.readSeriesList
	 *
	 * @param string
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static List<String> readSeriesList(String fname) throws FileNotFoundException, IOException {

		final Set<String> uniqCodes = new HashSet<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				final String fld[] = str.split("\\s+");
				final String code = fld[0].trim().toUpperCase();
				uniqCodes.add(code);
			}
		}

		final List<String> ret = new ArrayList<>(uniqCodes);
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.readSeriesNames
	 *
	 * @param string
	 * @return
	 */
	public static List<DataSeriesInfo> readSeriesNames(String fname) {

		final List<DataSeriesInfo> retList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					if (!str.equals(infoHeader)) {
						final String s1 = str.substring(0, 1);
						if (!s1.contains("#")) {
							final String fld[] = str.split("\t");
							DataSeriesInfo dsi = null;
							if (fld.length < 5) {
								dsi = new DataSeriesInfo(fld[0]);
							} else {
								dsi = new DataSeriesInfo(fld);
							}
							retList.add(dsi);
						}
					}
				}

			}
		} catch (final IOException e) {
			retList.clear();
		}
		return retList;
	}

	public static List<String> readTextNames(String fname) {

		final List<String> retList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					final String s1 = str.substring(0, 1);
					if (!s1.contains("#")) {
						final String fld[] = str.split("[\\s+,]");
						if (fld.length > 0) {
							retList.add(fld[0].trim());
						}
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
	 * net.ajaskey.market.tools.fred.regression
	 *
	 * @param data
	 * @param valuesToUse
	 * @return
	 */
	public static SimpleRegression regression(List<DataValues> data, int valuesToUse) {

		try {
			final SimpleRegression ret = new SimpleRegression(true);

			final int len = data.size();

			if (valuesToUse > len) {
				return null;
			}

			final int start = len - valuesToUse;
			int regKnt = 0;
			for (int i = start; i < len; i++) {
				//System.out.println(data.get(i));
				ret.addData(regKnt++, data.get(i).getValue());
			}

			return ret;
		} catch (final Exception e) {
			return null;
		}
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

		final String ret = sb.toString().replaceAll("\\s+", " ").trim();

		return ret;
	}

	public static String toSeriesInfo(DataSeriesInfo dsi) {

		String ret = "";
		String lastObs = "";
		String lastUpdate = "";
		if (dsi != null) {
			if (dsi.getLastObservation() != null) {
				lastObs = sdf.format(dsi.getLastObservation().getTime());
			}
			if (dsi.getLastUpdate() != null) {
				lastUpdate = sdf.format(dsi.getLastUpdate().getTime());
			}
			ret = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", dsi.getName(), dsi.getTitle(), dsi.getRefChart(),
			    dsi.getFrequency(), dsi.getUnits(), dsi.getType(), lastUpdate, lastObs);
		}
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
	public static void writeSeriesInfo(DataSeriesInfo dsi, PrintWriter pw) {

		if ((pw != null) && (dsi != null) && (dsi.getTitle() != null)) {
			pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", dsi.getName(), dsi.getTitle(), dsi.getSeasonalAdjusted(),
			    dsi.getFrequency(), dsi.getUnits(), dsi.getType(), sdf.format(dsi.getLastUpdate().getTime()),
			    sdf.format(dsi.getLastObservation().getTime()));
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.writeSeriesInfo
	 *
	 * @param dsList
	 * @throws FileNotFoundException
	 */
	public static void writeSeriesInfo(List<DataSeriesInfo> dsList, String filename) throws FileNotFoundException {

		final File f = new File(filename);
		if (f.exists()) {
			final File fb = new File(f.getAbsolutePath() + ".bak");
			try {
				Files.copy(f.toPath(), fb.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		try (PrintWriter pw = new PrintWriter(f)) {
			pw.println(infoHeader);
			for (final DataSeriesInfo ds : dsList) {
				//System.out.println(ds);
				try {
					if (ds != null) {
						pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s%n", ds.getName(), ds.getTitle(), ds.getSeasonalAdjusted(),
						    ds.getFrequency(), ds.getUnits(), ds.getType(), sdf.format(ds.getLastUpdate().getTime()),
						    sdf.format(ds.getLastObservation().getTime()));
					}
				} catch (final Exception e) {
					e.printStackTrace();
					System.out.println("Continuing... after error in " + ds.getName());
				}
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.writeToOptuma
	 *
	 * @param data
	 * @param seriesName
	 * @param freq
	 */
	public static void writeToOptuma(List<DataValues> data, String fullFileName, String seriesName, String units,
	    String freq, boolean propagate) {

		final double scaler = FredCommon.getScaler(units);

		//		List<DataValues> propagated = new ArrayList<>();
		//
		//		if (propagate) {
		//			propagated = FredCommon.propagate(data, freq);
		//		}

		String ffn = fullFileName.replace(">", "greater");
		final File file = new File(ffn);
		final File fileshort = new File(FredCommon.fredPath + seriesName + ".csv");
		try (PrintWriter pw = new PrintWriter(file); PrintWriter pwShort = new PrintWriter(fileshort)) {
			pw.println("Date," + seriesName);
			pwShort.println("Date," + seriesName);
			for (final DataValues dv : data) {
				final String date = DataValues.sdf.format(dv.getDate().getTime());
				final double d = dv.getValue() * scaler;
				pw.printf("%s,%.2f%n", date, d);
				pwShort.printf("%s,%.2f%n", date, d);
			}
			//Overwrite short filename with any propagated codes
			//			for (final DataValues dv : propagated) {
			//				final String date = DataValues.sdf.format(dv.getDate().getTime());
			//				final double d = dv.getValue() * scaler;
			//				//pw.printf("%s,%.2f%n", date, d);
			//				pwShort.printf("%s,%.2f%n", date, d);
			//			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
