package saman.zamani.persiandate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Test;

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
    assertFalse(pDate.addDay(1).isToday());
  }
  @Test
  public void testIsTodayMethodWithParameter() throws Exception {
    PersianDate pDate = new PersianDate();
    assertTrue(pDate.isToday(new PersianDate()));
    assertFalse(pDate.isToday(new PersianDate().subDay()));
  }
}
