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

public class ReplaceBillActivity_ViewBinding implements Unbinder {
  private ReplaceBillActivity target;

  @UiThread
  public ReplaceBillActivity_ViewBinding(ReplaceBillActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReplaceBillActivity_ViewBinding(ReplaceBillActivity target, View source) {
    this.target = target;

    target.confirmButton = Utils.findRequiredViewAsType(source, R.id.replace_bill_confirm, "field 'confirmButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReplaceBillActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.confirmButton = null;
  }
}
