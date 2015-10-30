
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

	private static void findLists(File dir) {

		File[] files = dir.listFiles();

		for (File f : files) {
			if (f.isDirectory()) {
				findLists(f);
			} else if (f.isFile()) {
				if (f.getName().equalsIgnoreCase("SymbolList.xml")) {
					list.add(f);
				}
			}
		}

	}

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
		
		File outDir = new File("symbols");
		if (!outDir.exists()) {
			outDir.mkdir();
		}

		findLists(new File("\\ASCII"));

		for (File f : list) {
			String fpath = f.getAbsolutePath();
			//System.out.println(fpath);
			int idx = fpath.indexOf("ASCII");
			idx += 6;
			int idx2 = fpath.indexOf("SymbolList.xml");
			if ((idx > 0) && (idx < idx2)) {
				String oFile = "symbols\\" + fpath.substring(idx, idx2 - 1) + "_SymbolList.xml";

				final Document document = builder.parse(f);

				final NodeList nodeList = document.getDocumentElement().getChildNodes();

				try (PrintWriter pw = new PrintWriter(oFile)) {
					for (int i = 0; i < nodeList.getLength(); i++) {

						final Node node = nodeList.item(i);

						if (node instanceof Element) {

							final String code = node.getAttributes().getNamedItem("Code").getNodeValue();
							final String name = node.getAttributes().getNamedItem("Name").getNodeValue();

							pw.println(code + "\t" + name);

						}
					}
				}
			}
		}
	}

}
