
package net.ajaskey.market.tools.optuma;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.input.YahooData;
import net.ajaskey.market.tools.ConvertOHLCV;
import net.ajaskey.market.tools.helpers.OhlcvData;

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
public class ConvertOptuma {

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("dd-MMM-yyyy");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * net.ajaskey.market.tools.optuma.BoundGaapToSpx
	 *
	 * @param epsList
	 * @throws ParseException
	 *
	 */
	@SuppressWarnings("unused")
	private static List<OhlcvData> BoundGaapToSpx(List<OhlcvData> epsList) throws ParseException {

		final List<String> data = YahooData.getHistoric("^GSPC");
		final List<OhlcvData> spx = new ArrayList<>();
		for (final String s : data) {
			//System.out.println(s);
			final String fld[] = s.split(",");
			try {
				final Date date = sdfOptuma.parse(fld[0]);
				final Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				final double c = Double.parseDouble(fld[4]);
				final OhlcvData d = new OhlcvData(cal, c, c, c, c, 0);
				d.open = 0.0;
				spx.add(d);
				//System.out.println("gaap  "+d.toShortString());
			} catch (final Exception e) {
			}
		}

		for (final OhlcvData price : spx) {
			for (final OhlcvData eps : epsList) {
				if (Utils.sameDate(price.date, eps.date)) {
					price.open = eps.close;
					break;
				} else if (eps.date.before(price.date)) {
					price.open = eps.close;
					break;
				}
			}
		}

		return spx;

	}

	private static List<OhlcvData> getGaapEps() {

		final List<OhlcvData> data = new ArrayList<>();
		try {
			final String gaapEps = ConvertOHLCV
			    .parseHtmlFile(new File("C:/Users/ajask_000/Downloads/gaap_spx.html").toPath());
			try (Scanner scanner = new Scanner(gaapEps)) {
				while (scanner.hasNextLine()) {
					final String line = scanner.nextLine();
					//System.out.println(line);
					final String fld[] = line.split("\\s+");
					final Date date = sdf.parse(fld[0]);
					final Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					final double c = Double.parseDouble(fld[1]);
					final OhlcvData d = new OhlcvData(cal, c, c, c, c, 0);
					data.add(d);
				}
			} catch (final Exception e1) {
			}
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		//		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc.html").toPath());
		//		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpci.html").toPath());
		//		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpce.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-call-v.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-put-v.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-call-v.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-put-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rybull.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rybear.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rymm.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/mfcash.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/mfpcash.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/crb.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxupvol.html").toPath());
		//ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxdownvol.html").toPath());

		//final List<OhlcvData> eps = ConvertOptuma.getGaapEps();

		//final List<OhlcvData> spx = ConvertOptuma.BoundGaapToSpx(eps);

		//		final double MAX_PE = 37.0;
		//		Collections.reverse(spx);
		//		try (PrintWriter pw = new PrintWriter(ConvertOHLCV.shortPath + "\\gaap_spx_bound.csv")) {
		//			for (final OhlcvData price : spx) {
		//				if (price.open > 0.0) {
		//					double pe = price.close / price.open;
		//					if (pe > MAX_PE) {
		//						pe = MAX_PE;
		//					}
		//					pw.printf("%s,%.2f%n", sdfOptuma.format(price.date.getTime()), pe);
		//				}
		//			}
		//		}

		System.out.println("Done.");
	}
}
