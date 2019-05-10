
package net.ajaskey.market.tools.fred.processing;

import java.io.IOException;
import java.util.List;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.optuma.PriceData;
import net.ajaskey.market.tools.optuma.OptumaPriceData;

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
public class SpxData {

	private static List<PriceData> spxPrices = null;

	/**
	 * net.ajaskey.market.tools.fred.processing.getSpxClose
	 *
	 * @param date
	 * @return
	 */
	public static double getSpxClose(final DateTime date) {

		//System.out.printf("%s\t%s%n", Utils.sdf.format(date.getTime()), Utils.sdf.format(spxPrices.get(0).date.getTime()));

		if (date.isLessThan(spxPrices.get(0).date)) {
			return 0.0;
		}

		for (final PriceData pd : spxPrices) {

			//System.out.printf("%s\t%s%n", Utils.sdf.format(date.getTime()), Utils.sdf.format(pd.date.getTime()));

			if (pd.date.isGreaterThanOrEqual(date)) {
				return pd.close;
			}

		}
		return 0;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SpxData() {

		try {
			spxPrices = OptumaPriceData.getPriceData("C:\\Users\\Andy\\Documents\\PriceData\\World Indices\\S\\SPX.csv");
		} catch (final IOException e) {
			spxPrices.clear();
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		// TODO Auto-generated method stub
		return super.toString();
	}

}
