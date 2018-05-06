// Generated code from Butter Knife. Do not modify!
package saman.zamani.persiandatedemo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DateConverter_ViewBinding implements Unbinder {
  private DateConverter target;

  private View view2131558538;

  private View view2131558535;

  private View view2131558520;

  private View view2131558523;

  private View view2131558532;

  private View view2131558533;

  @UiThread
  public DateConverter_ViewBinding(DateConverter target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DateConverter_ViewBinding(final DateConverter target, View source) {
    this.target = target;

    View view;
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.top_bar = Utils.findRequiredViewAsType(source, R.id.top_bar, "field 'top_bar'", Toolbar.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txt_title, "field 'txtTitle'", TextView.class);
    target.txtToJalali2 = Utils.findRequiredViewAsType(source, R.id.txt_to_jalali2, "field 'txtToJalali2'", TextView.class);
    target.txtToGrg2 = Utils.findRequiredViewAsType(source, R.id.txt_to_grg2, "field 'txtToGrg2'", TextView.class);
    target.txtToJalali = Utils.findRequiredViewAsType(source, R.id.txt_to_jalali, "field 'txtToJalali'", TextView.class);
    target.txtToGrg = Utils.findRequiredViewAsType(source, R.id.txt_to_grg, "field 'txtToGrg'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ageCalc, "field 'ageCalc' and method 'startAgeActivity'");
    target.ageCalc = Utils.castView(view, R.id.ageCalc, "field 'ageCalc'", TextView.class);
    view2131558538 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startAgeActivity();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_to_show, "field 'txtToShow' and method 'startConvert'");
    target.txtToShow = Utils.castView(view, R.id.txt_to_show, "field 'txtToShow'", TextView.class);
    view2131558535 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startConvert();
      }
    });
    view = Utils.findRequiredView(source, R.id.rd_togrg, "field 'rdTogrg' and method 'GrgSelect'");
    target.rdTogrg = Utils.castView(view, R.id.rd_togrg, "field 'rdTogrg'", AppCompatRadioButton.class);
    view2131558520 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.GrgSelect();
      }
    });
    view = Utils.findRequiredView(source, R.id.rd_tojalali, "field 'rdTojalali' and method 'JalaliSelect'");
    target.rdTojalali = Utils.castView(view, R.id.rd_tojalali, "field 'rdTojalali'", AppCompatRadioButton.class);
    view2131558523 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.JalaliSelect();
      }
    });
    target.txtYear = Utils.findRequiredViewAsType(source, R.id.txt_year, "field 'txtYear'", TextView.class);
    target.txtMonth = Utils.findRequiredViewAsType(source, R.id.txt_month, "field 'txtMonth'", TextView.class);
    target.txtDay = Utils.findRequiredViewAsType(source, R.id.txt_day, "field 'txtDay'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_calc, "field 'btnCalc' and method 'calc'");
    target.btnCalc = Utils.castView(view, R.id.btn_calc, "field 'btnCalc'", Button.class);
    view2131558532 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.calc();
      }
    });
    target.edtDay = Utils.findRequiredViewAsType(source, R.id.edt_day, "field 'edtDay'", EditText.class);
    target.edtMonth = Utils.findRequiredViewAsType(source, R.id.edt_month, "field 'edtMonth'", EditText.class);
    target.edtYear = Utils.findRequiredViewAsType(source, R.id.edt_year, "field 'edtYear'", EditText.class);
    target.txtResult = Utils.findRequiredViewAsType(source, R.id.txt_result, "field 'txtResult'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_forg, "method 'imgForg'");
    view2131558533 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.imgForg();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DateConverter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.drawer = null;
    target.navView = null;
    target.top_bar = null;
    target.txtTitle = null;
    target.txtToJalali2 = null;
    target.txtToGrg2 = null;
    target.txtToJalali = null;
    target.txtToGrg = null;
    target.ageCalc = null;
    target.txtToShow = null;
    target.rdTogrg = null;
    target.rdTojalali = null;
    target.txtYear = null;
    target.txtMonth = null;
    target.txtDay = null;
    target.btnCalc = null;
    target.edtDay = null;
    target.edtMonth = null;
    target.edtYear = null;
    target.txtResult = null;

    view2131558538.setOnClickListener(null);
    view2131558538 = null;
    view2131558535.setOnClickListener(null);
    view2131558535 = null;
    view2131558520.setOnClickListener(null);
    view2131558520 = null;
    view2131558523.setOnClickListener(null);
    view2131558523 = null;
    view2131558532.setOnClickListener(null);
    view2131558532 = null;
    view2131558533.setOnClickListener(null);
    view2131558533 = null;
  }
}
