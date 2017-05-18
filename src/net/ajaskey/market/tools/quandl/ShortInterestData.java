
package net.ajaskey.market.tools.quandl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.ajaskey.market.misc.Utils;

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
public class ShortInterestData {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String		ticker;
	public Calendar	date;
	public double		si;
	public double		avgVol;
	public double		dtc;
	public double		modDtc;

	public Calendar latest;
	public int knt;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ShortInterestData(Calendar cal, double s, double v, double d) {
		date = Utils.buildCalendar(cal);
		si = s;
		avgVol = v;
		dtc = d;
		modDtc = si / (avgVol / 3.0);
		ticker = "";
		knt = 1;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param trim
	 */
	public ShortInterestData(String line) {
		knt = 1;
		if (line == null) {
			this.date = null;
		} else {
			try {
				String fld[] = line.trim().split("[\\s+,]");
				ticker = fld[0].trim();
				date = Calendar.getInstance();
				date.setTime(sdf.parse(fld[1].trim()));
				long tmp = Long.parseLong(fld[2].trim());
				si = (double) tmp;
				dtc = Double.parseDouble(fld[3].trim());
				modDtc = Double.parseDouble(fld[4].trim());
				tmp = Long.parseLong(fld[5].trim());
				avgVol = (double) tmp;
			} catch (Exception e) {
				this.date = null;
			}
		}
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ShortInterestData() {
		ticker = "";
		knt = 0;
		date = Calendar.getInstance();
		si = 0;
		dtc = 0;
		modDtc = 0;
		avgVol = 0;
	}

	@Override
	public String toString() {

		final StringBuilder result = new StringBuilder();
		final String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		final Field[] fields = this.getClass().getDeclaredFields();

		for (final Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");

				//System.out.println(field.getType());

				String ft = field.getType().toString();
				if (ft.equals("class java.util.Calendar")) {
					result.append(Utils.stringDate((Calendar) field.get(this)));
				} else {
					result.append(field.get(this));
				}

			} catch (final IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

}
