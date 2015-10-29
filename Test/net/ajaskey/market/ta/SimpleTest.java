
package net.ajaskey.market.ta;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.reports.StockHTML;

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
public class SimpleTest {

	static List<TickerData> tdAll = new ArrayList<TickerData>();

	public static void main(String[] args) throws ParseException, IOException {

		final List<String> fnames = new ArrayList<String>();
		fnames.add("C:\\Users\\ajask_000\\Documents\\EODData\\TickerLists\\INDEX.TXT");
		fnames.add("C:\\Users\\ajask_000\\Documents\\EODData\\TickerLists\\NASDAQ.TXT");
		fnames.add("C:\\Users\\ajask_000\\Documents\\EODData\\TickerLists\\AMEX.TXT");
		fnames.add("C:\\Users\\ajask_000\\Documents\\EODData\\TickerLists\\NYSE.TXT");
		TickerFullName.build(fnames);

		ParseData.setValidTicker("qqq");

		final List<String> filenames = new ArrayList<String>();
		filenames.add("C:\\Users\\ajask_000\\Documents\\EODData\\DataClient\\ASCII\\INDEX");
		filenames.add("C:\\Users\\ajask_000\\Documents\\EODData\\DataClient\\ASCII\\AMEX");
		filenames.add("C:\\Users\\ajask_000\\Documents\\EODData\\DataClient\\ASCII\\NASDAQ");
		filenames.add("C:\\Users\\ajask_000\\Documents\\EODData\\DataClient\\ASCII\\NYSE");
		tdAll = TickerData.build(filenames);

		/*
		 * for (final TickerData t : tdAll) { System.out.println("\n\n" +
		 * t.getTicker()); for (final DailyData dd : t.getData()) {
		 * System.out.println("\t" + dd.getDate().get(Calendar.DAY_OF_YEAR) + "\t" +
		 * dd.getClose()); } }
		 */

		for (final TickerData td : tdAll) {

			System.out.println("\n\n" + td.getTicker());

			for (int i = 0; i < 100; i++) {
				final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				final String dat = sdf.format(td.getData().get(i).getDate().getTime());
				// String dat = sdf.format(td.getData().get(i).getDate());
				System.out.printf("%s %.2f %.2f %.2f %.2f\n", dat, td.getOpenData()[i], td.getHighData()[i], td.getLowData()[i],
				    td.getCloseData()[i]);
			}

			System.out.println(
			    "SMA : " + td.getSma23() + "\t" + td.getSma23Trend() + "\t" + td.getSma65() + "\t" + td.getSma65Trend() + "\t"
			        + td.getSma130() + "\t" + td.getSma130Trend() + "\t" + td.getSma260() + "\t" + td.getSma260Trend());
			// System.out.println("Price : " + td.getCloseData()[0] + "\t" +
			// td.getCloseData()[23] + "\t" + td.getCloseData()[65]
			// + "\t" + td.getCloseData()[130] + "\t" + td.getCloseData()[260]);
			System.out
			    .println("Chg   : \t" + td.getChg23() + "\t" + td.getChg65() + "\t" + td.getChg130() + "\t" + td.getChg260());
			System.out.println("RS       " + td.getRsRaw());
			System.out.println("volume   : " + (int) td.getAvgVol65());
			System.out.printf("ATR      : %.2f %.2f%%\n", td.getAtr23(), td.getAtrPercent23());
			System.out.printf("MFI      : %.2f %.2f %.2f %.2f \n", td.getMfi14(), td.getMfi23(), td.getMfi65(),
			    td.getMfi130());
			System.out.printf("Off      : %.2f %.2f %.2f\n", td.getPriceInRng260(), td.getPriceOffLow260(),
			    td.getPriceOffHigh260());
			System.out.printf("High/Low : %.2f %.2f %.2f\n", td.getHigh260(), td.getCurrentPrice(), td.getLow260());
			System.out.printf("LR       : %.2f %.2f %.2f %.5f\n", td.getLr260(), td.getLrAngle260(), td.getLrInt260(),
			    td.getLrSlope260());
			final double atr = td.getAtr23() * 2.5;
			System.out.printf("LR band  : %.2f %.2f %.2f\n", td.getLr260() - atr, td.getCurrentPrice(), td.getLr260() + atr);
			System.out.printf("ADX/DI   : %.2f %.2f %.2f\n", td.getAdx(), td.getDiPlus(), td.getDiMinus());

			final StockHTML html = new StockHTML();
			html.build(td);
		}

		System.out.println("Done.");
	}
}
