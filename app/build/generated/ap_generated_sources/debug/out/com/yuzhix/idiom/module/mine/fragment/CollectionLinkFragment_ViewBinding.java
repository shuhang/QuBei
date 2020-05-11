// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.mine.fragment;

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

public class CollectionLinkFragment_ViewBinding implements Unbinder {
  private CollectionLinkFragment target;

  @UiThread
  public CollectionLinkFragment_ViewBinding(CollectionLinkFragment target, View source) {
    this.target = target;

    target.msv = Utils.findRequiredViewAsType(source, R.id.msv, "field 'msv'", MultiStateView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.srl, "field 'srl'", SmartRefreshLayout.class);
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CollectionLinkFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.msv = null;
    target.srl = null;
    target.rv = null;
  }
}
