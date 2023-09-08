package saman.zamani.persiandate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Test;
import saman.zamani.persiandate.PersianDate.Dialect;

public class PersianDateTest {
  public String testStringHelper(int j) {
    if (j < 10) {
      return "0" + j;
    } else {
      return "" + j;
    }
  }

  public final String testCase = "{'1981':{'04':{'15':'13600126'},'01':{'09':'13591019'}},'1923':{'05':{'03':'13020212'}},'1993':{'03':{'30':'13720110'},'02':{'13':'13711124'}},'2041':{'09':{'14':'14200624'},'12':{'12':'14200922'}},'1920':{'01':{'06':'12981015'},'08':{'25':'12990603'}},'1977':{'10':{'16':'13560724'}},'2098':{'05':{'07':'14770218'},'12':{'15':'14770925'}},'2063':{'11':{'15':'14420824'}},'2061':{'08':{'06':'14400516'},'09':{'28':'14400707'}},'1974':{'11':{'07':'13530816'}},'2056':{'10':{'23':'14350802'}},'1924':{'10':{'27':'13030805'},'02':{'25':'13021205','23':'13021203'}},'1906':{'12':{'08':'12850916'},'01':{'01':'12841011'}},'1908':{'01':{'13':'12861022'}},'2053':{'12':{'20':'14320930'}},'2038':{'06':{'08':'14170318'},'02':{'10':'14161122'},'01':{'09':'14161020'}},'1975':{'07':{'06':'13540415'}},'1921':{'08':{'02':'13000511'}},'2040':{'09':{'14':'14190624'}},'1990':{'12':{'09':'13690918'}},'2019':{'02':{'04':'13971115'}},'2082':{'05':{'29':'14610309'},'11':{'27':'14610907'}},'2021':{'07':{'27':'14000505'}},'2018':{'08':{'21':'13970530'},'02':{'16':'13961127'}},'1996':{'10':{'26':'13750805'}},'1913':{'12':{'12':'12920921'}},'2090':{'07':{'04':'14690414'}},'2074':{'04':{'17':'14530129'}},'1942':{'10':{'08':'13210716'}},'2023':{'01':{'27':'14011107'},'08':{'21':'14020530'}},'1949':{'10':{'15':'13280723'}},'2087':{'03':{'28':'14660108'}},'2088':{'09':{'02':'14670612'}},'1904':{'05':{'11':'12830221'}},'1936':{'08':{'23':'13150601'},'02':{'13':'13141123'},'01':{'15':'13141024'}},'2043':{'05':{'28':'14220307'}},'2010':{'06':{'01':'13890311'}},'1950':{'03':{'23':'13290103'},'10':{'06':'13290714'}},'2055':{'03':{'13':'14331222'}},'2094':{'02':{'22':'14721204'}},'1952':{'07':{'03':'13310412'}},'1930':{'01':{'27':'13081107'}},'1969':{'10':{'03':'13480711'}},'1926':{'08':{'12':'13050520'}},'1962':{'11':{'14':'13410823'}},'1965':{'03':{'07':'13431216'}},'1907':{'07':{'11':'12860419'}},'1954':{'02':{'18':'13321129'}},'1955':{'08':{'10':'13340518'}},'1959':{'04':{'15':'13380125'}},'2064':{'05':{'18':'14430229'}},'2078':{'01':{'17':'14561028'}},'2022':{'07':{'28':'14010506'}},'1994':{'07':{'16':'13730425'}},'1970':{'06':{'07':'13490317'},'03':{'01':'13481210'}},'2068':{'10':{'25':'14470804'},'05':{'11':'14470222'}},'2037':{'09':{'15':'14160625'}},'2048':{'01':{'04':'14261014'}},'1992':{'05':{'24':'13710303'}},'2065':{'04':{'17':'14440129'}},'2052':{'02':{'26':'14301207'}},'2085':{'12':{'12':'14640922'}},'1999':{'08':{'26':'13780604'}},'2044':{'12':{'10':'14230920'}},'1912':{'09':{'29':'12910707'}},'2042':{'08':{'26':'14210604'}},'2032':{'05':{'09':'14110220'}},'1916':{'02':{'27':'12941207'},'09':{'09':'12950618'}},'2079':{'07':{'07':'14580416'}},'2039':{'07':{'03':'14180412'}},'1917':{'12':{'30':'12961009'}},'1987':{'07':{'27':'13660505'}},'2027':{'12':{'31':'14061010'}},'1910':{'12':{'16':'12890924'}},'2008':{'02':{'09':'13861120'}},'1958':{'05':{'29':'13370308'}},'1935':{'06':{'09':'13140318'}},'2009':{'08':{'09':'13880518'}},'1903':{'02':{'06':'12811116'}},'2083':{'02':{'11':'14611123'}}}";


