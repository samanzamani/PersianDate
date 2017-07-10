# Persian Date(Jalali)
======
This is simple android calender converter for Convert Jalali date to Gregorian date.
# Gradle
```groovy
dependencies {
    compile 'com.github.samanzamani.persiandate:PersianDate:0.0.2'
}
```
##Let's convert some data :)

###Step 1

```java
PersianDate pdate = new PersianDate();
```

###step2

```java
PersianDateFormat pdformater = new PersianDateFormat();
pdformater.format(pdate);
```
***PersianDate***
---
+ **PersianDate class methods**

| method        | describtion  |
| ------------- | -----:|
| PersianDate(timestamp)      | make time with timestamp |
| PersianDate(DATE)      |   Constractor for make PersianDate object from Date object  |
| setShYear |    Set Jalali year |
| setShYear |    Set Jalali year |
| setShMonth |    Set Jalali month |
| setShDay |    Set Jalali day |
                     