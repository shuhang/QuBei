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

public class QBAddFriendActivity_ViewBinding implements Unbinder {
  private QBAddFriendActivity target;

  @UiThread
  public QBAddFriendActivity_ViewBinding(QBAddFriendActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBAddFriendActivity_ViewBinding(QBAddFriendActivity target, View source) {
    this.target = target;

    target.button = Utils.findRequiredViewAsType(source, R.id.qb_addZ_friend_button, "field 'button'", Button.class);
    target.inputEditText = Utils.findRequiredViewAsType(source, R.id.qb_addZ_friend_input, "field 'inputEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBAddFriendActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.button = null;
    target.inputEditText = null;
  }
}
