
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.apps.helpers.BreadthData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.methods.MovingAverageMethods;
import net.ajaskey.market.ta.methods.UtilMethods;

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

public class BreadthOfList {

	private static List<String>	filenames			= new ArrayList<>();
	private static List<String>	fullfilenames	= new ArrayList<>();
	final private static String	TAB						= "\t";

	final private static int		UD_DAYS				= 45;

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		System.out.println("Processing...");

		fullfilenames.add("symbols\\AMEX_SymbolList.txt");
		fullfilenames.add("symbols\\NYSE_SymbolList.txt");
		fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\AMEX");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");

		System.out.println("Ticker\t23dma\t65dma\t130dma\t260dma\tUpDays\tUpVol");

		BreadthOfList.processGroup("SPX");
		BreadthOfList.processGroup("MID");
		BreadthOfList.processGroup("SML");
		BreadthOfList.processGroup("NDX");

		BreadthOfList.processGroup("XRT");
		BreadthOfList.processGroup("KRE");
		BreadthOfList.processGroup("IBB");
		BreadthOfList.processGroup("XHB");
		BreadthOfList.processGroup("SMH");
		BreadthOfList.processGroup("TRANS");

		BreadthOfList.processGroup("XLB");
		BreadthOfList.processGroup("XLE");
		BreadthOfList.processGroup("XLF");
		BreadthOfList.processGroup("XLI");
		BreadthOfList.processGroup("XLK");
		BreadthOfList.processGroup("XLP");
		BreadthOfList.processGroup("XLU");
		BreadthOfList.processGroup("XLV");
		BreadthOfList.processGroup("XLY");
		BreadthOfList.processGroup("XLRE");

		// Utils.makeDir("breadth");

	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processGroup
	 *
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void processGroup(String name) throws FileNotFoundException, IOException, ParseException {
		final List<TickerData> tdAll = BreadthOfList.readList(name);
		final List<BreadthData> bd = BreadthOfList.processList(tdAll);
		BreadthOfList.writeData(bd, name);
		tdAll.clear();
		bd.clear();
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processList
	 *
	 * @param tdList
	 * @return
	 */
	private static List<BreadthData> processList(List<TickerData> tdList) {
		final List<BreadthData> retList = new ArrayList<>();
		for (final TickerData td : tdList) {
			td.fillDataArrays(0, false);

			if (td.getDataCount() > 260) {

				final BreadthData data = new BreadthData();

				data.setPrice(td.getClose(0));
				data.setDma23(UtilMethods.sma(td.getCloseData(), 23));
				data.setDma65(UtilMethods.sma(td.getCloseData(), 65));
				data.setDma130(UtilMethods.sma(td.getCloseData(), 130));
				data.setDma260(UtilMethods.sma(td.getCloseData(), 260));

				for (int i = 1; i < UD_DAYS; i++) {
					final double yesterday = td.getClose(i);
					final double today = td.getClose(i - 1);
					final long volToday = (long) td.getVolume(i - 1);
					data.addVol(volToday);
					if (today > yesterday) {
						data.addUpDay();
						data.addUpVol(volToday);
					} else if (yesterday > today) {
						data.addDownDay();
						data.addDownVol(volToday);
					}

					// System.out.println(today + TAB +
					// yesterday+TAB+volToday+TAB+data.getUpVol()+TAB+data.getDownVol());
				}

				// System.out.println(td.getTicker() + " : " + data.toString() + TAB +
				// td.getDataCount());

				retList.add(data);
			} else {
				// System.out.println("Warning... " + td.getTicker() + " does not have
				// 200 days of data.");
			}
		}
		return retList;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.readList
	 *
	 * @param listName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static List<TickerData> readList(String listName) throws FileNotFoundException, IOException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\" + listName + "-components.csv"));

		final List<TickerData> tdList = ParseData.parseFiles(filenames, 400);

		return tdList;
	}

	/**
	 * net.ajaskey.market.ta.apps.writeData
	 *
	 * @param bd
	 * @param name
	 */
	private static void writeData(List<BreadthData> bdList, String name) {
		final int knt = bdList.size();
		long over23dma = 0;
		long over65dma = 0;
		long over130dma = 0;
		long over260dma = 0;
		long upDays = 0;
		long totDays = 0;
		long upVol = 0;
		long totVol = 0;
		for (final BreadthData bd : bdList) {
			final double p = bd.getPrice();
			if (p > bd.getDma23()) {
				over23dma++;
			}
			if (p > bd.getDma65()) {
				over65dma++;
			}
			if (p > bd.getDma130()) {
				over130dma++;
			}
			if (p > bd.getDma260()) {
				over260dma++;
			}
			upDays += bd.getUpDays();
			totDays += UD_DAYS;
			upVol += bd.getUpVol();
			totVol += bd.getTotVol();
		}
		final double per23dma = ((((double) over23dma / (double) knt) * 100.0) - 50.0) / 5.0;
		final double per65dma = ((((double) over65dma / (double) knt) * 100.0) - 50.0) / 5.0;
		final double per130dma = ((((double) over130dma / (double) knt) * 100.0) - 50.0) / 5.0;
		final double per260dma = ((((double) over260dma / (double) knt) * 100.0) - 50.0) / 5.0;
		final double perUpDays = ((((double) upDays / (double) totDays) * 100.0) - 50.0) / 5.0;
		final double perUpVol = ((((double) upVol / (double) totVol) * 100.0) - 50.0) / 5.0;

		// System.out.println(TAB+over23dma + TAB + over65dma + TAB + over130dma +
		// TAB + over260dma);

		System.out.println(name + TAB + Math.round(per23dma) + TAB + Math.round(per65dma) + TAB + Math.round(per130dma)
		    + TAB + Math.round(per260dma) + TAB + Math.round(perUpDays) + TAB + Math.round(perUpVol));

	}

}
