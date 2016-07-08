package net.ajaskey.market.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

  public static boolean debug = false;

  @Test
  public void test001() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test001"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d3 = tickerData0.getOpen((int)(short)0);

  }

  @Test
  public void test002() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test002"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d4 = tickerData0.getHigh((int)(byte)100);

  }

  @Test
  public void test003() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test003"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getLow((int)(short)1);

  }

  @Test
  public void test004() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test004"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getVolume((int)(short)10);

  }

  @Test
  public void test005() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test005"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d3 = tickerData0.getClose((int)(byte)1);

  }

  @Test
  public void test006() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test006"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar3 = tickerData0.getDate((int)(short)0);

  }

  @Test
  public void test007() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test007"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str13 = tickerData0.getDailyDataString((int)(byte)(-1));

  }

  @Test
  public void test008() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test008"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getVolume((int)'a');

  }

  @Test
  public void test009() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test009"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getAtrPercent23();
    java.lang.String str3 = tickerData0.getTickerName();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getClose((int)'4');

  }

  @Test
  public void test010() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test010"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    net.ajaskey.market.ta.input.Fundamentals fundamentals3 = tickerData0.getFundies();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getLow(0);

  }

  @Test
  public void test011() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test011"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("30-Jan-0001");

  }

  @Test
  public void test012() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test012"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    java.lang.String str7 = tickerData0.toString();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getOi((int)(short)1);

  }

  @Test
  public void test013() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test013"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getOpen((int)(byte)0);

  }

  @Test
  public void test014() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test014"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("NotFound", (int)'a');

  }

  @Test
  public void test015() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test015"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808652183,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=817,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)0);

  }

  @Test
  public void test016() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test016"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLow260();
    double d8 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getHigh((int)(byte)(-1));

  }

  @Test
  public void test017() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test017"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getHigh((int)(short)1);

  }

  @Test
  public void test018() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test018"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    tickerData0.setTicker("NotFound");
    double[] d_array4 = tickerData0.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar6 = tickerData0.getDate((int)(short)0);

  }

  @Test
  public void test019() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test019"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getLow((-1));

  }

  @Test
  public void test020() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test020"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d3 = tickerData0.getHigh((int)(short)0);

  }

  @Test
  public void test021() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test021"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d4 = tickerData0.getOpen(0);

  }

  @Test
  public void test022() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test022"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    double d6 = tickerData0.getDiPlus();
    java.lang.Integer i7 = tickerData0.getDaysOfData();
    double d8 = tickerData0.getMfi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOpen((int)(byte)100);

  }

  @Test
  public void test023() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test023"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    net.ajaskey.market.ta.TickerData tickerData6 = new net.ajaskey.market.ta.TickerData();
    double[] d_array7 = tickerData6.getTrueLowData();
    java.util.Calendar calendar11 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str12 = net.ajaskey.market.misc.Utils.stringDate(calendar11);
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate2(calendar11);
    net.ajaskey.market.ta.DailyData dailyData14 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData6, calendar11);
    double d15 = tickerData6.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType16 = tickerData6.getSma130Trend();
    double[] d_array17 = tickerData6.getVolumeData();
    int i21 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData6, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate2(calendar26);
    net.ajaskey.market.ta.TickerData tickerData35 = new net.ajaskey.market.ta.TickerData("hi!", calendar26, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData36 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData6, calendar26);
    java.util.Calendar calendar40 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str41 = net.ajaskey.market.misc.Utils.stringDate(calendar40);
    net.ajaskey.market.ta.DailyData dailyData48 = new net.ajaskey.market.ta.DailyData(calendar40, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str49 = net.ajaskey.market.misc.Utils.stringDate2(calendar40);
    long long50 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar26, calendar40);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData52 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar40, (int)(short)1);

  }

  @Test
  public void test024() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test024"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("HI!");

  }

  @Test
  public void test025() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test025"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar13 = tickerData0.getDate((int)'4');

  }

  @Test
  public void test026() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test026"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d4 = tickerData0.getLow(1);

  }

  @Test
  public void test027() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test027"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getOpen((-1));

  }

  @Test
  public void test028() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test028"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getOi((int)'4');

  }

  @Test
  public void test029() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test029"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getAtrPercent23();
    java.lang.String str3 = tickerData0.getTickerName();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getOi((int)(short)0);

  }

  @Test
  public void test030() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test030"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double[] d_array13 = tickerData0.getTrueHighData();
    net.ajaskey.market.ta.TrendType trendType14 = tickerData0.getSma65Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getOi((int)(short)100);

  }

  @Test
  public void test031() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test031"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double d9 = tickerData0.getAtr23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate(calendar18);
    java.lang.String str20 = net.ajaskey.market.misc.Utils.stringDate2(calendar18);
    boolean b21 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar18);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData23 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar18, (int)(short)100);

  }

  @Test
  public void test032() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test032"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData13.getOi(1);

  }

  @Test
  public void test033() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test033"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    java.lang.String str13 = tickerData0.toString();
    double d14 = tickerData0.getMfi23();
    double d15 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData0.getVolume((int)'#');

  }

  @Test
  public void test034() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test034"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    double d6 = tickerData0.getDiPlus();
    java.lang.Integer i7 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getOi(0);

  }

  @Test
  public void test035() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test035"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData0.getOi((int)'4');

  }

  @Test
  public void test036() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test036"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("Unknown");

  }

  @Test
  public void test037() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test037"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    double[] d_array10 = tickerData0.getTypicalPriceData();
    double[] d_array11 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar13 = tickerData0.getDate((int)(short)1);

  }

  @Test
  public void test038() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test038"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    double d6 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar8 = tickerData0.getDate((-1));

  }

  @Test
  public void test039() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test039"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808648093,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=907,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test040() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test040"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double[] d_array26 = tickerData0.getHighData();
    double d27 = tickerData0.getMfi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str29 = tickerData0.getDailyDataString((int)'4');

  }

  @Test
  public void test041() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test041"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808651540,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=460,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test042() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test042"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    java.lang.String str10 = tickerData0.getTickerExchange();
    double d11 = tickerData0.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getVolume((int)' ');

  }

  @Test
  public void test043() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test043"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    java.util.Calendar calendar29 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str30 = net.ajaskey.market.misc.Utils.stringDate(calendar29);
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate2(calendar29);
    net.ajaskey.market.ta.DailyData dailyData32 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar29);
    net.ajaskey.market.ta.DailyData dailyData36 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)(byte)(-1), (int)(short)1, (int)' ');
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str38 = tickerData0.getDailyDataString((int)'4');

  }

  @Test
  public void test044() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test044"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getMfi65();
    double d12 = tickerData0.getAtr23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getHigh((int)(short)1);

  }

  @Test
  public void test045() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test045"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    java.lang.Double d3 = tickerData0.getSmaPerc23();
    double d4 = tickerData0.getChg130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getOpen((-1));

  }

  @Test
  public void test046() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test046"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double[] d_array10 = tickerData0.getOpenData();
    double[] d_array11 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getLow((int)(short)100);

  }

  @Test
  public void test047() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test047"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808648436,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=564,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test048() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test048"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getChg130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getVolume((int)(byte)0);

  }

  @Test
  public void test049() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test049"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma260Trend();
    double d9 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str11 = tickerData0.getDailyDataString(0);

  }

  @Test
  public void test050() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test050"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getClose((int)(short)0);

  }

  @Test
  public void test051() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test051"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getRsStRaw();
    double[] d_array13 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getLow((-1));

  }

  @Test
  public void test052() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test052"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d3 = tickerData0.getVolume((int)'4');

  }

  @Test
  public void test053() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test053"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getChg23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getLow((-1));

  }

  @Test
  public void test054() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test054"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double[] d_array3 = tickerData0.getTrueHighData();
    java.lang.String str4 = tickerData0.getTicker();
    double d5 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getLow((int)(short)0);

  }

  @Test
  public void test055() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test055"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getLow((int)(byte)100);

  }

  @Test
  public void test056() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test056"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    java.lang.String str12 = tickerData0.getTicker();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getVolume((int)(byte)1);

  }

  @Test
  public void test057() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test057"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    java.lang.Double d9 = tickerData0.getSmaPerc23();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate2(calendar14);
    net.ajaskey.market.ta.TickerData tickerData23 = new net.ajaskey.market.ta.TickerData("hi!", calendar14, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar24 = net.ajaskey.market.misc.Utils.makeCopy(calendar14);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData26 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar24, (int)'4');

  }

  @Test
  public void test058() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test058"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double[] d_array14 = tickerData13.getTypicalPriceData();
    double d15 = tickerData13.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData13.getLow((int)'a');

  }

  @Test
  public void test059() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test059"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808645097,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=54,MILLISECOND=903,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test060() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test060"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double[] d_array10 = tickerData0.getOpenData();
    double[] d_array11 = tickerData0.getTrueHighData();
    tickerData0.setTickerExchange("unknown-month");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getOi((int)(byte)10);

  }

  @Test
  public void test061() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test061"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.methods.TaMethods taMethods8 = tickerData0.getTaMethods();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    net.ajaskey.market.ta.TrendType trendType11 = tickerData0.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getOpen((int)(short)10);

  }

  @Test
  public void test062() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test062"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getLowData();
    double d3 = tickerData0.getPriceOffLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getLow((int)(byte)0);

  }

  @Test
  public void test063() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test063"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getClose((int)(byte)1);

  }

  @Test
  public void test064() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test064"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)100);

  }

  @Test
  public void test065() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test065"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.Double d9 = tickerData0.getSmaPerc260();
    double d10 = tickerData0.getAvgVol20();
    double[] d_array11 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str13 = tickerData0.getDailyDataString(0);

  }

  @Test
  public void test066() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test066"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getHigh((int)(byte)10);

  }

  @Test
  public void test067() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test067"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma23Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getLow((int)(short)100);

  }

  @Test
  public void test068() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test068"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    double d14 = tickerData13.getChg23();
    double d15 = tickerData13.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData13.getLow(0);

  }

  @Test
  public void test069() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test069"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar11 = tickerData0.getDate((int)(short)10);

  }

  @Test
  public void test070() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test070"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double d7 = tickerData0.getRsi14();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getHigh(0);

  }

  @Test
  public void test071() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test071"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    java.lang.Double d8 = tickerData0.getSma130();
    net.ajaskey.market.ta.TickerData tickerData9 = new net.ajaskey.market.ta.TickerData();
    double[] d_array10 = tickerData9.getVolumeData();
    double d11 = tickerData9.getChg65();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d16 = tickerData9.getLow260();
    double d17 = tickerData9.getDiMinus();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData9);
    net.ajaskey.market.ta.DailyData dailyData22 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)(byte)(-1), 0, (int)' ');
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d24 = tickerData0.getLow((int)(short)100);

  }

  @Test
  public void test072() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test072"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getMfi14();
    double[] d_array11 = tickerData0.getTrueLowData();
    double d12 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOpen((int)(byte)0);

  }

  @Test
  public void test073() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test073"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSmaPerc65();
    double[] d_array5 = tickerData0.getOpenData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getOpen((int)(short)(-1));

  }

  @Test
  public void test074() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test074"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808649169,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=831,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)100);

  }

  @Test
  public void test075() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test075"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma23Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar12 = tickerData0.getDate((int)(byte)10);

  }

  @Test
  public void test076() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test076"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    java.lang.String str7 = tickerData0.toString();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getHigh((int)(short)10);

  }

  @Test
  public void test077() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test077"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    net.ajaskey.market.ta.methods.TaMethods taMethods7 = tickerData0.getTaMethods();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getLow((int)(short)100);

  }

  @Test
  public void test078() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test078"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808649263,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=737,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)0);

  }

  @Test
  public void test079() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test079"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    double[] d_array16 = tickerData0.getTrueHighData();
    double d17 = tickerData0.getLrInt260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d19 = tickerData0.getHigh(10);

  }

  @Test
  public void test080() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test080"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808645877,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=54,MILLISECOND=123,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test081() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test081"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.Double d14 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getOi((int)(byte)10);

  }

  @Test
  public void test082() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test082"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getAtrPercent23();
    java.lang.String str3 = tickerData0.getTickerName();
    java.lang.Double d4 = tickerData0.getSmaPerc65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getHigh(0);

  }

  @Test
  public void test083() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test083"); }


    net.ajaskey.market.ta.TickerData tickerData1 = new net.ajaskey.market.ta.TickerData();
    double[] d_array2 = tickerData1.getTrueLowData();
    java.util.Calendar calendar6 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate(calendar6);
    java.lang.String str8 = net.ajaskey.market.misc.Utils.stringDate2(calendar6);
    net.ajaskey.market.ta.DailyData dailyData9 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar6);
    double d10 = tickerData1.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType11 = tickerData1.getSma130Trend();
    double[] d_array12 = tickerData1.getVolumeData();
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData1, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.TickerData tickerData30 = new net.ajaskey.market.ta.TickerData("hi!", calendar21, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData31 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar21);
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    net.ajaskey.market.ta.DailyData dailyData43 = new net.ajaskey.market.ta.DailyData(calendar35, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    long long45 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar21, calendar35);
    net.ajaskey.market.ta.TickerData tickerData52 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650214,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar21, (double)(byte)0, (double)1, (double)100, (double)'4', (double)10L, (double)1.0f);
    java.lang.String str53 = tickerData52.getTickerExchange();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d55 = tickerData52.getLow(0);

  }

  @Test
  public void test084() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test084"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    java.lang.Double d8 = tickerData0.getSma260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOpen((int)(short)(-1));

  }

  @Test
  public void test085() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test085"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getLow((int)'4');

  }

  @Test
  public void test086() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test086"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getOi((int)'a');

  }

  @Test
  public void test087() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test087"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    double[] d_array9 = tickerData0.getOiData();
    double d10 = tickerData0.getMfi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar12 = tickerData0.getDate((int)' ');

  }

  @Test
  public void test088() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test088"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    net.ajaskey.market.ta.TrendType trendType1 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str3 = tickerData0.getDailyDataString((int)'#');

  }

  @Test
  public void test089() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test089"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("", (int)(byte)(-1));

  }

  @Test
  public void test090() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test090"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    java.lang.Double d10 = tickerData0.getSmaPerc130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getHigh((int)(byte)(-1));

  }

  @Test
  public void test091() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test091"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double d14 = tickerData13.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData13.getOpen((int)'#');

  }

  @Test
  public void test092() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test092"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar6 = tickerData0.getDate((int)(byte)1);

  }

  @Test
  public void test093() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test093"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double d3 = tickerData0.getAtr23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar5 = tickerData0.getDate((int)(short)100);

  }

  @Test
  public void test094() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test094"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar7 = tickerData0.getDate((int)' ');

  }

  @Test
  public void test095() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test095"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData8.getOi(1);

  }

  @Test
  public void test096() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test096"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getAdx();
    java.lang.Double d9 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str11 = tickerData0.getDailyDataString((int)(short)100);

  }

  @Test
  public void test097() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test097"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    double d8 = tickerData0.getRsRaw();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getClose((int)(short)1);

  }

  @Test
  public void test098() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test098"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getLowData();
    double d3 = tickerData0.getAtrPercent23();
    double d4 = tickerData0.getPriceOffHigh260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getHigh((int)(byte)100);

  }

  @Test
  public void test099() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test099"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    double[] d_array7 = tickerData0.getOpenData();
    tickerData0.setTickerExchange("NotFound");
    double[] d_array10 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getClose((int)' ');

  }

  @Test
  public void test100() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test100"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData0.getLr260();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808645097,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=54,MILLISECOND=903,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getOpen((int)' ');

  }

  @Test
  public void test101() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test101"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    java.lang.Double d8 = tickerData0.getSma130();
    net.ajaskey.market.ta.TickerData tickerData9 = new net.ajaskey.market.ta.TickerData();
    double[] d_array10 = tickerData9.getVolumeData();
    double d11 = tickerData9.getChg65();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d16 = tickerData9.getLow260();
    double d17 = tickerData9.getDiMinus();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData9);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, false);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d24 = tickerData0.getClose((-1));

  }

  @Test
  public void test102() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test102"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData0.getLr260();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808645097,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=54,MILLISECOND=903,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getClose((int)(byte)1);

  }

  @Test
  public void test103() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test103"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808649029,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=971,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test104() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test104"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    java.lang.String str12 = tickerData0.getTicker();
    double d13 = tickerData0.getPriceOffLow260();
    double d14 = tickerData0.getAvgVol20();
    double d15 = tickerData0.getAvgVol20();
    java.lang.Double d16 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar18 = tickerData0.getDate(10);

  }

  @Test
  public void test105() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test105"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)' ');

  }

  @Test
  public void test106() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test106"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808642568,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=57,MILLISECOND=432,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 1);

  }

  @Test
  public void test107() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test107"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getAdx();
    java.lang.Double d9 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getOpen((-1));

  }

  @Test
  public void test108() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test108"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("30-Jan-0001", (-1));

  }

  @Test
  public void test109() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test109"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808646330,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=53,MILLISECOND=670,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)10);

  }

  @Test
  public void test110() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test110"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    double d9 = tickerData0.getChg260();
    net.ajaskey.market.ta.TickerData tickerData10 = new net.ajaskey.market.ta.TickerData();
    double[] d_array11 = tickerData10.getTrueLowData();
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    net.ajaskey.market.ta.DailyData dailyData18 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar15);
    double d19 = tickerData10.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType20 = tickerData10.getSma130Trend();
    double[] d_array21 = tickerData10.getVolumeData();
    int i25 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData10, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar30 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate(calendar30);
    java.lang.String str32 = net.ajaskey.market.misc.Utils.stringDate2(calendar30);
    net.ajaskey.market.ta.TickerData tickerData39 = new net.ajaskey.market.ta.TickerData("hi!", calendar30, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData40 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar30);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    net.ajaskey.market.ta.DailyData dailyData52 = new net.ajaskey.market.ta.DailyData(calendar44, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str53 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    long long54 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar30, calendar44);
    java.util.Calendar calendar58 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar62 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str63 = net.ajaskey.market.misc.Utils.stringDate(calendar62);
    java.lang.String str64 = net.ajaskey.market.misc.Utils.stringDate2(calendar62);
    boolean b65 = net.ajaskey.market.misc.Utils.sameYear(calendar58, calendar62);
    java.lang.String str66 = net.ajaskey.market.misc.Utils.getString(calendar62);
    boolean b67 = net.ajaskey.market.misc.Utils.sameYear(calendar44, calendar62);
    net.ajaskey.market.ta.DailyData dailyData68 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar44);
    double[] d_array69 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d71 = tickerData0.getOi(10);

  }

  @Test
  public void test111() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test111"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.lang.Double d6 = tickerData0.getSma65();
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma260Trend();
    double d8 = tickerData0.getPriceOffHigh260();
    double[] d_array9 = tickerData0.getVolumeData();
    double d10 = tickerData0.getPriceOffLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getOi((int)(short)(-1));

  }

  @Test
  public void test112() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test112"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSmaPerc65();
    double[] d_array5 = tickerData0.getOpenData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getVolume((int)'#');

  }

  @Test
  public void test113() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test113"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getLow((int)(byte)(-1));

  }

  @Test
  public void test114() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test114"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double[] d_array14 = tickerData11.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData11.getOpen(10);

  }

  @Test
  public void test115() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test115"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    java.lang.Integer i7 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getOpen((int)' ');

  }

  @Test
  public void test116() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test116"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    net.ajaskey.market.ta.DailyData dailyData17 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData13, (int)(byte)10, (-1), (int)(byte)10);
    net.ajaskey.market.ta.input.Fundamentals fundamentals18 = tickerData13.getFundies();
    net.ajaskey.market.ta.TrendType trendType19 = tickerData13.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d21 = tickerData13.getVolume(10);

  }

  @Test
  public void test117() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test117"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    net.ajaskey.market.ta.methods.TaMethods taMethods4 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)(short)(-1), (int)'#', (int)'#');
    double d9 = tickerData0.getAtrPercent23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar11 = tickerData0.getDate((int)'#');

  }

  @Test
  public void test118() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test118"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    java.lang.Double d10 = tickerData0.getSmaPerc130();
    net.ajaskey.market.ta.input.Fundamentals fundamentals11 = tickerData0.getFundies();
    net.ajaskey.market.ta.input.Fundamentals fundamentals12 = tickerData0.getFundies();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getClose((int)(short)1);

  }

  @Test
  public void test119() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test119"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.methods.TaMethods taMethods8 = tickerData0.getTaMethods();
    double d9 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getClose((-1));

  }

  @Test
  public void test120() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test120"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    tickerData0.fillDataArrays((int)(byte)0, true);
    java.lang.String str8 = tickerData0.toString();
    double d9 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume(0);

  }

  @Test
  public void test121() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test121"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    java.lang.Double d3 = tickerData0.getSmaPerc23();
    java.lang.Double d4 = tickerData0.getSmaPerc130();
    double d5 = tickerData0.getAvgVol65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getHigh((int)(byte)0);

  }

  @Test
  public void test122() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test122"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808650526,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=474,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 1);

  }

  @Test
  public void test123() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test123"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test124() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test124"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    tickerData0.setTicker("NotFound");
    double[] d_array4 = tickerData0.getTrueLowData();
    double[] d_array5 = tickerData0.getLowData();
    java.util.Calendar calendar10 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str11 = net.ajaskey.market.misc.Utils.stringDate(calendar10);
    java.lang.String str12 = net.ajaskey.market.misc.Utils.stringDate2(calendar10);
    net.ajaskey.market.ta.TickerData tickerData19 = new net.ajaskey.market.ta.TickerData("hi!", calendar10, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData21 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar10, (int)(byte)1);

  }

  @Test
  public void test125() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test125"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808651306,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=694,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test126() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test126"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData11.getRsi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar16 = tickerData11.getDate((int)(short)0);

  }

  @Test
  public void test127() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test127"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.methods.TaMethods taMethods14 = tickerData13.getTaMethods();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData13.getLow(1);

  }

  @Test
  public void test128() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test128"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    java.lang.Double d14 = tickerData0.getSmaPerc260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getLow((-1));

  }

  @Test
  public void test129() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test129"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double d26 = tickerData0.getMfi23();
    double d27 = tickerData0.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d29 = tickerData0.getLow((int)(byte)(-1));

  }

  @Test
  public void test130() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test130"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str10 = tickerData0.getDailyDataString((int)'#');

  }

  @Test
  public void test131() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test131"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    java.lang.Double d9 = tickerData0.getSma23();
    net.ajaskey.market.ta.methods.TaMethods taMethods10 = tickerData0.getTaMethods();
    double[] d_array11 = tickerData0.getHighData();
    double d12 = tickerData0.getRsRaw();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getHigh(0);

  }

  @Test
  public void test132() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test132"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str14 = tickerData13.getTickerExchange();
    double d15 = tickerData13.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData13.getLow((int)'a');

  }

  @Test
  public void test133() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test133"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808640442,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=59,MILLISECOND=558,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test134() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test134"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.TickerData tickerData29 = new net.ajaskey.market.ta.TickerData("hi!", calendar20, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData30 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str32 = tickerData0.getDailyDataString((int)'4');

  }

  @Test
  public void test135() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test135"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    java.lang.Double d8 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOi((int)(short)100);

  }

  @Test
  public void test136() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test136"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    double d9 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getOpen((int)(short)1);

  }

  @Test
  public void test137() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test137"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("", (-1));

  }

  @Test
  public void test138() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test138"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("");

  }

  @Test
  public void test139() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test139"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getLow((int)(byte)(-1));

  }

  @Test
  public void test140() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test140"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getMfi14();
    double[] d_array11 = tickerData0.getTrueLowData();
    double d12 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar14 = tickerData0.getDate((-1));

  }

  @Test
  public void test141() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test141"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    tickerData0.setTicker("NotFound");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str10 = tickerData0.getDailyDataString(0);

  }

  @Test
  public void test142() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test142"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    net.ajaskey.market.ta.TrendType trendType1 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d3 = tickerData0.getClose((int)'#');

  }

  @Test
  public void test143() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test143"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    double[] d_array14 = tickerData8.getTypicalPriceData();
    tickerData8.setTickerExchange("java.util.GregorianCalendar[time=-62164808649013,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=987,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d17 = tickerData8.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d19 = tickerData8.getLow((int)(short)100);

  }

  @Test
  public void test144() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test144"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getLow((int)(short)10);

  }

  @Test
  public void test145() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test145"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double[] d_array14 = tickerData13.getTypicalPriceData();
    double d15 = tickerData13.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData13.getLow((int)(short)0);

  }

  @Test
  public void test146() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test146"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getClose((int)(short)100);

  }

  @Test
  public void test147() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test147"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getOpen((int)'#');

  }

  @Test
  public void test148() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test148"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    net.ajaskey.market.ta.methods.TaMethods taMethods7 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.input.Fundamentals fundamentals8 = tickerData0.getFundies();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getVolume((int)(short)(-1));

  }

  @Test
  public void test149() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test149"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getAvgVol20();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str6 = tickerData0.getDailyDataString((int)(short)0);

  }

  @Test
  public void test150() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test150"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double d3 = tickerData0.getAtr23();
    double d4 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getHigh((int)(short)100);

  }

  @Test
  public void test151() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test151"); }


    net.ajaskey.market.ta.TickerData tickerData1 = new net.ajaskey.market.ta.TickerData();
    double[] d_array2 = tickerData1.getTrueLowData();
    java.util.Calendar calendar6 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate(calendar6);
    java.lang.String str8 = net.ajaskey.market.misc.Utils.stringDate2(calendar6);
    net.ajaskey.market.ta.DailyData dailyData9 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar6);
    double d10 = tickerData1.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType11 = tickerData1.getSma130Trend();
    double[] d_array12 = tickerData1.getVolumeData();
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData1, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.TickerData tickerData30 = new net.ajaskey.market.ta.TickerData("hi!", calendar21, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData31 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar21);
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    net.ajaskey.market.ta.DailyData dailyData43 = new net.ajaskey.market.ta.DailyData(calendar35, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    long long45 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar21, calendar35);
    net.ajaskey.market.ta.TickerData tickerData52 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650214,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar21, (double)(byte)0, (double)1, (double)100, (double)'4', (double)10L, (double)1.0f);
    java.lang.String str53 = tickerData52.getTickerExchange();
    java.lang.Double d54 = tickerData52.getSmaPerc260();
    net.ajaskey.market.ta.TrendType trendType55 = tickerData52.getSma23Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d57 = tickerData52.getLow(100);

  }

  @Test
  public void test152() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test152"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getMfi130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getHigh((int)' ');

  }

  @Test
  public void test153() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test153"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getOi((int)(byte)(-1));

  }

  @Test
  public void test154() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test154"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    double[] d_array9 = tickerData0.getOiData();
    double d10 = tickerData0.getMfi14();
    double d11 = tickerData0.getDiMinus();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, false);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getHigh((-1));

  }

  @Test
  public void test155() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test155"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double d7 = tickerData0.getRsi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar9 = tickerData0.getDate((int)'4');

  }

  @Test
  public void test156() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test156"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    java.lang.String str8 = tickerData0.getTickerName();
    double d9 = tickerData0.getDiPlus();
    java.lang.Double d10 = tickerData0.getSmaPerc260();
    double d11 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getOpen(1);

  }

  @Test
  public void test157() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test157"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLrInt260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar9 = tickerData0.getDate((int)(byte)10);

  }

  @Test
  public void test158() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test158"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.methods.TaMethods taMethods8 = tickerData0.getTaMethods();
    double d9 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)' ');

  }

  @Test
  public void test159() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test159"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double d26 = tickerData0.getMfi23();
    double d27 = tickerData0.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d29 = tickerData0.getOi((int)' ');

  }

  @Test
  public void test160() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test160"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    double d5 = tickerData0.getLrAngle260();
    java.lang.Double d6 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getOpen((int)(byte)0);

  }

  @Test
  public void test161() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test161"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    java.lang.Double d10 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getHigh((int)(byte)1);

  }

  @Test
  public void test162() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test162"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808636975,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=3,MILLISECOND=25,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test163() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test163"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg23();
    double d3 = tickerData0.getChg();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getOi((int)(byte)0);

  }

  @Test
  public void test164() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test164"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808647188,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=52,MILLISECOND=812,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)0);

  }

  @Test
  public void test165() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test165"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double d10 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getVolume((int)(byte)(-1));

  }

  @Test
  public void test166() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test166"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getAvgVol20();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getOi((-100));

  }

  @Test
  public void test167() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test167"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    java.lang.Double d9 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str11 = tickerData0.getDailyDataString((int)'#');

  }

  @Test
  public void test168() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test168"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    net.ajaskey.market.ta.DailyData dailyData20 = new net.ajaskey.market.ta.DailyData(calendar12, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar21 = dailyData20.getDate();
    tickerData0.addData(dailyData20);
    double d23 = tickerData0.getChg23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d25 = tickerData0.getHigh((int)(short)100);

  }

  @Test
  public void test169() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test169"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    double d9 = tickerData0.getChg260();
    net.ajaskey.market.ta.TickerData tickerData10 = new net.ajaskey.market.ta.TickerData();
    double[] d_array11 = tickerData10.getTrueLowData();
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    net.ajaskey.market.ta.DailyData dailyData18 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar15);
    double d19 = tickerData10.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType20 = tickerData10.getSma130Trend();
    double[] d_array21 = tickerData10.getVolumeData();
    int i25 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData10, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar30 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate(calendar30);
    java.lang.String str32 = net.ajaskey.market.misc.Utils.stringDate2(calendar30);
    net.ajaskey.market.ta.TickerData tickerData39 = new net.ajaskey.market.ta.TickerData("hi!", calendar30, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData40 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar30);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    net.ajaskey.market.ta.DailyData dailyData52 = new net.ajaskey.market.ta.DailyData(calendar44, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str53 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    long long54 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar30, calendar44);
    java.util.Calendar calendar58 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar62 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str63 = net.ajaskey.market.misc.Utils.stringDate(calendar62);
    java.lang.String str64 = net.ajaskey.market.misc.Utils.stringDate2(calendar62);
    boolean b65 = net.ajaskey.market.misc.Utils.sameYear(calendar58, calendar62);
    java.lang.String str66 = net.ajaskey.market.misc.Utils.getString(calendar62);
    boolean b67 = net.ajaskey.market.misc.Utils.sameYear(calendar44, calendar62);
    net.ajaskey.market.ta.DailyData dailyData68 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar44);
    java.lang.Integer i69 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d71 = tickerData0.getVolume((int)(short)1);

  }

  @Test
  public void test170() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test170"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getAvgVol20();
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getLow(0);

  }

  @Test
  public void test171() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test171"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getPriceOffLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getOi(0);

  }

  @Test
  public void test172() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test172"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getMfi14();
    double[] d_array11 = tickerData0.getTrueLowData();
    double d12 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOpen((int)'a');

  }

  @Test
  public void test173() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test173"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    double d9 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getOpen((-100));

  }

  @Test
  public void test174() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test174"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double[] d_array9 = tickerData0.getOiData();
    double[] d_array10 = tickerData0.getOiData();
    double d11 = tickerData0.getMfi23();
    double[] d_array12 = tickerData0.getOiData();
    double d13 = tickerData0.getAdx();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate(calendar17);
    net.ajaskey.market.ta.DailyData dailyData25 = new net.ajaskey.market.ta.DailyData(calendar17, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d26 = dailyData25.getClose();
    double d27 = dailyData25.getDailyPercentChg();
    java.util.Calendar calendar28 = dailyData25.getDate();
    java.util.Calendar calendar32 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.makeCopy(calendar32);
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.makeCopy(calendar32);
    java.util.Calendar calendar39 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str40 = net.ajaskey.market.misc.Utils.stringDate(calendar39);
    java.lang.String str41 = net.ajaskey.market.misc.Utils.stringDate2(calendar39);
    net.ajaskey.market.ta.TickerData tickerData48 = new net.ajaskey.market.ta.TickerData("hi!", calendar39, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar49 = net.ajaskey.market.misc.Utils.makeCopy(calendar39);
    long long50 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar34, calendar39);
    long long51 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar28, calendar34);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData53 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar28, 1);

  }

  @Test
  public void test175() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test175"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double d11 = tickerData0.getLrSlope260();
    double d12 = tickerData0.getLrInt260();
    double[] d_array13 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getVolume((-100));

  }

  @Test
  public void test176() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test176"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    java.lang.String str8 = tickerData0.getTickerName();
    double d9 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getLow((int)(short)0);

  }

  @Test
  public void test177() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test177"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.String str14 = tickerData0.toString();
    net.ajaskey.market.ta.input.Fundamentals fundamentals15 = tickerData0.getFundies();
    double d16 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getVolume(1);

  }

  @Test
  public void test178() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test178"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    net.ajaskey.market.ta.TrendType trendType14 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str18 = tickerData0.getDailyDataString((int)(short)0);

  }

  @Test
  public void test179() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test179"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double[] d_array14 = tickerData13.getTypicalPriceData();
    double d15 = tickerData13.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData13.getHigh(1);

  }

  @Test
  public void test180() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test180"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLow260();
    double d8 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar10 = tickerData0.getDate((int)(byte)100);

  }

  @Test
  public void test181() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test181"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.util.Calendar calendar9 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str10 = net.ajaskey.market.misc.Utils.stringDate(calendar9);
    net.ajaskey.market.ta.DailyData dailyData17 = new net.ajaskey.market.ta.DailyData(calendar9, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d18 = dailyData17.getTrueHigh();
    dailyData17.setTrueHigh((double)(short)0);
    dailyData17.setTrueHigh((double)(byte)(-1));
    tickerData0.addData(dailyData17);
    double d24 = tickerData0.getChg23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d26 = tickerData0.getOpen(0);

  }

  @Test
  public void test182() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test182"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    java.lang.String str13 = tickerData0.toString();
    double d14 = tickerData0.getMfi23();
    double d15 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData0.getVolume((int)(byte)100);

  }

  @Test
  public void test183() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test183"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double[] d_array13 = tickerData0.getTrueHighData();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate(calendar17);
    java.lang.String str19 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar17);
    java.util.Calendar calendar24 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate(calendar24);
    java.lang.String str26 = net.ajaskey.market.misc.Utils.stringDate2(calendar24);
    net.ajaskey.market.ta.TickerData tickerData33 = new net.ajaskey.market.ta.TickerData("hi!", calendar24, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.makeCopy(calendar24);
    boolean b35 = net.ajaskey.market.misc.Utils.sameDate(calendar17, calendar34);
    net.ajaskey.market.ta.DailyData dailyData36 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar34);
    tickerData0.setTicker("Fri");
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    net.ajaskey.market.ta.DailyData dailyData50 = new net.ajaskey.market.ta.DailyData(calendar42, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d51 = dailyData50.getClose();
    double d52 = dailyData50.getTrueLow();
    tickerData0.addData(dailyData50);
    java.lang.String str54 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType55 = tickerData0.getSma23Trend();
    net.ajaskey.market.ta.TickerData tickerData56 = new net.ajaskey.market.ta.TickerData();
    double[] d_array57 = tickerData56.getVolumeData();
    double d58 = tickerData56.getChg65();
    net.ajaskey.market.ta.TrendType trendType59 = tickerData56.getSma23Trend();
    java.lang.Integer i60 = tickerData56.getDaysOfData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals61 = tickerData56.getFundies();
    java.lang.Double d62 = tickerData56.getSmaPerc260();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData56);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d65 = tickerData0.getVolume((int)(byte)1);

  }

  @Test
  public void test184() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test184"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSmaPerc65();
    double[] d_array5 = tickerData0.getOpenData();
    double[] d_array6 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getHigh((int)(short)100);

  }

  @Test
  public void test185() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test185"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double[] d_array10 = tickerData0.getOpenData();
    double[] d_array11 = tickerData0.getTrueHighData();
    tickerData0.setTickerExchange("unknown-month");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getVolume(1);

  }

  @Test
  public void test186() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test186"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    java.util.Calendar calendar29 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str30 = net.ajaskey.market.misc.Utils.stringDate(calendar29);
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate2(calendar29);
    net.ajaskey.market.ta.DailyData dailyData32 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar29);
    net.ajaskey.market.ta.DailyData dailyData36 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)(byte)(-1), (int)(short)1, (int)' ');
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar38 = tickerData0.getDate((int)(short)100);

  }

  @Test
  public void test187() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test187"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str6 = tickerData0.getDailyDataString((int)(short)0);

  }

  @Test
  public void test188() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test188"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    double[] d_array5 = tickerData0.getTrueLowData();
    tickerData0.rSort();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getOpen(10);

  }

  @Test
  public void test189() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test189"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808631828,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=8,MILLISECOND=172,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 0);

  }

  @Test
  public void test190() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test190"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.TickerData tickerData29 = new net.ajaskey.market.ta.TickerData("hi!", calendar20, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData30 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    double[] d_array31 = tickerData0.getOiData();
    java.lang.Double d32 = tickerData0.getSma130();
    java.lang.Double d33 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d35 = tickerData0.getLow((int)(short)1);

  }

  @Test
  public void test191() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test191"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getAdx();
    double d11 = tickerData0.getChg();
    net.ajaskey.market.ta.TrendType trendType12 = tickerData0.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOi((int)(short)(-1));

  }

  @Test
  public void test192() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test192"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808650277,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=723,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)10);

  }

  @Test
  public void test193() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test193"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double d15 = tickerData0.getChg23();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d18 = tickerData0.getChg();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d20 = tickerData0.getClose((-1));

  }

  @Test
  public void test194() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test194"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d4 = tickerData0.getClose((int)(short)0);

  }

  @Test
  public void test195() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test195"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    java.lang.Double d5 = tickerData0.getSmaPerc65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar7 = tickerData0.getDate((int)(byte)100);

  }

  @Test
  public void test196() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test196"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d4 = tickerData0.getOpen((int)(short)100);

  }

  @Test
  public void test197() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test197"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    java.lang.String str8 = tickerData0.getTickerName();
    double d9 = tickerData0.getDiPlus();
    java.lang.Double d10 = tickerData0.getSmaPerc260();
    double d11 = tickerData0.getLr260();
    double d12 = tickerData0.getLrAngle260();
    java.lang.Integer i13 = tickerData0.getDaysOfData();
    double d14 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getClose((int)(byte)1);

  }

  @Test
  public void test198() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test198"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getMfi14();
    double[] d_array11 = tickerData0.getTrueLowData();
    double d12 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOi(100);

  }

  @Test
  public void test199() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test199"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808644926,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=55,MILLISECOND=74,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 0);

  }

  @Test
  public void test200() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test200"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double d3 = tickerData0.getChg65();
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808651306,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=694,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getClose((int)(short)(-1));

  }

  @Test
  public void test201() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test201"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("08-Aug-0005", (int)(short)1);

  }

  @Test
  public void test202() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test202"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    java.lang.String str12 = tickerData0.getTicker();
    double d13 = tickerData0.getChg23();
    double[] d_array14 = tickerData0.getCloseData();
    double d15 = tickerData0.getDiMinus();
    tickerData0.fillDataArrays(10, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar20 = tickerData0.getDate(100);

  }

  @Test
  public void test203() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test203"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    java.lang.String str10 = tickerData0.getTickerExchange();
    double d11 = tickerData0.getLow260();
    double d12 = tickerData0.getAvgVol20();
    java.util.Calendar[] calendar_array13 = tickerData0.getDateData();
    double d14 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getHigh((int)(byte)0);

  }

  @Test
  public void test204() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test204"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma23Trend();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getVolumeData();
    double d13 = tickerData11.getChg65();
    int i17 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData11, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType18 = tickerData11.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData11, true);
    double d21 = tickerData11.getDiPlus();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d24 = tickerData11.getVolume((int)'4');

  }

  @Test
  public void test205() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test205"); }


    net.ajaskey.market.ta.TickerData tickerData1 = new net.ajaskey.market.ta.TickerData();
    double[] d_array2 = tickerData1.getTrueLowData();
    java.util.Calendar calendar6 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate(calendar6);
    java.lang.String str8 = net.ajaskey.market.misc.Utils.stringDate2(calendar6);
    net.ajaskey.market.ta.DailyData dailyData9 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar6);
    double d10 = tickerData1.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType11 = tickerData1.getSma130Trend();
    double[] d_array12 = tickerData1.getVolumeData();
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData1, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.TickerData tickerData30 = new net.ajaskey.market.ta.TickerData("hi!", calendar21, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData31 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar21);
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    net.ajaskey.market.ta.DailyData dailyData43 = new net.ajaskey.market.ta.DailyData(calendar35, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    long long45 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar21, calendar35);
    net.ajaskey.market.ta.TickerData tickerData52 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650214,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar21, (double)(byte)0, (double)1, (double)100, (double)'4', (double)10L, (double)1.0f);
    java.lang.String str53 = tickerData52.getTickerExchange();
    double[] d_array54 = tickerData52.getTrueLowData();
    double[] d_array55 = tickerData52.getTrueHighData();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData52, false);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d59 = tickerData52.getHigh((int)(byte)(-1));

  }

  @Test
  public void test206() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test206"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.String str5 = tickerData0.getTickerExchange();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getOpen(0);

  }

  @Test
  public void test207() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test207"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    java.lang.Double d8 = tickerData0.getSma260();
    java.lang.Double d9 = tickerData0.getSmaPerc65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)(byte)(-1));

  }

  @Test
  public void test208() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test208"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    tickerData0.fillDataArrays((int)' ', false);
    double d11 = tickerData0.getDiPlus();
    double d12 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOi((int)(byte)0);

  }

  @Test
  public void test209() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test209"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getAvgVol20();
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma130Trend();
    double d6 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getClose((-100));

  }

  @Test
  public void test210() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test210"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getClose((int)(short)1);

  }

  @Test
  public void test211() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test211"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808641741,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=58,MILLISECOND=259,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)100);

  }

  @Test
  public void test212() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test212"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.String str14 = tickerData0.toString();
    int i18 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, 100, (int)' ', (int)'#');
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d20 = tickerData0.getClose(100);

  }

  @Test
  public void test213() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test213"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)'#');

  }

  @Test
  public void test214() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test214"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808650760,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=240,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)'#');

  }

  @Test
  public void test215() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test215"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double[] d_array13 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getOpen((int)(short)(-1));

  }

  @Test
  public void test216() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test216"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar16 = tickerData0.getDate((int)' ');

  }

  @Test
  public void test217() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test217"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getMfi130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getLow((-1));

  }

  @Test
  public void test218() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test218"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getMfi23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str14 = tickerData0.getDailyDataString((int)'4');

  }

  @Test
  public void test219() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test219"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808647281,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=52,MILLISECOND=719,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test220() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test220"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("Unknown", (int)(short)0);

  }

  @Test
  public void test221() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test221"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    double d16 = tickerData0.getChg();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar18 = tickerData0.getDate((int)'a');

  }

  @Test
  public void test222() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test222"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    double d9 = tickerData0.getDiMinus();
    double[] d_array10 = tickerData0.getOpenData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getOpen((-1));

  }

  @Test
  public void test223() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test223"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.lang.Double d6 = tickerData0.getSma65();
    net.ajaskey.market.ta.input.Fundamentals fundamentals7 = tickerData0.getFundies();
    double d8 = tickerData0.getLrSlope260();
    java.lang.Double d9 = tickerData0.getSma65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)(byte)(-1));

  }

  @Test
  public void test224() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test224"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    java.lang.Double d9 = tickerData0.getSma23();
    net.ajaskey.market.ta.methods.TaMethods taMethods10 = tickerData0.getTaMethods();
    double[] d_array11 = tickerData0.getHighData();
    java.lang.Double d12 = tickerData0.getSmaPerc23();
    double d13 = tickerData0.getRsRaw();
    double d14 = tickerData0.getAvgVol20();
    tickerData0.rSort();
    double d16 = tickerData0.getAtrPercent23();
    double d17 = tickerData0.getPriceInRng260();
    double d18 = tickerData0.getChg();
    double d19 = tickerData0.getMfi23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d21 = tickerData0.getOpen((int)' ');

  }

  @Test
  public void test225() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test225"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    double[] d_array9 = tickerData0.getOiData();
    double d10 = tickerData0.getMfi14();
    double d11 = tickerData0.getDiMinus();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, false);
    double d14 = tickerData0.getMfi23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getOi(100);

  }

  @Test
  public void test226() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test226"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double[] d_array26 = tickerData0.getHighData();
    double d27 = tickerData0.getMfi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar29 = tickerData0.getDate((int)'a');

  }

  @Test
  public void test227() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test227"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    double[] d_array9 = tickerData0.getOiData();
    double d10 = tickerData0.getMfi14();
    tickerData0.setTickerExchange("");
    double d13 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str15 = tickerData0.getDailyDataString((int)(short)1);

  }

  @Test
  public void test228() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test228"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSma130();
    double[] d_array3 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getVolume((int)(byte)10);

  }

  @Test
  public void test229() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test229"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma260Trend();
    double d9 = tickerData0.getChg65();
    double d10 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getHigh(0);

  }

  @Test
  public void test230() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test230"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)10);

  }

  @Test
  public void test231() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test231"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma65Trend();
    double[] d_array10 = tickerData0.getCloseData();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getVolumeData();
    double d13 = tickerData11.getChg65();
    double d14 = tickerData11.getChg65();
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getTrueLowData();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.DailyData dailyData23 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar20);
    double d24 = tickerData15.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType25 = tickerData15.getSma130Trend();
    double[] d_array26 = tickerData15.getVolumeData();
    int i30 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData15, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    net.ajaskey.market.ta.TickerData tickerData44 = new net.ajaskey.market.ta.TickerData("hi!", calendar35, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData45 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar35);
    java.util.Calendar calendar49 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str50 = net.ajaskey.market.misc.Utils.stringDate(calendar49);
    net.ajaskey.market.ta.DailyData dailyData57 = new net.ajaskey.market.ta.DailyData(calendar49, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str58 = net.ajaskey.market.misc.Utils.stringDate2(calendar49);
    long long59 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar35, calendar49);
    java.util.Calendar calendar63 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar67 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str68 = net.ajaskey.market.misc.Utils.stringDate(calendar67);
    java.lang.String str69 = net.ajaskey.market.misc.Utils.stringDate2(calendar67);
    boolean b70 = net.ajaskey.market.misc.Utils.sameYear(calendar63, calendar67);
    java.lang.String str71 = net.ajaskey.market.misc.Utils.getString(calendar67);
    boolean b72 = net.ajaskey.market.misc.Utils.sameYear(calendar49, calendar67);
    java.lang.String str73 = net.ajaskey.market.misc.Utils.stringDate2(calendar67);
    java.util.Calendar calendar74 = net.ajaskey.market.misc.Utils.makeCopy(calendar67);
    int i75 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData11, calendar67);
    java.util.Calendar calendar80 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str81 = net.ajaskey.market.misc.Utils.stringDate(calendar80);
    java.lang.String str82 = net.ajaskey.market.misc.Utils.stringDate2(calendar80);
    net.ajaskey.market.ta.TickerData tickerData89 = new net.ajaskey.market.ta.TickerData("hi!", calendar80, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar90 = net.ajaskey.market.misc.Utils.makeCopy(calendar80);
    boolean b91 = net.ajaskey.market.misc.Utils.sameMonth(calendar67, calendar90);
    java.util.Calendar calendar92 = net.ajaskey.market.misc.Utils.makeCopy(calendar90);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData94 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar90, (int)(byte)10);

  }

  @Test
  public void test232() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test232"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808644926,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=55,MILLISECOND=74,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test233() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test233"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 100);

  }

  @Test
  public void test234() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test234"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    net.ajaskey.market.ta.DailyData dailyData17 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData13, (int)(byte)10, (-1), (int)(byte)10);
    net.ajaskey.market.ta.input.Fundamentals fundamentals18 = tickerData13.getFundies();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d20 = tickerData13.getLow((int)(byte)100);

  }

  @Test
  public void test235() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test235"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.methods.TaMethods taMethods10 = tickerData0.getTaMethods();
    double d11 = tickerData0.getChg();
    int i12 = tickerData0.getDataCount();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getVolume(0);

  }

  @Test
  public void test236() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test236"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    java.lang.Double d14 = tickerData0.getSmaPerc260();
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate(calendar18);
    net.ajaskey.market.ta.DailyData dailyData26 = new net.ajaskey.market.ta.DailyData(calendar18, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d27 = dailyData26.getClose();
    double d28 = dailyData26.getDailyPercentChg();
    java.util.Calendar calendar29 = dailyData26.getDate();
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.makeCopy(calendar33);
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.makeCopy(calendar33);
    java.util.Calendar calendar40 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str41 = net.ajaskey.market.misc.Utils.stringDate(calendar40);
    java.lang.String str42 = net.ajaskey.market.misc.Utils.stringDate2(calendar40);
    net.ajaskey.market.ta.TickerData tickerData49 = new net.ajaskey.market.ta.TickerData("hi!", calendar40, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar50 = net.ajaskey.market.misc.Utils.makeCopy(calendar40);
    long long51 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar35, calendar40);
    long long52 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar29, calendar35);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData54 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar35, 0);

  }

  @Test
  public void test237() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test237"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808633435,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=6,MILLISECOND=565,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)' ');

  }

  @Test
  public void test238() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test238"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getMfi65();
    double d10 = tickerData0.getLrSlope260();
    java.util.Calendar calendar11 = net.ajaskey.market.misc.Utils.getBaseDate();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.makeCopy(calendar11);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData14 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar12, (int)(short)100);

  }

  @Test
  public void test239() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test239"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    double[] d_array5 = tickerData0.getTrueLowData();
    double d6 = tickerData0.getHigh260();
    double d7 = tickerData0.getAdx();
    java.util.Calendar calendar11 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.makeCopy(calendar11);
    net.ajaskey.market.ta.DailyData dailyData13 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar11);
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double[] d_array15 = tickerData0.getLowData();
    double d16 = tickerData0.getRsStRaw();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    net.ajaskey.market.ta.DailyData dailyData28 = new net.ajaskey.market.ta.DailyData(calendar20, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d29 = dailyData28.getTrueHigh();
    java.lang.String str30 = dailyData28.toString();
    tickerData0.addData(dailyData28);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d33 = tickerData0.getVolume((int)(byte)(-1));

  }

  @Test
  public void test240() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test240"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    net.ajaskey.market.ta.methods.TaMethods taMethods7 = tickerData0.getTaMethods();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getClose((int)(short)10);

  }

  @Test
  public void test241() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test241"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getAdx();
    double d11 = tickerData0.getChg();
    net.ajaskey.market.ta.TrendType trendType12 = tickerData0.getSma260Trend();
    double[] d_array13 = tickerData0.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getVolume((-100));

  }

  @Test
  public void test242() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test242"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808642662,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=57,MILLISECOND=338,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test243() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test243"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808624967,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=15,MILLISECOND=33,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test244() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test244"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    java.lang.Double d8 = tickerData0.getSma130();
    net.ajaskey.market.ta.TickerData tickerData9 = new net.ajaskey.market.ta.TickerData();
    double[] d_array10 = tickerData9.getVolumeData();
    double d11 = tickerData9.getChg65();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d16 = tickerData9.getLow260();
    double d17 = tickerData9.getDiMinus();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData9);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar22 = tickerData0.getDate((int)'#');

  }

  @Test
  public void test245() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test245"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808621426,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=18,MILLISECOND=574,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test246() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test246"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate2(calendar16);
    net.ajaskey.market.ta.TickerData tickerData25 = new net.ajaskey.market.ta.TickerData("hi!", calendar16, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str26 = tickerData25.getTickerExchange();
    net.ajaskey.market.ta.DailyData dailyData30 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData25, (int)(short)(-1), (int)(byte)0, (int)(byte)1);
    java.lang.String str31 = tickerData25.getTickerName();
    java.util.Calendar[] calendar_array32 = tickerData25.getDateData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData25);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str35 = tickerData25.getDailyDataString((-100));

  }

  @Test
  public void test247() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test247"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiMinus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getClose((int)(byte)10);

  }

  @Test
  public void test248() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test248"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808639444,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=0,MILLISECOND=556,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)100);

  }

  @Test
  public void test249() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test249"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double d10 = tickerData0.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getClose((int)(short)(-1));

  }

  @Test
  public void test250() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test250"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808650199,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=801,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)(-1));

  }

  @Test
  public void test251() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test251"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma65Trend();
    java.lang.String str10 = tickerData0.getTickerName();
    double d11 = tickerData0.getChg130();
    java.lang.String str12 = tickerData0.toString();
    java.lang.Double d13 = tickerData0.getSmaPerc260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getOi((int)(short)100);

  }

  @Test
  public void test252() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test252"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    double d5 = tickerData0.getCurrentPrice();
    double d6 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getVolume((int)(byte)1);

  }

  @Test
  public void test253() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test253"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double[] d_array14 = tickerData13.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData13.getClose((int)(byte)1);

  }

  @Test
  public void test254() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test254"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    java.lang.Double d4 = tickerData0.getSma65();
    tickerData0.setTickerExchange("unknown-month");
    double[] d_array7 = tickerData0.getCloseData();
    java.lang.Integer i8 = tickerData0.getDaysOfData();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getClose((int)(short)10);

  }

  @Test
  public void test255() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test255"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    double d10 = tickerData0.getRsStRaw();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getHigh((int)(byte)(-1));

  }

  @Test
  public void test256() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test256"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getOi((int)(short)1);

  }

  @Test
  public void test257() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test257"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    double d6 = tickerData0.getDiPlus();
    java.lang.Integer i7 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getClose(0);

  }

  @Test
  public void test258() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test258"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.methods.TaMethods taMethods8 = tickerData0.getTaMethods();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar11 = tickerData0.getDate(10);

  }

  @Test
  public void test259() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test259"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    java.lang.String str13 = tickerData0.toString();
    double d14 = tickerData0.getMfi23();
    double d15 = tickerData0.getChg65();
    double d16 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getOpen((-1));

  }

  @Test
  public void test260() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test260"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    java.lang.Double d9 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)(byte)(-1));

  }

  @Test
  public void test261() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test261"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    double d3 = tickerData0.getMfi23();
    net.ajaskey.market.ta.TickerData tickerData4 = new net.ajaskey.market.ta.TickerData();
    double[] d_array5 = tickerData4.getTrueLowData();
    java.lang.Double d6 = tickerData4.getSmaPerc23();
    java.lang.Double d7 = tickerData4.getSma260();
    double d8 = tickerData4.getMfi130();
    java.lang.Double d9 = tickerData4.getSmaPerc65();
    net.ajaskey.market.ta.TickerData tickerData10 = new net.ajaskey.market.ta.TickerData();
    double[] d_array11 = tickerData10.getTrueLowData();
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    net.ajaskey.market.ta.DailyData dailyData18 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar15);
    double[] d_array19 = tickerData10.getOiData();
    double[] d_array20 = tickerData10.getOiData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData4, tickerData10);
    java.lang.Double d22 = tickerData10.getSmaPerc23();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData10);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d25 = tickerData0.getOi(0);

  }

  @Test
  public void test262() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test262"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808628386,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=11,MILLISECOND=614,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test263() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test263"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808640895,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=59,MILLISECOND=105,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)0);

  }

  @Test
  public void test264() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test264"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808649933,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=67,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)100);

  }

  @Test
  public void test265() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test265"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    double d9 = tickerData0.getPriceOffHigh260();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double d11 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d13 = tickerData0.getClose(0);

  }

  @Test
  public void test266() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test266"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    double[] d_array9 = tickerData0.getOiData();
    double d10 = tickerData0.getMfi14();
    tickerData0.setTickerExchange("");
    double[] d_array13 = tickerData0.getTrueLowData();
    java.lang.Double d14 = tickerData0.getSmaPerc23();
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate(calendar18);
    net.ajaskey.market.ta.DailyData dailyData26 = new net.ajaskey.market.ta.DailyData(calendar18, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d27 = dailyData26.getTrueHigh();
    java.lang.String str28 = dailyData26.toString();
    java.lang.Double d29 = dailyData26.getVolume();
    java.lang.String str30 = dailyData26.toString();
    java.util.Calendar calendar31 = dailyData26.getDate();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData33 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar31, (int)'#');

  }

  @Test
  public void test267() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test267"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getRsStRaw();
    double d13 = tickerData0.getLrSlope260();
    tickerData0.setTicker("unknown-month");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData0.getClose(1);

  }

  @Test
  public void test268() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test268"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    java.lang.Double d4 = tickerData0.getSma65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getVolume((int)(byte)10);

  }

  @Test
  public void test269() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test269"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.lang.Double d6 = tickerData0.getSma65();
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma260Trend();
    double d8 = tickerData0.getPriceOffHigh260();
    double[] d_array9 = tickerData0.getVolumeData();
    double d10 = tickerData0.getPriceOffLow260();
    double d11 = tickerData0.getPriceInRng260();
    double[] d_array12 = tickerData0.getLowData();
    double d13 = tickerData0.getMfi14();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.makeCopy(calendar17);
    java.util.Calendar calendar19 = net.ajaskey.market.misc.Utils.makeCopy(calendar17);
    java.util.Calendar calendar24 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate(calendar24);
    java.lang.String str26 = net.ajaskey.market.misc.Utils.stringDate2(calendar24);
    net.ajaskey.market.ta.TickerData tickerData33 = new net.ajaskey.market.ta.TickerData("hi!", calendar24, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.makeCopy(calendar24);
    long long35 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar19, calendar24);
    java.util.Calendar calendar36 = net.ajaskey.market.misc.Utils.makeCopy(calendar19);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData38 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar36, 1);

  }

  @Test
  public void test270() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test270"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma130Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getLow(10);

  }

  @Test
  public void test271() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test271"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("null\tnull\tjava.util.GregorianCalendar[time=-62164808650620,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=380,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n\r\n", 0);

  }

  @Test
  public void test272() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test272"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    java.lang.Double d8 = tickerData0.getSma130();
    net.ajaskey.market.ta.TickerData tickerData9 = new net.ajaskey.market.ta.TickerData();
    double[] d_array10 = tickerData9.getVolumeData();
    double d11 = tickerData9.getChg65();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d16 = tickerData9.getLow260();
    double d17 = tickerData9.getDiMinus();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData9);
    double d19 = tickerData0.getAvgVol65();
    java.lang.String str20 = tickerData0.getTicker();
    double d21 = tickerData0.getLr260();
    java.lang.Integer i22 = tickerData0.getDaysOfData();
    double[] d_array23 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d25 = tickerData0.getClose((int)(byte)100);

  }

  @Test
  public void test273() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test273"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.String str8 = tickerData0.getTicker();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOi((-1));

  }

  @Test
  public void test274() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test274"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    double[] d_array5 = tickerData0.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getHigh((int)(short)100);

  }

  @Test
  public void test275() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test275"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLrInt260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getClose((int)(short)10);

  }

  @Test
  public void test276() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test276"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    double[] d_array16 = tickerData0.getTrueHighData();
    double d17 = tickerData0.getLrInt260();
    double[] d_array18 = tickerData0.getCloseData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar20 = tickerData0.getDate((int)(short)10);

  }

  @Test
  public void test277() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test277"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getLrInt260();
    double d5 = tickerData0.getMfi65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getVolume((int)(short)10);

  }

  @Test
  public void test278() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test278"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getMfi65();
    double d12 = tickerData0.getAtr23();
    java.lang.String str13 = tickerData0.getTicker();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getClose((int)(byte)0);

  }

  @Test
  public void test279() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test279"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double[] d_array9 = tickerData0.getOpenData();
    java.lang.String str10 = tickerData0.getTickerExchange();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    java.lang.String str16 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar14);
    net.ajaskey.market.ta.DailyData dailyData17 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar14);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d19 = tickerData0.getClose(0);

  }

  @Test
  public void test280() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test280"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double d26 = tickerData0.getMfi23();
    double d27 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d29 = tickerData0.getVolume(100);

  }

  @Test
  public void test281() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test281"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808631610,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=8,MILLISECOND=390,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test282() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test282"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    java.lang.Double d8 = tickerData0.getSmaPerc23();
    double d9 = tickerData0.getChg130();
    double d10 = tickerData0.getRsi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getVolume((int)(short)100);

  }

  @Test
  public void test283() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test283"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808628389,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=11,MILLISECOND=611,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(byte)0);

  }

  @Test
  public void test284() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test284"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    java.lang.Double d4 = tickerData0.getSma65();
    tickerData0.setTickerExchange("unknown-month");
    double[] d_array7 = tickerData0.getCloseData();
    java.lang.Double d8 = tickerData0.getSma23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOpen((int)(short)10);

  }

  @Test
  public void test285() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test285"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    tickerData0.fillDataArrays((int)' ', false);
    double d11 = tickerData0.getPriceOffHigh260();
    java.util.Calendar[] calendar_array12 = tickerData0.getDateData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getHigh((int)(short)1);

  }

  @Test
  public void test286() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test286"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getMfi23();
    double[] d_array13 = tickerData0.getVolumeData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getLow((int)'a');

  }

  @Test
  public void test287() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test287"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    java.lang.String str14 = tickerData8.getTicker();
    double[] d_array15 = tickerData8.getVolumeData();
    double d16 = tickerData8.getPriceOffLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData8.getOi((int)(byte)(-1));

  }

  @Test
  public void test288() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test288"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData0.getLr260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getVolume((int)'4');

  }

  @Test
  public void test289() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test289"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double d9 = tickerData0.getAtr23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double d11 = tickerData0.getRsi14();
    double d12 = tickerData0.getAtr23();
    java.lang.String str13 = tickerData0.getTickerExchange();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getClose(0);

  }

  @Test
  public void test290() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test290"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double[] d_array7 = tickerData0.getCloseData();
    double[] d_array8 = tickerData0.getTrueLowData();
    double[] d_array9 = tickerData0.getLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getClose((int)(short)1);

  }

  @Test
  public void test291() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test291"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    net.ajaskey.market.ta.TickerData tickerData5 = new net.ajaskey.market.ta.TickerData();
    double[] d_array6 = tickerData5.getTrueLowData();
    java.util.Calendar calendar10 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str11 = net.ajaskey.market.misc.Utils.stringDate(calendar10);
    java.lang.String str12 = net.ajaskey.market.misc.Utils.stringDate2(calendar10);
    net.ajaskey.market.ta.DailyData dailyData13 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData5, calendar10);
    double d14 = tickerData5.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType15 = tickerData5.getSma130Trend();
    double[] d_array16 = tickerData5.getVolumeData();
    int i20 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData5, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar25 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str26 = net.ajaskey.market.misc.Utils.stringDate(calendar25);
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate2(calendar25);
    net.ajaskey.market.ta.TickerData tickerData34 = new net.ajaskey.market.ta.TickerData("hi!", calendar25, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData35 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData5, calendar25);
    java.util.Calendar calendar39 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str40 = net.ajaskey.market.misc.Utils.stringDate(calendar39);
    net.ajaskey.market.ta.DailyData dailyData47 = new net.ajaskey.market.ta.DailyData(calendar39, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str48 = net.ajaskey.market.misc.Utils.stringDate2(calendar39);
    long long49 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar25, calendar39);
    net.ajaskey.market.ta.DailyData dailyData50 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar39);
    double d51 = tickerData0.getRsRaw();
    net.ajaskey.market.ta.TrendType trendType52 = tickerData0.getSma65Trend();
    java.lang.Double d53 = tickerData0.getSmaPerc260();
    double d54 = tickerData0.getChg130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d56 = tickerData0.getLow(100);

  }

  @Test
  public void test292() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test292"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    double[] d_array10 = tickerData0.getTypicalPriceData();
    double[] d_array11 = tickerData0.getHighData();
    java.lang.Double d12 = tickerData0.getSmaPerc23();
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    net.ajaskey.market.ta.DailyData dailyData24 = new net.ajaskey.market.ta.DailyData(calendar16, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate2(calendar16);
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.makeCopy(calendar16);
    net.ajaskey.market.ta.DailyData dailyData27 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar16);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d29 = tickerData0.getOi((int)(byte)100);

  }

  @Test
  public void test293() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test293"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    java.lang.Double d9 = tickerData0.getSma23();
    double d10 = tickerData0.getLrInt260();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    net.ajaskey.market.ta.DailyData dailyData15 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar14);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData0.getClose((int)(byte)10);

  }

  @Test
  public void test294() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test294"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    java.lang.String str14 = tickerData8.getTicker();
    double[] d_array15 = tickerData8.getVolumeData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData8.getClose((int)'4');

  }

  @Test
  public void test295() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test295"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    java.lang.String str12 = tickerData0.getTicker();
    double d13 = tickerData0.getChg23();
    double d14 = tickerData0.getHigh260();
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getVolumeData();
    double d17 = tickerData15.getChg65();
    int i21 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData15, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData15, true);
    net.ajaskey.market.ta.methods.TaMethods taMethods24 = tickerData15.getTaMethods();
    double d25 = tickerData15.getRsRaw();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData15);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d28 = tickerData0.getHigh((int)(byte)1);

  }

  @Test
  public void test296() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test296"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str4 = tickerData0.getDailyDataString((int)'#');

  }

  @Test
  public void test297() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test297"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    double d8 = tickerData0.getChg23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getVolume((int)(byte)100);

  }

  @Test
  public void test298() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test298"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str14 = tickerData13.getTickerExchange();
    double d15 = tickerData13.getCurrentPrice();
    double d16 = tickerData13.getDiMinus();
    net.ajaskey.market.ta.TrendType trendType17 = tickerData13.getSma23Trend();
    net.ajaskey.market.ta.TrendType trendType18 = tickerData13.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d20 = tickerData13.getLow(0);

  }

  @Test
  public void test299() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test299"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.methods.TaMethods taMethods9 = tickerData0.getTaMethods();
    java.lang.Double d10 = tickerData0.getSmaPerc130();
    net.ajaskey.market.ta.input.Fundamentals fundamentals11 = tickerData0.getFundies();
    net.ajaskey.market.ta.input.Fundamentals fundamentals12 = tickerData0.getFundies();
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    net.ajaskey.market.ta.DailyData dailyData24 = new net.ajaskey.market.ta.DailyData(calendar16, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    dailyData24.setTrueLow(0.0d);
    java.lang.Double d27 = dailyData24.getHigh();
    java.util.Calendar calendar28 = dailyData24.getDate();
    java.lang.String str29 = net.ajaskey.market.misc.Utils.getMonthName(calendar28);
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str34 = net.ajaskey.market.misc.Utils.stringDate(calendar33);
    long long35 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar28, calendar33);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData37 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar33, (int)(byte)1);

  }

  @Test
  public void test300() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test300"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808631173,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=8,MILLISECOND=827,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)' ');

  }

  @Test
  public void test301() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test301"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    java.lang.Double d9 = tickerData0.getSmaPerc130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)(short)(-1));

  }

  @Test
  public void test302() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test302"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808611678,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=28,MILLISECOND=322,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test303() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test303"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double d1 = tickerData0.getPriceOffHigh260();
    java.lang.Double d2 = tickerData0.getSma23();
    double[] d_array3 = tickerData0.getCloseData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getClose((int)(byte)0);

  }

  @Test
  public void test304() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test304"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData11.getRsi14();
    double d15 = tickerData11.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData11.getVolume((int)(byte)100);

  }

  @Test
  public void test305() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test305"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double[] d_array10 = tickerData0.getOpenData();
    double[] d_array11 = tickerData0.getTrueHighData();
    double[] d_array12 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOpen((int)(byte)10);

  }

  @Test
  public void test306() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test306"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSmaPerc65();
    double[] d_array5 = tickerData0.getOpenData();
    double[] d_array6 = tickerData0.getTrueHighData();
    double d7 = tickerData0.getAvgVol65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar9 = tickerData0.getDate(0);

  }

  @Test
  public void test307() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test307"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808631859,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=8,MILLISECOND=141,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test308() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test308"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSmaPerc23();
    java.lang.Double d3 = tickerData0.getSma260();
    double d4 = tickerData0.getAvgVol20();
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma130Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str7 = tickerData0.getDailyDataString((-1));

  }

  @Test
  public void test309() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test309"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    tickerData0.fillDataArrays((int)(byte)0, true);
    java.lang.String str8 = tickerData0.toString();
    net.ajaskey.market.ta.DailyData dailyData12 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)(byte)(-1), (int)(byte)0, (int)(byte)10);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar14 = tickerData0.getDate((int)(short)1);

  }

  @Test
  public void test310() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test310"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getPriceOffLow260();
    double d5 = tickerData0.getPriceOffHigh260();
    java.lang.Double d6 = tickerData0.getSmaPerc260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getVolume((int)'#');

  }

  @Test
  public void test311() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test311"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808633482,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=6,MILLISECOND=518,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test312() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test312"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.String str8 = tickerData0.getTicker();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOpen(0);

  }

  @Test
  public void test313() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test313"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    double[] d_array10 = tickerData0.getTypicalPriceData();
    double[] d_array11 = tickerData0.getHighData();
    java.lang.Double d12 = tickerData0.getSmaPerc23();
    double d13 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str15 = tickerData0.getDailyDataString((-100));

  }

  @Test
  public void test314() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test314"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    double d16 = tickerData0.getAtr23();
    double d17 = tickerData0.getMfi14();
    double d18 = tickerData0.getRsRaw();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar20 = tickerData0.getDate((int)(short)(-1));

  }

  @Test
  public void test315() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test315"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getOpen((int)' ');

  }

  @Test
  public void test316() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test316"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double[] d_array9 = tickerData0.getOiData();
    double[] d_array10 = tickerData0.getOiData();
    double d11 = tickerData0.getMfi23();
    double[] d_array12 = tickerData0.getOiData();
    double d13 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getClose((-100));

  }

  @Test
  public void test317() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test317"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808646455,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=53,MILLISECOND=545,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)0);

  }

  @Test
  public void test318() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test318"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getVolume((int)'a');

  }

  @Test
  public void test319() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test319"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getAdx();
    double d11 = tickerData0.getChg();
    net.ajaskey.market.ta.TrendType trendType12 = tickerData0.getSma260Trend();
    double d13 = tickerData0.getChg23();
    java.lang.Double d14 = tickerData0.getSmaPerc260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData0.getHigh(10);

  }

  @Test
  public void test320() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test320"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("NOTFOUND\tnull\tnull\r\n");

  }

  @Test
  public void test321() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test321"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    net.ajaskey.market.ta.DailyData dailyData20 = new net.ajaskey.market.ta.DailyData(calendar12, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar21 = dailyData20.getDate();
    tickerData0.addData(dailyData20);
    double d23 = tickerData0.getChg23();
    double[] d_array24 = tickerData0.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str26 = tickerData0.getDailyDataString((int)(byte)0);

  }

  @Test
  public void test322() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test322"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)100, (int)(short)(-1), (int)(short)1);
    java.lang.String str8 = tickerData0.getTicker();
    java.lang.Integer i9 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume(0);

  }

  @Test
  public void test323() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test323"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    tickerData0.setTicker("NotFound");
    java.lang.String str9 = tickerData0.toString();
    double d10 = tickerData0.getChg();
    java.lang.String str11 = tickerData0.toString();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str13 = tickerData0.getDailyDataString((-1));

  }

  @Test
  public void test324() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test324"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.methods.TaMethods taMethods8 = tickerData0.getTaMethods();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double d14 = tickerData11.getPriceOffLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d16 = tickerData11.getOi(0);

  }

  @Test
  public void test325() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test325"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getLrInt260();
    double[] d_array9 = tickerData0.getOiData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getOi((int)(byte)0);

  }

  @Test
  public void test326() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test326"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.String str14 = tickerData0.toString();
    int i18 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, 100, (int)' ', (int)'#');
    tickerData0.rSort();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d21 = tickerData0.getVolume((int)(short)100);

  }

  @Test
  public void test327() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test327"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double d3 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d5 = tickerData0.getLow((int)(short)0);

  }

  @Test
  public void test328() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test328"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    net.ajaskey.market.ta.TrendType trendType14 = tickerData13.getSma130Trend();
    double[] d_array15 = tickerData13.getTrueLowData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str17 = tickerData13.getDailyDataString((int)(short)1);

  }

  @Test
  public void test329() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test329"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.String str14 = tickerData0.toString();
    int i18 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, 100, (int)' ', (int)'#');
    tickerData0.rSort();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d21 = tickerData0.getOi((-100));

  }

  @Test
  public void test330() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test330"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    tickerData0.rSort();
    java.lang.Integer i4 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d6 = tickerData0.getHigh((int)'a');

  }

  @Test
  public void test331() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test331"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getMfi65();
    net.ajaskey.market.ta.TrendType trendType12 = tickerData0.getSma23Trend();
    double d13 = tickerData0.getChg260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getOpen((int)(short)1);

  }

  @Test
  public void test332() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test332"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808622845,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=17,MILLISECOND=155,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)0);

  }

  @Test
  public void test333() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test333"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getMfi65();
    double d10 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getOi((int)'4');

  }

  @Test
  public void test334() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test334"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double[] d_array15 = tickerData0.getTypicalPriceData();
    double d16 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getOpen((int)(short)(-1));

  }

  @Test
  public void test335() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test335"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    java.lang.String str13 = tickerData0.toString();
    double d14 = tickerData0.getMfi23();
    double d15 = tickerData0.getChg65();
    java.util.Calendar[] calendar_array16 = tickerData0.getDateData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData0.getLow((int)(short)0);

  }

  @Test
  public void test336() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test336"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    double d8 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getOi(10);

  }

  @Test
  public void test337() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test337"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808630065,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=9,MILLISECOND=935,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (-1));

  }

  @Test
  public void test338() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test338"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData();
    double[] d_array12 = tickerData11.getTrueLowData();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData11);
    double[] d_array14 = tickerData11.getHighData();
    tickerData11.rSort();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d17 = tickerData11.getVolume(1);

  }

  @Test
  public void test339() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test339"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double[] d_array7 = tickerData0.getCloseData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar9 = tickerData0.getDate((int)(short)0);

  }

  @Test
  public void test340() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test340"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    tickerData0.setTicker("NotFound");
    double d9 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getVolume((int)(short)100);

  }

  @Test
  public void test341() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test341"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808647640,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=52,MILLISECOND=360,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)'a');

  }

  @Test
  public void test342() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test342"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    double[] d_array5 = tickerData0.getTrueLowData();
    double d6 = tickerData0.getHigh260();
    double d7 = tickerData0.getAdx();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getHigh(100);

  }

  @Test
  public void test343() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test343"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getLowData();
    double d3 = tickerData0.getAtrPercent23();
    double d4 = tickerData0.getAtr23();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getHigh((int)(short)10);

  }

  @Test
  public void test344() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test344"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getHigh260();
    java.lang.Double d9 = tickerData0.getSma23();
    net.ajaskey.market.ta.methods.TaMethods taMethods10 = tickerData0.getTaMethods();
    double[] d_array11 = tickerData0.getHighData();
    java.lang.Double d12 = tickerData0.getSmaPerc23();
    double d13 = tickerData0.getRsRaw();
    double d14 = tickerData0.getAvgVol20();
    tickerData0.rSort();
    double d16 = tickerData0.getAtrPercent23();
    double d17 = tickerData0.getPriceInRng260();
    double d18 = tickerData0.getPriceOffHigh260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str20 = tickerData0.getDailyDataString((int)(short)1);

  }

  @Test
  public void test345() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test345"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808636239,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=3,MILLISECOND=761,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test346() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test346"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808620299,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=19,MILLISECOND=701,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test347() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test347"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.lang.String str14 = tickerData0.toString();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar16 = tickerData0.getDate((int)'#');

  }

  @Test
  public void test348() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test348"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double[] d_array9 = tickerData0.getOpenData();
    double d10 = tickerData0.getPriceOffHigh260();
    java.lang.Integer i11 = tickerData0.getDaysOfData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar13 = tickerData0.getDate((int)' ');

  }

  @Test
  public void test349() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test349"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    double d9 = tickerData0.getMfi14();
    net.ajaskey.market.ta.TickerData tickerData10 = new net.ajaskey.market.ta.TickerData();
    double[] d_array11 = tickerData10.getVolumeData();
    double d12 = tickerData10.getChg65();
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData10, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType17 = tickerData10.getSma130Trend();
    double[] d_array18 = tickerData10.getTrueHighData();
    java.lang.Double d19 = tickerData10.getSma23();
    double d20 = tickerData10.getLrInt260();
    java.util.Calendar calendar24 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData10, calendar24);
    int i26 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, calendar24);
    double[] d_array27 = tickerData0.getCloseData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar29 = tickerData0.getDate((int)(short)10);

  }

  @Test
  public void test350() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test350"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808614966,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=25,MILLISECOND=34,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 10);

  }

  @Test
  public void test351() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test351"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getMfi23();
    double d13 = tickerData0.getMfi130();
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate(calendar18);
    java.lang.String str20 = net.ajaskey.market.misc.Utils.stringDate2(calendar18);
    net.ajaskey.market.ta.TickerData tickerData27 = new net.ajaskey.market.ta.TickerData("hi!", calendar18, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    double d28 = tickerData27.getAvgVol20();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData27);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d31 = tickerData27.getVolume(10);

  }

  @Test
  public void test352() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test352"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    double[] d_array14 = tickerData8.getTypicalPriceData();
    tickerData8.setTickerExchange("java.util.GregorianCalendar[time=-62164808649013,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=987,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d18 = tickerData8.getVolume((int)'a');

  }

  @Test
  public void test353() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test353"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808603993,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=36,MILLISECOND=7,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)(short)100);

  }

  @Test
  public void test354() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test354"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getTypicalPriceData();
    tickerData0.rSort();
    tickerData0.fillDataArrays((int)'#', false);
    java.lang.Double d7 = tickerData0.getSmaPerc130();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    java.lang.Double d9 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar11 = tickerData0.getDate((int)'4');

  }

  @Test
  public void test355() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test355"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.Double d9 = tickerData0.getSmaPerc260();
    double d10 = tickerData0.getAvgVol20();
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d13 = tickerData0.getPriceOffHigh260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d15 = tickerData0.getLow((int)'4');

  }

  @Test
  public void test356() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test356"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    java.lang.String str8 = tickerData0.getTickerName();
    double d9 = tickerData0.getDiPlus();
    java.lang.Double d10 = tickerData0.getSmaPerc260();
    double d11 = tickerData0.getLr260();
    tickerData0.rSort();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getOpen((int)' ');

  }

  @Test
  public void test357() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test357"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("2,016", (-1));

  }

  @Test
  public void test358() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test358"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getClose((int)(byte)100);

  }

  @Test
  public void test359() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test359"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    double[] d_array7 = tickerData0.getTrueHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar9 = tickerData0.getDate((int)'4');

  }

  @Test
  public void test360() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test360"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLow260();
    double d8 = tickerData0.getDiMinus();
    java.lang.Double d9 = tickerData0.getSmaPerc130();
    java.lang.Double d10 = tickerData0.getSmaPerc260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getOi((int)(byte)0);

  }

  @Test
  public void test361() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test361"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    double[] d_array5 = tickerData0.getTrueLowData();
    java.lang.Double d6 = tickerData0.getSma130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str8 = tickerData0.getDailyDataString(10);

  }

  @Test
  public void test362() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test362"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    double d9 = tickerData0.getLow260();
    double d10 = tickerData0.getLrInt260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getClose((int)(byte)10);

  }

  @Test
  public void test363() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test363"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    tickerData0.setTickerExchange("HI!");
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma260Trend();
    double d8 = tickerData0.getAvgVol65();
    double[] d_array9 = tickerData0.getHighData();
    double d10 = tickerData0.getLrSlope260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str12 = tickerData0.getDailyDataString(100);

  }

  @Test
  public void test364() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test364"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    tickerData0.fillDataArrays((int)' ', false);
    double d11 = tickerData0.getPriceOffHigh260();
    double d12 = tickerData0.getRsRaw();
    net.ajaskey.market.ta.TrendType trendType13 = tickerData0.getSma260Trend();
    double d14 = tickerData0.getChg130();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar16 = tickerData0.getDate(100);

  }

  @Test
  public void test365() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test365"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double[] d_array9 = tickerData0.getOiData();
    double[] d_array10 = tickerData0.getOiData();
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    net.ajaskey.market.ta.TickerData tickerData24 = new net.ajaskey.market.ta.TickerData("hi!", calendar15, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData26 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar15, (int)(short)100);

  }

  @Test
  public void test366() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test366"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double[] d_array9 = tickerData0.getOpenData();
    java.util.Calendar calendar13 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str14 = net.ajaskey.market.misc.Utils.stringDate(calendar13);
    net.ajaskey.market.ta.DailyData dailyData21 = new net.ajaskey.market.ta.DailyData(calendar13, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d22 = dailyData21.getClose();
    double d23 = dailyData21.getDailyPercentChg();
    double d24 = dailyData21.getDailyPercentRng();
    dailyData21.setTrueHigh((double)(short)(-1));
    dailyData21.setTrueHigh((-1.0d));
    long long29 = dailyData21.getDaysSinceBase();
    tickerData0.addData(dailyData21);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d32 = tickerData0.getHigh((int)(short)10);

  }

  @Test
  public void test367() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test367"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    java.lang.String str10 = tickerData0.getTickerExchange();
    double d11 = tickerData0.getLow260();
    net.ajaskey.market.ta.TrendType trendType12 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TrendType trendType13 = tickerData0.getSma65Trend();
    double d14 = tickerData0.getRsStRaw();
    double d15 = tickerData0.getHigh260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar17 = tickerData0.getDate(1);

  }

  @Test
  public void test368() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test368"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    java.lang.Double d7 = tickerData0.getSma260();
    double d8 = tickerData0.getChg65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getVolume((int)(short)(-1));

  }

  @Test
  public void test369() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test369"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808636419,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=3,MILLISECOND=581,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", 0);

  }

  @Test
  public void test370() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test370"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double d14 = tickerData13.getChg65();
    double d15 = tickerData13.getLrAngle260();
    double d16 = tickerData13.getRsRaw();
    int i20 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData13, (int)(short)100, (int)(byte)(-1), (int)'#');
    java.lang.Double d21 = tickerData13.getSmaPerc23();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d23 = tickerData13.getOpen((int)(short)10);

  }

  @Test
  public void test371() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test371"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double d26 = tickerData0.getMfi23();
    double[] d_array27 = tickerData0.getVolumeData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d29 = tickerData0.getClose((int)(short)100);

  }

  @Test
  public void test372() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test372"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData2 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808599610,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=40,MILLISECOND=390,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", (int)'#');

  }

  @Test
  public void test373() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test373"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d23 = dailyData22.getClose();
    double d24 = dailyData22.getDailyPercentChg();
    tickerData0.addData(dailyData22);
    double[] d_array26 = tickerData0.getHighData();
    double d27 = tickerData0.getChg260();
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808635993,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=4,MILLISECOND=7,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar31 = tickerData0.getDate(100);

  }

  @Test
  public void test374() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test374"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double[] d_array3 = tickerData0.getTrueHighData();
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808650542,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=458,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLrAngle260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d9 = tickerData0.getOi((int)(byte)100);

  }

  @Test
  public void test375() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test375"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma65Trend();
    java.lang.String str10 = tickerData0.getTickerName();
    java.lang.Double d11 = tickerData0.getSma65();
    double[] d_array12 = tickerData0.getHighData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d14 = tickerData0.getHigh(0);

  }

  @Test
  public void test376() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test376"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getVolumeData();
    double d10 = tickerData8.getChg65();
    double[] d_array11 = tickerData8.getOiData();
    double d12 = tickerData8.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData8);
    double d14 = tickerData8.getChg260();
    double[] d_array15 = tickerData8.getOpenData();
    double[] d_array16 = tickerData8.getOpenData();
    java.lang.String str17 = tickerData8.getTickerExchange();
    double[] d_array18 = tickerData8.getCloseData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d20 = tickerData8.getClose((int)(short)10);

  }

  @Test
  public void test377() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test377"); }


    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData1 = net.ajaskey.market.ta.input.ParseData.parsePTVData("java.util.GregorianCalendar[time=-62164808613687,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=26,MILLISECOND=313,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test378() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test378"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double d12 = tickerData0.getMfi23();
    double d13 = tickerData0.getMfi130();
    tickerData0.fillDataArrays(0, false);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar18 = tickerData0.getDate((int)(byte)0);

  }

  @Test
  public void test379() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test379"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    double d6 = tickerData0.getDiPlus();
    java.lang.Integer i7 = tickerData0.getDaysOfData();
    int i11 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, 0, (int)'#', 10);
    java.lang.Double d12 = tickerData0.getSmaPerc130();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar15 = tickerData0.getDate(100);

  }

  @Test
  public void test380() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test380"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    double d3 = tickerData0.getPriceInRng260();
    double d4 = tickerData0.getAvgVol65();
    double d5 = tickerData0.getChg65();
    java.lang.Double d6 = tickerData0.getSmaPerc65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar8 = tickerData0.getDate((int)(short)1);

  }

  @Test
  public void test381() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test381"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.lang.Double d6 = tickerData0.getSma65();
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma260Trend();
    double d8 = tickerData0.getPriceOffHigh260();
    double[] d_array9 = tickerData0.getVolumeData();
    double d10 = tickerData0.getCurrentPrice();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getOi((int)(byte)100);

  }

  @Test
  public void test382() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test382"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    java.lang.Integer i4 = tickerData0.getDaysOfData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals5 = tickerData0.getFundies();
    net.ajaskey.market.ta.TrendType trendType6 = tickerData0.getSma260Trend();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getHigh((int)(short)100);

  }

  @Test
  public void test383() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test383"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.TickerData tickerData29 = new net.ajaskey.market.ta.TickerData("hi!", calendar20, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData30 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    double[] d_array31 = tickerData0.getOiData();
    java.lang.Double d32 = tickerData0.getSma130();
    java.lang.Double d33 = tickerData0.getSma130();
    java.lang.String str34 = tickerData0.toString();
    double d35 = tickerData0.getRsi14();
    double d36 = tickerData0.getDiPlus();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.util.Calendar calendar38 = tickerData0.getDate((int)' ');

  }

  @Test
  public void test384() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test384"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getChg130();
    tickerData0.fillDataArrays((int)(byte)10, false);
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d11 = tickerData0.getClose((int)(byte)10);

  }

  @Test
  public void test385() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test385"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    double d10 = tickerData0.getLow260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d12 = tickerData0.getVolume(0);

  }

  @Test
  public void test386() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test386"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d1 = tickerData0.getSma130();
    double[] d_array2 = tickerData0.getLowData();
    double d3 = tickerData0.getPriceOffHigh260();
    java.lang.Integer i4 = tickerData0.getDaysOfData();
    double d5 = tickerData0.getMfi14();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d7 = tickerData0.getOi((int)' ');

  }

  @Test
  public void test387() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test387"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double d9 = tickerData0.getAtr23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    java.lang.Double d11 = tickerData0.getSmaPerc65();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    java.lang.String str13 = tickerData0.getDailyDataString(0);

  }

  @Test
  public void test388() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test388"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double d7 = tickerData0.getLr260();
    java.lang.Double d8 = tickerData0.getSma260();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d10 = tickerData0.getLow((int)(short)(-1));

  }

  @Test
  public void test389() throws Throwable {

    if (debug) { System.out.format("%n%s%n","ErrorTest0.test389"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double[] d_array3 = tickerData0.getTrueHighData();
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808650542,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=458,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double[] d_array6 = tickerData0.getTypicalPriceData();
    // during test generation this statement threw an exception of type java.lang.NullPointerException in error
    double d8 = tickerData0.getVolume((int)' ');

  }

}
