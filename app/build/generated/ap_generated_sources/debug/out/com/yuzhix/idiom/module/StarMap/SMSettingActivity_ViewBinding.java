// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMSettingActivity_ViewBinding implements Unbinder {
  private SMSettingActivity target;

  @UiThread
  public SMSettingActivity_ViewBinding(SMSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMSettingActivity_ViewBinding(SMSettingActivity target, View source) {
    this.target = target;

    target.clearMemoryLayout = Utils.findRequiredViewAsType(source, R.id.sm_setting_clear_memory, "field 'clearMemoryLayout'", RelativeLayout.class);
    target.shareLayout = Utils.findRequiredViewAsType(source, R.id.sm_setting_share, "field 'shareLayout'", RelativeLayout.class);
    target.memoryTextView = Utils.findRequiredViewAsType(source, R.id.sm_setting_text_memory, "field 'memoryTextView'", TextView.class);
    target.logoutButton = Utils.findRequiredViewAsType(source, R.id.sm_setting_logout, "field 'logoutButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMSettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.clearMemoryLayout = null;
    target.shareLayout = null;
    target.memoryTextView = null;
    target.logoutButton = null;
  }
}
