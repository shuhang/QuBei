// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.login.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import com.yuzhix.idiom.widget.InputView;
import com.yuzhix.idiom.widget.SubmitView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  private View view2131231069;

  private View view2131231461;

  @UiThread
  public LoginFragment_ViewBinding(final LoginFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ll_go_register, "field 'll_go_register' and method 'onClick'");
    target.ll_go_register = Utils.castView(view, R.id.ll_go_register, "field 'll_go_register'", LinearLayout.class);
    view2131231069 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.piv_account = Utils.findRequiredViewAsType(source, R.id.piv_login_account, "field 'piv_account'", InputView.class);
    target.piv_password = Utils.findRequiredViewAsType(source, R.id.piv_login_password, "field 'piv_password'", InputView.class);
    view = Utils.findRequiredView(source, R.id.sv_login, "field 'sv_login' and method 'onClick'");
    target.sv_login = Utils.castView(view, R.id.sv_login, "field 'sv_login'", SubmitView.class);
    view2131231461 = view;
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
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_go_register = null;
    target.piv_account = null;
    target.piv_password = null;
    target.sv_login = null;

    view2131231069.setOnClickListener(null);
    view2131231069 = null;
    view2131231461.setOnClickListener(null);
    view2131231461 = null;
  }
}
