// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.mine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HostWhiteFragment_ViewBinding implements Unbinder {
  private HostWhiteFragment target;

  @UiThread
  public HostWhiteFragment_ViewBinding(HostWhiteFragment target, View source) {
    this.target = target;

    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HostWhiteFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
  }
}