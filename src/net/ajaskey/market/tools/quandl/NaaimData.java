
package net.ajaskey.market.tools.quandl;

import java.lang.reflect.Field;
import java.util.Calendar;

import net.ajaskey.market.misc.DateTime;
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
public class NaaimData {

	/*
	 <column-name>Date</column-name>
	<column-name>Mean/Average</column-name>
	<column-name>Most Bearish Response</column-name>
	<column-name>Quart 1 (25% at/below)</column-name>
	<column-name>Quart 2 (median)</column-name>
	<column-name>Quart 3 (25% at/above)</column-name>
	<column-name>Most Bullish Response</column-name>
	<column-name>Standard Deviation</column-name>
	<column-name>NAAIM Number</column-name>
	<column-name>S&P 500</column-name>
	 */

	public DateTime	date;
	public double		mean;
	public double		mostBearish;
	public double		q1;
	public double		median;
	public double		q3;
	public double		mostBullish;
	public double		stdDev;
	public double		number;
	public double		sp500;

	public double bbDiff;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public NaaimData(final DateTime dt, final double mn, final double mbear, final double qq1, final double med, final double qq3,
	    final double mbull, final double s, final double n, final double sp) {

		this.date = dt;
		this.mean = mn;
		this.mostBearish = mbear;
		if (mbear == 0.0) {
			this.mostBearish = 0.01;
		}
		this.q1 = qq1;
		this.median = med;
		this.q3 = qq3;
		this.mostBullish = mbull;
		if (this.mostBullish == 0.0) {
			this.mostBullish = 0.01;
		}
		this.bbDiff = mbull + mbear;
		if (this.bbDiff == 0.0) {
			this.bbDiff = 0.01;
		}

		this.stdDev = s;
		this.number = n;
		this.sp500 = sp;

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
				final String ft = field.getType().toString();
				if (ft.equals("class java.util.Calendar")) {
					result.append(Utils.stringDate((Calendar) field.get(this)));
				}
				else {
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
