
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

	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public static void main(final String[] args) throws ParseException, IOException {

		DataItemList.readOptionData("data/spy-options.dat");
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
	public static DataItemList readOptionData(final String filename) throws FileNotFoundException, IOException {

		final DataItemList diData = new DataItemList();

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

			final String header1 = reader.readLine();
			final String hdr[] = header1.trim().split(",");
			diData.code = hdr[0].trim();
			diData.last = Double.parseDouble(hdr[1].trim());

			final String header2 = reader.readLine();
			final String header3 = reader.readLine();
			System.out.println(header1);
			System.out.println(header2);
			System.out.println(header3);
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {

					final String fld[] = str.split(",");

					try {
						final Date d = sdf.parse(fld[0].trim());
						final Calendar c = Calendar.getInstance();
						c.setTime(d);

						final DataItem dicall = new DataItem(c, diData.last, Arrays.copyOfRange(fld, 1, 12), DataItem.ACALL);
						diData.diList.add(dicall);
						System.out.println(dicall);
						final DataItem diput = new DataItem(c, diData.last, Arrays.copyOfRange(fld, 11, 22), DataItem.APUT);
						diData.diList.add(diput);
						System.out.println(diput);

						//System.out.println(sdf.format(c.getTime()));
					} catch (final Exception e) {
					}

				}
			}
		}
		return null;
	}

	String code;

	double last;

	int volume;

	List<DataItem> diList;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataItemList() {

		this.diList = new ArrayList<>();
	}

}
