
package net.ajaskey.market.misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class DateTime {

	public static final int	DATE	= Calendar.DATE;
	public static final int	MONTH	= Calendar.MONTH;
	public static final int	YEAR	= Calendar.YEAR;

	public static final int	JANUARY		= Calendar.JANUARY;
	public static final int	FEBRUARY	= Calendar.FEBRUARY;
	public static final int	MARCH			= Calendar.MARCH;
	public static final int	APRIL			= Calendar.APRIL;
	public static final int	MAY				= Calendar.MAY;
	public static final int	JUNE			= Calendar.JUNE;
	public static final int	JULY			= Calendar.JULY;
	public static final int	AUGUST		= Calendar.AUGUST;
	public static final int	SEPTEMBER	= Calendar.SEPTEMBER;
	public static final int	OCTOBER		= Calendar.OCTOBER;
	public static final int	NOVEMBER	= Calendar.NOVEMBER;
	public static final int	DECEMBER	= Calendar.DECEMBER;

	/**
	 *
	 * net.ajaskey.market.misc.main
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		final DateTime dt = new DateTime();
		System.out.println(dt);
		final String s = dt.format("yyyy-MM-dd");
		System.out.println(s);
		dt.setSdf(Utils.sdfFull);
		System.out.println(dt);

	}

	private Calendar cal = null;

	private SimpleDateFormat sdf = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DateTime() {

		this.cal = Calendar.getInstance();
	}

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param c
	 */
	public DateTime(final Calendar c) {

		final Calendar cc = Calendar.getInstance();
		cc.setTime(c.getTime());
		this.cal = cc;
	}

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param d
	 */
	public DateTime(final Date d) {

		this.cal = Calendar.getInstance();
		this.cal.setTime(d);
	}

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param year
	 * @param month
	 * @param day
	 */
	public DateTime(final int year, final int month, final int day) {

		this.cal = Calendar.getInstance();
		this.cal.set(year, month, day);
	}

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param ms
	 */
	public DateTime(final long ms) {

		this.cal = Calendar.getInstance();
		this.cal.setTimeInMillis(ms);
	}

	/**
	 *
	 * net.ajaskey.market.misc.add
	 *
	 * @param unit
	 * @param knt
	 */
	public void add(final int unit, final int knt) {

		this.cal.add(unit, knt);
	}

	/**
	 *
	 * net.ajaskey.market.misc.copy
	 *
	 * @param dt
	 * @return
	 */
	public DateTime copy(final DateTime dt) {

		final DateTime d = new DateTime(dt.cal.getTime());
		return d;
	}

	/**
	 *
	 * net.ajaskey.market.misc.format
	 *
	 * @return
	 */
	public String format() {

		String ret = "";
		try {
			ret = this.sdf.format(this.cal.getTime());
		} catch (final Exception e) {
			ret = "BAD-DATE-FORMAT";
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.misc.format
	 *
	 * @param fmt
	 * @return
	 */
	public String format(final String fmt) {

		String ret = "";
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			ret = sdf.format(this.cal.getTime());
		} catch (final Exception e) {
			ret = "BAD-DATE-FORMAT";
		}
		return ret;
	}

	/**
	 * @return the cal
	 */
	public Calendar getCal() {

		return this.cal;
	}

	/**
	 *
	 * net.ajaskey.market.misc.getSdf
	 *
	 * @return
	 */
	public SimpleDateFormat getSdf() {

		return this.sdf;
	}

	/**
	 *
	 * net.ajaskey.market.misc.isEqual
	 *
	 * @param dt
	 * @return
	 */
	public boolean isEqual(final DateTime dt) {

		try {
			return Utils.sameDate(dt.cal, this.cal);
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.isGreaterThan
	 *
	 * @param dt
	 * @return
	 */
	public boolean isGreaterThan(final DateTime dt) {

		try {
			return (dt.cal.after(this.cal));
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.isGreaterThanOrEqual
	 *
	 * @param dt
	 * @return
	 */
	public boolean isGreaterThanOrEqual(final DateTime dt) {

		try {
			return (this.isGreaterThan(dt) || this.isEqual(dt));
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.isLessThan
	 *
	 * @param dt
	 * @return
	 */
	public boolean isLessThan(final DateTime dt) {

		try {
			return (dt.cal.before(this.cal));
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.isLessThanOrEqual
	 *
	 * @param dt
	 * @return
	 */
	public boolean isLessThanOrEqual(final DateTime dt) {

		try {
			return (this.isLessThan(dt) || this.isEqual(dt));
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.parse
	 *
	 * @param src
	 * @return
	 */
	public DateTime parse(final String src) {

		DateTime ret = null;
		try {
			final Date d = this.sdf.parse(src);
			ret = new DateTime(d);
		} catch (final Exception e) {
			ret = null;
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.misc.parse
	 *
	 * @param src
	 * @param fmt
	 * @return
	 */
	public DateTime parse(final String src, final String fmt) {

		DateTime ret = null;
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			final Date d = sdf.parse(src);
			ret = new DateTime(d);
		} catch (final Exception e) {
			ret = null;
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.misc.set
	 *
	 * @param c
	 */
	public void set(final Calendar c) {

		this.cal.setTime(c.getTime());
	}

	public void set(final Date d) {

		this.cal.setTime(d);
	}

	/**
	 *
	 * net.ajaskey.market.misc.set
	 *
	 * @param year
	 * @param month
	 * @param day
	 */
	public void set(final int year, final int month, final int day) {

		this.cal.set(year, month, day);
	}

	public void setSdf(final SimpleDateFormat simpledateformat) {

		this.sdf = simpledateformat;
	}

	/**
	 *
	 * net.ajaskey.market.misc.toFullString
	 *
	 * @return
	 */
	public String toFullString() {

		return Utils.sdfFull.format(this.cal.getTime());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (this.sdf == null) {
			this.setSdf(Utils.sdf);
		}
		return this.sdf.format(this.cal.getTime());
	}

}
