
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
import net.ajaskey.market.ta.SortTickerRs;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.methods.TaMethods;

/**
 *
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
public class ProcessMarketInternals {

	final private static TaMethods	taMethods	= new TaMethods();
	private static List<TickerData>	tdAll;
	private static List<String>			filenames	= new ArrayList<>();

	/**
	 *
	 * net.ajaskey.market.ta.apps.calcAdvDecl
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	private static void calcAdvDecl() throws ParseException, FileNotFoundException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("NYA.IDX");
		ParseData.setValidTicker("DWC.IDX");
		ParseData.setValidTicker("COMP.IDX");
		ParseData.setValidTicker("RUA.IDX");
		ParseData.setValidTicker("SML.IDX");
		ParseData.setValidTicker("BANK.IDX");
		ParseData.setValidTicker("S2TR.IDX");

		tdAll = ParseData.parseFiles(filenames);

		int advDecl = 0;

		try (PrintWriter pw = new PrintWriter("out\\advance-decline.txt")) {

			for (final TickerData td : tdAll) {
				td.generateDerived(false);
				advDecl = taMethods.calcAdvDecl(td.getCloseData(), 260);
				pw.println(td.getTicker() + "  :  " + advDecl);
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.calcMfiNasdaq
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	private static void calcMfiNasdaq() throws ParseException, FileNotFoundException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("ADVQ.IDX");
		ParseData.setValidTicker("AVVQ.IDX");
		ParseData.setValidTicker("DECQ.IDX");
		ParseData.setValidTicker("DVCQ.IDX");
		ParseData.setValidTicker("COMP.IDX");

		tdAll = ParseData.parseFiles(filenames);

		double[] adv = null;
		double[] decl = null;
		double[] advVol = null;
		double[] declVol = null;
		double[] close = null;

		for (final TickerData td : tdAll) {
			td.generateDerived(false);
			if (td.getTicker().equalsIgnoreCase("ADVQ.IDX")) {
				adv = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DECQ.IDX")) {
				decl = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("AVVQ.IDX")) {
				advVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DVCQ.IDX")) {
				declVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("COMP.IDX")) {
				close = td.getCloseData();
			}
		}

		final DecimalFormat fmt = new DecimalFormat("###,###,###");
		final String mfi10 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 10));
		final String mfi23 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 23));
		final String mfi65 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 65));
		final String mfi130 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 130));
		final String mfi260 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 260));
		final String mfi300 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 300));

		try (PrintWriter pw = new PrintWriter("out\\nasdaq-mfi.txt")) {
			pw.println(" 10 days : " + mfi10);
			pw.println(" 23 days : " + mfi23);
			pw.println(" 65 days : " + mfi65);
			pw.println("130 days : " + mfi130);
			pw.println("260 days : " + mfi260);
			pw.println("300 days : " + mfi300);
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.calcMfiNyse
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	private static void calcMfiNyse() throws ParseException, FileNotFoundException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("ADVN.IDX");
		ParseData.setValidTicker("AVVN.IDX");
		ParseData.setValidTicker("DECN.IDX");
		ParseData.setValidTicker("DVCN.IDX");
		ParseData.setValidTicker("NYA.IDX");

		tdAll = ParseData.parseFiles(filenames);

		double[] adv = null;
		double[] decl = null;
		double[] advVol = null;
		double[] declVol = null;
		double[] close = null;

		for (final TickerData td : tdAll) {
			td.generateDerived(false);
			if (td.getTicker().equalsIgnoreCase("ADVN.IDX")) {
				adv = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DECN.IDX")) {
				decl = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("AVVN.IDX")) {
				advVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DVCN.IDX")) {
				declVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("NYA.IDX")) {
				close = td.getCloseData();
			}
		}

		final DecimalFormat fmt = new DecimalFormat("###,###,###");
		final String mfi10 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 10));
		final String mfi23 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 23));
		final String mfi65 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 65));
		final String mfi130 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 130));
		final String mfi260 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 260));
		final String mfi300 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 300));

		try (PrintWriter pw = new PrintWriter("out\\nyse-mfi.txt")) {
			pw.println(" 10 days : " + mfi10);
			pw.println(" 23 days : " + mfi23);
			pw.println(" 65 days : " + mfi65);
			pw.println("130 days : " + mfi130);
			pw.println("260 days : " + mfi260);
			pw.println("300 days : " + mfi300);
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.calcMfiOtc
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	private static void calcMfiOtc() throws ParseException, FileNotFoundException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("ADVD.IDX");
		ParseData.setValidTicker("AVVD.IDX");
		ParseData.setValidTicker("DECD.IDX");
		ParseData.setValidTicker("DVCD.IDX");
		ParseData.setValidTicker("SML.IDX");

		tdAll = ParseData.parseFiles(filenames);

		double[] adv = null;
		double[] decl = null;
		double[] advVol = null;
		double[] declVol = null;
		double[] close = null;

		for (final TickerData td : tdAll) {
			td.generateDerived(false);
			if (td.getTicker().equalsIgnoreCase("ADVD.IDX")) {
				adv = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DECD.IDX")) {
				decl = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("AVVD.IDX")) {
				advVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("DVCD.IDX")) {
				declVol = td.getCloseData();
			}
			else if (td.getTicker().equalsIgnoreCase("SML.IDX")) {
				close = td.getCloseData();
			}
		}

		final DecimalFormat fmt = new DecimalFormat("###,###,###");
		final String mfi10 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 10));
		final String mfi23 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 23));
		final String mfi65 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 65));
		final String mfi130 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 130));
		final String mfi260 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 260));
		final String mfi300 = fmt.format(taMethods.calcIndexMoneyFlow(adv, decl, advVol, declVol, close, 300));

		try (PrintWriter pw = new PrintWriter("out\\otc-mfi.txt")) {
			pw.println(" 10 days : " + mfi10);
			pw.println(" 23 days : " + mfi23);
			pw.println(" 65 days : " + mfi65);
			pw.println("130 days : " + mfi130);
			pw.println("260 days : " + mfi260);
			pw.println("300 days : " + mfi300);
		}
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
	public static void main(final String[] args) throws ParseException, FileNotFoundException, IOException {

		new ProcessMarketInternals();

		ParseData.setValidTickers(ParseData.getTickerList("lists\\djus-list.txt"));

		final List<String> fnames = new ArrayList<>();
		fnames.add("symbols\\INDEX_SymbolList.txt");
		fnames.add("symbols\\NASDAQ_SymbolList.txt");
		fnames.add("symbols\\AMEX_SymbolList.txt");
		fnames.add("symbols\\NYSE_SymbolList.txt");
		TickerFullName.build(fnames);
		TickerFullName.debug("out\\tfn.dbg");

		final List<TickerData> tdAll = ParseData.parseFiles(filenames);

		for (final TickerData t : tdAll) {
			t.generateDerived(false);
		}

		try (PrintWriter pw = new PrintWriter("out\\industry-rs.txt")) {
			Collections.sort(tdAll, new SortTickerRs());
			for (final TickerData t : tdAll) {
				pw.println(TickerFullName.getName(t.getTicker()) + "\t" + (int) t.getChg260() + "%");
			}
		}

		try (PrintWriter pw = new PrintWriter("out\\industry-rs-st.txt")) {
			Collections.sort(tdAll, new SortTickerRs());
			for (final TickerData t : tdAll) {
				pw.println(TickerFullName.getName(t.getTicker()) + "\t" + (int) t.getChg23() + "%");
			}
		}

		ProcessMarketInternals.calcMfiNasdaq();
		ProcessMarketInternals.calcMfiNyse();
		ProcessMarketInternals.calcMfiOtc();
		ProcessMarketInternals.calcAdvDecl();

		System.out.println("Done.");
	}

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	public ProcessMarketInternals() throws ParseException, FileNotFoundException {

		filenames.add("C:\\Users\\ajask_000\\Documents\\EODData\\DataClient\\ASCII\\INDEX");
		tdAll = ParseData.parseFiles(filenames);

		Utils.makeDir("out");
	}

}
