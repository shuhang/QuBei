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

public class SMLoginActivity_ViewBinding implements Unbinder {
  private SMLoginActivity target;

  @UiThread
  public SMLoginActivity_ViewBinding(SMLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMLoginActivity_ViewBinding(SMLoginActivity target, View source) {
    this.target = target;

    target.nameInputView = Utils.findRequiredViewAsType(source, R.id.sm_login_input_name, "field 'nameInputView'", InputView.class);
    target.passwordInputView = Utils.findRequiredViewAsType(source, R.id.sm_login_input_password, "field 'passwordInputView'", InputView.class);
    target.buttonLogin = Utils.findRequiredViewAsType(source, R.id.sm_login_button_login, "field 'buttonLogin'", Button.class);
    target.buttonRegister = Utils.findRequiredViewAsType(source, R.id.sm_login_button_register, "field 'buttonRegister'", Button.class);
    target.buttonForgetPassword = Utils.findRequiredViewAsType(source, R.id.sm_login_button_forget_password, "field 'buttonForgetPassword'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameInputView = null;
    target.passwordInputView = null;
    target.buttonLogin = null;
    target.buttonRegister = null;
    target.buttonForgetPassword = null;
  }
}
