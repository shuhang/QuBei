// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.home.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kennyc.view.MultiStateView;
import com.pku45a.difference.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class UserPageActivity_ViewBinding implements Unbinder {
  private UserPageActivity target;

  @UiThread
  public UserPageActivity_ViewBinding(UserPageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserPageActivity_ViewBinding(UserPageActivity target, View source) {
    this.target = target;

    target.msv = Utils.findRequiredViewAsType(source, R.id.msv, "field 'msv'", MultiStateView.class);
    target.cl = Utils.findRequiredViewAsType(source, R.id.cl, "field 'cl'", CoordinatorLayout.class);
    target.ctbl = Utils.findRequiredViewAsType(source, R.id.ctbl, "field 'ctbl'", CollapsingToolbarLayout.class);
    target.abl = Utils.findRequiredViewAsType(source, R.id.abl, "field 'abl'", AppBarLayout.class);
    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.srl, "field 'srl'", SmartRefreshLayout.class);
    target.iv_blur = Utils.findRequiredViewAsType(source, R.id.iv_blur, "field 'iv_blur'", ImageView.class);
    target.rl_user_info = Utils.findRequiredViewAsType(source, R.id.rl_user_info, "field 'rl_user_info'", RelativeLayout.class);
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.tv_user_name = Utils.findRequiredViewAsType(source, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
    target.tv_user_id = Utils.findRequiredViewAsType(source, R.id.tv_user_id, "field 'tv_user_id'", TextView.class);
    target.tv_user_coin = Utils.findRequiredViewAsType(source, R.id.tv_user_coin, "field 'tv_user_coin'", TextView.class);
    target.tv_user_ranking = Utils.findRequiredViewAsType(source, R.id.tv_user_ranking, "field 'tv_user_ranking'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserPageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.msv = null;
    target.cl = null;
    target.ctbl = null;
    target.abl = null;
    target.abc = null;
    target.srl = null;
    target.iv_blur = null;
    target.rl_user_info = null;
    target.rv = null;
    target.tv_user_name = null;
    target.tv_user_id = null;
    target.tv_user_coin = null;
    target.tv_user_ranking = null;
  }
}
