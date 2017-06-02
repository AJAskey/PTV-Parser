
package net.ajaskey.market.tools.optuma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.ConvertOHLCV;
import net.ajaskey.market.tools.helpers.IciCombinedFlowData;
import net.ajaskey.market.tools.helpers.IciMoneyFlowData;

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
public class ProcessICI {

	public static List<IciCombinedFlowData>	data		= new ArrayList<>();
	public static List<IciMoneyFlowData>		mfList	= new ArrayList<>();

	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {

		ProcessICI.processMoneyFlow();
		ProcessICI.processEtfFlow();
	}

	public static void processEtfFlow() {

		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader("data/combined_flows_data_2017.txt"))) {

			Calendar lastCal = null;
			while ((line = reader.readLine()) != null) {
				if (line.toLowerCase().contains("estimated weekly fund flows")) {
					lastCal = Utils.buildCalendar(data.get(data.size() - 1).date);
					lastCal.add(Calendar.MONTH, 1);
					break;
				}
				IciCombinedFlowData d = new IciCombinedFlowData();
				d.build(line);
				if (d.valid) {
					data.add(d);
				} else {
					d = null;
				}
			}

			System.out.println(Utils.stringDate(lastCal));
			final IciCombinedFlowData weekly = new IciCombinedFlowData();
			weekly.date = lastCal;
			while ((line = reader.readLine()) != null) {
				final IciCombinedFlowData d = new IciCombinedFlowData();
				d.build(line);
				if (d.valid) {
					weekly.equityDomestic += d.equityDomestic;
					weekly.equityWorld += d.equityWorld;
					weekly.bondTaxable += d.bondTaxable;
					weekly.bondMuni += d.bondMuni;
					weekly.commodity += d.commodity;
				}
			}
			weekly.valid = true;
			data.add(weekly);

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (PrintWriter pwed = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_equity_dom.csv");
		    PrintWriter pwew = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_world_dom.csv");
		    PrintWriter pwbt = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_bond_taxable.csv");
		    PrintWriter pwbm = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_bond_municipal.csv");
		    PrintWriter pwc = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_commodity.csv")) {

			for (final IciCombinedFlowData p : data) {
				if (p.valid) {
					System.out.println(p);
					final String dat = sdfOptuma.format(p.date.getTime());
					pwed.println(dat + "," + p.equityDomestic);
					pwew.println(dat + "," + p.equityWorld);
					pwbt.println(dat + "," + p.bondTaxable);
					pwbm.println(dat + "," + p.bondMuni);
					pwc.println(dat + "," + p.commodity);
				}
			}
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * net.ajaskey.market.tools.optuma.main
	 *
	 * @param args
	 */
	public static void processMoneyFlow() {

		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader("data/flows_data_2017.txt"))) {

			Calendar lastCal = null;
			while ((line = reader.readLine()) != null) {
				if (line.toLowerCase().contains("estimated weekly net new cash flow")) {
					lastCal = Utils.buildCalendar(mfList.get(mfList.size() - 1).date);
					lastCal.add(Calendar.MONTH, 1);
					break;
				}
				IciMoneyFlowData d = new IciMoneyFlowData();
				d.build(line);
				if (d.valid) {
					mfList.add(d);
				} else {
					d = null;
				}
			}

			System.out.println(Utils.stringDate(lastCal));
			final IciMoneyFlowData weekly = new IciMoneyFlowData();
			weekly.date = lastCal;
			while ((line = reader.readLine()) != null) {
				final IciMoneyFlowData d = new IciMoneyFlowData();
				d.build(line);
				if (d.valid) {
					weekly.total += d.total;
					weekly.equity += d.equity;
					weekly.domestic += d.domestic;
					weekly.lcap += d.lcap;
					weekly.mcap += d.mcap;
					weekly.scap += d.scap;
				}
			}
			weekly.valid = true;
			mfList.add(weekly);

		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (PrintWriter pwt = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_total_mf.csv");
		    PrintWriter pwe = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_equity_mf.csv");
		    PrintWriter pwd = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_eq_domestic_mf.csv");
		    PrintWriter pwlc = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_eq_lcap_mf.csv");
		    PrintWriter pwmc = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_eq_mcap_mf.csv");
		    PrintWriter pwsc = new PrintWriter(ConvertOHLCV.shortPath + "\\ici_eq_scap_mf.csv")) {

			for (final IciMoneyFlowData p : mfList) {
				if (p.valid) {
					System.out.println(p);
					final String dat = sdfOptuma.format(p.date.getTime());
					pwt.println(dat + "," + p.total);
					pwe.println(dat + "," + p.equity);
					pwd.println(dat + "," + p.domestic);
					pwlc.println(dat + "," + p.lcap);
					pwmc.println(dat + "," + p.mcap);
					pwsc.println(dat + "," + p.scap);
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
