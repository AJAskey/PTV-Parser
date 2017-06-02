
package net.ajaskey.market.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.ajaskey.market.misc.Utils;

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
public class TestExcel {

	/**
	 * net.ajaskey.market.tools.convertDate
	 *
	 * @param day
	 * @return
	 */
	private static Calendar convertDate(int day) {

		final Calendar base = Calendar.getInstance();
		base.set(1900, Calendar.JANUARY, 1);
		base.add(Calendar.DATE, day);
		return base;
	}

	public static void main(String[] args) throws IOException {

		final String excelFilePath = "input/fred.xlsx";
		final FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		final Workbook workbook = new XSSFWorkbook(inputStream);
		final Sheet firstSheet = workbook.getSheetAt(0);
		final Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			final Row nextRow = iterator.next();
			final Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				final Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						final double day = cell.getNumericCellValue();
						System.out.print(day);
						if (day > 30000.0) {
							final Calendar cal = TestExcel.convertDate((int) day);
							System.out.print("\t" + Utils.stringDate(cal));
						}
						break;
				}
				System.out.print("\t");
			}
			System.out.println();
		}

		workbook.close();
		inputStream.close();
	}

}
