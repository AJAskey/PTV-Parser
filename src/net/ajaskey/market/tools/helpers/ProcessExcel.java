
package net.ajaskey.market.tools.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author ajask_000
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
public class ProcessExcel {

	public Calendar	date;
	public double		value;

	/**
	 *
	 * net.ajaskey.market.tools.helpers.convertXlsToXlsx
	 *
	 * @param fname
	 * @throws IOException
	 */
	public static void convertXlsToXlsx(String fname) throws IOException {
		final String outFn = fname + "x";

		try (InputStream in = new BufferedInputStream(new FileInputStream(fname));
		    final Workbook wbIn = new HSSFWorkbook(in);
		    final Workbook wbOut = new XSSFWorkbook()) {

			final int sheetCnt = wbIn.getNumberOfSheets();

			for (int i = 0; i < sheetCnt; i++) {

				final Sheet sIn = wbIn.getSheetAt(0);
				final Sheet sOut = wbOut.createSheet(sIn.getSheetName());

				final Iterator<Row> rowIt = sIn.rowIterator();
				while (rowIt.hasNext()) {
					final Row rowIn = rowIt.next();
					final Row rowOut = sOut.createRow(rowIn.getRowNum());

					final Iterator<Cell> cellIt = rowIn.cellIterator();
					while (cellIt.hasNext()) {
						final Cell cellIn = cellIt.next();
						final Cell cellOut = rowOut.createCell(cellIn.getColumnIndex(), cellIn.getCellType());

						switch (cellIn.getCellType()) {
							case Cell.CELL_TYPE_BLANK:
								break;

							case Cell.CELL_TYPE_BOOLEAN:
								cellOut.setCellValue(cellIn.getBooleanCellValue());
								break;

							case Cell.CELL_TYPE_ERROR:
								cellOut.setCellValue(cellIn.getErrorCellValue());
								break;

							case Cell.CELL_TYPE_FORMULA:
								cellOut.setCellFormula(cellIn.getCellFormula());
								break;

							case Cell.CELL_TYPE_NUMERIC:
								cellOut.setCellValue(cellIn.getNumericCellValue());
								break;

							case Cell.CELL_TYPE_STRING:
								cellOut.setCellValue(cellIn.getStringCellValue());
								break;
						}

						{
							final CellStyle styleIn = cellIn.getCellStyle();
							final CellStyle styleOut = cellOut.getCellStyle();
							styleOut.setDataFormat(styleIn.getDataFormat());
						}
						cellOut.setCellComment(cellIn.getCellComment());
					}
				}
			}

			final File outF = new File(outFn);
			if (outF.exists()) {
				outF.delete();
			}
			try (final OutputStream out = new BufferedOutputStream(new FileOutputStream(outF))) {
				
				wbOut.write(out);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// convertXlsToXlsx("input/fred2.xls");

		final List<ProcessExcel> peList = ProcessExcel.parseFred("input/fred.xls");
		for (final ProcessExcel pe : peList) {
			System.out.println(Utils.stringDate(pe.date) + "\t" + pe.value);
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.parseFred
	 *
	 * @param fName
	 * @throws IOException
	 */
	public static List<ProcessExcel> parseFred(String fName) throws IOException {

		final List<ProcessExcel> retList = new ArrayList<>();

		final String ext = ProcessExcel.getExtention(fName);
		if (ext.contentEquals("xls")) {
			ProcessExcel.convertXlsToXlsx(fName);
			fName += "x";
		}

		final String excelFilePath = fName;
		try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {

			final Workbook workbook = new XSSFWorkbook(inputStream);
			final Sheet firstSheet = workbook.getSheetAt(0);
			final Iterator<Row> iterator = firstSheet.iterator();

			int lknt = 0;
			while (iterator.hasNext()) {
				final Row nextRow = iterator.next();
				final Iterator<Cell> cellIterator = nextRow.cellIterator();
				lknt++;
				int knt = 0;
				final ProcessExcel pe = new ProcessExcel();
				while (cellIterator.hasNext()) {
					final Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.println(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:

							if (knt == 0) {
								pe.date = ProcessExcel.convertDate((int) (cell.getNumericCellValue()));
								knt++;
							} else if (knt == 1) {
								pe.value = cell.getNumericCellValue();
								retList.add(pe);
							} else {
								System.out.println("Unexpected value in line " + lknt + "  : " + cell.getNumericCellValue());
							}

							break;
					}
				}
			}
			workbook.close();
			inputStream.close();
		}

		return retList;
	}

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

	/**
	 * net.ajaskey.market.tools.helpers.getExtention
	 *
	 * @param fName
	 * @return
	 */
	public static String getExtention(String fName) {
		String ret = null;
		final int idx = fName.lastIndexOf(".");
		if (idx > 1) {
			ret = fName.substring(idx + 1).toLowerCase();
		}
		return ret;
	}

}
