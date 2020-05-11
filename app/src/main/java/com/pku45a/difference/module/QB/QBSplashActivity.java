package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.pku45a.difference.R;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.SMStartActivity;

import java.util.Date;

import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;

public class QBSplashActivity extends BaseActivity<MyPresenter> implements BaseView {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            SharedPreferences sp = getContext().getSharedPreferences("QB", Context.MODE_PRIVATE);
            if(!sp.contains("install")) {
                sp.edit().putBoolean("install", true).commit();
                Tool.User_Id = Tool.getUUID(getContext());

                Intent intent= new Intent(getContext(), SMStartActivity.class);
                startActivity(intent);
            }
            else {
                if(!sp.contains("user_id")) {
                    Tool.User_Id = Tool.getUUID(getContext());

                    Intent intent= new Intent(getContext(), QBLoginActivity.class);
                    intent.putExtra("main", true);
                    startActivity(intent);
                }
                else {
                    Tool.User_Id = sp.getString("user_id", "");
                    Tool.Vip = sp.getBoolean("vip", false);
                    if(Tool.Vip) {
                        long vipTime = sp.getLong("vip_time", 0);
                        Date date = new Date();
                        if(vipTime <= date.getTime()) {
                            Tool.Vip = false;
                            sp.edit().putBoolean("vip", false).commit();
                        }
                    }
                    Tool.User_Name = sp.getString("user_name","");
                    Tool.Phone = sp.getString("phone","");
                    Intent intent= new Intent(getContext(), QBMainActivity.class);
                    startActivity(intent);
                }
            }
            finish();
        }
    };

    public static void start(Context context) {
        Intent intent = new Intent(context, QBSplashActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_splash;
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

    private void go() {

    }
}
