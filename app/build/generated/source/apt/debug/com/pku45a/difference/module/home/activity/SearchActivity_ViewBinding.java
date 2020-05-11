// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.home.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarSearch;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target, View source) {
    this.target = target;

    target.abs = Utils.findRequiredViewAsType(source, R.id.abs, "field 'abs'", ActionBarSearch.class);
    target.fl = Utils.findRequiredViewAsType(source, R.id.fl, "field 'fl'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abs = null;
    target.fl = null;
  }
}
