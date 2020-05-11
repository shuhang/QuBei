package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pku45a.difference.R;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;

public class QBServiceActivity extends BaseActivity<MyPresenter> implements BaseView {
    public static void start(Context context) {
        Intent intent = new Intent(context, QBServiceActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_service;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }
}
