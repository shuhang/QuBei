// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.ShuHang.Tab2.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyHomeActivity_ViewBinding implements Unbinder {
  private MyHomeActivity target;

  @UiThread
  public MyHomeActivity_ViewBinding(MyHomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyHomeActivity_ViewBinding(MyHomeActivity target, View source) {
    this.target = target;

    target.getMoneyButton = Utils.findRequiredViewAsType(source, R.id.home_page_mine_get_money, "field 'getMoneyButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyHomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.getMoneyButton = null;
  }
}
