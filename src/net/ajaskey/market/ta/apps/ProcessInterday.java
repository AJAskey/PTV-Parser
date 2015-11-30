
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import net.ajaskey.market.ta.InterdayData;
import net.ajaskey.market.ta.input.ParseData;

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
public class ProcessInterday {

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		final String arg = "InterdayDataPath";
		final String idDataPath = System.getProperty(arg, "");

		final File f = new File(idDataPath + "\\NASDAQ_20151127.csv");

		final List<InterdayData> idList = ParseData.parseInterdayFile(f);

		int totUp = 0;
		int totDown = 0;
		double totFUp = 0;
		double totFDown = 0;
		int totPosDiv = 0;
		int totNegDiv = 0;
		int totBottom5th = 0;
		int totTop5th = 0;
		for (final InterdayData id : idList) {
			final int diff = id.getSumUp() - id.getSumDown();
			final long fDiff = (long) (id.getSumForceUp() - id.getSumForceDown());
			if ((diff < -10) && (fDiff > 1000)) {
				totPosDiv++;
			} else if ((diff > 10) && (fDiff < -1000)) {
				totNegDiv++;
			}
			final double rng = id.getDayHigh() - id.getDayLow();
			double priceInRng = 0;
			if (rng > 0.0) {
				priceInRng = (id.getDayClose() - id.getDayLow()) / rng;
			}

			totUp += id.getSumUp();
			totDown += id.getSumDown();
			totFUp += id.getSumForceUp();
			totFDown += id.getSumForceDown();

			System.out.printf("%s %d %d %d      %d %d %d      %d %.2f %.2f  %.2f   %.2f %.2f  %.2f%n", id.getTicker(),
			    id.getSumUp(), id.getSumDown(), diff, (long) id.getSumForceUp(), (long) id.getSumForceDown(), fDiff,
			    id.getSumVol(), id.getDayLow(), id.getDayHigh(), rng, id.getDayOpen(), id.getDayClose(), priceInRng);

			if ((id.getDayHigh() > 6.99) && (Math.abs(rng) > 0.10)) {
				if (priceInRng > 0.80) {
					totTop5th++;
				} else if (priceInRng < 0.20) {
					totBottom5th++;
				}
			}

		}
		System.out.println(idList.size());
		System.out.printf("%d %d %n", totPosDiv, totNegDiv);
		System.out.printf("%d %d %n", totBottom5th, totTop5th);
		System.out.printf("%d %d %n", (totUp - totDown), (long) (totFUp - totFDown));
		System.out.printf("%.2f %.2f %n", ((double) (totUp - totDown) / (double) idList.size()),
		    (totFUp - totFDown) / idList.size());

		// this.priceInRng260 = (this.currentPrice - this.low260) / (this.high260 -
		// this.low260);

	}

}
