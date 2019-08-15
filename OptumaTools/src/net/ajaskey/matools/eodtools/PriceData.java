
package net.ajaskey.matools.eodtools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.common.DateTime;
import net.ajaskey.common.Utils;

public class PriceData {

   public static final String NL  = "\n";
   public static final String TAB = "\t";

   /**
    *
    * @param fname
    * @throws FileNotFoundException
    * @throws IOException
    */
   public static List<PriceData> ReadPriceData(String fname) throws FileNotFoundException, IOException {

      final List<PriceData> pdList = new ArrayList<>();

      try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {

         String line = "";
         while ((line = reader.readLine()) != null) {
            final String str = line.trim();
            if (str.length() > 1) {

               final PriceData pd = new PriceData();

               // System.out.println(str);
               final String fld[] = str.split(",");

               int ptr = 0;
               pd.code = fld[ptr++].trim().toUpperCase();
               pd.datetime = new DateTime(fld[ptr++].trim(), "yyyyMMdd");
               System.out.printf("%s\t%s\t%s%n", fld[ptr - 1].trim(), pd.datetime,
                     Utils.sdf2.format(pd.getDatetime().getCal().getTime()));

               if (pd.datetime.isValid()) {

                  try {
                     pd.open = Double.parseDouble(fld[ptr++].trim());
                     pd.high = Double.parseDouble(fld[ptr++].trim());
                     pd.low = Double.parseDouble(fld[ptr++].trim());
                     pd.close = Double.parseDouble(fld[ptr++].trim());
                     pd.volume = Long.parseLong(fld[ptr++].trim());
                     pdList.add(pd);

                     // System.out.println(pd);

                  } catch (final Exception e) {
                     e.printStackTrace();
                  }
               }
               else {
                  System.out.println("Not valid");
               }
            }
         }
      }

      return pdList;
   }

   private String code;

   private DateTime datetime;

   private double open;
   private double high;
   private double low;
   private double close;
   private long   volume;

   /**
    *
    */
   public PriceData() {

      code = "";
      datetime = null;
      open = 0.0;
      high = 0.0;
      low = 0.0;
      close = 0.0;
      volume = 0;
   }

   public PriceData(String cd, DateTime dt, double o, double h, double l, double c, long vol) {

      code = cd;
      datetime = new DateTime(dt);
      open = o;
      high = h;
      low = l;
      close = c;
      volume = vol;
   }

   /**
    * @return the close
    */
   public double getClose() {

      return close;
   }

   public String getCode() {

      return code;
   }

   /**
    * @return the datetime
    */
   public DateTime getDatetime() {

      return datetime;
   }

   /**
    * @return the high
    */
   public double getHigh() {

      return high;
   }

   /**
    * @return the low
    */
   public double getLow() {

      return low;
   }

   /**
    * @return the open
    */
   public double getOpen() {

      return open;
   }

   /**
    * @return the volume
    */
   public long getVolume() {

      return volume;
   }

   /**
    * @param close
    *           the close to set
    */
   public void setClose(double close) {

      this.close = close;
   }

   /**
    * @param datetime
    *           the datetime to set
    */
   public void setDatetime(DateTime datetime) {

      this.datetime = datetime;
   }

   /**
    * @param high
    *           the high to set
    */
   public void setHigh(double high) {

      this.high = high;
   }

   /**
    * @param low
    *           the low to set
    */
   public void setLow(double low) {

      this.low = low;
   }

   /**
    * @param open
    *           the open to set
    */
   public void setOpen(double open) {

      this.open = open;
   }

   /**
    * @param volume
    *           the volume to set
    */
   public void setVolume(long volume) {

      this.volume = volume;
   }

   /**
    *
    */
   @Override
   public String toString() {

      String ret = code + PriceData.TAB + datetime.format("yyyy-MMM-dd EE") + PriceData.NL;
      ret += String.format("%sOpen  : %.2f%s", PriceData.TAB, open, PriceData.NL);
      ret += String.format("%sHigh  : %.2f%s", PriceData.TAB, high, PriceData.NL);
      ret += String.format("%sLow   : %.2f%s", PriceData.TAB, low, PriceData.NL);
      ret += String.format("%sClose : %.2f%s", PriceData.TAB, close, PriceData.NL);
      ret += String.format("%sVol   : %d", PriceData.TAB, volume);
      return ret;
   }
}
