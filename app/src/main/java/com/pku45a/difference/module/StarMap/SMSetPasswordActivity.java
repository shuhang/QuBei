package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.widget.InputView;

public class SMSetPasswordActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_set_password_text_top)
    TextView topTextView;

    @BindView(R.id.sm_set_password_button_register)
    Button buttonRegister;

    @BindView(R.id.sm_set_password_input_password1)
    InputView passwordInputView1;

    @BindView(R.id.sm_set_password_input_password2)
    InputView passwordInputView2;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMSetPasswordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_set_password;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        passwordInputView1.getEditText().setHint("请输入密码");
        passwordInputView1.getEditText().setTransformationMethod(PasswordTransformationMethod.getInstance());

        passwordInputView2.getEditText().setHint("请确认密码");
        passwordInputView2.getEditText().setTransformationMethod(PasswordTransformationMethod.getInstance());

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getIntent().getStringExtra("name").equals("register")) {
                    register();
                }
                else if(getIntent().getStringExtra("name").equals("resetPassword")) {
                    resetPassword();
                }
                else {
                    changePassword();
                }
            }
        });

        if(getIntent().getStringExtra("name").equals("register")) {
            buttonRegister.setText("注册");
        }
        else if(getIntent().getStringExtra("name").equals("resetPassword")) {
            buttonRegister.setText("重置密码");
            topTextView.setText("重置密码");
        }
        else {
            buttonRegister.setText("修改密码");
            topTextView.setText("修改密码");
            passwordInputView1.getEditText().setHint("请输入旧密码");
            passwordInputView2.getEditText().setHint("请输入新密码");
        }
    }

    @Override
    protected void loadData() {

    }

    private void resetPassword() {
        if(passwordInputView1.getText().length() == 0) {
            ToastMaker.showShort("请输入密码");
            return;
        }
        if(passwordInputView1.getText().length() < 6 || passwordInputView1.getText().length() > 18) {
            ToastMaker.showShort("密码6~18位");
            return;
        }
        if(!passwordInputView1.getText().equals(passwordInputView2.getText())) {
            ToastMaker.showShort("两次密码输入不一致");
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smResetPassword(getIntent().getStringExtra("phone"), passwordInputView1.getText()), true, "user/findPwd", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                setSuccess();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error);
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }

    private void changePassword() {
        if(passwordInputView1.getText().length() < 6 || passwordInputView1.getText().length() > 18) {
            ToastMaker.showShort("旧密码6~18位");
            return;
        }
        if(passwordInputView2.getText().length() < 6 || passwordInputView2.getText().length() > 18) {
            ToastMaker.showShort("新密码6~18位");
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smModifyPassword(Config.userEntity.getUser_id(), getIntent().getStringExtra("phone"), passwordInputView1.getText(), passwordInputView1.getText()), true, "user/findPwd", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                ToastMaker.showShort("修改成功");
                finish();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error);
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }

    private void register() {
        if(passwordInputView1.getText().length() == 0) {
            ToastMaker.showShort("请输入密码");
            return;
        }
        if(passwordInputView1.getText().length() < 6 || passwordInputView1.getText().length() > 18) {
            ToastMaker.showShort("密码6~18位");
            return;
        }
        if(!passwordInputView1.getText().equals(passwordInputView2.getText())) {
            ToastMaker.showShort("两次密码输入不一致");
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smRegister(getIntent().getStringExtra("name"), getIntent().getStringExtra("phone"), passwordInputView1.getText()), true, "user/regist", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                setSuccess();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error);
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }

    private void setSuccess() {
        Intent intent= new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(getIntent().getStringExtra("type"), true);
        startActivity(intent);
    }
}
