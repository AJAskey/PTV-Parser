package net.ajaskey.market.tools.quandl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.helpers.OhlcvData;

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
public class ProcessQuandl {

	private static List<LeadingIndicatorData> getLeadingIndicatorData(String url) {

		final List<LeadingIndicatorData> ret = new ArrayList<>();
		final List<CommonQuandlData> ddList = Qcommon.getData(url, 2);
		for (final CommonQuandlData cqd : ddList) {
			final LeadingIndicatorData li = new LeadingIndicatorData(cqd.date, cqd.dd[0], cqd.dd[1]);
			ret.add(li);
		}

		return ret;

	}

	/**
	 * net.ajaskey.market.tools.quandl.getMtsData
	 *
	 * @param mtsURL
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<MtsData> getMtsData(String url) {

		final List<MtsData> ret = new ArrayList<>();

		final List<CommonQuandlData> ddList = Qcommon.getData(url, 6);
		for (final CommonQuandlData cqd : ddList) {
			final MtsData md = new MtsData(cqd.date, cqd.dd[0], cqd.dd[1], cqd.dd[2], cqd.dd[3], cqd.dd[4], cqd.dd[5]);
			ret.add(md);
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.quandl.getNaaimData
	 *
	 * @param naaimURL
	 * @return
	 */
	private static List<NaaimData> getNaaimData(String url) {

		final List<NaaimData> ret = new ArrayList<>();
		final List<CommonQuandlData> ddList = Qcommon.getData(url, 9);
		for (final CommonQuandlData cqd : ddList) {
			final NaaimData na = new NaaimData(cqd.date, cqd.dd[0], cqd.dd[1], cqd.dd[2], cqd.dd[3], cqd.dd[4], cqd.dd[5],
			    cqd.dd[6], cqd.dd[7], cqd.dd[8]);
			ret.add(na);
			//System.out.println(na);
		}

		return ret;
	}

