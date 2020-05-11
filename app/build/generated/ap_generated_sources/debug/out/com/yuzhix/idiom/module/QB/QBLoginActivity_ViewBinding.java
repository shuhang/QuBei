// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBLoginActivity_ViewBinding implements Unbinder {
  private QBLoginActivity target;

  @UiThread
  public QBLoginActivity_ViewBinding(QBLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBLoginActivity_ViewBinding(QBLoginActivity target, View source) {
    this.target = target;

    target.phoneEditText = Utils.findRequiredViewAsType(source, R.id.qb_login_input_phone, "field 'phoneEditText'", EditText.class);
    target.codeEditText = Utils.findRequiredViewAsType(source, R.id.qb_login_input_code, "field 'codeEditText'", EditText.class);
    target.codeButton = Utils.findRequiredViewAsType(source, R.id.qb_login_button_code, "field 'codeButton'", Button.class);
    target.timeTextView = Utils.findRequiredViewAsType(source, R.id.qb_login_text_time, "field 'timeTextView'", TextView.class);
    target.agreeLayout = Utils.findRequiredViewAsType(source, R.id.qb_login_layout_agree, "field 'agreeLayout'", RelativeLayout.class);
    target.agreeTextView = Utils.findRequiredViewAsType(source, R.id.qb_login_text_agreement, "field 'agreeTextView'", TextView.class);
    target.agreeImageView = Utils.findRequiredViewAsType(source, R.id.qb_login_image_agree, "field 'agreeImageView'", ImageView.class);
    target.addButton = Utils.findRequiredViewAsType(source, R.id.qb_login_button_add, "field 'addButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.phoneEditText = null;
    target.codeEditText = null;
    target.codeButton = null;
    target.timeTextView = null;
    target.agreeLayout = null;
    target.agreeTextView = null;
    target.agreeImageView = null;
    target.addButton = null;
  }
}
