package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import per.goweii.basic.ui.toast.ToastMaker;
import com.pku45a.difference.R;
import com.pku45a.difference.widget.InputView;

public class SMForgetPasswordActivity extends BaseActivity {
    @BindView(R.id.sm_forget_password_input_phone)
    InputView phoneInputView;

    @BindView(R.id.sm_forget_password_button_get_code)
    Button buttonGetCode;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMForgetPasswordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_forget_password;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        phoneInputView.getEditText().setHint("手机号");
        phoneInputView.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);

        buttonGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judgePhone();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void judgePhone() {
        if(phoneInputView.getText().length() != 11) {
            ToastMaker.showShort("请输入正确的手机号");
            return;
        }
        Intent intent = new Intent(getContext(), SMCheckPhoneActivity.class);
        intent.putExtra("name", "");
        intent.putExtra("phone", phoneInputView.getText());
        intent.putExtra("type", "resetPassword");
        getContext().startActivity(intent);
    }
}
