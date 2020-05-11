// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import com.yuzhix.idiom.widget.InputView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMForgetPasswordActivity_ViewBinding implements Unbinder {
  private SMForgetPasswordActivity target;

  @UiThread
  public SMForgetPasswordActivity_ViewBinding(SMForgetPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMForgetPasswordActivity_ViewBinding(SMForgetPasswordActivity target, View source) {
    this.target = target;

    target.phoneInputView = Utils.findRequiredViewAsType(source, R.id.sm_forget_password_input_phone, "field 'phoneInputView'", InputView.class);
    target.buttonGetCode = Utils.findRequiredViewAsType(source, R.id.sm_forget_password_button_get_code, "field 'buttonGetCode'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMForgetPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.phoneInputView = null;
    target.buttonGetCode = null;
  }
}
