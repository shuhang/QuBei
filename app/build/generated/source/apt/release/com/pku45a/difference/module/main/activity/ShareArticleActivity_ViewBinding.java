// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.main.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.WebContainer;
import java.lang.IllegalStateException;
import java.lang.Override;
import per.goweii.actionbarex.common.ActionBarCommon;

public class ShareArticleActivity_ViewBinding implements Unbinder {
  private ShareArticleActivity target;

  private View view2131231593;

  private View view2131231598;

  @UiThread
  public ShareArticleActivity_ViewBinding(ShareArticleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShareArticleActivity_ViewBinding(final ShareArticleActivity target, View source) {
    this.target = target;

    View view;
    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.wc = Utils.findRequiredViewAsType(source, R.id.wc, "field 'wc'", WebContainer.class);
    target.et_title = Utils.findRequiredViewAsType(source, R.id.et_title, "field 'et_title'", EditText.class);
    target.et_link = Utils.findRequiredViewAsType(source, R.id.et_link, "field 'et_link'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_open, "method 'onClick'");
    view2131231593 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_refresh, "method 'onClick'");
    view2131231598 = view;
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
    ShareArticleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abc = null;
    target.wc = null;
    target.et_title = null;
    target.et_link = null;

    view2131231593.setOnClickListener(null);
    view2131231593 = null;
    view2131231598.setOnClickListener(null);
    view2131231598 = null;
  }
}
