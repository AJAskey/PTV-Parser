
package net.ajaskey.market.tools.quandl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.ConvertOHLCV;
import net.ajaskey.market.tools.helpers.OhlcvData;
import net.ajaskey.market.tools.optuma.OptumaCommon;

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

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	private static DocumentBuilderFactory	dbFactory	= null;
	private static DocumentBuilder				dBuilder	= null;

	final public static String outpath = OptumaCommon.optumaPath + "/quandl";

	/**
	 * net.ajaskey.market.tools.quandl.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		dbFactory = DocumentBuilderFactory.newInstance();

		String sp500EarnURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_EARNINGS_MONTH.xml?api_key="
		    + QuandlApi.key;
		String sp500DivURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_DIV_MONTH.xml?api_key=" + QuandlApi.key;
		String bookValueURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_BVPS_YEAR.xml?api_key=" + QuandlApi.key;
		String shillerPeURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SHILLER_PE_RATIO_MONTH.xml?api_key="
		    + QuandlApi.key;
		String sp500SalesURL = "https://www.quandl.com/api/v3/datasets/MULTPL/SP500_SALES_QUARTER.xml?api_key="
		    + QuandlApi.key;

		String epcURL = "https://www.quandl.com/api/v3/datasets/CBOE/EQUITY_PC.xml?api_key=" + QuandlApi.key;
		String ipcURL = "https://www.quandl.com/api/v3/datasets/CBOE/INDEX_PC.xml?api_key=" + QuandlApi.key;
		String tpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/TOTAL_PC.xml?api_key=" + QuandlApi.key;
		String spxpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/SPX_PC.xml?api_key=" + QuandlApi.key;
		String vixpcURL = "https://www.quandl.com/api/v3/datasets/CBOE/VIX_PC.xml?api_key=" + QuandlApi.key;

		String mtsURL = "https://www.quandl.com/api/v3/datasets/FMSTREAS/MTS.xml?api_key=" + QuandlApi.key;

		List<OhlcvData> earn = getData(sp500EarnURL);
		writeList(earn, "SP500_Earnings");

		List<OhlcvData> div = getData(sp500DivURL);
		writeList(div, "SP500_Dividend");

		List<OhlcvData> bv = getData(bookValueURL);
		writeList(bv, "SP500_BookValuePS");

		List<OhlcvData> sPE = getData(shillerPeURL);
		writeList(sPE, "Shiller_PE");

		List<OhlcvData> sales = getData(sp500SalesURL);
		writeList(sales, "SP500_Sales");

		List<OhlcvData> epc = getPutCallData(epcURL, 0, 1, 2, 3);
		writePcList(epc, "EquityPC");

		List<OhlcvData> ipc = getPutCallData(ipcURL, 0, 1, 2, 3);
		writePcList(ipc, "IndexPC");

		List<OhlcvData> tpc = getPutCallData(tpcURL, 0, 1, 2, 3);
		writePcList(tpc, "TotalPC");

		List<OhlcvData> spxpc = getPutCallData(spxpcURL, 1, 2, 3, 0);
		writePcList(spxpc, "SPX PC");

		List<OhlcvData> vixpc = getPutCallData(vixpcURL, 1, 2, 3, 0);
		writePcList(vixpc, "VIX PC");

		List<MtsData> mts = getMtsData(mtsURL);
		writeMtsList(mts, "MTS");

	}

	/**
	 * net.ajaskey.market.tools.quandl.writeMtsList
	 *
	 * @param mts
	 * @param string
	 */
	private static void writeMtsList(List<MtsData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(outpath + "\\" + fname + ".csv")) {
			for (final MtsData item : list) {

				pw.printf("%s,%d%n", sdfOptuma.format(item.date.getTime()), (int) item.receipts);
			}
			System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.getMtsData
	 *
	 * @param mtsURL
	 * @return
	 */
	private static List<MtsData> getMtsData(String url) {

		final List<MtsData> ret = new ArrayList<>();

		String resp;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			System.out.println("Processing : " + url);

			resp = Utils.getFromUrl(url);
			//System.out.println(resp);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("datum");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final NodeList nrList = nodeResp.getChildNodes();
					Calendar cal = Calendar.getInstance();
					int dReads = 0;
					Double[] dd = new Double[6];
					for (int cnt = 0; cnt < nrList.getLength(); cnt++) {
						final Node nr = nrList.item(cnt);
						if (nr.getNodeType() == Node.ELEMENT_NODE) {
							//final Element eElement = (Element) nodeResp;
							//System.out.println(nr.getNodeName() + " " + nr.getTextContent());

							Element eElement = (Element) nr;
							//System.out.println("type: " + eElement.getAttribute("type"));
							String s = eElement.getAttribute("type");

							if (s.contains("date")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								final Date date = sdf.parse(nr.getTextContent().trim());
								cal.setTime(date);

							} else if (s.contains("float")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								dd[dReads++] = Double.parseDouble(nr.getTextContent().trim());
								if (dReads == 6) {

									final MtsData d = new MtsData(Utils.buildCalendar(cal), dd[0], dd[1], dd[2], dd[3], dd[4], dd[5]);
									ret.add(d);
									System.out.println("Adding - " + d.toString());
									//System.out.println(d.toShortString());
									dReads = 0;
								}
							}
						}
					}
				}
			}

		} catch (final Exception e) {
			ret.clear();
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.quandl.writePcList
	 *
	 * @param epc
	 * @param string
	 */
	private static void writePcList(List<OhlcvData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pwCall = new PrintWriter(outpath + "\\" + fname + "-CallVol.csv");
		    PrintWriter pwPut = new PrintWriter(outpath + "\\" + fname + "-PutVol.csv");
		    PrintWriter pwTot = new PrintWriter(outpath + "\\" + fname + "-TotalVol.csv");
		    PrintWriter pwDiff = new PrintWriter(outpath + "\\" + fname + "-DiffVol.csv");
		    PrintWriter pwRatio = new PrintWriter(outpath + "\\" + fname + "-Ratio.csv")) {

			for (final OhlcvData price : list) {

				pwCall.printf("%s,%d%n", sdfOptuma.format(price.date.getTime()), (int) price.open);
				pwPut.printf("%s,%d%n", sdfOptuma.format(price.date.getTime()), (int) price.high);
				pwTot.printf("%s,%d%n", sdfOptuma.format(price.date.getTime()), (int) price.low);
				pwRatio.printf("%s,%.2f%n", sdfOptuma.format(price.date.getTime()), price.close);

				int diff = (int) (price.open - price.high);
				pwDiff.printf("%s,%d%n", sdfOptuma.format(price.date.getTime()), diff);

			}
			System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.getPutCallData
	 *
	 * @param epcURL
	 * @return
	 */
	private static List<OhlcvData> getPutCallData(String url, int callIdx, int putIdx, int totIdx, int ratioIdx) {

		final List<OhlcvData> ret = new ArrayList<>();

		String resp;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			System.out.println("Processing : " + url);

			resp = Utils.getFromUrl(url);
			//System.out.println(resp);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("datum");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final NodeList nrList = nodeResp.getChildNodes();
					Calendar cal = Calendar.getInstance();
					int dReads = 0;
					Double[] dd = new Double[4];
					for (int cnt = 0; cnt < nrList.getLength(); cnt++) {
						final Node nr = nrList.item(cnt);
						if (nr.getNodeType() == Node.ELEMENT_NODE) {
							//final Element eElement = (Element) nodeResp;
							//System.out.println(nr.getNodeName() + " " + nr.getTextContent());

							Element eElement = (Element) nr;
							//System.out.println("type: " + eElement.getAttribute("type"));
							String s = eElement.getAttribute("type");

							if (s.contains("date")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								final Date date = sdf.parse(nr.getTextContent().trim());
								cal.setTime(date);

							} else if (s.contains("float")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								dd[dReads++] = Double.parseDouble(nr.getTextContent().trim());
								if (dReads == 4) {

									final OhlcvData d = new OhlcvData(Utils.buildCalendar(cal), dd[callIdx], dd[putIdx], dd[totIdx],
									    dd[ratioIdx], 0);
									ret.add(d);
									System.out.println("Adding - " + d.toString());
									//System.out.println(d.toShortString());
									dReads = 0;
								}
							}
						}
					}
				}
			}

		} catch (final Exception e) {
			ret.clear();
			e.printStackTrace();
		}

		return ret;
	}

	private static void writeList(List<OhlcvData> list, String fname) {

		Collections.reverse(list);
		try (PrintWriter pw = new PrintWriter(outpath + "\\" + fname + ".csv")) {
			for (final OhlcvData price : list) {

				pw.printf("%s,%.2f%n", sdfOptuma.format(price.date.getTime()), price.close);
			}
			System.out.println(Utils.getString(list.get(list.size() - 1).date));

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static List<OhlcvData> getData(String url) {

		final List<OhlcvData> ret = new ArrayList<>();

		String resp;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			System.out.println("Processing : " + url);

			resp = Utils.getFromUrl(url);
			System.out.println(resp);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("datum");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final NodeList nrList = nodeResp.getChildNodes();
					Calendar cal = null;
					for (int cnt = 0; cnt < nrList.getLength(); cnt++) {
						final Node nr = nrList.item(cnt);
						if (nr.getNodeType() == Node.ELEMENT_NODE) {
							//final Element eElement = (Element) nodeResp;
							System.out.println(nr.getNodeName() + " " + nr.getTextContent());

							Element eElement = (Element) nr;
							System.out.println("type: " + eElement.getAttribute("type"));
							String s = eElement.getAttribute("type");

							if (s.contains("date")) {
								System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								final Date date = sdf.parse(nr.getTextContent().trim());
								cal = Calendar.getInstance();
								cal.setTime(date);

							} else if (s.contains("float")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								if (cal != null) {
									final double c = Double.parseDouble(nr.getTextContent().trim());
									final OhlcvData d = new OhlcvData(Utils.buildCalendar(cal), c, c, c, c, 0);
									cal = null;
									ret.add(d);
									System.out.println("Adding - " + d.toShortString());
									//System.out.println(d.toShortString());
								}
							}
						}
					}
				}
			}

		} catch (final Exception e) {
			ret.clear();
			e.printStackTrace();
		}

		return ret;
	}
}
