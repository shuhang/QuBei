// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMessageSystemListActivity_ViewBinding implements Unbinder {
  private SMMessageSystemListActivity target;

  @UiThread
  public SMMessageSystemListActivity_ViewBinding(SMMessageSystemListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMMessageSystemListActivity_ViewBinding(SMMessageSystemListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_message_system_list_list, "field 'listView'", RecyclerView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.sm_message_system_list_srl, "field 'srl'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMessageSystemListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.srl = null;
  }
}
