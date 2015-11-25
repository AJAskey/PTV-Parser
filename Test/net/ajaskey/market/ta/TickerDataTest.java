
package net.ajaskey.market.ta;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ajaskey.market.ta.input.ParseData;

/**
 * This class...
 *
 * @author Andy Askey
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
public class TickerDataTest {

	private static TickerData tdQQQ = null;
	private static Calendar cal = Calendar.getInstance();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cal.set(1980, Calendar.MARCH, 15, 23, 45);
		tdQQQ = ParseData.parseOneFile("TestData\\QQQ-TickerDataTest.txt");
		tdQQQ.generateDerived();
	}


	/**
	 * net.ajaskey.market.ta.setUp
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeEachTest() throws Exception {

	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#TickerData()}.
	 */
	@Test
	public void testTickerData() {
		Assert.assertEquals(tdQQQ.getDataCount(), 83);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#TickerData(java.lang.String, java.util.Calendar, double, double, double, double, double)}
	 * .
	 */
	@Test
	public void testTickerDataStringCalendarDoubleDoubleDoubleDoubleDouble() {
		Assert.assertEquals(tdQQQ.getTicker(), "QQQ");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#build(java.util.List)}.
	 */
	@Test
	public void testBuild() {
		List<String> dirs = new ArrayList<>();
		dirs.add("TestData\\NASDAQ");
	  try {
			TickerData.build(dirs);
		} catch (FileNotFoundException | ParseException e) {
			fail("Exception raised.");
		}
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#clearTickerData(java.util.List)}.
	 */
	@Test
	public void testClearTickerDataListOfTickerData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#clearTickerData(net.ajaskey.market.ta.TickerData)}
	 * .
	 */
	@Test
	public void testClearTickerDataTickerData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDataOfDate(net.ajaskey.market.ta.TickerData, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetDataOfDateTickerDataCalendar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDataOfDate(net.ajaskey.market.ta.TickerData, int, int, int)}
	 * .
	 */
	@Test
	public void testGetDataOfDateTickerDataIntIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getFromList(java.lang.String, java.util.List)}
	 * .
	 */
	@Test
	public void testGetFromList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getIndexOfDate(net.ajaskey.market.ta.TickerData, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetIndexOfDateTickerDataCalendar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getIndexOfDate(net.ajaskey.market.ta.TickerData, int, int, int)}
	 * .
	 */
	@Test
	public void testGetIndexOfDateTickerDataIntIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getSlice(net.ajaskey.market.ta.TickerData, java.util.Calendar, int)}
	 * .
	 */
	@Test
	public void testGetSlice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTickerData(java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testGetTickerData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTradingDays(net.ajaskey.market.ta.TickerData, java.util.Calendar, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetTradingDays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#mergeData(net.ajaskey.market.ta.TickerData, net.ajaskey.market.ta.TickerData)}
	 * .
	 */
	@Test
	public void testMergeData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#sortDailyData(net.ajaskey.market.ta.TickerData, boolean)}
	 * .
	 */
	@Test
	public void testSortDailyData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#addData(net.ajaskey.market.ta.DailyData)}
	 * .
	 */
	@Test
	public void testAddData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#DailyDataString(int)}.
	 */
	@Test
	public void testDailyDataString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#fillDataArrays(int, boolean)}.
	 */
	@Test
	public void testFillDataArrays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#generateDerived()}.
	 */
	@Test
	public void testGenerateDerived() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#generateDerived(int)}.
	 */
	@Test
	public void testGenerateDerivedInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAdx()}.
	 */
	@Test
	public void testGetAdx() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAtr23()}.
	 */
	@Test
	public void testGetAtr23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAtrPercent23()}.
	 */
	@Test
	public void testGetAtrPercent23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAvgVol20()}.
	 */
	@Test
	public void testGetAvgVol20() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getAvgVol65()}.
	 */
	@Test
	public void testGetAvgVol65() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg()}.
	 */
	@Test
	public void testGetChg() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg130()}.
	 */
	@Test
	public void testGetChg130() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg23()}.
	 */
	@Test
	public void testGetChg23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg260()}.
	 */
	@Test
	public void testGetChg260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getChg65()}.
	 */
	@Test
	public void testGetChg65() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getClose(int)}.
	 */
	@Test
	public void testGetClose() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getCloseData()}.
	 */
	@Test
	public void testGetCloseData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getCurrentPrice()}.
	 */
	@Test
	public void testGetCurrentPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDailyDataString(int)}.
	 */
	@Test
	public void testGetDailyDataString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDataCount()}.
	 */
	@Test
	public void testGetDataCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDate(int)}.
	 */
	@Test
	public void testGetDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDateData()}.
	 */
	@Test
	public void testGetDateData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDaysOfData()}.
	 */
	@Test
	public void testGetDaysOfData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDiMinus()}.
	 */
	@Test
	public void testGetDiMinus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getDiPlus()}.
	 */
	@Test
	public void testGetDiPlus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getFundies()}.
	 */
	@Test
	public void testGetFundies() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHigh(int)}.
	 */
	@Test
	public void testGetHigh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHigh260()}.
	 */
	@Test
	public void testGetHigh260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getHighData()}.
	 */
	@Test
	public void testGetHighData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLow(int)}.
	 */
	@Test
	public void testGetLow() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLow260()}.
	 */
	@Test
	public void testGetLow260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLowData()}.
	 */
	@Test
	public void testGetLowData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLr260()}.
	 */
	@Test
	public void testGetLr260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrAngle260()}.
	 */
	@Test
	public void testGetLrAngle260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrInt260()}.
	 */
	@Test
	public void testGetLrInt260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getLrSlope260()}.
	 */
	@Test
	public void testGetLrSlope260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi130()}.
	 */
	@Test
	public void testGetMfi130() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi14()}.
	 */
	@Test
	public void testGetMfi14() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi23()}.
	 */
	@Test
	public void testGetMfi23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getMfi65()}.
	 */
	@Test
	public void testGetMfi65() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getOpen(int)}.
	 */
	@Test
	public void testGetOpen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getOpenData()}.
	 */
	@Test
	public void testGetOpenData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getPriceInRng260()}
	 * .
	 */
	@Test
	public void testGetPriceInRng260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getPriceOffHigh260()}.
	 */
	@Test
	public void testGetPriceOffHigh260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getPriceOffLow260()}.
	 */
	@Test
	public void testGetPriceOffLow260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getRsi14()}.
	 */
	@Test
	public void testGetRsi14() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getRsRaw()}.
	 */
	@Test
	public void testGetRsRaw() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getRsStRaw()}.
	 */
	@Test
	public void testGetRsStRaw() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma130()}.
	 */
	@Test
	public void testGetSma130() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma130Trend()}.
	 */
	@Test
	public void testGetSma130Trend() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma23()}.
	 */
	@Test
	public void testGetSma23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma23Trend()}.
	 */
	@Test
	public void testGetSma23Trend() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma260()}.
	 */
	@Test
	public void testGetSma260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma260Trend()}.
	 */
	@Test
	public void testGetSma260Trend() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma65()}.
	 */
	@Test
	public void testGetSma65() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSma65Trend()}.
	 */
	@Test
	public void testGetSma65Trend() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc130()}.
	 */
	@Test
	public void testGetSmaPerc130() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc23()}.
	 */
	@Test
	public void testGetSmaPerc23() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc260()}.
	 */
	@Test
	public void testGetSmaPerc260() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getSmaPerc65()}.
	 */
	@Test
	public void testGetSmaPerc65() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTaMethods()}.
	 */
	@Test
	public void testGetTaMethods() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTicker()}.
	 */
	@Test
	public void testGetTicker() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTickerExchange()}.
	 */
	@Test
	public void testGetTickerExchange() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTickerName()}.
	 */
	@Test
	public void testGetTickerName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTrueHighData()}.
	 */
	@Test
	public void testGetTrueHighData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getTrueLowData()}.
	 */
	@Test
	public void testGetTrueLowData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTypicalPriceData()}.
	 */
	@Test
	public void testGetTypicalPriceData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getVolume(int)}.
	 */
	@Test
	public void testGetVolume() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.TickerData#getVolumeData()}.
	 */
	@Test
	public void testGetVolumeData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#setTicker(java.lang.String)}.
	 */
	@Test
	public void testSetTicker() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#setTickerExchange(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetTickerExchange() {
		fail("Not yet implemented");
	}

}
