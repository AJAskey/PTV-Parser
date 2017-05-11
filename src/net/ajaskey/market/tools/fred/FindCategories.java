
package net.ajaskey.market.tools.fred;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.ajaskey.market.misc.Utils;

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
public class FindCategories {

	private static final DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();
	private static DocumentBuilder							dBuilder	= null;
	private static PrintWriter									pw;
	private static PrintWriter									pwSum;

	private static List<Integer> catList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		pwSum = new PrintWriter("fred-categories.txt");

		FindCategories.processProductionBusiness();
		FindCategories.processBanking();
		FindCategories.processEmployment();
		FindCategories.processPrices();
		FindCategories.processNatlAccounts();

		pwSum.close();
	}

	/**
	 * net.ajaskey.market.tools.fred.getSeries
	 *
	 * @param id
	 * @param indent
	 */
	private static void getSeries(int id, int indent) {

		final String url = "https://api.stlouisfed.org/fred/category/series?category_id=" + id + "&api_key=" + ApiKey.get();
		try {
			final String resp = Utils.getFromUrl(url);
			//System.out.println(resp);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("series");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final Element eElement = (Element) nodeResp;
					final String idStr = eElement.getAttribute("id");
					String title = eElement.getAttribute("title");
					final String freq = eElement.getAttribute("frequency");
					final String units = eElement.getAttribute("units");
					final String sa = eElement.getAttribute("seasonal_adjustment_short");

					final String filtered = title.replaceAll("[^\\x00-\\x7F]", " ");
					title = filtered.trim();

					if (!title.contains("DISCONTINUED")) {

						String tab = "";
						for (int i = 0; i < indent; i++) {
							tab += "  ";
						}

						//pw.println(tab + idStr + "   " + title + " -- " + freq + " -- " + sa);
						pw.println(tab + idStr + "\t" + title + "\t" + freq + "\t" + units + " -- " + sa);
					}
				}
			}

		} catch (final Exception e) {
		}
	}

	private static void processBanking() throws FileNotFoundException {

		catList.clear();
		catList.add(32991);

		pw = new PrintWriter("fred-banking-categories.txt");
		for (final int cat : catList) {
			FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1);
		}
		pw.close();
	}

	private static void processCategory(int cat) {

		final String url = "https://api.stlouisfed.org/fred/category?category_id=" + cat + "&api_key=" + ApiKey.get();

		try {
			final String resp = Utils.getFromUrl(url);
			//System.out.println(resp);

			dBuilder = dbFactory.newDocumentBuilder();

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			int id = 0;
			final NodeList nResp = doc.getElementsByTagName("category");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final Element eElement = (Element) nodeResp;
					final String tmp = eElement.getAttribute("id");
					final String name = eElement.getAttribute("name");

					if (!name.contains("DISCONTINUED")) {
						id = Integer.parseInt(tmp);

						pw.println(id + " " + name);
						pwSum.println(Utils.NL + id + " " + name);
					}
				}
			}

		} catch (final Exception e) {
		}
	}

	private static void processEmployment() throws FileNotFoundException {

		catList.clear();
		catList.add(10);

		pw = new PrintWriter("employment-categories.txt");
		for (final int cat : catList) {
			FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1);
		}
		pw.close();
	}

	private static void processNatlAccounts() throws FileNotFoundException {

		catList.clear();
		catList.add(32992);

		pw = new PrintWriter("national-account-categories.txt");
		for (final int cat : catList) {
			FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1);
		}
		pw.close();
	}

	private static void processParentCategory(int cat, int indent) {

		final String url = "https://api.stlouisfed.org/fred/category/children?category_id=" + cat + "&" + "&api_key="
		    + ApiKey.get();

		try {
			final String resp = Utils.getFromUrl(url);
			//System.out.println(resp);

			dBuilder = dbFactory.newDocumentBuilder();

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			int id = 0;
			final NodeList nResp = doc.getElementsByTagName("category");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final Element eElement = (Element) nodeResp;
					final String tmp = eElement.getAttribute("id");
					final String name = eElement.getAttribute("name");
					if (!name.contains("DISCONTINUED")) {
						id = Integer.parseInt(tmp);
						String tab = "";
						for (int i = 0; i < indent; i++) {
							tab += "  ";
						}

						pw.println(Utils.NL + tab + id + " " + name);
						pwSum.println(tab + id + " " + name);

						FindCategories.processParentCategory(id, indent + 1);

						FindCategories.getSeries(id, indent + 2);
					}
				}
			}

		} catch (final Exception e) {
		}

	}

	private static void processPrices() throws FileNotFoundException {

		catList.clear();
		catList.add(32455);

		pw = new PrintWriter("price-categories.txt");
		for (final int cat : catList) {
			FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1);
		}
		pw.close();
	}

	private static void processProductionBusiness() throws FileNotFoundException {

		catList.clear();
		catList.add(1);

		pw = new PrintWriter("production-business-categories.txt");
		for (final int cat : catList) {
			FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1);
		}
		pw.close();
	}

}