  @Test
  public void JalaliToGrgTest() throws Exception {
    JSONObject obj = new JSONObject(testCase);

    for (int i = 1981; i <= 2083; i++) {
      if (!obj.isNull("" + i)) {
        for (int j = 1; j <= 12; j++) {
          if (!obj.getJSONObject("" + i).isNull(testStringHelper(j))) {
            for (int k = 1; k <= 31; k++) {
              if (!obj.getJSONObject("" + i).getJSONObject(testStringHelper(j))
                  .isNull(testStringHelper(k))) {
                String jalali = obj.getJSONObject("" + i).getJSONObject(testStringHelper(j))
                    .getString(testStringHelper(k));
                int jalaliYear = Integer.parseInt(jalali.substring(0, 4));
                int jalaliMonth = Integer.parseInt(jalali.substring(4, 6));
                int jalaliDay = Integer.parseInt(jalali.substring(6, 8));
                PersianDate pDate = new PersianDate()
                    .initJalaliDate(jalaliYear, jalaliMonth, jalaliDay);
                assertEquals("" + i + j + k,
                    "" + pDate.getGrgYear() + pDate.getGrgMonth() + pDate.getGrgDay());
              }
            }
          }
        }
      }
    }
  }

  @Test
  public void grgToJalaliTest() throws Exception {
    JSONObject obj = new JSONObject(testCase);

    for (int i = 1981; i <= 2083; i++) {
      if (!obj.isNull("" + i)) {
        for (int j = 1; j <= 12; j++) {
          if (!obj.getJSONObject("" + i).isNull(testStringHelper(j))) {
            for (int k = 1; k <= 31; k++) {
              if (!obj.getJSONObject("" + i).getJSONObject(testStringHelper(j))
                  .isNull(testStringHelper(k))) {
                assertEquals(
                    PersianDateFormat.format(new PersianDate().initGrgDate(i, j, k), "Ymd"),
                    obj.getJSONObject("" + i).getJSONObject(testStringHelper(j))
                        .getString(testStringHelper(k)));
              }
            }
          }
        }
      }
    }
  }

  @Test
  public void reportedBug() throws Exception {
    Map<String, PersianDate> dates = new HashMap<>();
    dates.put("19891226", new PersianDate()
        .initJalaliDate(1368, 10, 5));//https://github.com/samanzamani/PersianDate/issues/29
    //https://github.com/samanzamani/PersianDate/issues/16
    //https://github.com/samanzamani/PersianDate/issues/35
    dates.put("2030320", new PersianDate().initJalaliDate(1408, 12, 30));
    dates.put("2030321", new PersianDate().initJalaliDate(1409, 1, 1));
    dates.put("2025320", new PersianDate().initJalaliDate(1403, 12, 30));
    dates.put("2025321", new PersianDate().initJalaliDate(1404, 1, 1));
    dates.put("2026320", new PersianDate().initJalaliDate(1404, 12, 29));
    dates.put("2026321", new PersianDate().initJalaliDate(1405, 1, 1));
    dates.put("2029319", new PersianDate().initJalaliDate(1407, 12, 29));
    dates.put("2029320", new PersianDate().initJalaliDate(1408, 1, 1));

    for (Map.Entry<String, PersianDate> entry : dates.entrySet()) {
      String key = entry.getKey();
      PersianDate value = entry.getValue();
      assertEquals(key, "" + value.getGrgYear() + value.getGrgMonth() + value.getGrgDay());
    }
  }

