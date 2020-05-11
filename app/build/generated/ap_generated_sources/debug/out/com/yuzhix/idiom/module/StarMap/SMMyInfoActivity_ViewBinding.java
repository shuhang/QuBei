// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMyInfoActivity_ViewBinding implements Unbinder {
  private SMMyInfoActivity target;

  @UiThread
  public SMMyInfoActivity_ViewBinding(SMMyInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMMyInfoActivity_ViewBinding(SMMyInfoActivity target, View source) {
    this.target = target;

    target.headLayout = Utils.findRequiredViewAsType(source, R.id.sm_my_info_layout_head, "field 'headLayout'", RelativeLayout.class);
    target.tagLayout = Utils.findRequiredViewAsType(source, R.id.sm_my_info_layout_tag, "field 'tagLayout'", RelativeLayout.class);
    target.passwordLayout = Utils.findRequiredViewAsType(source, R.id.sm_my_info_layout_password, "field 'passwordLayout'", RelativeLayout.class);
    target.headImageView = Utils.findRequiredViewAsType(source, R.id.sm_my_info_image_head, "field 'headImageView'", ImageView.class);
    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.sm_my_info_text_name, "field 'nameTextView'", TextView.class);
    target.phoneTextView = Utils.findRequiredViewAsType(source, R.id.sm_my_info_text_phone, "field 'phoneTextView'", TextView.class);
    target.tagTextView = Utils.findRequiredViewAsType(source, R.id.sm_my_info_text_tag, "field 'tagTextView'", TextView.class);
    target.hideSwitch = Utils.findRequiredViewAsType(source, R.id.sm_my_info_switch_hide, "field 'hideSwitch'", SwitchCompat.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMyInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headLayout = null;
    target.tagLayout = null;
    target.passwordLayout = null;
    target.headImageView = null;
    target.nameTextView = null;
    target.phoneTextView = null;
    target.tagTextView = null;
    target.hideSwitch = null;
  }
}
