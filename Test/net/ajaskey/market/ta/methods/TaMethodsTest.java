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
package net.ajaskey.market.ta.methods;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;


/**
 * @author Andy Askey
 *
 * PTV-Parser Copyright (c) 2015, Andy Askey. 
 * All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to 
 * deal in the Software without restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION  OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 *
 */
public class TaMethodsTest {
	
	private final TickerData	tdSC;
	
	/**
	 * This method serves as a constructor for the class.
	 * @throws ParseException 
	 * @throws FileNotFoundException 
	 *
	 */
	public TaMethodsTest() throws FileNotFoundException, ParseException {
		this.tdSC = ParseData.parseOneFile("TestData\\cs-rsi.csv");
		this.tdSC.generateDerived();
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcAdvDecl(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcAdvDecl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcAdx(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcAdx() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcATR(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcATR() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcDiMinus(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcDiMinus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcDiPlus(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcDiPlus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcHigh(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcHigh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcIndexMoneyFlow(double[], double[], double[], double[], double[], int)}.
	 */
	//@Test
	public final void testCalcIndexMoneyFlow() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcLinearRegression(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcLinearRegression() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcLinearRegressionAngle(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcLinearRegressionAngle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcLinearRegressionInt(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcLinearRegressionInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcLinearRegressionSlope(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcLinearRegressionSlope() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcLow(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcLow() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcMFI(net.ajaskey.market.ta.TickerData, int)}.
	 */
	//@Test
	public final void testCalcMFI() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcPercentChange(double, double)}.
	 */
	//@Test
	public final void testCalcPercentChange() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcRawRS(net.ajaskey.market.ta.TickerData)}.
	 */
	//@Test
	public final void testCalcRawRS() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcRsi(net.ajaskey.market.ta.TickerData, int)}.
	 */
	@Test
	public final void testCalcRsi() {
		double rsi = tdSC.getRsi14();
		System.out.printf("RSI : %.2f%n",rsi);
		Assert.assertEquals(rsi, 69.78, 0.01);
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcSma(net.ajaskey.market.ta.TickerData, int, net.ajaskey.market.ta.FieldName)}.
	 */
	//@Test
	public final void testCalcSma() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.ajaskey.market.ta.methods.TaMethods#calcSmaTrend(net.ajaskey.market.ta.TickerData, int, net.ajaskey.market.ta.FieldName)}.
	 */
	//@Test
	public final void testCalcSmaTrend() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	//@Test
	public final void testObject() {
		fail("Not yet implemented");
	}

}
