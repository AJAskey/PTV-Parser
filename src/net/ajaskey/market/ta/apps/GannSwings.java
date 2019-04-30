
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
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
public class GannSwings {

	static private DailyData	ddStart;
	static private DailyData	ddStop;

	private static int		rangeCal;
	private static int		rangeTd;
	private static double	priceRng;

	/**
	 * net.ajaskey.market.ta.apps.addCalendarDays
	 *
	 * @param stop
	 * @param i
	 */
	private static Calendar getCalendarDate(final Calendar cal, final int i) {

		final Calendar c = (Calendar) cal.clone();
		c.add(Calendar.DAY_OF_YEAR, i);
		return c;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.getTradingDays
	 *
	 * @param cal
	 * @param knt
	 * @return
	 */
	static private Calendar getTradingDate(final Calendar cal, final int knt) {

		final int tradingDays = (int) Math.round((knt * 7.0) / 5.0);
		return GannSwings.getCalendarDate(cal, tradingDays);
	}

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException, ParseException {

		final TickerData td = ParseData.parseOneFile("out\\QQQ.txt");
		td.generateDerived(false);

		final Calendar start = Calendar.getInstance();
		start.set(2015, Calendar.JULY, 20, 0, 0, 1);

		final Calendar stop = Calendar.getInstance();
		stop.set(2015, Calendar.AUGUST, 25, 0, 0, 1);

		GannSwings.setBounds(td, start, stop);

		System.out.println(rangeCal + "  " + rangeTd + "  " + priceRng);

		final double incs = 4.0;
		double dateInc = rangeCal / incs;

		final Calendar[] dates = new Calendar[(int) (incs * 4)];

		double rDate = dateInc;
		System.out.println(dateInc);
		for (int i = 0; i < (incs * 4); i++) {
			dates[i] = GannSwings.getCalendarDate(stop, (int) Math.round(rDate));
			rDate += dateInc;
			System.out.println(i + 1 + "  " + Utils.stringDate2(dates[i]));
		}

		dateInc = rangeTd / incs;
		rDate = dateInc;
		System.out.println(dateInc);
		for (int i = 0; i < (incs * 4); i++) {
			dates[i] = GannSwings.getTradingDate(stop, (int) Math.round(rDate));
			rDate += dateInc;
			System.out.println(i + 1 + "  " + Utils.stringDate2(dates[i]));
		}

		System.out.println("Done.");

	}

	static private void setBounds(final TickerData td, final Calendar start, final Calendar stop) {

		final SimpleDateFormat sdf = new SimpleDateFormat("E dd-MMM-yyyy");

		String s = sdf.format(start.getTime());
		System.out.println(s);
		ddStart = TickerData.getDataOfDate(td, start);
		s = sdf.format(ddStart.getDate().getTime());
		System.out.println(s);

		s = sdf.format(stop.getTime());
		System.out.println(s);
		ddStop = TickerData.getDataOfDate(td, stop);
		s = sdf.format(ddStop.getDate().getTime());
		System.out.println(s);

		rangeCal = (int) Utils.getTimeSpan(ddStop.getDate(), ddStart.getDate()) + 1;
		rangeTd = TickerData.getTradingDays(td, ddStart.getDate(), ddStop.getDate());
		priceRng = Math.abs(ddStart.getClose() - ddStop.getClose());

	}

}
