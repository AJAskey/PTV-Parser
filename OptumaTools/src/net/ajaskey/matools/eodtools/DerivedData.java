
package net.ajaskey.matools.eodtools;

public class DerivedData {

   private boolean         swing3bar;
   private final DailyData dd;

   public DerivedData(DailyData dailyData) {

      dd = dailyData;
      setSwing3bar();
   }

   public boolean isSwing3bar() {

      return swing3bar;
   }

   private void setSwing3bar() {

      swing3bar = false;
      for (final PriceData pd : dd.getPdList()) {

      }
   }

}
