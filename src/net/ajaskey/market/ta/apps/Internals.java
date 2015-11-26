
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.Utils;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.methods.UtilMethods;

/**
 * This application generates market breadth data.
 *
 * @author
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
public class Internals {

	final static double							obosLevel	= 400.0;

	private static List<String>			filenames	= new ArrayList<String>();
	private static List<TickerData>	tdList		= new ArrayList<>();
	public static PrintWriter				pwAll			= null;
	private static final int				MILLION		= 1000000;

	private static double						ndxClose;
	private static double						spxClose;
	private static double						smlClose;
	private static double						ndxClosePast;
	private static double						spxClosePast;
	private static double						smlClosePast;

	/**
	 *
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) {

		System.out.println("Processing...");

		try {
			final int days = 10;
			Internals.getClosingPrices(days);

			pwAll = new PrintWriter("out\\breadth.txt");

			Internals.processIndex();

			Internals.processAnIndex("lists\\sp500-list.txt", "SPX");
			Internals.processAnIndex("lists\\sp600-list.txt", "SML");
			Internals.processAnIndex("lists\\nasdaq100-list.txt", "NDX");
			Internals.processAnIndex("lists\\stock-list.txt", "Stocks");
			Internals.processAnIndex("lists\\etf-list-mod.txt", "ETF");

			double val = Internals.processListPercent("lists\\sp500-list.txt", days);
			System.out.printf("SPX days to recover %.2f%n", val);
			val = Internals.processListPercent("lists\\nasdaq100-list.txt", days);
			System.out.printf("NDX days to recover %.2f%n", val);

			Internals.printBreath("lists\\sp500-list.txt", "SPX", days);
			Internals.printBreath("lists\\nasdaq100-list.txt", "NDX", days);
			Internals.printBreath("lists\\sp600-list.txt", "SML", days);
			Internals.printBreath("lists\\stock-list.txt", "STOCKS - Over $10 and 500k volume", days);
			//Internals.printBreath("lists\\etf-list-mod.txt", "ETF", days);

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		pwAll.close();
		System.out.println("Internals Done.");

	}

	private static void getClosingPrices(int days) throws FileNotFoundException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTicker("SPX.IDX");
		ParseData.setValidTicker("NDX.IDX");
		ParseData.setValidTicker("SML.IDX");

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\INDEX");

		TickerData.clearTickerData(tdList);
		tdList = ParseData.parseFiles(filenames, 50);

		final TickerData spx = TickerData.getTickerData(tdList, "SPX.IDX");
		if (spx != null) {
			spx.generateDerived();
			spxClose = spx.getCurrentPrice();
			spxClosePast = spx.getClose(days);
			// System.out.println(spxClose);
		}

		final TickerData ndx = TickerData.getTickerData(tdList, "NDX.IDX");
		if (ndx != null) {
			ndx.generateDerived();
			ndxClose = ndx.getCurrentPrice();
			ndxClosePast = ndx.getClose(days);
			// System.out.println(ndxClose);
		}

		final TickerData sml = TickerData.getTickerData(tdList, "SML.IDX");
		if (sml != null) {
			sml.generateDerived();
			smlClose = sml.getCurrentPrice();
			smlClosePast = sml.getClose(days);
			// System.out.println(smlClose);
		}

		TickerData.clearTickerData(tdList);

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
		double sum = 0;
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

	private static void printBreath(String list, String listName, int days)
	    throws FileNotFoundException, IOException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList(list));

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");
		filenames.add(dataPath + "\\ASCII\\AMEX");

		final int tdays = ((days * 7) / 5) + 1;
		final int dataDays = Math.max(30, (int) (tdays * 3.25));

		tdList.clear();
		tdList = ParseData.parseFiles(filenames, dataDays);

		final int[] up = new int[days];
		final int[] down = new int[days];
		final int[] daily = new int[days];
		final long[] volUp = new long[days];
		final long[] volDown = new long[days];
		final double[] forceUp = new double[days];
		final double[] forceDown = new double[days];
		final double[] price = new double[days];
		final double[] vol = new double[days];
		for (int i = 0; i < days; i++) {
			up[i] = 0;
			down[i] = 0;
			daily[i] = 0;
			forceUp[i] = 0;
			forceDown[i] = 0;
			vol[i] = 0;
			price[i] = 0;
			volUp[i] = 0;
			volDown[i] = 0;
		}
		// double sumVol = 0;
		double priceChg = 0;
		double volume = 0;

		Calendar[] cal = null;
		for (final TickerData td : tdList) {
			td.generateDerived();
			// System.out.println(td.getTicker() + " " + td.getDaysOfData() + " " +
			// days*2);
			if (td.getDaysOfData() > (days * 3)) {
				double chg = 0;
				volume += UtilMethods.sma(td.getVolumeData(), days * 3);
				for (int i = 0; i < days; i++) {
					chg = (td.getClose(i) - td.getClose(i + 1)) / td.getClose(i + 1);
					priceChg = td.getClose(i) - td.getClose(i + 1);
					final double val = Math.abs(chg * td.getAvgVol20());
					if (chg > 0.0) {
						daily[i]++;
						up[i]++;
						forceUp[i] += val;
						volUp[i] += (long) td.getVolume(i);
					} else if (chg < 0.0) {
						daily[i]--;
						down[i]++;
						forceDown[i] += val;
						volDown[i] += (long) td.getVolume(i);
					}
					vol[i] += td.getVolume(i);
					price[i] += priceChg;
				}
				if (cal == null) {
					cal = new Calendar[days];
					for (int i = 0; i < days; i++) {
						cal[i] = td.getDate(i);
					}
				}
			}
		}

		if (cal == null) {
			System.out.println("ERROR cal == null");
			return;
		}

		Utils.makeDir("out");
		double cumForce = 0;
		pwAll.printf("\t%s%n\tChg\tUp\tDown\tDiff\tPercent\tForce\tVolUp(M)\tVolDown(M)\tvDiff(M)\tVolRatio%n", listName);
		for (int i = 0; i < days; i++) {
			final double percent = ((double) up[i] / (double) ParseData.getValidTickerCount()) * 100.0;
			final String sUp = NumberFormat.getIntegerInstance().format(up[i]);
			final String sDown = NumberFormat.getIntegerInstance().format(down[i]);
			final String sDaily = NumberFormat.getIntegerInstance().format(daily[i]);
			final String sForce = NumberFormat.getIntegerInstance().format((int) (forceUp[i] - forceDown[i]));
			// double avgVol = sumVol / (double) days;
			final double avgVol = volume;
			final double volRatio = vol[i] / avgVol;

			final long volDiff = (volUp[i] - volDown[i]) / MILLION;
			final String sVolUp = NumberFormat.getIntegerInstance().format(volUp[i] / MILLION);
			final String sVolDown = NumberFormat.getIntegerInstance().format(volDown[i] / MILLION);
			final String sVolDiff = NumberFormat.getIntegerInstance().format(volDiff);
			pwAll.printf("\t%.2f\t%s\t%s\t%s\t%.1f%%\t%s\t%s\t%s\t%s\t%.2f \t%s%n", price[i], sUp, sDown, sDaily, percent,
			    sForce, sVolUp, sVolDown, sVolDiff, volRatio, Utils.getString(cal[i]));

			cumForce += (forceUp[i] - forceDown[i]);
		}
		final String sCumForce = NumberFormat.getIntegerInstance().format((int) cumForce);
		final int sumUp = UtilMethods.sum(up, days);
		final int sumDown = UtilMethods.sum(down, days);
		final double pDaily = (sumUp / (double) (sumUp + sumDown)) * 100.0;

		final long sumVolUp = UtilMethods.sum(volUp, days) / MILLION;
		final long sumVolDown = UtilMethods.sum(volDown, days) / MILLION;
		final long sumVolDiff = sumVolUp - sumVolDown;
		final String sSumVolUp = NumberFormat.getIntegerInstance().format(sumVolUp);
		final String sSumVolDown = NumberFormat.getIntegerInstance().format(sumVolDown);
		final String sSumVolDiff = NumberFormat.getIntegerInstance().format(sumVolDiff);

		final double sumVol = UtilMethods.sma(vol, vol.length);
		final double volRatio = sumVol / volume;

		final double sumPrice = UtilMethods.sum(price, days);
		pwAll.printf("\t%.2f\t%d\t%d\t%d\t%.1f%%\t%s\t%s\t%s\t%s\t%.2f%n", sumPrice, sumUp, sumDown,
		    UtilMethods.sum(daily, days), pDaily, sCumForce, sSumVolUp, sSumVolDown, sSumVolDiff, volRatio);

		double currentPrice = 1.0;
		double pastPrice = 1.0;
		if (listName.contains("SPX")) {
			currentPrice = spxClose;
			pastPrice = spxClosePast;
		} else if (listName.contains("NDX")) {
			currentPrice = ndxClose;
			pastPrice = ndxClosePast;
		} else if (listName.contains("SML")) {
			currentPrice = smlClose;
			pastPrice = smlClosePast;
		}

		final double perChg = ((pastPrice - currentPrice) / pastPrice) * 100.0;
		String cmt = "Up";
		if (sumPrice < 0.0) {
			cmt = "Down";
		}
		pwAll.printf(
		    "%s %.2f Points per Component with overall change of %.2f%% from closing price %.2f which was %d days ago.%n%n",
		    cmt, sumPrice / tdList.size(), perChg, currentPrice, days + 1);

		TickerData.clearTickerData(tdList);

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
			e.printStackTrace();
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

		TickerData.clearTickerData(tdList);
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

		TickerData.clearTickerData(tdList);
		tdList = ParseData.parseFiles(filenames, Math.max(70, 50 + days));

		final int[] daily = new int[days];
		for (final TickerData td : tdList) {
			td.generateDerived();
			if (td.getDaysOfData() > days) {
				double chg = 0;
				for (int i = 0; i < days; i++) {
					chg = td.getClose(i) - td.getClose(i + 1);
					if (chg > 0.0) {
						daily[i]++;
					} else if (chg < 0.0) {
						daily[i]--;
					}
				}
			}
		}

		TickerData.clearTickerData(tdList);

		int sum = 0;
		for (final int i : daily) {
			// System.out.println(i);
			sum += i;
		}
		final double retVal = (double) sum / (double) days;
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.processListPercent
	 *
	 * @param list
	 * @param days
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static double processListPercent(String list, int days)
	    throws FileNotFoundException, IOException, ParseException {

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList(list));

		filenames.clear();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");

		TickerData.clearTickerData(tdList);
		tdList = ParseData.parseFiles(filenames, Math.max(70, 50 + days));

		final double[] daily = new double[days];
		double sumChg = 0;
		for (final TickerData td : tdList) {
			td.generateDerived();
			if (td.getDaysOfData() > days) {
				double chg = 0;
				for (int i = 0; i < days; i++) {
					chg = (td.getClose(i) - td.getClose(i + 1)) / td.getClose(i + 1);

					final double val = chg * td.getAvgVol20();
					daily[i] += val;
					sumChg += Math.abs(val);
				}
				// System.out.println(td.getTicker());
			}
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
