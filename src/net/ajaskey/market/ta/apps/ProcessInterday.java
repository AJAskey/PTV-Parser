
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import net.ajaskey.market.ta.InterdayData;
import net.ajaskey.market.ta.Utils;
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

		final File nazFile = new File(idDataPath + "\\NASDAQ_20151116.csv");
		final List<InterdayData> idList = ParseData.parseInterdayFile(nazFile);

		final File nyseFile = new File(idDataPath + "\\NYSE_20151116.csv");
		final List<InterdayData> nyseList = ParseData.parseInterdayFile(nyseFile);
		
		final File amexFile = new File(idDataPath + "\\AMEX_20151116.csv");
		final List<InterdayData> amexList = ParseData.parseInterdayFile(amexFile);

		idList.addAll(amexList);

		Utils.makeDir("out");
		try (PrintWriter pw = new PrintWriter("out\\interday.out")) {
			pw.printf("Ticker\tTicks\tUp\tDown\tDiff\tfUp\tfDown\tForce\tVol\tFV\tOpen\tHigh\tLow\tClose\tRng\tpRng\tcRatio%n");

			int totUp = 0;
			int totDown = 0;
			double totFUp = 0;
			double totFDown = 0;
			int totPosDiv = 0;
			int totNegDiv = 0;
			int totBottom5th = 0;
			int totTop5th = 0;
			int knt = 0;
			
			for (final InterdayData id : idList) {

				 double rng = id.getDayHigh() - id.getDayLow();
				
				if ((id.getDayHigh() > 4.99) && (Math.abs(rng) > 0.10) && (id.getSumVol() > 500000) && (id.getUpdates() > 290)) {

					knt++;

					final int diff = id.getSumUp() - id.getSumDown();
					final long fDiff = (long) (id.getSumForceUp() - id.getSumForceDown());

					if ((diff < -10) && (fDiff > 1000)) {
						totPosDiv++;
					} else if ((diff > 10) && (fDiff < -1000)) {
						totNegDiv++;
					}

					double priceInRng = 0;
					if (rng > 0.0) {
						priceInRng = (id.getDayClose() - id.getDayLow()) / rng;
					}

					totUp += id.getSumUp();
					totDown += id.getSumDown();
					totFUp += id.getSumForceUp();
					totFDown += id.getSumForceDown();
					
					double fv = Math.abs((double)fDiff / id.getSumVol() * 100.0);
					double rngPerc = rng / id.getDayClose();
					

					pw.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.4f\t%.2f%n", id.getTicker(),
					    id.getUpdates(), id.getSumUp(), id.getSumDown(), diff, (long) id.getSumForceUp(),
					    (long) id.getSumForceDown(), fDiff, id.getSumVol(), fv, id.getDayOpen(), id.getDayHigh(), id.getDayLow(),
					    id.getDayClose(),rng, rngPerc, priceInRng);

					if (priceInRng > 0.80) {
						totTop5th++;
					} else if (priceInRng < 0.20) {
						totBottom5th++;
					}
				}

			}
			System.out.println(idList.size() + "   " + knt);
			System.out.printf("%d %d %n", totNegDiv, totPosDiv);
			System.out.printf("%d %d %n", totBottom5th, totTop5th);
			System.out.printf("%d %d %n", (totUp - totDown), (long) (totFUp - totFDown));
			System.out.printf("%.2f %.2f %n", ((double) (totUp - totDown) / (double) idList.size()),
			    (totFUp - totFDown) / idList.size());

			// this.priceInRng260 = (this.currentPrice - this.low260) / (this.high260
			// -
			// this.low260);
		}
	}

}