	private static List<OneValueData> getOneDataPoint(String url) {

		final List<OneValueData> ret = new ArrayList<>();
		final List<CommonQuandlData> ddList = Qcommon.getData(url, 1);
		for (final CommonQuandlData cqd : ddList) {
			final OneValueData dp = new OneValueData(cqd.date, cqd.dd[0]);
			ret.add(dp);
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.quandl.getPutCallData
	 *
	 * @param epcURL
	 * @return
	 */
	private static List<OhlcvData> getPutCallData(String url, int callIdx, int putIdx, int totIdx, int ratioIdx) {

		final List<OhlcvData> ret = new ArrayList<>();

		final List<CommonQuandlData> ddList = Qcommon.getData(url, 4);
		for (final CommonQuandlData cqd : ddList) {
			final OhlcvData pc = new OhlcvData(cqd.date, cqd.dd[callIdx], cqd.dd[putIdx], cqd.dd[totIdx], cqd.dd[ratioIdx],
			    0);
			ret.add(pc);
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.quandl.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final String sp500URL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_REAL_PRICE_MONTH.xml?api_key="
		    + QuandlApi.key;
		final String sp500EarnYldURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_EARNINGS_YIELD_MONTH.xml?api_key"
		    + QuandlApi.key;
		final String sp500DivURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_DIV_MONTH.xml?api_key="
		    + QuandlApi.key;
		final String bookValueURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_BVPS_YEAR.xml?api_key="
		    + QuandlApi.key;
		final String shillerPeURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SHILLER_PE_RATIO_MONTH.xml?api_key="
		    + QuandlApi.key;
		final String sp500SalesURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_SALES_QUARTER.xml?api_key="
		    + QuandlApi.key;

		final String epcURL = "https://www.quandl.com/api/v3/datasets/CBOE/EQUITY_PC.xml?api_key=" + QuandlApi.key;
		final String ipcURL = "https://www.quandl.com/api/v3/datasets/CBOE/INDEX_PC.xml?api_key=" + QuandlApi.key;
		final String tpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/TOTAL_PC.xml?api_key=" + QuandlApi.key;
		final String spxpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/SPX_PC.xml?api_key=" + QuandlApi.key;
		final String vixpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/VIX_PC.xml?api_key=" + QuandlApi.key;
		final String mtsURL = "https://www.quandl.com/api/v3/datasets/FMSTREAS/MTS.xml?api_key=" + QuandlApi.key;
		final String balDryURL = "https://www.quandl.com/" + "api/v3/datasets/LLOYDS/BDI.xml?api_key=" + QuandlApi.key;
		final String naaimURL = "https://www.quandl.com/api/v3/datasets/NAAIM/NAAIM.xml?api_key=" + QuandlApi.key;
		final String leadURL = "https://www.quandl.com/api/v3/datasets/ECRI/USLEADING.xml?api_key=" + QuandlApi.key;

		final List<NaaimData> naaim = ProcessQuandl.getNaaimData(naaimURL);
		ProcessQuandl.writeNaaimList(naaim, "NAAIM");

		final List<OneValueData> balDry = ProcessQuandl.getOneDataPoint(balDryURL);
		ProcessQuandl.writeOneList(balDry, "Baltic_Dry_Index");

		//Manual update from Treasury website
		//final List<MtsData> mts = ProcessQuandl.getMtsData(mtsURL);
		//ProcessQuandl.writeMtsList(mts, "MTS");

	  //final List<LeadingIndicatorData> li = ProcessQuandl.getLeadingIndicatorData(leadURL);
		//processEcri(li, 0.0, 0.0);
		//ProcessQuandl.writeLiList(li, "Leading_Indicator");

		final List<OneValueData> price = ProcessQuandl.getOneDataPoint(sp500URL);
		final List<OneValueData> earn = ProcessQuandl.getOneDataPoint(sp500EarnYldURL);
		List<OneValueData> searn = scaleEarnings(earn, price);
		ProcessQuandl.writeOneList(searn, "SP500_Earnings");
		ProcessQuandl.writeOneList(earn, "SP500_EarningsYield");

		final List<OneValueData> div = ProcessQuandl.getOneDataPoint(sp500DivURL);
		ProcessQuandl.writeOneList(div, "SP500_Dividend");

		final List<OneValueData> bv = ProcessQuandl.getOneDataPoint(bookValueURL);
		ProcessQuandl.writeOneList(bv, "SP500_BookValuePS");

		final List<OneValueData> sPE = ProcessQuandl.getOneDataPoint(shillerPeURL);
		//ProcessQuandl.writeOneList(sPE, "Shiller_PE");

		final List<OneValueData> sales = ProcessQuandl.getOneDataPoint(sp500SalesURL);
		//ProcessQuandl.writeOneList(sales, "SP500_Sales");

		final List<OhlcvData> epc = ProcessQuandl.getPutCallData(epcURL, 0, 1, 2, 3);
		ProcessQuandl.writePcList(epc, "EquityPC");

		final List<OhlcvData> ipc = ProcessQuandl.getPutCallData(ipcURL, 0, 1, 2, 3);
		ProcessQuandl.writePcList(ipc, "IndexPC");

		final List<OhlcvData> tpc = ProcessQuandl.getPutCallData(tpcURL, 0, 1, 2, 3);
		ProcessQuandl.writePcList(tpc, "TotalPC");

		final List<OhlcvData> spxpc = ProcessQuandl.getPutCallData(spxpcURL, 1, 2, 3, 0);
		ProcessQuandl.writePcList(spxpc, "SPX PC");

		final List<OhlcvData> vixpc = ProcessQuandl.getPutCallData(vixpcURL, 1, 2, 3, 0);
		ProcessQuandl.writePcList(vixpc, "VIX PC");

	}

	/**
	 * net.ajaskey.market.tools.quandl.processEcri
	 *
	 * @param li
	 * @param d
	 * @param e
	 */
	private static void processEcri(List<LeadingIndicatorData> li, double wk2, double wk1) {

		Calendar cal2 = null;
		if (wk2 > 0.0) {
			cal2 = Utils.buildCalendar(li.get(0).date);
			cal2.add(Calendar.DATE, 7);
			LeadingIndicatorData d2 = new LeadingIndicatorData(cal2, wk2, 0.0);
			li.add(0, d2);
			if (wk1 > 0.0) {
				Calendar cal1 = Utils.buildCalendar(cal2);
				cal1.add(Calendar.DATE, 7);
				LeadingIndicatorData d1 = new LeadingIndicatorData(cal1, wk1, 0.0);
				li.add(0, d1);
			}
		}
	}

	/**
	 * net.ajaskey.market.tools.quandl.scaleEarnings
	 *
	 * @param earn
	 * @param d
	 * @return
	 */
	private static List<OneValueData> scaleEarnings(List<OneValueData> earn, List<OneValueData> price) {

		List<OneValueData> ret = new ArrayList<>();
		int knt = 0;
		for (OneValueData data : earn) {
			OneValueData nd = new OneValueData(data.date, data.value * price.get(knt++).value / 100.0);
			ret.add(nd);
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.quandl.writeLiList
	 *
	 * @param li
	 * @param string
	 */
	private static void writeLiList(List<LeadingIndicatorData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(Qcommon.outpath + "\\" + fname + ".csv")) {
			for (final LeadingIndicatorData item : list) {

				pw.printf("%s,%.1f%n", Qcommon.sdf.format(item.date.getTime()), item.index);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.writeMtsList
	 *
	 * @param mts
	 * @param string
	 */
	@SuppressWarnings("unused")
	private static void writeMtsList(List<MtsData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(Qcommon.outpath + "\\" + fname + ".csv")) {
			for (final MtsData item : list) {

				pw.printf("%s,%d%n", Qcommon.sdf.format(item.date.getTime()), (int) item.receipts);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.writeNaaimList
	 *
	 * @param naaim
	 * @param string
	 */
	private static void writeNaaimList(List<NaaimData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pwMean = new PrintWriter(Qcommon.outpath + "\\" + fname + "_Mean.csv");
		    PrintWriter pwBear = new PrintWriter(Qcommon.outpath + "\\" + fname + "_Bear.csv");
		    PrintWriter pwq1 = new PrintWriter(Qcommon.outpath + "\\" + fname + "_q1.csv");
		    PrintWriter pwMed = new PrintWriter(Qcommon.outpath + "\\" + fname + "_Median.csv");
		    PrintWriter pwq3 = new PrintWriter(Qcommon.outpath + "\\" + fname + "_q3.csv");
		    PrintWriter pwBull = new PrintWriter(Qcommon.outpath + "\\" + fname + "_Bull.csv");
		    PrintWriter pwStddev = new PrintWriter(Qcommon.outpath + "\\" + fname + "_StdDev.csv");
		    PrintWriter pwbbdiff = new PrintWriter(Qcommon.outpath + "\\" + fname + "_BullBear.csv");
		    PrintWriter pwsp500 = new PrintWriter(Qcommon.outpath + "\\" + fname + "_SP500.csv")) {
			for (final NaaimData naaim : list) {

				pwMean.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.mean);
				pwBear.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.mostBearish);
				pwq1.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.q1);
				pwMed.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.median);
				pwq3.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.q3);
				pwBull.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.mostBullish);
				pwStddev.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.stdDev);
				pwsp500.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.sp500);
				pwbbdiff.printf("%s,%.2f%n", Qcommon.sdf.format(naaim.date.getTime()), naaim.bbDiff);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	//	private static void writeList(List<OhlcvData> list, String fname) {
	//
	//		Collections.reverse(list);
	//		try (PrintWriter pw = new PrintWriter(Qcommon.outpath + "\\" + fname + ".csv")) {
	//			for (final OhlcvData price : list) {
	//
	//				pw.printf("%s,%.2f%n", Qcommon.sdf.format(price.date.getTime()), price.close);
	//			}
	//			//System.out.println(Utils.getString(list.get(list.size() - 1).date));
	//
	//		} catch (final FileNotFoundException e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * net.ajaskey.market.tools.quandl.writeBalticDryList
	 *
	 * @param balDry
	 * @param string
	 */
	private static void writeOneList(List<OneValueData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(Qcommon.outpath + "\\" + fname + ".csv")) {
			for (final OneValueData one : list) {

				pw.printf("%s,%.2f%n", Qcommon.sdf.format(one.date.getTime()), one.value);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * net.ajaskey.market.tools.quandl.writePcList
	 *
	 * @param epc
	 * @param string
	 */
	private static void writePcList(List<OhlcvData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pwCall = new PrintWriter(Qcommon.outpath + "\\" + fname + "-CallVol.csv");
		    PrintWriter pwPut = new PrintWriter(Qcommon.outpath + "\\" + fname + "-PutVol.csv");
		    PrintWriter pwTot = new PrintWriter(Qcommon.outpath + "\\" + fname + "-TotalVol.csv");
		    PrintWriter pwDiff = new PrintWriter(Qcommon.outpath + "\\" + fname + "-DiffVol.csv");
		    PrintWriter pwRatio = new PrintWriter(Qcommon.outpath + "\\" + fname + "-Ratio.csv")) {

			for (final OhlcvData price : list) {

				pwCall.printf("%s,%d%n", Qcommon.sdf.format(price.date.getTime()), (int) price.open);
				pwPut.printf("%s,%d%n", Qcommon.sdf.format(price.date.getTime()), (int) price.high);
				pwTot.printf("%s,%d%n", Qcommon.sdf.format(price.date.getTime()), (int) price.low);
				pwRatio.printf("%s,%.2f%n", Qcommon.sdf.format(price.date.getTime()), price.close);

				final int diff = (int) (price.open - price.high);
				pwDiff.printf("%s,%d%n", Qcommon.sdf.format(price.date.getTime()), diff);

			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
