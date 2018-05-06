// Generated code from Butter Knife. Do not modify!
package saman.zamani.persiandatedemo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StartupActivity_ViewBinding implements Unbinder {
  private StartupActivity target;

  private View view2131558536;

  private View view2131558537;

  private View view2131558538;

  private View view2131558533;

  @UiThread
  public StartupActivity_ViewBinding(StartupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StartupActivity_ViewBinding(final StartupActivity target, View source) {
    this.target = target;

    View view;
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.top_bar = Utils.findRequiredViewAsType(source, R.id.top_bar, "field 'top_bar'", Toolbar.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txt_title, "field 'txtTitle'", TextView.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txtDate'", TextView.class);
    target.spnFormat = Utils.findRequiredViewAsType(source, R.id.spn_format, "field 'spnFormat'", AppCompatSpinner.class);
    view = Utils.findRequiredView(source, R.id.txt_to_jalali, "field 'txtToJalali' and method 'startConvert'");
    target.txtToJalali = Utils.castView(view, R.id.txt_to_jalali, "field 'txtToJalali'", TextView.class);
    view2131558536 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startConvert();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_to_grg, "field 'txtToGrg' and method 'startConvert2'");
    target.txtToGrg = Utils.castView(view, R.id.txt_to_grg, "field 'txtToGrg'", TextView.class);
    view2131558537 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startConvert2();
      }
    });
    view = Utils.findRequiredView(source, R.id.ageCalc, "field 'ageCalc' and method 'startAgeActivity'");
    target.ageCalc = Utils.castView(view, R.id.ageCalc, "field 'ageCalc'", TextView.class);
    view2131558538 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startAgeActivity();
      }
    });
    target.txtToShow = Utils.findRequiredViewAsType(source, R.id.txt_to_show, "field 'txtToShow'", TextView.class);
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
    StartupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.drawer = null;
    target.navView = null;
    target.top_bar = null;
    target.txtTitle = null;
    target.txtDate = null;
    target.spnFormat = null;
    target.txtToJalali = null;
    target.txtToGrg = null;
    target.ageCalc = null;
    target.txtToShow = null;

    view2131558536.setOnClickListener(null);
    view2131558536 = null;
    view2131558537.setOnClickListener(null);
    view2131558537 = null;
    view2131558538.setOnClickListener(null);
    view2131558538 = null;
    view2131558533.setOnClickListener(null);
    view2131558533 = null;
  }
}
