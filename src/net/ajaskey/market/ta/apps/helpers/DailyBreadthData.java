
package net.ajaskey.market.ta.apps.helpers;

import net.ajaskey.market.ta.TickerData;

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
public class DailyBreadthData {

	private static int		newLowsTotal	= 0;
	private static int		newHighsTotal	= 0;
	private final int			adv;

	private final int			dec;
	private final int			adDiff10dma;
	private final long		advVol;
	private final long		decVol;
	private final long		adVolDiff10dma;

	private final long		totVol;
	private final double	percentVolume;

	private final double	percentAdvancing;
	private final double	percentAdvancingVol;

	private int						newLows;
	private int						newHighs;

	final private String	TAB						= "\t";

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param lowa
	 * @param higa
	 *
	 */
	public DailyBreadthData(TickerData advancing, TickerData declining, TickerData advancingVol, TickerData decliningVol,
	    TickerData highs, TickerData lows) {

		advancing.generateDerived();
		declining.generateDerived();
		advancingVol.generateDerived();
		decliningVol.generateDerived();
		if (highs != null) {
			highs.generateDerived();
			this.newHighs = (int) highs.getClose(0);
		} else {
			this.newHighs = 0;
		}
		if (lows != null) {
			lows.generateDerived();
			this.newLows = (int) lows.getClose(0);
		} else {
			this.newLows = 0;
		}
		newHighsTotal += this.newHighs;
		newLowsTotal += this.newLows;

		this.adv = (int) advancing.getClose(0);
		this.dec = (int) declining.getClose(0);
		this.advVol = (long) advancingVol.getClose(0);
		this.decVol = (long) decliningVol.getClose(0);
		this.totVol = this.advVol + this.decVol;

		this.percentAdvancing = ((double) this.adv / (double) (this.adv + this.dec)) * 100.0;
		this.percentAdvancingVol = ((double) this.advVol / (double) this.totVol) * 100.0;

		int sum = 0;
		long sumVol = 0;
		for (int i = 0; i < 10; i++) {
			sum += (advancing.getClose(i) - declining.getClose(i));
			sumVol += (advancingVol.getClose(i) - decliningVol.getClose(i));
		}
		this.adDiff10dma = sum / 10;
		this.adVolDiff10dma = sumVol / 10;

		double sumVolume = 0;
		for (int i = 0; i < 35; i++) {
			sumVolume += (advancingVol.getClose(i) + decliningVol.getClose(i));
		}
		final double avgVol = sumVolume / 35.0;
		this.percentVolume = (this.totVol / avgVol) * 100.0;

	}

	/**
	 * @return the newHighsTotal
	 */
	public static int getNewHighsTotal() {
		return newHighsTotal;
	}

	/**
	 * @return the newLowsTotal
	 */
	public static int getNewLowsTotal() {
		return newLowsTotal;
	}

	/**
	 * @return the adDiff10dma
	 */
	public int getAdDiff10dma() {
		return this.adDiff10dma;
	}

	/**
	 * @return the adv
	 */
	public int getAdv() {
		return this.adv;
	}

	/**
	 * @return the adv
	 */
	public long getAdvancing() {
		return this.adv;
	}

	/**
	 * @return the adVolDiff10dma
	 */
	public long getAdVolDiff10dma() {
		return this.adVolDiff10dma;
	}

	/**
	 * @return the advVol
	 */
	public long getAdvVol() {
		return this.advVol;
	}

	/**
	 * @return the dec
	 */
	public int getDec() {
		return this.dec;
	}

	/**
	 * @return the dec
	 */
	public long getDeclining() {
		return this.dec;
	}

	/**
	 * @return the decVol
	 */
	public long getDecVol() {
		return this.decVol;
	}

	/**
	 * @return the newHigh52
	 */
	public int getNewHighs() {
		return this.newHighs;
	}

	/**
	 * @return the newLow52
	 */
	public int getNewLows() {
		return this.newLows;
	}

	/**
	 * @return the percentAD
	 */
	public double getPercentAD() {
		return this.percentAdvancing;
	}

	/**
	 * @return the percentADV
	 */
	public double getPercentADV() {
		return this.percentAdvancingVol;
	}

	/**
	 * @return the percentAdvancing
	 */
	public double getPercentAdvancing() {
		return this.percentAdvancing;
	}

	/**
	 * @return the percentAdvancingVol
	 */
	public double getPercentAdvancingVol() {
		return this.percentAdvancingVol;
	}

	/**
	 * @return the percentVolume
	 */
	public double getPercentVolume() {
		return this.percentVolume;
	}

	/**
	 * @return the tAB
	 */
	public String getTAB() {
		return this.TAB;
	}

	/**
	 * @return the totVol
	 */
	public long getTotVol() {
		return this.totVol;
	}

	/**
	 * @param newHighs
	 *          the newHighs to set
	 */
	public void setNewHighs() {
		this.newHighs = newHighsTotal;
	}

	/**
	 * @param newLows
	 *          the newLows to set
	 */
	public void setNewLows() {
		this.newLows = newLowsTotal;
	}

	@Override
	public String toString() {
		final String str = this.adv + this.TAB + this.dec + this.TAB + (int) this.percentAdvancing + this.TAB
		    + this.adDiff10dma + this.TAB + this.advVol + this.TAB + this.decVol + this.TAB + (int) this.percentAdvancingVol
		    + this.TAB + this.adVolDiff10dma + this.TAB + (int) this.percentVolume + this.TAB + this.newHighs + this.TAB
		    + this.newLows;
		return str;
	}

}
