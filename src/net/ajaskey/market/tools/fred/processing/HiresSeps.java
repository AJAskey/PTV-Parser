
package net.ajaskey.market.tools.fred.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.ajaskey.market.tools.fred.FredCommon;

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
public class HiresSeps {

	/**
	 * net.ajaskey.market.tools.fred.findFullName
	 *
	 * @param tmp1
	 * @param files
	 * @return
	 */
	private static String findFullName(String title, List<File> files) {

		for (final File file : files) {
			final String name = file.getName();
			if (name.startsWith("[JTU")) {
				if (name.contains("HIL]")) {
					if (name.contains(title)) {
						final String ret = file.getName().replace("HIL]", "DIFF]").replace("Hires", "HiresMinusSeparations");
						return ret;
					}
				}
			}
		}

		return null;
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final File folder = new File(FredCommon.fredPath);

		final List<String> jtuList = new ArrayList<>();

		final String[] ext = new String[] { "csv" };
		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (final File file : files) {
			final String name = file.getName();
			if (name.startsWith("JTU")) {
				jtuList.add(name);
			}
		}

		for (final String s1 : jtuList) {
			if (s1.contains("HIL.csv")) {
				final String tmp1 = s1.replace("HIL.csv", "").trim();
				for (final String s2 : jtuList) {
					if (s2.contains("TSL.csv")) {
						final String tmp2 = s2.replace("TSL.csv", "");
						if (tmp2.equals(tmp1)) {
							final String fullname = HiresSeps.findFullName(tmp1, files);
							System.out.println(fullname);
							IngestOptumaFile.process(FredCommon.fredPath + s1, FredCommon.fredPath + s2, fullname);
						}
					}
				}
			}
		}
	}
}
