
package net.ajaskey.market.tools.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class PEAnalysisData {

	final private static SimpleDateFormat	sdf	= new SimpleDateFormat("d-MMM-yyyy");
	public Calendar												date;

	public double price;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public PEAnalysisData() {

		this.date = Calendar.getInstance();
		this.price = 0;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param trim
	 * @param trim2
	 * @throws ParseException
	 */
	public PEAnalysisData(final String sDate, final String sPrice) throws ParseException {

		try {
			this.date = Calendar.getInstance();
			this.date.setTime(sdf.parse(sDate));
			this.price = Double.parseDouble(sPrice);
			// System.out.println(Utils.getString(date) + " " + price);
		} catch (final Exception e) {
			this.price = -1.0;
		}
	}

}
