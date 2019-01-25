package saman.zamani.persiandatedemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindFont;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.Timer;
import java.util.TimerTask;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

/**
 * Created by Saman on 3/29/2017 AD.
 */

public class StartupActivity extends AppCompatActivity
{
	private String[] displayFormat = {"فرمت نمایش را انتخاب کنید","Y/m/d","l j F Y \n H:i:s","j F y","z روز از سال","s","H:i","l w:i:s"};
	Handler h = new Handler();
	private String pattern = "l j F Y \n H:i:s";
	@BindFont(R.font.byekan)
	Typeface bYekan;
	@BindView(R.id.drawer_layout)
	DrawerLayout drawer;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.top_bar)
	Toolbar top_bar;
	@BindView(R.id.txt_title)
	TextView txtTitle;
	@BindView(R.id.txt_date)
	TextView txtDate;
	@BindView(R.id.spn_format)
	AppCompatSpinner spnFormat;
	@BindView(R.id.txt_to_jalali)
	TextView txtToJalali;
	@BindView(R.id.txt_to_grg)
	TextView txtToGrg;
	@BindView(R.id.ageCalc)
	TextView ageCalc;
	@BindView(R.id.txt_to_show)
	TextView txtToShow;

	@Override
	public void onBackPressed() {
		if(drawer.isDrawerOpen(Gravity.RIGHT)){
			drawer.closeDrawer(Gravity.RIGHT);
		}else{
			super.onBackPressed();
		}
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startup);
		PersianDate pdate = new PersianDate();
		pdate.setShYear(1408).setShMonth(12);
//		Log.i("LOG","---------------$$$------------------");
//		Log.i("LOG","String:" + Arrays.toString(pdate.toJalali(2028, 1, 1)));
//		Log.i("LOG","inv String:" + Arrays.toString(pdate.toGregorian(1407, 10, 12)));
//		Log.i("LOG","Year is:" + pdate.getShYear());
		Log.i("LOG","---------------$$$------------------");
		Log.i("LOG","Year is:" + pdate.startOfDay().getGrgYear() + " month is: " + pdate.startOfDay().getGrgMonth() + " day is :" + pdate.startOfDay().getGrgDay());
		Log.i("LOG",""+pdate.isLeap());
//		Log.i("LOG","---------------$$$------------------");
//		Log.i("LOG","String:" + Arrays.toString(pdate.toJalali(2029, 1, 1)));
//		Log.i("LOG","inv String:" + Arrays.toString(pdate.toGregorian(1407, 10, 12)));
//		Log.i("LOG","Year is:" + pdate.getShYear());
//		Log.i("LOG","Year is:" + pdate.startOfDay().getGrgYear() + " month is: " + pdate.startOfDay().getGrgMonth() + " day is :" + pdate.startOfDay().getGrgDay());
		Log.i("LOG","---------------$$$------------------");
		ButterKnife.bind(this);
		//toolbar
		setSupportActionBar(top_bar);
		top_bar.setTitle("");
		setSupportActionBar(top_bar);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, top_bar, R.string.open, R.string.close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();
		txtTitle.setTypeface(bYekan);
		txtDate.setTypeface(bYekan);
		ageCalc.setTypeface(bYekan);
		txtToGrg.setTypeface(bYekan);
		txtToJalali.setTypeface(bYekan);
		txtToShow.setTypeface(bYekan);
		new Timer().scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run() {
				changeTime();
			}
		}, 0, 1000);//put here time 1000 milliseconds=1 second
		//DO: Spinner
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, displayFormat)
		{

			public View getView(int position, View convertView, ViewGroup parent) {
				View v = super.getView(position, convertView, parent);

				((TextView) v).setTypeface(bYekan);
				if(position == 0){
					((TextView) v).setTextColor(Color.parseColor("#c2c2c2"));
				}else{
					((TextView) v).setTextColor(Color.BLACK);
				}
				((TextView) v).setTextSize(14);

				return v;
			}


			public View getDropDownView(int position, View convertView, ViewGroup parent) {
				View v = super.getDropDownView(position, convertView, parent);

				((TextView) v).setTypeface(bYekan);

				return v;
			}
		};
		spnFormat.setAdapter(adapter);
		spnFormat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if(position != 0){
					pattern = displayFormat[position];
					changeTime();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	@MainThread
	private void changeTime() {
		h.post(new Runnable()
		{
			@Override
			public void run() {
				txtDate.setText(number2persian(new PersianDateFormat(pattern).format(new PersianDate())));
			}
		});
	}

	private String number2persian(String text) {
		text = text.replaceAll("0", "۰");
		text = text.replaceAll("1", "۱");
		text = text.replaceAll("2", "۲");
		text = text.replaceAll("3", "۳");
		text = text.replaceAll("4", "۴");
		text = text.replaceAll("5", "۵");
		text = text.replaceAll("6", "۶");
		text = text.replaceAll("7", "۷");
		text = text.replaceAll("8", "۸");
		text = text.replaceAll("9", "۹");
		return text;
	}

	@OnClick(R.id.txt_to_jalali) void startConvert(){
		Intent intent = new Intent(StartupActivity.this, DateConverter.class);
		intent.putExtra("TYPE","TO_JALALI");
		StartupActivity.this.startActivity(intent);
	}
	@OnClick(R.id.txt_to_grg) void startConvert2(){
		Intent intent = new Intent(StartupActivity.this, DateConverter.class);
		intent.putExtra("TYPE","TO_GRG");
		StartupActivity.this.startActivity(intent);
	}
	@OnClick(R.id.ageCalc) void startAgeActivity(){
		Intent intent = new Intent(StartupActivity.this, AgeCalculator.class);
		StartupActivity.this.startActivity(intent);
	}

	@OnClick(R.id.img_forg)
	void imgForg() {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samanzamani/PersianDate"));
		startActivity(browserIntent);
	}
}
