// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.InputView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMCheckPhoneActivity_ViewBinding implements Unbinder {
  private SMCheckPhoneActivity target;

  @UiThread
  public SMCheckPhoneActivity_ViewBinding(SMCheckPhoneActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMCheckPhoneActivity_ViewBinding(SMCheckPhoneActivity target, View source) {
    this.target = target;

    target.topTextView = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_top_text, "field 'topTextView'", TextView.class);
    target.timeTextView = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_text_time, "field 'timeTextView'", TextView.class);
    target.codeInputView = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_input_code, "field 'codeInputView'", InputView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_input_image, "field 'imageView'", ImageView.class);
    target.codeButton = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_button_get_code, "field 'codeButton'", Button.class);
    target.checkButton = Utils.findRequiredViewAsType(source, R.id.sm_check_phone_button_check, "field 'checkButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMCheckPhoneActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.topTextView = null;
    target.timeTextView = null;
    target.codeInputView = null;
    target.imageView = null;
    target.codeButton = null;
    target.checkButton = null;
  }
}
