
package net.ajaskey.market.tools.sipro;

import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

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
public class DateSet {

	public class Quarter {

		public Calendar	q4;
		public Calendar	q3;
		public Calendar	q2;
		public Calendar	q1;

		/**
		 * This method serves as a constructor for the class.
		 *
		 */
		public Quarter(Calendar base) {
			this.q4 = Utils.buildCalendar(base);

			base.add(Calendar.MONTH, -3);
			int lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			base.set(Calendar.DAY_OF_MONTH, lday);
			this.q3 = Utils.buildCalendar(base);

			base.add(Calendar.MONTH, -3);
			lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			base.set(Calendar.DAY_OF_MONTH, lday);
			this.q2 = Utils.buildCalendar(base);

			base.add(Calendar.MONTH, -3);
			lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			base.set(Calendar.DAY_OF_MONTH, lday);
			this.q1 = Utils.buildCalendar(base);
		}

		@Override
		public String toString() {

			String ret = "  Q1 : " + Utils.stringDate(this.q1);
			ret += "\n  Q2 : " + Utils.stringDate(this.q2);
			ret += "\n  Q3 : " + Utils.stringDate(this.q3);
			ret += "\n  Q4 : " + Utils.stringDate(this.q4);

			return ret;
		}
	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final DateSet ds = new DateSet();
		System.out.println(ds);

	}

	public Quarter	y7;
	public Quarter	y6;
	public Quarter	y5;
	public Quarter	y4;
	public Quarter	y3;
	public Quarter	y2;
	public Quarter	y1;

	public Calendar ttm;

	public DateSet() {

		this.ttm = Calendar.getInstance();
		for (int i = 0; i < 7; i++) {
			this.ttm.add(Calendar.DATE, -1);
			if (this.ttm.get(Calendar.DATE) == Calendar.FRIDAY) {
				break;
			}
		}

		final Calendar tmp = Calendar.getInstance();
		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y1 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y2 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y3 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y4 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y5 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y6 = new Quarter(tmp);

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DATE, 31);
		this.y7 = new Quarter(tmp);
	}

	@Override
	public String toString() {

		String ret = "";
		ret += "Y7\n" + this.y7;
		ret += "\nY6\n" + this.y6;
		ret += "\nY5\n" + this.y5;
		ret += "\nY4\n" + this.y4;
		ret += "\nY3\n" + this.y3;
		ret += "\nY2\n" + this.y2;
		ret += "\nY1\n" + this.y1;
		ret += "\nTTM  : " + Utils.stringDate(this.ttm);
		return ret;
	}

}
