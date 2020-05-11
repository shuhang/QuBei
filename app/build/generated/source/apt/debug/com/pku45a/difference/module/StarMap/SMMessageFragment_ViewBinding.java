// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMessageFragment_ViewBinding implements Unbinder {
  private SMMessageFragment target;

  @UiThread
  public SMMessageFragment_ViewBinding(SMMessageFragment target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.sm_message_list, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMessageFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
