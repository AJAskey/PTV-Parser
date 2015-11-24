
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Calendar;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.methods.RegressionMethods;

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

		final RegressionMethods rm = new RegressionMethods();
		rm.addData(spx.getCloseData(), spx.getDateData(), 261 * 25);
		rm.regress();

		final double slope = rm.sreg.getSlope();
		System.out.println((slope * 180.0) / Math.PI);

		final Calendar cal = Calendar.getInstance();
		//cal.set(2018, Calendar.MARCH, 15);
		final double x = rm.findX(cal);
		final double y = rm.sreg.predict(x);
		System.out.println(y);

		final double err = Math.sqrt(rm.sreg.getMeanSquareError());
		final double err2 = err * 2.0;
		final double err3 = err * 3.0;
		System.out.printf("%.2f  %.2f  %.2f %.2f %.2f %.2f %.2f %.2f%n", err, (y - err3), (y - err2), (y - err), y,
		    (y + err), (y + err2), (y + err3));

	}

}
