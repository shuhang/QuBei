package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;

public class MyHomeActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.home_page_mine_get_money)
    Button getMoneyButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, MyHomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_page_mine;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        getMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getNetwork();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void getNetwork() {
        showLoadingDialog();
        BaseRequest.cacheAndNetList(presenter.getRxLife(),
                WanApi.api().getHomeList(10006, 1, 2),
                true,
                "api/user/getAll",
                HomeEntity.class,
                new RequestListener<List<HomeEntity>>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int code, List<HomeEntity> data) {
                        Log.i("", "");
                    }

                    @Override
                    public void onFailed(int code, String msg) {

                    }

                    @Override
                    public void onError(ExceptionHandle handle) {

                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
