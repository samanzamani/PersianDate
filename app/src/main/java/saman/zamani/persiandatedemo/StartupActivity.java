package saman.zamani.persiandatedemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindFont;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Setter;
import butterknife.ViewCollections;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;
import saman.zamani.persiandate.PersianDateFormat.PersianDateNumberCharacter;

/**
 * Created by Saman on 3/29/2017 AD.
 */

public class StartupActivity extends AppCompatActivity
{
	private final String[] displayFormat = {"فرمت نمایش را انتخاب کنید","Y/m/d","l j F Y \n H:i:s","j F y","z روز از سال","s","H:i","l w:i:s"};
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
	@BindView(R.id.spn_format)
	AppCompatSpinner spnFormat;
	@BindViews({R.id.txt_title,R.id.txt_date,R.id.txt_to_jalali,R.id.txt_to_grg,R.id.ageCalc,R.id.txt_to_show})
	List<TextView> textViews;

	final Setter<TextView, Typeface> SET_FONT = (view, tf, index) -> view.setTypeface(tf);

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
		ButterKnife.bind(this);


		//toolbar
		setSupportActionBar(top_bar);
		top_bar.setTitle("");
		setSupportActionBar(top_bar);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, top_bar, R.string.open, R.string.close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		ViewCollections.set(textViews,SET_FONT,bYekan);
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
				textViews.get(1).setText(number2persian(new PersianDateFormat(pattern).format(new PersianDate())));
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
	void imgFork() {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samanzamani/PersianDate"));
		startActivity(browserIntent);
	}
}
