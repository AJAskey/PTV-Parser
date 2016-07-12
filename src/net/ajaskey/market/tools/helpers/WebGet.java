
package net.ajaskey.market.tools.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WebGet {

	private static String NL = System.lineSeparator();

	/**
	 *
	 * @param url
	 * @return
	 */
	public static List<String> getIshares(String url) {

		String response;
		try {
			response = WebGet.getFromUrl(url);
		} catch (final IOException e) {
			response = null;
		}
		boolean found = false;
		final List<String> ret = new ArrayList<>();
		if (response != null) {
			final String[] line = response.split(NL);

			for (final String s : line) {
				final String[] fld = s.split(",");

				if (found) {
					if (!fld[0].matches("^\\W*$")) {
						ret.add(fld[0].replaceAll("\"", ""));
					}
				}

				if (!found && fld[0].contains("Ticker")) {
					found = true;
				}

			}
			// System.out.println(response);
			return ret;
		}
		return null;
	}

	/**
	 *
	 * @param url
	 * @return
	 */
	public static List<String> getSPDR(String url) {

		String response = null;
		try {
			response = WebGet.getFromUrl(url);
		} catch (final IOException e) {
			return null;
		}
		if (response != null) {
			final String[] fld = response.split(NL);
			final List<String> ret = new ArrayList<>();

			for (final String element : fld) {
				ret.add(element);
			}
			return ret;
		}
		return null;
	}

	private static String getFromUrl(String url) throws IOException {
		final StringBuilder sb = new StringBuilder();

		final URL myURL = new URL(url);
		final URLConnection myURLConnection = myURL.openConnection();
		myURLConnection.connect();
		String line;
		try (BufferedReader resp = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()))) {
			while ((line = resp.readLine()) != null) {
				sb.append(line + NL);
			}
		}
		return sb.toString();
	}

}
