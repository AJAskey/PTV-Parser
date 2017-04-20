
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.IndustryData;
import net.ajaskey.market.ta.SortTickerRs;
import net.ajaskey.market.ta.SortTickerRsSt;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.Fundamentals;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.input.YahooData;

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
public class WhosHot {

	private static List<String>		filenames			= new ArrayList<>();
	private static List<String>		fullfilenames	= new ArrayList<>();
	private static DecimalFormat	vFmt					= new DecimalFormat("###,###,###.00");

	private static boolean init = false;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws IOException
	 *
	 */
	private WhosHot(String list) throws ParseException, IOException {

		if (!init) {

			fullfilenames.add("symbols\\INDEX_SymbolList.txt");
			// fullfilenames.add("symbols\\AMEX_SymbolList.txt");
			fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
			fullfilenames.add("symbols\\NYSE_SymbolList.txt");
			TickerFullName.build(fullfilenames);

			final String dataPath = Utils.getDataPath();
			// filenames.add(dataPath + "\\ASCII\\AMEX");
			filenames.add(dataPath + "\\ASCII\\NYSE");
			filenames.add(dataPath + "\\ASCII\\NASDAQ");
			filenames.add(dataPath + "\\ASCII\\INDEX");
			// filenames.add(dataPath + "\\ASCII\\USMF");

			Fundamentals.build("lists\\stock-fundie-list.txt");

			init = true;
		}
		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList(list));

	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {

		System.out.println("Processing...");

		WhosHot.processList("lists\\caseshiller-list-mod.txt", "cs", 0, 0);
		// WhosHot.processList("lists\\djus-list.txt", "djus", 0, 0);
		// WhosHot.processList("lists\\etf-list-mod.txt", "etf", 0, 500000);
		WhosHot.processList("lists\\stock-list.txt", "stocks", 0, 750000);

		System.out.println("Done.");
	}

	@SuppressWarnings("unused")
	private static IndustryData find(String name, IndustryData[] ind) {

		for (final IndustryData id : ind) {
			if (id.getName().equalsIgnoreCase(name)) {
				return id;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processList
	 *
	 * @param list
	 * @param outName
	 * @param offset
	 * @param minVol
	 * @throws ParseException
	 * @throws IOException
	 */
	private static void processList(String list, String outName, int offset, int minVol)
	    throws ParseException, IOException {

		new WhosHot(list);

		final List<TickerData> tdAll = ParseData.parseFiles(filenames, 400);

		if (tdAll == null) {
			return;
		}

		System.out.println("Tickers found : " + tdAll.size());

		for (final TickerData td : tdAll) {
			td.generateDerived(offset, false);
		}

		Utils.makeDir("out");

		Collections.sort(tdAll, new SortTickerRs());

		final IndustryData[] ind = new IndustryData[tdAll.size()];
		int maxNameLen = 0;
		int maxTickerLen = 0;
		int knt = 0;
		for (final TickerData td : tdAll) {
			ind[knt] = new IndustryData();
			ind[knt].setName(td.getTickerName());
			ind[knt].setTicker(td.getTicker());
			if (td.getFundies() != null) {
				ind[knt].setShares(td.getFundies().getShares());
				ind[knt].setMarketCap(td.getFundies().getMarketCap());
			}
			ind[knt].setExch(td.getTickerExchange());
			ind[knt].setRawRs(td.getRsRaw());
			ind[knt].setChg260(td.getChg260());
			ind[knt].setAvgVol(td.getAvgVol65());
			ind[knt].setPriceInRange260(td.getPriceInRng260());
			ind[knt].setRank(knt);
			maxNameLen = Math.max(maxNameLen, td.getTickerName().length() + 2);
			maxTickerLen = Math.max(maxTickerLen, td.getTicker().length() + 1);
			knt++;
		}

		final String fmt = String.format("%%-%ds\t%%-%ds\t%%-10s\t%%s\t%%9.1f\t%%12sM\t%%8sM\t%%10.1f\t%%10s%%n",
		    maxTickerLen, maxNameLen);

		final PrintWriter pwSD = new PrintWriter("out\\SupplyDemand-" + outName + ".txt");
		pwSD.println("Symbol\tName\tExchange\tRank\tAvgVol (M)\tFloat (M)\tRatio\tMktCap\tCompany Description");

		try (PrintWriter pw = new PrintWriter("out\\whosHot-" + outName + ".txt")) {
			double shares = 0.0;
			for (final IndustryData id : ind) {
				if (id.getAvgVol() >= minVol) {
					double volRatio = 0;
					if (id.getfShares() > 0) {
						volRatio = id.getfShares() / id.getAvgVol();
						shares = id.getfShares();
					} else if (id.getShares() > 0) {
						volRatio = id.getShares() / id.getAvgVol();
						shares = id.getShares();
					}
					final String vol = vFmt.format(id.getAvgVol() / 1000000.0);
					final String shr = vFmt.format(id.getShares() / 1000000.0);
					pw.printf(fmt, id.getTicker(), id.getName(), id.getExch(), id.getRanks(), id.getChg260(), vol, shr, volRatio,
					    id.getMarketCap());

					if ((volRatio > 0.0) && (shares > 0.0) && (shares < 100000000.0) && (id.getPriceInRange260() > 0.50)
					    && (volRatio < 35.0)) {
						final String bSum = YahooData.getBusinessSummary(id.getTicker());
						// final String bSum = "";
						pwSD.println(id.getTicker() + Utils.TAB + id.getName() + Utils.TAB + id.getExch() + Utils.TAB
						    + id.getRanks() + Utils.TAB + vol + Utils.TAB + shr + Utils.TAB + volRatio + Utils.TAB
						    + id.getMarketCap() + Utils.TAB + bSum);
					}
				}
			}
		}
		pwSD.close();

		Collections.sort(tdAll, new SortTickerRsSt());

		knt = 0;
		for (final TickerData td : tdAll) {
			ind[knt].setName(td.getTickerName());
			ind[knt].setTicker(td.getTicker());
			ind[knt].setRawRsSt(td.getRsStRaw());
			ind[knt].setAvgVol(td.getAvgVol65());
			ind[knt].setRank(knt);
			knt++;
		}
		try (PrintWriter pw = new PrintWriter("out\\whosHot-" + outName + "-ShortTerm.txt")) {

			for (final IndustryData id : ind) {
				if (id.getAvgVol() >= minVol) {
					double volRatio = 0;
					if (id.getShares() > 0) {
						volRatio = id.getShares() / id.getAvgVol();
					}
					final String vol = vFmt.format(id.getAvgVol() / 1000000.0);
					final String shr = vFmt.format(id.getShares() / 1000000.0);
					pw.printf(fmt, id.getTicker(), id.getName(), id.getExch(), id.getRanks(), id.getRawRsSt(), vol, shr, volRatio,
					    id.getMarketCap());

					// System.out.printf("%-30s %s%n",id.getName(), id.getRanks());
				}
			}
		}
		TickerData.clearTickerData(tdAll);
	}

}
