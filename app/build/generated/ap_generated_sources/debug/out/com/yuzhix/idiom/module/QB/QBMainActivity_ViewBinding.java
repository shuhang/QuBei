// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBMainActivity_ViewBinding implements Unbinder {
  private QBMainActivity target;

  @UiThread
  public QBMainActivity_ViewBinding(QBMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBMainActivity_ViewBinding(QBMainActivity target, View source) {
    this.target = target;

    target.addButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_add, "field 'addButton'", Button.class);
    target.locationButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_location, "field 'locationButton'", Button.class);
    target.mineButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_mine, "field 'mineButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.addButton = null;
    target.locationButton = null;
    target.mineButton = null;
  }
}
