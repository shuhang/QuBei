// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.mine.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view2131231074;

  private View view2131231287;

  private View view2131231083;

  private View view2131231089;

  private View view2131231060;

  private View view2131231052;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    target.sc_dark_theme = Utils.findRequiredViewAsType(source, R.id.sc_dark_theme, "field 'sc_dark_theme'", SwitchCompat.class);
    target.sc_show_read_later = Utils.findRequiredViewAsType(source, R.id.sc_show_read_later, "field 'sc_show_read_later'", SwitchCompat.class);
    target.sc_show_top = Utils.findRequiredViewAsType(source, R.id.sc_show_top, "field 'sc_show_top'", SwitchCompat.class);
    target.sc_show_banner = Utils.findRequiredViewAsType(source, R.id.sc_show_banner, "field 'sc_show_banner'", SwitchCompat.class);
    target.sc_hide_about_me = Utils.findRequiredViewAsType(source, R.id.sc_hide_about_me, "field 'sc_hide_about_me'", SwitchCompat.class);
    target.sc_hide_open = Utils.findRequiredViewAsType(source, R.id.sc_hide_open, "field 'sc_hide_open'", SwitchCompat.class);
    target.sc_web_swipeback_edge = Utils.findRequiredViewAsType(source, R.id.sc_web_swipeback_edge, "field 'sc_web_swipeback_edge'", SwitchCompat.class);
    target.tv_intercept_host = Utils.findRequiredViewAsType(source, R.id.tv_intercept_host, "field 'tv_intercept_host'", TextView.class);
    target.tv_rv_anim = Utils.findRequiredViewAsType(source, R.id.tv_rv_anim, "field 'tv_rv_anim'", TextView.class);
    target.tv_cache = Utils.findRequiredViewAsType(source, R.id.tv_cache, "field 'tv_cache'", TextView.class);
    target.tv_has_update = Utils.findRequiredViewAsType(source, R.id.tv_has_update, "field 'tv_has_update'", TextView.class);
    target.tv_curr_version = Utils.findRequiredViewAsType(source, R.id.tv_curr_version, "field 'tv_curr_version'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_logout, "field 'll_logout' and method 'onClick'");
    target.ll_logout = Utils.castView(view, R.id.ll_logout, "field 'll_logout'", LinearLayout.class);
    view2131231074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_intercept_host, "method 'onClick' and method 'onLongClick'");
    view2131231287 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View p0) {
        return target.onLongClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_rv_anim, "method 'onClick'");
    view2131231083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_update, "method 'onClick'");
    view2131231089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_cache, "method 'onClick'");
    view2131231060 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_about, "method 'onClick'");
    view2131231052 = view;
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
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sc_dark_theme = null;
    target.sc_show_read_later = null;
    target.sc_show_top = null;
    target.sc_show_banner = null;
    target.sc_hide_about_me = null;
    target.sc_hide_open = null;
    target.sc_web_swipeback_edge = null;
    target.tv_intercept_host = null;
    target.tv_rv_anim = null;
    target.tv_cache = null;
    target.tv_has_update = null;
    target.tv_curr_version = null;
    target.ll_logout = null;

    view2131231074.setOnClickListener(null);
    view2131231074 = null;
    view2131231287.setOnClickListener(null);
    view2131231287.setOnLongClickListener(null);
    view2131231287 = null;
    view2131231083.setOnClickListener(null);
    view2131231083 = null;
    view2131231089.setOnClickListener(null);
    view2131231089 = null;
    view2131231060.setOnClickListener(null);
    view2131231060 = null;
    view2131231052.setOnClickListener(null);
    view2131231052 = null;
  }
}
