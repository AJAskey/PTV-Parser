
package net.ajaskey.market.ta.methods;

import org.apache.commons.math3.stat.regression.RegressionResults;

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
public class RegressionOutput {

	public RegressionResults	results					= null;
	public long								count;
	public double							predictedPrice	= 0;
	public double							meanErr					= 0;
	public double							slope						= 0;
	public double							r2							= 0;

	/**
	 * This method serves as a constructor for the class.
	 * 
	 * @param regressionMethods
	 *
	 * @param parameters
	 * @param varcov
	 * @param isSymmetricCompressed
	 * @param nobs
	 * @param rank
	 * @param sumy
	 * @param sumysq
	 * @param sse
	 * @param containsConstant
	 * @param copyData
	 */
	public RegressionOutput(RegressionMethods reg, long days) {
		results = reg.regress();

		count = results.getN();
		predictedPrice = reg.predict(days);
		meanErr = Math.sqrt(results.getMeanSquareError());
		slope = reg.getSlope() * 180.0 / Math.PI;
		r2 = results.getRSquared();
		
	}

	@Override
	public String toString() {
		String str = null;
		str = String.format("Values:%d Predicted:%.2f MeanErr:%.2f Slope:%.2f RSquared:%.2f%n", count, predictedPrice,
		    meanErr, slope, r2);

		return str;
	}

}
