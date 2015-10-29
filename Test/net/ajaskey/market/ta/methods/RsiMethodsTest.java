
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
public class RsiMethodsTest {

	private final TickerData tdSC;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 *
	 */
	public RsiMethodsTest() throws FileNotFoundException, ParseException {
		this.tdSC = ParseData.parseOneFile("TestData\\cs-rsi.csv");
		this.tdSC.generateDerived();
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RsiMethods#calcAvgGain(double[], int)}
	 * .
	 */
	@Test
	public final void testCalcAvgGain() {
		final double avgGain = RsiMethods.calcAvgGain(this.tdSC.getCloseData(), 14);
		// System.out.println(avgGain);
		Assert.assertEquals(avgGain, 0.18, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RsiMethods#calcAvgLoss(double[], int)}
	 * .
	 */
	@Test
	public final void testCalcAvgLoss() {
		final double avgLoss = RsiMethods.calcAvgLoss(this.tdSC.getCloseData(), 14);
		// System.out.println(avgLoss);
		Assert.assertEquals(avgLoss, 0.30, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RsiMethods#calcRS(double[], int)} .
	 */
	@Test
	public final void testCalcRS() {
		final double rs = RsiMethods.calcRS(this.tdSC.getCloseData(), 14);
		// System.out.println(rs);
		Assert.assertEquals(rs, 0.61, 0.01);
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.RsiMethods#calcRSI(double[], int)} .
	 */
	@Test
	public final void testCalcRSI() {
		final double rsi = RsiMethods.calcRSI(this.tdSC.getCloseData(), 14);
		// System.out.println(rsi);
		Assert.assertEquals(rsi, 37.77, 0.02);
	}
}
