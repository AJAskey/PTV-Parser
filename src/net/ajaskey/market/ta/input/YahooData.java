
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

	/**
	 *
	 * net.ajaskey.market.ta.input.get
	 *
	 * @param tickers
	 * @param command
	 * @return
	 */
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

	/**
	 *
	 * net.ajaskey.market.ta.input.getBusinessSummary
	 *
	 * @param tkr
	 * @return
	 */
	public static String getBusinessSummary(String tkr) {
		final String url = "http://finance.yahoo.com/q/pr?s=" + tkr + "+Profile";
		String retResp = "N/A";
		try {
			final String response = YahooData.getFromUrl(url);
			final int idx1 = response.indexOf("Business Summary");
			if (idx1 > 100) {
				final int idx2 = response.substring(idx1, response.length()).indexOf("<p>");
				final int idx3 = response.substring(idx1, response.length()).indexOf("</p>");
				retResp = response.substring(idx1 + idx2 + 3, idx1 + idx3);
			}
		} catch (final Exception e) {
			retResp = "N/A";
		}
		return retResp;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getSectorIndustry
	 *
	 * @param tkr
	 * @return
	 */
	public static String[] getSectorIndustry(String tkr) {
		final String url = "http://finance.yahoo.com/q/in?s=" + tkr + "+Industry";
		final String retResp[] = { "N/A", "N/A" };
		try {
			final String response = YahooData.getFromUrl(url);
			int idx1 = response.indexOf("Sector:");
			if (idx1 > 100) {
				int idx2 = response.substring(idx1).indexOf(".html");
				if (idx2 > 0) {
					int idx3 = response.substring(idx1 + idx2 + 6).indexOf("<");
					if (idx3 > 0) {
						final String sector = response.substring(idx1 + idx2 + 7, idx1 + idx2 + 6 + idx3);
						if (sector.length() < 25) {
							retResp[0] = sector;

							final int idx0 = idx1 + idx2 + 6 + idx3 + 1;
							// String s1 = response.substring(idx0);
							idx1 = response.substring(idx0).indexOf("Industry:");
							// String s2 = response.substring(idx0 + idx1);
							idx2 = response.substring(idx0 + idx1).indexOf(".html");
							// String s3 = response.substring(idx0 + idx1 + idx2 + 6);
							idx3 = response.substring(idx0 + idx1 + idx2 + 6).indexOf("<");
							final String ind = response.substring(idx0 + idx1 + idx2 + 7, idx0 + idx1 + idx2 + 6 + idx3);
							if (ind.length() < 65) {
								retResp[1] = ind.replaceAll("&amp;", "&");
							}
						}
					}
				}
			}
		} catch (final Exception e) {
			retResp[0] = "N/A";
			retResp[1] = "N/A";
		}
		return retResp;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		YahooData.testit();

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
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getFromUrl
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 */
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

	/**
	 * Test only
	 *
	 * net.ajaskey.market.ta.input.testit
	 *
	 */
	private static void testit() {
		final String tkr = "rcii";
		final String[] secind = YahooData.getSectorIndustry(tkr);
		for (final String str : secind) {
			System.out.println(str);
		}
		final String mc = YahooData.get(tkr, "f6j1");
		Double.parseDouble(mc.trim());

		System.out.println(mc);
	}

}
