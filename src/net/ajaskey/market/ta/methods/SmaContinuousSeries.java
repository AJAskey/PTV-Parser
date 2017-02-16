
package net.ajaskey.market.ta.methods;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
 *         reserved. </p> <p> Permission is hereby granted, free of charge, to
 *         any person obtaining a copy of this software and associated
 *         documentation files (the "Software"), to deal in the Software without
 *         restriction, including without limitation the rights to use, copy,
 *         modify, merge, publish, distribute, sublicense, and/or sell copies of
 *         the Software, and to permit persons to whom the Software is furnished
 *         to do so, subject to the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software. </p>
 *
 *         <p> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE. </p>
 *
 */
public class SmaContinuousSeries {

	private int knt;

	private int				ptr;
	private double		sma;
	private double		smaTot;
	private final int	smaWindow;
	private double[]	values	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SmaContinuousSeries(int smaWin) {
		this.knt = 0;
		this.ptr = -1;
		this.sma = 0;
		this.smaTot = 0;
		this.smaWindow = smaWin;
		this.values = new double[smaWin];
		for (int i = 0; i < smaWin; i++) {
			this.values[i] = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final SmaContinuousSeries sma = new SmaContinuousSeries(9);
		for (int i = 1; i < 31; i++) {
			System.out.println(i + "\t" + sma.addValue(i));
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.addValue
	 *
	 * @param val
	 * @return
	 */
	public double addValue(double val) {

		this.knt++;
		this.incPtr();

		if (this.knt < this.smaWindow) {
			this.smaTot += val;
			this.sma = this.smaTot / this.knt;
		} else {
			this.smaTot -= this.values[this.ptr];
			this.smaTot += val;
			this.sma = this.smaTot / this.smaWindow;
		}
		this.values[this.ptr] = val;

		return this.sma;
	}

	/**
	 * @return the knt
	 */
	public int getKnt() {

		return this.knt;
	}

	/**
	 * @return the sma
	 */
	public double getSma() {

		return this.sma;
	}

	/**
	 * @return the smaWindow
	 */
	public int getSmaWindow() {

		return this.smaWindow;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.incPtr
	 *
	 */
	private void incPtr() {

		this.ptr++;
		if (this.ptr >= this.smaWindow) {
			this.ptr = 0;
		}
	}

}
