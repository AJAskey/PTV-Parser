
package net.ajaskey.market.tools.helpers;

import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

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
public class LongShort {

	public enum MarketType {
		DEALER, PM, LEVERED, OTHER, NONRPT, OI, TRADER_DEALER, TRADER_PM, TRADER_LEVERED, TRADER_OTHER, TOTALS
	};

	public enum SourceType {
		ALL, DJIA, DJIA_C, SPX, SPX_C, NDX, NDX_C, RUT, EMINI500, EMINI400, VIX
	}

	public MarketType	type;
	public SourceType	source;
	public long				longPos;
	public long				shortPos;
	public long				spreadPos;
	public double			pc;
	public long				delta;
	public Calendar		date	= null;
	public boolean		valid;

	public LongShort(long longs, long shorts, long spreads, Calendar d, MarketType mt, SourceType st) {

		this.date = Utils.makeCopy(d);
		// Utils.printCalendar(date);
		this.type = mt;
		this.source = st;

		longPos = longs;
		shortPos = shorts;
		spreadPos = spreads;
		update();
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param d
	 *
	 */
	public LongShort(String l, String s, String sp, Calendar d, MarketType mt, SourceType st) {

		try {

			this.date = Utils.makeCopy(d);
			// Utils.printCalendar(date);
			this.type = mt;
			this.source = st;

			if (l.trim().length() > 0) {
				this.longPos = Long.parseLong(l.trim());
			} else {
				this.longPos = 0;
			}
			if (s.trim().length() > 0) {
				this.shortPos = Long.parseLong(s.trim());
			} else {
				this.shortPos = 0;
			}
			if (sp.trim().length() > 0) {
				this.spreadPos = Long.parseLong(sp.trim());
			} else {
				this.spreadPos = 0;
			}
			update();
			this.valid = true;
		} catch (final Exception e) {
			this.longPos = 0;
			this.shortPos = 0;
			this.spreadPos = 0;
			this.pc = 0.0;
			this.valid = false;
			e.printStackTrace();
		}
	}

	public void update() {
		if (this.longPos > 0) {
			this.pc = (double) this.shortPos / (double) this.longPos;
		} else {
			this.pc = 0.0;
		}
		delta = longPos - shortPos;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public LongShort() {
		this.longPos = 0;
		this.shortPos = 0;
		this.spreadPos = 0;
		this.pc = 0.0;
		this.valid = false;
	}

	@Override
	public String toString() {
		long tot = 0;
		if (this.type == MarketType.OI) {
			tot = this.longPos;
		} else {
			tot = this.longPos + this.shortPos + this.spreadPos;
		}
		final String ret = String.format("%10s    %-9s : %15s %12s %12s %12s %12s %10.2f %9d", Utils.getString(this.date),
		    this.source, this.type, Utils.formatInt(this.longPos), Utils.formatInt(this.shortPos),
		    Utils.formatInt(this.spreadPos), Utils.formatInt(tot), this.pc, this.delta);
		return ret;
	}

}
