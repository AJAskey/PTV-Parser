
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

	private static TickerData	tdQQQ	= null;
	private static Calendar		cal		= Calendar.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cal.set(1980, Calendar.MARCH, 15, 23, 45);
		tdQQQ = ParseData.parseOneFile("TestData\\QQQ-TickerDataTest.txt");
		tdQQQ.generateDerived(false);
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
		List<TickerData> tdList = new ArrayList<>();
		dirs.add("TestData\\ASCII\\NASDAQ");
		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException | ParseException e) {
			fail("Exception raised.");
		}
		Assert.assertEquals(tdList.size(), 0);

		dirs.add("TestData\\ASCII\\NASDAQ");
		ParseData.setValidTicker("MSFT");
		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException | ParseException e) {
			fail("Exception raised.");
		}
		Assert.assertEquals(tdList.size(), 1);

		dirs.clear();
		dirs.add("crapdir");
		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException e1) {

		} catch (ParseException e2) {
			fail("Exception raised.");
		}

		dirs.clear();
		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException e1) {

		} catch (ParseException e2) {
			fail("Exception raised.");
		}

	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#clearTickerData(java.util.List)}.
	 */
	@Test
	public void testClearTickerDataListOfTickerData() {
		List<String> dirs = new ArrayList<>();
		List<TickerData> tdList = new ArrayList<>();
		dirs.add("TestData\\ASCII\\NASDAQ");
		ParseData.setValidTicker("MSFT");
		ParseData.setValidTicker("NVAX");
		ParseData.setValidTicker("QCOM");

		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Exception raised.");
		} catch (ParseException e) {
			e.printStackTrace();
			fail("Exception raised.");
		}
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#clearTickerData(net.ajaskey.market.ta.TickerData)}
	 * .
	 */
	@Test
	public void testClearTickerDataTickerData() {
		Assert.assertEquals(tdQQQ.getDataCount(), 83);
		TickerData.clearTickerData(tdQQQ);
		Assert.assertEquals(tdQQQ.getDataCount(), 0);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDataOfDate(net.ajaskey.market.ta.TickerData, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetDataOfDateTickerDataCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, Calendar.SEPTEMBER, 8);
		DailyData dd = TickerData.getDataOfDate(tdQQQ, cal);
		Assert.assertEquals(dd.getClose(), 105.04, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getDataOfDate(net.ajaskey.market.ta.TickerData, int, int, int)}
	 * .
	 */
	@Test
	public void testGetDataOfDateTickerDataIntIntInt() {
		DailyData dd = TickerData.getDataOfDate(tdQQQ, 2015,Calendar.SEPTEMBER,8);
		Assert.assertEquals(dd.getClose(), 105.04, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getFromList(java.lang.String, java.util.List)}
	 * .
	 */
	@Test
	public void testGetFromList() {
		List<String> dirs = new ArrayList<>();
		List<TickerData> tdList = new ArrayList<>();
		dirs.add("TestData\\ASCII\\NASDAQ");
		ParseData.setValidTicker("MSFT");
		ParseData.setValidTicker("NVAX");
		ParseData.setValidTicker("QCOM");

		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Exception raised.");
		} catch (ParseException e) {
			e.printStackTrace();
			fail("Exception raised.");
		}
		TickerData td = TickerData.getFromList("MSFT", tdList);
		Assert.assertEquals(td.getTicker(), "MSFT");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getIndexOfDate(net.ajaskey.market.ta.TickerData, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetIndexOfDateTickerDataCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, Calendar.SEPTEMBER, 8);
		int idx = TickerData.getIndexOfDate(tdQQQ, cal);
		Assert.assertEquals(idx, 33);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getIndexOfDate(net.ajaskey.market.ta.TickerData, int, int, int)}
	 * .
	 */
	@Test
	public void testGetIndexOfDateTickerDataIntIntInt() {
		int idx = TickerData.getIndexOfDate(tdQQQ, 2015, Calendar.SEPTEMBER, 8);
		Assert.assertEquals(idx, 33);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getSlice(net.ajaskey.market.ta.TickerData, java.util.Calendar, int)}
	 * .
	 */
	@Test
	public void testGetSlice() {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, Calendar.SEPTEMBER, 8);
		List<DailyData> ddList = TickerData.getSlice(tdQQQ, cal, 5);
		Assert.assertEquals(ddList.get(1).getClose(), 102.16, 0.01);

	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTickerData(java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testGetTickerData() {
		Assert.assertEquals(tdQQQ.getTicker(), "QQQ");
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#getTradingDays(net.ajaskey.market.ta.TickerData, java.util.Calendar, java.util.Calendar)}
	 * .
	 */
	@Test
	public void testGetTradingDays() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2015, Calendar.SEPTEMBER, 8);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2015, Calendar.OCTOBER, 20);
		int td = TickerData.getTradingDays(tdQQQ, cal1, cal2);
		Assert.assertEquals(td, 30);
		td = TickerData.getTradingDays(tdQQQ, cal2, cal1);
		Assert.assertEquals(td, 0);
	}


	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.TickerData#fillDataArrays(int, boolean)}.
	 * @throws ParseException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testFillDataArrays() throws FileNotFoundException, ParseException {
		List<String> dirs = new ArrayList<>();
		List<TickerData> tdList = new ArrayList<>();
		dirs.add("TestData\\ASCII\\NASDAQ");
		ParseData.setValidTicker("MSFT");
		ParseData.setValidTicker("NVAX");
		ParseData.setValidTicker("QCOM");

		try {
			tdList = TickerData.build(dirs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Exception raised.");
		} catch (ParseException e) {
			e.printStackTrace();
			fail("Exception raised.");
		}
		TickerData td = TickerData.getFromList("MSFT", tdList);
		Assert.assertNotNull(td.getCloseData());

	}



}
