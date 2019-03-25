
package net.ajaskey.market.tools.options;

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
public class DataItemList {

	String					code;
	double					bid;
	double					ask;
	double					last;
	int							volume;
	List<DataItem>	diList;

	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataItemList(String c, double b, double a, double l, int volume) {

		diList = new ArrayList<>();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.options.readOptionData
	 *
	 * @param filename
	 * @param optionType
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static DataItemList readOptionData(String filename)
	    throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

			String header1 = reader.readLine();
			String header2 = reader.readLine();
			System.out.println(header1);
			System.out.println(header2);
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {

					String fld[] = str.split(",");

					try {
						Date d = sdf.parse(fld[0].trim());
						Calendar c = Calendar.getInstance();
						c.setTime(d);
						
						DataItem di = new DataItem(fld);
						
						//System.out.println(sdf.format(c.getTime()));
					} catch (Exception e) {
					}

				}
			}
		}
		return null;
	}
	
	/**
	 *
	 * @param fld
	 * @param putcalltype
	 */
	private DataItemList(String fld[], int putcalltype) {

		int ptr = 0;
		this.id = fld[ptr++].trim();
		this.last = Double.parseDouble(fld[ptr++].trim());
		this.net = Double.parseDouble(fld[ptr++].trim());
		this.bid = Double.parseDouble(fld[ptr++].trim());
		this.ask = Double.parseDouble(fld[ptr++].trim());
		this.volume = Integer.parseInt(fld[ptr++].trim());
		this.iv = Double.parseDouble(fld[ptr++].trim());
		this.delta = Double.parseDouble(fld[ptr++].trim());
		this.gamma = Double.parseDouble(fld[ptr++].trim());
		this.oi = Double.parseDouble(fld[ptr++].trim());
		this.dataType = putcalltype;
	}
	
	public static void main(String[] args) throws ParseException, IOException {

		DataItemList diList = readOptionData("data/spy-options.dat");
	}

}
