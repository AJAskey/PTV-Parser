
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.InterdayData;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.apps.helpers.InterdaySumData;
import net.ajaskey.market.ta.input.ParseData;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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

		final File nazFile = new File(idDataPath + "\\NASDAQ_20151201.csv");
		final List<InterdayData> idList = ParseData.parseInterdayFile(nazFile);
		System.out.println("Total Tickers : " + idList.size());

		final List<String> filenames = new ArrayList<>();

		arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		// filenames.add(dataPath + "\\ASCII\\NYSE");
		ParseData.clearValidTickers();
		ParseData.setValidTicker("PROCESS_ALL_TICKERS");
		tdList = ParseData.parseFiles(filenames, 60);

		Utils.makeDir("out");

		InterdaySumData sd = ProcessInterday.setSumData(idList);
		ProcessInterday.printList(idList, sd, "out\\all-interday.txt");

		List<InterdayData> filteredList = ProcessInterday.filterList(idList, 0.99, 50000, 200, 0.01);
		sd = ProcessInterday.setSumData(filteredList);
		ProcessInterday.printList(filteredList, sd, "out\\most-interday.txt");

		filteredList.clear();
		filteredList = ProcessInterday.filterList(idList, 4.99, 500000, 290, 0.10);
		sd = ProcessInterday.setSumData(filteredList);
		ProcessInterday.printList(filteredList, sd, "out\\filtered-interday.txt");

	}

	/**
	 * Creates a sublist of InterdayData based on filter criteria.
	 *
	 * @param idList
	 *          List of InterdayData object to filter
	 * @param priceLimit
	 *          lowest price to consider
	 * @param volumeLimit
	 *          lowest volume to consider
	 * @param tickLimit
	 *          lowest number of data points to consider
	 * @param rangeLimit
	 *          smallest interday price change to consider
	 *
	 * @return A List of InterdayData objects that meet all the criteria passed
	 *         in.
	 */
	private static List<InterdayData> filterList(List<InterdayData> idList, double priceLimit, long volumeLimit,
	    int tickLimit, double rangeLimit) {

		final List<InterdayData> filterList = new ArrayList<>();

		for (final InterdayData id : idList) {

			/**
			 * Stocks over $5 that have moved and have a reasonable about of daily
			 * data.
			 */
			TickerData td = null;
			if ((id.getDayHigh() > priceLimit) && (Math.abs(id.getPriceRange()) > rangeLimit)
			    && (id.getUpdates() > tickLimit)) {

				if (id.getTd() == null) {
					td = TickerData.getFromList(id.getTicker(), tdList);
					td.generateDerived(false);
					id.setTd(td);
				} else {
					td = id.getTd();
				}

				/**
				 * Stocks over 500k volume and todays volume greater than average daily
				 * volume.
				 */
				final long vol20 = (long) td.getAvgVol20();
				if ((vol20 > volumeLimit) && ((id.getSumVol() > vol20))) {
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
	 * @param sd
	 * @throws FileNotFoundException
	 */
	private static void printList(List<InterdayData> list, InterdaySumData sd, String outfile)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(outfile)) {
			pw.printf(
			    "Ticker\tTicks\tUp\tDown\tDiff\tfUp\tfDown\tForce\tVol\tFV\tOpen\tHigh\tLow\tClose\tRng\tpRng\tcRatio%n");

			for (final InterdayData id : list) {

				// System.out.println(id.getTicker() + " " + id.getUpdates());

				pw.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.4f\t%.2f%n",
				    id.getTicker(), id.getUpdates(), id.getSumUp(), id.getSumDown(), id.getUpDownDiff(),
				    (long) id.getSumForceUp(), (long) id.getSumForceDown(), id.getForceDiff(), id.getSumVol(),
				    id.getForceVolume(), id.getDayOpen(), id.getDayHigh(), id.getDayLow(), id.getDayClose(), id.getPriceRange(),
				    id.getRangePercent(), sd.priceInRng);
			}

			final String strDiff = NumberFormat.getIntegerInstance().format(sd.totUp - sd.totDown);
			final String strFdiff = NumberFormat.getIntegerInstance().format(sd.totForceUp - sd.totForceDown);

			System.out.printf("%5d  %10s %18s  %d  %d  %d  %d %n", list.size(), strDiff, strFdiff, sd.upperRange,
			    sd.lowerRange, sd.upOnVolume, sd.downOnVolume);

		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.setSumData
	 *
	 * @param list
	 * @return
	 */
	private static InterdaySumData setSumData(List<InterdayData> list) {

		final InterdaySumData sd = new InterdaySumData();

		for (final InterdayData id : list) {

			sd.priceInRng = 0;
			if (id.getPriceRange() > 0.0) {
				sd.priceInRng = (id.getDayClose() - id.getDayLow()) / id.getPriceRange();
			}

			sd.totUp += id.getSumUp();
			sd.totDown += id.getSumDown();
			sd.totForceUp += id.getSumForceUp();
			sd.totForceDown += id.getSumForceDown();

			if (id.getTd() != null) {
				if (id.getSumVol() > (id.getTd().getAvgVol20() * 2.0)) {
					if (id.getDayOpen() < id.getDayClose()) {
						if (sd.priceInRng > 0.75) {
							sd.upOnVolume++;
						}
					} else if (id.getDayOpen() > id.getDayClose()) {
						if (sd.priceInRng < 0.25) {
							sd.downOnVolume++;
						}
					}
				}
			}

			/**
			 * Greater than 1% more or at least an 80 cent move.
			 */
			if ((id.getRangePercent() > 0.009) || (id.getPriceRange() > 0.79)) {
				if (sd.priceInRng > 0.85) {
					sd.upperRange++;
				} else if (sd.priceInRng < 0.15) {
					sd.lowerRange++;
				}
			}
		}
		return sd;
	}
}
