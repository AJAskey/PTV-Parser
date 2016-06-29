
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.SortTickerName;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

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
public class GenStockList {

	private static List<String>	filenames			= new ArrayList<>();
	private static List<String>	fullfilenames	= new ArrayList<>();
	private static boolean			init					= false;
	private static List<String>	ignoreNames;

	private static List<String>	dontIgnoreTickers;

	private static List<String>	sp500List			= null;
	private static List<String>	sp600List			= null;
	private static List<String>	ndxList				= null;

	private GenStockList() throws ParseException, IOException {

		if (!init) {

			fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
			fullfilenames.add("symbols\\NYSE_SymbolList.txt");
			fullfilenames.add("symbols\\AMEX_SymbolList.txt");
			TickerFullName.build(fullfilenames);

			final String arg = "dataPath";
			final String dataPath = System.getProperty(arg, "");
			filenames.add(dataPath + "\\ASCII\\NASDAQ");
			filenames.add(dataPath + "\\ASCII\\NYSE");
			filenames.add(dataPath + "\\ASCII\\AMEX");
			init = true;
		}
		ParseData.clearValidTickers();
		ParseData.setValidTicker("PROCESS_ALL_TICKERS");

		/**
		 * DontIgnoreTickers overrides general strings of IgnoreNames
		 */
		dontIgnoreTickers = new ArrayList<String>();
		// dontIgnoreTickers.add("QQQ");
		// dontIgnoreTickers.add("DIA");
		// dontIgnoreTickers.add("QQEW");
		// dontIgnoreTickers.add("SPY");
		// dontIgnoreTickers.add("IWO");

		ignoreNames = new ArrayList<String>();
		ignoreNames.add(" ETF");
		ignoreNames.add("PROSHRES");
		ignoreNames.add("SHARES");
		ignoreNames.add(" BULL");
		ignoreNames.add(" BEAR");
		ignoreNames.add(" INDEX");
		ignoreNames.add("SPDR");
		ignoreNames.add("DIREXION");
		ignoreNames.add(" SECTOR");
		ignoreNames.add(" FUTURES");
		ignoreNames.add(" HEDGED");
		ignoreNames.add(" TRUST");
		ignoreNames.add(" FUND");
		ignoreNames.add(" ETN");
		ignoreNames.add("VANGUARD TOTAL");
		ignoreNames.add("PCG-");
		ignoreNames.add("DB-XT");
		ignoreNames.add("WISDOMTREE");
		ignoreNames.add(" EATON VANCE");
		ignoreNames.add(" SCHWAB");
		ignoreNames.add("LIBERTY GLOBAL");
	}

	/**
	 * net.ajaskey.market.ta.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException, IOException {

		System.out.println("GenStockList Processing...");

		GenStockList.findStocks("stock-list", 500000, 10.0);

		System.out.println("GenStockList Done.");

	}

	/**
	 * net.ajaskey.market.ta.checkName
	 *
	 * @param ticker
	 * @return
	 */
	private static boolean checkName(String tickerName, String ticker) {

		boolean ret = false;

		for (final String s : dontIgnoreTickers) {
			if (tickerName != null) {
				if (ticker.equalsIgnoreCase(s)) {
					ret = true;
					System.out.println("Not Ignoring : " + ticker);
					break;
				}
			}
		}

		if (!ret) {
			ret = true;
			for (final String s : ignoreNames) {
				if (tickerName == null) {
					ret = false;
				} else if (tickerName.toUpperCase().contains(s)) {
					ret = false;
					// System.out.println("Ignoring : " + tickerName);
					break;
				}
			}
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.findStocks
	 *
	 * @param outName
	 * @param offset
	 * @param minVol
	 * @param minPrice
	 * @throws ParseException
	 * @throws IOException
	 */
	private static void findStocks(String outName, int minVol, double minPrice) throws ParseException, IOException {

		new GenStockList();

		final List<TickerData> tdAll = ParseData.parseFiles(filenames, 60);

		if (tdAll == null) {
			return;
		}

		final List<TickerData> tdStocks = new ArrayList<TickerData>();

		System.out.println("Tickers found : " + tdAll.size());

		int maxNameLen = 0;
		int maxTickerLen = 0;

		for (final TickerData td : tdAll) {
			td.generateDerived(false);
			if ((td.getAvgVol20() >= minVol) && (td.getCurrentPrice() >= minPrice)) {
				if (GenStockList.checkName(td.getTickerName(), td.getTicker())) {
					tdStocks.add(td);
					maxNameLen = Math.max(maxNameLen, td.getTickerName().length() + 2);
					maxTickerLen = Math.max(maxTickerLen, td.getTicker().length() + 1);
				}
			}
		}

		Collections.sort(tdStocks, new SortTickerName());

		Utils.makeDir("lists");

		final String fmt = String.format("%%-%ds\t%%-%ds\t%%-10s\t%%-10s%n", maxTickerLen, maxNameLen);
		try (PrintWriter pw = new PrintWriter("lists\\" + outName + ".txt")) {
			pw.println("Ticker      Name                                        Exchange    List");
			for (final TickerData td : tdStocks) {
				if (GenStockList.isSP500(td.getTicker())) {
					pw.printf(fmt, td.getTicker(), td.getTickerName(), td.getTickerExchange(), "SP500");
				} else if (GenStockList.isNDX(td.getTicker())) {
					pw.printf(fmt, td.getTicker(), td.getTickerName(), td.getTickerExchange(), "NDX");
				} else if (GenStockList.isSP600(td.getTicker())) {
					pw.printf(fmt, td.getTicker(), td.getTickerName(), td.getTickerExchange(), "SP600");
				} else {
					pw.printf(fmt, td.getTicker(), td.getTickerName(), td.getTickerExchange(), "none");
				}
			}
		}
	}

	private static boolean isNDX(String ticker) throws FileNotFoundException, IOException {
		if (ndxList == null) {
			ndxList = ParseData.getTickerList("lists\\nasdaq100-list.txt");
		}
		for (final String s : ndxList) {
			if (ticker.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isSP500
	 *
	 * @param ticker
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static boolean isSP500(String ticker) throws FileNotFoundException, IOException {
		if (sp500List == null) {
			sp500List = ParseData.getTickerList("lists\\sp500-list.txt");
		}
		for (final String s : sp500List) {
			if (ticker.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isSP600
	 *
	 * @param ticker
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static boolean isSP600(String ticker) throws FileNotFoundException, IOException {
		if (sp600List == null) {
			sp600List = ParseData.getTickerList("lists\\sp600-list.txt");
		}
		for (final String s : sp600List) {
			if (ticker.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

}
