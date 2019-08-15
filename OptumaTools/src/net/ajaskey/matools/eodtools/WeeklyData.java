
package net.ajaskey.matools.eodtools;

import java.util.ArrayList;
import java.util.List;

import net.ajaskey.common.DateTime;
import net.ajaskey.common.Utils;

public class WeeklyData {

   private List<PriceData> wdList = new ArrayList<>();

   public WeeklyData(DailyData ddata) {

      int yesterday = 0;
      int today = 0;

      double high = -1.0;
      double low = 9999999999.9;
      double open = -1.0;
      long vol = 0;

      double lastHigh = 0.0;
      double lastLow = 0.0;
      double lastOpen = 0.0;
      double lastClose = 0.0;
      long lastVol = 0;
      DateTime lastDate = null;

      for (PriceData pd : ddata.getPdList()) {
         today = pd.getDatetime().getDayOfWeek();
         String s = Utils.sdfFull.format(pd.getDatetime().getCal().getTime());
         System.out.printf("%s %d%n", s, today);

         if (today > yesterday) {

            high = Math.max(high, pd.getHigh());
            low = Math.min(low, pd.getLow());
            vol += pd.getVolume();

            if (open < 0.0) {
               open = pd.getOpen();
               lastOpen = open;
            }

            lastDate = pd.getDatetime();
            lastHigh = high;
            lastLow = low;
            lastClose = pd.getClose();
            lastVol = vol;

            if (today == DateTime.FRIDAY) {

               PriceData newPd = new PriceData(pd.getCode(), pd.getDatetime(), open, high, low, pd.getClose(), vol);
               wdList.add(newPd);

               System.out.println(newPd);

               high = -1.0;
               low = 9999999999.9;
               open = -1.0;
               vol = 0;
            }

         }
         else {
            PriceData newPd = new PriceData(pd.getCode(), lastDate, lastOpen, lastHigh, lastLow, lastClose,
                  lastVol);
            // wdList.add(newPd);

            System.out.println(newPd);

            high = -1.0;
            low = 9999999999.9;
            open = -1.0;
            vol = 0;
         }
         yesterday = today;
      }
   }

   public static void main(String[] args) {

      final DailyData ddata = new DailyData("C:\\Users\\Andy\\Documents\\PriceData\\AMEX\\J\\JAX.CSV");
      WeeklyData wdata = new WeeklyData(ddata);

      for (PriceData pd : wdata.wdList) {
         System.out.println(pd);
      }
   }

}
