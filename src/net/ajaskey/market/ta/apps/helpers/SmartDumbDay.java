
package net.ajaskey.market.ta.apps.helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
public class SmartDumbDay {

	final static public int				SMART	= 1;
	final static public int				DUMB	= 2;
	final static public String[]	MODE	= { "None", "Smart", "Dumb" };

	public static List<SmartDumbDay> days = new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.helpers.isValidDate
	 *
	 * @param cal
	 * @param holidays
	 * @return
	 */
	private static boolean isValidDate(Calendar cal, List<Calendar> holidays) {

		if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			return false;
		} else {
			for (final Calendar holiday : holidays) {
				if (Utils.sameDate(holiday, cal)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * net.ajaskey.market.ta.apps.helpers.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final Calendar cal = Utils.buildCalendar(2018, Calendar.JANUARY, 1);
		SmartDumbDay.set(cal);
	}

	public static List<Calendar> set(Calendar cal) {

		final List<Calendar> caldays = new ArrayList<>();
		final List<Calendar> holidays = SmartDumbDay.setHolidays();

		final Calendar today = Calendar.getInstance();

		while (cal.before(today)) {
			cal.add(Calendar.DATE, 1);
			if (SmartDumbDay.isValidDate(cal, holidays)) {
				caldays.add(Utils.buildCalendar(cal));
			}
		}

		return caldays;
	}

	/**
	 * net.ajaskey.market.ta.apps.helpers.setHolidays
	 *
	 * @param cal
	 *
	 * @return
	 */
	private static List<Calendar> setHolidays() {

		final List<Calendar> ret = new ArrayList<>();

		ret.add(Utils.buildCalendar(2016, Calendar.JANUARY, 1));
		ret.add(Utils.buildCalendar(2016, Calendar.JANUARY, 18));
		ret.add(Utils.buildCalendar(2016, Calendar.FEBRUARY, 15));
		ret.add(Utils.buildCalendar(2016, Calendar.MARCH, 25));
		ret.add(Utils.buildCalendar(2016, Calendar.MAY, 30));
		ret.add(Utils.buildCalendar(2016, Calendar.JULY, 4));
		ret.add(Utils.buildCalendar(2016, Calendar.SEPTEMBER, 5));
		ret.add(Utils.buildCalendar(2016, Calendar.NOVEMBER, 25));
		ret.add(Utils.buildCalendar(2016, Calendar.DECEMBER, 26));

		ret.add(Utils.buildCalendar(2017, Calendar.JANUARY, 2));
		ret.add(Utils.buildCalendar(2017, Calendar.JANUARY, 16));
		ret.add(Utils.buildCalendar(2017, Calendar.FEBRUARY, 20));
		ret.add(Utils.buildCalendar(2017, Calendar.APRIL, 14));
		ret.add(Utils.buildCalendar(2017, Calendar.MAY, 24));
		ret.add(Utils.buildCalendar(2017, Calendar.JULY, 4));
		ret.add(Utils.buildCalendar(2017, Calendar.SEPTEMBER, 4));
		ret.add(Utils.buildCalendar(2017, Calendar.NOVEMBER, 23));
		ret.add(Utils.buildCalendar(2017, Calendar.DECEMBER, 25));

		ret.add(Utils.buildCalendar(2018, Calendar.JANUARY, 1));
		ret.add(Utils.buildCalendar(2018, Calendar.JANUARY, 15));
		ret.add(Utils.buildCalendar(2018, Calendar.FEBRUARY, 19));
		ret.add(Utils.buildCalendar(2018, Calendar.MARCH, 30));
		ret.add(Utils.buildCalendar(2018, Calendar.MAY, 28));
		ret.add(Utils.buildCalendar(2018, Calendar.JULY, 4));
		ret.add(Utils.buildCalendar(2018, Calendar.SEPTEMBER, 3));
		ret.add(Utils.buildCalendar(2018, Calendar.NOVEMBER, 28));
		ret.add(Utils.buildCalendar(2018, Calendar.DECEMBER, 25));

		return ret;
	}

	public int mode;

	public Calendar day;

	public double mktcap;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SmartDumbDay(int mday, Calendar cal) {

		this.mode = mday;
		this.day = cal;
		this.mktcap = 0.0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final String s = String.format("%s %10s %15.2f", Utils.stringDate2(this.day), MODE[this.mode], this.mktcap);
		return s;
	}
}
