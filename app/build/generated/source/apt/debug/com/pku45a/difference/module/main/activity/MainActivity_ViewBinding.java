// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.main.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131231055;

  private View view2131231056;

  private View view2131231059;

  private View view2131231058;

  private View view2131231057;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
    target.ll_bb = Utils.findRequiredViewAsType(source, R.id.ll_bb, "field 'll_bb'", LinearLayout.class);
    target.iv_bb_home = Utils.findRequiredViewAsType(source, R.id.iv_bb_home, "field 'iv_bb_home'", ImageView.class);
    target.tv_bb_home = Utils.findRequiredViewAsType(source, R.id.tv_bb_home, "field 'tv_bb_home'", TextView.class);
    target.iv_bb_knowledge = Utils.findRequiredViewAsType(source, R.id.iv_bb_knowledge, "field 'iv_bb_knowledge'", ImageView.class);
    target.tv_bb_knowledge = Utils.findRequiredViewAsType(source, R.id.tv_bb_knowledge, "field 'tv_bb_knowledge'", TextView.class);
    target.iv_bb_wechat = Utils.findRequiredViewAsType(source, R.id.iv_bb_wechat, "field 'iv_bb_wechat'", ImageView.class);
    target.tv_bb_wechat = Utils.findRequiredViewAsType(source, R.id.tv_bb_wechat, "field 'tv_bb_wechat'", TextView.class);
    target.iv_bb_project = Utils.findRequiredViewAsType(source, R.id.iv_bb_project, "field 'iv_bb_project'", ImageView.class);
    target.tv_bb_project = Utils.findRequiredViewAsType(source, R.id.tv_bb_project, "field 'tv_bb_project'", TextView.class);
    target.iv_bb_mine = Utils.findRequiredViewAsType(source, R.id.iv_bb_mine, "field 'iv_bb_mine'", ImageView.class);
    target.tv_bb_mine = Utils.findRequiredViewAsType(source, R.id.tv_bb_mine, "field 'tv_bb_mine'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_bb_home, "method 'onClick'");
    view2131231055 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bb_knowledge, "method 'onClick'");
    view2131231056 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bb_wechat, "method 'onClick'");
    view2131231059 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bb_project, "method 'onClick'");
    view2131231058 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bb_mine, "method 'onClick'");
    view2131231057 = view;
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
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vp = null;
    target.ll_bb = null;
    target.iv_bb_home = null;
    target.tv_bb_home = null;
    target.iv_bb_knowledge = null;
    target.tv_bb_knowledge = null;
    target.iv_bb_wechat = null;
    target.tv_bb_wechat = null;
    target.iv_bb_project = null;
    target.tv_bb_project = null;
    target.iv_bb_mine = null;
    target.tv_bb_mine = null;

    view2131231055.setOnClickListener(null);
    view2131231055 = null;
    view2131231056.setOnClickListener(null);
    view2131231056 = null;
    view2131231059.setOnClickListener(null);
    view2131231059 = null;
    view2131231058.setOnClickListener(null);
    view2131231058 = null;
    view2131231057.setOnClickListener(null);
    view2131231057 = null;
  }
}
