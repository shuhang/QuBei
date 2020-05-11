// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMFocusUserListActivity_ViewBinding implements Unbinder {
  private SMFocusUserListActivity target;

  @UiThread
  public SMFocusUserListActivity_ViewBinding(SMFocusUserListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMFocusUserListActivity_ViewBinding(SMFocusUserListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_focus_user_list_list, "field 'listView'", RecyclerView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.sm_focus_user_list_srl, "field 'srl'", SmartRefreshLayout.class);
    target.symbolView = Utils.findRequiredView(source, R.id.sm_focus_user_list_top_symbol, "field 'symbolView'");
    target.leftTextView = Utils.findRequiredViewAsType(source, R.id.sm_focus_user_list_top_text_left, "field 'leftTextView'", TextView.class);
    target.rightTextView = Utils.findRequiredViewAsType(source, R.id.sm_focus_user_list_top_text_right, "field 'rightTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMFocusUserListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.srl = null;
    target.symbolView = null;
    target.leftTextView = null;
    target.rightTextView = null;
  }
}
