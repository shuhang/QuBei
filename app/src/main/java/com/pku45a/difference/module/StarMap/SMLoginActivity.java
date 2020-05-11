package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.widget.InputView;

public class SMLoginActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_login_input_name)
    InputView nameInputView;

    @BindView(R.id.sm_login_input_password)
    InputView passwordInputView;

    @BindView(R.id.sm_login_button_login)
    Button buttonLogin;

    @BindView(R.id.sm_login_button_register)
    Button buttonRegister;

    @BindView(R.id.sm_login_button_forget_password)
    Button buttonForgetPassword;

    private IWXAPI api;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMLoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_login;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        nameInputView.getEditText().setHint("用户名/手机号");
        nameInputView.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
        passwordInputView.getEditText().setHint("请输入密码");
        passwordInputView.getEditText().setTransformationMethod(PasswordTransformationMethod.getInstance());
        //
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMCreateAccountActivity.start(getContext());
            }
        });

        buttonForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMForgetPasswordActivity.start(getContext());
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void login() {
        api = WXAPIFactory.createWXAPI(this, Config.WX_APPID);
        PayReq request = new PayReq();
        request.appId = Config.WX_APPID;
        request.partnerId = "1558786431";
        request.prepayId= "wx29141335703546ccf2f4fa1c1199871200";
        request.packageValue = "Sign=WXPay";
        request.nonceStr= "OnwWfpurxzpfnK51";
        request.timeStamp= "1588140815";
        request.sign= "E783DD34EEED4EE66185359F056F6D71";
        api.sendReq(request);
    }
}
