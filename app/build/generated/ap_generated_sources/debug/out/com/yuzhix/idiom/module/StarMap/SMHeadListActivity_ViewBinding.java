// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMHeadListActivity_ViewBinding implements Unbinder {
  private SMHeadListActivity target;

  @UiThread
  public SMHeadListActivity_ViewBinding(SMHeadListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMHeadListActivity_ViewBinding(SMHeadListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_head_list_list, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMHeadListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
