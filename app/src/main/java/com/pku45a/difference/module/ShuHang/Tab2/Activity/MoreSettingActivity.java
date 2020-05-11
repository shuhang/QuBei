package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import per.goweii.basic.ui.dialog.LoadingDialog;
import com.pku45a.difference.R;

public class MoreSettingActivity extends BaseActivity {
    @BindView(R.id.more_setting_rule)
    RelativeLayout ruleLayout;

    @BindView(R.id.more_setting_feedback)
    RelativeLayout feedbackLayout;

    @BindView(R.id.more_setting_privacy)
    RelativeLayout privacyLayout;

    @BindView(R.id.more_setting_update)
    RelativeLayout updateLayout;

    @BindView(R.id.more_setting_online)
    RelativeLayout onlineLayout;

    private Handler mHandler = null;
    private LoadingDialog dialog = null;

    public static void start(Context context) {
        Intent intent = new Intent(context, MoreSettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.more_setting;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        dialog.dismiss();
                }
            }
        };

        ruleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        feedbackLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackActivity.start(getContext());
            }
        });
        privacyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        updateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = LoadingDialog.with(getContext());
                dialog.show();

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(0);
                    }
                }, 3000);
            }
        });
        onlineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void loadData() {

    }
}
