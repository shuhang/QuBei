// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBSettingActivity_ViewBinding implements Unbinder {
  private QBSettingActivity target;

  @UiThread
  public QBSettingActivity_ViewBinding(QBSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBSettingActivity_ViewBinding(QBSettingActivity target, View source) {
    this.target = target;

    target.layoutPrivacy = Utils.findRequiredViewAsType(source, R.id.qb_setting_privacy, "field 'layoutPrivacy'", RelativeLayout.class);
    target.layoutAgreement = Utils.findRequiredViewAsType(source, R.id.qb_setting_agreement, "field 'layoutAgreement'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBSettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutPrivacy = null;
    target.layoutAgreement = null;
  }
}
