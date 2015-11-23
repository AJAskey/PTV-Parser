
package net.ajaskey.market.ta.methods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;

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
public class MovingAverageMethodsTest {

	private final TickerData	tdSC;
	private final TickerData	td;

	public MovingAverageMethodsTest() throws FileNotFoundException, IOException, ParseException {

		this.tdSC = ParseData.parseOneFile("TestData\\cs-movavg.csv");
		this.tdSC.generateDerived();

		this.td = ParseData.parseOneFile("TestData\\qqq.csv");
		this.td.generateDerived();
	}

	@Test
	public void testEma10() {
		final double ema10 = MovingAverageMethods.ema(this.tdSC.getCloseData(), 10);
		// System.out.println(ema10);
		Assert.assertEquals(ema10, 22.92, 0.1);
	}

	@Test
	public void testEma10a() {
		final double ema10 = MovingAverageMethods.ema(this.td.getCloseData(), 10);
		// System.out.println(ema10);
		Assert.assertEquals(ema10, 108.51, 0.1);
	}

	@Test
	public void testEma25() {
		final double ema25 = MovingAverageMethods.ema(this.td.getCloseData(), 25);
		System.out.println(ema25);
		Assert.assertEquals(ema25, 106.76, 0.1);
	}
}
