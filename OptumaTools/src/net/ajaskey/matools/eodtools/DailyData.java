
package net.ajaskey.matools.eodtools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DailyData {

   public static void main(String[] args) {

      final DailyData ddata = new DailyData("C:\\Users\\Andy\\Documents\\PriceData\\NASDAQ\\J\\JACK.CSV");
      // WeeklyData wd = new WeeklyData(ddata);

      // for (final PriceData pd : ddata.pdList) {
      System.out.println(ddata);
      // }
      System.out.printf("Close  20dma : %.2f%n", ddata.price20dma);
      System.out.printf("Close  50dma : %.2f%n", ddata.price50dma);
      System.out.printf("Volume 50dma : %.2f%n", ddata.vol50dma);

   }

   private List<PriceData> pdList = new ArrayList<>();

   // private DerivedData dd = null;

   private double price20dma;
   private double price50dma;
   private double vol50dma;

   private boolean swingUp;
   //
   private boolean valid;

   private static final String NL = "\n";

   public DailyData(String fname) {

      this.setSwingUp(false);

      try {
         this.pdList = PriceData.ReadPriceData(fname);

         for (int i = this.pdList.size() - 1; i > 0; i--) {
            int today = i;
            int yesterday = today - 1;
            double hhtod = this.pdList.get(today).getHigh();
            double hhyes = this.pdList.get(yesterday).getHigh();
            if (hhtod > hhyes) {
               setHigherhigh(true);
            }
            if (this.pdList.get(today).getLow() < this.pdList.get(yesterday).getLow()) {
               setLowerlow(true);
            }
         }
         final int start = this.pdList.size() - 1;
         int stop = start - 50;

         if (stop > 0) {

            double d = 0;
            for (int i = start; i > stop; i--) {
               d += this.pdList.get(i).getClose();
            }
            this.price50dma = d / 50.0;

            d = 0;
            for (int i = start; i > stop; i--) {
               d += this.pdList.get(i).getVolume();
            }
            this.vol50dma = d / 50.0;

            stop = start - 20;
            d = 0;
            for (int i = start; i > stop; i--) {
               d += this.pdList.get(i).getClose();
            }
            this.price20dma = d / 20.0;
            this.setValid(true);
            // this.dd = new DerivedData(this);

         }
         else {
            this.price50dma = 0.0;
            this.price20dma = 0.0;
            this.vol50dma = 0.0;
            this.setValid(false);
         }

      } catch (final IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public List<PriceData> getPdList() {

      return this.pdList;
   }

   public boolean isHigherhigh() {

      return this.higherhigh;
   }

   public boolean isLowerlow() {

      return this.lowerlow;
   }

   public boolean isSwingUp() {

      return this.swingUp;
   }

   public boolean isValid() {

      return this.valid;
   }

   public void setHigherhigh(boolean higherhigh) {

      this.higherhigh = higherhigh;
   }

   public void setLowerlow(boolean lowerlow) {

      this.lowerlow = lowerlow;
   }

   private void setSwingUp(boolean swingState) {

      this.swingUp = swingState;
   }

   private void setValid(boolean valid) {

      this.valid = valid;
   }

   @Override
   public String toString() {

      String ret = "";

      for (PriceData pd : this.pdList) {
         ret += pd.toString() + NL;
         ret += "\tisHH  : " + this.isHigherhigh() + NL;
         ret += "\tisLL  : " + this.isLowerlow() + NL;
      }
      return ret;
   }

}
