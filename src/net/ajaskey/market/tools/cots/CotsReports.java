
package net.ajaskey.market.tools.cots;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.input.SpxLongTermPrices;

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

	/**
	 *
	 * net.ajaskey.market.tools.helpers.dumpRaw
	 *
	 * @param list
	 */
	public static void dumpRaw() {
		for (final CotsData cd : CotsData.cotsList) {
			System.out.println(cd);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeAllCsv
	 *
	 * @param source
	 * @param outputPath
	 * @throws FileNotFoundException
	 */
	public static void writeAllCsv(String source, String outputPath, List<SpxLongTermPrices> spx)
	    throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(outputPath + "\\" + source + "combined.csv")) {

			pw.println("Date,OI,Dealer,PM,Levered,Other,NonRpt,Hedged,Specs,SPX,");

			for (final CotsData cd : CotsData.cotsList) {

				String price;
				try {
					price = SpxLongTermPrices.getClose(cd.date);
				} catch (final Exception e) {
					price = "";
				}

				pw.printf("%s,%d,%d,%d,%d,%d,%d,%d,%d,%s%n", Utils.getString(cd.date), cd.oi, cd.dealer.delta, cd.pm.delta,
				    cd.levered.delta, cd.other.delta, cd.nonrpt.delta, (cd.pm.delta + cd.other.delta),
				    (cd.levered.delta + cd.nonrpt.delta), price);
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeCsv
	 *
	 * @param prefix
	 * @param outputPath
	 * @throws FileNotFoundException
	 */
	public static void writeCsv(String prefix, String outputPath) throws FileNotFoundException {

		try (PrintWriter pwOI = new PrintWriter(outputPath + "\\" + prefix + "oi-data.csv");
		    PrintWriter pwDealer = new PrintWriter(outputPath + "\\" + prefix + "dealer-data.csv");
		    PrintWriter pwPM = new PrintWriter(outputPath + "\\" + prefix + "pm-data.csv");
		    PrintWriter pwLevered = new PrintWriter(outputPath + "\\" + prefix + "levered-data.csv");
		    PrintWriter pwNonrpt = new PrintWriter(outputPath + "\\" + prefix + "nonrpt-data.csv");
		    PrintWriter pwOther = new PrintWriter(outputPath + "\\" + prefix + "other-data.csv")) {

			pwOI.println("Date\tOI");
			CotsReports.writeCsvHeader(pwDealer);
			CotsReports.writeCsvHeader(pwPM);
			CotsReports.writeCsvHeader(pwLevered);
			CotsReports.writeCsvHeader(pwNonrpt);
			CotsReports.writeCsvHeader(pwOther);

			for (final CotsData cd : CotsData.cotsList) {
				pwOI.printf("%10s,%10d%n", Utils.getString(cd.date), cd.oi);
				pwDealer.printf("%s", CotsReports.formatCsvData(cd.dealer, cd.oi));
				pwPM.printf("%s", CotsReports.formatCsvData(cd.pm, cd.oi));
				pwLevered.printf("%s", CotsReports.formatCsvData(cd.levered, cd.oi));
				pwOther.printf("%s", CotsReports.formatCsvData(cd.other, cd.oi));
				pwNonrpt.printf("%s", CotsReports.formatCsvData(cd.nonrpt, cd.oi));

			}
		}
	}

	/**
	 * net.ajaskey.market.tools.helpers.writeOptuma
	 *
	 * @param prefix
	 * @param outputpath
	 * @throws FileNotFoundException
	 */
	public static void writeOptuma(String prefix, String outputPath) throws FileNotFoundException {

		final String header = "Date,Long,Short,Net";
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try (PrintWriter pwDealer = new PrintWriter(outputPath + "\\" + prefix + "dealer-optuma.csv");
		    PrintWriter pwPM = new PrintWriter(outputPath + "\\" + prefix + "pm-optuma.csv");
		    PrintWriter pwLevered = new PrintWriter(outputPath + "\\" + prefix + "levered-optuma.csv");
		    PrintWriter pwNonrpt = new PrintWriter(outputPath + "\\" + prefix + "nonrpt-optuma.csv");
		    PrintWriter pwOther = new PrintWriter(outputPath + "\\" + prefix + "other-optuma.csv");
		    PrintWriter pwHedged = new PrintWriter(outputPath + "\\" + prefix + "hedged-optuma.csv");
		    PrintWriter pwSpecs = new PrintWriter(outputPath + "\\" + prefix + "specs-optuma.csv")) {

			pwDealer.println(header);
			pwPM.println(header);
			pwLevered.println(header);
			pwNonrpt.println(header);
			pwOther.println(header);

			for (final CotsData cd : CotsData.cotsList) {
				final String theDate = sdf.format(cd.date.getTime());
				pwDealer.printf("%s,%d,%d,%d%n", theDate, cd.dealer.longPos, cd.dealer.shortPos, cd.dealer.delta);
				pwPM.printf("%s,%d,%d,%d%n", theDate, cd.pm.longPos, cd.pm.shortPos, cd.pm.delta);
				pwLevered.printf("%s,%d,%d,%d%n", theDate, cd.levered.longPos, cd.levered.shortPos, cd.levered.delta);
				pwNonrpt.printf("%s,%d,%d,%d%n", theDate, cd.nonrpt.longPos, cd.nonrpt.shortPos, cd.nonrpt.delta);
				pwOther.printf("%s,%d,%d,%d%n", theDate, cd.other.longPos, cd.other.shortPos, cd.other.delta);

				final long hedgedLong = cd.pm.longPos + cd.other.longPos;
				final long hedgedShort = cd.pm.shortPos + cd.other.shortPos;
				final long hedgedDelta = hedgedLong - hedgedShort;
				pwHedged.printf("%s,%d,%d,%d%n", theDate, hedgedLong, hedgedShort, hedgedDelta);

				final long specLong = cd.levered.longPos + cd.nonrpt.longPos;
				final long specShort = cd.levered.shortPos + cd.nonrpt.shortPos;
				final long specDelta = specLong - specShort;
				pwSpecs.printf("%s,%d,%d,%d%n", theDate, specLong, specShort, specDelta);
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeSummary
	 *
	 * @param st
	 * @param cal
	 * @throws FileNotFoundException
	 */
	public static void writeSummary(String outputPath, String rptPrefix, Calendar cal) throws FileNotFoundException {

		final CotsData cd = CotsData.findDate(cal);

		if (cd != null) {
			try (PrintWriter pw = new PrintWriter(
			    outputPath + "/" + rptPrefix + Utils.getString(cd.date) + "-cots-summary.txt")) {

				pw.printf("OI : %s  Spread Positions : %s  %s %n", Utils.formatInt(cd.oi), Utils.formatInt(cd.totalSpread),
				    Utils.getString(cd.date));
				pw.printf("%18sLong       Short    Short/Long   Delta     %%-Longs    %%-Shorts      %%-Total %n", " ");

				CotsReports.printSummary(pw, cd.dealer, cd.totalLong, cd.totalShort);
				CotsReports.printSummary(pw, cd.pm, cd.totalLong, cd.totalShort);
				CotsReports.printSummary(pw, cd.levered, cd.totalLong, cd.totalShort);
				CotsReports.printSummary(pw, cd.other, cd.totalLong, cd.totalShort);
				CotsReports.printSummary(pw, cd.nonrpt, cd.totalLong, cd.totalShort);

			}
		} else {
			System.out.println(Utils.getString(cal) + " not found.");
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.formatCsvData
	 *
	 * @param ls
	 * @param oi
	 * @return
	 */
	private static String formatCsvData(LongShort ls, double oi) {
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
		return str;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.printSummary
	 *
	 * @param pw
	 * @param ls
	 * @param totLongs
	 * @param totShorts
	 */
	private static void printSummary(PrintWriter pw, LongShort ls, long totLongs, long totShorts) {

		final String fmt = "%-10s : %10s %10s %10.2f %10s %10.2f%% %10.2f%%  %10.2f%% %n";
		final double percl = ((double) ls.longPos / (double) totLongs) * 100.0;
		final double percs = ((double) ls.shortPos / (double) totShorts) * 100.0;
		final double perct = (percl + percs) / 2.0;
		pw.printf(fmt, ls.type, Utils.formatInt(ls.longPos), Utils.formatInt(ls.shortPos), ls.pc, Utils.formatInt(ls.delta),
		    percl, percs, perct);
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.writeCsvHeader
	 *
	 * @param pw
	 */
	private static void writeCsvHeader(PrintWriter pw) {
		pw.println("Date,Long,Short,Spread,Long-Short,ShortToLong,PercentLong,PercentShort,PercentSpread");
	}

}
