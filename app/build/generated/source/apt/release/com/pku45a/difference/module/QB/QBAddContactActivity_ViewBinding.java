// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBAddContactActivity_ViewBinding implements Unbinder {
  private QBAddContactActivity target;

  @UiThread
  public QBAddContactActivity_ViewBinding(QBAddContactActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBAddContactActivity_ViewBinding(QBAddContactActivity target, View source) {
    this.target = target;

    target.button = Utils.findRequiredViewAsType(source, R.id.qb_add_contact_button_add, "field 'button'", Button.class);
    target.nameEditText = Utils.findRequiredViewAsType(source, R.id.qb_add_contact_name, "field 'nameEditText'", EditText.class);
    target.phoneEditText = Utils.findRequiredViewAsType(source, R.id.qb_add_contact_phone, "field 'phoneEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBAddContactActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.button = null;
    target.nameEditText = null;
    target.phoneEditText = null;
  }
}