  //https://github.com/samanzamani/PersianDate/issues/42
  @Test
  public void testTimestamp() throws Exception {
    PersianDate pDate = new PersianDate().initJalaliDate(1360, 8, 2);
    assertEquals("13600802", PersianDateFormat.format(new PersianDate(pDate.getTime()), "Ymd"));
  }

  @Test
  public void testIsTodayMethodWithoutParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    assertTrue(pDate.isToday());
    assertFalse(pDate.addDay().isToday());
  }
  @Test
  public void testIsTodayMethodWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    assertTrue(pDate.isToday(new PersianDate()));
    assertFalse(pDate.isToday(new PersianDate().subDay()));
  }

  @Test
  public void testSetJalaliMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(1);
    assertEquals(1, pDate.getShMonth());
    pDate.setShMonth(12);
    assertEquals(12, pDate.getShMonth());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliMonthExceptionBiggerThan12() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliMonthExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(0);
  }

  @Test
  public void testSetJalaliYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(1395);
    assertEquals(1395, pDate.getShYear());
    pDate.setShYear(1396);
    assertEquals(1396, pDate.getShYear());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliYearExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(0);
  }

  @Test
  public void testSetJalaliDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(1);
    assertEquals(1, pDate.getShDay());
    pDate.setShDay(27);
    assertEquals(27, pDate.getShDay());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliDayExceptionBiggerThan31() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(32);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliDayExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetJalaliDayExceptionWrongDayForMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(11);
    pDate.setShDay(31);
  }

  @Test
  public void testSetGrgYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgYear(2017);
    assertEquals(2017, pDate.getGrgYear());
    pDate.setGrgYear(2022);
    assertEquals(2022, pDate.getGrgYear());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgYearExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgYear(0);
  }

  @Test
  public void testSetGrgMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(1);
    assertEquals(1, pDate.getGrgMonth());
    pDate.setGrgMonth(12);
    assertEquals(12, pDate.getGrgMonth());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgMonthExceptionBiggerThan12() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgMonthExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(0);
  }

  @Test
  public void testSetGrgDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgDay(1);
    assertEquals(1, pDate.getGrgDay());
    pDate.setGrgDay(27);
    assertEquals(27, pDate.getGrgDay());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgDayExceptionBiggerThan31() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgDay(32);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgDayExceptionSmallerThan1() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgDay(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetGrgDayExceptionWrongDayForMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(11);
    pDate.setGrgDay(31);
  }

  @Test
  public void testGetGrgMonthLengthWithParameter(){
    PersianDate pDate = new PersianDate();
    PersianDate pDate2 = new PersianDate();
    assertEquals(31, pDate2.getGrgMonthLength(pDate.setGrgMonth(1).toDate()));
    assertEquals(28, pDate2.getGrgMonthLength(pDate.setGrgMonth(2).toDate()));
    assertEquals(31, pDate2.getGrgMonthLength(pDate.setGrgMonth(3).toDate()));
    assertEquals(30, pDate2.getGrgMonthLength(pDate.setGrgMonth(4).toDate()));
    assertEquals(31, pDate2.getGrgMonthLength(pDate.setGrgMonth(5).toDate()));
    assertEquals(30, pDate2.getGrgMonthLength(pDate.setGrgMonth(6).toDate()));
    assertEquals(31, pDate2.getGrgMonthLength(pDate.setGrgMonth(7).toDate()));
    assertEquals(31, pDate2.getGrgMonthLength(pDate.setGrgMonth(8).toDate()));
    assertEquals(30, pDate2.getGrgMonthLength(pDate.setGrgMonth(9).toDate()));
  }

  @Test
  public void testGetGrgMonthLengthWithoutParameter(){
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(1);
    assertEquals(31, pDate.getGrgMonthLength(pDate.toDate()));
  }

  @Test
  public void testSetSecond() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(10);
    assertEquals(10, pDate.getSecond());
  }
  @Test(expected = IllegalArgumentException.class)
  public void testSetSecondWithInvalidValue() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(60);
  }

  @Test
  public void testSetMinute() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(10);
    assertEquals(10, pDate.getMinute());
  }
  @Test(expected = IllegalArgumentException.class)
  public void testSetMinuteWithInvalidValue() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(60);
  }

  @Test
  public void testSetHour() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(10);
    assertEquals(10, pDate.getHour());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetHourWithInvalidValue() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(24);
  }

  @Test
  public void testGetGrgMonthLength() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(1);
    assertEquals(31, pDate.getGrgMonthLength());
  }

  @Test
  public void testGetGrgMonthLengthWithDateParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setGrgMonth(1);
    assertEquals(31, pDate.getGrgMonthLength(pDate.toDate()));
  }

  @Test
  public void testGetGrgMonthLengthWithYearAndMonthParameters() throws Exception {
    PersianDate pDate = new PersianDate();
    assertEquals(31, pDate.getGrgMonthLength(2022,1));
  }

  @Test
  public void testInitGrgDate() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,1,1,23,59,13);
    assertEquals(2022, pDate.getGrgYear());
    assertEquals(1, pDate.getGrgMonth());
    assertEquals(1, pDate.getGrgDay());
    assertEquals(23, pDate.getHour());
    assertEquals(59, pDate.getMinute());
    assertEquals(13, pDate.getSecond());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(0,13,1,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,13,1,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,1,0,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidDayForSpecificMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,11,31,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidHour() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,1,1,24,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidMinute() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,1,1,23,60,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitGrgDateWithInvalidSecond() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initGrgDate(2022,1,1,23,59,60);
  }

  @Test
  public void testDefaultDialect() {
    PersianDate pDate = new PersianDate();
    assertEquals(Dialect.IRANIAN, pDate.getDialect());
  }

  @Test
  public void testSetDialect() {
    PersianDate pDate = new PersianDate();
    pDate.setDialect(Dialect.IRANIAN);
    assertEquals(Dialect.IRANIAN, pDate.getDialect());
  }

  @Test
  public void testGetDialect() {
    PersianDate pDate = new PersianDate();
    pDate.setDialect(Dialect.PASHTO);
    assertEquals(Dialect.PASHTO, pDate.getDialect());
    pDate.setDialect(Dialect.AFGHAN);
    assertEquals(Dialect.AFGHAN, pDate.getDialect());
  }

  @Test
  public void testInitJalaliDate() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,1,1,23,59,13);
    assertEquals(1399, pDate.getShYear());
    assertEquals(1, pDate.getShMonth());
    assertEquals(1, pDate.getShDay());
    assertEquals(23, pDate.getHour());
    assertEquals(59, pDate.getMinute());
    assertEquals(13, pDate.getSecond());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(0,13,1,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,13,1,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,1,0,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidDayForSpecificMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,11,31,23,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidHour() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,1,1,24,59,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidMinute() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,1,1,23,60,13);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInitJalaliDateWithInvalidSecond() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.initJalaliDate(1399,1,1,23,59,60);
  }

  //test add dates methods
  @Test
  public void testAddDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(1);
    pDate.addDay();
    assertEquals(2, pDate.getShDay());
  }

  @Test
  public void testAddDayWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(1);
    pDate.addDays(2);
    assertEquals(3, pDate.getShDay());
  }

  @Test
  public void testAddMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(1);
    pDate.addMonth();
    assertEquals(2, pDate.getShMonth());
  }

  @Test
  public void testAddMonthWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(1);
    pDate.addMonths(2);
    assertEquals(3, pDate.getShMonth());
  }

  @Test
  public void testAddYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(1399);
    pDate.addYear();
    assertEquals(1400, pDate.getShYear());
  }

  @Test
  public void testAddYearWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(1399);
    pDate.addYears(2);
    assertEquals(1401, pDate.getShYear());
  }

  @Test
  public void testAddHour() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(1);
    pDate.addHour();
    assertEquals(2, pDate.getHour());
  }

  @Test
  public void testAddHourWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(1);
    pDate.addHours(2);
    assertEquals(3, pDate.getHour());
  }

  @Test
  public void testAddMinute() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(1);
    pDate.addMinute();
    assertEquals(2, pDate.getMinute());
  }

  @Test
  public void testAddMinuteWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(1);
    pDate.addMinutes(2);
    assertEquals(3, pDate.getMinute());
  }

  @Test
  public void testAddSecond() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(1);
    pDate.addSecond();
    assertEquals(2, pDate.getSecond());
  }

  @Test
  public void testAddSecondWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(1);
    pDate.addSeconds(2);
    assertEquals(3, pDate.getSecond());
  }

  @Test
  public void testAddWeek() throws Exception {
    PersianDate pDate = new PersianDate().initJalaliDate(1399,1,1);
    pDate.addWeek();
    assertEquals(8, pDate.getShDay());
  }

  @Test
  public void testAddWeekWithParameter() throws Exception {
    PersianDate pDate = new PersianDate().initJalaliDate(1399,1,1);
    pDate.addWeeks(3);
    assertEquals(22, pDate.getShDay());
  }

  //test sub dates
  @Test
  public void testSubDay() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(3);
    pDate.subDay();
    assertEquals(2, pDate.getShDay());
  }

  @Test
  public void testSubDayWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShDay(3);
    pDate.subDays(2);
    assertEquals(1, pDate.getShDay());
  }

  @Test
  public void testSubMonth() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(3);
    pDate.subMonth();
    assertEquals(2, pDate.getShMonth());
  }

  @Test
  public void testSubMonthWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShMonth(3);
    pDate.subMonths(2);
    assertEquals(1, pDate.getShMonth());
  }

  @Test
  public void testSubYear() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(1399);
    pDate.subYear();
    assertEquals(1398, pDate.getShYear());
  }

  @Test
  public void testSubYearWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setShYear(1399);
    pDate.subYears(2);
    assertEquals(1397, pDate.getShYear());
  }

  @Test
  public void testSubHour() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(3);
    pDate.subHour();
    assertEquals(2, pDate.getHour());
  }

  @Test
  public void testSubHourWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setHour(3);
    pDate.subHours(2);
    assertEquals(1, pDate.getHour());
  }

  @Test
  public void testSubMinute() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(3);
    pDate.subMinute();
    assertEquals(2, pDate.getMinute());
  }

  @Test
  public void testSubMinuteWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setMinute(3);
    pDate.subMinutes(2);
    assertEquals(1, pDate.getMinute());
  }

  @Test
  public void testSubSecond() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(3);
    pDate.subSecond();
    assertEquals(2, pDate.getSecond());
  }

  @Test
  public void testSubSecondWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    pDate.setSecond(3);
    pDate.subSeconds(2);
    assertEquals(1, pDate.getSecond());
  }

  @Test
  public void testSubWeek() throws Exception {
    PersianDate pDate = new PersianDate().initJalaliDate(1399,1,8);
    pDate.subWeek();
    assertEquals(1, pDate.getShDay());
  }

  @Test
  public void testSubWeekWithParameter() throws Exception {
    PersianDate pDate = new PersianDate().initJalaliDate(1399,1,22);
    pDate.subWeeks(3);
    assertEquals(1, pDate.getShDay());
  }

}
