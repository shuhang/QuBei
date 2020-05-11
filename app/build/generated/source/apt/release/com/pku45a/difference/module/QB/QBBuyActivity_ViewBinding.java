// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBBuyActivity_ViewBinding implements Unbinder {
  private QBBuyActivity target;

  @UiThread
  public QBBuyActivity_ViewBinding(QBBuyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBBuyActivity_ViewBinding(QBBuyActivity target, View source) {
    this.target = target;

    target.layout1 = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout1, "field 'layout1'", RelativeLayout.class);
    target.layout1_bg = Utils.findRequiredView(source, R.id.qb_buy_layout1_bg, "field 'layout1_bg'");
    target.layout1_price = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout1_text_price, "field 'layout1_price'", TextView.class);
    target.layout1_info = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout1_text_info, "field 'layout1_info'", TextView.class);
    target.layout1_check_image = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout1_check_image, "field 'layout1_check_image'", ImageView.class);
    target.layout1_red_image = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout1_top_red, "field 'layout1_red_image'", TextView.class);
    target.layout2 = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout2, "field 'layout2'", RelativeLayout.class);
    target.layout2_bg = Utils.findRequiredView(source, R.id.qb_buy_layout2_bg, "field 'layout2_bg'");
    target.layout2_price = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout2_text_price, "field 'layout2_price'", TextView.class);
    target.layout2_info = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout2_text_info, "field 'layout2_info'", TextView.class);
    target.layout2_check_image = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout2_check_image, "field 'layout2_check_image'", ImageView.class);
    target.layout3 = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout3, "field 'layout3'", RelativeLayout.class);
    target.layout3_bg = Utils.findRequiredView(source, R.id.qb_buy_layout3_bg, "field 'layout3_bg'");
    target.layout3_price = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout3_text_price, "field 'layout3_price'", TextView.class);
    target.layout3_info = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout3_text_info, "field 'layout3_info'", TextView.class);
    target.layout3_check_image = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout3_check_image, "field 'layout3_check_image'", ImageView.class);
    target.layout4 = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout4, "field 'layout4'", RelativeLayout.class);
    target.layout4_bg = Utils.findRequiredView(source, R.id.qb_buy_layout4_bg, "field 'layout4_bg'");
    target.layout4_price = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout4_text_price, "field 'layout4_price'", TextView.class);
    target.layout4_info = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout4_text_info, "field 'layout4_info'", TextView.class);
    target.layout4_check_image = Utils.findRequiredViewAsType(source, R.id.qb_buy_layout4_check_image, "field 'layout4_check_image'", ImageView.class);
    target.buyButton = Utils.findRequiredViewAsType(source, R.id.qb_buy_button, "field 'buyButton'", Button.class);
    target.skipButton = Utils.findRequiredViewAsType(source, R.id.qb_buy_skip, "field 'skipButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBBuyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layout1 = null;
    target.layout1_bg = null;
    target.layout1_price = null;
    target.layout1_info = null;
    target.layout1_check_image = null;
    target.layout1_red_image = null;
    target.layout2 = null;
    target.layout2_bg = null;
    target.layout2_price = null;
    target.layout2_info = null;
    target.layout2_check_image = null;
    target.layout3 = null;
    target.layout3_bg = null;
    target.layout3_price = null;
    target.layout3_info = null;
    target.layout3_check_image = null;
    target.layout4 = null;
    target.layout4_bg = null;
    target.layout4_price = null;
    target.layout4_info = null;
    target.layout4_check_image = null;
    target.buyButton = null;
    target.skipButton = null;
  }
}
