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

public class SMMessageActivityListActivity_ViewBinding implements Unbinder {
  private SMMessageActivityListActivity target;

  @UiThread
  public SMMessageActivityListActivity_ViewBinding(SMMessageActivityListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMMessageActivityListActivity_ViewBinding(SMMessageActivityListActivity target,
      View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_message_activity_list_list, "field 'listView'", RecyclerView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.sm_message_activity_list_srl, "field 'srl'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMessageActivityListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.srl = null;
  }
}
