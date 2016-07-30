
package net.ajaskey.market.tools;

import java.io.IOException;
import java.util.List;

import net.ajaskey.market.tools.helpers.SpxEarningsData;

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
public class SpxEarnings {
	
	final private static double SpxPrice = 2162.54;

	/**
	 * net.ajaskey.market.tools.getEarnings
	 *
	 * @param d
	 *
	 * @return
	 */
	private static double getEarnings(SpxEarningsData d) {
		if (Math.abs(d.eps) > 0.0) {
			return (d.eps + d.div);
		} else if ((Math.abs(d.netIncAfterTax) > 0.0) && (Math.abs(d.shares) > 0.0)) {
			return ((d.netIncAfterTax / d.shares) + d.div);
		}

		return (d.eps1y + d.div);
	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		final List<SpxEarningsData> data = SpxEarningsData.readData("SP500-Earnings.txt");

		double totCap = 0;
		for (final SpxEarningsData d : data) {
			totCap += d.mktcap;
		}
		System.out.printf("%15.3f%n", totCap);

		final double fudge = 15.0;

		double totEarn = 0;
		for (final SpxEarningsData d : data) {
			final double wt = d.mktcap / totCap;
			final double perc = wt * 100.0;
			final double e = SpxEarnings.getEarnings(d);
			final double earn = e * wt * fudge;
			totEarn += earn;
			System.out.printf("%s\t%9.2f%%\t%9.5f\t%9.2f\t%9.2f\t%9.5f %n", d.ticker, perc, wt, d.div, e, earn);
		}
		System.out.printf("Earnings : %6.2f%n", totEarn);
		double pe = SpxPrice / totEarn;
		System.out.printf("PE       : %6.2f%n", pe);

	}

}
