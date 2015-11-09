
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
public class YahooData {

	public static List<String> get(List<String> tickers, String command) {
		String tkrs = "";
		for (final String t : tickers) {
			tkrs += t + "+";
		}
		final String url = "http://download.finance.yahoo.com/d/quotes.csv?s=" + tkrs + "&f=" + command;
		String response;
		try {
			response = YahooData.getFromUrl(url);
		} catch (final IOException e) {
			response = null;
		}
		if (response != null) {
			final String[] fld = response.split(Utils.NL);
			final List<String> ret = new ArrayList<>();
			int knt = 0;
			for (final String t : tickers) {
				final String resp = t + "," + fld[knt++];
				ret.add(resp);
			}
			return ret;
		}
		return null;
	}

	public static String get(String tickers, String command) {
		String response = null;
		final String url = "http://download.finance.yahoo.com/d/quotes.csv?s=" + tickers + "&f=" + command;
		try {
			response = YahooData.getFromUrl(url);
		} catch (final IOException e) {
			response = null;
		}
		return response;
	}

	public static void main(String[] args) {

		testit();

		final String str = "1234" + Utils.NL;
		str.trim();

		final String resp = YahooData.get("EFOI", "f6n4");
		System.out.println(resp);

		final List<String> tickers = new ArrayList<>();
		tickers.add("MSFT");
		tickers.add("EFOI");
		tickers.add("CALM");

		for (final String s : YahooData.get(tickers, "f6")) {
			System.out.println(s);
		}
		// if (resp != null) {
		// System.out.println(resp);
		// }
	}

	private static String getFromUrl(String url) throws IOException {
		final StringBuilder sb = new StringBuilder();

		final URL yahooURL = new URL(url);
		final URLConnection yahooURLConnection = yahooURL.openConnection();
		yahooURLConnection.connect();
		String line;
		try (BufferedReader resp = new BufferedReader(new InputStreamReader(yahooURLConnection.getInputStream()))) {
			while ((line = resp.readLine()) != null) {
				sb.append(line + Utils.NL);
			}
		}
		return sb.toString();
	}
	
	public static String getBusinessSummary(String tkr) {
		String url = "http://finance.yahoo.com/q/pr?s=" + tkr + "+Profile";
		String retResp = "N/A";
		try {
		String	response = YahooData.getFromUrl(url);
			int idx1 = response.indexOf("Business Summary");
			int idx2 = response.substring(idx1, response.length()).indexOf("<p>");
			int idx3 = response.substring(idx1, response.length()).indexOf("</p>");
			retResp = response.substring(idx1+idx2+3,idx1+idx3);
		} catch (Exception e) {
			retResp = "N/A";
		}
		return retResp;
	}

	private static void testit() {
		final String tkr = "NVAX";
		System.out.println(getBusinessSummary(tkr));
	}

}
