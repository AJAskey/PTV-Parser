
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.methods.RegressionMethods;
import net.ajaskey.market.ta.methods.RegressionOutput;

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
public class GenerateRegression {

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		ParseData.clearValidTickers();
		ParseData.setValidTicker("SPX");

		final TickerData spx = ParseData.parseOneFile("spx-1950-yahoo.csv");

		System.out.println(spx.DailyDataString(0));

		final Calendar cal = Calendar.getInstance();
		cal.set(1981, Calendar.APRIL, 11);
		final long days = Utils.getTimeSpan(cal, Utils.getBaseDate());

		final RegressionMethods regMeth = new RegressionMethods();
		regMeth.addData(spx.getCloseData(), spx.getDateData(), (days * 5) / 7);
		regMeth.regress();

		final double slope = regMeth.getSlope();
		System.out.println((slope * 180.0) / Math.PI);

		cal.set(2015, Calendar.MARCH, 15);
		final double x = regMeth.findX(cal);
		final double y = regMeth.predict(x);
		System.out.println(y);

		final double err = Math.sqrt(regMeth.getMeanSquareError());
		final double err2 = err * 2.0;
		final double err3 = err * 3.0;
		System.out.printf("%.2f  %.2f  %.2f %.2f %.2f %.2f %.2f %.2f%n", err, (y - err3), (y - err2), (y - err), y,
		    (y + err), (y + err2), (y + err3));

		final RegressionOutput out = regMeth.getOutput(cal);

		System.out.println(out.toString());

	}

}
