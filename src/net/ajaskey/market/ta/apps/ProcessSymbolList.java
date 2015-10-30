
package net.ajaskey.market.ta.apps;

import java.io.IOException;

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

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// Get the DOM Builder Factory
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		final DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document
		// document contains the complete XML as a Tree.
		final Document document = builder.parse("TestData\\SymbolList.xml");

		// Iterating through the nodes and extracting the data.
		final NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			final Node node = nodeList.item(i);

			if (node instanceof Element) {

				final String code = node.getAttributes().getNamedItem("Code").getNodeValue();
				final String name = node.getAttributes().getNamedItem("Name").getNodeValue();

				System.out.println(code + "\t" + name);

			}
		}

	}

}
