
package net.ajaskey.market.tools.optuma;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.Utils;
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
	//private final static SimpleDateFormat	sdf						= new SimpleDateFormat("yyyy-MM-dd");

	private static List<TickerData> tdList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.optuma.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {

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
		
		ParseData.setValidTicker("ADDN.IDX");
		ParseData.setValidTicker("ADDQ.IDX");		
		ParseData.setValidTicker("AVDN.IDX");
		ParseData.setValidTicker("AVDQ.IDX");
		ParseData.setValidTicker("AVVN.IDX");
		ParseData.setValidTicker("AVVN.IDX");
		ParseData.setValidTicker("DVCN.IDX");

		ParseData.setValidTicker("HIGN.IDX");
		ParseData.setValidTicker("HIGQ.IDX");
		ParseData.setValidTicker("LOWN.IDX");
		ParseData.setValidTicker("LOWQ.IDX");

		ParseData.setValidTicker("MMTW.IDX"); 
		ParseData.setValidTicker("MMFI.IDX");
		ParseData.setValidTicker("MMOH.IDX");
		ParseData.setValidTicker("MMTH.IDX");

		ParseData.setValidTicker("S5TW.IDX");
		ParseData.setValidTicker("S5FI.IDX");
		ParseData.setValidTicker("S5OH.IDX");
		ParseData.setValidTicker("S5TH.IDX");

		filenames.clear();
		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\INDEX");

		fullfilenames.add("symbols\\INDEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		TickerData.clearTickerData(tdList);
		tdList = ParseData.parseFiles(filenames, 3000);

		final String outdir = OptumaCommon.optumaPath + "\\EOD-Data\\";

		for (final TickerData td : tdList) {
			System.out.println(td.getTicker() + "\t" + td.getTickerName());
			try (PrintWriter pw = new PrintWriter(outdir + td.getTicker() + ".csv")) {
				td.generateDerived(true);
				td.printOptuma(pw);
			}
		}
	}

}
