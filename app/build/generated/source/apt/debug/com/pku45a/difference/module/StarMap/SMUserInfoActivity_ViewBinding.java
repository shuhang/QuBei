// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class SMUserInfoActivity_ViewBinding implements Unbinder {
  private SMUserInfoActivity target;

  @UiThread
  public SMUserInfoActivity_ViewBinding(SMUserInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMUserInfoActivity_ViewBinding(SMUserInfoActivity target, View source) {
    this.target = target;

    target.actionBarCommon = Utils.findRequiredViewAsType(source, R.id.abc, "field 'actionBarCommon'", ActionBarCommon.class);
    target.headImageView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_head, "field 'headImageView'", ImageView.class);
    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_name, "field 'nameTextView'", TextView.class);
    target.tagTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_tag, "field 'tagTextView'", TextView.class);
    target.rankImageView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_rank_image, "field 'rankImageView'", ImageView.class);
    target.feedTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_feed_count, "field 'feedTextView'", TextView.class);
    target.focusTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_focus_count, "field 'focusTextView'", TextView.class);
    target.changeTypeTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_text_change_type, "field 'changeTypeTextView'", TextView.class);
    target.riskTextView = Utils.findRequiredViewAsType(source, R.id.sm_user_info_text_risk, "field 'riskTextView'", TextView.class);
    target.focusButton = Utils.findRequiredViewAsType(source, R.id.sm_user_info_focus, "field 'focusButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMUserInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.actionBarCommon = null;
    target.headImageView = null;
    target.nameTextView = null;
    target.tagTextView = null;
    target.rankImageView = null;
    target.feedTextView = null;
    target.focusTextView = null;
    target.changeTypeTextView = null;
    target.riskTextView = null;
    target.focusButton = null;
  }
}
