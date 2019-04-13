
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import net.ajaskey.market.misc.Debug;
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

	private static final boolean useOnline = false;

	private static final DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();
	private static DocumentBuilder							dBuilder	= null;

	private static PrintWriter	pw;
	private static PrintWriter	pwSum;

	private static List<Integer> catList = new ArrayList<>();

	private static List<String>	optumaTickerList				= new ArrayList<>();
	private static List<String>	optumaIntermediateList	= new ArrayList<>();
	private static List<String>	optumaFinalList					= new ArrayList<>();

	private static List<String>	optumaIncludeNames			= new ArrayList<>();
	private static List<String>	optumaExcludeNames			= new ArrayList<>();
	private static List<String>	optumaIncludePeriod			= new ArrayList<>();
	private static List<String>	optumaIncludeFrequency	= new ArrayList<>();
	private static List<String>	optumaIncludeCode				= new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.getSeries
	 *
	 * @param id
	 * @param indent
	 */
	private static void getSeries(int id, int indent, String catName, String subCatName) {

		final String url = "https://api.stlouisfed.org/fred/category/series?category_id=" + id + "&api_key=" + ApiKey.get();

		String resp = "";
		int loopknt = 0;
		try {
			while (resp.length() == 0) {
				resp = Utils.getFromUrl(url);

				if ((resp != null) && (resp.trim().length() > 0)) {

					Debug.log(String.format("getSeries :: id : %d\tindent : %d\tcatName : %s\tsubCatName : %s%n%s%n", id, indent,
					    catName, subCatName, resp));

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
								Debug.log(String.format("getSeries :: %s%n", str));
								//System.out.println(str);
							}
						}
					}
				} else {
					loopknt++;
					if (loopknt == 10) {
						Debug.log(String.format("getSeries :: catName : %s\tsubCatName : %s%nNULL RESPONSE - Breaking...%n",
						    catName, subCatName));
						break;
					}
					Debug.log(String.format("getSeries :: catName : %s\tsubCatName : %s%nNULL RESPONSE - Sleeping...%n", catName,
					    subCatName));
					Utils.sleep(30000);
					resp = "";
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

		fld = item.split("\t");

		// Check individual codes
		try {
			for (String s : optumaIncludeCode) {
				//System.out.println(s);
				if (fld[2].trim().equalsIgnoreCase(s)) {
					Debug.log(String.format("IN\tCode\t%s%n", item));
					return true;
				}
			}
		} catch (final Exception e) {
			return false;
		}

		//Check if valid Period
		boolean period = false;
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
			Debug.log(String.format("OUT\tPeriod\t%s%n", item));
			return false;
		}

		// Check if valid frequency
		boolean freq = false;
		try {
			for (final String s : optumaIncludeFrequency) {
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
			Debug.log(String.format("OUT\tFrequency\t%s%n", item));
			return false;
		}

		// Check if name is excluded
		try {
			for (final String s : optumaExcludeNames) {
				//System.out.println(s);
				if (fld[3].toUpperCase().contains(s)) {
					Debug.log(String.format("OUT\tEXCLUDED\t%s\t%s%n", item, s));
					return false;
				}
			}
		} catch (final Exception e) {
			return false;
		}

		// Check if name is included
		try {
			for (final String s : optumaIncludeNames) {
				//System.out.println(s);
				if (fld[3].toUpperCase().contains(s)) {
					Debug.log(String.format("IN\tINCLUDED\t%s\t%s%n", item, s));
					return true;
				}
			}
		} catch (final Exception e) {
			return false;
		}

		Debug.log(String.format("OUT\tUNMATCHED\t%s%n", item));
		return false;
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Debug.init("findcat.dbg");

		//setupIncluded();

		//if (useOnline) {

		pwSum = new PrintWriter("fred-categories.txt");
		FindCategories.processProductionBusiness();
		FindCategories.processBanking();
		FindCategories.processEmployment();
		FindCategories.processPrices();
		FindCategories.processNatlAccounts();
		pwSum.close();

		//			try (PrintWriter pwAll = new PrintWriter("data/optumaAllTickers.txt")) {
		//				for (String s : optumaTickerList) {
		//					pwAll.println(s);
		//				}
		//			}
		//
		//		} else {
		//			try (BufferedReader br = new BufferedReader(new FileReader(new File("data/optumaAllTickers.txt")))) {
		//				String line = "";
		//				while (line != null) {
		//					line = br.readLine();
		//					if ((line != null) && (line.trim().length() > 0)) {
		//						String s = line.trim().replaceAll("\"", "");
		//						optumaTickerList.add(s);
		//					}
		//				}
		//			}
		//		}
		//
		//		FindCategories.processTickerList();

		System.out.println("Done.");

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

		String resp = "";
		try {
			int loopknt = 0;
			while (resp.length() == 0) {
				resp = Utils.getFromUrl(url);
				//System.out.println(resp);

				Debug.log(String.format("processCategory cat : %d%n%s%n", cat, resp));

				if ((resp != null) && (resp.trim().length() > 0)) {

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

								Debug.log(String.format("processCategory id : %d\t catname : %s%n", id, catName));
								pw.println(id + " " + name);
								pwSum.println(Utils.NL + id + " " + name);
							}
						}
					}
				} else {
					loopknt++;
					if (loopknt == 10) {
						break;
					}
					Debug.log("processCategory null resp ... sleeping\n");
					Utils.sleep(30000);
					resp = "";
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

		String resp = "";
		int loopknt = 0;
		try {
			while (resp.length() == 0) {
				resp = Utils.getFromUrl(url);

				if ((resp != null) && (resp.trim().length() > 0)) {

					Debug.log(String.format("processParentCategory cat : %d\tcatName : %s%n%s%n", cat, catName, resp));

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

								Debug.log(
								    String.format("processParentCategory id : %d\tindent : %d\tcatName : %s%n", id, indent, catName));

								pw.println(Utils.NL + tab + id + " " + name);
								pwSum.println(tab + id + " " + name);

								if (id == 191) {
									System.out.println(id);
								}

								FindCategories.processParentCategory(id, indent + 1, catName);

								FindCategories.getSeries(id, indent + 2, catName, name);
							}
						}
					}
				} else {
					loopknt++;
					if (loopknt == 10) {
						Debug.log(String.format("processParentCategory cat : %d\tcatName : %s%nNULL RESPONSE - Breaking...%n", cat,
						    catName));						break;
					}
					Debug.log(String.format("processParentCategory cat : %d\tcatName : %s%nNULL RESPONSE - Sleeping...%n", cat,
					    catName));
					Utils.sleep(30000);
					resp = "";
				}
			}
		} catch (final Exception e) {
			Debug.log(String.format("processParentCategory cat : %d\tcatName : %s%n%s%n", cat, catName, e.getMessage()));

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

		try {
			FindCategories.setupIncluded();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

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
	 * @throws IOException
	 * @throws FileNotFoundException
	 *
	 */
	private static void setupIncluded() throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File("data/Fred-Include-List.txt")))) {
			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line == null) break;
				//System.out.println(line);

				try {
					final String uline = line.trim().toUpperCase();

					if (uline.length() > 0) {
						final String fld[] = uline.split("\t");

						if (fld.length > 1) {
							final String cat = fld[0].trim();
							final String item = fld[1].replaceAll("\"", "");

							if (cat.equals("INCLUDE")) {
								optumaIncludeNames.add(item);
							} else if (cat.equals("EXCLUDE")) {
								optumaExcludeNames.add(item);
							} else if (cat.equals("PERIOD")) {
								optumaIncludePeriod.add(item);
							} else if (cat.equals("FREQUENCY")) {
								optumaIncludeFrequency.add(item);
							} else if (cat.equals("CODE")) {
								optumaIncludeCode.add(item);
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		for (String s : optumaIncludeCode) {
			System.out.printf("Code\t%s%n", s);
		}
		for (String s : optumaIncludePeriod) {
			System.out.printf("Period\t%s%n", s);
		}
		for (String s : optumaIncludeFrequency) {
			System.out.printf("Frequency\t%s%n", s);
		}
		for (String s : optumaIncludeNames) {
			System.out.printf("Include Name\t%s%n", s);
		}
		for (String s : optumaExcludeNames) {
			System.out.printf("Exclude Name\t%s%n", s);
		}

	}

}
