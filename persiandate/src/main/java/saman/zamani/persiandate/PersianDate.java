package saman.zamani.persiandate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Saman on 3/29/2017 AD.
 */

public class PersianDate
{
	/*----- Define Variable ---*/
	private Long timeInMilliSecond;
	public static final int FARVARDIN = 1;
	public static final int ORDIBEHEST = 2;
	public static final int KHORDAD = 3;
	public static final int TIR = 4;
	public static final int MORDAD = 5;
	public static final int SHAHRIVAR = 6;
	public static final int MEHR = 7;
	public static final int ABAN = 8;
	public static final int AZAR = 9;
	public static final int DAY = 10;
	public static final int BAHMAN = 11;
	public static final int ESFAND = 12;
	public static final int AM = 1;
	public static final int PM = 2;
	public static final String AM_SHORT_NAME = "ق.ظ";
	public static final String PM_SHORT_NAME = "ب.ظ";
	public static final String AM_NAME = "قبل از ظهر";
	public static final String PM_NAME = "بعد از ظهر";
	private int shYear;
	private int shMonth;
	private int shDay;
	private int grgYear;
	private int grgMonth;
	private int grgDay;
	private int hour;
	private int minute;
	private int second;

	/**
	 * Constractou
	 */
	public PersianDate() {
		this.timeInMilliSecond = new Date().getTime();
		this.changeTime();
	}

	/**
	 * Constractou
	 */
	public PersianDate(Long timeInMilliSecond) {
		this.timeInMilliSecond = timeInMilliSecond;
		this.changeTime();
	}
	/**
	 * Constractou
	 */
	public PersianDate(Date date) {
		this.timeInMilliSecond = date.getTime();
		this.changeTime();
	}

