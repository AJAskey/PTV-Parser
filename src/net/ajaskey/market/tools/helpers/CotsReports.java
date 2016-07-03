
package net.ajaskey.market.tools.helpers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

	private static final String	TAB					= "\t";
	private static final String	NL					= System.getProperty("line.separator");

	private static List<String>	csvOI				= new ArrayList<>();
	private static List<String>	csvDealer		= new ArrayList<>();
	private static List<String>	csvPM				= new ArrayList<>();
	private static List<String>	csvLevered	= new ArrayList<>();
	private static List<String>	csvOther		= new ArrayList<>();
	private static List<String>	csvNonrpt		= new ArrayList<>();
	private static List<String>	csvCombined	= new ArrayList<>();

	private static String				rptPrefix		= "";

	/**
	 *
	 * net.ajaskey.market.tools.helpers.dumpRaw
	 *
	 * @param list
	 */
	public static void dumpRaw(List<LongShort> list) {
		for (final LongShort ls : list) {
			System.out.println(ls);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.printCsvCombined
	 *
	 * @param list
	 * @param mt
	 * @throws FileNotFoundException
	 */
	private static void printCsvCombined(List<LongShort> list, LongShort.MarketType mt) throws FileNotFoundException {

		final PrintWriter pwCombined = new PrintWriter("out\\" + rptPrefix + mt + "-combo-data.csv");

		CotsReports.writeCsvHeader(pwCombined);

		final double oi = 0.0;

		long totLong = 0;
		long totShort = 0;
		long totSpread = 0;

		csvCombined.clear();

		Calendar prevCal = list.get(0).date;

		for (final LongShort ls : list) {

			if (ls.type == mt) {

				totLong += ls.longPos;
				totShort += ls.shortPos;
				totSpread += ls.spreadPos;

				// System.out.println("Adding " + ls.source + TAB + ls.type + TAB +
				// Utils.stringDate(ls.date));

			}
			if (prevCal.after(ls.date)) {
				final LongShort theLs = new LongShort(totLong, totShort, totSpread, ls.date, LongShort.MarketType.TOTALS, ls.source);
				theLs.date = prevCal;
				CotsReports.writeCsvData(csvCombined, theLs, oi);
				prevCal = ls.date;
				totLong = 0;
				totShort = 0;
				totSpread = 0;

			}
		}

		final LongShort theLs = new LongShort(totLong, totShort, totSpread, prevCal, LongShort.MarketType.TOTALS, null);
		theLs.date = prevCal;
		CotsReports.writeCsvData(csvCombined, theLs, oi);

		Collections.reverse(csvCombined);
		for (final String s : csvCombined) {
			pwCombined.print(s);
		}

		pwCombined.close();
	}

	/**
	 * net.ajaskey.market.tools.helpers.printSummary
	 *
	 * @param fmt
	 * @param type
	 * @param longPos
	 * @param shortPos
	 * @param pc
	 * @param percl
	 * @param percs
	 * @param perct
	 */
	private static void printSummary(PrintWriter pw, LongShort ls, long totLongs, long totShorts) {

		final String fmt = "%-10s : %10s %10s %10.2f %10.2f%% %10.2f%%  %10.2f%% %n";
		final double percl = ((double) ls.longPos / (double) totLongs) * 100.0;
		final double percs = ((double) ls.shortPos / (double) totShorts) * 100.0;
		final double perct = (percl + percs) / 2.0;
		pw.printf(fmt, ls.type, Utils.formatInt(ls.longPos), Utils.formatInt(ls.shortPos), ls.pc, percl, percs, perct);
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeSpreadsheets
	 *
	 * @param list
	 * @param st
	 * @throws FileNotFoundException
	 */
	public static void writeCsv(List<LongShort> list, LongShort.SourceType st) throws FileNotFoundException {
		final PrintWriter pwOI = new PrintWriter("out\\" + rptPrefix + st + "-oi-data.csv");
		final PrintWriter pwDealer = new PrintWriter("out\\" + rptPrefix + st + "-dealer-data.csv");
		final PrintWriter pwPM = new PrintWriter("out\\" + rptPrefix + st + "-pm-data.csv");
		final PrintWriter pwLevered = new PrintWriter("out\\" + rptPrefix + st + "-levered-data.csv");
		final PrintWriter pwNonrpt = new PrintWriter("out\\" + rptPrefix + st + "-nonrpt-data.csv");
		final PrintWriter pwOther = new PrintWriter("out\\" + rptPrefix + st + "-other-data.csv");

		pwOI.println("Date\tOI");
		CotsReports.writeCsvHeader(pwDealer);
		CotsReports.writeCsvHeader(pwPM);
		CotsReports.writeCsvHeader(pwLevered);
		CotsReports.writeCsvHeader(pwNonrpt);
		CotsReports.writeCsvHeader(pwOther);

		csvOI.clear();
		csvDealer.clear();
		csvPM.clear();
		csvLevered.clear();
		csvOther.clear();
		csvNonrpt.clear();

		double oi = 0.0;

		for (final LongShort ls : list) {
			if (ls.source == st) {

				switch (ls.type) {
					case OI: // needs to be first in data group, always is so far
						oi = ls.longPos;
						final String str = String.format("%10s,%10d%n", Utils.getString(ls.date), ls.longPos);
						csvOI.add(str);
						break;
					case DEALER:
						CotsReports.writeCsvData(csvDealer, ls, oi);
						break;
					case LEVERED:
						CotsReports.writeCsvData(csvLevered, ls, oi);
						break;
					case NONRPT:
						CotsReports.writeCsvData(csvNonrpt, ls, oi);
						break;
					case OTHER:
						CotsReports.writeCsvData(csvOther, ls, oi);
						break;
					case PM:
						CotsReports.writeCsvData(csvPM, ls, oi);
						break;
					default:
						break;

				}
			}
		}

		Collections.reverse(csvOI);
		Collections.reverse(csvDealer);
		Collections.reverse(csvPM);
		Collections.reverse(csvLevered);
		Collections.reverse(csvOther);
		Collections.reverse(csvNonrpt);

		for (final String s : csvOI) {
			pwOI.print(s);
		}

		for (final String s : csvDealer) {
			pwDealer.print(s);
		}

		for (final String s : csvPM) {
			pwPM.print(s);
		}

		for (final String s : csvLevered) {
			pwLevered.print(s);
		}

		for (final String s : csvOther) {
			pwOther.print(s);
		}

		for (final String s : csvNonrpt) {
			pwNonrpt.print(s);
		}

		pwOI.close();
		pwDealer.close();
		pwPM.close();
		pwLevered.close();
		pwNonrpt.close();
		pwOther.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeCsvCombined
	 *
	 * @param list
	 * @throws FileNotFoundException
	 */
	public static void writeCsvCombined(List<LongShort> list) throws FileNotFoundException {
		CotsReports.printCsvCombined(CotsData.dataPoints, LongShort.MarketType.DEALER);
		CotsReports.printCsvCombined(CotsData.dataPoints, LongShort.MarketType.PM);
		CotsReports.printCsvCombined(CotsData.dataPoints, LongShort.MarketType.LEVERED);
		CotsReports.printCsvCombined(CotsData.dataPoints, LongShort.MarketType.OTHER);
		CotsReports.printCsvCombined(CotsData.dataPoints, LongShort.MarketType.NONRPT);
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeSpreadSheetData
	 *
	 * @param pw
	 * @param ls
	 * @param oi
	 */
	private static void writeCsvData(List<String> csvList, LongShort ls, double oi) {
		double percOIlong = 0.0;
		double percOIshort = 0.0;
		double percOIspread = 0.0;

		if (oi > 0.0) {
			percOIlong = ls.longPos / oi;
			percOIshort = ls.shortPos / oi;
			percOIspread = ls.spreadPos / oi;
		}
		final long delta = ls.longPos - ls.shortPos;
		final String str = String.format("%10s,%10d,%10d,%10d,%10d,%10.2f,%10.2f,%10.2f,%10.2f%n", Utils.getString(ls.date),
		    ls.longPos, ls.shortPos, ls.spreadPos, delta, ls.pc, percOIlong, percOIshort, percOIspread);
		csvList.add(str);

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeSpreadSheetHeader
	 *
	 * @param pw
	 */
	private static void writeCsvHeader(PrintWriter pw) {
		pw.println("Date,Long,Short,Spread,Long-Short,ShortToLong,PercentLong,PercentShort,PercentSpread");
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeSummary
	 *
	 * @param list
	 * @param st
	 * @param cal
	 * @throws FileNotFoundException
	 */
	public static void writeSummary(List<LongShort> list, LongShort.SourceType st, Calendar cal)
	    throws FileNotFoundException {

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
		boolean complete = false;

		try (PrintWriter pw = new PrintWriter("out\\" + rptPrefix + st + "-cots-summary.txt")) {
			for (final LongShort ls : list) {

				// System.out.println(ls.source);

				if ((!complete) && (ls.source == st)) {

					if (Utils.sameDate(ls.date, cal)) {

						String.format("%6.2f", ls.pc);

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
								complete = true;
								break;
							default:
								break;
						}

					}
				}
			}
			if (knt == 6) {
				// System.out.println(NL);
				final double perc = ((double) totSpread / (double) oi.longPos) * 100.0;

				pw.printf("%s OI : %s  Spread Positions : %s  %6.1f%%   %s %n", st, Utils.formatInt(oi.longPos),
				    Utils.formatInt(totSpread), perc, Utils.getString(oi.date));

				pw.printf("%18sLong       Short    Short/Long  %%-Longs    %%-Shorts      %%-Total %n", " ");

				CotsReports.printSummary(pw, dealer, totLongs, totShorts);

				CotsReports.printSummary(pw, pm, totLongs, totShorts);

				CotsReports.printSummary(pw, levered, totLongs, totShorts);

				CotsReports.printSummary(pw, other, totLongs, totShorts);

				CotsReports.printSummary(pw, nonrpt, totLongs, totShorts);

				CotsReports.printSummary(pw, new LongShort(totLongs, totShorts, 0, cal, LongShort.MarketType.TOTALS, null), totLongs,
				    totShorts);

			} else {
				System.out.println("Error - writeSummary() invalid data!");
			}
		}
	}

	public static String getRptPrefix() {
		return rptPrefix;
	}

	public static void setRptPrefix(String rptPrefix) {
		CotsReports.rptPrefix = rptPrefix;
	}

}
