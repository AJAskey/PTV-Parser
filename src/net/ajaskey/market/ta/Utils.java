
package net.ajaskey.market.ta;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class Utils {

	public final static Calendar					baseDate		= Calendar.getInstance();
	public final static SimpleDateFormat	sdf					= new SimpleDateFormat("dd-MMM-yyyy");
	public final static SimpleDateFormat	sdf2				= new SimpleDateFormat("E dd-MMM-yyyy");

	public static String[]								daysOfWeek	= { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	public static String									NL					= System.lineSeparator();
	public static String									TAB					= "\t";

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Utils() {
		Utils.baseDate.set(Calendar.YEAR, 1900);
		Utils.baseDate.set(Calendar.DAY_OF_YEAR, 1);
		Utils.baseDate.set(Calendar.HOUR, 0);
		Utils.baseDate.set(Calendar.MINUTE, 0);
		Utils.baseDate.set(Calendar.SECOND, 1);
		Utils.baseDate.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * net.ajaskey.market.ta.printCalendar
	 *
	 * @param cal
	 */
	public static String calendarToString(Calendar cal) {
		String ret = cal.toString() + "\n";
		ret += "  Year         : " + cal.get(Calendar.YEAR) + "\n";
		ret += "  Month        : " + cal.get(Calendar.MONTH) + "\n";
		ret += "  Day of Month : " + cal.get(Calendar.DAY_OF_MONTH) + "\n";
		ret += "  Day of Year  : " + cal.get(Calendar.DAY_OF_YEAR) + "\n";
		ret += "  Week of Year : " + cal.get(Calendar.WEEK_OF_YEAR) + "\n";
		return ret;

	}

	public static String getDayOfWeek(Calendar cal) {
		final int dow = cal.get(Calendar.DAY_OF_WEEK);
		return daysOfWeek[dow];
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
		return TimeUnit.MILLISECONDS.toDays(Math.abs(lessRecent.getTimeInMillis() - recent.getTimeInMillis()));
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

	public static void printCalendar(Calendar cal) {
		if (cal != null) {
			System.out.println(sdf2.format(cal.getTime()));
		}
	}

	public static String stringCalendar(Calendar cal) {
		if (cal != null) {
			return sdf2.format(cal.getTime());
		}
		return "";
	}

}
