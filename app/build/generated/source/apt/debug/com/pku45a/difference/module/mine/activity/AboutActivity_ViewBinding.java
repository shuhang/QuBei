// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.mine.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding implements Unbinder {
  private AboutActivity target;

  private View view2131231094;

  private View view2131231052;

  private View view2131231067;

  @UiThread
  public AboutActivity_ViewBinding(AboutActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutActivity_ViewBinding(final AboutActivity target, View source) {
    this.target = target;

    View view;
    target.tv_version_name = Utils.findRequiredViewAsType(source, R.id.tv_version_name, "field 'tv_version_name'", TextView.class);
    target.tv_web = Utils.findRequiredViewAsType(source, R.id.tv_web, "field 'tv_web'", TextView.class);
    target.tv_about = Utils.findRequiredViewAsType(source, R.id.tv_about, "field 'tv_about'", TextView.class);
    target.tv_github = Utils.findRequiredViewAsType(source, R.id.tv_github, "field 'tv_github'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_web, "method 'onClick'");
    view2131231094 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_about, "method 'onClick'");
    view2131231052 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_github, "method 'onClick'");
    view2131231067 = view;
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
    AboutActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_version_name = null;
    target.tv_web = null;
    target.tv_about = null;
    target.tv_github = null;

    view2131231094.setOnClickListener(null);
    view2131231094 = null;
    view2131231052.setOnClickListener(null);
    view2131231052 = null;
    view2131231067.setOnClickListener(null);
    view2131231067 = null;
  }
}
