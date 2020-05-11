package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;

public class QBMineActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_mine_button_setting)
    Button settingButton;

    @BindView(R.id.qb_mine_unlock)
    Button unlockButton;

    @BindView(R.id.qb_mine_phone)
    TextView phoneTextView;

    @BindView(R.id.qb_mine_vip_time)
    TextView vipTimeTextView;

    @BindView(R.id.qb_mine_layout_service)
    RelativeLayout layoutService;

    @BindView(R.id.qb_mine_layout_share)
    RelativeLayout layoutShare;

    @BindView(R.id.qb_mine_layout_location)
    RelativeLayout layoutLocation;

    @BindView(R.id.qb_mine_vip)
    RelativeLayout layoutVip;

    @BindView(R.id.qb_mine_no_vip)
    RelativeLayout layoutNoVip;

    @BindView(R.id.qb_mine_layout_contact)
    RelativeLayout layoutContact;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBMineActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == 101) {
            showVip();
        }
        else if(requestCode == 200 && resultCode == 102) {
            ToastMaker.showShort("添加联系人成功", getContext());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_mine;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        layoutService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QBServiceActivity.start(getContext());
            }
        });

        layoutShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        layoutLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QBSettingLocationActivity.start(getContext());
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QBSettingActivity.start(getContext());
            }
        });

        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QBBuyActivity.class);
                intent.putExtra("pay", true);
                startActivityForResult(intent, 100);
            }
        });

        layoutContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QBAddContactActivity.class);
                startActivityForResult(intent, 200);
            }
        });

        showVip();

        phoneTextView.setText(Tool.User_Name);
    }

    @Override
    protected void loadData() {

    }

    private void showVip() {
        if(Tool.Vip) {
            layoutVip.setVisibility(View.VISIBLE);
            layoutNoVip.setVisibility(View.GONE);
            layoutLocation.setVisibility(View.VISIBLE);

            SharedPreferences sp = getContext().getSharedPreferences("QB", Context.MODE_PRIVATE);
            long vipTime = sp.getLong("vip_time", 0);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date vipDate = new Date(vipTime);
            String timeString = df.format(vipDate);
            if(timeString != null && timeString.length() >= 10) {
                vipTimeTextView.setText("日期截至到" + timeString.substring(0, 10));
            }
        }
    }

    private void share() {
        QBSharePopView.create(getContext()).show();
    }

    private void shareToWechat() {
        WXTextObject textObj = new WXTextObject();
        textObj.text = "我正在使用趣呗App，一起来下载吧";

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = "我正在使用趣呗App，一起来下载吧";

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "android";
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        WXAPIFactory.createWXAPI(this, Config.WX_APPID).sendReq(req);
    }

    private void shareToCircle() {
        WXTextObject textObj = new WXTextObject();
        textObj.text = "我正在使用趣呗App，一起来下载吧";

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = "我正在使用趣呗App，一起来下载吧";

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "android";
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        WXAPIFactory.createWXAPI(this, Config.WX_APPID).sendReq(req);
    }
}
