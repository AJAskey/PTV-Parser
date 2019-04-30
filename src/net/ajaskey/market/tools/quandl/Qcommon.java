
package net.ajaskey.market.tools.quandl;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.ajaskey.market.misc.Utils;
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
public class Qcommon {

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public final static String outpath = OptumaCommon.optumaPath + "/quandl";

	private static DocumentBuilderFactory dbFactory = null;

	private static DocumentBuilder dBuilder = null;

	/**
	 *
	 * net.ajaskey.market.tools.quandl.getData
	 *
	 * @param url
	 * @param num
	 * @return
	 */
	public static List<CommonQuandlData> getData(final String url, final int num) {

		final List<CommonQuandlData> ret = new ArrayList<>();

		try {
			final Document doc = Qcommon.getDocument(url, false);

			Qcommon.getLatestTime(doc);

			final NodeList nResp = doc.getElementsByTagName("datum");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final NodeList nrList = nodeResp.getChildNodes();
					final Calendar cal = Calendar.getInstance();
					int dReads = 0;
					final Double[] dd = new Double[num];
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

							}
							else if (s.contains("float")) {
								//System.out.println(nr.getNodeName() + " " + nr.getTextContent());
								dd[dReads++] = Double.parseDouble(nr.getTextContent().trim());
								if (dReads == dd.length) {

									final CommonQuandlData cqd = new CommonQuandlData(cal, dd);
									ret.add(cqd);
									//System.out.println("Adding - " + cqd.toString());
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

	public static Document getDocument(final String url, final boolean debug) {

		dbFactory = DocumentBuilderFactory.newInstance();
		Document doc = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();

			System.out.println("Processing : " + url);

			final String resp = Utils.getFromUrl(url);
			if (debug) {
				System.out.println(resp);
			}

			doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

		} catch (final ParserConfigurationException e) {
			doc = null;
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return doc;

	}

	public static Calendar getLatestTime(final Document doc) {

		final Calendar latest = Calendar.getInstance();
		latest.add(Calendar.YEAR, -25);

		final NodeList nDate = doc.getElementsByTagName("newest-available-date");

		for (int knt = 0; knt < nDate.getLength(); knt++) {
			final Node nodeResp = nDate.item(knt);

			if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
				final Element eElement = (Element) nodeResp;
				System.out.println("  " + eElement.getNodeName() + " " + eElement.getTextContent());
				Date date;
				try {
					date = Qcommon.sdf.parse(eElement.getTextContent().trim());
					latest.setTime(date);
				} catch (DOMException | ParseException e) {
					e.printStackTrace();
				}
				break;
			}
		}

		return latest;
	}
}
