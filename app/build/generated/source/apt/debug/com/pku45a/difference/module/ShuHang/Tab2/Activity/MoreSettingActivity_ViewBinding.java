// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoreSettingActivity_ViewBinding implements Unbinder {
  private MoreSettingActivity target;

  @UiThread
  public MoreSettingActivity_ViewBinding(MoreSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoreSettingActivity_ViewBinding(MoreSettingActivity target, View source) {
    this.target = target;

    target.ruleLayout = Utils.findRequiredViewAsType(source, R.id.more_setting_rule, "field 'ruleLayout'", RelativeLayout.class);
    target.feedbackLayout = Utils.findRequiredViewAsType(source, R.id.more_setting_feedback, "field 'feedbackLayout'", RelativeLayout.class);
    target.privacyLayout = Utils.findRequiredViewAsType(source, R.id.more_setting_privacy, "field 'privacyLayout'", RelativeLayout.class);
    target.updateLayout = Utils.findRequiredViewAsType(source, R.id.more_setting_update, "field 'updateLayout'", RelativeLayout.class);
    target.onlineLayout = Utils.findRequiredViewAsType(source, R.id.more_setting_online, "field 'onlineLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoreSettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ruleLayout = null;
    target.feedbackLayout = null;
    target.privacyLayout = null;
    target.updateLayout = null;
    target.onlineLayout = null;
  }
}
