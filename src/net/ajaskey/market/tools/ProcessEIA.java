
package net.ajaskey.market.tools;

import java.io.File;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.fred.DataSeries;
import net.ajaskey.market.tools.fred.DataValues;
import net.ajaskey.market.tools.fred.Debug;
import net.ajaskey.market.tools.fred.FredCommon;
import net.ajaskey.market.tools.fred.DataSeries.AggregationMethodType;
import net.ajaskey.market.tools.fred.DataSeries.ResponseType;

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
public class ProcessEIA {

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws ParserConfigurationException {

		String apiKey = "5083132038aeb07288f19e6313b85532";

		String outName = "C:/Users/ajask_000/Documents/Market Analyst 8/CSV Data/EIA/.csv";
		String gasURL = "http://api.eia.gov/series/?api_key=" + apiKey + "&series_id=PET.WGFUPUS2.W&out=xml";

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		String resp;
		try {
			resp = Utils.getFromUrl(gasURL);
			System.out.println(resp);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("row");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					NodeList nrList = nodeResp.getChildNodes();
					for (int cnt = 0; cnt < nrList.getLength(); cnt++) {
						Node nr = nrList.item(cnt);
						if (nr.getNodeType() == Node.ELEMENT_NODE) {
							String s = nr.getNodeName();
							if (s.contains("date")) {
								System.out.println(nr.getNodeName() + " " + nr.getTextContent());
							} else if (s.contains("value")) {
								System.out.println(nr.getNodeName() + " " + nr.getTextContent());
							}

						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
