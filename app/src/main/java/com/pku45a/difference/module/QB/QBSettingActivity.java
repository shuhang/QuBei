package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.pku45a.difference.R;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.SMWebActivity;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;

public class QBSettingActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_setting_privacy)
    RelativeLayout layoutPrivacy;

    @BindView(R.id.qb_setting_agreement)
    RelativeLayout layoutAgreement;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBSettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_setting;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        layoutPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "隐私政策");
                intent.putExtra("url", "https://ads.qunzhu.me/qubei/#/Privacy");
                getContext().startActivity(intent);
            }
        });

        layoutAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "用户付费协议");
                intent.putExtra("url", "https://ads.qunzhu.me/qubei/#/Pay");
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
