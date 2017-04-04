package saman.zamani.persiandatedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saman on 3/29/2017 AD.
 */

public class StartupActivity extends Activity
{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PersianDate date1 = new PersianDate();
		PersianDate date2 = new PersianDate();
		date2.addDate(0,0,2,5,10,0);
		long[] compare = date2.untilToday();
		Log.d("LOG", "" + compare[0] +"/"+compare[1] +"/"+compare[2] +"/"+compare[3]);
		Log.d("LOG", "" + new PersianDateFormat().format(date2));
//		try{
//			formater.parse("24");
//		}catch(IllegalArgumentException e){
//			Log.d("LOG", "onCreate: " + e.toString());
//		}
	}
}
