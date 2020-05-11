// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class QBLocalWebActivity_ViewBinding implements Unbinder {
  private QBLocalWebActivity target;

  @UiThread
  public QBLocalWebActivity_ViewBinding(QBLocalWebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBLocalWebActivity_ViewBinding(QBLocalWebActivity target, View source) {
    this.target = target;

    target.infoTextView = Utils.findRequiredViewAsType(source, R.id.qb_local_web_info, "field 'infoTextView'", TextView.class);
    target.actionBarCommon = Utils.findRequiredViewAsType(source, R.id.abc, "field 'actionBarCommon'", ActionBarCommon.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBLocalWebActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.infoTextView = null;
    target.actionBarCommon = null;
  }
}
