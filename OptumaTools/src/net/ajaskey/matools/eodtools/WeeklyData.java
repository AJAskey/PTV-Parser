
package net.ajaskey.matools.eodtools;

import java.util.ArrayList;
import java.util.List;

import net.ajaskey.common.DateTime;
import net.ajaskey.common.Utils;

public class WeeklyData {

   /**
    *
    * @param args
    */
   public static void main(String[] args) {

      final DailyData ddata = new DailyData("C:\\Users\\Andy\\Documents\\PriceData\\AMEX\\J\\JAX.CSV");
      final WeeklyData wdata = new WeeklyData(ddata);

      for (final PriceData pd : wdata.wdList) {
         System.out.println(pd);
      }
   }

   private final List<PriceData> wdList     = new ArrayList<>();
   private double                price52wma = 0.0;

   /**
    *
    * @param ddata
    */
   public WeeklyData(DailyData ddata) {

      int yesterday = -1;
      int today = -1;

      double high = -1.0;
      double low = 9999999999.9;
      double open = -1.0;
      long vol = 0;

      for (final PriceData pd : ddata.getPdList()) {

         today = pd.getDatetime().getDayOfWeek();

         final String s = Utils.sdfFull.format(pd.getDatetime().getTime());
         System.out.printf("%s %d%n", s, today);

         // Days are sequential... reset on first trading day of week
         if (today > yesterday) {

            high = Math.max(high, pd.getHigh());
            low = Math.min(low, pd.getLow());
            vol += pd.getVolume();

            if (open < 0.0) {
               open = pd.getOpen();
            }

            if (today == DateTime.FRIDAY) {

               final PriceData newPd = new PriceData(pd.getCode(), pd.getDatetime(), open, high, low, pd.getClose(),
                     vol);
               this.wdList.add(newPd);

               System.out.println(newPd);

               high = -1.0;
               low = 9999999999.9;
               open = -1.0;
               vol = 0;
            }

         }

         yesterday = today;
      }

      this.setPrice52wma();
   }

   /**
    *
    * @return
    */
   public double getPrice52wma() {

      return this.price52wma;
   }

   /**
    *
    */
   private void setPrice52wma() {

      this.price52wma = 0.0;

      double price = 0.0;
      if (this.wdList.size() > 52) {
         final int start = this.wdList.size() - 1;
         final int stop = start - 52;
         for (int i = start; i > stop; i--) {
            price += this.wdList.get(i).getClose();
         }
         this.price52wma = price / 52.0;
      }
   }

}
