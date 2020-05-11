// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.home.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchHistoryFragment_ViewBinding implements Unbinder {
  private SearchHistoryFragment target;

  private View view2131231546;

  private View view2131231561;

  @UiThread
  public SearchHistoryFragment_ViewBinding(final SearchHistoryFragment target, View source) {
    this.target = target;

    View view;
    target.rv_hot = Utils.findRequiredViewAsType(source, R.id.rv_hot, "field 'rv_hot'", RecyclerView.class);
    target.ll_history = Utils.findRequiredViewAsType(source, R.id.ll_history, "field 'll_history'", LinearLayout.class);
    target.rv_history = Utils.findRequiredViewAsType(source, R.id.rv_history, "field 'rv_history'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_clean, "field 'tv_clean' and method 'onClick'");
    target.tv_clean = Utils.castView(view, R.id.tv_clean, "field 'tv_clean'", TextView.class);
    view2131231546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_down, "field 'tv_down' and method 'onClick'");
    target.tv_down = Utils.castView(view, R.id.tv_down, "field 'tv_down'", TextView.class);
    view2131231561 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchHistoryFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_hot = null;
    target.ll_history = null;
    target.rv_history = null;
    target.tv_clean = null;
    target.tv_down = null;

    view2131231546.setOnClickListener(null);
    view2131231546 = null;
    view2131231561.setOnClickListener(null);
    view2131231561 = null;
  }
}
