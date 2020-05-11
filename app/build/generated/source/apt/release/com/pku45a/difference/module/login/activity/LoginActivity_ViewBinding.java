// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.login.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.rl_input = Utils.findRequiredViewAsType(source, R.id.rl_input, "field 'rl_input'", RelativeLayout.class);
    target.iv_circle_1 = Utils.findRequiredViewAsType(source, R.id.iv_circle_1, "field 'iv_circle_1'", ImageView.class);
    target.iv_circle_2 = Utils.findRequiredViewAsType(source, R.id.iv_circle_2, "field 'iv_circle_2'", ImageView.class);
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rl_input = null;
    target.iv_circle_1 = null;
    target.iv_circle_2 = null;
    target.vp = null;
  }
}
