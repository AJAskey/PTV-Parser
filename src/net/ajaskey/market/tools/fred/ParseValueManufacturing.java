
package net.ajaskey.market.tools.fred;

import java.io.File;

import net.ajaskey.market.tools.optuma.OptumaCommon;

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
public class ParseValueManufacturing {

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		File folder = new File(OptumaCommon.optumaPath + "/Fred-Download/");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (file.getName().toUpperCase().contains("VALUE SHIPMENTS")) {
					String match = getFilePair(file.getName().substring(1, 4), listOfFiles);
					System.out.printf("%s%n%s%n%n", file.getName(), match);
				}
			}
		}

		//

	}

	/**
	 * net.ajaskey.market.tools.fred.getFilePair
	 * 
	 * @param files
	 *
	 * @return
	 */
	private static String getFilePair(String code, File[] files) {

		for (File file : files) {
			if (file.isFile()) {
				if (file.getName().toUpperCase().contains("VALUE TOTAL INVENTORIES")) {
					if (file.getName().substring(1, 4).equalsIgnoreCase(code)) {
						return file.getName();
					}
				}
			}
		}
		return null;
	}

}
