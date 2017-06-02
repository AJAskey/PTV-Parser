
package net.ajaskey.market.ta.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * This class will generate a HTML based on user inputs.
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class HtmlPage implements java.io.Closeable {

	private final StringBuilder	page			= new StringBuilder();
	private StringBuilder				head			= null;
	private final StringBuilder	content		= new StringBuilder();
	private String							filename	= null;
	private boolean							validate	= false;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public HtmlPage() {
		this.init(null, null);
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public HtmlPage(List<String> preInfo, List<String> headInfo) {
		this.init(preInfo, headInfo);
	}

	/**
	 *
	 * net.ajaskey.market.ta.output.addParagraph
	 *
	 * @param words
	 */
	public void addParagraph(List<String> words) {

		final StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		for (final String w : words) {
			sb.append(w);
		}
		sb.append("</p>");
		this.content.append(sb);
	}

	/**
	 *
	 * net.ajaskey.market.ta.output.addTable
	 *
	 * @param headings
	 * @param fields
	 */
	public void addTable(List<String> headings, List<String> fields) {

		final StringBuilder sb = new StringBuilder();

		sb.append("<table>");

		for (final String h : headings) {
			sb.append("<th>" + h + "</th>");
		}

		sb.append("<tr>");
		for (final String f : fields) {
			sb.append("<td> " + f + " </td>");
		}
		sb.append("</tr>");
		sb.append("</table>");

		this.content.append(sb);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close() throws IOException {

		final StringBuilder sb = new StringBuilder();

		sb.append("</body>");
		sb.append("</html>");

		this.page.append(this.head).append(this.content).append(sb);

		if (this.filename != null) {
			if (this.isValid()) {
				try (PrintWriter pw = new PrintWriter(this.filename)) {
					pw.println(this.page.toString());
				}
			}
		}
	}

	/**
	 * @return the content
	 */
	public String getContent() {

		return this.content.toString();
	}

	/**
	 * @return the file
	 */
	public String getFilename() {

		return this.filename;
	}

	/**
	 * @return the head
	 */
	public String getHead() {

		return this.head.toString();
	}

	/**
	 * @return the page
	 */
	public String getPage() {

		return this.page.toString();
	}

	/**
	 *
	 * net.ajaskey.market.ta.output.init
	 *
	 * @param preInfo
	 * @param headInfo
	 */
	private void init(List<String> preInfo, List<String> headInfo) {

		final StringBuilder sb = new StringBuilder();
		if (preInfo != null) {
			for (final String pre : preInfo) {
				sb.append(pre);
			}
		}
		sb.append("<html>");
		sb.append("<head>");
		if (headInfo != null) {
			for (final String h : headInfo) {
				sb.append(h);
			}
		}
		sb.append("</head>");
		this.head = sb;

	}

	/**
	 *
	 * Placeholder. Figure this out later.
	 *
	 * @return
	 */
	public boolean isValid() {

		return true;
	}

	/**
	 * @return the validateIt
	 */
	public boolean isValidatable() {

		return this.validate;
	}

	/**
	 * @param fname
	 *          the file to set
	 */
	public void setFile(String fname) {

		this.filename = fname;
	}

	/**
	 * @param validateIt
	 *          the validate to set
	 */
	public void setValidate(boolean validateIt) {

		this.validate = validateIt;
	}

}
