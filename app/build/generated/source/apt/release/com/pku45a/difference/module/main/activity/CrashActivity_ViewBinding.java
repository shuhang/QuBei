// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.main.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CrashActivity_ViewBinding implements Unbinder {
  private CrashActivity target;

  private View view2131231604;

  private View view2131231599;

  private View view2131231565;

  @UiThread
  public CrashActivity_ViewBinding(CrashActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CrashActivity_ViewBinding(final CrashActivity target, View source) {
    this.target = target;

    View view;
    target.tv_log = Utils.findRequiredViewAsType(source, R.id.tv_log, "field 'tv_log'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_show_log, "field 'tv_show_log' and method 'onClick'");
    target.tv_show_log = Utils.castView(view, R.id.tv_show_log, "field 'tv_show_log'", TextView.class);
    view2131231604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.iv_bug = Utils.findRequiredViewAsType(source, R.id.iv_bug, "field 'iv_bug'", ImageView.class);
    target.sv = Utils.findRequiredViewAsType(source, R.id.sv, "field 'sv'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.tv_restart, "method 'onClick'");
    view2131231599 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_exit, "method 'onClick'");
    view2131231565 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CrashActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_log = null;
    target.tv_show_log = null;
    target.iv_bug = null;
    target.sv = null;

    view2131231604.setOnClickListener(null);
    view2131231604 = null;
    view2131231599.setOnClickListener(null);
    view2131231599 = null;
    view2131231565.setOnClickListener(null);
    view2131231565 = null;
  }
}
