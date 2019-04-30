
package net.ajaskey.market.tools.smartmoney;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.tools.fred.DataValues;
import net.ajaskey.market.tools.optuma.OptumaCommon;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SmartDumbMoney {

	private static List<String>				filenames			= new ArrayList<>();
	private static List<String>				fullfilenames	= new ArrayList<>();
	private static List<SmartDumbDay>	sdDays				= new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.findSmartDumbDay
	 *
	 * @param date
	 * @return
	 */
	private static SmartDumbDay findSmartDumbDay(final Calendar date) {

		for (final SmartDumbDay sdd : sdDays) {
			if (Utils.sameDate(date, sdd.day)) {
				return sdd;
			}
		}
		return null;
	}

	public static void main(final String[] args) throws ParseException, IOException {

		final Calendar startDate = Utils.buildCalendar(2016, Calendar.DECEMBER, 24);

		fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
		fullfilenames.add("symbols\\NYSE_SymbolList.txt");
		fullfilenames.add("symbols\\AMEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");
		filenames.add(dataPath + "\\ASCII\\AMEX");

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\stock-list.txt"));

		final List<TickerData> tdAll = ParseData.parseFiles(filenames, startDate);

		if (tdAll == null) {
			return;
		}

		final Calendar today = Calendar.getInstance();
		final int todayMonth = today.get(Calendar.MONTH);
		final int todayYear = today.get(Calendar.YEAR);

		int currentMonth = startDate.get(Calendar.MONTH);
		int currentYear = startDate.get(Calendar.YEAR);

		final List<Calendar> tradingDays = SmartDumbDay.set(startDate);
		for (int i = 0; i < tradingDays.size(); i++) {

			if ((currentMonth == todayMonth) && (currentYear == todayYear)) {
				break;
			}

			final Calendar c = tradingDays.get(i);
			if (c.get(Calendar.MONTH) != currentMonth) {
				if ((i + 22) > tradingDays.size()) {
					break;
				}

				sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(i - 2)));
				sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(i - 1)));
				sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, c));
				sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(i + 1)));
				sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(i + 2)));

				currentMonth = c.get(Calendar.MONTH);
				currentYear = c.get(Calendar.YEAR);

				for (int j = i + 9; j < (i + 15); j++) {
					if (tradingDays.get(j).get(Calendar.DAY_OF_MONTH) > 14) {
						sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(j - 2)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(j - 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(j)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(j + 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.DUMB, tradingDays.get(j + 2)));
						break;
					}
				}
				for (int j = i + 5; j < (i + 9); j++) {
					if (tradingDays.get(j).get(Calendar.DAY_OF_MONTH) > 6) {
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j - 2)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j - 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j + 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j + 2)));
						break;
					}
				}
				for (int j = i + 15; j < (i + 19); j++) {
					if (tradingDays.get(j).get(Calendar.DAY_OF_MONTH) > 20) {
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j - 2)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j - 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j + 1)));
						sdDays.add(new SmartDumbDay(SmartDumbDay.SMART, tradingDays.get(j + 2)));
						break;
					}
				}
			}
		}

		for (final TickerData td : tdAll) {
			//if (td.getTicker().equalsIgnoreCase("MSFT")) {
			td.generateDerived(false);
			System.out.println(td.getTicker());
			for (final DailyData dd : td.getData()) {
				final SmartDumbDay sdd = SmartDumbMoney.findSmartDumbDay(dd.getDate());
				if (sdd != null) {
					sdd.mktcap += dd.getDailyChg() * dd.getVolume();
					//System.out.println(dd);
				}
			}
			//break;
			//}
		}

		//List<SmartDumbDays> totals = new ArrayList<>();
		double cumm = 0.0;
		final String outpath = OptumaCommon.optumaPath + "\\EOD-Data\\SmartMoney.csv";
		try (PrintWriter pw = new PrintWriter(outpath)) {
			for (final SmartDumbDay sdd : sdDays) {
				final String date = DataValues.sdf.format(sdd.day.getTime());
				if (sdd.mode == SmartDumbDay.DUMB) {
					cumm -= sdd.mktcap;
				}
				else if (sdd.mode == SmartDumbDay.SMART) {
					cumm += sdd.mktcap;
				}
				System.out.printf("%s\t%s\t%15.2f\n", sdd, date, cumm);
				pw.printf("%s,%.2f,%.2f,%.2f,%.2f,0\n", date, cumm, cumm, cumm, cumm);
			}
		}
	}
}
