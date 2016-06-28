
package net.ajaskey.market.tools.helpers;

import java.util.ArrayList;
import java.util.List;

public class CotsData {

	public static List<LongShort> dataPoint = new ArrayList<>();

	public static void setDataPoint(String l, String s, String d, LongShort.MarketType mt, LongShort.SourceType st) {
		LongShort tmp = new LongShort(l, s, d, mt, st);
		dataPoint.add(tmp);
	}

}
