
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
public class BreadthData {

	final private String	TAB	= "\t";
	final private String	NL	= System.getProperty("line.separator");

	private double				dma23;
	private double				dma65;
	private double				dma130;
	private double				dma260;
	//private long					upDays;
	//private long					downDays;
	//private long					upVol;
	//private long					downVol;
	private double				price;
	//private long					totVol;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public BreadthData() {
		this.setPrice(0.0);
		this.dma23 = 0;
		this.dma65 = 0;
		this.dma260 = 0;
		//this.upDays = 0;
		//this.downDays = 0;
		//this.upVol = 0;
		//this.downVol = 0;
		//this.totVol = 0;
	}

	/**
	 * @param downDays
	 *          the downDays to set
	 */
	/**
	public void addDownDay() {
		this.downDays++;
	}
	*/

	/**
	 * @param downVol
	 *          the downVol to set
	 */
	/**
	public void addDownVol(long downVol) {
		this.downVol += downVol;
	}
	*/

	/**
	 *
	 * net.ajaskey.market.ta.apps.helpers.addUpDays
	 *
	 */
	/**
	public void addUpDay() {
		this.upDays++;
	}
	*/

	/**
	 * @param upVol
	 *          the upVol to set
	 */
	/**
	public void addUpVol(long upVol) {
		this.upVol += upVol;
	}
	*/

	/**
	 * net.ajaskey.market.ta.apps.helpers.addVol
	 *
	 * @param volToday
	 */
	/**
	public void addVol(long volToday) {
		this.totVol += volToday;
	}
	*/

	/**
	 * @return the ema130
	 */
	public double getDma130() {
		return this.dma130;
	}

	/**
	 * @return the dma200
	 */
	public double getDma260() {
		return this.dma260;
	}

	/**
	 * @return the downDays
	 */
	/**
	public long getDownDays() {
		return this.downDays;
	}
	*/

	/**
	 * @return the downVol
	 */
	/**
	public long getDownVol() {
		return this.downVol;
	}
	*/

	/**
	 * @return the ema23
	 */
	public double getDma23() {
		return this.dma23;
	}

	/**
	 * @return the ema65
	 */
	public double getDma65() {
		return this.dma65;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return the totVol
	 */
	/**
	public long getTotVol() {
		return this.totVol;
	}
	*/

	/**
	 * @return the upDays
	 */
	/**
	public long getUpDays() {
		return this.upDays;
	}
	*/

	/**
	 * @return the upVol
	 */
	/**
	public long getUpVol() {
		return this.upVol;
	}
	*/

	/**
	 * @param ema130
	 *          the ema130 to set
	 */
	public void setDma130(double dma130) {
		this.dma130 = dma130;
	}

	/**
	 * @param dma200
	 *          the dma200 to set
	 */
	public void setDma260(double dma260) {
		this.dma260 = dma260;
	}

	/**
	 * @param ema23
	 *          the ema23 to set
	 */
	public void setDma23(double dma23) {
		this.dma23 = dma23;
	}

	/**
	 * @param ema65
	 *          the ema65 to set
	 */
	public void setDma65(double dma65) {
		this.dma65 = dma65;
	}

	/**
	 * @param price
	 *          the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		final String str = this.price + this.TAB + this.dma23 + this.TAB + this.dma65 + this.TAB + this.dma260;
		//+ this.TAB + this.upDays + this.TAB + this.downDays;
		return str;

	}

}
