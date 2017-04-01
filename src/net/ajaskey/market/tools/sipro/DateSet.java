
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

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final DateSet ds = new DateSet();
		System.out.println(ds);

	}

	public Calendar	y7;
	public Calendar	y6;
	public Calendar	y5;
	public Calendar	y4;
	public Calendar	y3;
	public Calendar	y2;
	public Calendar	y1;
	public Calendar	ttm;

	public DateSet() {

		this.ttm = Calendar.getInstance();
		for (int i = 0; i < 7; i++) {
			ttm.add(Calendar.DATE, -1);
			if (ttm.get(Calendar.DATE) == Calendar.FRIDAY) {
				break;
			}
		}

		final Calendar tmp = Calendar.getInstance();
		for (int i = 1; i < 4; i++) {
			tmp.add(Calendar.MONTH, -1);
			if (tmp.get(Calendar.MONTH) == Calendar.DECEMBER) {

				final int lday = tmp.getActualMaximum(Calendar.DAY_OF_MONTH);
				tmp.set(Calendar.DAY_OF_MONTH, lday);
				this.y1 = Utils.buildCalendar(tmp);
				break;
			}
		}

		tmp.add(Calendar.YEAR, -1);
		this.y2 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		this.y3 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		this.y4 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		this.y5 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		this.y6 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		this.y7 = Utils.buildCalendar(tmp);
	}

	@Override
	public String toString() {

		String ret = "TTM : " + Utils.stringDate(this.ttm);
		ret += "\nY1  : " + Utils.stringDate(this.y1);
		ret += "\nY2  : " + Utils.stringDate(this.y2);
		ret += "\nY3  : " + Utils.stringDate(this.y3);
		ret += "\nY4  : " + Utils.stringDate(this.y4);
		ret += "\nY5  : " + Utils.stringDate(this.y5);
		ret += "\nY6  : " + Utils.stringDate(this.y6);
		ret += "\nY7  : " + Utils.stringDate(this.y7);
		return ret;
	}

}
