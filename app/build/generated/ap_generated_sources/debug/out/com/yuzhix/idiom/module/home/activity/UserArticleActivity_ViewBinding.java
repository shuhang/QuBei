// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.home.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kennyc.view.MultiStateView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class UserArticleActivity_ViewBinding implements Unbinder {
  private UserArticleActivity target;

  @UiThread
  public UserArticleActivity_ViewBinding(UserArticleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserArticleActivity_ViewBinding(UserArticleActivity target, View source) {
    this.target = target;

    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.msv = Utils.findRequiredViewAsType(source, R.id.msv, "field 'msv'", MultiStateView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.srl, "field 'srl'", SmartRefreshLayout.class);
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserArticleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abc = null;
    target.msv = null;
    target.srl = null;
    target.rv = null;
  }
}
