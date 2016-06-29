
package net.ajaskey.market.ta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * This class provides methods to validate a list of DailyData.
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
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
 *         </p>
 * 
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class ValidateData {

	private static List<Calendar>	holidays	= new ArrayList<>();

	// private static Calendar aCal = Calendar.getInstance();

	private static boolean				init			= false;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public static void init() {
		final Calendar labor_15 = Calendar.getInstance();
		final Calendar july4_15 = Calendar.getInstance();
		final Calendar memorial_15 = Calendar.getInstance();
		final Calendar gfri_15 = Calendar.getInstance();
		final Calendar pres_15 = Calendar.getInstance();
		final Calendar mlk_15 = Calendar.getInstance();
		final Calendar xmas_14 = Calendar.getInstance();
		final Calendar thx_14 = Calendar.getInstance();
		final Calendar labor_14 = Calendar.getInstance();
		final Calendar july4_14 = Calendar.getInstance();
		final Calendar memorial_14 = Calendar.getInstance();
		final Calendar gfri_14 = Calendar.getInstance();
		final Calendar pres_14 = Calendar.getInstance();
		final Calendar mlk_14 = Calendar.getInstance();
		final Calendar xmas_13 = Calendar.getInstance();
		final Calendar thx_13 = Calendar.getInstance();
		final Calendar labor_13 = Calendar.getInstance();
		final Calendar july4_13 = Calendar.getInstance();
		final Calendar memorial_13 = Calendar.getInstance();
		final Calendar gfri_13 = Calendar.getInstance();
		final Calendar pres_13 = Calendar.getInstance();
		final Calendar mlk_13 = Calendar.getInstance();
		final Calendar xmas_12 = Calendar.getInstance();
		final Calendar thx_12 = Calendar.getInstance();
		final Calendar unk_12 = Calendar.getInstance();
		final Calendar labor_12 = Calendar.getInstance();
		final Calendar july4_12 = Calendar.getInstance();
		final Calendar memorial_12 = Calendar.getInstance();
		final Calendar gfri_12 = Calendar.getInstance();
		final Calendar pres_12 = Calendar.getInstance();
		final Calendar mlk_12 = Calendar.getInstance();

		labor_15.set(2015, Calendar.SEPTEMBER, 4);
		holidays.add(labor_15);
		july4_15.set(2015, Calendar.JULY, 2);
		holidays.add(july4_15);
		memorial_15.set(2015, Calendar.MAY, 22);
		holidays.add(memorial_15);
		gfri_15.set(2015, Calendar.APRIL, 2);
		holidays.add(gfri_15);
		pres_15.set(2015, Calendar.FEBRUARY, 13);
		holidays.add(pres_15);
		mlk_15.set(2015, Calendar.JANUARY, 16);
		holidays.add(mlk_15);

		xmas_14.set(2014, Calendar.DECEMBER, 24);
		holidays.add(xmas_14);
		thx_14.set(2014, Calendar.NOVEMBER, 26);
		holidays.add(thx_14);
		labor_14.set(2014, Calendar.AUGUST, 29);
		holidays.add(labor_14);
		july4_14.set(2014, Calendar.JULY, 3);
		holidays.add(july4_14);
		memorial_14.set(2014, Calendar.MAY, 23);
		holidays.add(memorial_14);
		gfri_14.set(2014, Calendar.APRIL, 17);
		holidays.add(gfri_14);
		pres_14.set(2014, Calendar.FEBRUARY, 14);
		holidays.add(pres_14);
		mlk_14.set(2014, Calendar.JANUARY, 17);
		holidays.add(mlk_14);

		xmas_13.set(2013, Calendar.DECEMBER, 24);
		holidays.add(xmas_13);
		thx_13.set(2013, Calendar.NOVEMBER, 27);
		holidays.add(thx_13);
		labor_13.set(2013, Calendar.AUGUST, 30);
		holidays.add(labor_13);
		july4_13.set(2013, Calendar.JULY, 3);
		holidays.add(july4_13);
		memorial_13.set(2013, Calendar.MAY, 24);
		holidays.add(memorial_13);
		gfri_13.set(2013, Calendar.MARCH, 28);
		holidays.add(gfri_13);
		pres_13.set(2013, Calendar.FEBRUARY, 15);
		holidays.add(pres_13);
		mlk_13.set(2013, Calendar.JANUARY, 18);
		holidays.add(mlk_13);

		xmas_12.set(2012, Calendar.DECEMBER, 24);
		holidays.add(xmas_12);
		thx_12.set(2012, Calendar.NOVEMBER, 21);
		holidays.add(thx_12);
		unk_12.set(2012, Calendar.OCTOBER, 26);
		holidays.add(unk_12);
		labor_12.set(2012, Calendar.AUGUST, 31);
		holidays.add(labor_12);
		july4_12.set(2012, Calendar.JULY, 3);
		holidays.add(july4_12);
		memorial_12.set(2012, Calendar.MAY, 25);
		holidays.add(memorial_12);
		gfri_12.set(2012, Calendar.APRIL, 5);
		holidays.add(gfri_12);
		pres_12.set(2012, Calendar.FEBRUARY, 17);
		holidays.add(pres_12);
		mlk_12.set(2012, Calendar.JANUARY, 13);
		holidays.add(mlk_12);

		init = true;
	}

	public static boolean isHoliday(Calendar cal) {

		if (!init) {
			ValidateData.init();
		}

		final int yr = cal.get(Calendar.YEAR);

		final int mon = cal.get(Calendar.MONTH);
		final int day = cal.get(Calendar.DAY_OF_MONTH);

		for (final Calendar c : holidays) {
			final int yrH = c.get(Calendar.YEAR);
			final int monH = c.get(Calendar.MONTH);
			final int dayH = c.get(Calendar.DAY_OF_MONTH);
			if ((yr == yrH) && (mon == monH) && (day == dayH)) {
				return true;
			}
		}
		return false;

	}

	public static boolean validate(TickerData td) {

		td.fillDataArrays(0, false);

		Calendar cal = td.getDate(0);
		int lastDoY = cal.get(Calendar.DAY_OF_YEAR);

		for (int i = 1; i < td.getDaysOfData(); i++) {
			cal = td.getDate(i);
			final int dow = cal.get(Calendar.DAY_OF_WEEK);
			if ((dow < Calendar.MONDAY) || (dow > Calendar.FRIDAY)) {
				System.out.println(td.getTicker() + " - Invalid Day of Week : " + td.getDailyDataString(i));
				return false;
			}
			final int yr = cal.get(Calendar.YEAR);
			final int doy = cal.get(Calendar.DAY_OF_YEAR);
			if (yr > 2011) {
				final boolean hol = ValidateData.isHoliday(td.getDate(i));
				if (hol) {
					// System.out.println("Ignored holiday : " +
					// td.getDailyDataString(i));
				} else {
					if (dow == Calendar.FRIDAY) {
						if ((doy + 3) != lastDoY) {
							// hol = ValidateData.isHoliday(td.getDate(i));
							System.out.println(td.getTicker() + " - Day of data skipped : " + td.getDailyDataString(i));
							// return false;
						}
					} else {
						if ((doy < 365) && ((doy + 1) != lastDoY)) {
							System.out.println(td.getTicker() + " - Day of data skipped : " + td.getDailyDataString(i));
							// return false;
						}
					}
				}
			}
			lastDoY = doy;
		}
		// System.out.println(dow + "\t" + doy);

		return true;
	}

}
