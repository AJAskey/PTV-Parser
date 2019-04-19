
package net.ajaskey.market.tools.options;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
	double					last;
	int							volume;
	List<DataItem>	diList;

	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataItemList() {

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
	public static DataItemList readOptionData(String filename) throws FileNotFoundException, IOException {

		DataItemList diData = new DataItemList();

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

			String header1 = reader.readLine();
			String hdr[] = header1.trim().split(",");
			diData.code = hdr[0].trim();
			diData.last = Double.parseDouble(hdr[1].trim());

			String header2 = reader.readLine();
			String header3 = reader.readLine();
			System.out.println(header1);
			System.out.println(header2);
			System.out.println(header3);
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {

					String fld[] = str.split(",");

					try {
						Date d = sdf.parse(fld[0].trim());
						Calendar c = Calendar.getInstance();
						c.setTime(d);

						DataItem dicall = new DataItem(c, diData.last, Arrays.copyOfRange(fld, 1, 12), DataItem.ACALL);
						diData.diList.add(dicall);
						System.out.println(dicall);
						DataItem diput = new DataItem(c, diData.last, Arrays.copyOfRange(fld, 11, 22), DataItem.APUT);
						diData.diList.add(diput);
						System.out.println(diput);

						//System.out.println(sdf.format(c.getTime()));
					} catch (Exception e) {
					}

				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws ParseException, IOException {

		DataItemList diList = readOptionData("data/spy-options.dat");
	}

}
