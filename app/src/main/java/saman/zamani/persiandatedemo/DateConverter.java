package saman.zamani.persiandatedemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.AppCompatRadioButton;
import butterknife.OnClick;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saman on 4/12/2017 AD.
 */

public class DateConverter extends AppCompatActivity
{
	private Typeface bYekan;
	private PersianDateFormat formater = new PersianDateFormat("l j F Y");
	@BindView(R.id.drawer_layout)
	DrawerLayout drawer;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.top_bar)
	Toolbar top_bar;
	@BindView(R.id.txt_title)
	TextView txtTitle;
	@BindView(R.id.txt_to_jalali2)
	TextView txtToJalali2;
	@BindView(R.id.txt_to_grg2)
	TextView txtToGrg2;
	@BindView(R.id.txt_to_jalali)
	TextView txtToJalali;
	@BindView(R.id.txt_to_grg)
	TextView txtToGrg;
	@BindView(R.id.ageCalc)
	TextView ageCalc;
	@BindView(R.id.about)
	TextView about;
	@BindView(R.id.txt_to_show)
	TextView txtToShow;
	@BindView(R.id.rd_togrg)
	AppCompatRadioButton rdTogrg;
	@BindView(R.id.rd_tojalali)
	AppCompatRadioButton rdTojalali;
	@BindView(R.id.txt_year)
	TextView txtYear;
	@BindView(R.id.txt_month)
	TextView txtMonth;
	@BindView(R.id.txt_day)
	TextView txtDay;
	@BindView(R.id.btn_calc)
	Button btnCalc;
	@BindView(R.id.edt_day)
	EditText edtDay;
	@BindView(R.id.edt_month)
	EditText edtMonth;
	@BindView(R.id.edt_year)
	EditText edtYear;
	@BindView(R.id.txt_result)
	TextView txtResult;

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
		setContentView(R.layout.activity_converter);
		ButterKnife.bind(this);
		bYekan = Typeface.createFromAsset(this.getAssets(), "byekan.ttf");
		Bundle bundle = getIntent().getExtras();
		if(bundle != null){
			if(bundle.getString("TYPE").equals("TO_JALALI")){
				rdTogrg.setChecked(true);
			}else{
				rdTojalali.setChecked(true);
			}
		}

		//Set fonts
		txtToJalali2.setTypeface(bYekan);
		txtToGrg2.setTypeface(bYekan);
		txtToJalali.setTypeface(bYekan);
		txtToGrg.setTypeface(bYekan);
		ageCalc.setTypeface(bYekan);
		about.setTypeface(bYekan);
		txtToShow.setTypeface(bYekan);
		txtTitle.setTypeface(bYekan);
		txtYear.setTypeface(bYekan);
		txtMonth.setTypeface(bYekan);
		txtDay.setTypeface(bYekan);
		btnCalc.setTypeface(bYekan);
		txtResult.setTypeface(bYekan);
		//toolbar
		setSupportActionBar(top_bar);
		top_bar.setTitle("");
		setSupportActionBar(top_bar);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, top_bar, R.string.open, R.string.close);
		drawer.setDrawerListener(toggle);

		toggle.syncState();
	}

	@OnClick(R.id.rd_tojalali) void JalaliSelect(){
		if(rdTogrg.isChecked()){
			rdTogrg.setChecked(false);
		}
	}
	@OnClick(R.id.rd_togrg) void GrgSelect(){
		if(rdTojalali.isChecked()){
			rdTojalali.setChecked(false);
		}
	}
	@OnClick(R.id.btn_calc) void calc(){
		if(edtDay.getText().toString().equals("") || edtDay.getText().toString().equals("") || edtDay.getText().toString().equals("")){
			Toast.makeText(this,getString(R.string.allFieldRequred),Toast.LENGTH_LONG).show();
			return;
		}
		int day = Integer.parseInt(edtDay.getText().toString());
		int month = Integer.parseInt(edtMonth.getText().toString());
		int year = Integer.parseInt(edtYear.getText().toString());
		if(day > 31){
			Toast.makeText(this,getString(R.string.dayWrong),Toast.LENGTH_LONG).show();
			edtDay.setText(""+31);
			return;
		}
		if(month > 12){
			Toast.makeText(this,getString(R.string.monthWrong),Toast.LENGTH_LONG).show();
			edtMonth.setText(""+12);
			return;
		}
		PersianDate date;
		if(rdTojalali.isChecked()){
			date = new PersianDate().initJalaliDate(year,month,day);
			Date grgDate = date.toDate();
			txtResult.setText(new SimpleDateFormat("EEEE dd MMMM yyyy").format(grgDate));
		}else{
			date = new PersianDate().initGrgDate(year,month,day);
			txtResult.setText(formater.format(date));
		}
	}
}
