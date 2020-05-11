// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.mine.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.daimajia.swipe.SwipeLayout;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.percentimageview.percentimageview.PercentImageView;

public class AboutMeActivity_ViewBinding implements Unbinder {
  private AboutMeActivity target;

  private View view2131231067;

  private View view2131231071;

  private View view2131231078;

  private View view2131231079;

  @UiThread
  public AboutMeActivity_ViewBinding(AboutMeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutMeActivity_ViewBinding(final AboutMeActivity target, View source) {
    this.target = target;

    View view;
    target.sl = Utils.findRequiredViewAsType(source, R.id.sl, "field 'sl'", SwipeLayout.class);
    target.iv_blur = Utils.findRequiredViewAsType(source, R.id.iv_blur, "field 'iv_blur'", ImageView.class);
    target.civ_icon = Utils.findRequiredViewAsType(source, R.id.civ_icon, "field 'civ_icon'", ImageView.class);
    target.tv_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_name'", TextView.class);
    target.tv_sign = Utils.findRequiredViewAsType(source, R.id.tv_sign, "field 'tv_sign'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_github, "field 'll_github' and method 'onClick'");
    target.ll_github = Utils.castView(view, R.id.ll_github, "field 'll_github'", LinearLayout.class);
    view2131231067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_jianshu, "field 'll_jianshu' and method 'onClick'");
    target.ll_jianshu = Utils.castView(view, R.id.ll_jianshu, "field 'll_jianshu'", LinearLayout.class);
    view2131231071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_qq, "field 'll_qq' and method 'onClick'");
    target.ll_qq = Utils.castView(view, R.id.ll_qq, "field 'll_qq'", LinearLayout.class);
    view2131231078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_qq_group, "field 'll_qq_group' and method 'onClick'");
    target.ll_qq_group = Utils.castView(view, R.id.ll_qq_group, "field 'll_qq_group'", LinearLayout.class);
    view2131231079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_github = Utils.findRequiredViewAsType(source, R.id.tv_github, "field 'tv_github'", TextView.class);
    target.tv_jianshu = Utils.findRequiredViewAsType(source, R.id.tv_jianshu, "field 'tv_jianshu'", TextView.class);
    target.tv_qq = Utils.findRequiredViewAsType(source, R.id.tv_qq, "field 'tv_qq'", TextView.class);
    target.tv_qq_group = Utils.findRequiredViewAsType(source, R.id.tv_qq_group, "field 'tv_qq_group'", TextView.class);
    target.rl_info = Utils.findRequiredViewAsType(source, R.id.rl_info, "field 'rl_info'", RelativeLayout.class);
    target.rl_reward = Utils.findRequiredViewAsType(source, R.id.rl_reward, "field 'rl_reward'", RelativeLayout.class);
    target.piv_qq_qrcode = Utils.findRequiredViewAsType(source, R.id.piv_qq_qrcode, "field 'piv_qq_qrcode'", PercentImageView.class);
    target.piv_wx_qrcode = Utils.findRequiredViewAsType(source, R.id.piv_wx_qrcode, "field 'piv_wx_qrcode'", PercentImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutMeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sl = null;
    target.iv_blur = null;
    target.civ_icon = null;
    target.tv_name = null;
    target.tv_sign = null;
    target.ll_github = null;
    target.ll_jianshu = null;
    target.ll_qq = null;
    target.ll_qq_group = null;
    target.tv_github = null;
    target.tv_jianshu = null;
    target.tv_qq = null;
    target.tv_qq_group = null;
    target.rl_info = null;
    target.rl_reward = null;
    target.piv_qq_qrcode = null;
    target.piv_wx_qrcode = null;

    view2131231067.setOnClickListener(null);
    view2131231067 = null;
    view2131231071.setOnClickListener(null);
    view2131231071 = null;
    view2131231078.setOnClickListener(null);
    view2131231078 = null;
    view2131231079.setOnClickListener(null);
    view2131231079 = null;
  }
}
