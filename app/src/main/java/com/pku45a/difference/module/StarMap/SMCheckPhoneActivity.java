package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import butterknife.BindView;
import cn.jpush.sms.SMSSDK;
import cn.jpush.sms.listener.SmscheckListener;
import cn.jpush.sms.listener.SmscodeListener;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.basic.utils.timer.SecondCountDownTimer;
import com.pku45a.difference.R;

import com.pku45a.difference.widget.InputView;

public class SMCheckPhoneActivity extends BaseActivity<MyPresenter> implements BaseView, SecondCountDownTimer.OnTimerTickListener, SecondCountDownTimer.OnTimerFinishListener {
    @BindView(R.id.sm_check_phone_top_text)
    TextView topTextView;

    @BindView(R.id.sm_check_phone_text_time)
    TextView timeTextView;

    @BindView(R.id.sm_check_phone_input_code)
    InputView codeInputView;

    @BindView(R.id.sm_check_phone_input_image)
    ImageView imageView;

    @BindView(R.id.sm_check_phone_button_get_code)
    Button codeButton;

    @BindView(R.id.sm_check_phone_button_check)
    Button checkButton;

    private SecondCountDownTimer timer;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMCheckPhoneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(timer != null) {
            timer.cancel();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_check_phone;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        SpannableStringBuilder style = new SpannableStringBuilder("请输入手机号" + getIntent().getStringExtra("phone") + "收到的验证码");
        style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.sm_blue)), 6, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.BLACK), 17, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        topTextView.setText(style);
        //
        codeInputView.getEditText().setHint("验证码");
        codeInputView.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
        codeInputView.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        //
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCode();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judgeCode();
            }
        });

        checkButton.setBackgroundResource(R.drawable.corner_bg_gray_25);
        checkButton.setEnabled(false);
    }

    @Override
    protected void loadData() {

    }


    public void onTick(long secondUntilFinished) {
        timeTextView.setText("剩余" + secondUntilFinished + "秒");
    }

    public void onFinish() {
        codeButton.setVisibility(View.VISIBLE);
        timeTextView.setVisibility(View.GONE);
    }

    private void startTimer() {
        timer = new SecondCountDownTimer(60, 1);
        timer.setOnTimerTickListener(this);
        timer.setOnTimerFinishListener(this);
        timer.start();
    }

    private void showHasSendCode() {
        checkButton.setBackgroundResource(R.drawable.corner_bg_blue_25);
        checkButton.setEnabled(true);
        codeButton.setVisibility(View.GONE);
        timeTextView.setVisibility(View.VISIBLE);
        startTimer();
    }

    private void judgeCode() {
        if(codeInputView.getText().length() == 0) {
            ToastMaker.showShort("请输入验证码");
            return;
        }
        showLoadingDialog();
        SMSSDK.getInstance().checkSmsCodeAsyn(getIntent().getStringExtra("phone"), codeInputView.getText(), new SmscheckListener() {
            @Override
            public void checkCodeSuccess(final String code) {
                dismissLoadingDialog();
                Intent intent = new Intent(getContext(), SMSetPasswordActivity.class);
                intent.putExtra("phone", getIntent().getStringExtra("phone"));
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("type", getIntent().getStringExtra("type"));
                getContext().startActivity(intent);
                finish();
            }

            @Override
            public void checkCodeFail(int errCode, final String errMsg) {
                dismissLoadingDialog();
                ToastMaker.showShort(errMsg);
            }
        });
    }

    private void sendCode() {
        showLoadingDialog();
        SMSSDK.getInstance().getSmsCodeAsyn(getIntent().getStringExtra("phone"), "1", new SmscodeListener() {
            @Override
            public void getCodeSuccess(final String uuid) {
                dismissLoadingDialog();
                ToastMaker.showShort("发送验证码成功");
                showHasSendCode();
            }

            @Override
            public void getCodeFail(int errCode, final String errMsg) {
                dismissLoadingDialog();
                ToastMaker.showShort(errMsg);
            }
        });
    }
}
