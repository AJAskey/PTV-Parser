
package net.ajaskey.market.tools.sipro;

import java.lang.reflect.Field;
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

	public Calendar	y8;
	public Calendar	y7;
	public Calendar	y6;
	public Calendar	y5;
	public Calendar	y4;
	public Calendar	y3;
	public Calendar	y2;
	public Calendar	y1;
	public Calendar	ttm;

	public DateSet() {

		ttm = Calendar.getInstance();
		Calendar tmp = Calendar.getInstance();
		for (int i = 1; i < 4; i++) {
			tmp.add(Calendar.MONTH, -1);
			if (tmp.get(Calendar.MONTH) == Calendar.DECEMBER) {

				int lday = tmp.getActualMaximum(Calendar.DAY_OF_MONTH);
				tmp.set(Calendar.DAY_OF_MONTH, lday);
				y1 = Utils.buildCalendar(tmp);
				break;
			}
		}

		tmp.add(Calendar.YEAR, -1);
		tmp.set(Calendar.MONTH, Calendar.DECEMBER);
		tmp.set(Calendar.DAY_OF_MONTH, 31);
		y2 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y3 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y4 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y5 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y6 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y7 = Utils.buildCalendar(tmp);

		tmp.add(Calendar.YEAR, -1);
		y8 = Utils.buildCalendar(tmp);
	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		DateSet ds = new DateSet();
		System.out.println(ds);

	}

	@Override
	public String toString() {

		String ret = "TTM : " + Utils.stringDate(ttm);
		ret += "\nY1  : " + Utils.stringDate(y1);
		ret += "\nY2  : " + Utils.stringDate(y2);
		ret += "\nY3  : " + Utils.stringDate(y3);
		ret += "\nY4  : " + Utils.stringDate(y4);
		ret += "\nY5  : " + Utils.stringDate(y5);
		ret += "\nY6  : " + Utils.stringDate(y6);
		ret += "\nY7  : " + Utils.stringDate(y7);
		ret += "\nY8  : " + Utils.stringDate(y8);
		return ret;
	}

}
