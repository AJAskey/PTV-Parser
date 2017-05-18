
package net.ajaskey.market.tools.quandl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	/**
	 * net.ajaskey.market.tools.quandl.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final String sp500EarnURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_EARNINGS_MONTH.xml?api_key="
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

		final String leadURL = "https://www.quandl.com/api/v3/datasets/ECRI/USLEADING.xml?api_key=" + QuandlApi.key;

		final List<MtsData> mts = ProcessQuandl.getMtsData(mtsURL);
		ProcessQuandl.writeMtsList(mts, "MTS");

		final List<LeadingIndicatorData> li = ProcessQuandl.getLeadingIndicatorData(leadURL);
		ProcessQuandl.writeLiList(li, "Leading_Indicator");

		final List<OhlcvData> earn = ProcessQuandl.getOneDataPoint(sp500EarnURL);
		ProcessQuandl.writeList(earn, "SP500_Earnings");

		final List<OhlcvData> div = ProcessQuandl.getOneDataPoint(sp500DivURL);
		ProcessQuandl.writeList(div, "SP500_Dividend");

		final List<OhlcvData> bv = ProcessQuandl.getOneDataPoint(bookValueURL);
		ProcessQuandl.writeList(bv, "SP500_BookValuePS");

		final List<OhlcvData> sPE = ProcessQuandl.getOneDataPoint(shillerPeURL);
		ProcessQuandl.writeList(sPE, "Shiller_PE");

		final List<OhlcvData> sales = ProcessQuandl.getOneDataPoint(sp500SalesURL);
		ProcessQuandl.writeList(sales, "SP500_Sales");

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
	private static List<MtsData> getMtsData(String url) {

		final List<MtsData> ret = new ArrayList<>();

		final List<CommonQuandlData> ddList = Qcommon.getData(url, 6);
		for (final CommonQuandlData cqd : ddList) {
			final MtsData md = new MtsData(cqd.date, cqd.dd[0], cqd.dd[1], cqd.dd[2], cqd.dd[3], cqd.dd[4], cqd.dd[5]);
			ret.add(md);
		}

		return ret;
	}

	private static List<OhlcvData> getOneDataPoint(String url) {

		final List<OhlcvData> ret = new ArrayList<>();
		final List<CommonQuandlData> ddList = Qcommon.getData(url, 1);
		for (final CommonQuandlData cqd : ddList) {
			final OhlcvData dp = new OhlcvData(cqd.date, cqd.dd[0], cqd.dd[0], cqd.dd[0], cqd.dd[0], 0);
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
			final OhlcvData pc = new OhlcvData(cqd.date, cqd.dd[0], cqd.dd[1], cqd.dd[2], cqd.dd[3], 0);
			ret.add(pc);
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

				pw.printf("%s,%d%n", Qcommon.sdf.format(item.date.getTime()), (int) item.index);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void writeList(List<OhlcvData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(Qcommon.outpath + "\\" + fname + ".csv")) {
			for (final OhlcvData price : list) {

				pw.printf("%s,%.2f%n", Qcommon.sdf.format(price.date.getTime()), price.close);
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
