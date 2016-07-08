package net.ajaskey.market.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest7 {

  public static boolean debug = false;

  @Test
  public void test001() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test001"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260(10.0d);
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808648342,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=658,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d12 = industryData0.getChg260();
    industryData0.setChg260((double)' ');
    industryData0.setPriceInRange260((double)1.0f);
    industryData0.setChg260((double)100L);
    double d19 = industryData0.getRawRs();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 10.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);

  }

  @Test
  public void test002() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test002"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSmaPerc260();
    double d6 = derivedData0.getMfi130();
    java.lang.Double d7 = derivedData0.getSma65();
    java.lang.Double d8 = derivedData0.getSma130();
    double d9 = derivedData0.getMfi23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test003() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test003"); }


    net.ajaskey.market.ta.TickerData tickerData0 = null;
    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.makeCopy(calendar4);
    java.util.Calendar calendar6 = net.ajaskey.market.misc.Utils.makeCopy(calendar4);
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, calendar4);
    net.ajaskey.market.ta.TickerData tickerData8 = null;
    net.ajaskey.market.ta.TickerData tickerData9 = null;
    java.util.Calendar calendar13 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str14 = net.ajaskey.market.misc.Utils.stringDate(calendar13);
    net.ajaskey.market.ta.DailyData dailyData21 = new net.ajaskey.market.ta.DailyData(calendar13, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData22 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData9, calendar13);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData24 = net.ajaskey.market.ta.TickerData.getSlice(tickerData8, calendar13, (int)'a');
    net.ajaskey.market.ta.TickerData tickerData25 = new net.ajaskey.market.ta.TickerData();
    double[] d_array26 = tickerData25.getVolumeData();
    double d27 = tickerData25.getChg65();
    double[] d_array28 = tickerData25.getOiData();
    double d29 = tickerData25.getMfi65();
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str34 = net.ajaskey.market.misc.Utils.stringDate(calendar33);
    java.lang.String str35 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar33);
    net.ajaskey.market.ta.TickerData tickerData36 = null;
    net.ajaskey.market.ta.TickerData tickerData37 = new net.ajaskey.market.ta.TickerData();
    double[] d_array38 = tickerData37.getTrueLowData();
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate2(calendar42);
    net.ajaskey.market.ta.DailyData dailyData45 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData37, calendar42);
    int i46 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData36, calendar42);
    boolean b47 = net.ajaskey.market.misc.Utils.sameYear(calendar33, calendar42);
    java.util.Calendar calendar51 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str52 = net.ajaskey.market.misc.Utils.stringDate(calendar51);
    java.lang.String str53 = net.ajaskey.market.misc.Utils.stringDate2(calendar51);
    int i54 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData25, calendar42, calendar51);
    java.util.Calendar calendar58 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str59 = net.ajaskey.market.misc.Utils.stringDate(calendar58);
    net.ajaskey.market.ta.DailyData dailyData66 = new net.ajaskey.market.ta.DailyData(calendar58, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar70 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    boolean b71 = net.ajaskey.market.misc.Utils.sameYear(calendar58, calendar70);
    long long72 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar51, calendar70);
    java.util.Calendar calendar76 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar80 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str81 = net.ajaskey.market.misc.Utils.stringDate(calendar80);
    java.lang.String str82 = net.ajaskey.market.misc.Utils.stringDate2(calendar80);
    boolean b83 = net.ajaskey.market.misc.Utils.sameYear(calendar76, calendar80);
    boolean b84 = net.ajaskey.market.misc.Utils.sameYear(calendar51, calendar76);
    boolean b85 = net.ajaskey.market.misc.Utils.sameDate(calendar13, calendar76);
    java.util.Calendar calendar86 = net.ajaskey.market.misc.Utils.makeCopy(calendar76);
    boolean b87 = net.ajaskey.market.misc.Utils.sameMonth(calendar4, calendar76);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "30-Jan-0001"+ "'", str14.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d27 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "30-Jan-0001"+ "'", str34.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "java.util.GregorianCalendar[time=-62164808596021,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=43,MILLISECOND=979,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str35.equals("java.util.GregorianCalendar[time=-62164808596021,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=43,MILLISECOND=979,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "Fri 30-Jan-0001"+ "'", str44.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData45);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i46 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b47 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "30-Jan-0001"+ "'", str52.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str53 + "' != '" + "Fri 30-Jan-0001"+ "'", str53.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i54 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar58);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str59 + "' != '" + "30-Jan-0001"+ "'", str59.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar70);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b71 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long72 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar76);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar80);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str81 + "' != '" + "30-Jan-0001"+ "'", str81.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str82 + "' != '" + "Fri 30-Jan-0001"+ "'", str82.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b83 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b84 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b85 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar86);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b87 == false);

  }

  @Test
  public void test004() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test004"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    industryData0.setName("java.util.GregorianCalendar[time=-62164808651587,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=413,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260((double)10);
    industryData0.setShares((long)0);
    double d14 = industryData0.getRawRs();
    industryData0.setChg260((double)(byte)100);
    industryData0.setAvgVol((double)(byte)0);
    // The following exception was thrown during execution in test generation
    try {
    double d20 = industryData0.getSlope((int)(short)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);

  }

  @Test
  public void test005() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test005"); }


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
    net.ajaskey.market.ta.methods.TaMethods taMethods55 = tickerData52.getTaMethods();
    java.lang.String str56 = tickerData52.getTicker();
    tickerData52.fillDataArrays(0, false);
    double d60 = tickerData52.getPriceInRng260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "30-Jan-0001"+ "'", str7.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Fri 30-Jan-0001"+ "'", str8.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i16 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Fri 30-Jan-0001"+ "'", str23.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "Fri 30-Jan-0001"+ "'", str44.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long45 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str53 + "' != '" + "Unknown"+ "'", str53.equals("Unknown"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d54 + "' != '" + 0.0d+ "'", d54.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(taMethods55);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str56 + "' != '" + "JAVA.UTIL.GREGORIANCALENDAR[TIME=-62164808650214,AREFIELDSSET=TRUE,AREALLFIELDSSET=FALSE,LENIENT=TRUE,ZONE=SUN.UTIL.CALENDAR.ZONEINFO[ID=\"AMERICA/DENVER\",OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,TRANSITIONS=157,LASTRULE=JAVA.UTIL.SIMPLETIMEZONE[ID=AMERICA/DENVER,OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,STARTYEAR=0,STARTMODE=3,STARTMONTH=2,STARTDAY=8,STARTDAYOFWEEK=1,STARTTIME=7200000,STARTTIMEMODE=0,ENDMODE=3,ENDMONTH=10,ENDDAY=1,ENDDAYOFWEEK=1,ENDTIME=7200000,ENDTIMEMODE=0]],FIRSTDAYOFWEEK=1,MINIMALDAYSINFIRSTWEEK=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  YEAR         : 1\n  MONTH        : 0\n  DAY OF MONTH : 30\n  DAY OF YEAR  : 30\n  WEEK OF YEAR : 5"+ "'", str56.equals("JAVA.UTIL.GREGORIANCALENDAR[TIME=-62164808650214,AREFIELDSSET=TRUE,AREALLFIELDSSET=FALSE,LENIENT=TRUE,ZONE=SUN.UTIL.CALENDAR.ZONEINFO[ID=\"AMERICA/DENVER\",OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,TRANSITIONS=157,LASTRULE=JAVA.UTIL.SIMPLETIMEZONE[ID=AMERICA/DENVER,OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,STARTYEAR=0,STARTMODE=3,STARTMONTH=2,STARTDAY=8,STARTDAYOFWEEK=1,STARTTIME=7200000,STARTTIMEMODE=0,ENDMODE=3,ENDMONTH=10,ENDDAY=1,ENDDAYOFWEEK=1,ENDTIME=7200000,ENDTIMEMODE=0]],FIRSTDAYOFWEEK=1,MINIMALDAYSINFIRSTWEEK=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  YEAR         : 1\n  MONTH        : 0\n  DAY OF MONTH : 30\n  DAY OF YEAR  : 30\n  WEEK OF YEAR : 5"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d60 == 0.0d);

  }

  @Test
  public void test006() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test006"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSma23();
    java.lang.Double d6 = derivedData0.getSmaPerc65();
    double d7 = derivedData0.getChg65();
    double d8 = derivedData0.getPriceOffLow260();
    double d9 = derivedData0.getAvgVol65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test007() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test007"); }


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
    java.lang.Double d52 = tickerData0.getSmaPerc260();
    double[] d_array53 = tickerData0.getOpenData();
    java.lang.Double d54 = tickerData0.getSma260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "30-Jan-0001"+ "'", str11.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Fri 30-Jan-0001"+ "'", str12.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i20 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "30-Jan-0001"+ "'", str26.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "Fri 30-Jan-0001"+ "'", str27.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar39);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str40 + "' != '" + "30-Jan-0001"+ "'", str40.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str48 + "' != '" + "Fri 30-Jan-0001"+ "'", str48.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long49 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d51 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array53);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d54);

  }

  @Test
  public void test008() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test008"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getPriceOffLow260();
    double d4 = derivedData0.getPriceInRng260();
    double d5 = derivedData0.getRsRaw();
    double d6 = derivedData0.getAvgVol65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test009() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test009"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    double d1 = industryData0.getAvgVol();
    java.util.List<java.lang.Integer> list_i2 = industryData0.getRank();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i2);

  }

  @Test
  public void test010() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test010"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    double d2 = derivedData0.getChg65();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsStRaw();
    double d5 = derivedData0.getPriceInRng260();
    double d6 = derivedData0.getMfi130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test011() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test011"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    java.util.Calendar calendar8 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str9 = net.ajaskey.market.misc.Utils.stringDate(calendar8);
    java.lang.String str10 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar8);
    net.ajaskey.market.ta.TickerData tickerData11 = null;
    net.ajaskey.market.ta.TickerData tickerData12 = new net.ajaskey.market.ta.TickerData();
    double[] d_array13 = tickerData12.getTrueLowData();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate(calendar17);
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate2(calendar17);
    net.ajaskey.market.ta.DailyData dailyData20 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData12, calendar17);
    int i21 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData11, calendar17);
    boolean b22 = net.ajaskey.market.misc.Utils.sameYear(calendar8, calendar17);
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate2(calendar26);
    int i29 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData0, calendar17, calendar26);
    java.lang.String str30 = net.ajaskey.market.misc.Utils.stringDate2(calendar17);
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar35);
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate2(calendar42);
    net.ajaskey.market.ta.TickerData tickerData51 = new net.ajaskey.market.ta.TickerData("hi!", calendar42, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar52 = net.ajaskey.market.misc.Utils.makeCopy(calendar42);
    boolean b53 = net.ajaskey.market.misc.Utils.sameDate(calendar35, calendar52);
    net.ajaskey.market.misc.Utils.printCalendar(calendar52);
    java.util.Calendar calendar58 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar62 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str63 = net.ajaskey.market.misc.Utils.stringDate(calendar62);
    java.lang.String str64 = net.ajaskey.market.misc.Utils.stringDate2(calendar62);
    boolean b65 = net.ajaskey.market.misc.Utils.sameYear(calendar58, calendar62);
    boolean b66 = net.ajaskey.market.misc.Utils.sameMonth(calendar52, calendar62);
    net.ajaskey.market.ta.TickerData tickerData73 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808645581,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=54,MILLISECOND=419,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar62, 32.0d, (double)(short)0, (double)(short)100, (double)(short)1, (double)100L, (double)'4');
    boolean b74 = net.ajaskey.market.misc.Utils.sameDate(calendar17, calendar62);
    net.ajaskey.market.misc.Utils.printCalendar(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "30-Jan-0001"+ "'", str9.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str10 + "' != '" + "java.util.GregorianCalendar[time=-62164808595803,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=197,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str10.equals("java.util.GregorianCalendar[time=-62164808595803,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=197,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "30-Jan-0001"+ "'", str18.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "Fri 30-Jan-0001"+ "'", str19.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b22 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Fri 30-Jan-0001"+ "'", str28.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i29 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "Fri 30-Jan-0001"+ "'", str30.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "java.util.GregorianCalendar[time=-62164808595803,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=197,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str37.equals("java.util.GregorianCalendar[time=-62164808595803,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=197,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "Fri 30-Jan-0001"+ "'", str44.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b53 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar58);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar62);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str63 + "' != '" + "30-Jan-0001"+ "'", str63.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str64 + "' != '" + "Fri 30-Jan-0001"+ "'", str64.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b65 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b66 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b74 == true);

  }

  @Test
  public void test012() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test012"); }


    boolean b1 = net.ajaskey.market.ta.input.ParseData.isTickerValid("JAVA.UTIL.GREGORIANCALENDAR[TIME=-62164808652443,AREFIELDSSET=TRUE,AREALLFIELDSSET=FALSE,LENIENT=TRUE,ZONE=SUN.UTIL.CALENDAR.ZONEINFO[ID=\"AMERICA/DENVER\",OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,TRANSITIONS=157,LASTRULE=JAVA.UTIL.SIMPLETIMEZONE[ID=AMERICA/DENVER,OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,STARTYEAR=0,STARTMODE=3,STARTMONTH=2,STARTDAY=8,STARTDAYOFWEEK=1,STARTTIME=7200000,STARTTIMEMODE=0,ENDMODE=3,ENDMONTH=10,ENDDAY=1,ENDDAYOFWEEK=1,ENDTIME=7200000,ENDTIMEMODE=0]],FIRSTDAYOFWEEK=1,MINIMALDAYSINFIRSTWEEK=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  YEAR         : 1\n  MONTH        : 0\n  DAY OF MONTH : 30\n  DAY OF YEAR  : 30\n  WEEK OF YEAR : 5");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b1 == false);

  }

  @Test
  public void test013() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test013"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808650526,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=474,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setPriceInRange260((double)0L);
    industryData0.setRank((int)(short)(-1));
    java.lang.String str17 = industryData0.getName();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str17);

  }

  @Test
  public void test014() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test014"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSma65();
    double d3 = derivedData0.getDiPlus();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getCurrentPrice();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);

  }

  @Test
  public void test015() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test015"); }


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
    java.util.Calendar calendar13 = null;
    net.ajaskey.market.ta.DailyData dailyData14 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar13);
    double d15 = tickerData0.getChg65();
    java.lang.Double d16 = tickerData0.getSmaPerc65();
    java.lang.Double d17 = tickerData0.getSma260();
    net.ajaskey.market.ta.DailyData dailyData21 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)'4', (int)(short)(-1), 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData21);

  }

  @Test
  public void test016() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test016"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    java.lang.Double d4 = tickerData0.getSma260();
    double[] d_array5 = tickerData0.getTrueLowData();
    tickerData0.rSort();
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma65Trend();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);

  }

  @Test
  public void test017() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test017"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType3 = tickerData0.getSma23Trend();
    java.lang.Double d4 = tickerData0.getSma65();
    tickerData0.setTickerExchange("unknown-month");
    java.lang.Double d7 = tickerData0.getSma23();
    net.ajaskey.market.ta.TickerData tickerData8 = new net.ajaskey.market.ta.TickerData();
    double[] d_array9 = tickerData8.getTrueLowData();
    java.util.Calendar calendar13 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str14 = net.ajaskey.market.misc.Utils.stringDate(calendar13);
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate2(calendar13);
    net.ajaskey.market.ta.DailyData dailyData16 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData8, calendar13);
    double d17 = tickerData8.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType18 = tickerData8.getSma130Trend();
    double[] d_array19 = tickerData8.getVolumeData();
    int i23 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData8, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar28 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str29 = net.ajaskey.market.misc.Utils.stringDate(calendar28);
    java.lang.String str30 = net.ajaskey.market.misc.Utils.stringDate2(calendar28);
    net.ajaskey.market.ta.TickerData tickerData37 = new net.ajaskey.market.ta.TickerData("hi!", calendar28, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData38 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData8, calendar28);
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    net.ajaskey.market.ta.DailyData dailyData50 = new net.ajaskey.market.ta.DailyData(calendar42, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str51 = net.ajaskey.market.misc.Utils.stringDate2(calendar42);
    long long52 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar28, calendar42);
    java.util.Calendar calendar56 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar60 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str61 = net.ajaskey.market.misc.Utils.stringDate(calendar60);
    java.lang.String str62 = net.ajaskey.market.misc.Utils.stringDate2(calendar60);
    boolean b63 = net.ajaskey.market.misc.Utils.sameYear(calendar56, calendar60);
    java.lang.String str64 = net.ajaskey.market.misc.Utils.getString(calendar60);
    boolean b65 = net.ajaskey.market.misc.Utils.sameYear(calendar42, calendar60);
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate2(calendar60);
    java.util.Calendar calendar67 = net.ajaskey.market.misc.Utils.makeCopy(calendar60);
    java.lang.String str68 = net.ajaskey.market.misc.Utils.getMonthName(calendar67);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData70 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar67, (int)(short)(-1));
    java.lang.Double d71 = tickerData0.getSma130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "30-Jan-0001"+ "'", str14.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "Fri 30-Jan-0001"+ "'", str15.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i23 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str29 + "' != '" + "30-Jan-0001"+ "'", str29.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "Fri 30-Jan-0001"+ "'", str30.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "Fri 30-Jan-0001"+ "'", str51.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long52 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar60);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str61 + "' != '" + "30-Jan-0001"+ "'", str61.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str62 + "' != '" + "Fri 30-Jan-0001"+ "'", str62.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b63 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str64 + "' != '" + "30-Jan-0001"+ "'", str64.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b65 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "Fri 30-Jan-0001"+ "'", str66.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar67);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str68 + "' != '" + "unknown-month"+ "'", str68.equals("unknown-month"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData70);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d71);

  }

  @Test
  public void test018() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test018"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    double[] d_array5 = tickerData0.getCloseData();
    double[] d_array6 = tickerData0.getTrueHighData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);

  }

  @Test
  public void test019() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test019"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar(0, (int)(byte)0, 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);

  }

  @Test
  public void test020() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test020"); }


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
    net.ajaskey.market.ta.input.Fundamentals fundamentals11 = tickerData0.getFundies();
    double[] d_array12 = tickerData0.getTrueLowData();
    java.lang.Integer i13 = tickerData0.getDaysOfData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "HI!"+ "'", str7.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i13);

  }

  @Test
  public void test021() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test021"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRawRs((double)100);
    java.lang.String str8 = industryData0.getSector();
    industryData0.setPriceInRange260((double)10L);
    java.lang.String str11 = industryData0.getSector();
    industryData0.setMarketCap("NotFound");
    double d14 = industryData0.getAvgVol();
    java.lang.String str15 = industryData0.getRanks();
    industryData0.setRawRsSt((double)(-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "101  "+ "'", str15.equals("101  "));

  }

  @Test
  public void test022() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test022"); }


    net.ajaskey.market.ta.input.ParseData.setValidTicker("java.util.GregorianCalendar[time=-62164808608495,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=31,MILLISECOND=505,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");

  }

  @Test
  public void test023() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test023"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "30-Jan-0001" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'#');
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)(-1));
    net.ajaskey.market.ta.TickerData.clearTickerData(list_tickerData9);
    net.ajaskey.market.ta.TickerData tickerData12 = net.ajaskey.market.ta.TickerData.getTickerData(list_tickerData9, "java.util.GregorianCalendar[time=-62164808614560,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=25,MILLISECOND=440,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(tickerData12);

  }

  @Test
  public void test024() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test024"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.Double d9 = tickerData0.getSmaPerc260();
    double d10 = tickerData0.getAvgVol20();
    double d11 = tickerData0.getAvgVol65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test025() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test025"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLr260();
    double[] d_array8 = tickerData0.getTrueHighData();
    tickerData0.fillDataArrays(1, false);
    double[] d_array12 = tickerData0.getTrueHighData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals13 = tickerData0.getFundies();
    java.lang.String str14 = tickerData0.getTickerExchange();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str14);

  }

  @Test
  public void test026() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test026"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    industryData0.setTicker("0");
    long long5 = industryData0.getShares();
    double d6 = industryData0.getAvgVol();
    double d7 = industryData0.getPriceInRange260();
    industryData0.setRank(10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long5 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test027() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test027"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    double d7 = tickerData0.getChg();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma23Trend();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);

  }

  @Test
  public void test028() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test028"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    java.lang.String str4 = industryData0.getRanks();
    java.lang.String str5 = industryData0.getTicker();
    java.util.List<java.lang.Integer> list_i6 = industryData0.getRank();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i6);

  }

  @Test
  public void test029() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test029"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData4 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData8 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'a');
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData10 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData10);

  }

  @Test
  public void test030() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test030"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma260Trend();
    int i12 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(byte)0, (int)(byte)1, (int)(short)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "HI!"+ "'", str7.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));

  }

  @Test
  public void test031() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test031"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.util.Calendar calendar14 = null;
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getTrueLowData();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.DailyData dailyData23 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar20);
    boolean b24 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar20);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808650620,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=380,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d28 = tickerData0.getAtrPercent23();
    double d29 = tickerData0.getMfi14();
    double[] d_array30 = tickerData0.getCloseData();
    double[] d_array31 = tickerData0.getTrueLowData();
    double d32 = tickerData0.getPriceOffLow260();
    double d33 = tickerData0.getHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Fri 30-Jan-0001"+ "'", str22.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d32 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d33 == 0.0d);

  }

  @Test
  public void test032() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test032"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double[] d_array6 = tickerData0.getTrueHighData();
    double[] d_array7 = tickerData0.getOpenData();
    tickerData0.setTickerExchange("NotFound");
    double[] d_array10 = tickerData0.getHighData();
    double[] d_array11 = tickerData0.getTypicalPriceData();
    int i12 = tickerData0.getDataCount();
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    java.util.Calendar calendar18 = null;
    java.util.Calendar calendar23 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str24 = net.ajaskey.market.misc.Utils.stringDate(calendar23);
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate2(calendar23);
    net.ajaskey.market.ta.TickerData tickerData32 = new net.ajaskey.market.ta.TickerData("hi!", calendar23, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.makeCopy(calendar23);
    java.util.Calendar calendar37 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str38 = net.ajaskey.market.misc.Utils.stringDate(calendar37);
    java.lang.String str39 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar37);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    net.ajaskey.market.ta.TickerData tickerData53 = new net.ajaskey.market.ta.TickerData("hi!", calendar44, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar54 = net.ajaskey.market.misc.Utils.makeCopy(calendar44);
    boolean b55 = net.ajaskey.market.misc.Utils.sameDate(calendar37, calendar54);
    long long56 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar33, calendar54);
    boolean b57 = net.ajaskey.market.misc.Utils.sameDate(calendar18, calendar54);
    java.lang.String str58 = net.ajaskey.market.misc.Utils.getDayName(calendar54);
    boolean b59 = net.ajaskey.market.misc.Utils.sameDate(calendar16, calendar54);
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData61 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar16, (int)' ');
      org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException");
    } catch (java.lang.NullPointerException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.NullPointerException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "30-Jan-0001"+ "'", str17.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "30-Jan-0001"+ "'", str24.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "Fri 30-Jan-0001"+ "'", str25.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str38 + "' != '" + "30-Jan-0001"+ "'", str38.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str39 + "' != '" + "java.util.GregorianCalendar[time=-62164808595585,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=415,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str39.equals("java.util.GregorianCalendar[time=-62164808595585,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=415,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar54);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b55 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long56 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b57 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "unknown-day"+ "'", str58.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b59 == true);

  }

  @Test
  public void test033() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test033"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLow260();
    double d8 = tickerData0.getDiMinus();
    double d9 = tickerData0.getRsRaw();
    double d10 = tickerData0.getLow260();
    double d11 = tickerData0.getCurrentPrice();
    java.lang.String str12 = tickerData0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "null\tnull\tnull\r\n"+ "'", str12.equals("null\tnull\tnull\r\n"));

  }

  @Test
  public void test034() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test034"); }


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
    java.util.Calendar calendar26 = dailyData22.getDate();
    java.lang.String str27 = net.ajaskey.market.misc.Utils.getString(calendar26);
    net.ajaskey.market.ta.TickerData tickerData28 = new net.ajaskey.market.ta.TickerData();
    double[] d_array29 = tickerData28.getVolumeData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals30 = tickerData28.getFundies();
    double d31 = tickerData28.getMfi23();
    java.lang.Double d32 = tickerData28.getSmaPerc23();
    double d33 = tickerData28.getChg23();
    net.ajaskey.market.ta.TickerData tickerData34 = null;
    net.ajaskey.market.ta.TickerData tickerData35 = null;
    java.util.Calendar calendar39 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str40 = net.ajaskey.market.misc.Utils.stringDate(calendar39);
    net.ajaskey.market.ta.DailyData dailyData47 = new net.ajaskey.market.ta.DailyData(calendar39, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData48 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData35, calendar39);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData50 = net.ajaskey.market.ta.TickerData.getSlice(tickerData34, calendar39, (int)'a');
    net.ajaskey.market.ta.TickerData tickerData51 = new net.ajaskey.market.ta.TickerData();
    double[] d_array52 = tickerData51.getTrueLowData();
    java.util.Calendar calendar56 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str57 = net.ajaskey.market.misc.Utils.stringDate(calendar56);
    java.lang.String str58 = net.ajaskey.market.misc.Utils.stringDate2(calendar56);
    net.ajaskey.market.ta.DailyData dailyData59 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData51, calendar56);
    double d60 = tickerData51.getAtrPercent23();
    tickerData51.fillDataArrays((int)(short)100, false);
    double[] d_array64 = tickerData51.getTrueHighData();
    java.util.Calendar calendar68 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str69 = net.ajaskey.market.misc.Utils.stringDate(calendar68);
    java.lang.String str70 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar68);
    java.util.Calendar calendar75 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate(calendar75);
    java.lang.String str77 = net.ajaskey.market.misc.Utils.stringDate2(calendar75);
    net.ajaskey.market.ta.TickerData tickerData84 = new net.ajaskey.market.ta.TickerData("hi!", calendar75, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar85 = net.ajaskey.market.misc.Utils.makeCopy(calendar75);
    boolean b86 = net.ajaskey.market.misc.Utils.sameDate(calendar68, calendar85);
    net.ajaskey.market.ta.DailyData dailyData87 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData51, calendar85);
    java.lang.String str88 = net.ajaskey.market.misc.Utils.getMonthName(calendar85);
    int i89 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData28, calendar39, calendar85);
    boolean b90 = net.ajaskey.market.misc.Utils.sameYear(calendar26, calendar85);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d23 + "' != '" + 1.0d+ "'", d23.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d33 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar39);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str40 + "' != '" + "30-Jan-0001"+ "'", str40.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str57 + "' != '" + "30-Jan-0001"+ "'", str57.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "Fri 30-Jan-0001"+ "'", str58.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData59);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d60 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array64);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str69 + "' != '" + "30-Jan-0001"+ "'", str69.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str70 + "' != '" + "java.util.GregorianCalendar[time=-62164808595569,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=431,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str70.equals("java.util.GregorianCalendar[time=-62164808595569,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=431,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar75);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "30-Jan-0001"+ "'", str76.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str77 + "' != '" + "Fri 30-Jan-0001"+ "'", str77.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar85);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b86 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData87);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str88 + "' != '" + "unknown-month"+ "'", str88.equals("unknown-month"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i89 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b90 == true);

  }

  @Test
  public void test035() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test035"); }


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
    net.ajaskey.market.ta.TickerData tickerData28 = new net.ajaskey.market.ta.TickerData();
    java.lang.Double d29 = tickerData28.getSma130();
    double[] d_array30 = tickerData28.getLowData();
    double d31 = tickerData28.getChg23();
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    net.ajaskey.market.ta.DailyData dailyData43 = new net.ajaskey.market.ta.DailyData(calendar35, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d44 = dailyData43.getTrueHigh();
    java.lang.String str45 = dailyData43.toString();
    java.lang.Double d46 = dailyData43.getOpen();
    dailyData43.setVolume((double)1L);
    java.lang.String str49 = dailyData43.toString();
    tickerData28.addData(dailyData43);
    double d51 = dailyData43.getDailyPercentChg();
    java.lang.Double d52 = dailyData43.getClose();
    tickerData0.addData(dailyData43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "30-Jan-0001"+ "'", str17.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "Fri 30-Jan-0001"+ "'", str25.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d44 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str45.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d46 + "' != '" + 0.0d+ "'", d46.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str49 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     1     0      1.00      0.00"+ "'", str49.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     1     0      1.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d51 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d52 + "' != '" + 1.0d+ "'", d52.equals(1.0d));

  }

  @Test
  public void test036() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test036"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLr260();
    double[] d_array8 = tickerData0.getTrueHighData();
    net.ajaskey.market.ta.DailyData dailyData12 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)' ', 0, (int)'a');
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData();
    double[] d_array14 = tickerData13.getVolumeData();
    double d15 = tickerData13.getChg65();
    int i19 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData13, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType20 = tickerData13.getSma130Trend();
    double[] d_array21 = tickerData13.getTrueHighData();
    double d22 = tickerData13.getLow260();
    java.util.Calendar calendar27 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate(calendar27);
    java.lang.String str29 = net.ajaskey.market.misc.Utils.stringDate2(calendar27);
    net.ajaskey.market.ta.TickerData tickerData36 = new net.ajaskey.market.ta.TickerData("hi!", calendar27, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str37 = tickerData36.getTickerExchange();
    java.util.Calendar calendar38 = null;
    net.ajaskey.market.ta.TickerData tickerData39 = new net.ajaskey.market.ta.TickerData();
    double[] d_array40 = tickerData39.getTrueLowData();
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    net.ajaskey.market.ta.DailyData dailyData47 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData39, calendar44);
    boolean b48 = net.ajaskey.market.misc.Utils.sameYear(calendar38, calendar44);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData50 = net.ajaskey.market.ta.TickerData.getSlice(tickerData36, calendar44, (int)(byte)(-1));
    java.util.Calendar calendar54 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str55 = net.ajaskey.market.misc.Utils.stringDate(calendar54);
    net.ajaskey.market.ta.DailyData dailyData62 = new net.ajaskey.market.ta.DailyData(calendar54, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar66 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    boolean b67 = net.ajaskey.market.misc.Utils.sameYear(calendar54, calendar66);
    boolean b68 = net.ajaskey.market.misc.Utils.sameYear(calendar44, calendar66);
    net.ajaskey.market.ta.DailyData dailyData69 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData13, calendar66);
    net.ajaskey.market.ta.DailyData dailyData70 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar66);
    int i74 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, 0, (-100), (int)(short)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i19 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d22 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "30-Jan-0001"+ "'", str28.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Fri 30-Jan-0001"+ "'", str29.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "Unknown"+ "'", str37.equals("Unknown"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array40);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b48 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar54);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str55 + "' != '" + "30-Jan-0001"+ "'", str55.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar66);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b67 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b68 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData69);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData70);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i74 == (-1));

  }

  @Test
  public void test037() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test037"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRawRs((double)100);
    long long8 = industryData0.getShares();
    double d9 = industryData0.getRawRsSt();
    double d10 = industryData0.getRawRs();
    industryData0.setPriceInRange260((double)0.0f);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long8 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 100.0d);

  }

  @Test
  public void test038() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test038"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    java.util.Calendar[] calendar_array10 = tickerData0.getDateData();
    tickerData0.rSort();
    double d12 = tickerData0.getRsi14();
    tickerData0.rSort();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(calendar_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test039() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test039"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    java.lang.Double d3 = tickerData0.getSmaPerc23();
    java.lang.Double d4 = tickerData0.getSmaPerc130();
    double d5 = tickerData0.getAvgVol65();
    double d6 = tickerData0.getChg260();
    java.util.Calendar calendar10 = net.ajaskey.market.misc.Utils.buildCalendar((int)(short)(-1), 0, (int)(short)1);
    net.ajaskey.market.ta.DailyData dailyData17 = new net.ajaskey.market.ta.DailyData(calendar10, (double)'#', (double)(byte)100, (double)(byte)(-1), (double)(short)(-1), (double)100, (double)(-1L));
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.getDayName(calendar21);
    net.ajaskey.market.ta.TickerData tickerData24 = new net.ajaskey.market.ta.TickerData();
    double[] d_array25 = tickerData24.getVolumeData();
    double d26 = tickerData24.getChg65();
    double[] d_array27 = tickerData24.getOiData();
    double d28 = tickerData24.getMfi65();
    java.util.Calendar calendar32 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str33 = net.ajaskey.market.misc.Utils.stringDate(calendar32);
    java.lang.String str34 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar32);
    net.ajaskey.market.ta.TickerData tickerData35 = null;
    net.ajaskey.market.ta.TickerData tickerData36 = new net.ajaskey.market.ta.TickerData();
    double[] d_array37 = tickerData36.getTrueLowData();
    java.util.Calendar calendar41 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str42 = net.ajaskey.market.misc.Utils.stringDate(calendar41);
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate2(calendar41);
    net.ajaskey.market.ta.DailyData dailyData44 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData36, calendar41);
    int i45 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData35, calendar41);
    boolean b46 = net.ajaskey.market.misc.Utils.sameYear(calendar32, calendar41);
    java.util.Calendar calendar50 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str51 = net.ajaskey.market.misc.Utils.stringDate(calendar50);
    java.lang.String str52 = net.ajaskey.market.misc.Utils.stringDate2(calendar50);
    int i53 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData24, calendar41, calendar50);
    java.util.Calendar calendar57 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str58 = net.ajaskey.market.misc.Utils.stringDate(calendar57);
    net.ajaskey.market.ta.DailyData dailyData65 = new net.ajaskey.market.ta.DailyData(calendar57, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar69 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    boolean b70 = net.ajaskey.market.misc.Utils.sameYear(calendar57, calendar69);
    long long71 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar50, calendar69);
    boolean b72 = net.ajaskey.market.misc.Utils.sameMonth(calendar21, calendar50);
    boolean b73 = net.ajaskey.market.misc.Utils.sameDate(calendar10, calendar21);
    java.util.Calendar calendar74 = null;
    java.util.Calendar calendar75 = net.ajaskey.market.misc.Utils.makeCopy(calendar74);
    boolean b76 = net.ajaskey.market.misc.Utils.sameDate(calendar10, calendar74);
    // The following exception was thrown during execution in test generation
    try {
    net.ajaskey.market.ta.DailyData dailyData77 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar74);
      org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException");
    } catch (java.lang.NullPointerException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.NullPointerException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "unknown-day"+ "'", str23.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d26 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str33 + "' != '" + "30-Jan-0001"+ "'", str33.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "java.util.GregorianCalendar[time=-62164808595304,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=696,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str34.equals("java.util.GregorianCalendar[time=-62164808595304,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=696,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar41);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str42 + "' != '" + "30-Jan-0001"+ "'", str42.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "Fri 30-Jan-0001"+ "'", str43.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b46 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "30-Jan-0001"+ "'", str51.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "Fri 30-Jan-0001"+ "'", str52.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i53 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar57);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "30-Jan-0001"+ "'", str58.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar69);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b70 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long71 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b72 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b73 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar75);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b76 == false);

  }

  @Test
  public void test040() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test040"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getMfi65();
    tickerData0.fillDataArrays((int)(byte)0, true);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str9 = tickerData0.DailyDataString((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);

  }

  @Test
  public void test041() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test041"); }


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
    double d13 = tickerData0.getMfi23();
    tickerData0.rSort();
    double d15 = tickerData0.getMfi14();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);

  }

  @Test
  public void test042() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test042"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double[] d_array8 = tickerData0.getTrueHighData();
    double d9 = tickerData0.getMfi14();
    double d10 = tickerData0.getAdx();
    double[] d_array11 = tickerData0.getTrueLowData();
    double d12 = tickerData0.getPriceOffLow260();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str14 = tickerData0.DailyDataString((int)(short)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test043() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test043"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double[] d_array3 = tickerData0.getTrueHighData();
    net.ajaskey.market.ta.TickerData tickerData4 = new net.ajaskey.market.ta.TickerData();
    double[] d_array5 = tickerData4.getVolumeData();
    double d6 = tickerData4.getChg65();
    double[] d_array7 = tickerData4.getOiData();
    double d8 = tickerData4.getMfi65();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    java.lang.String str14 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar12);
    net.ajaskey.market.ta.TickerData tickerData15 = null;
    net.ajaskey.market.ta.TickerData tickerData16 = new net.ajaskey.market.ta.TickerData();
    double[] d_array17 = tickerData16.getTrueLowData();
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.DailyData dailyData24 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData16, calendar21);
    int i25 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData15, calendar21);
    boolean b26 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar21);
    java.util.Calendar calendar30 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate(calendar30);
    java.lang.String str32 = net.ajaskey.market.misc.Utils.stringDate2(calendar30);
    int i33 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData4, calendar21, calendar30);
    net.ajaskey.market.ta.TickerData tickerData34 = new net.ajaskey.market.ta.TickerData();
    double[] d_array35 = tickerData34.getVolumeData();
    double d36 = tickerData34.getChg65();
    double[] d_array37 = tickerData34.getOiData();
    double d38 = tickerData34.getMfi65();
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar42);
    net.ajaskey.market.ta.TickerData tickerData45 = null;
    net.ajaskey.market.ta.TickerData tickerData46 = new net.ajaskey.market.ta.TickerData();
    double[] d_array47 = tickerData46.getTrueLowData();
    java.util.Calendar calendar51 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str52 = net.ajaskey.market.misc.Utils.stringDate(calendar51);
    java.lang.String str53 = net.ajaskey.market.misc.Utils.stringDate2(calendar51);
    net.ajaskey.market.ta.DailyData dailyData54 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData46, calendar51);
    int i55 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData45, calendar51);
    boolean b56 = net.ajaskey.market.misc.Utils.sameYear(calendar42, calendar51);
    java.util.Calendar calendar60 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str61 = net.ajaskey.market.misc.Utils.stringDate(calendar60);
    java.lang.String str62 = net.ajaskey.market.misc.Utils.stringDate2(calendar60);
    int i63 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData34, calendar51, calendar60);
    boolean b64 = net.ajaskey.market.misc.Utils.sameMonth(calendar21, calendar51);
    net.ajaskey.market.ta.DailyData dailyData65 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar21);
    double[] d_array66 = tickerData0.getTrueLowData();
    double d67 = tickerData0.getAvgVol20();
    double d68 = tickerData0.getChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "java.util.GregorianCalendar[time=-62164808595288,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=712,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str14.equals("java.util.GregorianCalendar[time=-62164808595288,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=712,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Fri 30-Jan-0001"+ "'", str23.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i25 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str31 + "' != '" + "30-Jan-0001"+ "'", str31.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str32 + "' != '" + "Fri 30-Jan-0001"+ "'", str32.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d36 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d38 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "java.util.GregorianCalendar[time=-62164808595288,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=712,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str44.equals("java.util.GregorianCalendar[time=-62164808595288,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=712,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "30-Jan-0001"+ "'", str52.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str53 + "' != '" + "Fri 30-Jan-0001"+ "'", str53.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData54);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i55 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b56 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar60);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str61 + "' != '" + "30-Jan-0001"+ "'", str61.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str62 + "' != '" + "Fri 30-Jan-0001"+ "'", str62.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i63 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b64 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array66);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d67 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d68 == 0.0d);

  }

  @Test
  public void test044() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test044"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    double d13 = dailyData11.getDailyRng();
    java.lang.Double d14 = dailyData11.getOi();
    long long15 = dailyData11.getDaysSinceBase();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long15 == 693934L);

  }

  @Test
  public void test045() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test045"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getChg65();
    tickerData0.fillDataArrays((int)(byte)(-1), false);
    net.ajaskey.market.ta.DailyData dailyData10 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, (int)'4', (int)(short)10, 0);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    java.lang.Double d13 = tickerData0.getSmaPerc23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d13);

  }

  @Test
  public void test046() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test046"); }


    java.lang.String str1 = net.ajaskey.market.misc.Utils.formatInt(35528L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "35,528"+ "'", str1.equals("35,528"));

  }

  @Test
  public void test047() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test047"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar(0, 100, 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);

  }

  @Test
  public void test048() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test048"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    dailyData11.setTrueLow(0.0d);
    double d14 = dailyData11.getDailyChg();
    java.lang.Double d15 = dailyData11.getOi();
    java.lang.Double d16 = dailyData11.getLow();
    double d17 = dailyData11.getTrueLow();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d16 + "' != '" + 0.0d+ "'", d16.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);

  }

  @Test
  public void test049() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test049"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    java.lang.Double d6 = tickerData0.getSma65();
    net.ajaskey.market.ta.input.Fundamentals fundamentals7 = tickerData0.getFundies();
    double d8 = tickerData0.getPriceInRng260();
    double d9 = tickerData0.getChg65();
    double d10 = tickerData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test050() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test050"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData4 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData6 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    net.ajaskey.market.ta.TickerData tickerData8 = net.ajaskey.market.ta.TickerData.getTickerData(list_tickerData6, "java.util.GregorianCalendar[time=-62164808644848,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=55,MILLISECOND=152,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    net.ajaskey.market.ta.TickerData.clearTickerData(list_tickerData6);
    net.ajaskey.market.ta.TickerData tickerData11 = net.ajaskey.market.ta.TickerData.getTickerData(list_tickerData6, "java.util.GregorianCalendar[time=-62164808644691,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=55,MILLISECOND=309,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(tickerData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(tickerData11);

  }

  @Test
  public void test051() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test051"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    java.lang.Double d14 = dailyData11.getVolume();
    java.util.Calendar calendar15 = dailyData11.getDate();
    double d16 = dailyData11.getDailyPercentChg();
    dailyData11.setVolume((double)2017L);
    java.util.Calendar calendar19 = dailyData11.getDate();
    java.lang.Double d20 = dailyData11.getLow();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d20 + "' != '" + 0.0d+ "'", d20.equals(0.0d));

  }

  @Test
  public void test052() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test052"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double d14 = tickerData13.getChg65();
    double d15 = tickerData13.getLrAngle260();
    double d16 = tickerData13.getRsRaw();
    int i20 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData13, (int)(short)100, (int)(byte)(-1), (int)'#');
    double d21 = tickerData13.getAtr23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Fri 30-Jan-0001"+ "'", str6.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i20 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);

  }

  @Test
  public void test053() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test053"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    java.lang.Double d3 = derivedData0.getSma65();
    double d4 = derivedData0.getCurrentPrice();
    java.lang.Double d5 = derivedData0.getSma23();
    java.lang.Double d6 = derivedData0.getSmaPerc23();
    java.lang.Double d7 = derivedData0.getSmaPerc65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));

  }

  @Test
  public void test054() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test054"); }


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
    double d13 = tickerData0.getRsRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);

  }

  @Test
  public void test055() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test055"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260(10.0d);
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808648342,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=658,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str12 = industryData0.getTicker();
    java.lang.String str13 = industryData0.getMarketCap();
    java.lang.String str14 = industryData0.getExch();
    java.util.List<java.lang.Integer> list_i15 = industryData0.getRank();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str13.equals("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "java.util.GregorianCalendar[time=-62164808648342,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=658,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str14.equals("java.util.GregorianCalendar[time=-62164808648342,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=658,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i15);

  }

  @Test
  public void test056() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test056"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    java.lang.String str14 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar12);
    net.ajaskey.market.ta.TickerData tickerData15 = null;
    net.ajaskey.market.ta.TickerData tickerData16 = new net.ajaskey.market.ta.TickerData();
    double[] d_array17 = tickerData16.getTrueLowData();
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.DailyData dailyData24 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData16, calendar21);
    int i25 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData15, calendar21);
    boolean b26 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar21);
    net.ajaskey.market.ta.TickerData tickerData27 = new net.ajaskey.market.ta.TickerData();
    double[] d_array28 = tickerData27.getVolumeData();
    double d29 = tickerData27.getChg65();
    double[] d_array30 = tickerData27.getOiData();
    double d31 = tickerData27.getMfi65();
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar35);
    net.ajaskey.market.ta.TickerData tickerData38 = null;
    net.ajaskey.market.ta.TickerData tickerData39 = new net.ajaskey.market.ta.TickerData();
    double[] d_array40 = tickerData39.getTrueLowData();
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    net.ajaskey.market.ta.DailyData dailyData47 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData39, calendar44);
    int i48 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData38, calendar44);
    boolean b49 = net.ajaskey.market.misc.Utils.sameYear(calendar35, calendar44);
    java.util.Calendar calendar53 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str54 = net.ajaskey.market.misc.Utils.stringDate(calendar53);
    java.lang.String str55 = net.ajaskey.market.misc.Utils.stringDate2(calendar53);
    int i56 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData27, calendar44, calendar53);
    net.ajaskey.market.ta.TickerData tickerData57 = new net.ajaskey.market.ta.TickerData();
    double[] d_array58 = tickerData57.getVolumeData();
    double d59 = tickerData57.getChg65();
    double[] d_array60 = tickerData57.getOiData();
    double d61 = tickerData57.getMfi65();
    java.util.Calendar calendar65 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate(calendar65);
    java.lang.String str67 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar65);
    net.ajaskey.market.ta.TickerData tickerData68 = null;
    net.ajaskey.market.ta.TickerData tickerData69 = new net.ajaskey.market.ta.TickerData();
    double[] d_array70 = tickerData69.getTrueLowData();
    java.util.Calendar calendar74 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str75 = net.ajaskey.market.misc.Utils.stringDate(calendar74);
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate2(calendar74);
    net.ajaskey.market.ta.DailyData dailyData77 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData69, calendar74);
    int i78 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData68, calendar74);
    boolean b79 = net.ajaskey.market.misc.Utils.sameYear(calendar65, calendar74);
    java.util.Calendar calendar83 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str84 = net.ajaskey.market.misc.Utils.stringDate(calendar83);
    java.lang.String str85 = net.ajaskey.market.misc.Utils.stringDate2(calendar83);
    int i86 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData57, calendar74, calendar83);
    boolean b87 = net.ajaskey.market.misc.Utils.sameMonth(calendar44, calendar74);
    boolean b88 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar74);
    int i89 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, calendar74);
    double[] d_array90 = tickerData0.getTrueHighData();
    double d91 = tickerData0.getLr260();
    double d92 = tickerData0.getAdx();
    double d93 = tickerData0.getLrInt260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str14.equals("java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Fri 30-Jan-0001"+ "'", str23.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i25 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str37.equals("java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array40);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i48 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b49 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar53);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str54 + "' != '" + "30-Jan-0001"+ "'", str54.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str55 + "' != '" + "Fri 30-Jan-0001"+ "'", str55.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i56 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array58);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d59 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array60);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d61 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "30-Jan-0001"+ "'", str66.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str67.equals("java.util.GregorianCalendar[time=-62164808595132,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=868,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array70);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar74);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str75 + "' != '" + "30-Jan-0001"+ "'", str75.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "Fri 30-Jan-0001"+ "'", str76.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData77);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i78 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b79 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar83);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str84 + "' != '" + "30-Jan-0001"+ "'", str84.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str85 + "' != '" + "Fri 30-Jan-0001"+ "'", str85.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i86 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b87 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b88 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i89 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array90);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d91 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d92 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d93 == 0.0d);

  }

  @Test
  public void test057() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test057"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    java.lang.Double d6 = tickerData0.getSma65();
    java.lang.Double d7 = tickerData0.getSma65();
    double d8 = tickerData0.getAvgVol20();
    double d9 = tickerData0.getAtrPercent23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test058() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test058"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d11 = industryData0.getAvgVol();
    industryData0.setRawRsSt((double)(short)100);
    java.lang.String str14 = industryData0.getExch();
    industryData0.setRank(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str14);

  }

  @Test
  public void test059() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test059"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.util.Calendar calendar14 = null;
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getTrueLowData();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.DailyData dailyData23 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar20);
    boolean b24 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar20);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    net.ajaskey.market.misc.Utils.printCalendar(calendar20);
    java.util.Calendar calendar30 = net.ajaskey.market.misc.Utils.buildCalendar(10, 10, 100);
    long long31 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar20, calendar30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Fri 30-Jan-0001"+ "'", str22.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long31 == 4027L);

  }

  @Test
  public void test060() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test060"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getRsRaw();
    double d6 = derivedData0.getDiPlus();
    double d7 = derivedData0.getHigh260();
    double d8 = derivedData0.getPriceOffLow260();
    net.ajaskey.market.ta.TickerData tickerData9 = new net.ajaskey.market.ta.TickerData();
    double[] d_array10 = tickerData9.getVolumeData();
    double d11 = tickerData9.getChg65();
    int i15 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType16 = tickerData9.getSma130Trend();
    net.ajaskey.market.ta.TickerData tickerData17 = new net.ajaskey.market.ta.TickerData();
    double[] d_array18 = tickerData17.getVolumeData();
    double d19 = tickerData17.getChg65();
    double[] d_array20 = tickerData17.getOiData();
    double d21 = tickerData17.getMfi65();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData9, tickerData17);
    double[] d_array23 = tickerData17.getTypicalPriceData();
    // The following exception was thrown during execution in test generation
    try {
    derivedData0.build(tickerData17);
      org.junit.Assert.fail("Expected exception of type java.lang.NoClassDefFoundError");
    } catch (java.lang.NoClassDefFoundError e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.NoClassDefFoundError")) {
        org.junit.Assert.fail("Expected exception of type java.lang.NoClassDefFoundError, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array23);

  }

  @Test
  public void test061() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test061"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar12 = dailyData11.getDate();
    net.ajaskey.market.misc.Utils.printCalendar(calendar12);
    net.ajaskey.market.ta.TickerData tickerData14 = new net.ajaskey.market.ta.TickerData();
    double[] d_array15 = tickerData14.getVolumeData();
    double d16 = tickerData14.getChg65();
    tickerData14.setTicker("hi!");
    double[] d_array19 = tickerData14.getOiData();
    double d20 = tickerData14.getDiMinus();
    tickerData14.setTicker("hi!");
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar30 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate(calendar30);
    java.lang.String str32 = net.ajaskey.market.misc.Utils.stringDate2(calendar30);
    boolean b33 = net.ajaskey.market.misc.Utils.sameYear(calendar26, calendar30);
    java.lang.String str34 = net.ajaskey.market.misc.Utils.getString(calendar30);
    java.lang.String str35 = net.ajaskey.market.misc.Utils.getString(calendar30);
    net.ajaskey.market.ta.DailyData dailyData36 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData14, calendar30);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.stringDate2(calendar30);
    long long38 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar12, calendar30);
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate(calendar42);
    net.ajaskey.market.ta.DailyData dailyData50 = new net.ajaskey.market.ta.DailyData(calendar42, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str51 = net.ajaskey.market.misc.Utils.stringDate2(calendar42);
    long long52 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar12, calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str31 + "' != '" + "30-Jan-0001"+ "'", str31.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str32 + "' != '" + "Fri 30-Jan-0001"+ "'", str32.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b33 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "30-Jan-0001"+ "'", str34.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "Fri 30-Jan-0001"+ "'", str37.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long38 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "Fri 30-Jan-0001"+ "'", str51.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long52 == 0L);

  }

  @Test
  public void test062() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test062"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getMfi130();
    java.lang.Double d6 = derivedData0.getSmaPerc260();
    double d7 = derivedData0.getChg();
    double d8 = derivedData0.getDiMinus();
    double d9 = derivedData0.getLrInt260();
    double d10 = derivedData0.getMfi65();
    java.lang.Double d11 = derivedData0.getSma130();
    double d12 = derivedData0.getLrAngle260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d11 + "' != '" + 0.0d+ "'", d11.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test063() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test063"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    java.lang.String str9 = tickerData0.getTickerName();
    java.lang.Double d10 = tickerData0.getSma130();
    double d11 = tickerData0.getAdx();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test064() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test064"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d11 = industryData0.getAvgVol();
    industryData0.setShares((long)(short)100);
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808649606,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=50,MILLISECOND=394,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808643457,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=56,MILLISECOND=543,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str18 = industryData0.getName();
    // The following exception was thrown during execution in test generation
    try {
    int i20 = industryData0.getRank((int)(short)(-1));
      org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException");
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArrayIndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str18);

  }

  @Test
  public void test065() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test065"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    java.lang.Double d10 = tickerData0.getSmaPerc260();
    double[] d_array11 = tickerData0.getCloseData();
    java.lang.Double d12 = tickerData0.getSmaPerc65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d12);

  }

  @Test
  public void test066() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test066"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double[] d_array7 = tickerData0.getCloseData();
    double[] d_array8 = tickerData0.getTrueLowData();
    double[] d_array9 = tickerData0.getLowData();
    double d10 = tickerData0.getAvgVol65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test067() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test067"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    double d14 = dailyData11.getDailyRng();
    java.lang.Double d15 = dailyData11.getOpen();
    double d16 = dailyData11.getDailyPercentChg();
    double d17 = dailyData11.getDailyPercentRng();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);

  }

  @Test
  public void test068() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test068"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    tickerData0.rSort();
    double d4 = tickerData0.getChg130();
    tickerData0.setTickerExchange("NotFound");
    double d7 = tickerData0.getLrAngle260();
    double d8 = tickerData0.getChg23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test069() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test069"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    double d3 = industryData0.getAvgVol();
    industryData0.setAvgVol((double)100);
    double d6 = industryData0.getRawRsSt();
    industryData0.setSlope((double)(short)0);
    industryData0.setChg260(0.0d);
    java.lang.String str11 = industryData0.getName();
    industryData0.setName("java.util.GregorianCalendar[time=-62164808650011,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=989,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str11);

  }

  @Test
  public void test070() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test070"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d6 = industryData0.getChg260();
    java.lang.String str7 = industryData0.getExch();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == (-1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str7);

  }

  @Test
  public void test071() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test071"); }


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
    java.util.Calendar calendar18 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate(calendar18);
    net.ajaskey.market.ta.DailyData dailyData26 = new net.ajaskey.market.ta.DailyData(calendar18, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar27 = dailyData26.getDate();
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate(calendar27);
    java.util.Calendar calendar29 = net.ajaskey.market.misc.Utils.makeCopy(calendar27);
    int i30 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, calendar29);
    double d31 = tickerData0.getRsRaw();
    java.lang.Double d32 = tickerData0.getSma65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "30-Jan-0001"+ "'", str19.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "30-Jan-0001"+ "'", str28.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d32);

  }

  @Test
  public void test072() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test072"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    double d2 = derivedData0.getChg65();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsStRaw();
    double d5 = derivedData0.getAvgVol65();
    double d6 = derivedData0.getAvgVol20();
    double d7 = derivedData0.getRsStRaw();
    java.lang.Double d8 = derivedData0.getSma65();
    double d9 = derivedData0.getLrAngle260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test073() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test073"); }


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
    double d12 = tickerData0.getLrAngle260();
    double[] d_array13 = tickerData0.getOiData();
    double d14 = tickerData0.getAtrPercent23();
    double[] d_array15 = tickerData0.getCloseData();
    double d16 = tickerData0.getAdx();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);

  }

  @Test
  public void test074() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test074"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    industryData0.setTicker("0");
    industryData0.setSlope((double)100.0f);
    java.lang.String str7 = industryData0.getTicker();
    industryData0.setSlope((double)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "0"+ "'", str7.equals("0"));

  }

  @Test
  public void test075() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test075"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getName();
    java.lang.String str7 = industryData0.getExch();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str7);

  }

  @Test
  public void test076() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test076"); }


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
    java.lang.String str15 = tickerData0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "null\tnull\tnull\r\n"+ "'", str14.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "null\tnull\tnull\r\n"+ "'", str15.equals("null\tnull\tnull\r\n"));

  }

  @Test
  public void test077() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test077"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSmaPerc260();
    double d4 = derivedData0.getAvgVol65();
    double d5 = derivedData0.getAtrPercent23();
    double d6 = derivedData0.getPriceOffHigh260();
    double d7 = derivedData0.getAtrPercent23();
    java.lang.Double d8 = derivedData0.getSmaPerc65();
    double d9 = derivedData0.getMfi65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test078() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test078"); }


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
    net.ajaskey.market.ta.DailyData dailyData39 = new net.ajaskey.market.ta.DailyData(calendar29, (double)100.0f, (double)10.0f, (double)1L, (double)1.0f, 100.0d, (double)(short)100);
    net.ajaskey.market.ta.DailyData dailyData46 = new net.ajaskey.market.ta.DailyData(calendar29, 1.0d, (double)10L, (double)10L, (double)10, (double)' ', (double)(-1L));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d23 + "' != '" + 1.0d+ "'", d23.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "30-Jan-0001"+ "'", str30.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Fri 30-Jan-0001"+ "'", str31.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(dailyData32);

  }

  @Test
  public void test079() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test079"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSma23();
    double d6 = derivedData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test080() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test080"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    double d3 = industryData0.getAvgVol();
    java.lang.String str4 = industryData0.getRanks();
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808646455,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=53,MILLISECOND=545,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setRawRs((double)'4');
    industryData0.setRawRs(32.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));

  }

  @Test
  public void test081() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test081"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSmaPerc260();
    double d4 = derivedData0.getAvgVol65();
    double d5 = derivedData0.getAtrPercent23();
    double d6 = derivedData0.getPriceOffHigh260();
    double d7 = derivedData0.getAtrPercent23();
    java.lang.Double d8 = derivedData0.getSma130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));

  }

  @Test
  public void test082() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test082"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    double d8 = industryData0.getPriceInRange260();
    industryData0.setRawRsSt(100.0d);
    java.lang.String str11 = industryData0.getSector();
    industryData0.setShares((long)'a');
    java.lang.String str14 = industryData0.getMarketCap();
    industryData0.setPriceInRange260((double)(-1L));
    double d17 = industryData0.getRawRs();
    java.util.List<java.lang.Integer> list_i18 = industryData0.getRank();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i18);

  }

  @Test
  public void test083() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test083"); }


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
    java.util.Calendar calendar13 = null;
    net.ajaskey.market.ta.DailyData dailyData14 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar13);
    double d15 = tickerData0.getChg65();
    double d16 = tickerData0.getRsi14();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    net.ajaskey.market.ta.DailyData dailyData28 = new net.ajaskey.market.ta.DailyData(calendar20, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d29 = dailyData28.getClose();
    double d30 = dailyData28.getDailyPercentChg();
    double d31 = dailyData28.getTrueLow();
    tickerData0.addData(dailyData28);
    java.lang.Double d33 = dailyData28.getHigh();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d29 + "' != '" + 1.0d+ "'", d29.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d30 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d33 + "' != '" + 10.0d+ "'", d33.equals(10.0d));

  }

  @Test
  public void test084() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test084"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    java.lang.String str13 = dailyData11.toString();
    double d14 = dailyData11.getTrueHigh();
    double d15 = dailyData11.getDailyChg();
    double d16 = dailyData11.getDailyPercentChg();
    double d17 = dailyData11.getTrueHigh();
    java.lang.Double d18 = dailyData11.getOi();
    java.lang.String str19 = dailyData11.toString();
    double d20 = dailyData11.getDailyPercentChg();
    java.util.Calendar calendar21 = dailyData11.getDate();
    double d22 = dailyData11.getDailyRng();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str13.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d18 + "' != '" + 0.0d+ "'", d18.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str19.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d22 == 0.0d);

  }

  @Test
  public void test085() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test085"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    java.lang.Double d3 = derivedData0.getSmaPerc260();
    double d4 = derivedData0.getHigh260();
    double d5 = derivedData0.getChg();
    double d6 = derivedData0.getRsStRaw();
    double d7 = derivedData0.getPriceOffHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test086() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test086"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    industryData0.setName("Unknown");
    java.lang.String str5 = industryData0.getSector();
    industryData0.setChg260((double)10.0f);
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808648763,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=237,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str10 = industryData0.getExch();
    industryData0.setRawRsSt((double)(byte)100);
    industryData0.setRank(100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);

  }

  @Test
  public void test087() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test087"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double d11 = tickerData0.getLow260();
    net.ajaskey.market.ta.input.Fundamentals fundamentals12 = tickerData0.getFundies();
    double d13 = tickerData0.getRsi14();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);

  }

  @Test
  public void test088() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test088"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getDailyPercentChg();
    double d14 = dailyData11.getDailyPercentRng();
    java.lang.Double d15 = dailyData11.getLow();
    java.lang.Double d16 = dailyData11.getOpen();
    dailyData11.setTrueHigh(10.0d);
    java.lang.String str19 = dailyData11.toString();
    java.lang.Double d20 = dailyData11.getOi();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d16 + "' != '" + 0.0d+ "'", d16.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str19.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d20 + "' != '" + 0.0d+ "'", d20.equals(0.0d));

  }

  @Test
  public void test089() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test089"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.util.Calendar calendar14 = null;
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getTrueLowData();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.DailyData dailyData23 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar20);
    boolean b24 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar20);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808650620,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=380,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d28 = tickerData0.getAtrPercent23();
    double d29 = tickerData0.getAvgVol20();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Fri 30-Jan-0001"+ "'", str22.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);

  }

  @Test
  public void test090() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test090"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    double d3 = industryData0.getAvgVol();
    double d4 = industryData0.getChg260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == (-1.0d));

  }

  @Test
  public void test091() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test091"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "30-Jan-0001" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'#');
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData7 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(short)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);

  }

  @Test
  public void test092() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test092"); }


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
    java.lang.Double d23 = dailyData20.getOpen();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d23 + "' != '" + 0.0d+ "'", d23.equals(0.0d));

  }

  @Test
  public void test093() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test093"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str14 = tickerData13.getTickerExchange();
    double d15 = tickerData13.getAvgVol20();
    java.lang.Integer i16 = tickerData13.getDaysOfData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Fri 30-Jan-0001"+ "'", str6.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Unknown"+ "'", str14.equals("Unknown"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i16 + "' != '" + 0+ "'", i16.equals(0));

  }

  @Test
  public void test094() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test094"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    industryData0.setName("java.util.GregorianCalendar[time=-62164808651587,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=413,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260((double)10);
    long long12 = industryData0.getShares();
    industryData0.setRawRsSt((double)100.0f);
    double d15 = industryData0.getAvgVol();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long12 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);

  }

  @Test
  public void test095() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test095"); }


    // The following exception was thrown during execution in test generation
    try {
    net.ajaskey.market.ta.TickerData tickerData1 = net.ajaskey.market.ta.input.ParseData.parseOneFile("java.util.GregorianCalendar[time=-62164808637771,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=2,MILLISECOND=229,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
      org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException");
    } catch (java.io.FileNotFoundException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.io.FileNotFoundException")) {
        org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException, got " + e.getClass().getCanonicalName());
      }
    }

  }

  @Test
  public void test096() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test096"); }


    net.ajaskey.market.ta.TickerData tickerData1 = null;
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    net.ajaskey.market.ta.DailyData dailyData13 = new net.ajaskey.market.ta.DailyData(calendar5, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData14 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData1, calendar5);
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.util.Calendar calendar16 = null;
    net.ajaskey.market.ta.TickerData tickerData17 = new net.ajaskey.market.ta.TickerData();
    double[] d_array18 = tickerData17.getTrueLowData();
    java.util.Calendar calendar22 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate(calendar22);
    java.lang.String str24 = net.ajaskey.market.misc.Utils.stringDate2(calendar22);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData17, calendar22);
    boolean b26 = net.ajaskey.market.misc.Utils.sameYear(calendar16, calendar22);
    java.util.Calendar calendar31 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str32 = net.ajaskey.market.misc.Utils.stringDate(calendar31);
    java.lang.String str33 = net.ajaskey.market.misc.Utils.stringDate2(calendar31);
    net.ajaskey.market.ta.TickerData tickerData40 = new net.ajaskey.market.ta.TickerData("hi!", calendar31, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar41 = net.ajaskey.market.misc.Utils.makeCopy(calendar31);
    boolean b42 = net.ajaskey.market.misc.Utils.sameDate(calendar16, calendar31);
    boolean b43 = net.ajaskey.market.misc.Utils.sameDate(calendar5, calendar31);
    java.lang.String str44 = net.ajaskey.market.misc.Utils.getMonthName(calendar5);
    net.ajaskey.market.ta.TickerData tickerData51 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808638102,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=1,MILLISECOND=898,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar5, (double)'4', (double)'#', (double)(short)10, (double)(short)1, 52.0d, 0.0d);
    java.lang.String str52 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "30-Jan-0001"+ "'", str23.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "Fri 30-Jan-0001"+ "'", str24.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str32 + "' != '" + "30-Jan-0001"+ "'", str32.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str33 + "' != '" + "Fri 30-Jan-0001"+ "'", str33.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar41);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b42 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b43 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "unknown-month"+ "'", str44.equals("unknown-month"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "Fri 30-Jan-0001"+ "'", str52.equals("Fri 30-Jan-0001"));

  }

  @Test
  public void test097() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test097"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Double d2 = tickerData0.getSma130();
    double[] d_array3 = tickerData0.getVolumeData();
    double d4 = tickerData0.getDiMinus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);

  }

  @Test
  public void test098() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test098"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getMfi14();
    double d11 = tickerData0.getChg65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test099() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test099"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    java.lang.Double d5 = derivedData0.getSmaPerc260();
    double d6 = derivedData0.getRsRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test100() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test100"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank(0);
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808651930,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=70,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str10 = industryData0.getName();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);

  }

  @Test
  public void test101() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test101"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getDailyPercentChg();
    java.util.Calendar calendar14 = dailyData11.getDate();
    dailyData11.setTrueHigh((-1.0d));
    dailyData11.setVolume((double)(byte)100);
    dailyData11.setTrueHigh((double)(short)10);
    java.lang.String str21 = dailyData11.toString();
    dailyData11.setDailyChg((double)693934L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00   100     0    100.00      0.00"+ "'", str21.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00   100     0    100.00      0.00"));

  }

  @Test
  public void test102() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test102"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRawRs((double)100);
    java.util.List<java.lang.Integer> list_i6 = industryData0.getRank();
    java.lang.String str7 = industryData0.getMarketCap();
    double d8 = industryData0.getAvgVol();
    long long9 = industryData0.getfShares();
    double d10 = industryData0.getRawRs();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long9 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 100.0d);

  }

  @Test
  public void test103() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test103"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array9 = tickerData0.getTrueHighData();
    java.lang.String str10 = tickerData0.getTickerExchange();
    double d11 = tickerData0.getLow260();
    double d12 = tickerData0.getAvgVol20();
    double d13 = tickerData0.getMfi130();
    double d14 = tickerData0.getMfi65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);

  }

  @Test
  public void test104() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test104"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma260Trend();
    double d9 = tickerData0.getChg65();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double d11 = tickerData0.getRsi14();
    java.lang.String str12 = tickerData0.getTicker();
    double d13 = tickerData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "HI!"+ "'", str7.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "HI!"+ "'", str12.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);

  }

  @Test
  public void test105() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test105"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double[] d_array9 = tickerData0.getOiData();
    double[] d_array10 = tickerData0.getOiData();
    double d11 = tickerData0.getLow260();
    java.lang.Double d12 = tickerData0.getSma260();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    net.ajaskey.market.ta.TrendType trendType15 = tickerData0.getSma23Trend();
    double d16 = tickerData0.getRsRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);

  }

  @Test
  public void test106() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test106"); }


    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str1 = net.ajaskey.market.ta.input.ParseData.getTickerList("java.util.GregorianCalendar[time=-62164808595803,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=44,MILLISECOND=197,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
      org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException");
    } catch (java.io.FileNotFoundException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.io.FileNotFoundException")) {
        org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException, got " + e.getClass().getCanonicalName());
      }
    }

  }

  @Test
  public void test107() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test107"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double d9 = tickerData0.getDiPlus();
    double d10 = tickerData0.getLrAngle260();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test108() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test108"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSma130();
    java.lang.Double d4 = derivedData0.getSmaPerc65();
    double d5 = derivedData0.getLrInt260();
    double d6 = derivedData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test109() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test109"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double d3 = tickerData0.getPriceInRng260();
    int i4 = tickerData0.getDataCount();
    double d5 = tickerData0.getMfi14();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);

  }

  @Test
  public void test110() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test110"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    int i7 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)'#', (int)(short)10, (int)(byte)0);
    java.lang.String str8 = tickerData0.getTickerName();
    double d9 = tickerData0.getDiPlus();
    java.lang.Double d10 = tickerData0.getSmaPerc130();
    double[] d_array11 = tickerData0.getVolumeData();
    double[] d_array12 = tickerData0.getHighData();
    double d13 = tickerData0.getLow260();
    net.ajaskey.market.ta.TickerData tickerData14 = new net.ajaskey.market.ta.TickerData();
    double[] d_array15 = tickerData14.getTrueLowData();
    double d16 = tickerData14.getCurrentPrice();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    net.ajaskey.market.ta.DailyData dailyData28 = new net.ajaskey.market.ta.DailyData(calendar20, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d29 = dailyData28.getHigh();
    java.lang.Double d30 = dailyData28.getOpen();
    tickerData14.addData(dailyData28);
    double d32 = dailyData28.getDailyPercentChg();
    dailyData28.setTrueLow((double)100);
    tickerData0.addData(dailyData28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d29 + "' != '" + 10.0d+ "'", d29.equals(10.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d30 + "' != '" + 0.0d+ "'", d30.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d32 == 0.0d);

  }

  @Test
  public void test111() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test111"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d6 = industryData0.getChg260();
    industryData0.setChg260((double)100L);
    long long9 = industryData0.getShares();
    double d10 = industryData0.getRawRsSt();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == (-1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long9 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test112() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test112"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getDailyPercentChg();
    double d14 = dailyData11.getDailyPercentRng();
    java.lang.Double d15 = dailyData11.getLow();
    java.lang.Double d16 = dailyData11.getOpen();
    double d17 = dailyData11.getDailyRng();
    double d18 = dailyData11.getTrueHigh();
    java.lang.Double d19 = dailyData11.getOi();
    double d20 = dailyData11.getTrueHigh();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d16 + "' != '" + 0.0d+ "'", d16.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d19 + "' != '" + 0.0d+ "'", d19.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);

  }

  @Test
  public void test113() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test113"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData18 = new net.ajaskey.market.ta.DailyData(calendar3, (double)1L, (double)' ', 1.0d, 1.0d, (double)(short)(-1), (double)(byte)0);
    double d19 = dailyData18.getDailyChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);

  }

  @Test
  public void test114() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test114"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double d7 = tickerData0.getChg23();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test115() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test115"); }


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
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808644926,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=55,MILLISECOND=74,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.Double d15 = tickerData0.getSma23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d15);

  }

  @Test
  public void test116() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test116"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    double d7 = tickerData0.getLr260();
    double[] d_array8 = tickerData0.getTrueHighData();
    tickerData0.fillDataArrays(1, false);
    double[] d_array12 = tickerData0.getTrueHighData();
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData();
    double[] d_array14 = tickerData13.getVolumeData();
    double d15 = tickerData13.getChg65();
    double[] d_array16 = tickerData13.getOiData();
    double d17 = tickerData13.getMfi65();
    tickerData13.fillDataArrays((int)(byte)0, true);
    java.lang.String str21 = tickerData13.toString();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData0, tickerData13);
    double d23 = tickerData0.getPriceOffLow260();
    double d24 = tickerData0.getLow260();
    double d25 = tickerData0.getRsRaw();
    double d26 = tickerData0.getCurrentPrice();
    double d27 = tickerData0.getRsStRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "null\tnull\tnull\r\n"+ "'", str21.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d23 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d25 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d26 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d27 == 0.0d);

  }

  @Test
  public void test117() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test117"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    java.lang.String str13 = dailyData11.toString();
    double d14 = dailyData11.getTrueHigh();
    double d15 = dailyData11.getDailyChg();
    double d16 = dailyData11.getDailyPercentChg();
    double d17 = dailyData11.getTrueHigh();
    dailyData11.setTrueHigh((double)1.0f);
    double d20 = dailyData11.getDailyRng();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str13.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);

  }

  @Test
  public void test118() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test118"); }


    net.ajaskey.market.ta.TickerData tickerData0 = null;
    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    net.ajaskey.market.ta.DailyData dailyData12 = new net.ajaskey.market.ta.DailyData(calendar4, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d13 = dailyData12.getClose();
    double d14 = dailyData12.getDailyPercentChg();
    java.util.Calendar calendar15 = dailyData12.getDate();
    java.util.Calendar calendar19 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.makeCopy(calendar19);
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.makeCopy(calendar19);
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate2(calendar26);
    net.ajaskey.market.ta.TickerData tickerData35 = new net.ajaskey.market.ta.TickerData("hi!", calendar26, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar36 = net.ajaskey.market.misc.Utils.makeCopy(calendar26);
    long long37 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar21, calendar26);
    long long38 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar15, calendar21);
    java.util.Calendar calendar39 = net.ajaskey.market.misc.Utils.makeCopy(calendar15);
    net.ajaskey.market.ta.TickerData tickerData40 = null;
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    net.ajaskey.market.ta.DailyData dailyData52 = new net.ajaskey.market.ta.DailyData(calendar44, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d53 = dailyData52.getClose();
    double d54 = dailyData52.getDailyPercentChg();
    java.util.Calendar calendar55 = dailyData52.getDate();
    java.util.Calendar calendar59 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar60 = net.ajaskey.market.misc.Utils.makeCopy(calendar59);
    java.util.Calendar calendar61 = net.ajaskey.market.misc.Utils.makeCopy(calendar59);
    java.util.Calendar calendar66 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str67 = net.ajaskey.market.misc.Utils.stringDate(calendar66);
    java.lang.String str68 = net.ajaskey.market.misc.Utils.stringDate2(calendar66);
    net.ajaskey.market.ta.TickerData tickerData75 = new net.ajaskey.market.ta.TickerData("hi!", calendar66, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar76 = net.ajaskey.market.misc.Utils.makeCopy(calendar66);
    long long77 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar61, calendar66);
    long long78 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar55, calendar61);
    net.ajaskey.market.ta.DailyData dailyData79 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData40, calendar61);
    int i80 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData0, calendar39, calendar61);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d13 + "' != '" + 1.0d+ "'", d13.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Fri 30-Jan-0001"+ "'", str28.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long37 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long38 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar39);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d53 + "' != '" + 1.0d+ "'", d53.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d54 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar55);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar59);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar60);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar61);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar66);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "30-Jan-0001"+ "'", str67.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str68 + "' != '" + "Fri 30-Jan-0001"+ "'", str68.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar76);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long77 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long78 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData79);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i80 == 0);

  }

  @Test
  public void test119() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test119"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getLow260();
    double d8 = tickerData0.getDiMinus();
    double d9 = tickerData0.getRsRaw();
    double d10 = tickerData0.getLow260();
    double d11 = tickerData0.getCurrentPrice();
    java.lang.String str12 = tickerData0.getTickerExchange();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str12);

  }

  @Test
  public void test120() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test120"); }


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
    double[] d_array15 = tickerData0.getHighData();
    net.ajaskey.market.ta.TrendType trendType16 = tickerData0.getSma260Trend();
    // The following exception was thrown during execution in test generation
    try {
    tickerData0.generateDerived(false);
      org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException");
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArrayIndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType16);

  }

  @Test
  public void test121() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test121"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    double d8 = industryData0.getPriceInRange260();
    java.lang.String str9 = industryData0.getTicker();
    industryData0.setChg260((double)100);
    industryData0.setName("java.util.GregorianCalendar[time=-62164808652183,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=817,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setSlope(0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str9);

  }

  @Test
  public void test122() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test122"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate2(calendar16);
    boolean b19 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar16);
    java.lang.String str20 = net.ajaskey.market.misc.Utils.getString(calendar16);
    java.lang.String str21 = net.ajaskey.market.misc.Utils.getString(calendar16);
    net.ajaskey.market.ta.DailyData dailyData22 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar16);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar16);
    java.lang.String str24 = net.ajaskey.market.misc.Utils.getDayName(calendar16);
    java.lang.String str25 = net.ajaskey.market.misc.Utils.getString(calendar16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "30-Jan-0001"+ "'", str17.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Fri 30-Jan-0001"+ "'", str18.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "30-Jan-0001"+ "'", str20.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Fri 30-Jan-0001"+ "'", str23.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "unknown-day"+ "'", str24.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "30-Jan-0001"+ "'", str25.equals("30-Jan-0001"));

  }

  @Test
  public void test123() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test123"); }


    net.ajaskey.market.misc.Utils.NL = "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     1     0      1.00      0.00";

  }

  @Test
  public void test124() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test124"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getChg65();
    double d3 = derivedData0.getLr260();
    double d4 = derivedData0.getMfi14();
    double d5 = derivedData0.getAvgVol20();
    double d6 = derivedData0.getCurrentPrice();
    double d7 = derivedData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test125() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test125"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData4 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData6 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)1);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData7 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData8 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData10 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, 1);
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData13 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)100);
    net.ajaskey.market.ta.TickerData.clearTickerData(list_tickerData13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData13);

  }

  @Test
  public void test126() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test126"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    java.lang.String str5 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar3);
    net.ajaskey.market.ta.TickerData tickerData6 = null;
    net.ajaskey.market.ta.TickerData tickerData7 = new net.ajaskey.market.ta.TickerData();
    double[] d_array8 = tickerData7.getTrueLowData();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    java.lang.String str14 = net.ajaskey.market.misc.Utils.stringDate2(calendar12);
    net.ajaskey.market.ta.DailyData dailyData15 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData7, calendar12);
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData6, calendar12);
    boolean b17 = net.ajaskey.market.misc.Utils.sameYear(calendar3, calendar12);
    net.ajaskey.market.ta.TickerData tickerData18 = new net.ajaskey.market.ta.TickerData();
    double[] d_array19 = tickerData18.getVolumeData();
    double d20 = tickerData18.getChg65();
    double[] d_array21 = tickerData18.getOiData();
    double d22 = tickerData18.getMfi65();
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar26);
    net.ajaskey.market.ta.TickerData tickerData29 = null;
    net.ajaskey.market.ta.TickerData tickerData30 = new net.ajaskey.market.ta.TickerData();
    double[] d_array31 = tickerData30.getTrueLowData();
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    net.ajaskey.market.ta.DailyData dailyData38 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData30, calendar35);
    int i39 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData29, calendar35);
    boolean b40 = net.ajaskey.market.misc.Utils.sameYear(calendar26, calendar35);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    int i47 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData18, calendar35, calendar44);
    net.ajaskey.market.ta.TickerData tickerData48 = new net.ajaskey.market.ta.TickerData();
    double[] d_array49 = tickerData48.getVolumeData();
    double d50 = tickerData48.getChg65();
    double[] d_array51 = tickerData48.getOiData();
    double d52 = tickerData48.getMfi65();
    java.util.Calendar calendar56 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str57 = net.ajaskey.market.misc.Utils.stringDate(calendar56);
    java.lang.String str58 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar56);
    net.ajaskey.market.ta.TickerData tickerData59 = null;
    net.ajaskey.market.ta.TickerData tickerData60 = new net.ajaskey.market.ta.TickerData();
    double[] d_array61 = tickerData60.getTrueLowData();
    java.util.Calendar calendar65 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate(calendar65);
    java.lang.String str67 = net.ajaskey.market.misc.Utils.stringDate2(calendar65);
    net.ajaskey.market.ta.DailyData dailyData68 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData60, calendar65);
    int i69 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData59, calendar65);
    boolean b70 = net.ajaskey.market.misc.Utils.sameYear(calendar56, calendar65);
    java.util.Calendar calendar74 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str75 = net.ajaskey.market.misc.Utils.stringDate(calendar74);
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate2(calendar74);
    int i77 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData48, calendar65, calendar74);
    boolean b78 = net.ajaskey.market.misc.Utils.sameMonth(calendar35, calendar65);
    boolean b79 = net.ajaskey.market.misc.Utils.sameYear(calendar3, calendar65);
    net.ajaskey.market.ta.DailyData dailyData86 = new net.ajaskey.market.ta.DailyData(calendar3, (double)10L, (double)693934L, 0.0d, (double)(short)100, 100.0d, (double)(byte)1);
    dailyData86.setTrueLow(1.0d);
    java.lang.Double d89 = dailyData86.getOpen();
    java.lang.Double d90 = dailyData86.getOpen();
    dailyData86.setDailyChg((double)100L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str5.equals("java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Fri 30-Jan-0001"+ "'", str14.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i16 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d22 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str28.equals("java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "Fri 30-Jan-0001"+ "'", str37.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b40 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i47 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array49);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d50 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d52 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str57 + "' != '" + "30-Jan-0001"+ "'", str57.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str58.equals("java.util.GregorianCalendar[time=-62164808594040,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=45,MILLISECOND=960,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array61);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "30-Jan-0001"+ "'", str66.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "Fri 30-Jan-0001"+ "'", str67.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i69 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b70 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar74);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str75 + "' != '" + "30-Jan-0001"+ "'", str75.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "Fri 30-Jan-0001"+ "'", str76.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i77 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b78 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b79 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d89 + "' != '" + 10.0d+ "'", d89.equals(10.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d90 + "' != '" + 10.0d+ "'", d90.equals(10.0d));

  }

  @Test
  public void test127() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test127"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260(10.0d);
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808651119,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=881,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808648342,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=658,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d12 = industryData0.getChg260();
    industryData0.setChg260((double)' ');
    industryData0.setPriceInRange260((double)1.0f);
    long long17 = industryData0.getfShares();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 10.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long17 == 0L);

  }

  @Test
  public void test128() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test128"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    double d3 = tickerData0.getPriceInRng260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    java.lang.String str6 = tickerData0.toString();
    double d7 = tickerData0.getChg260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "null\tnull\tnull\r\n"+ "'", str6.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test129() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test129"); }


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
    java.lang.Double d11 = tickerData0.getSmaPerc130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d11);

  }

  @Test
  public void test130() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test130"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    double d14 = dailyData11.getDailyRng();
    java.lang.Double d15 = dailyData11.getOpen();
    dailyData11.setVolume((double)(byte)0);
    double d18 = dailyData11.getDailyPercentRng();
    java.lang.Double d19 = dailyData11.getOpen();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d19 + "' != '" + 0.0d+ "'", d19.equals(0.0d));

  }

  @Test
  public void test131() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test131"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsi14();
    double d5 = derivedData0.getCurrentPrice();
    double d6 = derivedData0.getChg23();
    double d7 = derivedData0.getMfi14();
    double d8 = derivedData0.getPriceOffHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test132() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test132"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    double d2 = tickerData0.getCurrentPrice();
    double d3 = tickerData0.getAtr23();
    double d4 = tickerData0.getDiMinus();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);

  }

  @Test
  public void test133() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test133"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    double d3 = derivedData0.getChg65();
    double d4 = derivedData0.getChg130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);

  }

  @Test
  public void test134() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test134"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    net.ajaskey.market.ta.input.Fundamentals fundamentals2 = tickerData0.getFundies();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)(-1), 100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma23Trend();
    java.lang.Double d8 = tickerData0.getSma260();
    double d9 = tickerData0.getLrAngle260();
    double d10 = tickerData0.getAdx();
    double[] d_array11 = tickerData0.getOpenData();
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    java.lang.String str17 = net.ajaskey.market.misc.Utils.getDayName(calendar15);
    net.ajaskey.market.misc.Utils.printCalendar(calendar15);
    java.util.Calendar calendar19 = null;
    boolean b20 = net.ajaskey.market.misc.Utils.sameMonth(calendar15, calendar19);
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    net.ajaskey.market.ta.DailyData dailyData22 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar15);
    // The following exception was thrown during execution in test generation
    try {
    double d24 = tickerData0.getHigh((int)(byte)100);
      org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException");
    } catch (java.lang.NullPointerException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.NullPointerException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(fundamentals2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "30-Jan-0001"+ "'", str16.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "unknown-day"+ "'", str17.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b20 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "Fri 30-Jan-0001"+ "'", str21.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData22);

  }

  @Test
  public void test135() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test135"); }


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
    double d14 = tickerData0.getPriceOffHigh260();
    double d15 = tickerData0.getAtr23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);

  }

  @Test
  public void test136() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test136"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    double[] d_array9 = tickerData0.getOpenData();
    double d10 = tickerData0.getPriceOffHigh260();
    double d11 = tickerData0.getCurrentPrice();
    double[] d_array12 = tickerData0.getLowData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);

  }

  @Test
  public void test137() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test137"); }


    java.util.Calendar calendar0 = null;
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.TickerData tickerData14 = new net.ajaskey.market.ta.TickerData("hi!", calendar5, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.makeCopy(calendar5);
    java.util.Calendar calendar19 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str20 = net.ajaskey.market.misc.Utils.stringDate(calendar19);
    java.lang.String str21 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar19);
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate2(calendar26);
    net.ajaskey.market.ta.TickerData tickerData35 = new net.ajaskey.market.ta.TickerData("hi!", calendar26, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar36 = net.ajaskey.market.misc.Utils.makeCopy(calendar26);
    boolean b37 = net.ajaskey.market.misc.Utils.sameDate(calendar19, calendar36);
    long long38 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar15, calendar36);
    boolean b39 = net.ajaskey.market.misc.Utils.sameDate(calendar0, calendar36);
    java.lang.String str40 = net.ajaskey.market.misc.Utils.getDayName(calendar36);
    java.lang.String str41 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar36);
    net.ajaskey.market.ta.TickerData tickerData42 = new net.ajaskey.market.ta.TickerData();
    double[] d_array43 = tickerData42.getVolumeData();
    double d44 = tickerData42.getChg65();
    double[] d_array45 = tickerData42.getOiData();
    double d46 = tickerData42.getMfi65();
    java.util.Calendar calendar50 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str51 = net.ajaskey.market.misc.Utils.stringDate(calendar50);
    java.lang.String str52 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar50);
    net.ajaskey.market.ta.TickerData tickerData53 = null;
    net.ajaskey.market.ta.TickerData tickerData54 = new net.ajaskey.market.ta.TickerData();
    double[] d_array55 = tickerData54.getTrueLowData();
    java.util.Calendar calendar59 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str60 = net.ajaskey.market.misc.Utils.stringDate(calendar59);
    java.lang.String str61 = net.ajaskey.market.misc.Utils.stringDate2(calendar59);
    net.ajaskey.market.ta.DailyData dailyData62 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData54, calendar59);
    int i63 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData53, calendar59);
    boolean b64 = net.ajaskey.market.misc.Utils.sameYear(calendar50, calendar59);
    java.util.Calendar calendar68 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str69 = net.ajaskey.market.misc.Utils.stringDate(calendar68);
    java.lang.String str70 = net.ajaskey.market.misc.Utils.stringDate2(calendar68);
    int i71 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData42, calendar59, calendar68);
    java.util.Calendar calendar75 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate(calendar75);
    net.ajaskey.market.ta.DailyData dailyData83 = new net.ajaskey.market.ta.DailyData(calendar75, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar87 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    boolean b88 = net.ajaskey.market.misc.Utils.sameYear(calendar75, calendar87);
    long long89 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar68, calendar87);
    net.ajaskey.market.ta.DailyData dailyData96 = new net.ajaskey.market.ta.DailyData(calendar87, (double)100L, 0.0d, 32.0d, (double)2016L, (double)(-1L), (double)100.0f);
    long long97 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar36, calendar87);
    java.lang.String str98 = net.ajaskey.market.misc.Utils.stringDate2(calendar87);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "30-Jan-0001"+ "'", str20.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "java.util.GregorianCalendar[time=-62164808593869,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=131,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str21.equals("java.util.GregorianCalendar[time=-62164808593869,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=131,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Fri 30-Jan-0001"+ "'", str28.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b37 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long38 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str40 + "' != '" + "unknown-day"+ "'", str40.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str41 + "' != '" + "java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str41.equals("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d44 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array45);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d46 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "30-Jan-0001"+ "'", str51.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "java.util.GregorianCalendar[time=-62164808593869,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=131,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str52.equals("java.util.GregorianCalendar[time=-62164808593869,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=131,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array55);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar59);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str60 + "' != '" + "30-Jan-0001"+ "'", str60.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str61 + "' != '" + "Fri 30-Jan-0001"+ "'", str61.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData62);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i63 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b64 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str69 + "' != '" + "30-Jan-0001"+ "'", str69.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str70 + "' != '" + "Fri 30-Jan-0001"+ "'", str70.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i71 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar75);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "30-Jan-0001"+ "'", str76.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar87);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b88 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long89 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long97 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str98 + "' != '" + "Fri 30-Jan-0001"+ "'", str98.equals("Fri 30-Jan-0001"));

  }

  @Test
  public void test138() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test138"); }


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
    java.lang.Double d19 = tickerData0.getSmaPerc65();
    double d20 = tickerData0.getMfi130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "null\tnull\tnull\r\n"+ "'", str14.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);

  }

  @Test
  public void test139() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test139"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.util.List<java.lang.Integer> list_i11 = industryData0.getRank();
    industryData0.setName("java.util.GregorianCalendar[time=-62164808621161,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=18,MILLISECOND=839,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i11);

  }

  @Test
  public void test140() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test140"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    double d8 = industryData0.getPriceInRange260();
    java.lang.String str9 = industryData0.getTicker();
    industryData0.setRawRsSt((double)1.0f);
    java.lang.String str12 = industryData0.getSector();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str12);

  }

  @Test
  public void test141() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test141"); }


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
    double[] d_array21 = tickerData0.getOiData();
    java.lang.Double d22 = tickerData0.getSmaPerc260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d22);

  }

  @Test
  public void test142() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test142"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    tickerData0.fillDataArrays((int)(short)100, false);
    double d13 = tickerData0.getPriceOffLow260();
    java.util.Calendar calendar14 = null;
    net.ajaskey.market.ta.TickerData tickerData15 = new net.ajaskey.market.ta.TickerData();
    double[] d_array16 = tickerData15.getTrueLowData();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate2(calendar20);
    net.ajaskey.market.ta.DailyData dailyData23 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData15, calendar20);
    boolean b24 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar20);
    net.ajaskey.market.ta.DailyData dailyData25 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar20);
    tickerData0.setTickerExchange("java.util.GregorianCalendar[time=-62164808650620,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=380,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d28 = tickerData0.getAtrPercent23();
    java.lang.Double d29 = tickerData0.getSmaPerc23();
    double d30 = tickerData0.getRsRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Fri 30-Jan-0001"+ "'", str22.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b24 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d30 == 0.0d);

  }

  @Test
  public void test143() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test143"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double d6 = tickerData0.getPriceOffHigh260();
    double[] d_array7 = tickerData0.getCloseData();
    java.lang.String str8 = tickerData0.getTickerExchange();
    double d9 = tickerData0.getChg23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test144() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test144"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    java.lang.Double d14 = dailyData11.getVolume();
    java.util.Calendar calendar15 = dailyData11.getDate();
    double d16 = dailyData11.getDailyPercentChg();
    java.lang.Double d17 = dailyData11.getOpen();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d17 + "' != '" + 0.0d+ "'", d17.equals(0.0d));

  }

  @Test
  public void test145() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test145"); }


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
    double[] d_array15 = tickerData0.getTrueHighData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);

  }

  @Test
  public void test146() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test146"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    java.lang.Double d4 = derivedData0.getSma130();
    double d5 = derivedData0.getAtrPercent23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);

  }

  @Test
  public void test147() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test147"); }


    java.util.Map<java.lang.String,java.lang.Integer> map_str_i0 = net.ajaskey.market.misc.Utils.mapDays;
    net.ajaskey.market.misc.Utils.mapNames = map_str_i0;
    net.ajaskey.market.misc.Utils.mapDays = map_str_i0;
    net.ajaskey.market.misc.Utils.mapNames = map_str_i0;
    net.ajaskey.market.misc.Utils.mapNames = map_str_i0;
    net.ajaskey.market.misc.Utils.mapDays = map_str_i0;
    net.ajaskey.market.misc.Utils.mapNames = map_str_i0;
    net.ajaskey.market.misc.Utils.mapDays = map_str_i0;
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(map_str_i0);

  }

  @Test
  public void test148() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test148"); }


    java.util.ArrayList<java.lang.String> arraylist_str2 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array4 = new java.lang.String[] { "" };
    boolean b5 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str2, str_array4);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData6 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData7 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str2);
    net.ajaskey.market.ta.TickerData tickerData8 = net.ajaskey.market.ta.TickerData.getFromList("java.util.GregorianCalendar[time=-62164808652183,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=817,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", list_tickerData7);
    net.ajaskey.market.ta.TickerData tickerData9 = net.ajaskey.market.ta.TickerData.getFromList("java.util.GregorianCalendar[time=-62164808606389,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=33,MILLISECOND=611,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(tickerData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(tickerData9);

  }

  @Test
  public void test149() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test149"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    industryData0.setName("Unknown");
    java.lang.String str5 = industryData0.getSector();
    industryData0.setChg260((double)10.0f);
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808648763,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=51,MILLISECOND=237,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str10 = industryData0.getExch();
    // The following exception was thrown during execution in test generation
    try {
    int i12 = industryData0.getRank((int)(short)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);

  }

  @Test
  public void test150() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test150"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getAvgVol65();
    double d5 = derivedData0.getHigh260();
    double d6 = derivedData0.getPriceOffHigh260();
    double d7 = derivedData0.getAvgVol20();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test151() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test151"); }


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
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    net.ajaskey.market.ta.DailyData dailyData42 = new net.ajaskey.market.ta.DailyData(calendar34, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str43 = net.ajaskey.market.misc.Utils.stringDate2(calendar34);
    long long44 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar20, calendar34);
    java.lang.String str45 = net.ajaskey.market.misc.Utils.getDayName(calendar34);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Fri 30-Jan-0001"+ "'", str22.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "Fri 30-Jan-0001"+ "'", str43.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long44 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "unknown-day"+ "'", str45.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));

  }

  @Test
  public void test152() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test152"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    dailyData11.setTrueHigh((double)(short)0);
    long long15 = dailyData11.getDaysSinceBase();
    double d16 = dailyData11.getTrueLow();
    double d17 = dailyData11.getDailyPercentChg();
    java.lang.Double d18 = dailyData11.getClose();
    java.lang.Double d19 = dailyData11.getClose();
    java.lang.Double d20 = dailyData11.getVolume();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long15 == 693934L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d18 + "' != '" + 1.0d+ "'", d18.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d19 + "' != '" + 1.0d+ "'", d19.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d20 + "' != '" + 0.0d+ "'", d20.equals(0.0d));

  }

  @Test
  public void test153() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test153"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    dailyData11.setTrueLow(0.0d);
    java.lang.Double d14 = dailyData11.getHigh();
    java.util.Calendar calendar15 = dailyData11.getDate();
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar15, (double)'4', (double)100, (double)100L, (double)10L, (double)2017L, 0.0d);
    double d23 = dailyData22.getTrueLow();
    java.lang.Double d24 = dailyData22.getOi();
    java.lang.String str25 = dailyData22.toString();
    java.lang.Double d26 = dailyData22.getVolume();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 10.0d+ "'", d14.equals(10.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d23 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d24 + "' != '" + 0.0d+ "'", d24.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "Fri 30-Jan-0001  52.00  100.00  100.00  10.00  2017     0  20170.00      0.00"+ "'", str25.equals("Fri 30-Jan-0001  52.00  100.00  100.00  10.00  2017     0  20170.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d26 + "' != '" + 2017.0d+ "'", d26.equals(2017.0d));

  }

  @Test
  public void test154() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test154"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "30-Jan-0001" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'#');
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData6 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData7 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData11 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'4');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData11);

  }

  @Test
  public void test155() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test155"); }


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
    double d55 = tickerData0.getPriceOffHigh260();
    double d56 = tickerData0.getMfi130();
    java.lang.Double d57 = tickerData0.getSmaPerc260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "30-Jan-0001"+ "'", str18.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "java.util.GregorianCalendar[time=-62164808593650,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=350,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str19.equals("java.util.GregorianCalendar[time=-62164808593650,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=350,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "30-Jan-0001"+ "'", str25.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "Fri 30-Jan-0001"+ "'", str26.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d51 + "' != '" + 1.0d+ "'", d51.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d52 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str54 + "' != '" + "FRI"+ "'", str54.equals("FRI"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d55 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d56 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d57);

  }

  @Test
  public void test156() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test156"); }


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
    double[] d_array21 = tickerData0.getOiData();
    double d22 = tickerData0.getMfi65();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d22 == 0.0d);

  }

  @Test
  public void test157() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test157"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSmaPerc260();
    double d6 = derivedData0.getMfi130();
    java.lang.Double d7 = derivedData0.getSma65();
    java.lang.Double d8 = derivedData0.getSma130();
    java.lang.Double d9 = derivedData0.getSmaPerc23();
    double d10 = derivedData0.getHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d9 + "' != '" + 0.0d+ "'", d9.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test158() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test158"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getMfi130();
    java.lang.Double d6 = derivedData0.getSmaPerc260();
    double d7 = derivedData0.getDiPlus();
    double d8 = derivedData0.getChg23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test159() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test159"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    double d2 = derivedData0.getChg65();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsStRaw();
    double d5 = derivedData0.getAvgVol65();
    double d6 = derivedData0.getRsStRaw();
    double d7 = derivedData0.getLrAngle260();
    double d8 = derivedData0.getMfi130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test160() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test160"); }


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
    java.lang.Double d16 = tickerData0.getSma23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d16);

  }

  @Test
  public void test161() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test161"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    java.lang.String str13 = dailyData11.toString();
    double d14 = dailyData11.getTrueHigh();
    double d15 = dailyData11.getDailyChg();
    double d16 = dailyData11.getDailyPercentChg();
    dailyData11.setVolume((double)0L);
    double d19 = dailyData11.getDailyPercentChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str13.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);

  }

  @Test
  public void test162() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test162"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getPriceOffHigh260();
    java.lang.Double d6 = derivedData0.getSma260();
    double d7 = derivedData0.getAtrPercent23();
    double d8 = derivedData0.getRsi14();
    double d9 = derivedData0.getMfi23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test163() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test163"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSma65();
    double d3 = derivedData0.getDiPlus();
    java.lang.Double d4 = derivedData0.getSma65();
    double d5 = derivedData0.getRsRaw();
    double d6 = derivedData0.getAtr23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test164() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test164"); }


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
    double d13 = tickerData0.getHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);

  }

  @Test
  public void test165() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test165"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    tickerData0.fillDataArrays((int)' ', false);
    double d11 = tickerData0.getPriceOffHigh260();
    java.util.Calendar[] calendar_array12 = tickerData0.getDateData();
    java.lang.String str13 = tickerData0.getTickerName();
    // The following exception was thrown during execution in test generation
    try {
    tickerData0.generateDerived(false);
      org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException");
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArrayIndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(calendar_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str13);

  }

  @Test
  public void test166() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test166"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    industryData0.setPriceInRange260((double)(byte)100);
    industryData0.setSlope(0.0d);
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808650277,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=723,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d12 = industryData0.getRawRs();
    industryData0.setShares((long)(byte)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test167() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test167"); }


    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str1 = net.ajaskey.market.ta.input.ParseData.getTickerList("java.util.GregorianCalendar[time=-62164808632015,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=7,MILLISECOND=985,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
      org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException");
    } catch (java.io.FileNotFoundException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.io.FileNotFoundException")) {
        org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException, got " + e.getClass().getCanonicalName());
      }
    }

  }

  @Test
  public void test168() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test168"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    java.lang.String str5 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar3);
    net.ajaskey.market.ta.TickerData tickerData6 = null;
    net.ajaskey.market.ta.TickerData tickerData7 = new net.ajaskey.market.ta.TickerData();
    double[] d_array8 = tickerData7.getTrueLowData();
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    java.lang.String str14 = net.ajaskey.market.misc.Utils.stringDate2(calendar12);
    net.ajaskey.market.ta.DailyData dailyData15 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData7, calendar12);
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData6, calendar12);
    boolean b17 = net.ajaskey.market.misc.Utils.sameYear(calendar3, calendar12);
    net.ajaskey.market.ta.TickerData tickerData18 = new net.ajaskey.market.ta.TickerData();
    double[] d_array19 = tickerData18.getVolumeData();
    double d20 = tickerData18.getChg65();
    double[] d_array21 = tickerData18.getOiData();
    double d22 = tickerData18.getMfi65();
    java.util.Calendar calendar26 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str27 = net.ajaskey.market.misc.Utils.stringDate(calendar26);
    java.lang.String str28 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar26);
    net.ajaskey.market.ta.TickerData tickerData29 = null;
    net.ajaskey.market.ta.TickerData tickerData30 = new net.ajaskey.market.ta.TickerData();
    double[] d_array31 = tickerData30.getTrueLowData();
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.stringDate2(calendar35);
    net.ajaskey.market.ta.DailyData dailyData38 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData30, calendar35);
    int i39 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData29, calendar35);
    boolean b40 = net.ajaskey.market.misc.Utils.sameYear(calendar26, calendar35);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    int i47 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData18, calendar35, calendar44);
    net.ajaskey.market.ta.TickerData tickerData48 = new net.ajaskey.market.ta.TickerData();
    double[] d_array49 = tickerData48.getVolumeData();
    double d50 = tickerData48.getChg65();
    double[] d_array51 = tickerData48.getOiData();
    double d52 = tickerData48.getMfi65();
    java.util.Calendar calendar56 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str57 = net.ajaskey.market.misc.Utils.stringDate(calendar56);
    java.lang.String str58 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar56);
    net.ajaskey.market.ta.TickerData tickerData59 = null;
    net.ajaskey.market.ta.TickerData tickerData60 = new net.ajaskey.market.ta.TickerData();
    double[] d_array61 = tickerData60.getTrueLowData();
    java.util.Calendar calendar65 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate(calendar65);
    java.lang.String str67 = net.ajaskey.market.misc.Utils.stringDate2(calendar65);
    net.ajaskey.market.ta.DailyData dailyData68 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData60, calendar65);
    int i69 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData59, calendar65);
    boolean b70 = net.ajaskey.market.misc.Utils.sameYear(calendar56, calendar65);
    java.util.Calendar calendar74 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str75 = net.ajaskey.market.misc.Utils.stringDate(calendar74);
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate2(calendar74);
    int i77 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData48, calendar65, calendar74);
    boolean b78 = net.ajaskey.market.misc.Utils.sameMonth(calendar35, calendar65);
    boolean b79 = net.ajaskey.market.misc.Utils.sameYear(calendar3, calendar65);
    net.ajaskey.market.ta.DailyData dailyData86 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)1, (double)(short)1, (double)(short)1, (-1.0d), (double)'4', (double)(byte)10);
    java.lang.Double d87 = dailyData86.getVolume();
    dailyData86.setTrueLow((double)0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "java.util.GregorianCalendar[time=-62164808593494,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=506,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str5.equals("java.util.GregorianCalendar[time=-62164808593494,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=506,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Fri 30-Jan-0001"+ "'", str14.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i16 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b17 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d22 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "30-Jan-0001"+ "'", str27.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "java.util.GregorianCalendar[time=-62164808593479,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=521,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str28.equals("java.util.GregorianCalendar[time=-62164808593479,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=521,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "Fri 30-Jan-0001"+ "'", str37.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b40 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i47 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array49);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d50 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d52 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str57 + "' != '" + "30-Jan-0001"+ "'", str57.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "java.util.GregorianCalendar[time=-62164808593479,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=521,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str58.equals("java.util.GregorianCalendar[time=-62164808593479,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=521,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array61);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "30-Jan-0001"+ "'", str66.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "Fri 30-Jan-0001"+ "'", str67.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i69 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b70 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar74);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str75 + "' != '" + "30-Jan-0001"+ "'", str75.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "Fri 30-Jan-0001"+ "'", str76.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i77 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b78 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b79 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d87 + "' != '" + 52.0d+ "'", d87.equals(52.0d));

  }

  @Test
  public void test169() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test169"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    java.lang.String str13 = dailyData11.toString();
    double d14 = dailyData11.getTrueHigh();
    double d15 = dailyData11.getDailyChg();
    double d16 = dailyData11.getDailyPercentChg();
    dailyData11.setVolume((double)0L);
    dailyData11.setDailyChg((double)2017L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str13.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);

  }

  @Test
  public void test170() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test170"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    java.lang.Double d9 = tickerData0.getSmaPerc130();
    double d10 = tickerData0.getCurrentPrice();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar23 = dailyData22.getDate();
    java.lang.String str24 = net.ajaskey.market.misc.Utils.stringDate(calendar23);
    java.lang.String str25 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar23);
    net.ajaskey.market.ta.DailyData dailyData26 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "HI!"+ "'", str7.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "30-Jan-0001"+ "'", str24.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str25.equals("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData26);

  }

  @Test
  public void test171() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test171"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    double d6 = industryData0.getChg260();
    industryData0.setName("Fri 30-Jan-0001");
    long long9 = industryData0.getfShares();
    industryData0.setPriceInRange260((double)(short)1);
    double d12 = industryData0.getRawRsSt();
    // The following exception was thrown during execution in test generation
    try {
    double d14 = industryData0.getSlope((int)(short)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == (-1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long9 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test172() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test172"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    net.ajaskey.market.ta.DailyData dailyData10 = new net.ajaskey.market.ta.DailyData(calendar3, (double)'4', (double)0, 0.0d, (double)(short)(-1), (double)0L, (double)(-1.0f));
    net.ajaskey.market.misc.Utils.printCalendar(calendar3);
    java.lang.String str12 = net.ajaskey.market.misc.Utils.getDayName(calendar3);
    net.ajaskey.market.ta.DailyData dailyData19 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)10, (double)10L, (double)0, (-1.0d), (double)(short)(-1), (double)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str12 + "' != '" + "unknown-day"+ "'", str12.equals("unknown-day"));

  }

  @Test
  public void test173() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test173"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("hi!", calendar4, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    double d14 = tickerData13.getChg23();
    double d15 = tickerData13.getChg260();
    double d16 = tickerData13.getLrAngle260();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    net.ajaskey.market.ta.DailyData dailyData28 = new net.ajaskey.market.ta.DailyData(calendar20, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d29 = dailyData28.getTrueHigh();
    java.lang.String str30 = dailyData28.toString();
    java.lang.Double d31 = dailyData28.getOpen();
    java.lang.Double d32 = dailyData28.getHigh();
    dailyData28.setTrueLow((double)(-1L));
    dailyData28.setDailyChg((double)(-1.0f));
    tickerData13.addData(dailyData28);
    java.lang.String str38 = dailyData28.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Fri 30-Jan-0001"+ "'", str6.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str30.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d31 + "' != '" + 0.0d+ "'", d31.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d32 + "' != '" + 10.0d+ "'", d32.equals(10.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str38 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str38.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));

  }

  @Test
  public void test174() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test174"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData4 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData6 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)1);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData7 = net.ajaskey.market.ta.TickerData.build((java.util.List<java.lang.String>)arraylist_str0);
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData10 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData11 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData13 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)(byte)(-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData13);

  }

  @Test
  public void test175() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test175"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    java.lang.String str7 = tickerData0.getTicker();
    net.ajaskey.market.ta.TrendType trendType8 = tickerData0.getSma65Trend();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma65Trend();
    net.ajaskey.market.ta.TickerData tickerData10 = new net.ajaskey.market.ta.TickerData();
    double[] d_array11 = tickerData10.getVolumeData();
    double d12 = tickerData10.getChg65();
    int i16 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData10, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d17 = tickerData10.getCurrentPrice();
    double d18 = tickerData10.getChg260();
    double[] d_array19 = tickerData10.getOpenData();
    java.lang.String str20 = tickerData10.getTickerExchange();
    java.util.Calendar calendar24 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate(calendar24);
    java.lang.String str26 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar24);
    net.ajaskey.market.ta.DailyData dailyData27 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData10, calendar24);
    net.ajaskey.market.ta.DailyData dailyData28 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar24);
    double[] d_array29 = tickerData0.getTrueLowData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "HI!"+ "'", str7.equals("HI!"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i16 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "30-Jan-0001"+ "'", str25.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "java.util.GregorianCalendar[time=-62164808593260,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=740,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str26.equals("java.util.GregorianCalendar[time=-62164808593260,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=740,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array29);

  }

  @Test
  public void test176() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test176"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData13 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar4, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    double[] d_array14 = tickerData13.getTypicalPriceData();
    double d15 = tickerData13.getLow260();
    tickerData13.generateDerived(false);
    double d18 = tickerData13.getLrInt260();
    double[] d_array19 = tickerData13.getVolumeData();
    double d20 = tickerData13.getMfi130();
    // The following exception was thrown during execution in test generation
    try {
    double d22 = tickerData13.getVolume((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException");
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArrayIndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Fri 30-Jan-0001"+ "'", str6.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);

  }

  @Test
  public void test177() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test177"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setChg260(10.0d);
    industryData0.setRank(10);
    java.lang.String str10 = industryData0.getTicker();
    industryData0.setPriceInRange260((double)100);
    double d13 = industryData0.getPriceInRange260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 100.0d);

  }

  @Test
  public void test178() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test178"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getRsRaw();
    java.lang.Double d6 = derivedData0.getSma23();
    java.lang.Double d7 = derivedData0.getSma260();
    java.lang.Double d8 = derivedData0.getSma260();
    double d9 = derivedData0.getMfi65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test179() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test179"); }


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
    double d30 = tickerData0.getChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "30-Jan-0001"+ "'", str19.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "Fri 30-Jan-0001"+ "'", str20.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d30 == 0.0d);

  }

  @Test
  public void test180() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test180"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSma65();
    double d3 = derivedData0.getDiPlus();
    double d4 = derivedData0.getLrInt260();
    double d5 = derivedData0.getCurrentPrice();
    double d6 = derivedData0.getRsRaw();
    double d7 = derivedData0.getChg130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test181() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test181"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getDailyPercentChg();
    double d14 = dailyData11.getTrueLow();
    double d15 = dailyData11.getDailyPercentChg();
    java.lang.String str16 = dailyData11.toString();
    java.lang.Double d17 = dailyData11.getVolume();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str16.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d17 + "' != '" + 0.0d+ "'", d17.equals(0.0d));

  }

  @Test
  public void test182() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test182"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSmaPerc23();
    double d3 = derivedData0.getRsi14();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);

  }

  @Test
  public void test183() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test183"); }


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
    net.ajaskey.market.ta.TickerData tickerData16 = new net.ajaskey.market.ta.TickerData();
    double[] d_array17 = tickerData16.getTrueLowData();
    double d18 = tickerData16.getCurrentPrice();
    double d19 = tickerData16.getAtr23();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData16);
    double d21 = tickerData16.getRsRaw();
    net.ajaskey.market.ta.TickerData.mergeData(tickerData8, tickerData16);
    double d23 = tickerData8.getAtr23();
    double d24 = tickerData8.getLrInt260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d23 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);

  }

  @Test
  public void test184() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test184"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    double d2 = derivedData0.getChg65();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsStRaw();
    double d5 = derivedData0.getAvgVol65();
    double d6 = derivedData0.getCurrentPrice();
    java.lang.Double d7 = derivedData0.getSmaPerc260();
    double d8 = derivedData0.getCurrentPrice();
    double d9 = derivedData0.getRsRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test185() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test185"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setMarketCap("java.util.GregorianCalendar[time=-62164808650526,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=474,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setPriceInRange260((double)0L);
    industryData0.setRank((int)(short)(-1));
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808624140,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=15,MILLISECOND=860,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str19 = industryData0.getTicker();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str19.equals("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));

  }

  @Test
  public void test186() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test186"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSma65();
    double d3 = derivedData0.getDiPlus();
    java.lang.Double d4 = derivedData0.getSma65();
    double d5 = derivedData0.getMfi23();
    double d6 = derivedData0.getRsStRaw();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test187() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test187"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    long long6 = industryData0.getfShares();
    industryData0.setRawRs((double)693934L);
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808639740,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=0,MILLISECOND=260,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    // The following exception was thrown during execution in test generation
    try {
    double d12 = industryData0.getSlope(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException");
    } catch (java.lang.IndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.IndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long6 == 0L);

  }

  @Test
  public void test188() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test188"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg260();
    java.lang.Double d5 = tickerData0.getSmaPerc23();
    net.ajaskey.market.ta.DailyData dailyData9 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, 10, 0, (-1));
    double d10 = tickerData0.getAtrPercent23();
    double d11 = tickerData0.getChg130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test189() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test189"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.lang.Integer i2 = tickerData0.getDaysOfData();
    tickerData0.rSort();
    java.util.Calendar[] calendar_array4 = tickerData0.getDateData();
    java.lang.Double d5 = tickerData0.getSma65();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(calendar_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);

  }

  @Test
  public void test190() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test190"); }


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
    double d15 = tickerData0.getPriceOffHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "null\tnull\tnull\r\n"+ "'", str14.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);

  }

  @Test
  public void test191() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test191"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getChg130();
    java.util.Calendar calendar10 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str11 = net.ajaskey.market.misc.Utils.stringDate(calendar10);
    net.ajaskey.market.ta.DailyData dailyData18 = new net.ajaskey.market.ta.DailyData(calendar10, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d19 = dailyData18.getClose();
    double d20 = dailyData18.getDailyPercentChg();
    double d21 = dailyData18.getDailyPercentRng();
    java.lang.Double d22 = dailyData18.getLow();
    java.lang.Double d23 = dailyData18.getOpen();
    tickerData0.addData(dailyData18);
    double d25 = dailyData18.getDailyPercentRng();
    java.util.Calendar calendar26 = dailyData18.getDate();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "30-Jan-0001"+ "'", str11.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d19 + "' != '" + 1.0d+ "'", d19.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d20 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d22 + "' != '" + 0.0d+ "'", d22.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d23 + "' != '" + 0.0d+ "'", d23.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d25 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar26);

  }

  @Test
  public void test192() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test192"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    java.lang.String str9 = tickerData0.getTicker();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str9);

  }

  @Test
  public void test193() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test193"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    java.lang.Double d4 = tickerData0.getSma65();
    java.lang.Double d5 = tickerData0.getSma260();
    double d6 = tickerData0.getChg130();
    tickerData0.setTicker("Fri");
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate(calendar12);
    java.lang.String str14 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar12);
    net.ajaskey.market.ta.TickerData tickerData15 = null;
    net.ajaskey.market.ta.TickerData tickerData16 = new net.ajaskey.market.ta.TickerData();
    double[] d_array17 = tickerData16.getTrueLowData();
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar21);
    java.lang.String str23 = net.ajaskey.market.misc.Utils.stringDate2(calendar21);
    net.ajaskey.market.ta.DailyData dailyData24 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData16, calendar21);
    int i25 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData15, calendar21);
    boolean b26 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar21);
    net.ajaskey.market.ta.TickerData tickerData27 = new net.ajaskey.market.ta.TickerData();
    double[] d_array28 = tickerData27.getVolumeData();
    double d29 = tickerData27.getChg65();
    double[] d_array30 = tickerData27.getOiData();
    double d31 = tickerData27.getMfi65();
    java.util.Calendar calendar35 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate(calendar35);
    java.lang.String str37 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar35);
    net.ajaskey.market.ta.TickerData tickerData38 = null;
    net.ajaskey.market.ta.TickerData tickerData39 = new net.ajaskey.market.ta.TickerData();
    double[] d_array40 = tickerData39.getTrueLowData();
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate(calendar44);
    java.lang.String str46 = net.ajaskey.market.misc.Utils.stringDate2(calendar44);
    net.ajaskey.market.ta.DailyData dailyData47 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData39, calendar44);
    int i48 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData38, calendar44);
    boolean b49 = net.ajaskey.market.misc.Utils.sameYear(calendar35, calendar44);
    java.util.Calendar calendar53 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str54 = net.ajaskey.market.misc.Utils.stringDate(calendar53);
    java.lang.String str55 = net.ajaskey.market.misc.Utils.stringDate2(calendar53);
    int i56 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData27, calendar44, calendar53);
    net.ajaskey.market.ta.TickerData tickerData57 = new net.ajaskey.market.ta.TickerData();
    double[] d_array58 = tickerData57.getVolumeData();
    double d59 = tickerData57.getChg65();
    double[] d_array60 = tickerData57.getOiData();
    double d61 = tickerData57.getMfi65();
    java.util.Calendar calendar65 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate(calendar65);
    java.lang.String str67 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar65);
    net.ajaskey.market.ta.TickerData tickerData68 = null;
    net.ajaskey.market.ta.TickerData tickerData69 = new net.ajaskey.market.ta.TickerData();
    double[] d_array70 = tickerData69.getTrueLowData();
    java.util.Calendar calendar74 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str75 = net.ajaskey.market.misc.Utils.stringDate(calendar74);
    java.lang.String str76 = net.ajaskey.market.misc.Utils.stringDate2(calendar74);
    net.ajaskey.market.ta.DailyData dailyData77 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData69, calendar74);
    int i78 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData68, calendar74);
    boolean b79 = net.ajaskey.market.misc.Utils.sameYear(calendar65, calendar74);
    java.util.Calendar calendar83 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str84 = net.ajaskey.market.misc.Utils.stringDate(calendar83);
    java.lang.String str85 = net.ajaskey.market.misc.Utils.stringDate2(calendar83);
    int i86 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData57, calendar74, calendar83);
    boolean b87 = net.ajaskey.market.misc.Utils.sameMonth(calendar44, calendar74);
    boolean b88 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar74);
    java.lang.String str89 = net.ajaskey.market.misc.Utils.getDayName(calendar74);
    java.util.Calendar calendar90 = null;
    int i91 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData0, calendar74, calendar90);
    double[] d_array92 = tickerData0.getOiData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "30-Jan-0001"+ "'", str13.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str14.equals("java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Fri 30-Jan-0001"+ "'", str23.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i25 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b26 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d29 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d31 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "30-Jan-0001"+ "'", str36.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str37 + "' != '" + "java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str37.equals("java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array40);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "30-Jan-0001"+ "'", str45.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Fri 30-Jan-0001"+ "'", str46.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i48 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b49 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar53);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str54 + "' != '" + "30-Jan-0001"+ "'", str54.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str55 + "' != '" + "Fri 30-Jan-0001"+ "'", str55.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i56 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array58);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d59 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array60);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d61 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "30-Jan-0001"+ "'", str66.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str67.equals("java.util.GregorianCalendar[time=-62164808593198,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=802,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array70);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar74);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str75 + "' != '" + "30-Jan-0001"+ "'", str75.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "Fri 30-Jan-0001"+ "'", str76.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData77);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i78 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b79 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar83);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str84 + "' != '" + "30-Jan-0001"+ "'", str84.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str85 + "' != '" + "Fri 30-Jan-0001"+ "'", str85.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i86 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b87 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b88 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str89 + "' != '" + "unknown-day"+ "'", str89.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i91 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array92);

  }

  @Test
  public void test194() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test194"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setName("100");
    double d3 = industryData0.getChg260();
    industryData0.setSector("JAVA.UTIL.GREGORIANCALENDAR[TIME=-62164808650214,AREFIELDSSET=TRUE,AREALLFIELDSSET=FALSE,LENIENT=TRUE,ZONE=SUN.UTIL.CALENDAR.ZONEINFO[ID=\"AMERICA/DENVER\",OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,TRANSITIONS=157,LASTRULE=JAVA.UTIL.SIMPLETIMEZONE[ID=AMERICA/DENVER,OFFSET=-25200000,DSTSAVINGS=3600000,USEDAYLIGHT=TRUE,STARTYEAR=0,STARTMODE=3,STARTMONTH=2,STARTDAY=8,STARTDAYOFWEEK=1,STARTTIME=7200000,STARTTIMEMODE=0,ENDMODE=3,ENDMONTH=10,ENDDAY=1,ENDDAYOFWEEK=1,ENDTIME=7200000,ENDTIMEMODE=0]],FIRSTDAYOFWEEK=1,MINIMALDAYSINFIRSTWEEK=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  YEAR         : 1\n  MONTH        : 0\n  DAY OF MONTH : 30\n  DAY OF YEAR  : 30\n  WEEK OF YEAR : 5");
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);

  }

  @Test
  public void test195() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test195"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType5 = tickerData0.getSma65Trend();
    double[] d_array6 = tickerData0.getTypicalPriceData();
    tickerData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.Double d9 = tickerData0.getSmaPerc260();
    double d10 = tickerData0.getAvgVol20();
    net.ajaskey.market.ta.TickerData tickerData12 = new net.ajaskey.market.ta.TickerData();
    double[] d_array13 = tickerData12.getTrueLowData();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate(calendar17);
    java.lang.String str19 = net.ajaskey.market.misc.Utils.stringDate2(calendar17);
    net.ajaskey.market.ta.DailyData dailyData20 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData12, calendar17);
    double d21 = tickerData12.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType22 = tickerData12.getSma130Trend();
    double[] d_array23 = tickerData12.getVolumeData();
    int i27 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData12, (int)'a', (int)(byte)(-1), (int)(byte)(-1));
    java.util.Calendar calendar32 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str33 = net.ajaskey.market.misc.Utils.stringDate(calendar32);
    java.lang.String str34 = net.ajaskey.market.misc.Utils.stringDate2(calendar32);
    net.ajaskey.market.ta.TickerData tickerData41 = new net.ajaskey.market.ta.TickerData("hi!", calendar32, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    net.ajaskey.market.ta.DailyData dailyData42 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData12, calendar32);
    java.util.Calendar calendar46 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str47 = net.ajaskey.market.misc.Utils.stringDate(calendar46);
    net.ajaskey.market.ta.DailyData dailyData54 = new net.ajaskey.market.ta.DailyData(calendar46, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str55 = net.ajaskey.market.misc.Utils.stringDate2(calendar46);
    long long56 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar32, calendar46);
    net.ajaskey.market.ta.TickerData tickerData63 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650214,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=786,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar32, (double)(byte)0, (double)1, (double)100, (double)'4', (double)10L, (double)1.0f);
    net.ajaskey.market.ta.DailyData dailyData64 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar32);
    net.ajaskey.market.ta.TrendType trendType65 = tickerData0.getSma130Trend();
    double d66 = tickerData0.getPriceOffLow260();
    double[] d_array67 = tickerData0.getTypicalPriceData();
    double[] d_array68 = tickerData0.getHighData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "30-Jan-0001"+ "'", str18.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "Fri 30-Jan-0001"+ "'", str19.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str33 + "' != '" + "30-Jan-0001"+ "'", str33.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "Fri 30-Jan-0001"+ "'", str34.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar46);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str47 + "' != '" + "30-Jan-0001"+ "'", str47.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str55 + "' != '" + "Fri 30-Jan-0001"+ "'", str55.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long56 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData64);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType65);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d66 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array67);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array68);

  }

  @Test
  public void test196() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test196"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSma130();
    java.lang.Double d4 = derivedData0.getSmaPerc65();
    double d5 = derivedData0.getRsRaw();
    double d6 = derivedData0.getLrInt260();
    double d7 = derivedData0.getPriceOffHigh260();
    double d8 = derivedData0.getPriceInRng260();
    double d9 = derivedData0.getChg23();
    double d10 = derivedData0.getLrAngle260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test197() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test197"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    java.util.Calendar calendar12 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar16 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str17 = net.ajaskey.market.misc.Utils.stringDate(calendar16);
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate2(calendar16);
    boolean b19 = net.ajaskey.market.misc.Utils.sameYear(calendar12, calendar16);
    java.lang.String str20 = net.ajaskey.market.misc.Utils.getString(calendar16);
    java.lang.String str21 = net.ajaskey.market.misc.Utils.getString(calendar16);
    net.ajaskey.market.ta.DailyData dailyData22 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar16);
    net.ajaskey.market.ta.TrendType trendType23 = tickerData0.getSma260Trend();
    java.lang.Double d24 = tickerData0.getSmaPerc23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str17 + "' != '" + "30-Jan-0001"+ "'", str17.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Fri 30-Jan-0001"+ "'", str18.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b19 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str20 + "' != '" + "30-Jan-0001"+ "'", str20.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d24);

  }

  @Test
  public void test198() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test198"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSma23();
    double d4 = derivedData0.getRsi14();
    double d5 = derivedData0.getAvgVol20();
    java.lang.Double d6 = derivedData0.getSma260();
    double d7 = derivedData0.getLrSlope260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test199() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test199"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setChg260(0.0d);
    double d8 = industryData0.getAvgVol();
    industryData0.setAvgVol((double)(byte)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test200() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test200"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    double d14 = dailyData11.getDailyRng();
    java.lang.Double d15 = dailyData11.getOpen();
    double d16 = dailyData11.getDailyPercentChg();
    dailyData11.setTrueLow((double)100.0f);
    java.lang.Double d19 = dailyData11.getClose();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d15 + "' != '" + 0.0d+ "'", d15.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d19 + "' != '" + 1.0d+ "'", d19.equals(1.0d));

  }

  @Test
  public void test201() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test201"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setRank((int)(byte)10);
    java.lang.String str8 = industryData0.getMarketCap();
    java.util.List<java.lang.Integer> list_i9 = industryData0.getRank();
    industryData0.setExch("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808625981,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=14,MILLISECOND=19,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    long long14 = industryData0.getShares();
    industryData0.setChg260((double)4027L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_i9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long14 == 0L);

  }

  @Test
  public void test202() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test202"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    double d3 = derivedData0.getPriceOffLow260();
    double d4 = derivedData0.getLrSlope260();
    double d5 = derivedData0.getAtr23();
    double d6 = derivedData0.getMfi65();
    double d7 = derivedData0.getMfi130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test203() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test203"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    double[] d_array10 = tickerData0.getTypicalPriceData();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    net.ajaskey.market.ta.DailyData dailyData22 = new net.ajaskey.market.ta.DailyData(calendar14, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d23 = dailyData22.getTrueHigh();
    dailyData22.setTrueHigh((double)(short)0);
    long long26 = dailyData22.getDaysSinceBase();
    double d27 = dailyData22.getTrueHigh();
    java.util.Calendar calendar28 = dailyData22.getDate();
    net.ajaskey.market.ta.DailyData dailyData29 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar28);
    net.ajaskey.market.ta.TickerData tickerData30 = null;
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    net.ajaskey.market.ta.DailyData dailyData42 = new net.ajaskey.market.ta.DailyData(calendar34, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData43 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData30, calendar34);
    java.util.Calendar calendar47 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str48 = net.ajaskey.market.misc.Utils.stringDate(calendar47);
    net.ajaskey.market.ta.DailyData dailyData55 = new net.ajaskey.market.ta.DailyData(calendar47, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar56 = dailyData55.getDate();
    boolean b57 = net.ajaskey.market.misc.Utils.sameMonth(calendar34, calendar56);
    boolean b58 = net.ajaskey.market.misc.Utils.sameDate(calendar28, calendar56);
    java.lang.String str59 = net.ajaskey.market.misc.Utils.stringDate(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d23 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long26 == 693934L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d27 == 10.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str48 + "' != '" + "30-Jan-0001"+ "'", str48.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar56);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b57 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b58 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str59 + "' != '" + "30-Jan-0001"+ "'", str59.equals("30-Jan-0001"));

  }

  @Test
  public void test204() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test204"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsi14();
    double d5 = derivedData0.getChg65();
    double d6 = derivedData0.getDiMinus();
    double d7 = derivedData0.getChg65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test205() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test205"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    net.ajaskey.market.ta.TickerData tickerData12 = new net.ajaskey.market.ta.TickerData();
    double[] d_array13 = tickerData12.getVolumeData();
    double d14 = tickerData12.getChg65();
    double[] d_array15 = tickerData12.getOiData();
    double d16 = tickerData12.getMfi65();
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar20);
    net.ajaskey.market.ta.TickerData tickerData23 = null;
    net.ajaskey.market.ta.TickerData tickerData24 = new net.ajaskey.market.ta.TickerData();
    double[] d_array25 = tickerData24.getTrueLowData();
    java.util.Calendar calendar29 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str30 = net.ajaskey.market.misc.Utils.stringDate(calendar29);
    java.lang.String str31 = net.ajaskey.market.misc.Utils.stringDate2(calendar29);
    net.ajaskey.market.ta.DailyData dailyData32 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData24, calendar29);
    int i33 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData23, calendar29);
    boolean b34 = net.ajaskey.market.misc.Utils.sameYear(calendar20, calendar29);
    java.util.Calendar calendar38 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str39 = net.ajaskey.market.misc.Utils.stringDate(calendar38);
    java.lang.String str40 = net.ajaskey.market.misc.Utils.stringDate2(calendar38);
    int i41 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData12, calendar29, calendar38);
    java.util.Calendar calendar46 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str47 = net.ajaskey.market.misc.Utils.stringDate(calendar46);
    java.lang.String str48 = net.ajaskey.market.misc.Utils.stringDate2(calendar46);
    net.ajaskey.market.ta.TickerData tickerData55 = new net.ajaskey.market.ta.TickerData("hi!", calendar46, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    int i56 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData0, calendar38, calendar46);
    tickerData0.fillDataArrays(100, false);
    java.util.Calendar calendar64 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str65 = net.ajaskey.market.misc.Utils.stringDate(calendar64);
    java.lang.String str66 = net.ajaskey.market.misc.Utils.stringDate2(calendar64);
    net.ajaskey.market.ta.TickerData tickerData73 = new net.ajaskey.market.ta.TickerData("Fri 30-Jan-0001", calendar64, (double)1.0f, (double)1L, (double)0.0f, (double)(-1.0f), (double)(-1.0f), (double)(byte)0);
    net.ajaskey.market.ta.DailyData dailyData74 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData0, calendar64);
    java.lang.String str75 = net.ajaskey.market.misc.Utils.stringDate(calendar64);
    java.lang.String str76 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar64);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "java.util.GregorianCalendar[time=-62164808593026,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=974,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str22.equals("java.util.GregorianCalendar[time=-62164808593026,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=46,MILLISECOND=974,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "30-Jan-0001"+ "'", str30.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Fri 30-Jan-0001"+ "'", str31.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b34 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str39 + "' != '" + "30-Jan-0001"+ "'", str39.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str40 + "' != '" + "Fri 30-Jan-0001"+ "'", str40.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i41 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar46);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str47 + "' != '" + "30-Jan-0001"+ "'", str47.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str48 + "' != '" + "Fri 30-Jan-0001"+ "'", str48.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i56 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar64);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str65 + "' != '" + "30-Jan-0001"+ "'", str65.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str66 + "' != '" + "Fri 30-Jan-0001"+ "'", str66.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData74);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str75 + "' != '" + "30-Jan-0001"+ "'", str75.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str76 + "' != '" + "java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str76.equals("java.util.GregorianCalendar[time=-62164861199000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));

  }

  @Test
  public void test206() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test206"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    java.lang.Double d3 = derivedData0.getSma65();
    double d4 = derivedData0.getLr260();
    double d5 = derivedData0.getLr260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);

  }

  @Test
  public void test207() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test207"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRawRs((double)100);
    java.lang.String str8 = industryData0.getSector();
    industryData0.setPriceInRange260((double)10L);
    java.lang.String str11 = industryData0.getSector();
    industryData0.setMarketCap("NotFound");
    double d14 = industryData0.getAvgVol();
    double d15 = industryData0.getRawRsSt();
    java.lang.String str16 = industryData0.getTicker();
    industryData0.setShares(693934L);
    java.lang.String str19 = industryData0.getRanks();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "101  "+ "'", str19.equals("101  "));

  }

  @Test
  public void test208() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test208"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    tickerData0.setTicker("hi!");
    double[] d_array5 = tickerData0.getOiData();
    double d6 = tickerData0.getDiMinus();
    tickerData0.setTicker("hi!");
    double d9 = tickerData0.getChg260();
    double[] d_array10 = tickerData0.getHighData();
    double d11 = tickerData0.getChg23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test209() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test209"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getPriceOffHigh260();
    java.lang.Double d6 = derivedData0.getSma260();
    double d7 = derivedData0.getMfi23();
    double d8 = derivedData0.getAtr23();
    double d9 = derivedData0.getAtr23();
    double d10 = derivedData0.getDiPlus();
    double d11 = derivedData0.getLrAngle260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test210() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test210"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    double d10 = tickerData0.getDiPlus();
    double[] d_array11 = tickerData0.getOiData();
    double d12 = tickerData0.getAvgVol65();
    double[] d_array13 = tickerData0.getTrueHighData();
    double d14 = tickerData0.getDiPlus();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);

  }

  @Test
  public void test211() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test211"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    long long1 = industryData0.getShares();
    double d2 = industryData0.getRawRs();
    industryData0.setPriceInRange260((double)10.0f);
    java.lang.String str5 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808631407,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=8,MILLISECOND=593,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setRawRsSt((double)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long1 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str5);

  }

  @Test
  public void test212() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test212"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSmaPerc260();
    double d6 = derivedData0.getMfi130();
    java.lang.Double d7 = derivedData0.getSma65();
    java.lang.Double d8 = derivedData0.getSma130();
    double d9 = derivedData0.getLrSlope260();
    java.lang.Double d10 = derivedData0.getSmaPerc23();
    double d11 = derivedData0.getLrSlope260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d10 + "' != '" + 0.0d+ "'", d10.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);

  }

  @Test
  public void test213() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test213"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSma23();
    double d4 = derivedData0.getRsi14();
    double d5 = derivedData0.getHigh260();
    double d6 = derivedData0.getDiMinus();
    double d7 = derivedData0.getMfi23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test214() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test214"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808651306,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=694,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setAvgVol((double)0);
    industryData0.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setTicker("30-Jan-0001");
    industryData0.setRawRsSt((double)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);

  }

  @Test
  public void test215() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test215"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank((int)(short)0);
    industryData0.setName("java.util.GregorianCalendar[time=-62164808651587,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=48,MILLISECOND=413,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setRank((int)'a');
    industryData0.setExch("java.util.GregorianCalendar[time=-62164808646314,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=53,MILLISECOND=686,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.lang.String str14 = industryData0.getSector();
    java.lang.String str15 = industryData0.getSector();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str15);

  }

  @Test
  public void test216() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test216"); }


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
    double[] d_array19 = tickerData9.getHighData();
    net.ajaskey.market.ta.TickerData tickerData21 = new net.ajaskey.market.ta.TickerData();
    double[] d_array22 = tickerData21.getVolumeData();
    double d23 = tickerData21.getChg65();
    tickerData21.setTicker("hi!");
    net.ajaskey.market.ta.TrendType trendType26 = tickerData21.getSma65Trend();
    double[] d_array27 = tickerData21.getTypicalPriceData();
    tickerData21.setTicker("java.util.GregorianCalendar[time=-62164808652443,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=557,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    java.util.Calendar calendar33 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str34 = net.ajaskey.market.misc.Utils.stringDate(calendar33);
    net.ajaskey.market.ta.DailyData dailyData41 = new net.ajaskey.market.ta.DailyData(calendar33, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d42 = dailyData41.getClose();
    double d43 = dailyData41.getDailyPercentChg();
    double d44 = dailyData41.getDailyPercentRng();
    dailyData41.setTrueHigh((double)(short)(-1));
    dailyData41.setDailyChg(100.0d);
    java.util.Calendar calendar49 = dailyData41.getDate();
    net.ajaskey.market.ta.DailyData dailyData50 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData21, calendar49);
    net.ajaskey.market.misc.Utils.printCalendar(calendar49);
    net.ajaskey.market.ta.TickerData tickerData58 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650011,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=989,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar49, 0.0d, 10.0d, (double)'#', (double)100, (double)10.0f, (double)'4');
    int i59 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData9, calendar49);
    double d60 = tickerData9.getChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d23 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str34 + "' != '" + "30-Jan-0001"+ "'", str34.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d42 + "' != '" + 1.0d+ "'", d42.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d43 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d44 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar49);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i59 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d60 == 0.0d);

  }

  @Test
  public void test217() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test217"); }


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
    net.ajaskey.market.ta.TickerData tickerData16 = null;
    java.util.Calendar calendar20 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str21 = net.ajaskey.market.misc.Utils.stringDate(calendar20);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar20);
    java.util.Calendar calendar27 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str28 = net.ajaskey.market.misc.Utils.stringDate(calendar27);
    java.lang.String str29 = net.ajaskey.market.misc.Utils.stringDate2(calendar27);
    net.ajaskey.market.ta.TickerData tickerData36 = new net.ajaskey.market.ta.TickerData("hi!", calendar27, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.util.Calendar calendar37 = net.ajaskey.market.misc.Utils.makeCopy(calendar27);
    boolean b38 = net.ajaskey.market.misc.Utils.sameDate(calendar20, calendar37);
    java.util.Calendar calendar42 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.util.Calendar calendar43 = net.ajaskey.market.misc.Utils.makeCopy(calendar42);
    java.util.Calendar calendar44 = net.ajaskey.market.misc.Utils.makeCopy(calendar42);
    int i45 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData16, calendar37, calendar44);
    net.ajaskey.market.ta.DailyData dailyData46 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar37);
    java.lang.Double d47 = tickerData0.getSmaPerc130();
    // The following exception was thrown during execution in test generation
    try {
    tickerData0.generateDerived(true);
      org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException");
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArrayIndexOutOfBoundsException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "null\tnull\tnull\r\n"+ "'", str13.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str21 + "' != '" + "30-Jan-0001"+ "'", str21.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "java.util.GregorianCalendar[time=-62164808592948,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=52,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str22.equals("java.util.GregorianCalendar[time=-62164808592948,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=52,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str28 + "' != '" + "30-Jan-0001"+ "'", str28.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Fri 30-Jan-0001"+ "'", str29.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b38 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData46);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d47);

  }

  @Test
  public void test218() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test218"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    double d4 = derivedData0.getLow260();
    double d5 = derivedData0.getChg65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);

  }

  @Test
  public void test219() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test219"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getTrueLowData();
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate2(calendar5);
    net.ajaskey.market.ta.DailyData dailyData8 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData0, calendar5);
    double d9 = tickerData0.getAtrPercent23();
    net.ajaskey.market.ta.TrendType trendType10 = tickerData0.getSma130Trend();
    double[] d_array11 = tickerData0.getVolumeData();
    double[] d_array12 = tickerData0.getHighData();
    double d13 = tickerData0.getRsRaw();
    java.lang.Double d14 = tickerData0.getSmaPerc260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d14);

  }

  @Test
  public void test220() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test220"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    double d13 = dailyData11.getDailyRng();
    java.lang.Double d14 = dailyData11.getOi();
    double d15 = dailyData11.getDailyChg();
    dailyData11.setDailyChg((double)(-1L));
    double d18 = dailyData11.getDailyPercentChg();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);

  }

  @Test
  public void test221() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test221"); }


    net.ajaskey.market.ta.TickerData tickerData0 = null;
    net.ajaskey.market.ta.TickerData tickerData1 = null;
    java.util.Calendar calendar5 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str6 = net.ajaskey.market.misc.Utils.stringDate(calendar5);
    net.ajaskey.market.ta.DailyData dailyData13 = new net.ajaskey.market.ta.DailyData(calendar5, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    net.ajaskey.market.ta.DailyData dailyData14 = net.ajaskey.market.ta.TickerData.getDataOfDate(tickerData1, calendar5);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData16 = net.ajaskey.market.ta.TickerData.getSlice(tickerData0, calendar5, (int)'a');
    net.ajaskey.market.ta.TickerData tickerData17 = new net.ajaskey.market.ta.TickerData();
    double[] d_array18 = tickerData17.getVolumeData();
    double d19 = tickerData17.getChg65();
    double[] d_array20 = tickerData17.getOiData();
    double d21 = tickerData17.getMfi65();
    java.util.Calendar calendar25 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str26 = net.ajaskey.market.misc.Utils.stringDate(calendar25);
    java.lang.String str27 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar25);
    net.ajaskey.market.ta.TickerData tickerData28 = null;
    net.ajaskey.market.ta.TickerData tickerData29 = new net.ajaskey.market.ta.TickerData();
    double[] d_array30 = tickerData29.getTrueLowData();
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate2(calendar34);
    net.ajaskey.market.ta.DailyData dailyData37 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData29, calendar34);
    int i38 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData28, calendar34);
    boolean b39 = net.ajaskey.market.misc.Utils.sameYear(calendar25, calendar34);
    java.util.Calendar calendar43 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate(calendar43);
    java.lang.String str45 = net.ajaskey.market.misc.Utils.stringDate2(calendar43);
    int i46 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData17, calendar34, calendar43);
    java.util.Calendar calendar50 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str51 = net.ajaskey.market.misc.Utils.stringDate(calendar50);
    net.ajaskey.market.ta.DailyData dailyData58 = new net.ajaskey.market.ta.DailyData(calendar50, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.util.Calendar calendar62 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    boolean b63 = net.ajaskey.market.misc.Utils.sameYear(calendar50, calendar62);
    long long64 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar43, calendar62);
    java.util.Calendar calendar68 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)1, (int)'4', (int)(short)100);
    java.util.Calendar calendar72 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str73 = net.ajaskey.market.misc.Utils.stringDate(calendar72);
    java.lang.String str74 = net.ajaskey.market.misc.Utils.stringDate2(calendar72);
    boolean b75 = net.ajaskey.market.misc.Utils.sameYear(calendar68, calendar72);
    boolean b76 = net.ajaskey.market.misc.Utils.sameYear(calendar43, calendar68);
    boolean b77 = net.ajaskey.market.misc.Utils.sameDate(calendar5, calendar68);
    java.util.Calendar calendar78 = net.ajaskey.market.misc.Utils.makeCopy(calendar68);
    java.lang.String str79 = net.ajaskey.market.misc.Utils.getDayName(calendar68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d21 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "30-Jan-0001"+ "'", str26.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str27 + "' != '" + "java.util.GregorianCalendar[time=-62164808592933,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=67,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str27.equals("java.util.GregorianCalendar[time=-62164808592933,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=67,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "Fri 30-Jan-0001"+ "'", str36.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i38 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "30-Jan-0001"+ "'", str44.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str45 + "' != '" + "Fri 30-Jan-0001"+ "'", str45.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i46 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str51 + "' != '" + "30-Jan-0001"+ "'", str51.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar62);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b63 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long64 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar68);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar72);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str73 + "' != '" + "30-Jan-0001"+ "'", str73.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str74 + "' != '" + "Fri 30-Jan-0001"+ "'", str74.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b75 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b76 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b77 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar78);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str79 + "' != '" + "unknown-day"+ "'", str79.equals("unknown-day"));

  }

  @Test
  public void test222() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test222"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    double[] d_array3 = tickerData0.getOiData();
    double d4 = tickerData0.getChg();
    double d5 = tickerData0.getRsStRaw();
    java.lang.Double d6 = tickerData0.getSmaPerc260();
    tickerData0.fillDataArrays((int)(short)(-1), true);
    double d10 = tickerData0.getChg130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test223() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test223"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getPriceOffHigh260();
    java.lang.Double d6 = derivedData0.getSma260();
    java.lang.Double d7 = derivedData0.getSma130();
    double d8 = derivedData0.getChg23();
    double d9 = derivedData0.getMfi14();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test224() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test224"); }


    java.util.Calendar calendar0 = null;
    net.ajaskey.market.ta.TickerData tickerData1 = new net.ajaskey.market.ta.TickerData();
    double[] d_array2 = tickerData1.getTrueLowData();
    java.util.Calendar calendar6 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str7 = net.ajaskey.market.misc.Utils.stringDate(calendar6);
    java.lang.String str8 = net.ajaskey.market.misc.Utils.stringDate2(calendar6);
    net.ajaskey.market.ta.DailyData dailyData9 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData1, calendar6);
    double d10 = tickerData1.getAtrPercent23();
    double d11 = tickerData1.getMfi14();
    double[] d_array12 = tickerData1.getTrueLowData();
    double d13 = tickerData1.getPriceInRng260();
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str18 = net.ajaskey.market.misc.Utils.stringDate(calendar17);
    net.ajaskey.market.ta.DailyData dailyData25 = new net.ajaskey.market.ta.DailyData(calendar17, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    dailyData25.setTrueLow(0.0d);
    java.lang.Double d28 = dailyData25.getHigh();
    java.util.Calendar calendar29 = dailyData25.getDate();
    java.lang.String str30 = net.ajaskey.market.misc.Utils.getMonthName(calendar29);
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    long long36 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar29, calendar34);
    java.util.Calendar calendar37 = null;
    int i38 = net.ajaskey.market.ta.TickerData.getTradingDays(tickerData1, calendar34, calendar37);
    boolean b39 = net.ajaskey.market.misc.Utils.sameMonth(calendar0, calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "30-Jan-0001"+ "'", str7.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Fri 30-Jan-0001"+ "'", str8.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "30-Jan-0001"+ "'", str18.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d28 + "' != '" + 10.0d+ "'", d28.equals(10.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str30 + "' != '" + "unknown-month"+ "'", str30.equals("unknown-month"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long36 == 0L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i38 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b39 == false);

  }

  @Test
  public void test225() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test225"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getRsRaw();
    java.lang.Double d6 = derivedData0.getSma23();
    java.lang.Double d7 = derivedData0.getSma260();
    java.lang.Double d8 = derivedData0.getSmaPerc23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));

  }

  @Test
  public void test226() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test226"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d12 = dailyData11.getTrueHigh();
    double d13 = dailyData11.getDailyRng();
    java.lang.Double d14 = dailyData11.getLow();
    java.util.Calendar calendar15 = dailyData11.getDate();
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate2(calendar15);
    java.util.Calendar calendar17 = net.ajaskey.market.misc.Utils.makeCopy(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "Fri 30-Jan-0001"+ "'", str16.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);

  }

  @Test
  public void test227() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test227"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    double d7 = tickerData0.getCurrentPrice();
    double d8 = tickerData0.getChg260();
    net.ajaskey.market.ta.TickerData.clearTickerData(tickerData0);
    double d10 = tickerData0.getPriceOffHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);

  }

  @Test
  public void test228() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test228"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    java.lang.Double d4 = derivedData0.getSmaPerc260();
    double d5 = derivedData0.getMfi130();
    java.lang.Double d6 = derivedData0.getSmaPerc260();
    double d7 = derivedData0.getChg();
    double d8 = derivedData0.getDiPlus();
    double d9 = derivedData0.getCurrentPrice();
    double d10 = derivedData0.getRsRaw();
    double d11 = derivedData0.getCurrentPrice();
    double d12 = derivedData0.getAtrPercent23();
    java.lang.Double d13 = derivedData0.getSma130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d4 + "' != '" + 0.0d+ "'", d4.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d13 + "' != '" + 0.0d+ "'", d13.equals(0.0d));

  }

  @Test
  public void test229() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test229"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getRsRaw();
    java.lang.Double d6 = derivedData0.getSma23();
    double d7 = derivedData0.getLrInt260();
    double d8 = derivedData0.getMfi65();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d6 + "' != '" + 0.0d+ "'", d6.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test230() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test230"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    industryData0.setPriceInRange260((double)(byte)100);
    double d8 = industryData0.getRawRs();
    industryData0.setMarketCap("");
    industryData0.setRawRs((-99.0d));
    double d13 = industryData0.getAvgVol();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);

  }

  @Test
  public void test231() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test231"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)10, 100, (int)(byte)1);
    net.ajaskey.market.ta.TickerData tickerData11 = new net.ajaskey.market.ta.TickerData("101  ", calendar4, (double)2017L, (double)(byte)(-1), (double)(byte)(-1), 0.0d, (double)10L, (double)1L);
    java.util.Calendar calendar15 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str16 = net.ajaskey.market.misc.Utils.stringDate(calendar15);
    net.ajaskey.market.ta.DailyData dailyData23 = new net.ajaskey.market.ta.DailyData(calendar15, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    double d24 = dailyData23.getTrueHigh();
    dailyData23.setTrueHigh((double)(short)0);
    long long27 = dailyData23.getDaysSinceBase();
    double d28 = dailyData23.getTrueHigh();
    java.util.Calendar calendar29 = dailyData23.getDate();
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate2(calendar34);
    net.ajaskey.market.ta.TickerData tickerData43 = new net.ajaskey.market.ta.TickerData("hi!", calendar34, (double)(short)(-1), (double)(byte)10, (double)1, (-1.0d), (double)100.0f, (double)1);
    java.lang.String str44 = tickerData43.getTickerExchange();
    java.util.Calendar calendar45 = null;
    net.ajaskey.market.ta.TickerData tickerData46 = new net.ajaskey.market.ta.TickerData();
    double[] d_array47 = tickerData46.getTrueLowData();
    java.util.Calendar calendar51 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str52 = net.ajaskey.market.misc.Utils.stringDate(calendar51);
    java.lang.String str53 = net.ajaskey.market.misc.Utils.stringDate2(calendar51);
    net.ajaskey.market.ta.DailyData dailyData54 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData46, calendar51);
    boolean b55 = net.ajaskey.market.misc.Utils.sameYear(calendar45, calendar51);
    java.util.List<net.ajaskey.market.ta.DailyData> list_dailyData57 = net.ajaskey.market.ta.TickerData.getSlice(tickerData43, calendar51, (int)(byte)(-1));
    java.lang.String str58 = net.ajaskey.market.misc.Utils.getDayName(calendar51);
    java.lang.String str59 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar51);
    net.ajaskey.market.ta.DailyData dailyData66 = new net.ajaskey.market.ta.DailyData(calendar51, (double)(short)1, (double)0, (double)1, (double)(short)100, (double)1, 10.0d);
    java.lang.String str67 = net.ajaskey.market.misc.Utils.getDayName(calendar51);
    boolean b68 = net.ajaskey.market.misc.Utils.sameYear(calendar29, calendar51);
    long long69 = net.ajaskey.market.misc.Utils.getTimeSpan(calendar4, calendar51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "30-Jan-0001"+ "'", str16.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long27 == 693934L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d28 == 10.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "Fri 30-Jan-0001"+ "'", str36.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "Unknown"+ "'", str44.equals("Unknown"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array47);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar51);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str52 + "' != '" + "30-Jan-0001"+ "'", str52.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str53 + "' != '" + "Fri 30-Jan-0001"+ "'", str53.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData54);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b55 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(list_dailyData57);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str58 + "' != '" + "unknown-day"+ "'", str58.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str59 + "' != '" + "java.util.GregorianCalendar[time=-62164808592823,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=177,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str59.equals("java.util.GregorianCalendar[time=-62164808592823,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=177,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str67 + "' != '" + "unknown-day"+ "'", str67.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b68 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long69 == 6666L);

  }

  @Test
  public void test232() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test232"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setName("100");
    java.lang.String str3 = industryData0.getRanks();
    java.lang.String str4 = industryData0.getRanks();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));

  }

  @Test
  public void test233() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test233"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setChg260((double)10);
    java.lang.String str6 = industryData0.getRanks();
    industryData0.setSector("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00");
    java.lang.String str9 = industryData0.getSector();
    industryData0.setRawRs((double)2017L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + ""+ "'", str6.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"+ "'", str9.equals("Fri 30-Jan-0001  0.00  10.00  0.00  1.00     0     0      0.00      0.00"));

  }

  @Test
  public void test234() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test234"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    industryData0.setTicker("0");
    long long5 = industryData0.getShares();
    industryData0.setShares((long)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(long5 == 0L);

  }

  @Test
  public void test235() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test235"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    double d8 = tickerData0.getDiPlus();
    net.ajaskey.market.ta.TrendType trendType9 = tickerData0.getSma130Trend();
    java.lang.Double d10 = tickerData0.getSma260();
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    java.lang.String str16 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar14);
    int i17 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, calendar14);
    java.lang.String str18 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "java.util.GregorianCalendar[time=-62164808592792,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=208,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str16.equals("java.util.GregorianCalendar[time=-62164808592792,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=208,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i17 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "java.util.GregorianCalendar[time=-62164808592792,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=208,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str18.equals("java.util.GregorianCalendar[time=-62164808592792,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=208,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));

  }

  @Test
  public void test236() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test236"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    java.lang.Double d5 = derivedData0.getSmaPerc260();
    double d6 = derivedData0.getMfi130();
    java.lang.Double d7 = derivedData0.getSma65();
    java.lang.Double d8 = derivedData0.getSma130();
    java.lang.Double d9 = derivedData0.getSmaPerc23();
    double d10 = derivedData0.getMfi65();
    double d11 = derivedData0.getPriceOffHigh260();
    double d12 = derivedData0.getHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d5 + "' != '" + 0.0d+ "'", d5.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d8 + "' != '" + 0.0d+ "'", d8.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d9 + "' != '" + 0.0d+ "'", d9.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d10 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d11 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d12 == 0.0d);

  }

  @Test
  public void test237() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test237"); }


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
    java.lang.Double d25 = tickerData0.getSmaPerc130();
    java.lang.String str26 = tickerData0.getTickerExchange();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str10 + "' != '" + "30-Jan-0001"+ "'", str10.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d24 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str26);

  }

  @Test
  public void test238() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test238"); }


    java.util.ArrayList<java.lang.String> arraylist_str0 = new java.util.ArrayList<java.lang.String>();
    java.lang.String[] str_array2 = new java.lang.String[] { "" };
    boolean b3 = java.util.Collections.addAll((java.util.Collection<java.lang.String>)arraylist_str0, str_array2);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData4 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData5 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData8 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (int)'a');
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData9 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData10 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0);
    java.util.List<net.ajaskey.market.ta.TickerData> list_tickerData12 = net.ajaskey.market.ta.input.ParseData.parseFiles((java.util.List<java.lang.String>)arraylist_str0, (-100));
    net.ajaskey.market.ta.input.ParseData.setValidTickers((java.util.List<java.lang.String>)arraylist_str0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(list_tickerData12);

  }

  @Test
  public void test239() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test239"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getAvgVol20();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getDiPlus();
    double d5 = derivedData0.getAtrPercent23();
    double d6 = derivedData0.getHigh260();
    java.lang.Double d7 = derivedData0.getSmaPerc65();
    double d8 = derivedData0.getRsRaw();
    java.lang.Double d9 = derivedData0.getSmaPerc23();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d7 + "' != '" + 0.0d+ "'", d7.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d9 + "' != '" + 0.0d+ "'", d9.equals(0.0d));

  }

  @Test
  public void test240() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test240"); }


    net.ajaskey.market.ta.TickerData tickerData0 = new net.ajaskey.market.ta.TickerData();
    double[] d_array1 = tickerData0.getVolumeData();
    double d2 = tickerData0.getChg65();
    int i6 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData0, (int)(short)(-1), (int)(byte)100, (int)(short)100);
    net.ajaskey.market.ta.TrendType trendType7 = tickerData0.getSma130Trend();
    net.ajaskey.market.ta.TickerData.sortDailyData(tickerData0, true);
    double[] d_array10 = tickerData0.getOpenData();
    double[] d_array11 = tickerData0.getCloseData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(trendType7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array11);

  }

  @Test
  public void test241() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test241"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    net.ajaskey.market.ta.DailyData dailyData12 = new net.ajaskey.market.ta.DailyData(calendar4, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.String str13 = net.ajaskey.market.misc.Utils.stringDate2(calendar4);
    net.ajaskey.market.ta.TickerData tickerData20 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808640583,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=59,MILLISECOND=417,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar4, (double)(-100), (double)(byte)0, (double)0L, (double)2016L, (double)(short)1, (double)' ');
    java.util.Calendar calendar21 = net.ajaskey.market.misc.Utils.makeCopy(calendar4);
    java.lang.String str22 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Fri 30-Jan-0001"+ "'", str13.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str22 + "' != '" + "30-Jan-0001"+ "'", str22.equals("30-Jan-0001"));

  }

  @Test
  public void test242() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test242"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getChg130();
    double d2 = derivedData0.getAvgVol20();
    java.lang.Double d3 = derivedData0.getSma130();
    double d4 = derivedData0.getRsi14();
    double d5 = derivedData0.getChg65();
    double d6 = derivedData0.getPriceOffLow260();
    double d7 = derivedData0.getLr260();
    double d8 = derivedData0.getDiPlus();
    double d9 = derivedData0.getChg130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);

  }

  @Test
  public void test243() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test243"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    java.lang.Double d3 = derivedData0.getSmaPerc65();
    double d4 = derivedData0.getLrAngle260();
    double d5 = derivedData0.getRsRaw();
    double d6 = derivedData0.getDiPlus();
    double d7 = derivedData0.getAvgVol20();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);

  }

  @Test
  public void test244() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test244"); }


    java.util.Calendar calendar4 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str5 = net.ajaskey.market.misc.Utils.stringDate(calendar4);
    java.lang.String str6 = net.ajaskey.market.misc.Utils.getDayName(calendar4);
    net.ajaskey.market.misc.Utils.printCalendar(calendar4);
    java.util.Calendar calendar8 = null;
    boolean b9 = net.ajaskey.market.misc.Utils.sameMonth(calendar4, calendar8);
    java.util.Calendar calendar10 = net.ajaskey.market.misc.Utils.makeCopy(calendar4);
    java.util.Calendar calendar14 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str15 = net.ajaskey.market.misc.Utils.stringDate(calendar14);
    java.lang.String str16 = net.ajaskey.market.misc.Utils.calendarToLongString(calendar14);
    net.ajaskey.market.ta.TickerData tickerData17 = null;
    net.ajaskey.market.ta.TickerData tickerData18 = new net.ajaskey.market.ta.TickerData();
    double[] d_array19 = tickerData18.getTrueLowData();
    java.util.Calendar calendar23 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str24 = net.ajaskey.market.misc.Utils.stringDate(calendar23);
    java.lang.String str25 = net.ajaskey.market.misc.Utils.stringDate2(calendar23);
    net.ajaskey.market.ta.DailyData dailyData26 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData18, calendar23);
    int i27 = net.ajaskey.market.ta.TickerData.getIndexOfDate(tickerData17, calendar23);
    boolean b28 = net.ajaskey.market.misc.Utils.sameYear(calendar14, calendar23);
    net.ajaskey.market.ta.TickerData tickerData29 = new net.ajaskey.market.ta.TickerData();
    double[] d_array30 = tickerData29.getTrueLowData();
    java.util.Calendar calendar34 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str35 = net.ajaskey.market.misc.Utils.stringDate(calendar34);
    java.lang.String str36 = net.ajaskey.market.misc.Utils.stringDate2(calendar34);
    net.ajaskey.market.ta.DailyData dailyData37 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData29, calendar34);
    double d38 = tickerData29.getAtrPercent23();
    double d39 = tickerData29.getDiPlus();
    java.util.Calendar calendar43 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str44 = net.ajaskey.market.misc.Utils.stringDate(calendar43);
    net.ajaskey.market.ta.DailyData dailyData51 = new net.ajaskey.market.ta.DailyData(calendar43, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d52 = dailyData51.getClose();
    double d53 = dailyData51.getDailyPercentChg();
    tickerData29.addData(dailyData51);
    java.util.Calendar calendar58 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str59 = net.ajaskey.market.misc.Utils.stringDate(calendar58);
    java.lang.String str60 = net.ajaskey.market.misc.Utils.stringDate2(calendar58);
    net.ajaskey.market.ta.DailyData dailyData61 = net.ajaskey.market.ta.TickerData.getDailyDate(tickerData29, calendar58);
    boolean b62 = net.ajaskey.market.misc.Utils.sameMonth(calendar23, calendar58);
    boolean b63 = net.ajaskey.market.misc.Utils.sameDate(calendar10, calendar23);
    net.ajaskey.market.ta.TickerData tickerData70 = new net.ajaskey.market.ta.TickerData("java.util.GregorianCalendar[time=-62164808650011,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=989,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n", calendar10, (double)1L, 100.0d, (double)'4', 52.0d, (double)2016L, (double)(short)0);
    double d71 = tickerData70.getRsRaw();
    java.util.Calendar[] calendar_array72 = tickerData70.getDateData();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "30-Jan-0001"+ "'", str5.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "unknown-day"+ "'", str6.equals("unknown-day"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str15 + "' != '" + "30-Jan-0001"+ "'", str15.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str16 + "' != '" + "java.util.GregorianCalendar[time=-62164808592730,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=270,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str16.equals("java.util.GregorianCalendar[time=-62164808592730,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=270,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str24 + "' != '" + "30-Jan-0001"+ "'", str24.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "Fri 30-Jan-0001"+ "'", str25.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b28 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str35 + "' != '" + "30-Jan-0001"+ "'", str35.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str36 + "' != '" + "Fri 30-Jan-0001"+ "'", str36.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d38 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d39 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str44 + "' != '" + "30-Jan-0001"+ "'", str44.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d52 + "' != '" + 1.0d+ "'", d52.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d53 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar58);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str59 + "' != '" + "30-Jan-0001"+ "'", str59.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str60 + "' != '" + "Fri 30-Jan-0001"+ "'", str60.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(dailyData61);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b62 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b63 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d71 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(calendar_array72);

  }

  @Test
  public void test245() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test245"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    java.lang.Double d2 = derivedData0.getSmaPerc260();
    java.lang.Double d3 = derivedData0.getSmaPerc260();
    double d4 = derivedData0.getRsStRaw();
    double d5 = derivedData0.getPriceOffHigh260();
    double d6 = derivedData0.getLr260();
    double d7 = derivedData0.getAtr23();
    double d8 = derivedData0.getPriceOffHigh260();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d2 + "' != '" + 0.0d+ "'", d2.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d3 + "' != '" + 0.0d+ "'", d3.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d7 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);

  }

  @Test
  public void test246() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test246"); }


    java.util.Calendar calendar3 = net.ajaskey.market.misc.Utils.buildCalendar((int)(byte)0, 1, (int)(short)(-1));
    java.lang.String str4 = net.ajaskey.market.misc.Utils.stringDate(calendar3);
    net.ajaskey.market.ta.DailyData dailyData11 = new net.ajaskey.market.ta.DailyData(calendar3, (double)(short)0, (double)(byte)10, (double)(byte)0, (double)(short)1, (double)0L, (double)0.0f);
    java.lang.Double d12 = dailyData11.getClose();
    double d13 = dailyData11.getTrueLow();
    java.lang.Double d14 = dailyData11.getOpen();
    dailyData11.setVolume((double)'#');
    double d17 = dailyData11.getDailyPercentChg();
    double d18 = dailyData11.getDailyRng();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "30-Jan-0001"+ "'", str4.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d12 + "' != '" + 1.0d+ "'", d12.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d13 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d14 + "' != '" + 0.0d+ "'", d14.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d17 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);

  }

  @Test
  public void test247() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test247"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808652055,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=47,MILLISECOND=945,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setRank((int)(byte)10);
    industryData0.setShares((long)10);
    java.lang.String str10 = industryData0.getName();
    industryData0.setSector("java.util.GregorianCalendar[time=-62164808650589,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,SECOND=49,MILLISECOND=411,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n");
    industryData0.setAvgVol((double)(byte)1);
    industryData0.setChg260((double)100.0f);
    industryData0.setSlope(100.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str10);

  }

  @Test
  public void test248() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test248"); }


    net.ajaskey.market.ta.IndustryData industryData0 = new net.ajaskey.market.ta.IndustryData();
    industryData0.setChg260((double)(byte)(-1));
    java.lang.String str3 = industryData0.getSector();
    industryData0.setRank(100);
    industryData0.setRank(0);
    double d8 = industryData0.getRawRsSt();
    java.lang.String str9 = industryData0.getTicker();
    industryData0.setAvgVol((double)6666L);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d8 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(str9);

  }

  @Test
  public void test249() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test249"); }


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
    net.ajaskey.market.ta.methods.TaMethods taMethods17 = tickerData0.getTaMethods();
    double d18 = tickerData0.getDiMinus();
    double d19 = tickerData0.getCurrentPrice();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str13 + "' != '" + "null\tnull\tnull\r\n"+ "'", str13.equals("null\tnull\tnull\r\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d14 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d15 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d16 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(taMethods17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d18 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d19 == 0.0d);

  }

  @Test
  public void test250() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test250"); }


    net.ajaskey.market.ta.DerivedData derivedData0 = new net.ajaskey.market.ta.DerivedData();
    double d1 = derivedData0.getRsStRaw();
    double d2 = derivedData0.getPriceOffLow260();
    double d3 = derivedData0.getLr260();
    double d4 = derivedData0.getChg130();
    double d5 = derivedData0.getChg260();
    double d6 = derivedData0.getMfi130();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d1 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d2 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d3 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d4 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d5 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d6 == 0.0d);

  }

  @Test
  public void test251() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest7.test251"); }


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
    double d54 = dailyData50.getTrueLow();
    double d55 = dailyData50.getDailyChg();
    java.lang.Double d56 = dailyData50.getOpen();
    java.lang.Double d57 = dailyData50.getClose();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "30-Jan-0001"+ "'", str6.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Fri 30-Jan-0001"+ "'", str7.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d9 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(d_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str18 + "' != '" + "30-Jan-0001"+ "'", str18.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str19 + "' != '" + "java.util.GregorianCalendar[time=-62164808592574,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=426,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"+ "'", str19.equals("java.util.GregorianCalendar[time=-62164808592574,areFieldsSet=true,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"America/Denver\",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=157,lastRule=java.util.SimpleTimeZone[id=America/Denver,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=0,YEAR=1,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=30,DAY_OF_YEAR=30,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=36,SECOND=47,MILLISECOND=426,ZONE_OFFSET=-25200000,DST_OFFSET=0]\n  Year         : 1\n  Month        : 0\n  Day of Month : 30\n  Day of Year  : 30\n  Week of Year : 5\n"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str25 + "' != '" + "30-Jan-0001"+ "'", str25.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str26 + "' != '" + "Fri 30-Jan-0001"+ "'", str26.equals("Fri 30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b35 == true);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(dailyData36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(calendar42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str43 + "' != '" + "30-Jan-0001"+ "'", str43.equals("30-Jan-0001"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d51 + "' != '" + 1.0d+ "'", d51.equals(1.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d52 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d54 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(d55 == 0.0d);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d56 + "' != '" + 0.0d+ "'", d56.equals(0.0d));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + d57 + "' != '" + 1.0d+ "'", d57.equals(1.0d));

  }

}
