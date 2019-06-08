
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.misc.Debug;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class UpdateInfoSeriesFile {

	public static boolean validName(String name) {

		boolean ret = true;

		if (name.contains("TREAST-")) {
			ret = false;
		}
		else if (name.contains("Export minus Import")) {
			ret = false;
		}
		else if (name.contains("US Workers Wages per Capita")) {
			ret = false;
		}
		else if (name.contains("SPX Growth vs")) {
			ret = false;
		}
		else if (name.contains("GDP vs ")) {
			ret = false;
		}
		else if (name.contains("DIFF") && name.contains("JTU")) {
			ret = false;
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Debug.init("fred-updatefile.dbg");

		final File folder = new File(FredCommon.fredPath);
		List<DataSeriesInfo> oldList = FredCommon.readSeriesInfo("fred-series-info.txt");

		for (DataSeriesInfo dsi : oldList) {
			System.out.println(dsi.toCsvString());
		}

		final Set<String> uniqCodes = new HashSet<>();

		final String[] ext = new String[] { "csv" };
		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (final File file : files) {
			final String name = file.getName();
			//Ignore derived TREAST files
			if (validName(name)) {
				final String f1 = name.replace(".csv", "");
				final String f2 = f1.replace("[", "").trim();
				final int idx = f2.indexOf("]");
				String f3 = f2;
				if (idx > 0) {
					f3 = f2.substring(0, idx).trim();
				}
				uniqCodes.add(f3);
			}
		}

		final List<String> codes = new ArrayList<>(uniqCodes);
		Collections.sort(codes);

		for (String s : codes) {
			//System.out.println(s);
			boolean found = false;
			for (DataSeriesInfo ol : oldList) {
				if (ol.getName().equalsIgnoreCase(s)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("New found : " + s);
				DataSeriesInfo dsi = new DataSeriesInfo(s, new DateTime());
				if (dsi != null) {
					oldList.add(dsi);
				}
			}
		}

	}

}
