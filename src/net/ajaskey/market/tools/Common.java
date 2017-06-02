
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class Common {

	public static void delay(long ms) {

		try {
			Thread.sleep(ms);
		} catch (final InterruptedException e) {
		}
	}

	public static List<String> getTickersFromFile(String filename) throws FileNotFoundException, IOException {

		final List<String> ret = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			String line = "";

			while (line != null) {
				line = br.readLine();
				try {
					final String fld[] = line.split("[\\s+,]");
					final String s = fld[0].trim().replace("\"", "");
					if (s.length() > 0) {
						if (!s.substring(0, 1).equals("#")) {
							ret.add(s);
						}
					}
				} catch (final Exception e) {
					// handle errors in data but continue processing
				}
			}
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