	/**
	 * ---- Dont change---
	 */
	private int[][] grgSumOfDays = {{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365}, {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366}};
	private int[][] hshSumOfDays = {{0, 31, 62, 93, 124, 155, 186, 216, 246, 276, 306, 336, 365}, {0, 31, 62, 93, 124, 155, 186, 216, 246, 276, 306, 336, 366}};
	private String[] dayNames = {"شنبه", "یک‌شنبه", "دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه"};
	private String[] monthNames = {"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};

	/*---- Setter And getter ----*/
	public int getShYear() {
		return shYear;
	}

	public PersianDate setShYear(int shYear) {
		this.shYear = shYear;
		this.prepareDate2(this.getShYear(),this.getShMonth(),this.getShDay());
		return this;
	}

	public int getShMonth() {
		return shMonth;
	}

	public PersianDate setShMonth(int shMonth) {
		this.shMonth = shMonth;
		this.prepareDate2(this.getShYear(),this.getShMonth(),this.getShDay());
		return this;
	}

	public int getShDay() {
		return shDay;
	}

	public PersianDate setShDay(int shDay) {
		this.shDay = shDay;
		this.prepareDate2(this.getShYear(),this.getShMonth(),this.getShDay());
		return this;
	}

	public int getGrgYear() {
		return grgYear;
	}

	public PersianDate setGrgYear(int grgYear) {
		this.grgYear = grgYear;
		prepareDate();
		return this;
	}

	public int getGrgMonth() {
		return grgMonth;
	}

	public PersianDate setGrgMonth(int grgMonth) {
		this.grgMonth = grgMonth;
		prepareDate();
		return this;
	}

	public int getGrgDay() {
		return grgDay;
	}

	public PersianDate setGrgDay(int grgDay) {
		this.grgDay = grgDay;
		prepareDate();
		return this;
	}

	public int getHour() {
		return hour;
	}

	public PersianDate setHour(int hour) {
		this.hour = hour;
		prepareDate();
		return this;
	}

	public int getMinute() {
		return minute;
	}

	public PersianDate setMinute(int minute) {
		this.minute = minute;
		prepareDate();
		return this;
	}

	public int getSecond() {
		return second;
	}

	public PersianDate setSecond(int second) {
		this.second = second;
		prepareDate();
		return this;
	}

	/**
	 * init without time
	 *
	 * @param year  Yera in Grg
	 * @param month Month in Grg
	 * @param day   Day in Grg
	 * @return
	 */
	public PersianDate initGrgDate(int year, int month, int day) {
		return this.initGrgDate(year, month, day, 0, 0, 0);
	}

	/**
	 * init with Grg data
	 *
	 * @param year   Year in Grg
	 * @param month  Month in Grg
	 * @param day    day in Grg
	 * @param hour   hour
	 * @param minute min
	 * @param second secon
	 * @return
	 */
	public PersianDate initGrgDate(int year, int month, int day, int hour, int minute, int second) {
		this.grgYear = year;
		this.grgMonth = month;
		this.grgDay = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.setGrgYear(year)
				.setGrgMonth(month)
				.setGrgDay(day)
				.setHour(hour)
				.setMinute(minute)
				.setSecond(second);
		int[] convert = this.toJalali(year, month, day);
		this.shYear = convert[0];
		this.shMonth = convert[1];
		this.shDay = convert[2];
		this.setShYear(convert[0])
				.setShMonth(convert[1])
				.setShDay(convert[2]);
		return this;
	}

	/**
	 * initilize date from jallai date
	 *
	 * @param year  Year in jallali date
	 * @param month Month in Jallali date
	 * @param day   daye in Jalalli date
	 * @return
	 */
	public PersianDate initJalaliDate(int year, int month, int day) {
		return this.initJalaliDate(year, month, day, 0, 0, 0);
	}

	/**
	 * initilize date from jallai date
	 *
	 * @param year   Year in jallali date
	 * @param month  Month in Jallali date
	 * @param day    daye in Jalalli date
	 * @param hour   Hour
	 * @param minute Minute
	 * @param second Second
	 * @return
	 */
	public PersianDate initJalaliDate(int year, int month, int day, int hour, int minute, int second) {
		this.setShYear(year)
				.setShMonth(month)
				.setShDay(day)
				.setHour(hour)
				.setMinute(minute)
				.setSecond(second);
		int[] convert = this.toGregorian(year, month, day);
		this.setGrgYear(convert[0])
				.setGrgMonth(convert[1])
				.setGrgDay(convert[2]);
		return this;
	}

	/**
	 * Helper function for initilize jalali date
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private PersianDate prepareDate2(int year, int month, int day) {
		int[] convert = this.toGregorian(year, month, day);
		this.grgYear = convert[0];
		this.grgMonth = convert[1];
		this.setGrgDay(convert[2]);
		return this;
	}

	/**
	 * Helper function for inilize
	 */
	private void prepareDate(){
		String dtStart = "" + this.textNumberFilter("" + this.getGrgYear()) + "-" + this.textNumberFilter("" + this.getGrgMonth()) + "-" + this.textNumberFilter("" + this.getGrgDay())
				+ "T" + this.textNumberFilter("" + this.getHour()) + ":" + this.textNumberFilter("" + this.getMinute()) + ":" + this.textNumberFilter("" + this.getSecond()) + "Z";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		int[] convert = this.toJalali(this.getGrgYear(),this.getGrgMonth(),this.getGrgDay());
		this.shYear = convert[0];
		this.shMonth = convert[1];
		this.shDay = convert[2];
		Date date = null;
		try{
			date = format.parse(dtStart);
			this.timeInMilliSecond = date.getTime();
		}catch(ParseException e){
			e.printStackTrace();
		}
	}

	/**
	 * return time in long value
	 *
	 * @return Value of time in mile
	 */
	public Long getTime() {
		return this.timeInMilliSecond;
	}

	/**
	 * Check Grg year is leap
	 *
	 * @param Year
	 * @return
	 */
	public boolean grgIsLeap(int Year) {
		return ((Year % 4) == 0 && ((Year % 100) != 0 || (Year % 400) == 0));
	}

	/**
	 * Check year in Leap
	 *
	 * @return true or false
	 */
	public boolean isLeap() {
		return this.isLeap(this.shYear);
	}

	/**
	 * Check custom year is leap
	 *
	 * @param year int year
	 * @return true or false
	 */
	public boolean isLeap(int year) {
		double referenceYear = 1375;
		double startYear = 1375;
		double yearRes = year - referenceYear;
		if(yearRes > 0){
			if(yearRes >= 33){
				double numb = yearRes / 33;
				startYear = referenceYear + Math.floor(numb)*33;
			}
		}else{
			if(yearRes >= -33){
				startYear = referenceYear-33;
			}else{
				double numb = Math.abs(yearRes / 33);
				startYear = referenceYear - (Math.floor(numb)+1)*33;
			}
		}
		double[] leapYears = {startYear,startYear+4,startYear+8,startYear+16,startYear+20,startYear+24,startYear+28,startYear+33};
		return (Arrays.binarySearch(leapYears,year)) >= 0;
//		double Year = year;
//		Year = (Year - 474) % 128;
//		Year = ((Year >= 30) ? 0 : 29) + Year;
//		Year = Year - Math.floor(Year / 33) - 1;
//		return ((Year % 4) == 0);
	}

	/**
	 * Check static is leap year for Jalali Date
	 *
	 * @param year Jalali year
	 * @return true if year is leap
	 */
	public static boolean isJalaliLeap(int year){
		return (new PersianDate().isLeap(year));
	}

	/**
	 * Check static is leap year for Grg Date
	 *
	 * @param year
	 * @return
	 */
	public static boolean isGrgLeap(int year){
		return (new PersianDate().grgIsLeap(year));
	}

	/**
	 * Convert Grg date to jalali date
	 *
	 * @param year  year in Grg date
	 * @param month month in Grg date
	 * @param day   day in Grg date
	 * @return a int[year][month][day] in jalali date
	 */
	public int[] toJalali(int year, int month, int day) {
		int hshDay = 0;
		int hshMonth = 0;
		int hshElapsed;
		int hshYear = year - 621;
		boolean grgLeap = this.grgIsLeap(year);
		boolean hshLeap = this.isLeap(hshYear - 1);
		int grgElapsed = grgSumOfDays[(grgLeap ? 1 : 0)][month - 1] + day;
		int XmasToNorooz = (hshLeap && grgLeap) ? 80 : 79;
		if(grgElapsed <= XmasToNorooz){
			hshElapsed = grgElapsed + 286;
			hshYear--;
			if(hshLeap && !grgLeap)
				hshElapsed++;
		}else{
			hshElapsed = grgElapsed - XmasToNorooz;
			hshLeap = this.isLeap(hshYear);
		}
		if(year >= 2029 && (year-2029)%4 == 0){
			hshElapsed++;
		}
		for(int i = 1; i <= 12; i++){
			if(hshSumOfDays[(hshLeap ? 1 : 0)][i] >= hshElapsed){
				hshMonth = i;
				hshDay = hshElapsed - hshSumOfDays[(hshLeap ? 1 : 0)][i - 1];
				break;
			}
		}
		int[] ret = {hshYear, hshMonth, hshDay};
		return ret;
	}
	/**
	 * Convert Jalali date to Grg
	 *
	 * @param year  Year in jalali
	 * @param month Month in Jalali
	 * @param day   Day in Jalali
	 * @return int[year][month][day]
	 */
	public int[] toGregorian(int year, int month, int day) {
		int grgYear = year + 621;
		int grgDay = 0;
		int grgMonth = 0;
		int grgElapsed;

		boolean hshLeap = this.isLeap(year);
		boolean grgLeap = this.grgIsLeap(grgYear);

		int hshElapsed = hshSumOfDays[hshLeap ? 1 : 0][month - 1] + day;

		if(month > 10 || (month == 10 && hshElapsed > 286 + (grgLeap ? 1 : 0))){
			grgElapsed = hshElapsed - (286 + (grgLeap ? 1 : 0));
			grgLeap = grgIsLeap(++grgYear);
		}else{
			hshLeap = this.isLeap(year - 1);
			grgElapsed = hshElapsed + 79 + (hshLeap ? 1 : 0) - (grgIsLeap(grgYear - 1) ? 1 : 0);
		}
		if(grgYear >= 2030 && (grgYear-2030)%4 == 0)
			grgElapsed--;
		for(int i = 1; i <= 12; i++){
			if(grgSumOfDays[grgLeap ? 1 : 0][i] >= grgElapsed){
				grgMonth = i;
				grgDay = grgElapsed - grgSumOfDays[grgLeap ? 1 : 0][i - 1];
				break;
			}
		}
		int[] ret = {grgYear, grgMonth, grgDay};
		return ret;
	}

	/**
	 * calc day of week
	 *
	 * @return
	 */
	public int dayOfWeek() {
		return this.dayOfWeek(this);
	}

	/**
	 * Get day of week from PersianDate object
	 *
	 * @param date
	 * @return
	 */
	public int dayOfWeek(PersianDate date) {
		return this.dayOfWeek(date.toDate());
	}

	/**
	 * Get day of week from Date object
	 *
	 * @param date
	 * @return
	 */
	public int dayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) return 0;
		return (cal.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * return month name
	 *
	 * @return
	 */
	public String monthName() {
		return this.monthName(this.getShMonth());
	}

	/**
	 * Return month name
	 *
	 * @param month Month
	 * @return
	 */
	public String monthName(int month) {
		return this.monthNames[month - 1];
	}

	/**
	 * get day name
	 *
	 * @return
	 */
	public String dayName() {
		return this.dayName(this);
	}

	/**
	 * Get Day Name
	 *
	 * @param date
	 * @return
	 */
	public String dayName(PersianDate date) {
		return this.dayNames[this.dayOfWeek(date)];
	}

	/**
	 * Number days of month
	 *
	 * @return return days
	 */
	public int getMonthDays() {
		return this.getMonthDays(this.getShYear(), this.getShMonth());
	}

	/**
	 * calc count of day in month
	 *
	 * @param Year
	 * @param month
	 * @return
	 */
	public int getMonthDays(int Year, int month) {
		if(month == 12 && !this.isLeap(Year)){
			return 29;
		}
		if(month <= 6){
			return 31;
		}else{
			return 30;
		}
	}

	/**
	 * calcute day in year
	 *
	 * @return
	 */
	public int getDayInYear() {
		return this.getDayInYear(this.getShMonth(), getShDay());
	}

	/**
	 * Calc day of the year
	 *
	 * @param month Month
	 * @param day   Day
	 * @return
	 */
	public int getDayInYear(int month, int day) {
		for(int i = 1; i < month; i++){
			if(i <= 6){
				day += 31;
			}else{
				day += 30;
			}
		}
		return day;
	}

	/**
	 * add to date
	 *
	 * @param year Number of Year you want add
	 * @param month Number of month you want add
	 * @param day Number of day you want add
	 * @param hour Number of hour you want add
	 * @param minute Number of minute you want add
	 * @param second Number of second you want add
	 * @return
	 */
	public PersianDate addDate(int year ,int month,int day,int hour,int minute,int second){
		this.timeInMilliSecond += (((year*365)+(month*30)+day)*24*3_600*1_000);
		this.timeInMilliSecond += ((second + (hour*3600) + (minute*60)) * 1_000);
		this.changeTime();
		return this;
	}

	/**
	 * add to date
	 *
	 * @param year Number of Year you want add
	 * @param month Number of month you want add
	 * @param day Number of day you want add
	 * @return
	 */
	public PersianDate addDate(int year ,int month,int day){
		return this.addDate(year,month,day,0,0,0);
	}

	public PersianDate addYear(int year){
		return this.addDate(year,0,0,0,0,0);
	}
	public PersianDate addMonth(int month){
		return this.addDate(0,month,0,0,0,0);
	}
	public PersianDate addWeek(int week){
		return this.addDate(0,0,(week*7),0,0,0);
	}
	public PersianDate addDay(int day){
		return this.addDate(0,0,day,0,0,0);
	}

	/**
	 * Compare 2 date
	 *
	 * @param dateInput PersianDate type
	 *
	 * @return
	 */
	public Boolean after(PersianDate dateInput){
		return (this.timeInMilliSecond < dateInput.getTime());
	}
	/**
	 * copare to data
	 *
	 * @param dateInput Input
	 * @return
	 */
	public Boolean before(PersianDate dateInput){
		return (!this.after(dateInput));
	}
	/**
	 * Check date equals
	 *
	 * @param dateInput
	 * @return
	 */
	public Boolean equals(PersianDate dateInput){
		return (this.timeInMilliSecond == dateInput.getTime());
	}
	/**
	 * compare 2 data
	 *
	 * @param anotherDate
	 * @return  0 = equal,1=data1 > anotherDate,-1=data1 > anotherDate
	 */
	public int compareTo(PersianDate anotherDate) {
		return (this.timeInMilliSecond <anotherDate.getTime() ? -1 : (this.timeInMilliSecond ==anotherDate.getTime() ? 0 : 1));
	}
	/**
	 * Return Day in difreent date
	 *
	 * @return
	 */
	public long getDayuntilToday(){
		return this.getDayUntilToday(new PersianDate());
	}
	/**
	 * Return difreent just day in copare 2 date
	 *
	 * @param date date for compare
	 * @return
	 */
	public long getDayUntilToday(PersianDate date){
		long[] ret =  this.untilToday(date);
		return ret[0];
	}
	/**
	 * Calc difreent date until now
	 *
	 * @return
	 */
	public long[] untilToday(){
		return this.untilToday(new PersianDate());
	}
	/**
	 * calcute diffrent between 2 date
	 *
	 * @param date Date 1
	 * @return
	 */
	public long[] untilToday(PersianDate date){
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long different = Math.abs(this.timeInMilliSecond -date.getTime());

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		return new long[]{elapsedDays,elapsedHours,elapsedMinutes,elapsedSeconds};
	}

	@Override
	public String toString() {
		return PersianDateFormat.format(this,null);
	}
	/*----- Helper Function-----*/

	/**
	 * convert PersianDate class to date
	 *
	 * @return
	 */
	public Date toDate() {
		return new Date(this.timeInMilliSecond);
	}

	/**
	 * Helper function
	 *
	 * @param date
	 * @return
	 */
	private String textNumberFilter(String date) {
		if(date.length() < 2){
			return "0" + date;
		}
		return date;
	}

	/**
	 * initi with time in milesecond
	 */
	private void changeTime(){
		this.initGrgDate(Integer.parseInt(new SimpleDateFormat("yyyy").format(this.timeInMilliSecond)), Integer.parseInt(new SimpleDateFormat("MM").format(this.timeInMilliSecond)),
				Integer.parseInt(new SimpleDateFormat("dd").format(this.timeInMilliSecond)), Integer.parseInt(new SimpleDateFormat("HH").format(this.timeInMilliSecond)),
				Integer.parseInt(new SimpleDateFormat("mm").format(this.timeInMilliSecond)), Integer.parseInt(new SimpleDateFormat("ss").format(this.timeInMilliSecond)));
	}

	/**
	 * Return today
	 *
	 * @return
	 */
	public static PersianDate today(){
		PersianDate pdate = new PersianDate();
		pdate.setHour(0).setMinute(0).setSecond(0);
		return pdate;
	}
	/**
	 * Get tomorrow
	 *
	 * @return
	 */
	public static PersianDate tomorrow(){
		PersianDate pdate = new PersianDate();
		pdate.addDay(1);
		pdate.setHour(0).setMinute(0).setSecond(0);
		return pdate;
	}

	/**
	 * Get start of day
	 *
	 * @param persianDate
	 * @return
	 */
	public PersianDate startOfDay(PersianDate persianDate){
		persianDate.setHour(0).setMinute(0).setSecond(0);
		return persianDate;
	}

	/**
	 * Get Start of day
	 *
	 * @return
	 */
	public PersianDate startOfDay(){
		return this.startOfDay(this);
	}

	/**
	 * Get end of day
	 *
	 * @param persianDate
	 * @return
	 */
	public PersianDate endOfDay(PersianDate persianDate){
		persianDate.setHour(23).setMinute(59).setSecond(59);
		return persianDate;
	}

	/**
	 * Get end of day
	 *
	 * @return
	 */
	public PersianDate endOfDay(){
		return this.endOfDay(this);
	}

	/**
	 * Check midnight
	 *
	 * @param persianDate
	 * @return
	 */
	public Boolean isMidNight(PersianDate persianDate){
		return persianDate.isMidNight();
	}

	/**
	 * Check is midNight
	 *
	 * @return
	 */
	public Boolean isMidNight(){
		return (this.hour < 12);
	}

	/**
	 * Get short name time of the day
	 *
	 * @return
	 */
	public String getShortTimeOfTheDay(){
		return (this.isMidNight()) ? AM_SHORT_NAME : PM_SHORT_NAME;
	}
	/**
	 * Get short name time of the day
	 *
	 * @return
	 */
	public String getShortTimeOfTheDay(PersianDate persianDate){
		return (persianDate.isMidNight()) ? AM_SHORT_NAME : PM_SHORT_NAME;
	}
	/**
	 * Get time of the day
	 *
	 * @return
	 */
	public String getTimeOfTheDay(){
		return (this.isMidNight()) ? AM_NAME : PM_NAME;
	}
	/**
	 * Get time of the day
	 *
	 * @return
	 */
	public String getTimeOfTheDay(PersianDate persianDate){
		return (persianDate.isMidNight()) ? AM_NAME : PM_NAME;
	}
}