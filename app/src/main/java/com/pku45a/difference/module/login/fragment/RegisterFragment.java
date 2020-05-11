package com.pku45a.difference.module.login.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.pku45a.difference.module.login.activity.LoginActivity;
import com.pku45a.difference.module.login.model.LoginBean;
import com.pku45a.difference.module.login.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import per.goweii.basic.core.base.BaseFragment;
import per.goweii.basic.ui.toast.ToastMaker;
import com.pku45a.difference.R;
import com.pku45a.difference.event.LoginEvent;
import com.pku45a.difference.module.login.view.RegisterView;
import com.pku45a.difference.utils.KeyboardHelper;
import com.pku45a.difference.widget.InputView;
import com.pku45a.difference.widget.SubmitView;

/**
 * @author CuiZhen
 * @date 2019/5/16
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class RegisterFragment extends BaseFragment<RegisterPresenter> implements RegisterView {

    @BindView(R.id.ll_go_login)
    LinearLayout ll_go_login;
    @BindView(R.id.piv_register_account)
    InputView piv_account;
    @BindView(R.id.piv_register_password)
    InputView piv_password;
    @BindView(R.id.piv_register_password_again)
    InputView piv_password_again;
    @BindView(R.id.sv_register)
    SubmitView sv_register;

    private KeyboardHelper mKeyboardHelper;
    private LoginActivity mActivity;

    public static RegisterFragment create(){
        return new RegisterFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_register;
    }

    @Nullable
    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity) context;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void loadData() {
    }

    @Override
    public void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        mKeyboardHelper = KeyboardHelper.attach(mActivity)
                .init(mActivity.getRl_input(), sv_register, piv_account.getEditText(), piv_password.getEditText(), piv_password_again.getEditText())
                .moveWithTranslation();
    }

    @Override
    public void onInvisible() {
        super.onInvisible();
        if (mKeyboardHelper != null) {
            mKeyboardHelper.detach();
            mKeyboardHelper = null;
        }
    }

    @Override
    public void onDestroyView() {
        if (mKeyboardHelper != null) {
            mKeyboardHelper.detach();
            mKeyboardHelper = null;
        }
        super.onDestroyView();
    }

    @OnClick({R.id.ll_go_login, R.id.sv_register})
    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected boolean onClick1(View v) {
        switch (v.getId()) {
            default:
                return false;
            case R.id.ll_go_login:
                mActivity.changeToLogin();
                break;
            case R.id.sv_register:
                String userName = piv_account.getText();
                String password = piv_password.getText();
                String repassword = piv_password_again.getText();
                presenter.register(userName, password, repassword);
                break;
        }
        return true;
    }

    @Override
    public void registerSuccess(int code, LoginBean data) {
        new LoginEvent(true).post();
        finish();
    }

    @Override
    public void registerFailed(int code, String msg) {
        ToastMaker.showShort(msg);
    }
}
