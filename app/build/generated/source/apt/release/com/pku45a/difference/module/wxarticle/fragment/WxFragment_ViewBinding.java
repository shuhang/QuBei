// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.wxarticle.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.ActionBarEx;

public class WxFragment_ViewBinding implements Unbinder {
  private WxFragment target;

  @UiThread
  public WxFragment_ViewBinding(WxFragment target, View source) {
    this.target = target;

    target.ab = Utils.findRequiredViewAsType(source, R.id.ab, "field 'ab'", ActionBarEx.class);
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WxFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ab = null;
    target.vp = null;
  }
}
