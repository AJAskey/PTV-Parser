
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.ajaskey.market.ta.Utils;

/**
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
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
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class ProcessSymbolList {

	private static List<File> list = new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();

		Utils.makeDir("symbols");
		Utils.makeDir("lists");

		String arg = "dataPath";
		String dataPath = System.getProperty(arg, "");
		String filePath = dataPath + "\\ASCII";
		System.out.println(filePath);
		ProcessSymbolList.findLists(new File(filePath));

		final PrintWriter pwIshares = new PrintWriter("lists\\ishares-list.txt");
		final PrintWriter pwPshares = new PrintWriter("lists\\powershares-list.txt");
		final PrintWriter pwProshares = new PrintWriter("lists\\proshares-list.txt");
		final PrintWriter pwETF = new PrintWriter("lists\\etf-list.txt");
		final PrintWriter pwCS = new PrintWriter("lists\\caseshiller-list.txt");
		final PrintWriter pwGSCI = new PrintWriter("lists\\commodity-list.txt");
		final PrintWriter pwSector = new PrintWriter("lists\\sector-list.txt");
		final PrintWriter pwDJUS = new PrintWriter("lists\\djus-list.txt");
		final PrintWriter pwUSMF = new PrintWriter("lists\\usmf-list.txt");

		final PrintWriter pwAll = new PrintWriter("lists\\master-list.txt");

		for (final File f : list) {
			final String fpath = f.getAbsolutePath();
			// System.out.println(fpath);
			int idx = fpath.indexOf("ASCII");
			idx += 6;
			final int idx2 = fpath.indexOf("SymbolList.xml");
			if ((idx > 0) && (idx < idx2)) {

				final String dirName = fpath.substring(idx, idx2 - 1);

				// ignore options
				if ((dirName.compareToIgnoreCase("OPRA") != 0) && (dirName.compareToIgnoreCase("HKEX") != 0)
				    && (dirName.compareToIgnoreCase("WCE") != 0)) {

					final String oFile = "symbols\\" + dirName + "_SymbolList.txt";

					final Document document = builder.parse(f);

					final NodeList nodeList = document.getDocumentElement().getChildNodes();

					try (PrintWriter pw = new PrintWriter(oFile)) {
						for (int i = 0; i < nodeList.getLength(); i++) {

							final Node node = nodeList.item(i);

							if (node instanceof Element) {

								final String code = node.getAttributes().getNamedItem("Code").getNodeValue();
								final String name = node.getAttributes().getNamedItem("Name").getNodeValue();
								if (dirName.compareToIgnoreCase("INDEX") == 0) {
									String fmt = "%-10s\t%-50s\t%-10s%n";
									String codePlus = code + ".IDX";
									pw.printf(fmt, codePlus, name, dirName);
									if (name.contains("Home Price Index")) {
										pwCS.printf(fmt, codePlus, name, dirName);
									} else if (name.contains(" GSCI ")) {
										pwGSCI.printf(fmt, codePlus, name, dirName);
									} else if (name.contains("EQUAL WEIGHTED")) {
										pwSector.printf(fmt, codePlus, name, dirName);
									} else if (name.contains("DJ US")) {
										pwDJUS.printf(fmt, codePlus, name, dirName);
									}
									pwAll.printf("%-12s\t%-50s\t%-10s%n", codePlus, name, dirName);
								} else {
									String fmt = "%-10s\t%-50s\t%-10s%n";
									pw.printf(fmt, code, name, dirName);
									if (name.toUpperCase().contains("ISHARES")) {
										pwIshares.printf(fmt, code, name, dirName);
									} else if (name.toUpperCase().contains(" ETF ")) {
										pwETF.printf(fmt, code, name, dirName);
									} else if (name.toUpperCase().contains(" POWERSHARES")) {
										pwPshares.printf(fmt, code, name, dirName);
									} else if (name.toUpperCase().contains(" PROSHARES")) {
										pwProshares.printf(fmt, code, name, dirName);
									}
									pwAll.printf("%-12s\t%-50s\t%-10s%n", code, name, dirName);

									if (dirName.toUpperCase().contains("USMF")) {
										pwUSMF.printf(fmt, code, name, dirName);
									}
								}
							}
						}
					}
				}
			}
		}
		pwIshares.close();
		pwPshares.close();
		pwProshares.close();
		pwETF.close();
		pwCS.close();
		pwGSCI.close();
		pwSector.close();
		pwDJUS.close();
		pwAll.close();
		pwUSMF.close();

		System.out.println("Done.");
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.findLists
	 *
	 * @param dir
	 */
	private static void findLists(File dir) {

		final File[] files = dir.listFiles();

		for (final File f : files) {
			if (f.isDirectory()) {
				ProcessSymbolList.findLists(f);
			} else if (f.isFile()) {
				if (f.getName().equalsIgnoreCase("SymbolList.xml")) {
					list.add(f);
				}
			}
		}

	}

}
