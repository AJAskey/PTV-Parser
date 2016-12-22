
package net.ajaskey.market.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;

/**
 * This class...
 *
 * @author ajask_000
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *         </p>
 * 
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class ConvertOptuma {

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/ted-spread.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spx-yield.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spx-mcclellan-sum.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spx-mcclellan-osc.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/gaap_spx.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpci.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpce.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-call-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-put-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-call-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-put-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rydex-bull.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rydex-bear.html").toPath());

	}
}