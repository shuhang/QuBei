// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBGuidePermissionActivity_ViewBinding implements Unbinder {
  private QBGuidePermissionActivity target;

  @UiThread
  public QBGuidePermissionActivity_ViewBinding(QBGuidePermissionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBGuidePermissionActivity_ViewBinding(QBGuidePermissionActivity target, View source) {
    this.target = target;

    target.buttonContinue = Utils.findRequiredViewAsType(source, R.id.qb_guide_permission_continue, "field 'buttonContinue'", Button.class);
    target.buttonAgreement = Utils.findRequiredViewAsType(source, R.id.qb_guide_permission_agreement, "field 'buttonAgreement'", Button.class);
    target.layoutAgree = Utils.findRequiredViewAsType(source, R.id.qb_guide_permission_layout_agree, "field 'layoutAgree'", RelativeLayout.class);
    target.imageAgree = Utils.findRequiredViewAsType(source, R.id.qb_guide_permission_image_agree, "field 'imageAgree'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBGuidePermissionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonContinue = null;
    target.buttonAgreement = null;
    target.layoutAgree = null;
    target.imageAgree = null;
  }
}
