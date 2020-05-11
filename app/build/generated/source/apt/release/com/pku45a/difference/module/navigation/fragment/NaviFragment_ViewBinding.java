// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.navigation.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kennyc.view.MultiStateView;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NaviFragment_ViewBinding implements Unbinder {
  private NaviFragment target;

  @UiThread
  public NaviFragment_ViewBinding(NaviFragment target, View source) {
    this.target = target;

    target.msv = Utils.findRequiredViewAsType(source, R.id.msv, "field 'msv'", MultiStateView.class);
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NaviFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.msv = null;
    target.rv = null;
  }
}
