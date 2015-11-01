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

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

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
public class DailyDataTest {

	private Calendar	cal	= null;
	private DailyData	dd	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DailyDataTest() {
		this.cal = Calendar.getInstance();
		this.cal.set(Calendar.YEAR, 2015);
		this.cal.set(Calendar.DAY_OF_YEAR, 74);
		this.dd = new DailyData(this.cal, 10.0, 12.0, 9.0, 11.0, 123456);
	}

	@Test
	public final void testDailyChg() {
		this.dd.setDailyChg(10.0);
		Assert.assertEquals(this.dd.getDailyChg(), 1.0, 0.1);
		Assert.assertEquals(this.dd.getDailyPercentChg(), 10.0, 0.1);
	}

	@Test
	public final void testDailyRng() {
		this.dd.setTrueHigh(this.dd.getHigh());
		this.dd.setTrueLow(this.dd.getLow());
		this.dd.setDailyChg(10.0);
		Assert.assertEquals(this.dd.getDailyRng(), 3.0, 0.1);
		Assert.assertEquals(this.dd.getDailyPercentRng(), 27.27, 0.1);
	}

	@Test
	public final void testData() {
		Assert.assertEquals(this.dd.getOpen(), 10.0, 0.1);
		Assert.assertEquals(this.dd.getHigh(), 12.0, 0.1);
		Assert.assertEquals(this.dd.getLow(), 9.0, 0.1);
		Assert.assertEquals(this.dd.getClose(), 11.0, 0.1);
		Assert.assertEquals(this.dd.getVolume(), 123456.0, 0.1);
	}

	@Test
	public final void testToString() {
		System.out.println(this.dd.toString());
		final String tstStr = "15-Mar-2015  10.00  12.00  9.00  11.00 123456";
		final int cmp = tstStr.compareTo(this.dd.toString());
		Assert.assertEquals(cmp, 0);
	}

	@Test
	public final void testTrueHigh() {
		this.dd.setTrueHigh(13.0);
		Assert.assertEquals(this.dd.getTrueHigh(), 13.0, 0.1);

		this.dd.setTrueHigh(10.0);
		Assert.assertEquals(this.dd.getTrueHigh(), 12.0, 0.1);
	}

	@Test
	public final void testTrueLow() {
		this.dd.setTrueLow(7.0);
		Assert.assertEquals(this.dd.getTrueLow(), 7.0, 0.1);

		this.dd.setTrueLow(10.0);
		Assert.assertEquals(this.dd.getTrueLow(), 9.0, 0.1);
	}
}
