
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.InterdayData;
import net.ajaskey.market.ta.TickerData;
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

	private static List<TickerData> tdList = new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		String arg = "InterdayDataPath";
		final String idDataPath = System.getProperty(arg, "");

		final File nazFile = new File(idDataPath + "\\NASDAQ_20151130.csv");
		final List<InterdayData> idList = ParseData.parseInterdayFile(nazFile);

		final List<String> filenames = new ArrayList<>();

		arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		ParseData.clearValidTickers();
		ParseData.setValidTicker("PROCESS_ALL_TICKERS");
		tdList = ParseData.parseFiles(filenames, 60);

		Utils.makeDir("out");
		List<InterdayData> filteredList = ProcessInterday.filterList(idList, 0.99, 50000, 200, 0.01);
		ProcessInterday.printList(filteredList, "out\\all-interday.txt");

		filteredList.clear();
		filteredList = ProcessInterday.filterList(idList, 4.99, 500000, 290, 0.10);
		ProcessInterday.printList(filteredList, "out\\filtered-interday.txt");

	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.filterList
	 *
	 * @param idList
	 * @return
	 */
	private static List<InterdayData> filterList(List<InterdayData> idList, double price, long volume, int ticks,
	    double minRange) {

		final List<InterdayData> filterList = new ArrayList<>();

		for (final InterdayData id : idList) {

			/**
			 * Stocks over $5 that have moved and have a reasonable about of daily
			 * data.
			 */
			if ((id.getDayHigh() > price) && (Math.abs(id.getRange()) > minRange) && (id.getUpdates() > ticks)) {

				final TickerData td = TickerData.getFromList(id.getTicker(), tdList);
				td.generateDerived();

				/**
				 * Stocks over 500k volume and todays volume greater than average daily
				 * volume.
				 */
				if (((long) td.getAvgVol20() > volume) && ((id.getSumVol() > (long) td.getAvgVol20()))) {
					id.setTd(td);
					filterList.add(id);
				}
			}

		}
		return filterList;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processAllBreadth
	 *
	 * @param list
	 * @throws FileNotFoundException
	 */
	private static void printList(List<InterdayData> list, String outfile) throws FileNotFoundException {

		int totUp = 0;
		int totDown = 0;
		double totFUp = 0;
		double totFDown = 0;
		int totPosDiv = 0;
		int totNegDiv = 0;
		int totBottom5th = 0;
		int totTop5th = 0;

		try (PrintWriter pw = new PrintWriter(outfile)) {
			pw.printf(
			    "Ticker\tTicks\tUp\tDown\tDiff\tfUp\tfDown\tForce\tVol\tFV\tOpen\tHigh\tLow\tClose\tRng\tpRng\tcRatio%n");

			for (final InterdayData id : list) {

				// System.out.println(id.getTicker() + " " + id.getUpdates());

				final int diff = id.getSumUp() - id.getSumDown();
				final long fDiff = (long) (id.getSumForceUp() - id.getSumForceDown());

				if ((diff < -10) && (fDiff > 1000)) {
					totPosDiv++;
				} else if ((diff > 10) && (fDiff < -1000)) {
					totNegDiv++;
				}

				double priceInRng = 0;
				if (id.getRange() > 0.0) {
					priceInRng = (id.getDayClose() - id.getDayLow()) / id.getRange();
				}

				totUp += id.getSumUp();
				totDown += id.getSumDown();
				totFUp += id.getSumForceUp();
				totFDown += id.getSumForceDown();

				final double fv = Math.abs(((double) fDiff / id.getSumVol()) * 100.0);
				final double rngPerc = id.getRange() / id.getDayClose();

				pw.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.4f\t%.2f%n",
				    id.getTicker(), id.getUpdates(), id.getSumUp(), id.getSumDown(), diff, (long) id.getSumForceUp(),
				    (long) id.getSumForceDown(), fDiff, id.getSumVol(), fv, id.getDayOpen(), id.getDayHigh(), id.getDayLow(),
				    id.getDayClose(), id.getRange(), rngPerc, priceInRng);

				if (priceInRng > 0.80) {
					totTop5th++;
				} else if (priceInRng < 0.20) {
					totBottom5th++;
				}

			}

			String diff = NumberFormat.getIntegerInstance().format(totUp - totDown);
			String fdiff = NumberFormat.getIntegerInstance().format(totFUp - totFDown);

			// System.out.printf("%d %d %n", totNegDiv, totPosDiv);
			// System.out.printf("%d %d %n", totBottom5th, totTop5th);
			System.out.printf("%d  %10s %18s %n", list.size(), diff, fdiff);
			// System.out.printf("%.2f %d%n", ((double) (totUp - totDown) / (double)
			// list.size()),
			// (long) ((totFUp - totFDown) / list.size()));

		}
	}
}
