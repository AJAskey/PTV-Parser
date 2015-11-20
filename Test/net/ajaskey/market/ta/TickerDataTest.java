/**
 *
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

package net.ajaskey.market.ta;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ajaskey.market.ta.input.ParseData;

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
public class TickerDataTest {

	List<TickerData> tdList = new ArrayList<TickerData>();

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#addData(net.ajaskey.market.ta.DailyData)}
	 * .
	 */
	// @Test
	public final void testAddData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#build(java.util.List)}.
	 */
	@Test
	public final void testBuildErr1() {
		boolean valid = false;
		final List<String> fnames = null;
		try {
			TickerData.build(fnames);
		} catch (final FileNotFoundException e) {
			valid = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(valid);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#build(java.util.List)}.
	 */
	@Test
	public final void testBuildErr2() {
		boolean valid = false;
		final List<String> fnames = new ArrayList<String>();
		try {
			TickerData.build(fnames);
		} catch (final FileNotFoundException e) {
			valid = true;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(valid);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#generateDerived()}.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	@Test
	public final void testGenerateDerived() throws FileNotFoundException, ParseException {

		final TickerData td = ParseData.parseOneFile("TestData\\QQQ.csv");
		Assert.assertEquals(td.getClose(0), 112.78, 0.01);
		Assert.assertEquals(td.getOpen(16), 101.94, 0.01);
		Assert.assertEquals(td.getHigh(456), 85.65, 0.01);
		Assert.assertEquals(td.getLow(205), 102.38, 0.01);

		Assert.assertEquals(td.getChg23(), 8.34, 0.01);
		Assert.assertEquals(td.getChg65(), 0.76, 0.01);
		Assert.assertEquals(td.getChg130(), 4.86, 0.01);
		Assert.assertEquals(td.getChg260(), 22.63, 0.01);

		Assert.assertEquals(td.getHigh260(), 114.11, 0.01);
		Assert.assertEquals(td.getLow260(), 84.53, 0.01);

		Assert.assertEquals(td.getSma23(), 105.59, 0.01);
		Assert.assertEquals(td.getSma65(), 106.52, 0.01);
		Assert.assertEquals(td.getSma130(), 107.77, 0.01);
		Assert.assertEquals(td.getSma260(), 105.41, 0.01);
		Assert.assertEquals((int) td.getAvgVol65(), 40911412);

		Assert.assertEquals(td.getPriceOffHigh260(), -1.17, 0.01);
		Assert.assertEquals(td.getPriceOffLow260(), 33.42, 0.01);
		Assert.assertEquals(td.getPriceInRng260(), 0.96, 0.01);

		Assert.assertEquals(td.getAtr23(), 1.84, 0.01);
		Assert.assertEquals(td.getAtrPercent23(), 1.74, 0.01);

		Assert.assertEquals(td.getRsRaw(), 16.22, 0.01);
		Assert.assertEquals(td.getRsStRaw(), 5.84, 0.01);

		Assert.assertEquals((int) td.getDaysOfData(), 457);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#GetDateOfDate()}.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	@Test
	public final void testGetDataOfDate() throws FileNotFoundException, ParseException {
		final TickerData td = ParseData.parseOneFile("TestData\\QQQ.csv");

		DailyData dd = TickerData.getDataOfDate(td, 2015, 4, 31);
		//Assert.assertNull(dd);

		dd = TickerData.getDataOfDate(td, 2015, 15, 31);
		Assert.assertNull(dd);

		dd = TickerData.getDataOfDate(td, 1999, 12, 31);
		Assert.assertNull(dd);

		dd = TickerData.getDataOfDate(td, 2017, 12, 31);
		//Assert.assertNull(dd);

		dd = TickerData.getDataOfDate(td, 2015, 3, 20);
		System.out.println(dd.toString());
		//Assert.assertEquals(dd.getClose(), 108.02, 0.01);

	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#GetIndexOfDate()}.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	@Test
	public final void testGetIndexOfDate() throws FileNotFoundException, ParseException {
		final TickerData td = ParseData.parseOneFile("TestData\\QQQ.csv");

		int idx = TickerData.getIndexOfDate(td, 2015, 3, 15);
		//Assert.assertEquals(idx, 155);

		idx = TickerData.getIndexOfDate(td, 2015, 3, 20);
	//	System.out.println(idx + "\t" + td.getData().get(idx).toString());
		//Assert.assertEquals(idx, 151);

		idx = TickerData.getIndexOfDate(td, 2014, 11, 20);
	//	System.out.println(idx + "\t" + td.getData().get(idx).toString());
	//	Assert.assertEquals(idx, 232);

		idx = TickerData.getIndexOfDate(td, 2010, 11, 20);
	//	Assert.assertEquals(idx, -1);

	}

}
