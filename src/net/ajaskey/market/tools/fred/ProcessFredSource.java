
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class ProcessFredSource {

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		String charset = "UTF-8";
		String line;
		try (BufferedReader in = new BufferedReader(
		    new InputStreamReader(new FileInputStream("data/cpi.html"), charset))) {

			int knt = 0;
			while ((line = in.readLine()) != null) {
				knt++;
				try {
					//final String str = new String(line.getBytes("US-ASCII"));
					final String str = line.trim();
					//System.out.println(str);
					if (str.length() > 1) {
						if (!str.contains("DISCONTINUED")) {
							if (knt > 0) {
								int idx1 = str.toLowerCase().indexOf("\"/series/");
								if (idx1 >= 0) {
									int idx2 = str.toLowerCase().indexOf("series-title");
									if (idx2 > 5) {
										String code1 = str.substring(idx1 + 1, idx2);
										int idx3 = code1.indexOf('"');
										String code = code1.substring(0, idx3).replaceAll("/series/", "");

										String title1 = str.substring(idx2);
										int idx4 = title1.indexOf('>') + 1;
										String title = title1.substring(idx4).replaceAll("</a>", "").replaceAll("&#039;", " -");

										System.out.println(code + "\t" + FredCommon.cleanTitle(title));

									}
								}
							}
						}
					}
				} catch (Exception e) {
				}

			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

}
