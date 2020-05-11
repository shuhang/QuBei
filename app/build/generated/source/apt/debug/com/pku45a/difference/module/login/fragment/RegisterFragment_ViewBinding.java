// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.login.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.InputView;
import com.pku45a.difference.widget.SubmitView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterFragment_ViewBinding implements Unbinder {
  private RegisterFragment target;

  private View view2131231068;

  private View view2131231501;

  @UiThread
  public RegisterFragment_ViewBinding(final RegisterFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ll_go_login, "field 'll_go_login' and method 'onClick'");
    target.ll_go_login = Utils.castView(view, R.id.ll_go_login, "field 'll_go_login'", LinearLayout.class);
    view2131231068 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.piv_account = Utils.findRequiredViewAsType(source, R.id.piv_register_account, "field 'piv_account'", InputView.class);
    target.piv_password = Utils.findRequiredViewAsType(source, R.id.piv_register_password, "field 'piv_password'", InputView.class);
    target.piv_password_again = Utils.findRequiredViewAsType(source, R.id.piv_register_password_again, "field 'piv_password_again'", InputView.class);
    view = Utils.findRequiredView(source, R.id.sv_register, "field 'sv_register' and method 'onClick'");
    target.sv_register = Utils.castView(view, R.id.sv_register, "field 'sv_register'", SubmitView.class);
    view2131231501 = view;
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
    RegisterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_go_login = null;
    target.piv_account = null;
    target.piv_password = null;
    target.piv_password_again = null;
    target.sv_register = null;

    view2131231068.setOnClickListener(null);
    view2131231068 = null;
    view2131231501.setOnClickListener(null);
    view2131231501 = null;
  }
}
