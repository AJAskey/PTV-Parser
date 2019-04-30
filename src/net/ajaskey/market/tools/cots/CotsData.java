
package net.ajaskey.market.tools.cots;

import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.misc.DateTime;

public class CotsData {

	public static List<LongShort>	dataPoints	= new ArrayList<>();
	public static List<CotsData>	cotsList		= new ArrayList<>();

	private static final String	TAB	= "\t";
	private static final String	NL	= System.getProperty("line.separator");

	/**
	 * net.ajaskey.market.tools.helpers.clear
	 *
	 */
	public static void clear() {

		dataPoints.clear();
		cotsList.clear();
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findDate
	 *
	 * @param date
	 * @return
	 */
	public static CotsData findDate(final DateTime date) {

		for (final CotsData cd : CotsData.cotsList) {
			if (cd.date.isEqual(date)) {
				return cd;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setDataPoint
	 *
	 * @param l
	 * @param s
	 * @param sp
	 * @param d
	 * @param mt
	 * @param st
	 */
	public static void setDataPoint(final long l, final long s, final long sp, final DateTime d, final LongShort.MarketType mt,
	    final LongShort.SourceType st) {

		if (d == null) {
			return;
		}
		if (mt == null) {
			return;
		}
		if (st == null) {
			return;
		}

		final LongShort tmp = new LongShort(l, s, sp, d, mt, st);
		if (tmp.valid) {
			dataPoints.add(tmp);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setDataPoint
	 *
	 * @param l
	 * @param s
	 * @param sp
	 * @param d
	 * @param mt
	 * @param st
	 */
	public static void setDataPoint(String l, String s, String sp, final DateTime d, final LongShort.MarketType mt,
	    final LongShort.SourceType st) {

		if (d == null) {
			return;
		}
		if (mt == null) {
			return;
		}
		if (st == null) {
			return;
		}

		if (l.trim().length() == 0) {
			l = "0";
		}
		if (s.trim().length() == 0) {
			s = "0";
		}
		if (sp.trim().length() == 0) {
			sp = "0";
		}

		final LongShort tmp = new LongShort(l, s, sp, d, mt, st);
		if (tmp.valid) {
			dataPoints.add(tmp);
		}
	}

	public DateTime date = null;

	public long	oi					= 0;
	public long	totalLong		= 0;
	public long	totalShort	= 0;

	public long				totalSpread	= 0;
	public LongShort	dealer			= null;

	public LongShort pm = null;

	public LongShort levered = null;

	public LongShort other = null;

	public LongShort nonrpt = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public CotsData(final LongShort ls) {

		this.setData(ls);
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setData
	 *
	 * @param ls
	 */
	public void setData(final LongShort ls) {

		if (ls == null) {
			return;
		}
		if (this.date == null) {
			this.date = new DateTime(ls.date.getCal());
		}
		if (ls.type == LongShort.MarketType.DEALER) {
			if (this.dealer != null) {
				this.dealer.longPos += ls.longPos;
				this.dealer.shortPos += ls.shortPos;
				this.dealer.spreadPos += ls.spreadPos;
				this.dealer.source = LongShort.SourceType.ALL;
			}
			else {
				this.dealer = ls;
			}
		}
		else if (ls.type == LongShort.MarketType.PM) {
			if (this.pm != null) {
				this.pm.longPos += ls.longPos;
				this.pm.shortPos += ls.shortPos;
				this.pm.spreadPos += ls.spreadPos;
				this.pm.source = LongShort.SourceType.ALL;
			}
			else {
				this.pm = ls;
			}
		}
		else if (ls.type == LongShort.MarketType.LEVERED) {
			if (this.levered != null) {
				this.levered.longPos += ls.longPos;
				this.levered.shortPos += ls.shortPos;
				this.levered.spreadPos += ls.spreadPos;
				this.levered.source = LongShort.SourceType.ALL;
			}
			else {
				this.levered = ls;
			}
		}
		else if (ls.type == LongShort.MarketType.OTHER) {
			if (this.other != null) {
				this.other.longPos += ls.longPos;
				this.other.shortPos += ls.shortPos;
				this.other.spreadPos += ls.spreadPos;
				this.other.source = LongShort.SourceType.ALL;
			}
			else {
				this.other = ls;
			}
		}
		else if (ls.type == LongShort.MarketType.NONRPT) {
			if (this.nonrpt != null) {
				this.nonrpt.longPos += ls.longPos;
				this.nonrpt.shortPos += ls.shortPos;
				this.nonrpt.spreadPos += ls.spreadPos;
				this.nonrpt.source = LongShort.SourceType.ALL;
			}
			else {
				this.nonrpt = ls;
			}
		}
		else if (ls.type == LongShort.MarketType.OI) {
			this.oi = ls.longPos;
		}
	}

	@Override
	public String toString() {

		String ret = this.date + TAB + this.oi + NL;
		ret += TAB + this.dealer + NL;
		ret += TAB + this.pm + NL;
		ret += TAB + this.levered + NL;
		ret += TAB + this.other + NL;
		ret += TAB + this.nonrpt;

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.update
	 *
	 */
	public void update() {

		if (this.dealer != null) {
			this.dealer.update();
		}
		if (this.pm != null) {
			this.pm.update();
			this.totalLong += this.pm.longPos;
			this.totalShort += this.pm.shortPos;
			this.totalSpread += this.pm.spreadPos;
		}
		if (this.levered != null) {
			this.levered.update();
			this.totalLong += this.levered.longPos;
			this.totalShort += this.levered.shortPos;
			this.totalSpread += this.levered.spreadPos;
		}
		if (this.other != null) {
			this.other.update();
			this.totalLong += this.other.longPos;
			this.totalShort += this.other.shortPos;
			this.totalSpread += this.other.spreadPos;
		}
		if (this.nonrpt != null) {
			this.totalLong += this.nonrpt.longPos;
			this.totalShort += this.nonrpt.shortPos;
			this.totalSpread += this.nonrpt.spreadPos;
			this.nonrpt.update();
		}
	}
}
