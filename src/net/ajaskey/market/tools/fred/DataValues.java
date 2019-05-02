
package net.ajaskey.market.tools.fred;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.ajaskey.market.misc.DateTime;

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
public class DataValues {

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private DateTime	date;
	private double		value;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param cal
	 * @param val
	 */
	public DataValues(final DateTime dt, final double val) {

		this.date = new DateTime(dt);
		this.value = val;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataValues(final String date, final String val) {
		
		this.date = new DateTime();

		this.setDate(date);
		this.setValue(val);
	}

	/**
	 * @return the date
	 */
	public DateTime getDate() {

		return this.date;
	}

	/**
	 * @return the value
	 */
	public double getValue() {

		return this.value;
	}

	/**
	 * @param sdf.
	 *          the date to set
	 */
	public void setDate(final String dateStr) {

		try {
			final Date d = sdf.parse(dateStr);
			this.date.set(d);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param value
	 *          the value to set
	 */
	public void setValue(final String val) {

		try {
			this.value = Double.parseDouble(val);
		} catch (final Exception e) {
			this.value = 0.0;
		}
	}

	@Override
	public String toString() {

		return (String.format("%s\t%f", this.date, this.value));
	}
}
