// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.mine.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Chunjie1Activity_ViewBinding implements Unbinder {
  private Chunjie1Activity target;

  @UiThread
  public Chunjie1Activity_ViewBinding(Chunjie1Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Chunjie1Activity_ViewBinding(Chunjie1Activity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.get_money_record_list, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Chunjie1Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
