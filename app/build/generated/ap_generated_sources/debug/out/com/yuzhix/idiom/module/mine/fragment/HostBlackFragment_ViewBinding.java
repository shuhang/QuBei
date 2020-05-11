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

public class HostBlackFragment_ViewBinding implements Unbinder {
  private HostBlackFragment target;

  @UiThread
  public HostBlackFragment_ViewBinding(HostBlackFragment target, View source) {
    this.target = target;

    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HostBlackFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
  }
}
