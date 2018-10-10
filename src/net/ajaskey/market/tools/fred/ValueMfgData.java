
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.optuma.OptumaCommon;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class ValueMfgData {

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static List<ValueMfgData> shipments = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.dump
	 *
	 */
	public static void dump() {

		for (final ValueMfgData vmd : ValueMfgData.shipments)
			System.out.println(vmd);

	}

	/**
	 * net.ajaskey.market.tools.fred.setInventory
	 *
	 * @param trim
	 * @throws ParseException
	 */
	public static void setInventory(String inv) {

		try {
			final String fld[] = inv.split(",");
			final Date d = sdf.parse(fld[0].trim());
			final Calendar date = Calendar.getInstance();
			date.setTime(d);

			for (final ValueMfgData vmd : shipments)
				if (Utils.sameDate(date, vmd.date)) {
					final double inventory = Double.parseDouble(fld[1].trim());
					vmd.inventory = inventory;
					if (vmd.shipped > 0.0) {
						vmd.itos = vmd.inventory / vmd.shipped;
					}
					vmd.valid = true;
					return;
				}
		} catch (final Exception e) {
		}
	}

	public static void setShipments(String shipFile) throws FileNotFoundException, IOException {

		String line = "";
		try (BufferedReader reader = new BufferedReader(
		    new FileReader(OptumaCommon.optumaPath + "/Fred-Download/" + shipFile))) {
			while ((line = reader.readLine()) != null) {
				final ValueMfgData vmd = new ValueMfgData(line.trim());
				ValueMfgData.shipments.add(vmd);
			}
		}
		
//		for (ValueMfgData vmd : shipments) {
//			System.out.printf("%s : %.2f%n", sdf.format(vmd.date.getTime()), vmd.shipped);
//		}
	}

	public Calendar	date;
	public double		inventory;
	public double		shipped;
	public double		itos;

	public boolean valid;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param trim
	 */
	public ValueMfgData(String inv) {

		try {
			final String fld[] = inv.split(",");
			final Date d = sdf.parse(fld[0].trim());
			this.date = Calendar.getInstance();
			this.date.setTime(d);
			this.shipped = Double.parseDouble(fld[1].trim());
			this.valid = false;
		} catch (final Exception e) {
			this.date = Calendar.getInstance();
			this.shipped = 0.0;
			this.inventory = 0.0;
			this.itos = 0.0;
			this.valid = false;
		}

		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "";
		if (this.valid) {
			ret += sdf.format(this.date.getTime());
			ret += String.format("\t%.1f\t%.1f\t%.2f", this.inventory, this.shipped, this.itos);
		}
		return ret;
	}
}
