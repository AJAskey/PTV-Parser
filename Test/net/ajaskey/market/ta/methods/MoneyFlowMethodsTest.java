
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
public class MoneyFlowMethodsTest {

	private final TickerData tdSC;

	/**
	 * This method serves as a constructor for the class.
	 * 
	 * @throws ParseException
	 * @throws FileNotFoundException
	 *
	 */
	public MoneyFlowMethodsTest() throws FileNotFoundException, ParseException {
		this.tdSC = ParseData.parseOneFile("TestData\\cs-mfi.csv");
		this.tdSC.generateDerived();
	}

	/**
	 * Test method for
	 * {@link net.ajaskey.market.ta.methods.MoneyFlowMethods#mfi(double[], double[], double[], double[], int)}
	 * .
	 */
	@Test
	public final void testMfi() {
		final double mfi = MoneyFlowMethods.mfi(this.tdSC.getHighData(), this.tdSC.getLowData(), this.tdSC.getCloseData(),
		    this.tdSC.getVolumeData(), 14);
		Assert.assertEquals(mfi, 30.84, 0.01);
	}

}
