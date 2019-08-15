
package net.ajaskey.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This class encapsulates and improves the implementation of the
 * java.utils.Calendar class.
 *
 * @author Andy Askey
 *
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *
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
public class DateTime {

   public static final int APRIL  = Calendar.APRIL;
   public static final int AUGUST = Calendar.AUGUST;
   public static final int DATE   = Calendar.DATE;
   public static final int DECEMBER = Calendar.DECEMBER;
   public static final int FEBRUARY = Calendar.FEBRUARY;
   public static final int FRIDAY   = Calendar.FRIDAY;
   public static final int JANUARY  = Calendar.JANUARY;
   public static final int JULY     = Calendar.JULY;
   public static final int JUNE     = Calendar.JUNE;
   public static final int MARCH    = Calendar.MARCH;
   public static final int MAY      = Calendar.MAY;
   public static final int MONDAY   = Calendar.MONDAY;
   public static final int MONTH    = Calendar.MONTH;
   public static final int NOVEMBER = Calendar.NOVEMBER;
   public static final int OCTOBER  = Calendar.OCTOBER;
   public static final int SATURDAY  = Calendar.SATURDAY;
   public static final int SEPTEMBER = Calendar.SEPTEMBER;
   public static final int SUNDAY    = Calendar.SUNDAY;
   public static final int THURSDAY  = Calendar.THURSDAY;
   public static final int TUESDAY   = Calendar.TUESDAY;
   public static final int WEDNESDAY = Calendar.WEDNESDAY;
   public static final int YEAR      = Calendar.YEAR;

   /**
    *
    * net.ajaskey.market.misc.main
    *
    * @param args
    */
   public static void main(final String[] args) {

      final DateTime dt = new DateTime();
      final DateTime dt2 = new DateTime();
      dt2.add(DateTime.DATE, 1);
      System.out.println(dt);
      System.out.println(dt2);
      boolean b = dt.isLessThan(dt2);
      System.out.println("dt < dt2 : " + b);
      b = dt2.isLessThan(dt);
      System.out.println("dt2 < dt : " + b);

      b = dt.isGreaterThan(dt2);
      System.out.println("dt > dt2 : " + b);
      b = dt2.isGreaterThan(dt);
      System.out.println("dt2 > dt : " + b);

      System.out.println(dt.getSdf().toPattern());
      System.out.println(dt.getMonth());
      System.out.println(dt.getDay());
      System.out.println(dt.getYear());
      System.out.println(dt.getDayOfYear());
      System.out.println(dt.getDayOfWeek());
      System.out.println(dt.getDayOfMonth());
      final String s = dt.format("yyyy-MM-dd");
      System.out.println(s);
      dt.setSdf(Utils.sdfFull);
      System.out.println(dt);
      System.out.println(dt.getSdf().toPattern());
      System.out.println(dt.isWeekday());
      dt.set(2019, DateTime.MAY, 5);
      System.out.println(dt);
      System.out.println(dt.isWeekday());
      dt.add(DateTime.DATE, 3);
      System.out.println(dt);
      dt.add(DateTime.MONTH, -13);
      System.out.println(dt);

   }

   private Calendar         cal = null;
   private SimpleDateFormat sdf = null;

   /**
    * This method serves as a constructor for the class.
    *
    */
   public DateTime() {

      cal = Calendar.getInstance();
   }

