# Persian Date(Jalali)
[![forthebadge](https://forthebadge.com/images/badges/built-for-android.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
<br/>
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![](https://jitpack.io/v/samanzamani/PersianDate.svg)](https://jitpack.io/#samanzamani/PersianDate)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-PersianDate-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6141)
[![Method and size](https://img.shields.io/badge/Methods%20and%20size-100%20|%2011%20KB-e91e63.svg)](http://www.methodscount.com/?lib=com.github.samanzamani.persiandate%3APersianDate%3A0.1)


# Short about stable version
After 4 years (since 2017) and more than 8 versions of this library, I believe that this is the stable version of this library.
 Note that there is some bug in the core function and I prefer to use 2 methods from [jdf](https://jdf.scr.ir/) library.
 The stable version includes some new features and bugs fixed that I will talk about more in the wiki part. 
 Special Thanks to all contributors and reporters.

# Install
## Gradle
Step 1.Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Step 2.Add the dependency
```groovy
dependencies {
    implementation 'com.github.samanzamani.persiandate:PersianDate:1.1'
}
```
# what's new
### version 1.0
* I will create a wiki part to introduce new features.

### version 0.8
* Fix date formatting in year 1989 [#29](https://github.com/samanzamani/PersianDate/issues/29)
* add three new method to get month name in `Afghan`,`Kurdish` and `Pashto` name and from version 0.8 you can use `X`,`C` and `E` to display month name in `Afghan`,`Kurdish` and `Pashto` in `PersianDateFormat` [#28](https://github.com/samanzamani/PersianDate/issues/28)



## Let's convert some date :)

### Step 1

```java
PersianDate pdate = new PersianDate();
```

### Step 2

```java
PersianDateFormat pdformater = new PersianDateFormat();
pdformater.format(pdate);
```
[More example](#example)

***PersianDate***
---
+ **PersianDate class methods**

| method        | description  |
| ------------- | -----|
| PersianDate(Long timestamp)      | make time with timestamp |
| PersianDate(DATE date)      |   Constractor for make PersianDate object from Date object  |
| setShYear(int year) |    Set Jalali year |
| setShMonth(int month) |    Set Jalali month |
| setShDay(int day) |    Set Jalali day |
| setGrgYear(int year) |    Set Gregorian year |
| setGrgMonth(int month) |    Set Gregorian month |
| setGrgDay(int day) |    Set Gregorian day |
| setHour(int hour) |    Set hour of day |
| setMinute(int minute) |    Set minute of day |
| setSecond(int second) |    Set second of day |
| getShYear() |    (int) return Jalali year |
| getShMonth() |    (int) return Jalali month |
| getShDay() |    (int) return Jalali day |
| getGrgYear() |    (int) return Gregorian year |
| getGrgMonth() |    (int) return Gregorian month |
| getGrgDay() |    (int) return Gregorian day |
| getHour() |    (int) return hour of day |
| getMinute() |    (int) return minute of day |
| getSecond() |    (int) return second of day |
| getTime() |    (Long) return timestamp |
| initGrgDate() |   init date from Gregorian |
| initJalaliDate() |   init date from Jalali |
| isLeap() |   Check Jalali year is leap (TRUE-FALSE) |
| grgIsLeap() |   Check Gregorian year is leap (TRUE-FALSE) |
| toJalali(int year, int month, int day) |  Convert  Gregorian to Jalali (return int[3]) |
| toGregorian(int year, int month, int day) |  Convert  Jalali to Gregorian (return int[3]) |
| dayOfWeek() |   0-6 (0=sat) |
| getDayInYear() |   1-366 |
| dayName() |   شنبه-جمعه |
| monthName() |   فروردین-اسفند |
| getMonthDays() |   return month lenght |
| addDate() |   add some date to object |
| after(PersianDate dateInput) |   Compare 2 date (true=if input date after this) |
| before(PersianDate dateInput) |   Compare 2 date (true=if input date before this) |
| equals(PersianDate dateInput) |   Compare 2 date (true=if input date equals this) |
| untilToday() |   Cal year,month,day until now |
| getDayuntilToday() |   Cal day until now |
| toDate |   convert to Date object |


***PersianDateFormat***
---
+ **PersianDate class methods for display and parse date**

| method        | description  |
| ------------- | -----|
| format()      | (String) Display date |
| parse(String date,String pattern)      | (PersianDate) Convert string Jalali date (1396-05-05 & 'YYYY-MM-dd') to Persiandate |
| parseGrg(String date,String pattern)      | (PersianDate) Convert string Gregorian date (1396-05-05 & 'YYYY-MM-dd') to Persiandate |
| format()      | (String) Display date |

+ **Item for parse date**

| String key        | Role  |
| ------------- | -----|
| yyyy      | Year (1396-2012-...) |
| MM      | Month number (12-01-02-...) |
| dd      | Day number (21-01-02-...) |
| HH      | Hour  (21-01-02-...) |
| mm      | Minute  (21-01-02-...) |
| ss      | Second  (21-01-02-...) |

+ **Pattern item for format date**

| Pattern key   | Role  |
| ------------- | -----|
| l      | Day name in week (شنبه و ....) |
| j      | Day number in month(1-10-20...) |
| F      | Month name (فروردین) |
| Y      | Year  (1396...) |
| H      | Hour in day |
| i      | Minutes in hour |
| s      | Second in minute |
| d      | day in month (01-02-21...) |
| g      | Hour in day 1-12 |
| n      | Month of year 1-12 |
| m      | Month of year 01-12 |
| t      | number day of month |
| w      | day in week 0-6 |
| y      | year with 2 digits |
| z      | Number of days (full) past the year |
| L      | Is leap year (0-1) |

# Example
```java
PersianDate pdate = new PersianDate();
PersianDateFormat pdformater1 = new PersianDateFormat('Y/m/d');
pdformater1.format(pdate);//1396/05/20

PersianDateFormat pdformater2 = new PersianDateFormat('y F j');
pdformater2.format(pdate);//۱۹ تیر ۹۶
```
