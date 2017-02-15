
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

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxearnyield.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxyield.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spx-mcclellan-sum.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spx-mcclellan-osc.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpci.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpce.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-call-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/cpc-put-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-call-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/oex-put-v.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rybull.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rybear.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/rymm.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/mfcash.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/mfpcash.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/crb.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxupvol.html").toPath());
		ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/spxdownvol.html").toPath());
		
		List<OhlcvData> eps = getGaapEps();
		for(OhlcvData e : eps) {
			System.out.println(e.toShortString());
		}
		BoundGaapToSpx();
	}
	
	public final static SimpleDateFormat	sdf		= new SimpleDateFormat("dd-MMM-yyyy");

	private static List<OhlcvData> getGaapEps() {
		List<OhlcvData> data = new ArrayList<>(); 
		try {
			String gaapEps = ConvertOHLCV.parseHtmlFile(new File("C:/Users/ajask_000/Downloads/gaap_spx.html").toPath());
			try (Scanner scanner = new Scanner(gaapEps)) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					System.out.println(line);
					String fld[] = line.split("\\s+");
					Date date = sdf.parse(fld[0]);
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					double c = Double.parseDouble(fld[1]);
					OhlcvData d = new OhlcvData(cal, c, c, c, c, 0);
					data.add(d);
				}
			} catch (Exception e1) {
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/** 
	 * net.ajaskey.market.tools.optuma.BoundGaapToSpx
	 *
	 */
	private static void BoundGaapToSpx() {

		List<String> data = YahooData.getHistoric("^GSPC");
		
	}
}
