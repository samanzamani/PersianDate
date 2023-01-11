package saman.zamani.persiandatedemo;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindFont;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import androidx.appcompat.widget.AppCompatRadioButton;
import butterknife.OnClick;
import butterknife.Setter;
import butterknife.ViewCollections;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Saman on 4/12/2017 AD.
 */

public class DateConverter extends AppCompatActivity
{
	private PersianDateFormat formater = new PersianDateFormat("l j F Y");
	@BindFont(R.font.byekan)
    Typeface bYekan;
	@BindView(R.id.drawer_layout)
	DrawerLayout drawer;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.top_bar)
	Toolbar top_bar;
	@BindView(R.id.rd_togrg)
	AppCompatRadioButton rdTogrg;
	@BindView(R.id.rd_tojalali)
	AppCompatRadioButton rdTojalali;
	@BindView(R.id.btn_calc)
	Button btnCalc;
	@BindViews({R.id.edt_day,R.id.edt_month,R.id.edt_year})
	List<EditText> editTexts;
	@BindViews({R.id.txt_title,R.id.txt_to_jalali2,R.id.txt_to_grg2,R.id.txt_to_jalali,R.id.txt_to_grg,R.id.ageCalc,R.id.txt_to_show,R.id.txt_year,R.id.txt_month,R.id.txt_day,R.id.txt_result})
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
		setContentView(R.layout.activity_converter);
		ButterKnife.bind(this);
		Bundle bundle = getIntent().getExtras();
		if(bundle != null){
			if(bundle.getString("TYPE").equals("TO_JALALI")){
				rdTogrg.setChecked(true);
			}else{
				rdTojalali.setChecked(true);
			}
		}

		//Set fonts
		ViewCollections.set(textViews,SET_FONT,bYekan);
		btnCalc.setTypeface(bYekan);
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
		if(editTexts.get(0).getText().toString().equals("") || editTexts.get(0).getText().toString().equals("") || editTexts.get(0).getText().toString().equals("")){
			Toast.makeText(this,getString(R.string.allFieldRequred),Toast.LENGTH_LONG).show();
			return;
		}
		int day = Integer.parseInt(editTexts.get(0).getText().toString());
		int month = Integer.parseInt(editTexts.get(1).getText().toString());
		int year = Integer.parseInt(editTexts.get(2).getText().toString());
		if(day > 31){
			Toast.makeText(this,getString(R.string.dayWrong),Toast.LENGTH_LONG).show();
			editTexts.get(0).setText(""+31);
			return;
		}
		if(month > 12){
			Toast.makeText(this,getString(R.string.monthWrong),Toast.LENGTH_LONG).show();
			editTexts.get(1).setText(""+12);
			return;
		}
		PersianDate date;
		if(rdTojalali.isChecked()){
			date = new PersianDate().initJalaliDate(year,month,day);
			Date grgDate = date.toDate();
			textViews.get(10).setText(new SimpleDateFormat("EEEE dd MMMM yyyy").format(grgDate));
		}else{
			date = new PersianDate().initGrgDate(year,month,day);
			textViews.get(10).setText(formater.format(date));
		}
	}

	@OnClick(R.id.txt_to_show) void startConvert(){
		finish();
	}
	@OnClick(R.id.ageCalc) void startAgeActivity(){
		Intent intent = new Intent(DateConverter.this, AgeCalculator.class);
		DateConverter.this.startActivity(intent);
	}
	@OnClick(R.id.img_forg)
	void imgForg() {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samanzamani/PersianDate"));
		startActivity(browserIntent);
	}
}
