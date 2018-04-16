
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

	private static List<Integer>	catList						= new ArrayList<>();
	private static List<String>		optumaTickerList	= new ArrayList<>();

	private static List<String> optumaExcludeNames = new ArrayList<>();

	private static List<String>	optumaIncludePeriod			= new ArrayList<>();
	private static List<String>	optumaIncludeFreq				= new ArrayList<>();
	private static List<String>	optumaIntermediateList	= new ArrayList<>();

	private static List<String> optumaFinalList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.getSeries
	 *
	 * @param id
	 * @param indent
	 */
	private static void getSeries(int id, int indent, String catName, String subCatName) {

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

						final String str = String.format("%s\t%s\t%s\t%s\t%s\t%s", catName, subCatName, idStr, title, freq, sa);
						optumaTickerList.add(str);
						//System.out.println(str);
					}
				}
			}

		} catch (final Exception e) {
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.isValid
	 *
	 * @param item
	 * @return
	 */
	private static boolean isValid(String item) {

		String fld[];

		boolean period = false;
		fld = item.split("\t");
		try {
			for (final String s : optumaIncludePeriod) {
				//System.out.println(s);
				if (fld[4].toUpperCase().contains(s)) {
					period = true;
					break;
				}
			}

		} catch (final Exception e) {
			period = false;
		}
		if (!period) {
			return false;
		}

		boolean freq = false;
		try {
			for (final String s : optumaIncludeFreq) {
				//System.out.println(s);
				if (fld[5].toUpperCase().contains(s)) {
					freq = true;
					break;
				}
			}

		} catch (final Exception e) {
			freq = false;
		}
		if (!freq) {
			return false;
		}

		try {
			for (final String s : optumaExcludeNames) {
				//System.out.println(s);
				if (fld[3].toUpperCase().contains(s)) {
					return false;
				}
			}
		} catch (final Exception e) {
			return false;
		}

		return true;
	}

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

		FindCategories.processTickerList();

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processBanking
	 *
	 * @throws FileNotFoundException
	 */
	private static void processBanking() throws FileNotFoundException {

		catList.clear();
		catList.add(32991);

		pw = new PrintWriter("fred-banking-categories.txt");
		for (final int cat : catList) {
			final String catName = FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1, catName);
		}
		pw.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processCategory
	 *
	 * @param cat
	 * @return
	 */
	private static String processCategory(int cat) {

		final String url = "https://api.stlouisfed.org/fred/category?category_id=" + cat + "&api_key=" + ApiKey.get();

		String catName = "";

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
					catName = name;

					if (!name.contains("DISCONTINUED")) {
						id = Integer.parseInt(tmp);

						pw.println(id + " " + name);
						pwSum.println(Utils.NL + id + " " + name);
					}
				}
			}

		} catch (final Exception e) {
			return "";
		}
		return catName;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processEmployment
	 *
	 * @throws FileNotFoundException
	 */
	private static void processEmployment() throws FileNotFoundException {

		catList.clear();
		catList.add(10);

		pw = new PrintWriter("employment-categories.txt");
		for (final int cat : catList) {
			final String catName = FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1, catName);
		}
		pw.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processNatlAccounts
	 *
	 * @throws FileNotFoundException
	 */
	private static void processNatlAccounts() throws FileNotFoundException {

		catList.clear();
		catList.add(32992);

		pw = new PrintWriter("national-account-categories.txt");
		for (final int cat : catList) {
			final String catName = FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1, catName);
		}
		pw.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processParentCategory
	 *
	 * @param cat
	 * @param indent
	 * @param catName
	 */
	private static void processParentCategory(int cat, int indent, String catName) {

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

						FindCategories.processParentCategory(id, indent + 1, catName);

						FindCategories.getSeries(id, indent + 2, catName, name);
					}
				}
			}

		} catch (final Exception e) {
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processPrices
	 *
	 * @throws FileNotFoundException
	 */
	private static void processPrices() throws FileNotFoundException {

		catList.clear();
		catList.add(32455);

		pw = new PrintWriter("price-categories.txt");
		for (final int cat : catList) {
			final String catName = FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1, catName);
		}
		pw.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processProductionBusiness
	 *
	 * @throws FileNotFoundException
	 */
	private static void processProductionBusiness() throws FileNotFoundException {

		catList.clear();
		catList.add(1);

		pw = new PrintWriter("production-business-categories.txt");
		for (final int cat : catList) {
			final String catName = FindCategories.processCategory(cat);
			FindCategories.processParentCategory(cat, 1, catName);
		}
		pw.close();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processTickerList
	 *
	 * @throws FileNotFoundException
	 */
	private static void processTickerList() throws FileNotFoundException {

		FindCategories.setupExcluded();

		for (final String s : optumaTickerList) {
			if (FindCategories.isValid(s)) {
				//pwList.println(s);
				optumaIntermediateList.add(s);
			}
		}

		for (final String s : optumaIntermediateList) {
			final String fld[] = s.split("\t");
			//System.out.printf("%s\t%s\t%s", fld[3], fld[4], fld[5]);
			if (fld[4].toUpperCase().contains("QUARTER")) {
				// look for identical name with "not" QUARTER freq
				boolean found = false;
				for (final String s2 : optumaIntermediateList) {
					final String fld2[] = s2.split("\t");
					if (fld[3].equals(fld2[3])) {
						if (!fld2[4].toUpperCase().contains("QUARTER")) {
							found = true;
							break;
						}
					}
				}
				if (!found) {
					//Write QUARTER freq is only one in list
					optumaFinalList.add(s);
				}

			} else {
				//Write all "not" QUARTER
				optumaFinalList.add(s);
			}
		}

		try (PrintWriter pwList = new PrintWriter("FRED-Codes-Optuma.txt")) {
			pwList.println("Category\tSubCategory\tCode\tTitle\tFrequency\tPeriod");
			for (final String s : optumaFinalList) {
				pwList.println(s);
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.setupExcluded
	 *
	 */
	private static void setupExcluded() {

		optumaExcludeNames.add("EURO");
		optumaExcludeNames.add("AUSTRALIA");
		optumaExcludeNames.add("BELGIUM");
		optumaExcludeNames.add("BRAZIL");
		optumaExcludeNames.add("CANADA");
		optumaExcludeNames.add("SWITZERLAND");
		optumaExcludeNames.add("CHILE");
		optumaExcludeNames.add("CHINA");
		optumaExcludeNames.add("CZECH");
		optumaExcludeNames.add("GERMANY");
		optumaExcludeNames.add("DENMARK");
		optumaExcludeNames.add("SPAIN");
		optumaExcludeNames.add("ESTONIA");
		optumaExcludeNames.add("FINLAND");
		optumaExcludeNames.add("FRANCE");
		optumaExcludeNames.add("KINGDOM");
		optumaExcludeNames.add("GREECE");
		optumaExcludeNames.add("HUNGARY");
		optumaExcludeNames.add("INDIA");
		optumaExcludeNames.add("IRELAND");
		optumaExcludeNames.add("ITALY");
		optumaExcludeNames.add("JAPAN");
		optumaExcludeNames.add("KOREA");
		optumaExcludeNames.add("LUXEMBOURG");
		optumaExcludeNames.add("ASIA");
		optumaExcludeNames.add("MEXICO");
		optumaExcludeNames.add("NAFTA");
		optumaExcludeNames.add("NETHERLANDS");
		optumaExcludeNames.add("NORWAY");
		optumaExcludeNames.add("ZEALAND");
		optumaExcludeNames.add("OECD");
		optumaExcludeNames.add("POLAND");
		optumaExcludeNames.add("PORTUGAL");
		optumaExcludeNames.add("RUSSIA");
		optumaExcludeNames.add("REPUBLIC");
		optumaExcludeNames.add("SLOVENIA");
		optumaExcludeNames.add("SWEDEN");
		optumaExcludeNames.add("TURKEY");
		optumaExcludeNames.add("ARKANSAS");
		optumaExcludeNames.add("ILLINOIS");
		optumaExcludeNames.add("KENTUCKY");
		optumaExcludeNames.add("MISSISSIPPI");
		optumaExcludeNames.add("MISSOURI");
		optumaExcludeNames.add("TENNESSEE");
		optumaExcludeNames.add("TEXAS");
		optumaExcludeNames.add("PHILADELPHIA");
		optumaExcludeNames.add("NEW YORK");
		optumaExcludeNames.add("ST. LOUIS");
		optumaExcludeNames.add("SWISS");
		optumaExcludeNames.add("BRITISH");
		optumaExcludeNames.add("HQM");
		optumaExcludeNames.add("FOREIGN");
		optumaExcludeNames.add("REST OF THE WORLD");
		optumaExcludeNames.add("LATIN AMERICA");
		optumaExcludeNames.add("SOUTH AMERICA");
		optumaExcludeNames.add("SNAP BENEFITS");
		optumaExcludeNames.add("STATE AND LOCAL GOVERNMENTS");
		optumaExcludeNames.add("TERM REPURCHASE AGREEMENTS");
		optumaExcludeNames.add("TOTAL VALUE OF ISSUES,");
		optumaExcludeNames.add("UNEMPLOYED:");
		optumaExcludeNames.add("UNEMPLOYMENT LEVEL");
		optumaExcludeNames.add("UNEMPLOYMENT RATE -");
		optumaExcludeNames.add(", DUE");
		optumaExcludeNames.add("ALLL ");
		optumaExcludeNames.add("CBOE ");
		optumaExcludeNames.add(", MEN ");
		optumaExcludeNames.add("WOMEN ");
		optumaExcludeNames.add("GOLD ");
		optumaExcludeNames.add("HIGH SCHOOL");
		optumaExcludeNames.add("DHI-DFH");
		optumaExcludeNames.add("FACTORS ");
		optumaExcludeNames.add("GLOBAL PRICE ");
		optumaExcludeNames.add("MATURITY BETWEEN");
		optumaExcludeNames.add(": MATURING");
		optumaExcludeNames.add(" EMERGING MARKET");
		optumaExcludeNames.add("ALL-TRANSACTIONS HOUSE PRICE INDEX FOR");
		optumaExcludeNames.add("Producer Price Index by Commodity for Advertising Space and Time Sales:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Chemicals and Allied Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Construction:".toUpperCase());
		optumaExcludeNames.add(
		    "Producer Price Index by Commodity for Contract Work on Textile Products, Apparel, and Leather:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Data Processing and Related Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Farm Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Final Demand:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Furniture and Household Durables:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Fuels and Related Products and Power:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Health Care Services:".toUpperCase());
		optumaExcludeNames
		    .add("Producer Price Index by Commodity for Hides, Skins, Leather, and Related Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Inputs to Industries:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Insurance and Annuitie:".toUpperCase());
		optumaExcludeNames
		    .add("Producer Price Index by Commodity for Intermediate Demand by Commodity Type:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Lumber and Wood Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Machinery and Equipment:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Metal and Metal Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Metal Treatment Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Miscellaneous Products:".toUpperCase());
		optumaExcludeNames
		    .add("Producer Price Index by Commodity for Network Compensation from Broadcast and Cable Television and Radio:"
		        .toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Nonmetallic Mineral Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Processed Foods and Feeds:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Professional Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Publishing Sales, Excluding Software:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Pulp, Paper, and Allied Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Real Estate Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Repair and Maintenance Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Retail Trade Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Rubber and Plastic Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Software Publishing:".toUpperCase());
		optumaExcludeNames.add(
		    "Producer Price Index by Commodity for Telecommunication, Cable, and Internet User Service:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Textile Products and Apparel:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Transportation Equipment:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Wholesale Trade Services:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Metal and Metal Products:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Machinery and Equipment:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Metal Treatment Services:".toUpperCase());

		optumaExcludeNames.add("Producer Price Index by Industry".toUpperCase());

		optumaExcludeNames.add("Producer Price Index by Commodity for Travel Arrangement Service:".toUpperCase());
		optumaExcludeNames.add("Producer Price Index by Commodity for Special Indexes:".toUpperCase());

		optumaExcludeNames.add("Russell ".toUpperCase());
		optumaExcludeNames.add("$".toUpperCase());
		optumaExcludeNames.add("Unemployment Rate".toUpperCase());
		optumaExcludeNames.add("Wilshire ".toUpperCase());
		optumaExcludeNames.add("Other ".toUpperCase());
		
		optumaExcludeNames.add("Condo ".toUpperCase());
		optumaExcludeNames.add("Delinquenc".toUpperCase());
		optumaExcludeNames.add("Labor Force".toUpperCase());
		optumaExcludeNames.add("Unemployed for ".toUpperCase());

		optumaExcludeNames.add("New Houses Sold by Sales Price in the United States, ".toUpperCase());

		optumaExcludeNames.add("All Employees: Construction:".toUpperCase());
		optumaExcludeNames.add("All Employees: Durable Goods:".toUpperCase());
		optumaExcludeNames.add("All Employees: Education and Health Services:".toUpperCase());
		optumaExcludeNames.add("All Employees: Financial Activities:".toUpperCase());
		optumaExcludeNames.add("All Employees: Information:".toUpperCase());
		optumaExcludeNames.add("All Employees: Leisure and Hospitality:".toUpperCase());
		optumaExcludeNames.add("All Employees: Mining and Logging:".toUpperCase());
		optumaExcludeNames.add("All Employees: Nondurable Goods:".toUpperCase());
		optumaExcludeNames.add("All Employees: Professional and Business Services:".toUpperCase());
		optumaExcludeNames.add("All Employees: Transportation and Warehousing:".toUpperCase());
		optumaExcludeNames.add("Average Weekly Earnings of All Employees:".toUpperCase());
		optumaExcludeNames.add("Average Weekly Hours of All Employees:".toUpperCase());
		optumaExcludeNames.add("Civilian Labor Force".toUpperCase());
		optumaExcludeNames.add("Civilian Noninstitutional Population -".toUpperCase());
		optumaExcludeNames.add("Consumer Price Index for Urban".toUpperCase());
		optumaExcludeNames.add("Employed full time:".toUpperCase());
		optumaExcludeNames.add("Employment Cost Index:".toUpperCase());
		optumaExcludeNames.add("Chicago".toUpperCase());
		optumaExcludeNames.add("Charge-Off Rate on".toUpperCase());
		optumaExcludeNames.add("All Sectors;".toUpperCase());

		optumaExcludeNames.add("Employment-Population".toUpperCase());
		optumaExcludeNames.add("Harmonized System".toUpperCase());
		optumaExcludeNames.add("Home Price Index (".toUpperCase());
		optumaExcludeNames.add("Home Price Sales Pair Counts for".toUpperCase());
		optumaExcludeNames.add("(SITC)".toUpperCase());
		optumaExcludeNames.add("Indexes of Aggregate".toUpperCase());
		optumaExcludeNames.add("Mortgage Debt Outstanding by Type".toUpperCase());
		optumaExcludeNames.add("Multiple Jobholders, ".toUpperCase());
		optumaExcludeNames.add("National Rate on ".toUpperCase());
		optumaExcludeNames.add("Net Interest Margin for U.S.".toUpperCase());
		optumaExcludeNames.add("Net Percentage of Domestic Banks".toUpperCase());
		optumaExcludeNames.add("Other Loans ".toUpperCase());
		optumaExcludeNames.add("Other Separations".toUpperCase());
		optumaExcludeNames.add("PADD ".toUpperCase());
		optumaExcludeNames.add("Inputs to Stage ".toUpperCase());

		optumaExcludeNames.add("All Employees: Other Services".toUpperCase());

		optumaIncludePeriod.add("DAILY");
		optumaIncludePeriod.add("WEEK");
		optumaIncludePeriod.add("MONTH");
		optumaIncludePeriod.add("QUARTER");

		optumaIncludeFreq.add("NSA");

	}

}
