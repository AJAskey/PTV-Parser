
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
public class InventoryShipments {

	/**
	 * 
	 * net.ajaskey.market.tools.fred.processing.findFullName
	 *
	 * @param title
	 * @param files
	 * @return
	 */


	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException {

		final File folder = new File(FredCommon.fredPath);

		final List<String> u6List = new ArrayList<>();

		final String[] ext = new String[] { "csv" };

		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);

		for (final File file : files) {

			final String name = file.getName().trim();
			if ((name.startsWith("U")) && (name.length() == 10)) {
				u6List.add(name);
			}

		}

		for (final String s1 : u6List) {

			if (s1.endsWith("TI.csv")) {

				final String tmp1 = s1.replace("TI.csv", "").trim();
				for (final String s2 : u6List) {

					if (s2.endsWith("VS.csv")) {

						final String tmp2 = s2.replace("VS.csv", "");
						if (tmp2.equals(tmp1)) {

							final String fullname = FredCommon.findFullName(tmp1, files,"[U","TI]", "Total Inventories", "Inventory to Shipments");
							System.out.println(fullname);
							IngestOptumaFile.process(FredCommon.fredPath + s1, FredCommon.fredPath + s2, fullname, IngestOptumaFile.DIVIDE, 1.0);

						}
					}
				}
			}
		}
	}

}
