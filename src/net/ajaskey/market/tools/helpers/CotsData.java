
package net.ajaskey.market.tools.helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CotsData {

	public static List<LongShort> dataPoints = new ArrayList<>();

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
	public static void setDataPoint(String l, String s, String sp, Calendar d, LongShort.MarketType mt,
	    LongShort.SourceType st) {

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

}
