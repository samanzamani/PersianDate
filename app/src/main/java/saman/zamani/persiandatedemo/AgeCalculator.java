package saman.zamani.persiandatedemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import saman.zamani.persiandate.PersianDateFormat;

/**
 * Created by Saman on 4/12/2017 AD.
 */

public class AgeCalculator extends AppCompatActivity {

  private PersianDateFormat formater = new PersianDateFormat("l j F Y");
  /*
  @BindFont(R.font.byekan)
    Typeface bYekan;
  @BindView(R.id.drawer_layout)
  DrawerLayout drawer;
  @BindView(R.id.nav_view)
  NavigationView navView;
  @BindView(R.id.top_bar)
  Toolbar top_bar;
  @BindView(R.id.btn_calc)
  Button btnCalc;
  @BindView(R.id.rd_togrg)
  AppCompatRadioButton rdTogrg;
  @BindView(R.id.rd_tojalali)
  AppCompatRadioButton rdTojalali;
  @BindViews({R.id.edt_day,R.id.edt_month,R.id.edt_year})
  List<EditText> editTexts;
  @BindViews({R.id.txt_result,R.id.txt_day,R.id.txt_month,R.id.txt_year,R.id.txt_to_show,R.id.ageCalc,R.id.txt_to_grg,R.id.txt_to_jalali,R.id.txt_to_grg2,R.id.txt_to_jalali2,R.id.txt_title})
  List<TextView> textViews;
*/
//  final Setter<TextView, Typeface> SET_FONT = (view, tf, index) -> view.setTypeface(tf);

  @Override
  public void onBackPressed() {
//		if(drawer.isDrawerOpen(Gravity.RIGHT)){
//			drawer.closeDrawer(Gravity.RIGHT);
//		}else{
//		}
    super.onBackPressed();
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_agecalc);
//    ButterKnife.bind(this);
    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      if (bundle.getString("TYPE").equals("TO_JALALI")) {
//				rdTogrg.setChecked(true);
      } else {
//				rdTojalali.setChecked(true);
      }
    }
//		rdTojalali.setChecked(true);
    //Set fonts
//		ViewCollections.set(textViews,SET_FONT,bYekan);
//		btnCalc.setTypeface(bYekan);
    //toolbar
//		setSupportActionBar(top_bar);
//		top_bar.setTitle("");
//		setSupportActionBar(top_bar);
//		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//				this, drawer, top_bar, R.string.open, R.string.close);
//		drawer.setDrawerListener(toggle);
//
//		toggle.syncState();
  }
/*
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
			long[] age = date.untilToday();
			textViews.get(0).setText("" + age[0] + " روز " + age[1] + " ساعت " + age[2] + " دقیقه " + age[3] + " ثانیه");
		}else{
			date = new PersianDate().initGrgDate(year,month,day);
			long[] age = date.untilToday();
			textViews.get(0).setText("" + age[0] + " روز " + age[1] + " ساعت " + age[2] + " دقیقه " + age[3] + " ثانیه");
		}
	}

	@OnClick(R.id.txt_to_show) void startConvert3(){
		finish();
	}
	@OnClick(R.id.txt_to_jalali) void startConvert(){
		Intent intent = new Intent(AgeCalculator.this, DateConverter.class);
		intent.putExtra("TYPE","TO_JALALI");
		AgeCalculator.this.startActivity(intent);
	}
	@OnClick(R.id.txt_to_grg) void startConvert2(){
		Intent intent = new Intent(AgeCalculator.this, DateConverter.class);
		intent.putExtra("TYPE","TO_GRG");
		AgeCalculator.this.startActivity(intent);
	}
	@OnClick(R.id.img_forg)
	void imgForg() {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samanzamani/PersianDate"));
		startActivity(browserIntent);
	}
 */
}
