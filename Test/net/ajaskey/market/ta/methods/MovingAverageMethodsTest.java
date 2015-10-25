
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
		final double ema10 = MovingAverageMethods.ema(this.tdSC, 10);
		// System.out.println(ema10);
		Assert.assertEquals(ema10, 22.92, 0.1);
	}

	@Test
	public void testSma10() {
		final double ma = MovingAverageMethods.sma(this.tdSC, 10);
		Assert.assertEquals(ma, 23.13, 0.1);
	}

	@Test
	public void testSma10back20() {
		final double ma = MovingAverageMethods.sma(this.tdSC, 10, 20);
		Assert.assertEquals(ma, 22.22, 0.1);
	}

	@Test
	public void testSma260() {
		final double ma = MovingAverageMethods.sma(this.td.getCloseData(), 260);
		Assert.assertEquals(ma, 105.41, 0.1);
	}

	@Test
	public void testSma260offset() {
		final double ma = MovingAverageMethods.sma(this.td.getCloseData(), 260, 100);
		Assert.assertEquals(ma, 100.49, 0.1);
	}

	@Test
	public void testSma65() {
		final double ma = MovingAverageMethods.sma(this.td.getCloseData(), 65);
		Assert.assertEquals(ma, 106.52, 0.1);
	}

	@Test
	public void testSma65offset() {
		final double ma = MovingAverageMethods.sma(this.td.getCloseData(), 65, 5);
		Assert.assertEquals(ma, 106.79, 0.1);
	}

	@Test
	public void testSmaErr1() {
		final double ma = MovingAverageMethods.sma(this.tdSC, 40);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr2() {
		final double ma = MovingAverageMethods.sma(this.td, 500, 10);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr3() {
		final double ma = MovingAverageMethods.sma(this.td, 20, 1000);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr4() {
		final double ma = MovingAverageMethods.sma(this.td, -20, 10);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr5() {
		final double ma = MovingAverageMethods.sma(this.td, 20, -10);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr6() {
		final TickerData nullTd = null;
		final double ma = MovingAverageMethods.sma(nullTd, 20, 10);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr7() {
		final TickerData nullTd = null;
		final double ma = MovingAverageMethods.sma(nullTd, 20);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr8() {
		final double[] nullTd = null;
		final double ma = MovingAverageMethods.sma(nullTd, 20, 10);
		Assert.assertEquals(ma, 0.0, 0.1);
	}

	@Test
	public void testSmaErr9() {
		final double[] nullTd = null;
		final double ma = MovingAverageMethods.sma(nullTd, 20);
		Assert.assertEquals(ma, 0.0, 0.1);
	}
}
