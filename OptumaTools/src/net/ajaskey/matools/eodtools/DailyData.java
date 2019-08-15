
package net.ajaskey.matools.eodtools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DailyData {

   public static void main(String[] args) {

      final DailyData ddata = new DailyData("C:\\Users\\Andy\\Documents\\PriceData\\NASDAQ\\J\\JACK.CSV");
      WeeklyData wdata = new WeeklyData(ddata);

      for (final PriceData pd : ddata.pdList) {
         System.out.println(pd);
      }
      System.out.printf("Close  20dma : %.2f%n", ddata.price20dma);
      System.out.printf("Close  50dma : %.2f%n", ddata.price50dma);
      System.out.printf("Volume 50dma : %.2f%n", ddata.vol50dma);

   }

   private List<PriceData> pdList = new ArrayList<>();

   public List<PriceData> getPdList() {

      return pdList;
   }

   private DerivedData dd = null;

   private double price20dma;
   private double price50dma;
   private double vol50dma;

   private boolean valid;

   public DailyData(String fname) {

      try {
         pdList = PriceData.ReadPriceData(fname);

         final int start = pdList.size() - 1;
         int stop = start - 50;

         if (stop > 0) {

            double d = 0;
            for (int i = start; i > stop; i--) {
               d += pdList.get(i).getClose();
            }
            price50dma = d / 50.0;

            d = 0;
            for (int i = start; i > stop; i--) {
               d += pdList.get(i).getVolume();
            }
            vol50dma = d / 50.0;

            stop = start - 20;
            d = 0;
            for (int i = start; i > stop; i--) {
               d += pdList.get(i).getClose();
            }
            price20dma = d / 20.0;
            setValid(true);
            dd = new DerivedData(this);
         }
         else {
            price50dma = 0.0;
            price20dma = 0.0;
            vol50dma = 0.0;
            setValid(false);
         }

      } catch (final IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public boolean isValid() {

      return valid;
   }

   private void setValid(boolean valid) {

      this.valid = valid;
   }

}
