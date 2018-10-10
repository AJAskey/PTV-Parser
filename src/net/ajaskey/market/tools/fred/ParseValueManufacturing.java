
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ParseValueManufacturing {

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File folder = new File(OptumaCommon.optumaPath + "/Fred-Download/");
		File[] listOfFiles = folder.listFiles();

		for (File shipFile : listOfFiles) {
			if (shipFile.isFile()) {
				if (shipFile.getName().toUpperCase().contains("VALUE SHIPMENTS")) {
					String invFile = getFilePair(shipFile.getName().substring(1, 4), listOfFiles);
					if (invFile != null) {
						//System.out.printf("%s%n%s%n%n", shipFile.getName(), invFile);
						writeItoS(shipFile.getName(), invFile);
					}
				}
			}
		}

		//

	}

	/**
	 * net.ajaskey.market.tools.fred.writeItoS
	 *
	 * @param shipFile
	 * @param invFile
	 * @throws IOException
	 */
	private static void writeItoS(String shipFile, String invFile) throws IOException {

		ValueMfgData.setShipments(shipFile);

		System.out.println(invFile);
		String line = "";
		try (BufferedReader reader = new BufferedReader(
		    new FileReader(OptumaCommon.optumaPath + "/Fred-Download/" + invFile))) {
			while ((line = reader.readLine()) != null) {
				ValueMfgData.setInventory(line.trim());
			}
		}

		int idx = shipFile.indexOf("Value Shipments for ");
		String outname = "Inventory to Shipments for " + shipFile.substring(idx + 20);

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "/Fred-Download/" + outname)) {
			pw.println("Date,ItoS");
			for (ValueMfgData vmd : ValueMfgData.shipments) {
				if (vmd.valid) {
					pw.printf("%s,%.2f%n", ValueMfgData.sdf.format(vmd.date.getTime()), vmd.itos);
				}
			}
		}

		//ValueMfgData.dump();
		ValueMfgData.shipments.clear();
	}

	/**
	 * net.ajaskey.market.tools.fred.getFilePair
	 * 
	 * @param files
	 *
	 * @return
	 */
	private static String getFilePair(String code, File[] files) {

		for (File file : files) {
			if (file.isFile()) {
				if (file.getName().toUpperCase().contains("VALUE TOTAL INVENTORIES")) {
					if (file.getName().substring(1, 4).equalsIgnoreCase(code)) {
						return file.getName();
					}
				}
			}
		}
		return null;
	}

}
