
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
public class MoveNewEOD {

	public static void main(final String[] args) {

		final String dest = "C:\\Data\\EODData\\DataClient\\ASCII\\";

		MoveNewEOD.moveFile(dest);
	}

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 */
	public static void moveFile(final String path) {

		final File downloads = new File("C:\\Users\\Andy\\Downloads");
		final File flist[] = downloads.listFiles();

		for (final File f : flist) {
			File to = null;
			if (f.getName().toUpperCase().contains("NYSE_2019")) {
				to = new File(path + "NYSE\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("NASDAQ_2019")) {
				to = new File(path + "NASDAQ\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("AMEX_2019")) {
				to = new File(path + "AMEX\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("INDEX_2019")) {
				to = new File(path + "INDEX\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("COMEX_2019")) {
				to = new File(path + "COMEX\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("CME_2019")) {
				to = new File(path + "CME\\" + f.getName());
			}
			else if (f.getName().toUpperCase().contains("NYMEX_2019")) {
				to = new File(path + "NYMEX\\" + f.getName());
			}

			try {
				if (to != null) {
					Files.move(f.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
					System.out.println(f.getAbsolutePath());
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

	}

}
