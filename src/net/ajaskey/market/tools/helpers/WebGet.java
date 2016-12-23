
package net.ajaskey.market.tools.helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.Utils;

public class WebGet {

	/**
	 *
	 * @param url
	 * @return
	 */
	public static List<String> getIshares(String url) {

		String response;
		try {
			response = Utils.getFromUrl(url);
		} catch (final IOException e) {
			response = null;
		}
		boolean found = false;
		final List<String> ret = new ArrayList<>();
		if (response != null) {
			final String[] line = response.split(Utils.NL);

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
			response = Utils.getFromUrl(url);
		} catch (final IOException e) {
			return null;
		}
		if (response != null) {
			final String[] fld = response.split(Utils.NL);
			final List<String> ret = new ArrayList<>();

			for (final String element : fld) {
				ret.add(element);
			}
			return ret;
		}
		return null;
	}

}
