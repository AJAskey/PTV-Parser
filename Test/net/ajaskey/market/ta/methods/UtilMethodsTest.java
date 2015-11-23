
package net.ajaskey.market.ta.methods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
public class UtilMethodsTest {

	double[]	dData10	= new double[10];
	float[]		fData10	= new float[10];
	int[]			iData10	= new int[10];
	long[]		lData10	= new long[10];
	double[]	dData50	= new double[50];
	float[]		fData50	= new float[50];
	int[]			iData50	= new int[50];
	long[]		lData50	= new long[50];

	int				sum10		= 0;
	int				sum50		= 0;

	@Before
	public void setup() {
		for (int i = 0; i < 10; i++) {
			this.dData10[i] = i + 1;
			this.fData10[i] = i + 1;
			this.iData10[i] = i + 1;
			this.lData10[i] = i + 1;
			this.sum10 += (i + 1);
		}
		for (int i = 0; i < 50; i++) {
			this.dData50[i] = i + 1;
			this.fData50[i] = i + 1;
			this.iData50[i] = i + 1;
			this.lData50[i] = i + 1;
			this.sum50 += (i + 1);

		}
	}

	@Test
	public void testSmaDouble() {

		double sma = UtilMethods.sma(this.dData10, 10, 0);
		Assert.assertEquals(sma, 5.5, 0.1);

		sma = UtilMethods.sma(this.dData50, 50, 0);
		Assert.assertEquals(sma, 25.5, 0.1);

		sma = UtilMethods.sum(this.dData50, 60);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sum(this.dData50, 30, 75);
		Assert.assertEquals(sma, 0.0, 0.1);

		final double dVal[] = null;
		sma = UtilMethods.sum(dVal, 10, 0);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sma(this.dData10, 10);
		Assert.assertEquals(sma, 5.5, 0.1);

		sma = UtilMethods.sma(this.dData50, 50);
		Assert.assertEquals(sma, 25.5, 0.1);

		sma = UtilMethods.sum(this.dData50, 60);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sma, 0.0, 0.1);
	}

	@Test
	public void testSmaFloat() {

		float sma = UtilMethods.sma(this.fData10, 10, 0);
		Assert.assertEquals(sma, 5.5, 0.1);

		sma = UtilMethods.sma(this.fData50, 50, 0);
		Assert.assertEquals(sma, 25.5, 0.1);

		sma = UtilMethods.sum(this.fData50, 60);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sum(this.fData50, 30, 75);
		Assert.assertEquals(sma, 0.0, 0.1);

		final float dVal[] = null;
		sma = UtilMethods.sum(dVal, 10, 0);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sma(this.fData10, 10);
		Assert.assertEquals(sma, 5.5, 0.1);

		sma = UtilMethods.sma(this.fData50, 50);
		Assert.assertEquals(sma, 25.5, 0.1);

		sma = UtilMethods.sum(this.fData50, 60);
		Assert.assertEquals(sma, 0.0, 0.1);

		sma = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sma, 0.0, 0.1);
	}

	@Test
	public void testSmaInt() {

		int sma = UtilMethods.sma(this.iData10, 10, 0);
		Assert.assertEquals(sma, 5);

		sma = UtilMethods.sma(this.iData50, 50, 0);
		Assert.assertEquals(sma, 25);

		sma = UtilMethods.sum(this.iData50, 60);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sum(this.iData50, 30, 75);
		Assert.assertEquals(sma, 0);

		final int dVal[] = null;
		sma = UtilMethods.sum(dVal, 10, 0);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sma(this.iData10, 10);
		Assert.assertEquals(sma, 5);

		sma = UtilMethods.sma(this.iData50, 50);
		Assert.assertEquals(sma, 25);

		sma = UtilMethods.sum(this.iData50, 60);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sma, 0);
	}

	@Test
	public void testSmaLong() {

		long sma = UtilMethods.sma(this.lData10, 10, 0);
		Assert.assertEquals(sma, 5);

		sma = UtilMethods.sma(this.lData50, 50, 0);
		Assert.assertEquals(sma, 25);

		sma = UtilMethods.sum(this.lData50, 60);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sum(this.lData50, 30, 75);
		Assert.assertEquals(sma, 0);

		final long dVal[] = null;
		sma = UtilMethods.sum(dVal, 10, 0);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sma(this.lData10, 10);
		Assert.assertEquals(sma, 5);

		sma = UtilMethods.sma(this.lData50, 50);
		Assert.assertEquals(sma, 25);

		sma = UtilMethods.sum(this.lData50, 60);
		Assert.assertEquals(sma, 0);

		sma = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sma, 0);
	}

	@Test
	public void testSumDouble() {
		double sum = UtilMethods.sum(this.dData10, 10);
		Assert.assertEquals(sum, this.sum10, 0.1);

		sum = UtilMethods.sum(this.dData10, 3, 3);
		Assert.assertEquals(sum, 15.0, 0.1);

		sum = UtilMethods.sum(this.dData50, 50);
		Assert.assertEquals(sum, this.sum50, 0.1);

		sum = UtilMethods.sum(this.dData50, 25, 15);
		Assert.assertEquals(sum, 700.0, 0.1);

		sum = UtilMethods.sum(this.dData50, 60);
		Assert.assertEquals(sum, 0.0, 0.1);

		sum = UtilMethods.sum(this.dData50, 30, 75);
		Assert.assertEquals(sum, 0.0, 0.1);

		final double dVal[] = null;
		sum = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sum, 0.0, 0.1);

	}

	@Test
	public void testSumFloat() {
		float sum = UtilMethods.sum(this.fData10, 10);
		Assert.assertEquals(sum, 55.0, 0.1);

		sum = UtilMethods.sum(this.fData10, 3, 4);
		Assert.assertEquals(sum, 18.0, 0.1);

		sum = UtilMethods.sum(this.fData50, 50);
		Assert.assertEquals(sum, 1275.0, 0.1);

		sum = UtilMethods.sum(this.fData50, 25, 15);
		Assert.assertEquals(sum, 700.0, 0.1);

		sum = UtilMethods.sum(this.fData50, 60);
		Assert.assertEquals(sum, 0.0, 0.1);

		sum = UtilMethods.sum(this.fData50, 30, 75);
		Assert.assertEquals(sum, 0.0, 0.1);

		final float dVal[] = null;
		sum = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sum, 0.0, 0.1);
	}

	@Test
	public void testSumInt() {
		int sum = UtilMethods.sum(this.iData10, 10);
		Assert.assertEquals(sum, 55);

		sum = UtilMethods.sum(this.iData10, 4, 5);
		Assert.assertEquals(sum, 30);

		sum = UtilMethods.sum(this.iData50, 50);
		Assert.assertEquals(sum, 1275);

		sum = UtilMethods.sum(this.iData50, 25, 15);
		Assert.assertEquals(sum, 700);

		sum = UtilMethods.sum(this.iData50, 60);
		Assert.assertEquals(sum, 0);

		sum = UtilMethods.sum(this.iData50, 30, 75);
		Assert.assertEquals(sum, 0);

		final int dVal[] = null;
		sum = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sum, 0);
	}

	@Test
	public void testSumLong() {
		long sum = UtilMethods.sum(this.lData10, 10);
		Assert.assertEquals(sum, 55);

		sum = UtilMethods.sum(this.lData10, 2, 4);
		Assert.assertEquals(sum, 11);

		sum = UtilMethods.sum(this.lData50, 50);
		Assert.assertEquals(sum, 1275);

		sum = UtilMethods.sum(this.lData50, 25, 15);
		Assert.assertEquals(sum, 700);

		sum = UtilMethods.sum(this.lData50, 60);
		Assert.assertEquals(sum, 0);

		sum = UtilMethods.sum(this.lData50, 30, 75);
		Assert.assertEquals(sum, 0);

		final long dVal[] = null;
		sum = UtilMethods.sum(dVal, 10);
		Assert.assertEquals(sum, 0);
	}

	@Test
	public void testMinMaxDouble() {

		double val = UtilMethods.min(this.dData10, 10);
		Assert.assertEquals(val, 1.0, 0.1);

		val = UtilMethods.max(this.dData10, 10);
		Assert.assertEquals(val, 10.0, 0.1);

		val = UtilMethods.min(this.dData10, 3, 3);
		Assert.assertEquals(val, 4.0, 0.1);

		val = UtilMethods.max(this.dData10, 3, 3);
		Assert.assertEquals(val, 6.0, 0.1);

		val = UtilMethods.min(this.dData50, 60);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(this.dData50, 60);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.min(this.dData50, 30, 75);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(this.dData50, 30, 75);
		Assert.assertEquals(val, 0.0, 0.1);

		final double dVal[] = null;
		val = UtilMethods.min(dVal, 10);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(dVal, 10);
		Assert.assertEquals(val, 0.0, 0.1);
	}

	@Test
	public void testMinMaxFloat() {
		
		float val = UtilMethods.min(this.fData10, 10);
		Assert.assertEquals(val, 1.0, 0.1);

		val = UtilMethods.max(this.fData10, 10);
		Assert.assertEquals(val, 10.0, 0.1);

		val = UtilMethods.min(this.fData10, 3, 3);
		Assert.assertEquals(val, 4.0, 0.1);

		val = UtilMethods.max(this.fData10, 3, 3);
		Assert.assertEquals(val, 6.0, 0.1);

		val = UtilMethods.min(this.fData50, 60);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(this.fData50, 60);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.min(this.fData50, 30, 75);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(this.fData50, 30, 75);
		Assert.assertEquals(val, 0.0, 0.1);

		final float dVal[] = null;
		val = UtilMethods.min(dVal, 10);
		Assert.assertEquals(val, 0.0, 0.1);

		val = UtilMethods.max(dVal, 10);
		Assert.assertEquals(val, 0.0, 0.1);
	}

	@Test
	public void testMinMaxInt() {
		
		int val = UtilMethods.min(this.iData10, 10);
		Assert.assertEquals(val, 1);

		val = UtilMethods.max(this.iData10, 10);
		Assert.assertEquals(val, 10);

		val = UtilMethods.min(this.iData10, 3, 3);
		Assert.assertEquals(val, 4);

		val = UtilMethods.max(this.iData10, 3, 3);
		Assert.assertEquals(val, 6);

		val = UtilMethods.min(this.iData50, 60);
		Assert.assertEquals(val, 0);
		
		val = UtilMethods.max(this.iData50, 60);
		Assert.assertEquals(val, 0);

		val = UtilMethods.min(this.iData50, 30, 75);
		Assert.assertEquals(val, 0);

		val = UtilMethods.max(this.iData50, 30, 75);
		Assert.assertEquals(val, 0);

		final int dVal[] = null;
		val = UtilMethods.min(dVal, 10);
		Assert.assertEquals(val, 0);

		val = UtilMethods.max(dVal, 10);
		Assert.assertEquals(val, 0);
	}

	@Test
	public void testMinMaxLong() {
		
		long val = UtilMethods.min(this.lData10, 10);
		Assert.assertEquals(val, 1);

		val = UtilMethods.max(this.lData10, 10);
		Assert.assertEquals(val, 10);

		val = UtilMethods.min(this.lData10, 3, 3);
		Assert.assertEquals(val, 4);

		val = UtilMethods.max(this.lData10, 3, 3);
		Assert.assertEquals(val, 6);

		val = UtilMethods.min(this.lData50, 60);
		Assert.assertEquals(val, 0);
		
		val = UtilMethods.max(this.lData50, 60);
		Assert.assertEquals(val, 0);

		val = UtilMethods.min(this.lData50, 30, 75);
		Assert.assertEquals(val, 0);

		val = UtilMethods.max(this.lData50, 30, 75);
		Assert.assertEquals(val, 0);

		final long dVal[] = null;
		val = UtilMethods.min(dVal, 10);
		Assert.assertEquals(val, 0);

		val = UtilMethods.max(dVal, 10);
		Assert.assertEquals(val, 0);
	}
}
