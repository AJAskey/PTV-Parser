
package net.ajaskey.market.tools.quandl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.Common;
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
public class ProcessShortInterest {

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	final public static String outpath = OptumaCommon.optumaPath + "/quandl";

	static String siURL = "https://www.quandl.com/api/v3/datasets/SI/xxxxx_SI.xml?api_key=" + QuandlApi.key;

	public static List<ShortInterestList> bigList = new ArrayList<>();

	public static void getQuandl(String filename, Calendar staleDate) throws FileNotFoundException, IOException {

		final List<String> tickers = Common.getTickersFromFile(filename);

		final List<String> retry = new ArrayList<>();

		final String outfile = "data/si-data.txt";

		try (PrintWriter pwout = new PrintWriter(outfile)) {

			for (final String ticker : tickers) {
				Common.delay(250);

				final List<ShortInterestData> siList = ProcessShortInterest.getShortInterestData(siURL, ticker, staleDate);

				if ((siList != null) && (siList.size() > 1)) {
					//ShortInterestList.bigList.add(new ShortInterestList(ticker, siList));
					for (final ShortInterestData si : siList) {
						final String dt = Qcommon.sdf.format(si.date.getTime());
						final String s = String.format("%s\t%s\t%d\t%.2f\t%.2f\t%d", ticker, dt, (long) si.si, si.dtc, si.modDtc,
						    (long) si.avgVol);
						pwout.println(s);
					}
				} else if ((siList != null) && (siList.size() == 1)) {
					//ignore stale data
				} else {
					retry.add(ticker);
				}
			}
		}

		for (final String s : retry) {
			System.out.println("Not found : " + s);
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		//		ProcessShortInterest.processFile("data/si-data.txt");

		final Date date = Qcommon.sdf.parse("2017-04-14");
		final Calendar staleDate = Calendar.getInstance();
		staleDate.setTime(date);
		ProcessShortInterest.getQuandl("data/one-ticker.txt", staleDate);
		//				getQuandl("data/SP500-SIP3B.txt", staleDate);

	}

	public static void processFile(String filename) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			String line = "";

			while (line != null) {
				line = br.readLine();
				final ShortInterestData sid = new ShortInterestData(line);
				if (sid.date != null) {
					//System.out.println(sid);
					ProcessShortInterest.addToBigList(sid);
				}
			}
		}

		final List<ShortInterestData> cSid = ProcessShortInterest.combined();

		for (final ShortInterestList sil : bigList) {
			System.out.println(sil.name + "  " + sil.dateKnt);
		}
		System.out.println("Total Tickers : " + bigList.size());

		ProcessShortInterest.writeList(cSid, "Combined");

	}

	/**
	 * net.ajaskey.market.tools.quandl.addToBigList
	 *
	 * @param sid
	 */
	private static void addToBigList(ShortInterestData sid) {

		boolean found = false;
		for (final ShortInterestList sil : bigList) {
			if (sid.ticker.equalsIgnoreCase(sil.name)) {
				sil.list.add(sid);
				sil.dateKnt++;
				found = true;
				break;
			}
		}
		if (!found) {
			final ShortInterestList sil = new ShortInterestList(sid.ticker);
			sil.list.add(sid);
			sil.name = sid.ticker;
			sil.dateKnt = 1;
			sil.latest = sid.date;
			bigList.add(sil);
		}

	}

	/**
	 * net.ajaskey.market.tools.quandl.combined
	 *
	 * @return
	 */
	private static List<ShortInterestData> combined() {

		List<ShortInterestData> retSil = new ArrayList<>();

		ShortInterestList maxPeriods = new ShortInterestList();
		for (final ShortInterestList sil : bigList) {
			if (maxPeriods.dateKnt < sil.dateKnt) {
				maxPeriods = sil;
			}
		}

		retSil = ProcessShortInterest.getTimePeriods(maxPeriods.list);
		//System.out.println(retSil);

		for (final ShortInterestList bSil : bigList) {

			for (int i = 0; i < bSil.list.size(); i++) {

				retSil.get(i).si += bSil.list.get(i).si;
				retSil.get(i).avgVol += bSil.list.get(i).avgVol;
				retSil.get(i).knt++;

			}
		}

		for (final ShortInterestData sid : retSil) {
			sid.si /= sid.knt;
		}

		return retSil;
	}

	private static List<ShortInterestData> getShortInterestData(String url, String ticker, Calendar staleDate) {

		final List<ShortInterestData> ret = new ArrayList<>();

		try {

			final String nurl = url.replace("xxxxx", ticker);
			final Document doc = Qcommon.getDocument(nurl, false);

			final Calendar latest = Qcommon.getLatestTime(doc);

			if (latest.before(staleDate)) {
				// Add a dummy record so not added to retry ticker list
				ret.add(new ShortInterestData());
				return ret;
			}

			final NodeList nResp = doc.getElementsByTagName("datum");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final NodeList nrList = nodeResp.getChildNodes();
					final Calendar cal = Calendar.getInstance();
					int dReads = 0;
					final Double[] dd = new Double[3];
					for (int cnt = 0; cnt < nrList.getLength(); cnt++) {
						final Node nr = nrList.item(cnt);
						if (nr.getNodeType() == Node.ELEMENT_NODE) {
							//final Element eElement = (Element) nodeResp;
							//System.out.println(nr.getNodeName() + " " + nr.getTextContent());

							final Element eElement = (Element) nr;
							//System.out.println("type: " + eElement.getAttribute("type"));
							final String s = eElement.getAttribute("type");

							if (s.contains("date")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								final Date date = Qcommon.sdf.parse(nr.getTextContent().trim());
								cal.setTime(date);

							} else if (s.contains("float")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								dd[dReads++] = Double.parseDouble(nr.getTextContent().trim());
								if (dReads == dd.length) {

									final ShortInterestData d = new ShortInterestData(Utils.buildCalendar(cal), dd[0], dd[1], dd[2]);
									ret.add(d);
									//System.out.println("Adding - " + d.toString());
									//System.out.println(d.toShortString());
									dReads = 0;
								}
							}
						}
					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}

		return ret;
	}

	private static List<ShortInterestData> getTimePeriods(List<ShortInterestData> sid) {

		final List<ShortInterestData> retSid = new ArrayList<>();

		for (final ShortInterestData s : sid) {
			final ShortInterestData newSid = new ShortInterestData();
			newSid.date = s.date;
			retSid.add(newSid);
		}

		return retSid;
	}

	private static void write(ShortInterestData data, PrintWriter pw) throws FileNotFoundException {

		pw.printf("%s,%.2f%n", sdfOptuma.format(data.date.getTime()), data.si);

	}

	private static void writeList(List<ShortInterestData> list, String fname) throws FileNotFoundException {

		Collections.reverse(list);

		try (PrintWriter pw = new PrintWriter(outpath + "\\SI_" + fname + ".csv")) {

			for (final ShortInterestData data : list) {
				ProcessShortInterest.write(data, pw);
			}
			//System.out.println(Utils.getString(list.get(list.size() - 1).date));
		}

	}

}
