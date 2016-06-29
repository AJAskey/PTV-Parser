
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.apps.helpers.DailyBreadthData;
import net.ajaskey.market.ta.input.ParseData;

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
public class DailyBreadth {

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		final List<String> filenames = new ArrayList<>();
		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\INDEX");

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\breadth.txt"));

		final List<TickerData> tdAll = ParseData.parseFiles(filenames, 80);

		// for (TickerData td : tdAll) {
		// System.out.println(td.getTicker());
		// }

		System.out.println("\tAdv\tDecl\t%Adv\tSumDiff10d\tAdvVol\tDeclVol\t%AdvVol\tSumDiff10d\t%50dVol\tHighs\tLows");

		final TickerData adva = TickerData.getTickerData(tdAll, "adva.idx");
		final TickerData avva = TickerData.getTickerData(tdAll, "avva.idx");
		final TickerData deca = TickerData.getTickerData(tdAll, "deca.idx");
		final TickerData dvca = TickerData.getTickerData(tdAll, "dvca.idx");
		final TickerData higa = TickerData.getTickerData(tdAll, "higa.idx");
		final TickerData lowa = TickerData.getTickerData(tdAll, "lowa.idx");
		final DailyBreadthData dbAmex = new DailyBreadthData(adva, deca, avva, dvca, higa, lowa);

		final TickerData advq = TickerData.getTickerData(tdAll, "advq.idx");
		final TickerData avvq = TickerData.getTickerData(tdAll, "avvq.idx");
		final TickerData decq = TickerData.getTickerData(tdAll, "decq.idx");
		final TickerData dvcq = TickerData.getTickerData(tdAll, "dvcq.idx");
		final TickerData higq = TickerData.getTickerData(tdAll, "higq.idx");
		final TickerData lowq = TickerData.getTickerData(tdAll, "lowq.idx");
		final DailyBreadthData dbNaz = new DailyBreadthData(advq, decq, avvq, dvcq, higq, lowq);

		final TickerData advn = TickerData.getTickerData(tdAll, "advn.idx");
		final TickerData avvn = TickerData.getTickerData(tdAll, "avvn.idx");
		final TickerData decn = TickerData.getTickerData(tdAll, "decn.idx");
		final TickerData dvcn = TickerData.getTickerData(tdAll, "dvcn.idx");
		final TickerData hign = TickerData.getTickerData(tdAll, "hign.idx");
		final TickerData lown = TickerData.getTickerData(tdAll, "lown.idx");
		final DailyBreadthData dbNyse = new DailyBreadthData(advn, decn, avvn, dvcn, hign, lown);

		final TickerData advt = TickerData.getTickerData(tdAll, "advt.idx");
		final TickerData avvt = TickerData.getTickerData(tdAll, "avvt.idx");
		final TickerData dect = TickerData.getTickerData(tdAll, "dect.idx");
		final TickerData dvct = TickerData.getTickerData(tdAll, "dvct.idx");
		final DailyBreadthData dbTotal = new DailyBreadthData(advt, dect, avvt, dvct, null, null);

		final TickerData advd = TickerData.getTickerData(tdAll, "advd.idx");
		final TickerData avvd = TickerData.getTickerData(tdAll, "avvd.idx");
		final TickerData decd = TickerData.getTickerData(tdAll, "decd.idx");
		final TickerData dvcd = TickerData.getTickerData(tdAll, "dvcd.idx");
		final TickerData higd = TickerData.getTickerData(tdAll, "higd.idx");
		final TickerData lowd = TickerData.getTickerData(tdAll, "lowd.idx");
		final DailyBreadthData dbOtc = new DailyBreadthData(advd, decd, avvd, dvcd, higd, lowd);

		final TickerData adve = TickerData.getTickerData(tdAll, "adve.idx");
		final TickerData avve = TickerData.getTickerData(tdAll, "avve.idx");
		final TickerData dece = TickerData.getTickerData(tdAll, "dece.idx");
		final TickerData dvce = TickerData.getTickerData(tdAll, "dvce.idx");
		final DailyBreadthData dbEtf = new DailyBreadthData(adve, dece, avve, dvce, null, null);

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\nasdaq100-list.txt"));
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		final List<TickerData> tdNdxList = ParseData.parseFiles(filenames, 370);
		final DailyBreadthData dbNdx = new DailyBreadthData(tdNdxList);

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\sp500-list.txt"));
		filenames.add(dataPath + "\\ASCII\\NYSE");
		final List<TickerData> tdSpxList = ParseData.parseFiles(filenames, 370);
		final DailyBreadthData dbSpx = new DailyBreadthData(tdSpxList);

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\sp600-list.txt"));
		filenames.add(dataPath + "\\ASCII\\AMEX");
		final List<TickerData> tdSp600List = ParseData.parseFiles(filenames, 370);
		final DailyBreadthData dbSp600 = new DailyBreadthData(tdSp600List);

		System.out.println("NASD\t" + dbNaz.toString());
		System.out.println("NYSE\t" + dbNyse.toString());
		System.out.println("AMEX\t" + dbAmex.toString());
		System.out.println("ETFs\t" + dbEtf.toString());
		System.out.println("OTCBB\t" + dbOtc.toString());
		dbTotal.setNewHighs();
		dbTotal.setNewLows();
		System.out.println("Total\t" + dbTotal.toString());
		System.out.println("");
		System.out.println("SPX\t" + dbSpx.toString());
		System.out.println("NDX\t" + dbNdx.toString());
		System.out.println("SP600\t" + dbSp600.toString());

	}

}
