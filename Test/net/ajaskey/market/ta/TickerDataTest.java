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

		Assert.assertEquals(td.getRsRaw(), 13.10, 0.01);
		Assert.assertEquals((int) td.getDaysOfData(), 457);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAdx()}.
	 */
	// @Test
	public final void testGetAdx() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAtr23()}.
	 */
	// @Test
	public final void testGetAtr23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAtrPercent23()}.
	 */
	// @Test
	public final void testGetAtrPercent23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAvgVol65()}.
	 */
	// @Test
	public final void testGetAvgVol65() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#generateDerived()}.
	 */

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg130()}.
	 */
	// @Test
	public final void testGetChg130() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg23()}.
	 */
	// @Test
	public final void testGetChg23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg260()}.
	 */
	// @Test
	public final void testGetChg260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg65()}.
	 */
	// @Test
	public final void testGetChg65() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getClose(int)}.
	 */
	// @Test
	public final void testGetClose() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getCloseData()}.
	 */
	// @Test
	public final void testGetCloseData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getCurrentPrice()}.
	 */
	// @Test
	public final void testGetCurrentPrice() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDailyField(net.ajaskey.market.ta.TickerData, net.ajaskey.market.ta.FieldName)}
	 * .
	 */
	// @Test
	public final void testGetDailyField() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getData()}.
	 */
	// @Test
	public final void testGetData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDaysOfData()}.
	 */
	// @Test
	public final void testGetDaysOfData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDiMinus()}.
	 */
	// @Test
	public final void testGetDiMinus() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDiPlus()}.
	 */
	// @Test
	public final void testGetDiPlus() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getFromList(java.lang.String, java.util.List)}
	 * .
	 */
	// @Test
	public final void testGetFromList() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHigh(int)}.
	 */
	// @Test
	public final void testGetHigh() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHigh260()}.
	 */
	// @Test
	public final void testGetHigh260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHighData()}.
	 */
	// @Test
	public final void testGetHighData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLow(int)}.
	 */
	// @Test
	public final void testGetLow() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLow260()}.
	 */
	// @Test
	public final void testGetLow260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLowData()}.
	 */
	// @Test
	public final void testGetLowData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLr260()}.
	 */
	// @Test
	public final void testGetLr260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrAngle260()}.
	 */
	// @Test
	public final void testGetLrAngle260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrInt260()}.
	 */
	// @Test
	public final void testGetLrInt260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrSlope260()}.
	 */
	// @Test
	public final void testGetLrSlope260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi130()}.
	 */
	// @Test
	public final void testGetMfi130() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi14()}.
	 */
	// @Test
	public final void testGetMfi14() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi23()}.
	 */
	// @Test
	public final void testGetMfi23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi65()}.
	 */
	// @Test
	public final void testGetMfi65() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getOpen(int)}.
	 */
	// @Test
	public final void testGetOpen() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getOpenData()}.
	 */
	// @Test
	public final void testGetOpenData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getPriceInRng260()}
	 * .
	 */
	// @Test
	public final void testGetPriceInRng260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getPriceOffHigh260()}.
	 */
	// @Test
	public final void testGetPriceOffHigh260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getPriceOffLow260()}.
	 */
	// @Test
	public final void testGetPriceOffLow260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getRsi14()}.
	 */
	// @Test
	public final void testGetRsi14() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getRsRaw()}.
	 */
	// @Test
	public final void testGetRsRaw() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma130()}.
	 */
	// @Test
	public final void testGetSma130() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma130Trend()}.
	 */
	// @Test
	public final void testGetSma130Trend() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma23()}.
	 */
	// @Test
	public final void testGetSma23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma23Trend()}.
	 */
	// @Test
	public final void testGetSma23Trend() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma260()}.
	 */
	// @Test
	public final void testGetSma260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma260Trend()}.
	 */
	// @Test
	public final void testGetSma260Trend() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma65()}.
	 */
	// @Test
	public final void testGetSma65() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma65Trend()}.
	 */
	// @Test
	public final void testGetSma65Trend() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc130()}.
	 */
	// @Test
	public final void testGetSmaPerc130() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc23()}.
	 */
	// @Test
	public final void testGetSmaPerc23() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc260()}.
	 */
	// @Test
	public final void testGetSmaPerc260() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc65()}.
	 */
	// @Test
	public final void testGetSmaPerc65() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTaMethods()}.
	 */
	// @Test
	public final void testGetTaMethods() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTicker()}.
	 */
	// @Test
	public final void testGetTicker() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTrueHighData()}.
	 */
	// @Test
	public final void testGetTrueHighData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTrueLowData()}.
	 */
	// @Test
	public final void testGetTrueLowData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getVolume(int)}.
	 */
	// @Test
	public final void testGetVolume() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getVolumeData()}.
	 */
	// @Test
	public final void testGetVolumeData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	// @Test
	public final void testObject() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#setTicker(java.lang.String)}.
	 */
	// @Test
	public final void testSetTicker() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#TickerData()}.
	 */
	// @Test
	public final void testTickerData() {
		Assert.fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#TickerData(java.lang.String, java.util.Calendar, double, double, double, double, double)}
	 * .
	 */
	// @Test
	public final void testTickerDataStringCalendarDoubleDoubleDoubleDoubleDouble() {
		Assert.fail("Not yet implemented");
	}

}
