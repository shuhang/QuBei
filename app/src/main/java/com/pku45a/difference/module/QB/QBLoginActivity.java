package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.QB.Modal.QBCodeResponse;
import com.pku45a.difference.module.QB.Modal.QBLoginResponse;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.SMWebActivity;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.basic.utils.timer.SecondCountDownTimer;
import per.goweii.rxhttp.request.exception.ExceptionHandle;

public class QBLoginActivity extends BaseActivity<MyPresenter> implements BaseView, SecondCountDownTimer.OnTimerTickListener, SecondCountDownTimer.OnTimerFinishListener {
    @BindView(R.id.qb_login_input_phone)
    EditText phoneEditText;

    @BindView(R.id.qb_login_input_code)
    EditText codeEditText;

    @BindView(R.id.qb_login_button_code)
    Button codeButton;

    @BindView(R.id.qb_login_text_time)
    TextView timeTextView;

    @BindView(R.id.qb_login_layout_agree)
    RelativeLayout agreeLayout;

    @BindView(R.id.qb_login_text_agreement)
    TextView agreeTextView;

    @BindView(R.id.qb_login_image_agree)
    ImageView agreeImageView;

    @BindView(R.id.qb_login_button_add)
    Button addButton;

    @BindView(R.id.qb_login_action_bar)
    ActionBarCommon actionBarCommon;

    private boolean agreed = true;
    private SecondCountDownTimer timer;
    private String serverCode = "";

    public static void start(Context context) {
        Intent intent = new Intent(context, QBLoginActivity.class);
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
        return R.layout.qb_login;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCode();
            }
        });

        agreeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agreed) {
                    agreeImageView.setImageResource(R.drawable.corner_bg_solid_6);
                }
                else {
                    agreeImageView.setImageResource(R.mipmap.qb_check_blue);
                }
                agreed = !agreed;
            }
        });

        SpannableString style = new SpannableString("我已阅读并同意用户协议和隐私政策");
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#185CEE")), 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#185CEE")), 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "用户协议");
//                intent.putExtra("url", "https://ads.qunzhu.me/qubei/#/user");
                intent.putExtra("url", "https://ads.qunzhu.me/qb/user");
                getContext().startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ds.linkColor);
                ds.setUnderlineText(false);
            }
        }, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "隐私政策");
                intent.putExtra("url", "https://ads.qunzhu.me/qubei/#/Privacy");
                getContext().startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ds.linkColor);
                ds.setUnderlineText(false);
            }
        }, 12, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        agreeTextView.setText(style);
        agreeTextView.setMovementMethod(LinkMovementMethod.getInstance());//开始响应点击事件

        addButton.setEnabled(false);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAdd();
            }
        });

        if(getIntent().getBooleanExtra("main", false)) {
            actionBarCommon.setVisibility(View.GONE);
        }
    }

    @Override
    protected void loadData() {

    }

    private void sendCode() {
        if(phoneEditText.getText().toString().length() != 11) {
            ToastMaker.showShort("请输入正确的手机号", getContext());
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().qbGetCode(Tool.User_Id, phoneEditText.getText().toString()), true, "new_year/web/index.php?r=api/qubei/ask_phone_verification", QBCodeResponse.class, new RequestListener<QBCodeResponse>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, QBCodeResponse data) {
                serverCode = data.getVerification_code();
                ToastMaker.showShort("已发送", getContext());
                sendCodeSuccess();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg, getContext());
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }

    private void sendCodeSuccess() {
        codeButton.setVisibility(View.GONE);
        timeTextView.setVisibility(View.VISIBLE);
        startTimer();

        addButton.setBackgroundResource(R.mipmap.qb_blue_button_bg);
        addButton.setEnabled(true);
    }

    private void clickAdd() {
        if(phoneEditText.getText().toString().length() != 11) {
            ToastMaker.showShort("请输入正确的手机号", getContext());
            return;
        }

        if(codeEditText.getText().toString().length() == 0) {
            ToastMaker.showShort("请输入验证码", getContext());
            return;
        }

        if(!codeEditText.getText().toString().equals(serverCode)) {
            ToastMaker.showShort("请输入验证码", getContext());
            return;
        }

        if(!agreed) {
            ToastMaker.showShort("请同意用户协议和隐私政策", getContext());
            return;
        }

        if(timer != null) {
            timer.cancel();
        }

        login(phoneEditText.getText().toString(), codeEditText.getText().toString());
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

    private void login(String phone, String code) {
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().qbLogin(Tool.User_Id, phone), true, "new_year/web/index.php?r=api/qubei/phone_login", QBLoginResponse.class, new RequestListener<QBLoginResponse>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, QBLoginResponse data) {
                Tool.User_Id = data.getUser_info().getUser_id();
                SharedPreferences sp = getContext().getSharedPreferences("QB", Context.MODE_PRIVATE);
                sp.edit().putString("user_id", Tool.User_Id).commit();
                Tool.Vip = data.getUser_info().isIs_vip();
                sp.edit().putBoolean("vip", Tool.Vip).commit();
                if(Tool.Vip) {
                    sp.edit().putLong("vip_time", data.getUser_info().getVip_end_time() * 1000).commit();
                }
                sp.edit().putString("user_name", data.getUser_info().getNick_name()).commit();
                sp.edit().putString("phone", data.getUser_info().getPhone()).commit();

                QBMainActivity.start(getContext());
                setResult(101);
                finish();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg, getContext());
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }
}
