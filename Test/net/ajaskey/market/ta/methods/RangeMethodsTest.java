
package net.ajaskey.market.ta.methods;

import java.io.FileNotFoundException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import net.ajaskey.market.ta.TickerData;
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
public class RangeMethodsTest {

	private final TickerData	tdSC;
	private final TickerData	td;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 *
	 */
	public RangeMethodsTest() throws FileNotFoundException, ParseException {
		this.tdSC = ParseData.parseOneFile("TestData\\cs-atr.csv");
		this.tdSC.generateDerived();

		this.td = ParseData.parseOneFile("TestData\\QQQ-27oct2015.txt");
		this.td.generateDerived();
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RangeMethods#avgTrueRange(double[], double[], double[], int)}
	 * .
	 */
	@Test
	public void testAtr() {
		double atr;

		atr = RangeMethods.avgTrueRange(tdSC.getHighData(), tdSC.getLowData(), tdSC.getCloseData(), 14);
		//System.out.println(atr);
		Assert.assertEquals(atr, 1.31, 0.01);

		atr = RangeMethods.avgTrueRange(td.getHighData(), td.getLowData(), td.getCloseData(), 14);
		//System.out.println(atr);
		Assert.assertEquals(atr, 1.79, 0.01);
	}
	
	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RangeMethods#avgTrueRangePercent(double[], double[], double[], int)}
	 * .
	 */
	@Test
	public void testAtrPercent() {
		double atr;

		atr = RangeMethods.avgTrueRangePercent(tdSC.getHighData(), tdSC.getLowData(), tdSC.getCloseData(), 14);
		//System.out.println(atr);
		Assert.assertEquals(atr, 2.70, 0.01);

		atr = RangeMethods.avgTrueRangePercent(td.getHighData(), td.getLowData(), td.getCloseData(), 14);
		//System.out.println(atr);
		Assert.assertEquals(atr, 1.66, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RangeMethods#trueRange(double, double, double)}
	 * .
	 */
	@Test
	public void testTrueRange() {

		double tr = RangeMethods.trueRange(20.0, 11.0, 10.0);
		// System.out.println(tr);
		Assert.assertEquals(tr, 10.00, 0.01);

		tr = RangeMethods.trueRange(this.tdSC.getHigh(10), this.tdSC.getLow(10), this.tdSC.getClose(11));
		// System.out.println(tr);
		Assert.assertEquals(tr, 0.96, 0.01);

		tr = RangeMethods.trueRange(this.tdSC.getHigh(20), this.tdSC.getLow(20), this.tdSC.getClose(21));
		// System.out.println(tr);
		Assert.assertEquals(tr, 0.32, 0.01);
	}

}
