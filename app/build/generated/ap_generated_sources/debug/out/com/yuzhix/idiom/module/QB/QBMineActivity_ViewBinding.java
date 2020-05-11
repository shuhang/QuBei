// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBMineActivity_ViewBinding implements Unbinder {
  private QBMineActivity target;

  @UiThread
  public QBMineActivity_ViewBinding(QBMineActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBMineActivity_ViewBinding(QBMineActivity target, View source) {
    this.target = target;

    target.settingButton = Utils.findRequiredViewAsType(source, R.id.qb_mine_button_setting, "field 'settingButton'", Button.class);
    target.unlockButton = Utils.findRequiredViewAsType(source, R.id.qb_mine_unlock, "field 'unlockButton'", Button.class);
    target.layoutService = Utils.findRequiredViewAsType(source, R.id.qb_mine_layout_service, "field 'layoutService'", RelativeLayout.class);
    target.layoutShare = Utils.findRequiredViewAsType(source, R.id.qb_mine_layout_share, "field 'layoutShare'", RelativeLayout.class);
    target.layoutLocation = Utils.findRequiredViewAsType(source, R.id.qb_mine_layout_location, "field 'layoutLocation'", RelativeLayout.class);
    target.layoutVip = Utils.findRequiredViewAsType(source, R.id.qb_mine_vip, "field 'layoutVip'", RelativeLayout.class);
    target.layoutNoVip = Utils.findRequiredViewAsType(source, R.id.qb_mine_no_vip, "field 'layoutNoVip'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBMineActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.settingButton = null;
    target.unlockButton = null;
    target.layoutService = null;
    target.layoutShare = null;
    target.layoutLocation = null;
    target.layoutVip = null;
    target.layoutNoVip = null;
  }
}
