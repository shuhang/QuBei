// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.mine.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kennyc.view.MultiStateView;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class CoinActivity_ViewBinding implements Unbinder {
  private CoinActivity target;

  @UiThread
  public CoinActivity_ViewBinding(CoinActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CoinActivity_ViewBinding(CoinActivity target, View source) {
    this.target = target;

    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.tv_coin = Utils.findRequiredViewAsType(source, R.id.tv_coin, "field 'tv_coin'", TextView.class);
    target.msv = Utils.findRequiredViewAsType(source, R.id.msv, "field 'msv'", MultiStateView.class);
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CoinActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abc = null;
    target.tv_coin = null;
    target.msv = null;
    target.rv = null;
  }
}
