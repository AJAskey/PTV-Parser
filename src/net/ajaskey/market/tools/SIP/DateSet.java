
package net.ajaskey.market.tools.SIP;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.input.LongTermOHLCV;

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

	public class QData {

		public Calendar	date;
		public double		value;

		/**
		 * This method serves as a constructor for the class.
		 *
		 */
		public QData() {

			this.date = Calendar.getInstance();
			this.value = 0.0;
		}
	}

	public class Quarters {

		public QData	q4	= new QData();
		public QData	q3	= new QData();
		public QData	q2	= new QData();
		public QData	q1	= new QData();
		public QData	ttm	= new QData();

		/**
		 * This method serves as a constructor for the class.
		 *
		 */
		public Quarters(final Calendar base, final List<LongTermOHLCV> prices) {

			this.q4.date = Utils.buildCalendar(base);
			if (prices != null) {
				this.q4.value = LongTermOHLCV.queryDate(base, prices).close;
			}

			base.add(Calendar.MONTH, -3);
			//int lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			//base.set(Calendar.DAY_OF_MONTH, lday);
			this.q3.date = Utils.buildCalendar(base);
			if (prices != null) {
				this.q3.value = LongTermOHLCV.queryDate(base, prices).close;
			}

			base.add(Calendar.MONTH, -3);
			//lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			//base.set(Calendar.DAY_OF_MONTH, lday);
			this.q2.date = Utils.buildCalendar(base);
			if (prices != null) {
				this.q2.value = LongTermOHLCV.queryDate(base, prices).close;
			}

			base.add(Calendar.MONTH, -3);
			//lday = base.getActualMaximum(Calendar.DAY_OF_MONTH);
			//base.set(Calendar.DAY_OF_MONTH, lday);
			this.q1.date = Utils.buildCalendar(base);

			if (prices != null) {
				this.q1.value = LongTermOHLCV.queryDate(base, prices).close;
			}
		}

		@Override
		public String toString() {

			String ret = "  Q1 : " + Utils.stringDate(this.q1.date) + "\t" + this.q1.value;
			ret += "\n  Q2 : " + Utils.stringDate(this.q2.date) + "\t" + this.q2.value;
			ret += "\n  Q3 : " + Utils.stringDate(this.q3.date) + "\t" + this.q3.value;
			ret += "\n  Q4 : " + Utils.stringDate(this.q4.date) + "\t" + this.q4.value;

			return ret;
		}
	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException, ParseException {

		final List<LongTermOHLCV> prices = LongTermOHLCV.getData("SP500");
		final DateSet ds = new DateSet(prices);
		System.out.println(ds);

	}

	public Quarters	y7;
	public Quarters	y6;
	public Quarters	y5;
	public Quarters	y4;
	public Quarters	y3;
	public Quarters	y2;
	public Quarters	y1;
	public Quarters	y0;
	public QData		ttm	= new QData();

	public double latestPrice;

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param prices
	 */
	public DateSet(final List<LongTermOHLCV> prices) {

		this.latestPrice = LongTermOHLCV.getLatestPrice(prices);

		this.ttm.date = Calendar.getInstance();
		final Calendar tmp = Calendar.getInstance();

		this.y0 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y1 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y2 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y3 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y4 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y5 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y6 = new Quarters(tmp, prices);

		tmp.add(Calendar.MONTH, -3);
		this.y7 = new Quarters(tmp, prices);
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
		ret += "\nY0\n" + this.y0;
		ret += "\nTTM  : " + Utils.stringDate(this.ttm.date) + "\t" + this.latestPrice;
		return ret;
	}

}
