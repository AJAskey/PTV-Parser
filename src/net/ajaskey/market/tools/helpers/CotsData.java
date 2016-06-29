
package net.ajaskey.market.tools.helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CotsData {

	public static List<LongShort> dataPoint = new ArrayList<>();

	public static void setDataPoint(String l, String s, String sp, Calendar d, LongShort.MarketType mt,
	    LongShort.SourceType st) {
		final LongShort tmp = new LongShort(l, s, sp, d, mt, st);
		dataPoint.add(tmp);
	}

}