   /**
    *
    * This method serves as a constructor for the class.
    *
    * @param c
    *           Instantiated Calendar variable
    */
   public DateTime(final Calendar c) {

      cal = Calendar.getInstance();
      try {
         cal.setTime(c.getTime());
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    *
    * This method serves as a constructor for the class.
    *
    * @param d
    *           Instantiated Date variable
    */
   public DateTime(final Date d) {

      cal = Calendar.getInstance();
      try {
         cal.setTime(d);
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    *
    * This method serves as a constructor for the class.
    *
    * @param dt
    *           Instantiated DateTime variable
    */
   public DateTime(final DateTime dt) {

      cal = Calendar.getInstance();
      try {
         cal.setTime(dt.getCal().getTime());
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    *
    * This method serves as a constructor for the class.
    *
    * @param year
    * @param month
    * @param day
    */
   public DateTime(final int year, final int month, final int day) {

      cal = Calendar.getInstance();
      try {
         cal.set(year, month, day);
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    *
    * This method serves as a constructor for the class.
    *
    * @param ms
    *           Milliseconds
    */
   public DateTime(final long ms) {

      cal = Calendar.getInstance();
      try {
         cal.setTimeInMillis(ms);
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * This method serves as a constructor for the class.
    *
    * @param trim
    * @param string
    */
   public DateTime(String value, String fmt) {

      cal = Calendar.getInstance();
      try {
         sdf = new SimpleDateFormat(fmt);
         final Date d = sdf.parse(value);
         cal.setTime(d);
      } catch (final Exception e) {
         e.printStackTrace();
         this.cal = null;
      }
   }

   /**
    * 
    * @return
    */
   public boolean isValid() {

      if (this.cal == null) {
         return false;
      }
      return true;
   }

   /**
    *
    * net.ajaskey.market.misc.add
    *
    * @param unit
    *           DATE|MONTH|YEAR
    * @param knt
    *           Any integer
    */
   public void add(final int unit, final int knt) {

      try {
         if (unit == DateTime.DATE || unit == DateTime.MONTH || unit == DateTime.YEAR) {
            cal.add(unit, knt);
         }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   /**
    *
    * net.ajaskey.market.misc.copy
    *
    * @param dt
    *           Instantiated DateTime variable
    * @return
    */
   public DateTime copy(final DateTime dt) {

      try {
         final DateTime d = new DateTime(dt.cal.getTime());
         return d;
      } catch (final Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   /**
    *
    * net.ajaskey.market.misc.format
    *
    * @return
    */
   public String format() {

      String ret = "";
      try {
         ret = sdf.format(cal.getTime());
      } catch (final Exception e) {
         e.printStackTrace();
         ret = "BAD-DATE-FORMAT";
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.format
    *
    * @param fmt
    * @return
    */
   public String format(final String fmt) {

      String ret = "";
      try {
         final SimpleDateFormat sdf = new SimpleDateFormat(fmt);
         ret = sdf.format(cal.getTime());
      } catch (final Exception e) {
         e.printStackTrace();
         ret = "BAD-DATE-FORMAT";
      }
      return ret;
   }

   /**
    * @return the cal
    */
   public Calendar getCal() {

      return cal;
   }

   /**
    *
    * net.ajaskey.market.misc.getDay
    *
    * @return
    */
   public String getDay() {

      String ret = "UNKNOWN";
      if (cal != null) {
         ret = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.getDayOfMonth
    *
    * @return
    */
   public int getDayOfMonth() {

      int ret = -1;
      if (cal != null) {
         ret = cal.get(Calendar.DAY_OF_MONTH);
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.getDayOfWeek
    *
    * @return
    */
   public int getDayOfWeek() {

      int ret = -1;
      if (cal != null) {
         ret = cal.get(Calendar.DAY_OF_WEEK);
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.getDayOfYear
    *
    * @return
    */
   public int getDayOfYear() {

      int ret = -1;
      if (cal != null) {
         ret = cal.get(Calendar.DAY_OF_YEAR);
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.getMonth
    *
    * @return
    */
   public String getMonth() {

      String ret = "UNKNOWN";
      if (cal != null) {
         ret = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.getSdf
    *
    * @return
    */
   public SimpleDateFormat getSdf() {

      return sdf;
   }

   /**
    *
    * net.ajaskey.market.misc.getYear
    *
    * @return
    */
   public int getYear() {

      int ret = -1;
      if (cal != null) {
         ret = cal.get(Calendar.YEAR);
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.isEqual
    *
    * @param dt
    * @return
    */
   public boolean isEqual(final DateTime dt) {

      try {
         return Utils.sameDate(dt.cal, cal);
      } catch (final Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   /**
    *
    * net.ajaskey.market.misc.isGreaterThan
    *
    * @param dt
    * @return
    */
   public boolean isGreaterThan(final DateTime dt) {

      try {
         return dt.cal.before(cal);
      } catch (final Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   /**
    *
    * net.ajaskey.market.misc.isGreaterThanOrEqual
    *
    * @param dt
    * @return
    */
   public boolean isGreaterThanOrEqual(final DateTime dt) {

      try {
         return isGreaterThan(dt) || isEqual(dt);
      } catch (final Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   /**
    *
    * net.ajaskey.market.misc.isLessThan
    *
    * @param dt
    * @return
    */
   public boolean isLessThan(final DateTime dt) {

      boolean ret = false;
      try {
         ret = dt.cal.after(cal);
      } catch (final Exception e) {
         e.printStackTrace();
         return false;
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.isLessThanOrEqual
    *
    * @param dt
    * @return
    */
   public boolean isLessThanOrEqual(final DateTime dt) {

      try {
         return isLessThan(dt) || isEqual(dt);
      } catch (final Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   /**
    *
    * net.ajaskey.market.misc.isWeekday
    *
    * @return
    */
   public boolean isWeekday() {

      final int d = cal.get(Calendar.DAY_OF_WEEK);
      return d > DateTime.SUNDAY && d < DateTime.SATURDAY;
   }

   /**
    *
    * net.ajaskey.market.misc.parse
    *
    * @param src
    * @return
    */
   public DateTime parse(final String src) {

      DateTime ret = null;
      try {
         final Date d = sdf.parse(src);
         ret = new DateTime(d);
      } catch (final Exception e) {
         e.printStackTrace();
         ret = null;
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.parse
    *
    * @param src
    * @param fmt
    * @return
    */
   public DateTime parse(final String src, final String fmt) {

      DateTime ret = new DateTime();
      try {
         final SimpleDateFormat sdf = new SimpleDateFormat(fmt);
         final Date d = sdf.parse(src);
         ret = new DateTime(d);
      } catch (final Exception e) {
         e.printStackTrace();
         ret = null;
      }
      return ret;
   }

   /**
    *
    * net.ajaskey.market.misc.set
    *
    * @param c
    */
   public void set(final Calendar c) {

      if (c != null) {
         if (cal == null) {
            cal = Calendar.getInstance();
         }
         cal.setTime(c.getTime());
      }
   }

   /**
    *
    * net.ajaskey.market.misc.set
    *
    * @param d
    */
   public void set(final Date d) {

      if (d != null) {
         if (cal == null) {
            cal = Calendar.getInstance();
         }
         cal.setTime(d);
      }
   }

   /**
    *
    * net.ajaskey.market.misc.set
    *
    * @param dt
    */
   public void set(final DateTime dt) {

      if (dt != null && dt.cal != null) {
         if (cal == null) {
            cal = Calendar.getInstance();
         }
         cal.setTime(dt.cal.getTime());
      }
   }

   /**
    *
    * net.ajaskey.market.misc.set
    *
    * @param year
    * @param month
    * @param day
    */
   public void set(final int year, final int month, final int day) {

      if (cal == null) {
         cal = Calendar.getInstance();
      }
      cal.set(year, month, day);

   }

   /**
    *
    * net.ajaskey.market.misc.setSdf
    *
    * @param simpledateformat
    */
   public void setSdf(final SimpleDateFormat simpledateformat) {

      sdf = simpledateformat;
   }

   /**
    *
    * net.ajaskey.market.misc.toFullString
    *
    * @return
    */
   public String toFullString() {

      return Utils.sdfFull.format(cal.getTime());
   }

   /*
    * (non-Javadoc)
    *
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {

      if (sdf == null) {
         setSdf(Utils.sdf);
      }
      return sdf.format(cal.getTime());
   }

}
