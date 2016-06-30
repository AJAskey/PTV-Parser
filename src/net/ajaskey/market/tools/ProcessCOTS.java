
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.helpers.CotsData;
import net.ajaskey.market.tools.helpers.CotsReports;
import net.ajaskey.market.tools.helpers.CotsSorter;
import net.ajaskey.market.tools.helpers.LongShort;

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
public class ProcessCOTS {

	final static private String						folderPath	= "f:/temp/cots";
	final static private Charset					charset			= Charset.forName("UTF-8");
	public final static SimpleDateFormat	sdf					= new SimpleDateFormat("yyMMdd");
	private static final String						TAB					= "\t";
	private static final String						COMMA				= ",";

	private static List<String>						validNames	= new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		validNames.add("NASDAQ-100 Consolidated");
		validNames.add("S&P 500 Consolidated");
		//validNames.add("RUSSELL 2000 MINI");
		//validNames.add("VIX FUTURES");

		final Calendar cal = Calendar.getInstance();
		cal.set(2016, Calendar.JUNE, 14);
		
		ProcessCOTS.readAndProcess(null);

		CotsReports.writeSummary(CotsData.dataPoints, LongShort.SourceType.SPX, cal);

		System.out.println("\n");

		CotsReports.dumpRaw(CotsData.dataPoints);

