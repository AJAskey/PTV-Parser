/**
 *
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey All rights reserved.
 *
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
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */

package net.ajaskey.market.ta.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ajaskey.market.ta.TickerData;

/**
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
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
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class ParseDataTest {

	@Test
	public void testParseFileErr1() {
		boolean pass = false;
		try {
			ParseData.parseFile(null);
		} catch (final FileNotFoundException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseFileErr1a() {
		boolean pass = false;
		try {
			ParseData.parseFile(new File("bad.filename"));
		} catch (final FileNotFoundException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseFileErr2() throws IOException {
		boolean pass = false;
		try {
			ParseData.parseFile(new File("TestData\\dummy.txt"));
		} catch (final ParseException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseFileErr3() throws IOException {
		boolean pass = false;
		ParseData.setValidTicker("AAL");
		ParseData.setValidTicker("AAME");
		ParseData.setValidTicker("AAOI");
		try {
			ParseData.parseFile(new File("TestData\\NASDAQ_dummy.csv"));
		} catch (final ParseException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseOneFile() throws FileNotFoundException, IOException, ParseException {
		final TickerData td = ParseData.parseOneFile("TestData\\QQQ.csv");
		Assert.assertEquals(td.getClose(0), 112.78, 0.1);
		Assert.assertEquals(td.getOpen(16), 101.94, 0.1);
		Assert.assertEquals(td.getHigh(456), 85.65, 0.1);
		Assert.assertEquals(td.getLow(205), 102.38, 0.1);
	}

	@Test
	public void testParseOneFileErr1() {
		boolean pass = false;
		try {
			ParseData.parseOneFile(null);
		} catch (final FileNotFoundException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseOneFileErr1a() {
		boolean pass = false;
		try {
			ParseData.parseOneFile("bad.filename");
		} catch (final FileNotFoundException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseOneFileErr2() throws IOException {
		boolean pass = false;
		try {
			ParseData.parseOneFile("TestData\\dummy.txt");
		} catch (final ParseException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseOneFileErr3() throws IOException {
		boolean pass = false;
		try {
			ParseData.parseOneFile("TestData\\dummy2.txt");
		} catch (final ParseException e) {
			pass = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pass);
	}

	@Test
	public void testParseFile1() throws FileNotFoundException, ParseException {
		ParseData.setValidTicker("QQQ");
		ParseData.setValidTicker("MSFT");
		ParseData.setValidTicker("NVAX");
		ParseData.setValidTicker("xyz");
		List<TickerData> tdAll = ParseData.parseFile(new File("TestData\\NASDAQ\\NASDAQ_20150921.csv"));
		System.out.println(tdAll.size());
		Assert.assertEquals(tdAll.size(), 3);
	}
}
