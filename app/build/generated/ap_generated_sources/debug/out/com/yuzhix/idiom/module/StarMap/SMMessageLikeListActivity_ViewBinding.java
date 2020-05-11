// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMessageLikeListActivity_ViewBinding implements Unbinder {
  private SMMessageLikeListActivity target;

  @UiThread
  public SMMessageLikeListActivity_ViewBinding(SMMessageLikeListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMMessageLikeListActivity_ViewBinding(SMMessageLikeListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_message_like_list_list, "field 'listView'", RecyclerView.class);
    target.srl = Utils.findRequiredViewAsType(source, R.id.sm_message_like_list_srl, "field 'srl'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMessageLikeListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.srl = null;
  }
}
