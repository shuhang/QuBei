// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMSetTagActivity_ViewBinding implements Unbinder {
  private SMSetTagActivity target;

  @UiThread
  public SMSetTagActivity_ViewBinding(SMSetTagActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMSetTagActivity_ViewBinding(SMSetTagActivity target, View source) {
    this.target = target;

    target.inputEditText = Utils.findRequiredViewAsType(source, R.id.sm_set_tag_input, "field 'inputEditText'", EditText.class);
    target.saveButton = Utils.findRequiredViewAsType(source, R.id.sm_set_tag_save, "field 'saveButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMSetTagActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.inputEditText = null;
    target.saveButton = null;
  }
}
