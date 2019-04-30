
package net.ajaskey.market.tools.sipro;

import java.util.ArrayList;
import java.util.List;

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
public class ClosingPrices {

	public static List<ClosingPrices> priceList = new ArrayList<>();

	public static double getPrice(final String ticker) {

		double ret = 0.0;
		for (final ClosingPrices cp : priceList) {
			if (cp.ticker.equalsIgnoreCase(ticker)) {
				ret = cp.price;
				break;
			}
		}
		return ret;
	}

	private String ticker;

	private double price;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ClosingPrices() {

		// Not to be called
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ClosingPrices(final String t, final String p) {

		this.ticker = t;
		this.price = Double.parseDouble(p);
		priceList.add(this);
	}

	@Override
	public String toString() {

		String ret = "";
		ret += this.ticker + "  " + this.price;
		return ret;
	}

}
