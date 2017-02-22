
package net.ajaskey.market.tools.optuma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.ConvertOHLCV;

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

	public Calendar	date;
	public long			equityDomestic;
	public long			equityWorld;
	public long			bondTaxable;
	public long			bondMuni;
	public long			commodity;
	public boolean	valid;

	public static List<ProcessICI> data = new ArrayList<>();

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ProcessICI() {
		this.valid = false;
		equityDomestic = 0;
		equityWorld = 0;
		bondTaxable = 0;
		bondMuni = 0;
		commodity = 0;
	}

	/**
	 * net.ajaskey.market.tools.optuma.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader("data/combined_flows_data_2017.txt"))) {

			Calendar lastCal = null;
			while ((line = reader.readLine()) != null) {
				if (line.toLowerCase().contains("estimated weekly fund flows")) {
					lastCal = Utils.buildCalendar(data.get(data.size() - 1).date);
					lastCal.add(Calendar.MONTH, 1);
					break;
				}
				ProcessICI d = ProcessICI.build(line);
				if (d.valid) {
					data.add(d);
				}
			}

			System.out.println(Utils.stringDate(lastCal));
			ProcessICI weekly = new ProcessICI();
			weekly.date = lastCal;
			while ((line = reader.readLine()) != null) {
				ProcessICI d = ProcessICI.build(line);
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

			for (ProcessICI p : data) {
				if (p.valid) {
					System.out.println(p);
					String dat = sdfOptuma.format(p.date.getTime());
					pwed.println(dat + "," + p.equityDomestic);
					pwew.println(dat + "," + p.equityWorld);
					pwbt.println(dat + "," + p.bondTaxable);
					pwbm.println(dat + "," + p.bondMuni);
					pwc.println(dat + "," + p.commodity);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ProcessICI build(String line) {

		final ProcessICI ret = new ProcessICI();
		try {
			String str = line.replaceAll(",", "").replaceAll("\"", "").trim();
			String fld[] = str.split("\\s+");
			final Date date = sdf.parse(fld[0].trim());
			ret.date = Calendar.getInstance();
			ret.date.setTime(date);
			ret.equityDomestic = Long.parseLong(fld[3].trim());
			ret.equityWorld = Long.parseLong(fld[4].trim());
			ret.bondTaxable = Long.parseLong(fld[7].trim());
			ret.bondMuni = Long.parseLong(fld[8].trim());
			ret.commodity = Long.parseLong(fld[9].trim());
			ret.valid = true;
		} catch (Exception e) {
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = sdfOptuma.format(date.getTime());
		ret += Utils.TAB + equityDomestic;
		ret += Utils.TAB + equityWorld;
		ret += Utils.TAB + bondTaxable;
		ret += Utils.TAB + bondMuni;
		ret += Utils.TAB + commodity;
		return ret;
	}

}
