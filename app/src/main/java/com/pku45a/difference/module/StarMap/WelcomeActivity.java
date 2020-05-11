package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import cn.jpush.sms.SMSSDK;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import per.goweii.basic.ui.toast.ToastMaker;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;

public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.sm_welcome_top_text)
    TextView topTextView;

    @BindView(R.id.sm_welcome_button_login)
    Button buttonLogin;

    @BindView(R.id.sm_welcome_button_register)
    Button buttonRegister;

    public static void start(Context context) {
        Intent intent = new Intent(context, WelcomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Config.FIRST_LAUNCH) {
            Config.FIRST_LAUNCH = false;
            SMSSDK.getInstance().initSdk(this);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_welcome;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        SpannableString spanString = new SpannableString("用户协议、隐私条款");
        spanString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "用户协议");
                intent.putExtra("url", "https://jysios.com/index.php");
                getContext().startActivity(intent);
            }
        }, 0, spanString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        topTextView.setText("登录或创建账号即代表同意");
        topTextView.append(spanString);
        topTextView.setMovementMethod(LinkMovementMethod.getInstance());//开始响应点击事件
        //
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMLoginActivity.start(getContext());
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMCreateAccountActivity.start(getContext());
            }
        });

        if(getIntent() != null) {
            if(getIntent().getBooleanExtra("register", false)) {
                ToastMaker.showShort("注册成功，请登录");
            }
            else if(getIntent().getBooleanExtra("resetPassword", false)) {
                ToastMaker.showShort("重置密码成功，请重新登录");
            }
        }
    }

    @Override
    protected void loadData() {

    }
}
