
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
public class EmaContinuousSeries {

	private int						knt;
	private double				sma;
	private double				ema;
	private double				smaTot;
	private final int			emaWindow;
	private final double	emaMultipler;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public EmaContinuousSeries(int emaWin) {
		this.knt = 0;
		this.sma = 0;
		this.ema = 0;
		this.smaTot = 0;
		this.emaWindow = emaWin;
		this.emaMultipler = 2.0 / (1.0 + this.emaWindow);
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

		if (this.knt <= this.emaWindow) {
			this.smaTot += val;
			this.sma = this.smaTot / this.knt;
			this.ema = this.sma;
		} else {
			final double pEma = this.ema;
			this.ema = ((val - pEma) * this.emaMultipler) + pEma;
		}

		return this.ema;
	}

	/**
	 * @return the ema
	 */
	public double getEma() {

		return this.ema;
	}

	/**
	 * @return the emaWindow
	 */
	public int getEmaWindow() {

		return this.emaWindow;
	}

	/**
	 * @return the knt
	 */
	public int getKnt() {

		return this.knt;
	}

}
