package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

import com.pku45a.difference.widget.InputView;

public class SMCreateAccountActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_create_account_top_text)
    TextView topTextView;

    @BindView(R.id.sm_create_account_input_name)
    InputView nameInputView;

    @BindView(R.id.sm_create_account_input_phone)
    InputView phoneInputView;

    @BindView(R.id.sm_create_account_button_get_code)
    Button codeButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMCreateAccountActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_create_account;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
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
        nameInputView.getEditText().setHint("用户名");
        nameInputView.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
        phoneInputView.getEditText().setHint("手机号");
        phoneInputView.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
        //
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judgeUserName();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void judgeUserName() {
        if(nameInputView.getText().length() == 0) {
            ToastMaker.showShort("请输入用户名");
            return;
        }
        if(phoneInputView.getText().length() == 0) {
            ToastMaker.showShort("请输入手机号");
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smCheckUserName(nameInputView.getText()), true, "user/checkName", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                judgePhone();
            }

            @Override
            public void onFailed(int code, String msg) {
                dismissLoadingDialog();
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
                dismissLoadingDialog();
                ToastMaker.showShort(Config.Common_NetWork_Error);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    private void judgePhone() {
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smCheckPhone(phoneInputView.getText()), true, "user/checkPhone", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                Intent intent = new Intent(getContext(), SMCheckPhoneActivity.class);
                intent.putExtra("phone", phoneInputView.getText());
                intent.putExtra("name", nameInputView.getText());
                intent.putExtra("type", "register");
                getContext().startActivity(intent);
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
}
