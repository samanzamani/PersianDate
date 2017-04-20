package saman.zamani.persiandate;


import java.text.ParseException;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Saman on 3/31/2017 AD.
 */

public class PersianDateFormat
{
	//variable
	/**
	 * Key for convert Date to String
	 *
	 *
	 */
	private String key[] = {"l", "j", "F", "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", "L"};
	private String pattern;
	/**
	 * key_parse for convert String to PersianDate
	 *
	 * yyyy = Year (1396)
	 * MM = month (02-12-...)
	 * dd = day (13-02-15-...)
	 * HH = Hour (13-02-15-...)
	 * mm = minutes (13-02-15-...)
	 * ss = second (13-02-15-...)
	 */
	private String key_parse[] = {"yyyy", "MM", "dd", "HH", "mm", "ss"};

	/**
	 * Constracutor
	 *
	 * @param pattern
	 */
	public PersianDateFormat(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * initilize pattern
	 */
	public PersianDateFormat() {
		pattern = "l j F Y H:i:s";
	}

	public String format(PersianDate date) {
		String year2 = null;
		if((""+date.getShYear()).length() == 2){
			year2 = ""+date.getShYear();
		}else if((""+date.getShYear()).length() == 3){
			year2 = ("" + date.getShYear()).substring(2, 3);
		}else{
			year2 = ("" + date.getShYear()).substring(2, 4);
		}
		String values[] = {date.dayName(), "" + date.getShDay(), date.monthName(), "" + date.getShYear(),
				this.textNumberFilter("" + date.getHour()), this.textNumberFilter("" + date.getMinute()), this.textNumberFilter("" + date.getSecond()),
				this.textNumberFilter("" + date.getShDay()), "" + date.getHour(), "" + date.getShMonth(), this.textNumberFilter("" + date.getShMonth()),
				"" + date.getMonthDays(), "" + date.dayOfWeek(), year2, "" + date.getDayInYear(),
				(date.isLeap() ? "1" : "0")};
		return this.stringUtils(this.pattern, this.key, values);
	}

	/**
	 * Parse jalli date from String
	 *
	 * @param date date in string
	 * @return
	 * @throws ParseException
	 */
	public PersianDate parse(String date) throws ParseException{
		return this.parse(date,this.pattern);
	}
	/**
	 * Parse jalli date from String
	 *
	 * @param date date in string
	 * @param pattern pattern
	 * @return
	 * @throws ParseException
	 */
	public PersianDate parse(String date ,String pattern) throws ParseException {
		ArrayList<Integer> JalaliDate = new ArrayList<Integer>(){{
			add(0);
			add(0);
			add(0);
			add(0);
			add(0);
			add(0);
		}};
		for(int i = 0; i < key_parse.length; i++){
			if((pattern.indexOf(key_parse[i]) >= 0)){
				int start_temp = pattern.indexOf(key_parse[i]);
				int end_temp = start_temp + key_parse[i].length();
				String date_replcae = date.substring(start_temp,end_temp);
				if(date_replcae.matches("[-+]?\\d*\\.?\\d+")){
					JalaliDate.set(i,Integer.parseInt(date_replcae));
				}else{
					throw new ParseException("Parse Exeption",10);
				}

			}
		}
		return new PersianDate().initJalaliDate(JalaliDate.get(0),JalaliDate.get(1),JalaliDate.get(2),JalaliDate.get(3),JalaliDate.get(4),JalaliDate.get(5));
	}

	/**
	 * Convert String Grg date to persiand date object
	 *
	 * @param date date in String
	 * @return PersianDate object
	 * @throws ParseException
	 */
	public PersianDate parseGrg(String date) throws ParseException{
		return this.parseGrg(date,this.pattern);
	}

	/**
	 * Convert String Grg date to persiand date object
	 *
	 * @param date date String
	 * @param pattern pattern
	 * @return PersianDate object
	 * @throws ParseException
	 */
	public PersianDate parseGrg(String date, String pattern) throws ParseException {
		Date dateInGrg = new SimpleDateFormat(pattern).parse(date);
		return new PersianDate(dateInGrg.getTime());
	}

	/**
	 * Replace String
	 *
	 * @param text   String
	 * @param key    Loking for
	 * @param values Replace with
	 * @return
	 */
	private String stringUtils(String text, String[] key, String[] values) {
		for(int i = 0; i < key.length; i++){
			text = text.replace(key[i], values[i]);
		}
		return text;
	}

	/**
	 * add zero to start
	 *
	 * @param date data
	 * @return return string with 0 in start
	 */
	private String textNumberFilter(String date) {
		if(date.length() < 2){
			return "0" + date;
		}
		return date;
	}

}