		try {
			CotsReports.writeSpreadsheets(CotsData.dataPoints, LongShort.SourceType.NDX);
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.readAndProcess
	 *
	 * 0:Market_and_Exchange_Names 1:As_of_Date_In_Form_YYMMDD
	 * 2:Report_Date_as_MM_DD_YYYY 3:CFTC_Contract_Market_Code 4:CFTC_Market_Code
	 * 5:CFTC_Region_Code 6:CFTC_Commodity_Code 7:Open_Interest_All
	 * 8:Dealer_Positions_Long_All 9:Dealer_Positions_Short_All
	 * 10:Dealer_Positions_Spread_All 11:Asset_Mgr_Positions_Long_All
	 * 12:Asset_Mgr_Positions_Short_All 13:Asset_Mgr_Positions_Spread_All
	 * 14:Lev_Money_Positions_Long_All 15:Lev_Money_Positions_Short_All
	 * 16:Lev_Money_Positions_Spread_All 17:Other_Rept_Positions_Long_All
	 * 18:Other_Rept_Positions_Short_All 19:Other_Rept_Positions_Spread_All
	 * 20:Tot_Rept_Positions_Long_All 21:Tot_Rept_Positions_Short_All
	 * 22:NonRept_Positions_Long_All 23:NonRept_Positions_Short_All
	 * 24:Change_in_Open_Interest_All 25:Change_in_Dealer_Long_All
	 * 26:Change_in_Dealer_Short_All 27:Change_in_Dealer_Spread_All
	 * 28:Change_in_Asset_Mgr_Long_All 29:Change_in_Asset_Mgr_Short_All
	 * 30:Change_in_Asset_Mgr_Spread_All 31:Change_in_Lev_Money_Long_All
	 * 32:Change_in_Lev_Money_Short_All 33:Change_in_Lev_Money_Spread_All
	 * 34:Change_in_Other_Rept_Long_All 35:Change_in_Other_Rept_Short_All
	 * 36:Change_in_Other_Rept_Spread_All 37:Change_in_Tot_Rept_Long_All
	 * 38:Change_in_Tot_Rept_Short_All 39:Change_in_NonRept_Long_All
	 * 40:Change_in_NonRept_Short_All 41:Pct_of_Open_Interest_All
	 * 42:Pct_of_OI_Dealer_Long_All 43:Pct_of_OI_Dealer_Short_All
	 * 44:Pct_of_OI_Dealer_Spread_All 45:Pct_of_OI_Asset_Mgr_Long_All
	 * 46:Pct_of_OI_Asset_Mgr_Short_All 47:Pct_of_OI_Asset_Mgr_Spread_All
	 * 48:Pct_of_OI_Lev_Money_Long_All 49:Pct_of_OI_Lev_Money_Short_All
	 * 50:Pct_of_OI_Lev_Money_Spread_All 51:Pct_of_OI_Other_Rept_Long_All
	 * 52:Pct_of_OI_Other_Rept_Short_All 53:Pct_of_OI_Other_Rept_Spread_All
	 * 54:Pct_of_OI_Tot_Rept_Long_All 55:Pct_of_OI_Tot_Rept_Short_All
	 * 56:Pct_of_OI_NonRept_Long_All 57:Pct_of_OI_NonRept_Short_All
	 * 58:Traders_Tot_All 59:Traders_Dealer_Long_All 60:Traders_Dealer_Short_All
	 * 61:Traders_Dealer_Spread_All 62:Traders_Asset_Mgr_Long_All
	 * 63:Traders_Asset_Mgr_Short_All 64:Traders_Asset_Mgr_Spread_All
	 * 65:Traders_Lev_Money_Long_All 66:Traders_Lev_Money_Short_All
	 * 67:Traders_Lev_Money_Spread_All 68:Traders_Other_Rept_Long_All
	 * 69:Traders_Other_Rept_Short_All 70:Traders_Other_Rept_Spread_All
	 * 71:Traders_Tot_Rept_Long_All 72:Traders_Tot_Rept_Short_All
	 * 73:Conc_Gross_LE_4_TDR_Long_All 74:Conc_Gross_LE_4_TDR_Short_All
	 * 75:Conc_Gross_LE_8_TDR_Long_All 76:Conc_Gross_LE_8_TDR_Short_All
	 * 77:Conc_Net_LE_4_TDR_Long_All 78:Conc_Net_LE_4_TDR_Short_All
	 * 79:Conc_Net_LE_8_TDR_Long_All 80:Conc_Net_LE_8_TDR_Short_All
	 * 81:Contract_Units 82:CFTC_SubGroup_Code 83:FutOnly_or_Combined
	 *
	 */
	private static void readAndProcess(Calendar cal) {
		final File allFiles = new File(folderPath);
		final File[] listOfFiles = allFiles.listFiles();
		final Calendar rptDate = Calendar.getInstance();

		for (final File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
				final Path path = file.toPath();
				try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
					String line = reader.readLine(); // Header

					while ((line = reader.readLine()) != null) {
						final String fld[] = line.trim().split(TAB);
						final String name = fld[0].trim();

						if (ProcessCOTS.validName(name)) {
							final String day = fld[1].trim();
							try {
								rptDate.setTime(sdf.parse(day));
							} catch (final ParseException e) {
								rptDate.set(1950, Calendar.DECEMBER, 25);
								e.printStackTrace();
							}

							// Filter on date if provided.
							if ((cal == null) || (Utils.sameDate(cal, rptDate))) {

								LongShort.SourceType st = null;
								if (name.contains("NASDAQ-100 Consolidated")) {
									st = LongShort.SourceType.NDX;
								} else if (name.contains("S&P 500 Consolidated")) {
									st = LongShort.SourceType.SPX;
								} else if (name.contains("RUSSELL 2000 MINI")) {
									st = LongShort.SourceType.RUT;
								} else if (name.contains("VIX FUTURES")) {
									st = LongShort.SourceType.VIX;
								}
								if (st != null) {
									CotsData.setDataPoint(fld[7], fld[7], "0", rptDate, LongShort.MarketType.OI, st);
									CotsData.setDataPoint(fld[8], fld[9], fld[10], rptDate, LongShort.MarketType.DEALER, st);
									CotsData.setDataPoint(fld[11], fld[12], fld[13], rptDate, LongShort.MarketType.PM, st);
									CotsData.setDataPoint(fld[14], fld[15], fld[16], rptDate, LongShort.MarketType.LEVERED, st);
									CotsData.setDataPoint(fld[17], fld[18], fld[19], rptDate, LongShort.MarketType.OTHER, st);
									CotsData.setDataPoint(fld[22], fld[23], "0", rptDate, LongShort.MarketType.NONRPT, st);
									CotsData.setDataPoint(fld[59], fld[60], fld[61], rptDate, LongShort.MarketType.TRADER_DEALER, st);
									CotsData.setDataPoint(fld[62], fld[63], fld[64], rptDate, LongShort.MarketType.TRADER_PM, st);
									CotsData.setDataPoint(fld[65], fld[66], fld[67], rptDate, LongShort.MarketType.TRADER_LEVERED, st);
									CotsData.setDataPoint(fld[68], fld[69], fld[70], rptDate, LongShort.MarketType.TRADER_OTHER, st);
								}

							}
						}
					}

				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

		Collections.sort(CotsData.dataPoints, new CotsSorter());
	}

	/**
	 * net.ajaskey.market.tools.validName
	 *
	 * @param name
	 * @return
	 */
	private static boolean validName(String name) {
		// System.out.println(name);
		for (final String s : validNames) {
			if (name.contains(s)) {
				return true;
			}
		}
		return false;
	}

}