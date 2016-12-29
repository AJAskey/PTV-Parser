
package net.ajaskey.market.tools.fred;

import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.fred.DataSeries.AggregationMethodType;
import net.ajaskey.market.tools.fred.DataSeries.ResponseType;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class FredDataDownloader {

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final List<String> seriesNames = new ArrayList<>();

		/*
		seriesNames.add("PCEC96 0.1 false");
		seriesNames.add("DSPIC96 0.1 false");
		seriesNames.add("A576RC1 0.1 false");
		seriesNames.add("PSAVERT 0.1 false");
		seriesNames.add("TTLCON 0.1 false");
		seriesNames.add("USSLIND 0.1 false");
		seriesNames.add("USPHCI 0.1 false");
		
		seriesNames.add("TOTBUSSMNSA 0.1 false");
		seriesNames.add("GFDEBTN 0.1 false");
		seriesNames.add("TREAST 0.1 false");
		
		seriesNames.add("RMFNS -0.1 false");
		seriesNames.add("WHLSLRSMNSA 0.1 false");
		seriesNames.add("BOGMBASE 0.1 false");
		seriesNames.add("RSXFSN 0.1 false");
		
		
		seriesNames.add("UMTUNO 0.0 false");
		seriesNames.add("UMTUVS 0.0 false");
		seriesNames.add("UMTUTI 0.0 false");
		seriesNames.add("UMTMUO 0.1 false");
		
		//		seriesNames.add(" 0.1 false");
		
		seriesNames.add("SP500 0.0 true");
		seriesNames.add("WILL5000IND 0.0 true");
		
		seriesNames.add("GDPC1 0.4 false");
		seriesNames.add("CP -0.25 false");
		seriesNames.add("CNP16OV 0.1 false");
		
		
		seriesNames.add("AMTUNO 0.1 false");
		seriesNames.add("AMTUVS 0.1 false");
		seriesNames.add("AMTUTI 0.1 false");
		seriesNames.add("AMTMUO 0.1 false");
		
		seriesNames.add("DGS10 0.0 true");
		seriesNames.add("DGS2 0.0 true");
		seriesNames.add("DGS1MO 0.0 true");
		seriesNames.add("DGS3MO 0.0 true");
		
		
		seriesNames.add("ATCGUO 0.0 true");
		seriesNames.add("A34XUO 0.0 true");
		seriesNames.add("ACRPUO 0.0 true");
		seriesNames.add("ACMSUO 0.0 true");
		seriesNames.add("ACOGUO 0.0 true");
		seriesNames.add("AMDMUO 0.0 true");
		seriesNames.add("AITIUO 0.0 true");
		seriesNames.add("AMVPUO 0.0 true");
		
		seriesNames.add("ATCGVS 0.0 true");
		seriesNames.add("A34XVS 0.0 true");
		seriesNames.add("ACRPVS 0.0 true");
		seriesNames.add("ACMSVS 0.0 true");
		seriesNames.add("ACOGVS 0.0 true");
		seriesNames.add("AMDMVS 0.0 true");
		seriesNames.add("AITIVS 0.0 true");
		seriesNames.add("AMVPVS 0.0 true");
		seriesNames.add("AMNMVS 0.0 true");
		*/

		seriesNames.add("JTU2300HIL 0.0 true");
		seriesNames.add("JTU3000HIL 0.0 true");
		seriesNames.add("JTU3200HIL 0.0 true");
		seriesNames.add("JTU3400HIL 0.0 true");
		seriesNames.add("JTU4000HIL 0.0 true");
		seriesNames.add("JTU4200HIL 0.0 true");
		seriesNames.add("JTU4400HIL 0.0 true");
		seriesNames.add("JTU480099HIL 0.0 true");
		seriesNames.add("JTU510099HIL 0.0 true");
		seriesNames.add("JTU5100HIL 0.0 true");
		seriesNames.add("JTU5200HIL 0.0 true");
		seriesNames.add("JTU5300HIL 0.0 true");
		seriesNames.add("JTU540099HIL 0.0 true");
		seriesNames.add("JTU6000HIL 0.0 true");
		seriesNames.add("JTU6100HIL 0.0 true");
		seriesNames.add("JTU6200HIL 0.0 true");
		seriesNames.add("JTU7000HIL 0.0 true");
		seriesNames.add("JTU7100HIL 0.0 true");
		seriesNames.add("JTU7200HIL 0.0 true");
		seriesNames.add("JTU8100HIL 0.0 true");
		seriesNames.add("JTU9000HIL 0.0 true");
		seriesNames.add("JTU9100HIL 0.0 true");
		seriesNames.add("JTU9200HIL 0.0 true");
		seriesNames.add("JTUHIL 0.0 true");
		seriesNames.add("JTU1000QUL 0.0 true");
		seriesNames.add("JTU110099QUL 0.0 true");
		seriesNames.add("JTU2300QUL 0.0 true");
		seriesNames.add("JTU3000QUL 0.0 true");
		seriesNames.add("JTU3200QUL 0.0 true");
		seriesNames.add("JTU3400QUL 0.0 true");
		seriesNames.add("JTU4000QUL 0.0 true");
		seriesNames.add("JTU4200QUL 0.0 true");
		seriesNames.add("JTU4400QUL 0.0 true");
		seriesNames.add("JTU480099QUL 0.0 true");
		seriesNames.add("JTU510099QUL 0.0 true");
		seriesNames.add("JTU5100QUL 0.0 true");
		seriesNames.add("JTU5200QUL 0.0 true");
		seriesNames.add("JTU5300QUL 0.0 true");
		seriesNames.add("JTU6000QUL 0.0 true");
		seriesNames.add("JTU6100QUL 0.0 true");
		seriesNames.add("JTU6200QUL 0.0 true");
		seriesNames.add("JTU7000QUL 0.0 true");
		seriesNames.add("JTU7100QUL 0.0 true");
		seriesNames.add("JTU7200QUL 0.0 true");
		seriesNames.add("JTU8100QUL 0.0 true");
		seriesNames.add("JTU9000QUL 0.0 true");
		seriesNames.add("JTU9100QUL 0.0 true");
		seriesNames.add("JTU9200QUL 0.0 true");
		seriesNames.add("JTUQUL 0.0 true");

		//
		for (final String s : seriesNames) {
			final String fld[] = s.split(" ");
			double chg = 0;
			boolean noZeros = false;
			if (fld.length == 1) {
				chg = 0.0;
				noZeros = false;
			} else if (fld.length == 2) {
				chg = Double.parseDouble(fld[1].trim());
				noZeros = false;
			} else if (fld.length >= 3) {
				chg = Double.parseDouble(fld[1].trim());
				noZeros = Boolean.parseBoolean(fld[2].trim());
			}
			FredDataDownloader.process(fld[0].trim(), chg, noZeros);
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param series
	 * @param futureChg
	 * @param noZeroValues
	 */
	private static void process(String series, double futureChg, boolean noZeroValues) {

		final DataSeries ds = new DataSeries(series);

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			ds.setRespType(ResponseType.LIN);

			final List<DataValues> dvList = ds.getValues(futureChg, noZeroValues);

			FredCommon.writeToOptuma(dvList, ds.getName());
			System.out.println(ds);
			System.out.println(futureChg);
		}
	}

}
