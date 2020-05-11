// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WelcomeActivity_ViewBinding implements Unbinder {
  private WelcomeActivity target;

  @UiThread
  public WelcomeActivity_ViewBinding(WelcomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WelcomeActivity_ViewBinding(WelcomeActivity target, View source) {
    this.target = target;

    target.topTextView = Utils.findRequiredViewAsType(source, R.id.sm_welcome_top_text, "field 'topTextView'", TextView.class);
    target.buttonLogin = Utils.findRequiredViewAsType(source, R.id.sm_welcome_button_login, "field 'buttonLogin'", Button.class);
    target.buttonRegister = Utils.findRequiredViewAsType(source, R.id.sm_welcome_button_register, "field 'buttonRegister'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WelcomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.topTextView = null;
    target.buttonLogin = null;
    target.buttonRegister = null;
  }
}
