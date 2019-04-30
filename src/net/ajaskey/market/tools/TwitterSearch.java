
package net.ajaskey.market.tools;

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
public class TwitterSearch {

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		final List<String> symbols = new ArrayList<>();

		final String prefix = "https://twitter.com/search?s=follows&f=tweets&vertical=default&q=";

		symbols.add("$spx");
		symbols.add("$spy");
		symbols.add("$ndx");
		symbols.add("$compq");
		symbols.add("$qqq");
		symbols.add("$dji");
		symbols.add("$dia");
		symbols.add("$nya");
		symbols.add("$rut");
		symbols.add("$iwm");
		symbols.add("$gld");
		symbols.add("$tnx");
		symbols.add("$tlt");
		symbols.add("$dxy");
		symbols.add("$usd");
		symbols.add("$oil");
		symbols.add("$wti");
		symbols.add("$cl_f");
		symbols.add("$xlb");
		symbols.add("$xle");
		symbols.add("$xlf");
		symbols.add("$xli");
		symbols.add("$xlp");
		symbols.add("$xlre");
		symbols.add("$xlu");
		symbols.add("$xlv");
		symbols.add("$xly");
		symbols.add("nasdaq");
		symbols.add("nyse");
		symbols.add("$db");

		String str = prefix;

		int knt = 0;
		for (final String s : symbols) {
			if (knt > 0) {
				str += "%20OR%20" + s;
			}
			else {
				str += s;
			}
			knt++;
		}

		System.out.println(str);

	}

}
