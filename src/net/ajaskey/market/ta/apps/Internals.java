
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;

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
public class Internals {

	private static List<String>			filenames	= new ArrayList<String>();
	private static List<TickerData>	tdList		= new ArrayList<>();

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Internals() {
		ParseData.setValidTicker("ADDN.IDX");
		ParseData.setValidTicker("ADDQ.IDX");
		ParseData.setValidTicker("ADDE.IDX");
		ParseData.setValidTicker("ADDT.IDX");
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\INDEX");
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {

		new Internals();

		tdList = ParseData.parseFiles(filenames, 200);

		for (final TickerData td : tdList) {
			td.generateDerived();

			for (int days = 10; days < 101; days += 5) {
				final boolean ob = Internals.isOverBought(Internals.getSum(td.getCloseData(), days),
				    Internals.getAverage(td.getCloseData(), days), days);
				final boolean os = Internals.isOverSold(Internals.getSum(td.getCloseData(), days),
				    Internals.getAverage(td.getCloseData(), days), days);

				if (ob) {
					System.out.println(td.getTicker() + " is Overbought over last " + days + " days.");
				}

				if (os) {
					System.out.println(td.getTicker() + " is Oversold over last " + days + " days.");
				}
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.getAverage
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	private static double getAverage(double[] val, int days) {
		double sum = 0.0;
		for (int i = 0; i < days; i++) {
			// System.out.println(td.getClose(i));
			sum += Math.abs(val[i]);
		}
		return sum / days;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.getSum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	private static double getSum(double[] val, int days) {
		double sum = 0.0;
		for (int i = 0; i < days; i++) {
			// System.out.println(td.getClose(i));
			sum += val[i];
		}
		return sum;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isOverBought
	 *
	 * @param sum
	 * @param avg
	 * @param days
	 * @return
	 */
	private static boolean isOverBought(double sum, double avg, int days) {
		final double obLevel = avg * (0.25) * days;
		// System.out.println(sum + " " + obLevel);
		return (sum > obLevel);
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isOverSold
	 *
	 * @param sum
	 * @param avg
	 * @param days
	 * @return
	 */
	private static boolean isOverSold(double sum, double avg, int days) {
		final double osLevel = avg * (-0.25) * days;
		// System.out.println(sum + " " + osLevel);
		return (sum < osLevel);
	}

}
