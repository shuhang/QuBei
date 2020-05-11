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
import com.yuzhix.idiom.widget.InputView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMCreateAccountActivity_ViewBinding implements Unbinder {
  private SMCreateAccountActivity target;

  @UiThread
  public SMCreateAccountActivity_ViewBinding(SMCreateAccountActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMCreateAccountActivity_ViewBinding(SMCreateAccountActivity target, View source) {
    this.target = target;

    target.topTextView = Utils.findRequiredViewAsType(source, R.id.sm_create_account_top_text, "field 'topTextView'", TextView.class);
    target.nameInputView = Utils.findRequiredViewAsType(source, R.id.sm_create_account_input_name, "field 'nameInputView'", InputView.class);
    target.phoneInputView = Utils.findRequiredViewAsType(source, R.id.sm_create_account_input_phone, "field 'phoneInputView'", InputView.class);
    target.codeButton = Utils.findRequiredViewAsType(source, R.id.sm_create_account_button_get_code, "field 'codeButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMCreateAccountActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.topTextView = null;
    target.nameInputView = null;
    target.phoneInputView = null;
    target.codeButton = null;
  }
}
