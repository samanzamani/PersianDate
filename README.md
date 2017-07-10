# Persian Date(Jalali)
======
This is simple android calender converter for Convert Jalali date to Gregorian date.
# Gradle
```groovy
dependencies {
    compile 'com.github.samanzamani.persiandate:PersianDate:0.0.2'
}
```
## Let's convert some data :)

### Step 1

```java
PersianDate pdate = new PersianDate();
```

### step2

```java
PersianDateFormat pdformater = new PersianDateFormat();
pdformater.format(pdate);
```
***PersianDate***
---
+ **PersianDate class methods**

| method        | describtion  |
| ------------- | -----|
| PersianDate(Long timestamp)      | make time with timestamp |
| PersianDate(DATE date)      |   Constractor for make PersianDate object from Date object  |
| setShYear(int year) |    Set Jalali year |
| setShMonth(int month) |    Set Jalali month |
| setShDay(int day) |    Set Jalali day |
| setGrgYear(int day) |    Set Gregorian year |
| setGrgMonth(int day) |    Set Gregorian month |
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
                     