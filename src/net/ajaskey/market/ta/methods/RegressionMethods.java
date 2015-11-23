
package net.ajaskey.market.ta.methods;

import java.util.Calendar;

import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import net.ajaskey.market.ta.Utils;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
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
 *         </p>
 *
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class RegressionMethods {

	/**
	 *
	 */
	@SuppressWarnings("unused")
	private static final long	serialVersionUID	= -3141249013668879111L;
	private Calendar					baseCal						= null;

	public SimpleRegression		sreg							= new SimpleRegression();
	public RegressionResults	results						= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public RegressionMethods() {
		this.baseCal = Calendar.getInstance();
		this.baseCal.set(1900, Calendar.JANUARY, 1, 12, 0, 1);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.addData
	 *
	 * @param val
	 * @param dates
	 * @param days 
	 */
	public void addData(double[] val, Calendar[] dates, int days) {
		
		final int knt = Math.min(days, val.length);
		for (int i = 0; i < knt; i++) {
			final long dayNumber = Utils.getTimeSpan(dates[i], this.baseCal);
			this.sreg.addData(dayNumber, val[i]);
		}
	}

	public double findX(Calendar cal) {
		double ret = 0;
		try {
			ret = Utils.getTimeSpan(cal, this.baseCal);
		} catch (final Exception e) {
			ret = 0;
		}
		return ret;
	}

	public void regress() {
		this.results = this.sreg.regress();
	}

}
