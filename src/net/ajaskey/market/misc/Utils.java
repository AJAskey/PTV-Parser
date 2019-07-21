
package net.ajaskey.market.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
	public final static SimpleDateFormat	sdfFull		= new SimpleDateFormat("E dd-MMM-yyyy HH:mm:ss");
	public final static SimpleDateFormat	sdfTime		= new SimpleDateFormat("HH:mm:ss.SSS");

	// public static String[] daysOfWeek = { "SUN", "MON", "TUE", "WED", "THU",
	// "FRI", "SAT" };

	public static String	NL	= System.lineSeparator();
	public static String	TAB	= "\t";

	private static NumberFormat intFmt = null;

	static public Map<String, Integer>	mapNames	= null;
	static public Map<String, Integer>	mapDays		= null;
	final static public Locale					locale		= Locale.getDefault();

	private static boolean initialized = false;

	/**
	 *
	 * net.ajaskey.market.misc.buildCalendar
	 *
	 * @param inCal
	 * @return
	 */
	public static Calendar buildCalendar(final Calendar inCal) {

		final Calendar cal = Calendar.getInstance();
		cal.set(inCal.get(Calendar.YEAR), inCal.get(Calendar.MONTH), inCal.get(Calendar.DATE), inCal.get(Calendar.HOUR_OF_DAY),
		    inCal.get(Calendar.MINUTE), inCal.get(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 *
	 * net.ajaskey.market.misc.buildCalendar
	 *
	 * @param date
	 * @return
	 */
	public static Calendar buildCalendar(final Date date) {

		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
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
	public static Calendar buildCalendar(final int year, final int month, final int day) {

		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal;
	}

	/**
	 * net.ajaskey.market.ta.printCalendar
	 *
	 * @param cal
	 */
	public static String calendarToLongString(final Calendar cal) {

		String ret = cal.toString() + "\n";
		ret += "  Year         : " + cal.get(Calendar.YEAR) + "\n";
		ret += "  Month        : " + cal.get(Calendar.MONTH) + "\n";
		ret += "  Day of Month : " + cal.get(Calendar.DAY_OF_MONTH) + "\n";
		ret += "  Day of Year  : " + cal.get(Calendar.DAY_OF_YEAR) + "\n";
		ret += "  Week of Year : " + cal.get(Calendar.WEEK_OF_YEAR) + "\n";
		return ret;

	}

	private static String findName(final Map<String, Integer> map, final Integer key) {

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
	public static String formatInt(final int i) {

		return (Utils.formatInt((long) i));
	}

	/**
	 *
	 * net.ajaskey.market.misc.formatInt
	 *
	 * @param i
	 * @return
	 */
	public static String formatInt(final long i) {

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

	/**
	 * net.ajaskey.market.misc.getCurrentDateStr
	 *
	 * @return
	 */
	public static String getCurrentDateStr() {

		final Calendar cal = Calendar.getInstance();
		return Utils.getStringFull(cal);
	}

	public static String getCurrentTime() {

		final Calendar cal = Calendar.getInstance();
		return sdfTime.format(cal.getTime());
	}

	public static String getDataPath() {

		final String path = System.getProperty("dataPath", "C:\\Data\\EODData\\DataClient");
		return path;
	}

	/**
	 *
	 * net.ajaskey.market.misc.getDayOfWeek
	 *
	 * @param cal
	 * @return
	 */
	public static String getDayName(final Calendar cal) {

		try {
			Utils.init();
			return Utils.findName(mapDays, cal.get(Calendar.DAY_OF_WEEK));
		} catch (final Exception e) {
			return "unknown-day";
		}
	}

	public static List<File> getDirTree(final File top, final List<String> ext) {

		final List<File> retFiles = new ArrayList<>();
		Utils.updateDirTree(retFiles, top, ext);
		return retFiles;

	}

	/**
	 *
	 * net.ajaskey.market.misc.getFileExt
	 *
	 * @param f
	 * @return
	 */
	public static String getFileExt(final File f) {

		final String fname = f.getName().trim();
		if ((fname.lastIndexOf(".") != -1) && (fname.lastIndexOf(".") != 0)) {
			return fname.substring(fname.lastIndexOf(".") + 1).trim();
		}
		else {
			return "";
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
	public static String getFromUrl(final String url) {

		final StringBuilder sb = new StringBuilder();

		URL myURL;
		try {
			myURL = new URL(url);

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
		} catch (final IOException e) {
			return "";
		}
		return sb.toString();
	}

	public static String getMonthName(final Calendar cal) {

		try {
			Utils.init();
			return Utils.findName(mapNames, cal.get(Calendar.MONTH));
		} catch (final Exception e) {
			return "unknown-month";
		}
	}

	public static String getMonthName(final int month) {

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
	static public String getString(final Calendar cal) {

		return sdf.format(cal.getTime());
	}

	/**
	 * net.ajaskey.market.misc.getStringFull
	 *
	 * @param day
	 * @return
	 */
	public static String getStringFull(final Calendar cal) {

		return sdfFull.format(cal.getTime());
	}

	/**
	 *
	 * net.ajaskey.market.ta.getTimeSpan
	 *
	 * @param recent
	 * @param lessRecent
	 * @return
	 */
	static public long getTimeSpan(final Calendar recent, final Calendar lessRecent) {

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

	public static boolean isInExtList(final File f, final List<String> ext) {

		final String fext = "." + Utils.getFileExt(f).trim().toLowerCase();
		if (fext.length() > 1) {
			for (final String s : ext) {
				if (s.toLowerCase().contains(fext)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.ta.makeCopy
	 *
	 * @param cal
	 * @return
	 */
	public static Calendar makeCopy(final Calendar cal) {

		Calendar newCal = null;
		if (cal == null) {
			newCal = Calendar.getInstance();
		}
		else {
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
	static public void makeDir(final String dir) {

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

	public static void print(final String str) {

		System.out.println(str);
	}

	/**
	 *
	 * net.ajaskey.market.misc.printCalendar
	 *
	 * @param cal
	 */
	public static void printCalendar(final Calendar cal) {

		if (cal != null) {
			System.out.println(sdf2.format(cal.getTime()) + TAB + cal.get(Calendar.DAY_OF_YEAR));
		}
	}

	public static String removeFileExt(final File f) {

		final String fname = f.getName();
		if ((fname.lastIndexOf(".") != -1) && (fname.lastIndexOf(".") != 0)) {
			return fname.substring(0, fname.lastIndexOf("."));
		}
		else {
			return "";
		}
	}

	//////////////////////////////////////////////////////////////////////

	/**
	 *
	 * net.ajaskey.market.ta.sameDate
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean sameDate(final Calendar cal1, final Calendar cal2) {

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
	public static boolean sameMonth(final Calendar cal1, final Calendar cal2) {

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
	public static boolean sameYear(final Calendar cal1, final Calendar cal2) {

		if ((cal1 == null) || (cal2 == null)) {
			return false;
		}
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			return true;
		}
		return false;
	}

	/**
	 * net.ajaskey.market.misc.sleep
	 *
	 * @param i
	 */
	public static void sleep(final int milliseconds) {

		if (milliseconds < 1) {
			return;
		}

		try {
			Thread.sleep(milliseconds);
		} catch (final InterruptedException e) {
		}

	}

	/**
	 *
	 * net.ajaskey.market.misc.stringDate
	 *
	 * @param cal
	 * @return
	 */
	public static String stringDate(final Calendar cal) {

		if (cal != null) {
			return sdf.format(cal.getTime());
		}
		return "";
	}

	/**
	 *
	 * net.ajaskey.market.misc.stringDate
	 *
	 * @param dat
	 * @return
	 */
	public static String stringDate(final Date dat) {

		if (dat != null) {
			return sdf.format(dat);
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
	public static String stringDate2(final Calendar cal) {

		if (cal != null) {
			return sdf2.format(cal.getTime());
		}
		return "";
	}

	/**
	 *
	 * net.ajaskey.market.misc.updateDirTree
	 *
	 * @param list
	 * @param top
	 * @param ext
	 */
	private static void updateDirTree(final List<File> list, final File top, final List<String> ext) {

		if ((top.exists()) && top.isDirectory()) {
			for (final File aFile : top.listFiles()) {
				if (aFile.isDirectory()) {
					Utils.updateDirTree(list, aFile, ext);
				}
				else {
					if (Utils.isInExtList(aFile, ext)) {
						list.add(aFile);
					}
				}
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.writeToZipFile
	 *
	 * @param path
	 * @param zipStream
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeToZipFile(final String path, final ZipOutputStream zipStream) throws FileNotFoundException, IOException {

		final File file = new File(path);
		try (final FileInputStream fis = new FileInputStream(file)) {
			final ZipEntry zipEntry = new ZipEntry(path);
			zipStream.putNextEntry(zipEntry);

			final byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipStream.write(bytes, 0, length);
			}

			zipStream.closeEntry();
		}
	}

}
