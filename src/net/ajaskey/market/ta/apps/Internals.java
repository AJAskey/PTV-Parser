
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	final static double							obosLevel	= 400.0;

	private static List<String>			filenames	= new ArrayList<String>();
	private static List<TickerData>	tdList		= new ArrayList<>();

	/**
	 *
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {

		Internals.processIndex();

		Internals.processAnIndex("lists\\sp500-list.txt", "SPX");
		Internals.processAnIndex("lists\\nasdaq100-list.txt", "NDX");
		Internals.processAnIndex("lists\\stock-list.txt", "Stocks");
		Internals.processAnIndex("lists\\etf-list-mod.txt", "ETF");

		double val = Internals.processListPercent("lists\\sp500-list.txt", 14);
		System.out.printf("SPX days to recover %.2f%n", val);
		val = Internals.processListPercent("lists\\nasdaq100-list.txt", 14);
		System.out.printf("NDX days to recover %.2f%n", val);
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.getSum
	 *
	 * @param val
	 * @param signVal
	 * @param days
	 * @return
	 */
	@SuppressWarnings("unused")
	private static double getSum(double[] val, double[] signVal, int days) {
		double sum = 0.0;
		for (int i = 0; i < days; i++) {
			// System.out.println(val[i]);
			if (signVal[i] > 0) {
				sum += val[i];
			} else if (signVal[i] < 0) {
				sum -= val[i];
			}
		}
		return sum;
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
			// System.out.println(val[i]);
			sum += val[i];
		}
		return sum;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isOverBought
	 *
	 * @param avg
	 * @return
	 */
	private static boolean isOverBought(double avg) {
		// System.out.println(avg);
		return (avg > obosLevel);
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.isOverSold
	 *
	 * @param avg
	 * @return
	 */
	private static boolean isOverSold(double avg) {
		return (avg < ((-1.0) * obosLevel));
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processAnIndex
	 *
	 * @param list
	 * @param listName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void processAnIndex(String list, String listName)
	    throws FileNotFoundException, IOException, ParseException {
		final int[] inc = { 10, 20 };

		try {
			for (final int days : inc) {
				final double obos = Internals.processList(list, days);
				final double dtp = Math.abs(obos / ParseData.getValidTickerCount());
				System.out.printf("%-10s OBOS value for past %2d days : %10.1f for %4d tickers with days to clear %6.2f.%n",
				    listName, days, obos, ParseData.getValidTickerCount(), dtp);
				if (dtp > 2.0) {
					System.out.println("\tWARNING");
				}
			}
		} catch (final Exception e) {
			System.out.println(listName + " : Processing Error Occurred!");
		}

	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processIndex
	 *
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	private static void processIndex() throws FileNotFoundException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("ADDA.IDX");
		ParseData.setValidTicker("ADDD.IDX");
		ParseData.setValidTicker("ADDE.IDX");
		ParseData.setValidTicker("ADDN.IDX");
		ParseData.setValidTicker("ADDQ.IDX");
		ParseData.setValidTicker("ADDT.IDX");

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\INDEX");

		tdList.clear();
		tdList = ParseData.parseFiles(filenames, 100);

		for (final TickerData td : tdList) {
			td.generateDerived();

			for (int days = 10; days < 31; days += 5) {

				final double avg = Internals.getSum(td.getCloseData(), days) / days;
				final boolean ob = Internals.isOverBought(avg);
				final boolean os = Internals.isOverSold(avg);
				if (ob) {
					System.out.printf("%-10s%s %d%s%8d", td.getTicker(), " is over BOUGHT in the last ", days, " days :  ",
					    (int) avg);
					System.out.printf("   %10d %10d%n", (int) td.getClose(days - 1), (int) td.getClose(days - 2));
				} else if (os) {
					System.out.printf("%-10s%s %d%s%8d", td.getTicker(), " is over SOLD in the last ", days, " days :  ",
					    (int) avg);
					System.out.printf("   %10d %10d%n", (int) td.getClose(days - 1), (int) td.getClose(days - 2));
				}
			}
		}
	}

	/**
	 * net.ajaskey.market.ta.apps.processList
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 *
	 */
	private static double processList(String list, int days) throws FileNotFoundException, IOException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList(list));

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");

		tdList.clear();
		tdList = ParseData.parseFiles(filenames, Math.max(70, 50 + days));

		final int[] daily = new int[days];
		for (final TickerData td : tdList) {
			td.generateDerived();
			double chg = 0;
			for (int i = 0; i < days; i++) {
				chg = td.getClose(i) - td.getClose(i + 1);
				if (chg > 0.0) {
					daily[i]++;
				} else if (chg < 0.0) {
					daily[i]--;
				}
			}
			// System.out.println(td.getTicker());
		}
		int sum = 0;
		for (final int i : daily) {
			// System.out.println(i);
			sum += i;
		}
		final double retVal = (double) sum / (double) days;
		return retVal;
	}

	private static double processListPercent(String list, int days)
	    throws FileNotFoundException, IOException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList(list));

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");

		tdList.clear();
		tdList = ParseData.parseFiles(filenames, Math.max(70, 50 + days));

		final double[] daily = new double[days];
		double sumChg = 0;
		for (final TickerData td : tdList) {
			td.generateDerived();
			double chg = 0;
			for (int i = 0; i < days; i++) {
				chg = (td.getClose(i) - td.getClose(i + 1)) / td.getClose(i + 1);

				final double val = chg * td.getAvgVol20();
				daily[i] += val;
				sumChg += Math.abs(val);
			}
			// System.out.println(td.getTicker());
		}
		final double avgChg = sumChg / days;
		double sum = 0;
		for (final double d : daily) {
			sum += d;
		}
		final double avg = sum / days;
		final double retVal = avg / avgChg;
		return retVal;
	}

}
