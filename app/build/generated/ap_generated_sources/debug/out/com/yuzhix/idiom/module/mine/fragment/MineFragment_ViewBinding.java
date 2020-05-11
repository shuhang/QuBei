// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.mine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment target;

  private View view2131230849;

  private View view2131231583;

  private View view2131231080;

  private View view2131231077;

  private View view2131231053;

  private View view2131231091;

  private View view2131231064;

  private View view2131231084;

  private View view2131231063;

  private View view2131231085;

  @UiThread
  public MineFragment_ViewBinding(final MineFragment target, View source) {
    this.target = target;

    View view;
    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.srl, "field 'srl'", SmartRefreshLayout.class);
    target.nsv = Utils.findRequiredViewAsType(source, R.id.nsv, "field 'nsv'", NestedScrollView.class);
    target.iv_blur = Utils.findRequiredViewAsType(source, R.id.iv_blur, "field 'iv_blur'", ImageView.class);
    target.rl_user_info = Utils.findRequiredViewAsType(source, R.id.rl_user_info, "field 'rl_user_info'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.civ_user_icon, "field 'civ_user_icon' and method 'onClick'");
    target.civ_user_icon = Utils.castView(view, R.id.civ_user_icon, "field 'civ_user_icon'", ImageView.class);
    view2131230849 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_user_name, "field 'tv_user_name' and method 'onClick'");
    target.tv_user_name = Utils.castView(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
    view2131231583 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_user_id = Utils.findRequiredViewAsType(source, R.id.tv_user_id, "field 'tv_user_id'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_read_later, "field 'll_read_later' and method 'onClick'");
    target.ll_read_later = Utils.castView(view, R.id.ll_read_later, "field 'll_read_later'", LinearLayout.class);
    view2131231080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_open, "field 'll_open' and method 'onClick'");
    target.ll_open = Utils.castView(view, R.id.ll_open, "field 'll_open'", LinearLayout.class);
    view2131231077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_about_me, "field 'll_about_me' and method 'onClick'");
    target.ll_about_me = Utils.castView(view, R.id.ll_about_me, "field 'll_about_me'", LinearLayout.class);
    view2131231053 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_user_level = Utils.findRequiredViewAsType(source, R.id.tv_user_level, "field 'tv_user_level'", TextView.class);
    target.tv_user_ranking = Utils.findRequiredViewAsType(source, R.id.tv_user_ranking, "field 'tv_user_ranking'", TextView.class);
    target.tv_coin = Utils.findRequiredViewAsType(source, R.id.tv_coin, "field 'tv_coin'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_user_id, "method 'onClick'");
    view2131231091 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_collect, "method 'onClick'");
    view2131231064 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_setting, "method 'onClick'");
    view2131231084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_coin, "method 'onClick'");
    view2131231063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_share, "method 'onClick'");
    view2131231085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abc = null;
    target.srl = null;
    target.nsv = null;
    target.iv_blur = null;
    target.rl_user_info = null;
    target.civ_user_icon = null;
    target.tv_user_name = null;
    target.tv_user_id = null;
    target.ll_read_later = null;
    target.ll_open = null;
    target.ll_about_me = null;
    target.tv_user_level = null;
    target.tv_user_ranking = null;
    target.tv_coin = null;

    view2131230849.setOnClickListener(null);
    view2131230849 = null;
    view2131231583.setOnClickListener(null);
    view2131231583 = null;
    view2131231080.setOnClickListener(null);
    view2131231080 = null;
    view2131231077.setOnClickListener(null);
    view2131231077 = null;
    view2131231053.setOnClickListener(null);
    view2131231053 = null;
    view2131231091.setOnClickListener(null);
    view2131231091 = null;
    view2131231064.setOnClickListener(null);
    view2131231064 = null;
    view2131231084.setOnClickListener(null);
    view2131231084 = null;
    view2131231063.setOnClickListener(null);
    view2131231063 = null;
    view2131231085.setOnClickListener(null);
    view2131231085 = null;
  }
}
