// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.main.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.WebContainer;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarSearch;

public class WebActivity_ViewBinding implements Unbinder {
  private WebActivity target;

  @UiThread
  public WebActivity_ViewBinding(WebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebActivity_ViewBinding(WebActivity target, View source) {
    this.target = target;

    target.abs = Utils.findRequiredViewAsType(source, R.id.abs, "field 'abs'", ActionBarSearch.class);
    target.wc = Utils.findRequiredViewAsType(source, R.id.wc, "field 'wc'", WebContainer.class);
    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.iv_forward = Utils.findRequiredViewAsType(source, R.id.iv_forward, "field 'iv_forward'", ImageView.class);
    target.iv_menu = Utils.findRequiredViewAsType(source, R.id.iv_menu, "field 'iv_menu'", ImageView.class);
    target.iv_refresh = Utils.findRequiredViewAsType(source, R.id.iv_refresh, "field 'iv_refresh'", ImageView.class);
    target.iv_home = Utils.findRequiredViewAsType(source, R.id.iv_home, "field 'iv_home'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abs = null;
    target.wc = null;
    target.iv_back = null;
    target.iv_forward = null;
    target.iv_menu = null;
    target.iv_refresh = null;
    target.iv_home = null;
  }
}
