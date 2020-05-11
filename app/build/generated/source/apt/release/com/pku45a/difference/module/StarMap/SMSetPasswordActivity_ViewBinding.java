// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.InputView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMSetPasswordActivity_ViewBinding implements Unbinder {
  private SMSetPasswordActivity target;

  @UiThread
  public SMSetPasswordActivity_ViewBinding(SMSetPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMSetPasswordActivity_ViewBinding(SMSetPasswordActivity target, View source) {
    this.target = target;

    target.topTextView = Utils.findRequiredViewAsType(source, R.id.sm_set_password_text_top, "field 'topTextView'", TextView.class);
    target.buttonRegister = Utils.findRequiredViewAsType(source, R.id.sm_set_password_button_register, "field 'buttonRegister'", Button.class);
    target.passwordInputView1 = Utils.findRequiredViewAsType(source, R.id.sm_set_password_input_password1, "field 'passwordInputView1'", InputView.class);
    target.passwordInputView2 = Utils.findRequiredViewAsType(source, R.id.sm_set_password_input_password2, "field 'passwordInputView2'", InputView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMSetPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.topTextView = null;
    target.buttonRegister = null;
    target.passwordInputView1 = null;
    target.passwordInputView2 = null;
  }
}
