
package net.ajaskey.matools;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.ajaskey.matools.eodtools.PriceData;

public class ReadOptumaFiles {

   public static void main(String[] args) throws FileNotFoundException, IOException {

      PriceData.ReadPriceData("C:\\Users\\Andy\\Documents\\PriceData\\AMEX\\J\\JAX.CSV");

   }

}
