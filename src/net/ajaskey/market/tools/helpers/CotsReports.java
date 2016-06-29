
package net.ajaskey.market.tools.helpers;

import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
public class CotsReports {

	private static final String	TAB	= "\t";
	private static final String	NL	= System.getProperty("line.separator");

	public static void writeSummary(List<LongShort> list, LongShort.SourceType st, Calendar cal) {
		LongShort oi = null;
		LongShort dealer = null;
		LongShort pm = null;
		LongShort levered = null;
		LongShort other = null;
		LongShort nonrpt = null;
		long totLongs = 0;
		long totShorts = 0;
		long totSpread = 0;
		int knt = 0;
		for (final LongShort ls : list) {
			if (ls.source == st) {
				if (Utils.sameDate(ls.date, cal)) {
					String str = String.format("%6.2f", ls.pc);
					System.out.println(Utils.stringDate(ls.date) + TAB + ls.source + TAB + ls.type + TAB + ls.longPos + TAB
					    + ls.shortPos + TAB + ls.spreadPos + TAB + str);

					switch (ls.type) {
						case DEALER:
						case LEVERED:
						case NONRPT:
						case OTHER:
						case PM:
							totLongs += ls.longPos;
							totShorts += ls.shortPos;
							totSpread += ls.spreadPos;
							break;
						default:
							break;

					}

					switch (ls.type) {
						case OI:
							oi = ls;
							knt++;
							break;
						case DEALER:
							dealer = ls;
							knt++;
							break;
						case PM:
							pm = ls;
							knt++;
							break;
						case LEVERED:
							levered = ls;
							knt++;
							break;
						case OTHER:
							other = ls;
							knt++;
							break;
						case NONRPT:
							nonrpt = ls;
							knt++;
							break;
						default:
							break;
					}

				}
			}
		}
		if (knt == 6) {
			double totPC = (double) totShorts / (double) totLongs;
			System.out.println(NL);
			System.out.printf("%s OI : %d  Spread Positions : %d%n", st, oi.longPos, totSpread);
			System.out.printf("%19sLong      Short    Short/Long  %%-Longs    %%-Shorts %n", " ");
			String fmt = "%-10s : %10d %10d %10.2f %10.2f%% %10.2f%% %n";
			double percl = (double) dealer.longPos / (double) totLongs * 100.0;
			double percs = (double) dealer.shortPos / (double) totShorts * 100.0;
			System.out.printf(fmt, dealer.type, dealer.longPos, dealer.shortPos, dealer.pc, percl, percs);
			percl = (double) pm.longPos / (double) totLongs * 100.0;
			percs = (double) pm.shortPos / (double) totShorts * 100.0;
			System.out.printf(fmt, pm.type, pm.longPos, pm.shortPos, pm.pc, percl, percs);
			percl = (double) levered.longPos / (double) totLongs * 100.0;
			percs = (double) levered.shortPos / (double) totShorts * 100.0;
			System.out.printf(fmt, levered.type, levered.longPos, levered.shortPos, levered.pc, percl, percs);
			percl = (double) other.longPos / (double) totLongs * 100.0;
			percs = (double) other.shortPos / (double) totShorts * 100.0;
			System.out.printf(fmt, other.type, other.longPos, other.shortPos, other.pc, percl, percs);
			percl = (double) nonrpt.longPos / (double) totLongs * 100.0;
			percs = (double) nonrpt.shortPos / (double) totShorts * 100.0;
			System.out.printf(fmt, nonrpt.type, nonrpt.longPos, nonrpt.shortPos, nonrpt.pc, percl, percs);
			percl = 100.0;
			percs = 100.0;
			System.out.printf(fmt, "Total", totLongs, totShorts, totPC, percl, percs);
		} else {
			System.out.println("Error - writeSummry() invalid data!");
		}
	}

}
