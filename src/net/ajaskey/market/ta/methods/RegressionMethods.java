
package net.ajaskey.market.ta.methods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import net.ajaskey.market.misc.Utils;

/**
 * This class provide linear regression data for a set of time/price values. The
 * class is extended from
 * org.apache.commons.math3.stat.regression.SimpleRegression and all of the
 * methods of the parent class are available for use. Methods provide by this
 * class are for convenience.
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class RegressionMethods extends SimpleRegression {

	/**
	 *
	 * This class contains a data point that has been added to the regression data
	 * set.
	 *
	 *
	 */
	public class DataPoint {

		public Calendar	daDate;
		public long			daDays;
		public double		daPrice;

		/**
		 * This method serves as a constructor for the class.
		 *
		 */
		public DataPoint(final Calendar cal, final double price) {

			this.daDate = cal;
			this.daDays = Utils.getTimeSpan(cal, RegressionMethods.this.baseCal);
			this.daPrice = price;
		}
	}

	/**
	 *
	 * This class is used to sort a list of DataPoint objects.
	 *
	 *
	 */
	public class SortPoints implements Comparator<DataPoint> {

		@Override
		public int compare(final DataPoint d1, final DataPoint d2) {

			int retval = 0;
			if (d1.daDays > d2.daDays) {
				retval = 1;
			}
			else if (d1.daDays > d2.daDays) {
				retval = -1;
			}
			return retval;
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	List<DataPoint>		points	= new ArrayList<>();
	private Calendar	baseCal	= null;
	private int				dataCount;

	private Calendar	minDate	= null;
	private Calendar	maxDate	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public RegressionMethods() {

		this.baseCal = Calendar.getInstance();
		this.baseCal.set(1900, Calendar.JANUARY, 1, 12, 0, 1);
		this.dataCount = 0;
		this.minDate = Calendar.getInstance();
		this.maxDate = this.baseCal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.addData
	 *
	 * @param price
	 * @param dates
	 * @param days
	 */
	public void addData(final double[] price, final Calendar[] dates, final long days) {

		final long knt = Math.min(days, price.length);
		for (int i = 0; i < knt; i++) {
			final long dayNumber = Utils.getTimeSpan(dates[i], this.baseCal);
			this.addData(dayNumber, price[i]);

			if (dates[i].before(this.minDate)) {
				this.minDate = dates[i];
			}

			if (dates[i].after(this.maxDate)) {
				this.maxDate = dates[i];
			}

			this.points.add(new DataPoint(dates[i], price[i]));

			this.dataCount++;
		}
		Collections.sort(this.points, new SortPoints());
		System.out.println(Utils.calendarToLongString(this.minDate));
		System.out.println(Utils.calendarToLongString(this.maxDate));
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.findX
	 *
	 * @param cal
	 * @return
	 */
	public double findX(final Calendar cal) {

		double ret = 0;
		try {
			ret = Utils.getTimeSpan(cal, this.baseCal);
		} catch (final Exception e) {
			ret = 0;
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.getOutput
	 *
	 * @param cal
	 * @return
	 */
	public RegressionOutput getOutput(final Calendar cal) {

		try {
			if (this.dataCount > 0) {
				final RegressionOutput output = new RegressionOutput(this, Utils.getTimeSpan(cal, this.baseCal));

				return output;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

/**
 * double sumDelta = 0; int knt=0; for (int i = 0; i < spx.getDataCount(); i++)
 * { dd = TickerData.getDataOfDate(spx, spx.getDate(i)); if (dd != null) { yy =
 * dd.getClose();
 *
 * x = rm.findX(spx.getDate(i)); y = rm.sreg.predict(x);
 *
 * delta = yy - y; sumDelta += delta/err; knt++; } }
 *
 * x = rm.findX(cal); y = rm.sreg.predict(x); double avgDelta =
 * sumDelta/(double)knt; double expectedPrice = y * (1.0+avgDelta);
 * System.out.printf("%.3f %.2f",avgDelta, expectedPrice);
 *
 */
