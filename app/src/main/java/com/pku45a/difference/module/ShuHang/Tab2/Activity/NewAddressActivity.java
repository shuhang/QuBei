package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import com.pku45a.difference.R;

public class NewAddressActivity extends BaseActivity {
    public static void start(Context context) {
        Intent intent = new Intent(context, NewAddressActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.new_address;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }
}
