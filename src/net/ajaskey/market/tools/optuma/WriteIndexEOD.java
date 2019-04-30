
package net.ajaskey.market.tools.optuma;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.LongTermOHLCV;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class WriteIndexEOD {

	private final static List<String>	filenames			= new ArrayList<>();
	private final static List<String>	fullfilenames	= new ArrayList<>();

	private static List<TickerData> tdList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.optuma.fixBadData
	 *
	 * @param td
	 */
	private static void fixBadData(final TickerData td) {

		if (td.getTicker().equalsIgnoreCase("CPR.IDX")) {
			System.out.println("Fixing " + td.getTicker());
			DailyData prev = null;
			for (final DailyData dd : td.getData()) {
				if (prev != null) {
					if ((dd.getOpen() > 10.0) || (dd.getHigh() > 10.0) || (dd.getLow() > 10.0) || (dd.getClose() > 10.0)) {
						dd.resetOpen(prev.getOpen());
						dd.resetHigh(prev.getHigh());
						dd.resetLow(prev.getLow());
						dd.resetClose(prev.getClose());
					}
				}
				prev = dd;
			}
		}

	}

	//	private static void getNewData() {
	//
	//		final File allFiles = new File("C:\\Users\\ajask\\Downloads");
	//		final File[] listOfFiles = allFiles.listFiles();
	//
	//		for (final File file : listOfFiles) {
	//			if (file.isFile()) {
	//				final Path path = file.toPath();
	//				System.out.println(path);
	//			}
	//		}
	//	}

	/**
	 * net.ajaskey.market.tools.optuma.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws ParseException, IOException {

		//WriteIndexEOD.getNewData();

		WriteIndexEOD.processIndex();

		WriteStockData.main(args);

		LongTermOHLCV.main(args);
	}

	private static void processIndex() throws ParseException, IOException {

		ParseData.clearValidTickers();

		ParseData.setValidTickers(ParseData.getTickerList("lists\\eod-list.txt"));

		ParseData.setValidTicker("TACK.IDX");
		ParseData.setValidTicker("TACX.IDX");
		ParseData.setValidTicker("TQCK.IDX");
		ParseData.setValidTicker("TQCX.IDX");
		ParseData.setValidTicker("TICK.IDX");
		ParseData.setValidTicker("TICX.IDX");

		ParseData.setValidTicker("HIGN.IDX");
		ParseData.setValidTicker("HIGQ.IDX");
		ParseData.setValidTicker("LOWN.IDX");
		ParseData.setValidTicker("LOWQ.IDX");

		ParseData.setValidTicker("MMTW.IDX");
		ParseData.setValidTicker("MMFI.IDX");
		ParseData.setValidTicker("MMOH.IDX");
		ParseData.setValidTicker("MMOF.IDX");
		ParseData.setValidTicker("MMTH.IDX");

		ParseData.setValidTicker("S5TW.IDX");
		ParseData.setValidTicker("S5FI.IDX");
		ParseData.setValidTicker("S5OH.IDX");
		ParseData.setValidTicker("S5TH.IDX");

		filenames.clear();
		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\INDEX");
		filenames.add(dataPath + "\\ASCII\\AMEX");
		filenames.add(dataPath + "\\ASCII\\CME");
		filenames.add(dataPath + "\\ASCII\\COMEX");
		filenames.add(dataPath + "\\ASCII\\NYMEX");

		fullfilenames.add("symbols\\INDEX_SymbolList.txt");
		fullfilenames.add("symbols\\AMEX_SymbolList.txt");
		fullfilenames.add("symbols\\CME_SymbolList.txt");
		fullfilenames.add("symbols\\COMEX_SymbolList.txt");
		fullfilenames.add("symbols\\NYMEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		TickerData.clearTickerData(tdList);
		tdList = ParseData.parseFiles(filenames, 3000);

		final String outdir = OptumaCommon.optumaPath + "\\EOD-Data\\";

		for (final TickerData td : tdList) {
			System.out.println(td.getTicker() + "\t" + td.getTickerName());
			final String tn = td.getTicker();
			if (tn != null) {
				String nm = TickerFullName.getName(tn);
				if (nm == null) {
					nm = "Unknown";
				}
				WriteIndexEOD.fixBadData(td);
				final String tname = tn.replace(".IDX", "");
				final String nm2 = nm.replace("/", "_");
				final String fname = "[" + tname + "] - " + nm2;
				//System.out.println(fname);
				try (PrintWriter pw = new PrintWriter(outdir + fname + ".csv"); PrintWriter pw2 = new PrintWriter(outdir + tn + ".csv")) {
					td.generateDerived(true);
					td.printOptuma(pw);
					td.printOptuma(pw2);
				}
			}
		}
	}

}
