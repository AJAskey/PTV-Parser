
package net.ajaskey.market.ta.methods;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import net.ajaskey.market.ta.Utils;

/**
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
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
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class LinearRegressionMethods extends SimpleRegression {

	/**
	 *
	 */
	private static final long						serialVersionUID	= 1L;

	private final Calendar							baseDate					= Calendar.getInstance();

	private final DescriptiveStatistics	stats							= new DescriptiveStatistics();

	private double											currentPrice;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public LinearRegressionMethods(Calendar[] dates, double[] prices) {
		super();
		this.baseDate.set(Calendar.YEAR, 2000);
		this.baseDate.set(Calendar.DAY_OF_YEAR, 1);
		this.baseDate.set(Calendar.HOUR, 0);
		this.baseDate.set(Calendar.MINUTE, 0);
		this.baseDate.set(Calendar.SECOND, 1);
		this.baseDate.set(Calendar.MILLISECOND, 0);
		int knt = 0;
		for (final Calendar cal : dates) {
			final long days = this.getTimeSpan(cal);
			System.out.println(days + "\t" + prices[knt]);
			this.addData(days, prices[knt]);
			if (knt < 66)
				stats.addValue(prices[knt]);
			knt++;
		}
		currentPrice = prices[0];
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	@SuppressWarnings("unused")
	private LinearRegressionMethods() {
		super();
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.getTimeSpan
	 *
	 * @param cal
	 * @return
	 */
	public long getTimeSpan(Calendar cal) {
		return Utils.getTimeSpan(cal, this.baseDate);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.getTimeSpan
	 *
	 * @param recent
	 * @param lessRecent
	 * @return
	 */
	public long getTimeSpan(Calendar recent, Calendar lessRecent) {
		return Utils.getTimeSpan(recent, lessRecent);
	}

	public double linreg() {

		System.out.println((this.getSlope() * 360.0) / 3.1415);
		System.out.println((this.getSlopeStdErr() * 360.0) / 3.1415);
		System.out.println(this.getR() + "\t" + this.getRSquare());
		System.out.println(this.predict(5773) + "\t" + currentPrice);
		System.out.println();
		System.out.println(stats.toString());

		return 0;
	}

}
