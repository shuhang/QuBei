package com.pku45a.difference.module.QB;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.pku45a.difference.R;

import per.goweii.anylayer.DialogLayer;

public class QBSharePopView extends DialogLayer {
    private Context tempContext;

    public static QBSharePopView create(Context context) {
        return new QBSharePopView(context);
    }

    private QBSharePopView(Context context) {
        super(context);

        tempContext = context;
        contentView(R.layout.qb_share_pop);
    }

    @Override
    public void onShow() {
        super.onShow();

        Button wechatButton = getView(R.id.qb_share_pop_wechat);
        wechatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WXTextObject textObj = new WXTextObject();
                textObj.text = "我正在使用趣呗App，一起来下载吧";

                WXMediaMessage msg = new WXMediaMessage();
                msg.mediaObject = textObj;
                msg.description = "我正在使用趣呗App，一起来下载吧";

                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = "android";
                req.message = msg;
                req.scene = SendMessageToWX.Req.WXSceneSession;
                WXAPIFactory.createWXAPI(tempContext, com.pku45a.difference.common.Config.WX_APPID).sendReq(req);

                dismiss(true);
            }
        });

        Button circleButton = getView(R.id.qb_share_pop_circle);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WXTextObject textObj = new WXTextObject();
                textObj.text = "我正在使用趣呗App，一起来下载吧";

                WXMediaMessage msg = new WXMediaMessage();
                msg.mediaObject = textObj;
                msg.description = "我正在使用趣呗App，一起来下载吧";

                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = "android";
                req.message = msg;
                req.scene = SendMessageToWX.Req.WXSceneTimeline;
                WXAPIFactory.createWXAPI(tempContext, com.pku45a.difference.common.Config.WX_APPID).sendReq(req);

                dismiss(true);
            }
        });

        Button cancelButton = getView(R.id.qb_share_pop_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(true);
            }
        });
    }
}
