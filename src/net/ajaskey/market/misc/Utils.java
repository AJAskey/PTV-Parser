
package net.ajaskey.market.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * This class contains static utility methods used by this project.
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class Utils {

	private final static Calendar					baseDate	= Calendar.getInstance();
	public final static SimpleDateFormat	sdf				= new SimpleDateFormat("dd-MMM-yyyy");
	public final static SimpleDateFormat	sdf2			= new SimpleDateFormat("E dd-MMM-yyyy");

	// public static String[] daysOfWeek = { "SUN", "MON", "TUE", "WED", "THU",
	// "FRI", "SAT" };

	public static String	NL	= System.lineSeparator();
	public static String	TAB	= "\t";

	private static NumberFormat intFmt = null;

	static public Map<String, Integer>	mapNames	= null;
	static public Map<String, Integer>	mapDays		= null;
	final static public Locale					locale		= Locale.getDefault();

	private static boolean initialized = false;

	public static Calendar buildCalendar(Calendar inCal) {

		final Calendar cal = Calendar.getInstance();
		cal.set(inCal.get(Calendar.YEAR), inCal.get(Calendar.MONTH), inCal.get(Calendar.DATE));
		return cal;
	}

	/**
	 *
	 * net.ajaskey.market.misc.buildCalendar
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar buildCalendar(int year, int month, int day) {

		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal;
	}

	/**
	 * net.ajaskey.market.ta.printCalendar
	 *
	 * @param cal
	 */
	public static String calendarToLongString(Calendar cal) {

		String ret = cal.toString() + "\n";
		ret += "  Year         : " + cal.get(Calendar.YEAR) + "\n";
		ret += "  Month        : " + cal.get(Calendar.MONTH) + "\n";
		ret += "  Day of Month : " + cal.get(Calendar.DAY_OF_MONTH) + "\n";
		ret += "  Day of Year  : " + cal.get(Calendar.DAY_OF_YEAR) + "\n";
		ret += "  Week of Year : " + cal.get(Calendar.WEEK_OF_YEAR) + "\n";
		return ret;

	}

	private static String findName(Map<String, Integer> map, Integer key) {

		for (final Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == key) {
				return entry.getKey();
			}
		}
		return "NotFound";
	}

	/**
	 *
	 * net.ajaskey.market.misc.formatInt
	 *
	 * @param i
	 * @return
	 */
	public static String formatInt(int i) {

		return (Utils.formatInt((long) i));
	}

	/**
	 *
	 * net.ajaskey.market.misc.formatInt
	 *
	 * @param i
	 * @return
	 */
	public static String formatInt(long i) {

		String ret = "";
		Utils.init();
		try {
			ret = intFmt.format(i);
		} catch (final Exception e) {
			ret = "not number";
		}
		return ret;
	}

	/**
	 *
	 * Returns the base date of 01-Jan-1900.
	 *
	 * @return baseDate
	 */
	public static Calendar getBaseDate() {

		Utils.init();
		return baseDate;
	}

	public static String getDataPath() {

		final String path = System.getProperty("dataPath", "C:\\Users\\ajask_000\\Documents\\EODData\\DataClient");
		return path;
	}

	/**
	 *
	 * net.ajaskey.market.misc.getDayOfWeek
	 *
	 * @param cal
	 * @return
	 */
	public static String getDayName(Calendar cal) {

		try {
			Utils.init();
			return Utils.findName(mapDays, cal.get(Calendar.DAY_OF_WEEK));
		} catch (final Exception e) {
			return "unknown-day";
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.getFromUrl
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getFromUrl(String url) throws IOException {

		final StringBuilder sb = new StringBuilder();

		final URL myURL = new URL(url);
		final URLConnection myURLConnection = myURL.openConnection();
		myURLConnection.connect();
		String line;
		try (BufferedReader resp = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()))) {
			while ((line = resp.readLine()) != null) {
				if (line.length() > 0) {
					sb.append(line + NL);
				}
			}
		}
		return sb.toString();
	}

	public static String getMonthName(Calendar cal) {

		try {
			Utils.init();
			return Utils.findName(mapNames, cal.get(Calendar.MONTH));
		} catch (final Exception e) {
			return "unknown-month";
		}
	}

	public static String getMonthName(int month) {

		try {
			Utils.init();
			return Utils.findName(mapNames, month);
		} catch (final Exception e) {
			return "unknown-month";
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.getString
	 *
	 * @param cal
	 * @return
	 */
	static public String getString(Calendar cal) {

		return sdf.format(cal.getTime());
	}

	/**
	 *
	 * net.ajaskey.market.ta.getTimeSpan
	 *
	 * @param recent
	 * @param lessRecent
	 * @return
	 */
	static public long getTimeSpan(Calendar recent, Calendar lessRecent) {

		Utils.init();
		return TimeUnit.MILLISECONDS.toDays(Math.abs(lessRecent.getTimeInMillis() - recent.getTimeInMillis()));
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	private static void init() {

		if (!initialized) {
			Utils.baseDate.set(1900, Calendar.JANUARY, 1, 0, 0, 1);
			mapNames = baseDate.getDisplayNames(Calendar.MONTH, Calendar.LONG, locale);
			mapDays = baseDate.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale);

			intFmt = NumberFormat.getNumberInstance();
			initialized = true;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.makeCopy
	 *
	 * @param cal
	 * @return
	 */
	public static Calendar makeCopy(Calendar cal) {

		Calendar newCal = null;
		if (cal == null) {
			newCal = Calendar.getInstance();
		} else {
			newCal = (Calendar) cal.clone();
		}
		return newCal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.makeDir
	 *
	 * @param dir
	 */
	static public void makeDir(String dir) {

		final File theDir = new File(dir);
		if (!theDir.exists()) {
			theDir.mkdir();
		}
	}

	/**
	 * net.ajaskey.market.misc.newline
	 *
	 */
	public static void newline() {

		System.out.println();
	}

	public static void print(String str) {

		System.out.println(str);
	}

	/**
	 *
	 * net.ajaskey.market.misc.printCalendar
	 *
	 * @param cal
	 */
	public static void printCalendar(Calendar cal) {

		if (cal != null) {
			System.out.println(sdf2.format(cal.getTime()) + TAB + cal.get(Calendar.DAY_OF_YEAR));
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.sameDate
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean sameDate(Calendar cal1, Calendar cal2) {

		if ((cal1 == null) || (cal2 == null)) {
			return false;
		}
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
				if (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.ta.sameMonth
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean sameMonth(Calendar cal1, Calendar cal2) {

		if ((cal1 == null) || (cal2 == null)) {
			return false;
		}
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.ta.sameYear
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean sameYear(Calendar cal1, Calendar cal2) {

		if ((cal1 == null) || (cal2 == null)) {
			return false;
		}
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.misc.stringDate
	 *
	 * @param cal
	 * @return
	 */
	public static String stringDate(Calendar cal) {

		if (cal != null) {
			return sdf.format(cal.getTime());
		}
		return "";
	}

	/**
	 *
	 * net.ajaskey.market.misc.stringDate2
	 *
	 * @param cal
	 * @return
	 */
	public static String stringDate2(Calendar cal) {

		if (cal != null) {
			return sdf2.format(cal.getTime());
		}
		return "";
	}

	//////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * net.ajaskey.market.misc.getFileExt
	 *
	 * @param f
	 * @return
	 */
	public static String getFileExt(File f) {

		String fname = f.getName().trim();
		if ((fname.lastIndexOf(".") != -1) && (fname.lastIndexOf(".") != 0))
		  return fname.substring(fname.lastIndexOf(".") + 1).trim();
		else
			return "";
	}
	
	public static String removeFileExt(File f) {

		String fname = f.getName();
		if ((fname.lastIndexOf(".") != -1) && (fname.lastIndexOf(".") != 0))
		  return fname.substring(0, fname.lastIndexOf("."));
		else
			return "";
	}

	public static boolean isInExtList(File f, List<String> ext) {

		String fext = "." + getFileExt(f).trim().toLowerCase();
		if (fext.length() > 1) {
			for (String s : ext) {
				if (s.toLowerCase().contains(fext)) {
					return true;
				}
			}
		}
		return false;
	}

	public static List<File> getDirTree(File top, List<String> ext) {

		List<File> retFiles = new ArrayList<>();
		updateDirTree(retFiles, top, ext);
		return retFiles;

	}

	private static void updateDirTree(List<File> list, File top, List<String> ext) {

		if ((top.exists()) && top.isDirectory()) {
			for (final File aFile : top.listFiles()) {
				if (aFile.isDirectory()) {
					updateDirTree(list, aFile, ext);
				} else {
					if (isInExtList(aFile, ext)) {
						list.add(aFile);
					}
				}
			}
		}
	}

}
