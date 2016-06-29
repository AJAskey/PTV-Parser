
package net.ajaskey.market.ta.apps.helpers;

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
public class InterdaySumData {

	public int		totUp;
	public int		totDown;
	public double	totForceUp;
	public double	totForceDown;
	public double	priceInRng;
	public int		upperRange;
	public int		lowerRange;
	public int		upOnVolume;
	public int		downOnVolume;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public InterdaySumData() {
		this.totUp = 0;
		this.totDown = 0;
		this.totForceUp = 0;
		this.totForceDown = 0;
		this.priceInRng = 0.0;
		this.upperRange = 0;
		this.lowerRange = 0;
		this.upOnVolume = 0;
		this.downOnVolume = 0;
	}

}
