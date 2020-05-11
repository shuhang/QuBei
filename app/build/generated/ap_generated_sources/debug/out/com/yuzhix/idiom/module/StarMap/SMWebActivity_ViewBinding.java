// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class SMWebActivity_ViewBinding implements Unbinder {
  private SMWebActivity target;

  @UiThread
  public SMWebActivity_ViewBinding(SMWebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SMWebActivity_ViewBinding(SMWebActivity target, View source) {
    this.target = target;

    target.webView = Utils.findRequiredViewAsType(source, R.id.sm_webview_webview, "field 'webView'", WebView.class);
    target.actionBarCommon = Utils.findRequiredViewAsType(source, R.id.abc, "field 'actionBarCommon'", ActionBarCommon.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SMWebActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webView = null;
    target.actionBarCommon = null;
  }
}
