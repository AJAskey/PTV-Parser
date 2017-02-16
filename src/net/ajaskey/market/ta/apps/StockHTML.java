
package net.ajaskey.market.ta.apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

import net.ajaskey.market.ta.TickerData;

/**
 *
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
public class StockHTML {

	private String htmlStr;

	/**
	 *
	 * @throws IOException
	 */
	public StockHTML() throws IOException {
		final StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("stock-individual.htm"))) {
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {
					sb.append(line.trim());
				}
			}
			this.setHtmlStr(sb.toString());
		}
	}

	/**
	 *
	 * @param td
	 * @throws FileNotFoundException
	 */
	public void build(TickerData td) throws FileNotFoundException {

		this.htmlStr = this.htmlStr.replace("#Ticker#", td.getTicker().trim());
		this.htmlStr = this.htmlStr.replace("#CurrentPrice#", Double.toString(td.getCurrentPrice()));
		this.htmlStr = this.htmlStr.replace("#Low52#", Double.toString(td.getLow260()));
		this.htmlStr = this.htmlStr.replace("#High52#", Double.toString(td.getHigh260()));

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", (td.getPriceInRng260()));
			this.htmlStr = this.htmlStr.replace("#PriceRatio#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getPriceOffLow260());
			this.htmlStr = this.htmlStr.replace("#OffLow#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getPriceOffHigh260());
			this.htmlStr = this.htmlStr.replace("#OffHigh#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getAtr23());
			this.htmlStr = this.htmlStr.replace("#ATR#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getAtrPercent23());
			this.htmlStr = this.htmlStr.replace("#ATRPerc#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getLr260());
			this.htmlStr = this.htmlStr.replace("#LinearRegression#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f deg", td.getLrAngle260());
			this.htmlStr = this.htmlStr.replace("#LRPercent#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.1fM", (td.getAvgVol65() / 1000000.0));
			this.htmlStr = this.htmlStr.replace("#Volume#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getSma23());
			this.htmlStr = this.htmlStr.replace("#SMA23#", fmt.toString());
		}
		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getSmaPerc23());
			this.htmlStr = this.htmlStr.replace("#SMAPerc23#", fmt.toString());
		}
		this.htmlStr = this.htmlStr.replace("#Trend23#", td.getSma23Trend().toString());

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getSma65());
			this.htmlStr = this.htmlStr.replace("#SMA65#", fmt.toString());
		}
		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getSmaPerc65());
			this.htmlStr = this.htmlStr.replace("#SMAPerc65#", fmt.toString());
		}
		this.htmlStr = this.htmlStr.replace("#Trend65#", td.getSma65Trend().toString());

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getSma130());
			this.htmlStr = this.htmlStr.replace("#SMA130#", fmt.toString());
		}
		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getSmaPerc130());
			this.htmlStr = this.htmlStr.replace("#SMAPerc130#", fmt.toString());
		}
		this.htmlStr = this.htmlStr.replace("#Trend130#", td.getSma130Trend().toString());

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getSma260());
			this.htmlStr = this.htmlStr.replace("#SMA260#", fmt.toString());
		}
		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f%%", td.getSmaPerc260());
			this.htmlStr = this.htmlStr.replace("#SMAPerc260#", fmt.toString());
		}
		this.htmlStr = this.htmlStr.replace("#Trend260#", td.getSma260Trend().toString());

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getAdx());
			this.htmlStr = this.htmlStr.replace("#ADX#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getDiPlus());
			this.htmlStr = this.htmlStr.replace("#DIPlus#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%.2f", td.getDiMinus());
			this.htmlStr = this.htmlStr.replace("#DIMinus#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%d", (int) td.getRsi14());
			this.htmlStr = this.htmlStr.replace("#RSI14#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%d", (int) td.getMfi14());
			this.htmlStr = this.htmlStr.replace("#MFI14#", fmt.toString());
		}
		try (Formatter fmt = new Formatter()) {
			fmt.format("%d", (int) td.getMfi23());
			this.htmlStr = this.htmlStr.replace("#MFI23#", fmt.toString());
		}

		try (Formatter fmt = new Formatter()) {
			fmt.format("%d", (int) td.getMfi65());
			this.htmlStr = this.htmlStr.replace("#MFI65#", fmt.toString());
		}

		final File htmlDir = new File("html");
		if (!htmlDir.exists()) {
			htmlDir.mkdir();
		}
		try (PrintWriter pw = new PrintWriter("html\\" + td.getTicker().trim() + ".htm")) {
			pw.write(this.htmlStr);
		}
	}

	/**
	 * @return the htmlStr
	 */
	public String getHtmlStr() {

		return this.htmlStr;
	}

	/**
	 * @param htmlStr
	 *          the htmlStr to set
	 */
	private void setHtmlStr(String htmlStr) {

		this.htmlStr = htmlStr;
	}

}
