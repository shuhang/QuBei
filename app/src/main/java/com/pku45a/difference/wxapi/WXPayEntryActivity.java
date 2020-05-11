package com.pku45a.difference.wxapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import java.util.Date;

import per.goweii.basic.core.base.BaseActivity;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
    public static final String ACTION = "xyh.net.rrbus.weixin.wxapi.intent.action.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        api = WXAPIFactory.createWXAPI(this, Config.WX_APPID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_login;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onResp(BaseResp resp) {
        int code = resp.errCode;
        switch (code) {
            case 0://支付成功后的界面
                Tool.PayResult = true;
                Tool.Vip = true;
                SharedPreferences sp = getContext().getSharedPreferences("QB", Context.MODE_PRIVATE);
                Date date = new Date();
                long vipTime = date.getTime();
                vipTime = vipTime + (long)(Tool.Vip_Days * (long)24 * (long)3600 * (long)1000);
                sp.edit().putLong("vip_time", vipTime).commit();

                this.finish();
                break;
            case -1:
            case -2://用户取消支付后的界面
                Tool.PayResult = false;
                this.finish();
                break;
        }
    }
}