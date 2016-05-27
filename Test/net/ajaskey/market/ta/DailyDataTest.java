
package net.ajaskey.market.ta;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the DailyDaily class.
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
public class DailyDataTest {

	DailyData dd = null;

	/**
	 * net.ajaskey.market.ta.setUp
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeEachTest() throws Exception {
		final Calendar cal = Calendar.getInstance();
		cal.set(1980, Calendar.MARCH, 15, 23, 45);
		this.dd = new DailyData(cal, 1.0, 2.0, 0.5, 1.5, 1000.0, 0.0);
		//System.out.println("before");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getClose()}.
	 */
	@Test
	public void testGetClose() {
		Assert.assertEquals(this.dd.getClose(), 1.5, 0.01);

	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getDailyChg()}.
	 */
	@Test
	public void testGetDailyChg() {
		this.dd.setDailyChg(1.0);
		Assert.assertEquals(this.dd.getDailyChg(), 0.50, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.DailyData#getDailyPercentChg()}.
	 */
	@Test
	public void testGetDailyPercentChg() {
		this.dd.setDailyChg(1.0);
		Assert.assertEquals(this.dd.getDailyPercentChg(), 50.0, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.DailyData#getDailyPercentRng()}.
	 */
	@Test
	public void testGetDailyPercentRng() {
		this.dd.setTrueHigh(5.0);
		this.dd.setTrueLow(1.0);
		this.dd.setDailyChg(1.0);
		Assert.assertEquals(this.dd.getDailyPercentRng(), 300.0, 0.1);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getDailyRng()}.
	 */
	@Test
	public void testGetDailyRng() {
		this.dd.setTrueHigh(5.0);
		this.dd.setTrueLow(1.0);
		this.dd.setDailyChg(1.0);
		Assert.assertEquals(this.dd.getDailyRng(), 4.5, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getDate()}.
	 */
	@Test
	public void testGetDate() {
		final Calendar cal = this.dd.getDate();
		Assert.assertEquals(cal.get(Calendar.YEAR), 1980);
		Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.MARCH);
		Assert.assertEquals(cal.get(Calendar.DATE), 15);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getDaysSinceBase()}.
	 */
	@Test
	public void testGetDaysSinceBase() {
		Assert.assertEquals(this.dd.getDaysSinceBase(), 29292);

	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getHigh()}.
	 */
	@Test
	public void testGetHigh() {
		Assert.assertEquals(this.dd.getHigh(), 2.0, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getLow()}.
	 */
	@Test
	public void testGetLow() {
		Assert.assertEquals(this.dd.getLow(), 0.5, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getOpen()}.
	 */
	@Test
	public void testGetOpen() {
		Assert.assertEquals(this.dd.getOpen(), 1.0, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getTrueHigh()}.
	 */
	@Test
	public void testGetTrueHigh() {
		this.dd.setTrueHigh(1.95);
		Assert.assertEquals(this.dd.getTrueHigh(), 2.0, 0.01);
		this.dd.setTrueHigh(55.5);
		Assert.assertEquals(this.dd.getTrueHigh(), 55.5, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getTrueLow()}.
	 */
	@Test
	public void testGetTrueLow() {
		this.dd.setTrueLow(0.6);
		Assert.assertEquals(this.dd.getTrueLow(), 0.50, 0.01);
		this.dd.setTrueLow(0.43);
		Assert.assertEquals(this.dd.getTrueLow(), 0.43, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#getVolume()}.
	 */
	@Test
	public void testGetVolume() {
		this.dd.setVolume(200.0);
		Assert.assertEquals(this.dd.getVolume(), 200.0, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#setDailyChg(double)}
	 * .
	 */
	@Test
	public void testSetDailyChg() {
		this.dd.setDailyChg(10.0);
		Assert.assertEquals(this.dd.getDailyChg(), -8.5, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#setTrueHigh(double)}
	 * .
	 */
	@Test
	public void testSetTrueHigh() {
		this.dd.setTrueHigh(1.95);
		Assert.assertEquals(this.dd.getTrueHigh(), 2.0, 0.01);
		this.dd.setTrueHigh(55.5);
		Assert.assertEquals(this.dd.getTrueHigh(), 55.5, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#setTrueLow(double)}.
	 */
	@Test
	public void testSetTrueLow() {
		this.dd.setTrueLow(0.6);
		Assert.assertEquals(this.dd.getTrueLow(), 0.50, 0.01);
		this.dd.setTrueLow(0.43);
		Assert.assertEquals(this.dd.getTrueLow(), 0.43, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#setVolume(double)}.
	 */
	@Test
	public void testSetVolume() {
		this.dd.setVolume(100.0);
		Assert.assertEquals(this.dd.getVolume(), 100.0, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.DailyData#toString()}.
	 */
	@Test
	public final void testToString() {
		final Calendar cal = Calendar.getInstance();
		cal.set(1990, Calendar.MARCH, 15, 23, 45);
		this.dd = new DailyData(cal, 100.0, 200.0, 150.5, 111.1, 123456.0, 0.0);
		//System.out.println(this.dd.toString());
		final String expStr = "Thu 15-Mar-1990  100.00  200.00  150.50  111.10 123456 0";
		final String tstStr = this.dd.toString();
		final int cmp = expStr.compareTo(tstStr);
		Assert.assertEquals(cmp, 0);
	}

}
