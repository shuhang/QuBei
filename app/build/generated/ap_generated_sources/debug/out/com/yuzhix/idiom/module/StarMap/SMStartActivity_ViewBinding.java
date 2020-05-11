// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import com.yuzhix.idiom.module.QB.QBViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMStartActivity_ViewBinding implements Unbinder {
  private SMStartActivity target;

  @UiThread
  public SMStartActivity_ViewBinding(SMStartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMStartActivity_ViewBinding(SMStartActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.qb_welcome_pager, "field 'viewPager'", QBViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMStartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
  }
}
