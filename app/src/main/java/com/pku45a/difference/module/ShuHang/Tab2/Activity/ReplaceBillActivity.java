package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.pku45a.difference.module.ShuHang.View.SignPopView;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import com.pku45a.difference.R;

public class ReplaceBillActivity extends BaseActivity {
    @BindView(R.id.replace_bill_confirm)
    Button confirmButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, ReplaceBillActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.replace_bill;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView(R.layout.replace_bill_success);
                SignPopView.with(getContext()).show();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
