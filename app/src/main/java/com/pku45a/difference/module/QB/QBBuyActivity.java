package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.QB.Modal.QBWechatEntity;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;

public class QBBuyActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_buy_layout1)
    RelativeLayout layout1;

    @BindView(R.id.qb_buy_layout1_bg)
    View layout1_bg;

    @BindView(R.id.qb_buy_layout1_text_price)
    TextView layout1_price;

    @BindView(R.id.qb_buy_layout1_text_info)
    TextView layout1_info;

    @BindView(R.id.qb_buy_layout1_check_image)
    ImageView layout1_check_image;

    @BindView(R.id.qb_buy_layout1_top_red)
    TextView layout1_red_image;
    //
    @BindView(R.id.qb_buy_layout2)
    RelativeLayout layout2;

    @BindView(R.id.qb_buy_layout2_bg)
    View layout2_bg;

    @BindView(R.id.qb_buy_layout2_text_price)
    TextView layout2_price;

    @BindView(R.id.qb_buy_layout2_text_info)
    TextView layout2_info;

    @BindView(R.id.qb_buy_layout2_check_image)
    ImageView layout2_check_image;
    //
    @BindView(R.id.qb_buy_layout3)
    RelativeLayout layout3;

    @BindView(R.id.qb_buy_layout3_bg)
    View layout3_bg;

    @BindView(R.id.qb_buy_layout3_text_price)
    TextView layout3_price;

    @BindView(R.id.qb_buy_layout3_text_info)
    TextView layout3_info;

    @BindView(R.id.qb_buy_layout3_check_image)
    ImageView layout3_check_image;
    //
    @BindView(R.id.qb_buy_layout4)
    RelativeLayout layout4;

    @BindView(R.id.qb_buy_layout4_bg)
    View layout4_bg;

    @BindView(R.id.qb_buy_layout4_text_price)
    TextView layout4_price;

    @BindView(R.id.qb_buy_layout4_text_info)
    TextView layout4_info;

    @BindView(R.id.qb_buy_layout4_check_image)
    ImageView layout4_check_image;

    @BindView(R.id.qb_buy_button)
    Button buyButton;

    @BindView(R.id.qb_buy_skip)
    Button skipButton;

    private int choosedIndex = 0;
    private IWXAPI api;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBBuyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(Tool.GotoPay) {
            Tool.GotoPay = false;
            if(Tool.PayResult) {
                Tool.Vip = true;
                if(getIntent().getBooleanExtra("first", false)) {
                    Intent intent = new Intent(getContext(), QBLoginActivity.class);
                    startActivityForResult(intent, 100);
                    setResult(101);
                    finish();
                }
                else {
                    setResult(101);
                    finish();
                }
            }
            else {
                ToastMaker.showShort("支付失败，请重试", getContext());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 101) {
            setResult(101);
            finish();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_buy;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLayout(0);
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLayout(1);
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLayout(2);
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLayout(3);
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBuy();
            }
        });

        if(getIntent().getBooleanExtra("first", false)) {
            skipButton.setVisibility(View.VISIBLE);
            skipButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), QBLoginActivity.class);
                    startActivityForResult(intent, 100);
                }
            });
        }
    }

    @Override
    protected void loadData() {

    }

    private void clickLayout(int index) {
        if(index == choosedIndex) {
            return;
        }

        switch (index) {
            case 0:
                layout1_bg.setVisibility(View.VISIBLE);
                layout1_red_image.setVisibility(View.VISIBLE);
                layout1_price.setTextColor(Color.parseColor("#1A1A1A"));
                layout1_info.setTextColor(Color.parseColor("#1B1A1B"));
                layout1_check_image.setVisibility(View.VISIBLE);
                break;
            case 1:
                layout2_bg.setVisibility(View.VISIBLE);
                layout2_price.setTextColor(Color.parseColor("#1A1A1A"));
                layout2_info.setTextColor(Color.parseColor("#1B1A1B"));
                layout2_check_image.setVisibility(View.VISIBLE);
                break;
            case 2:
                layout3_bg.setVisibility(View.VISIBLE);
                layout3_price.setTextColor(Color.parseColor("#1A1A1A"));
                layout3_info.setTextColor(Color.parseColor("#1B1A1B"));
                layout3_check_image.setVisibility(View.VISIBLE);
                break;
            case 3:
                layout4_bg.setVisibility(View.VISIBLE);
                layout4_price.setTextColor(Color.parseColor("#1A1A1A"));
                layout4_info.setTextColor(Color.parseColor("#1B1A1B"));
                layout4_check_image.setVisibility(View.VISIBLE);
                break;
        }

        switch (choosedIndex) {
            case 0:
                layout1_bg.setVisibility(View.INVISIBLE);
                layout1_red_image.setVisibility(View.INVISIBLE);
                layout1_price.setTextColor(Color.WHITE);
                layout1_info.setTextColor(Color.WHITE);
                layout1_check_image.setVisibility(View.INVISIBLE);
                break;
            case 1:
                layout2_bg.setVisibility(View.INVISIBLE);
                layout2_price.setTextColor(Color.WHITE);
                layout2_info.setTextColor(Color.WHITE);
                layout2_check_image.setVisibility(View.INVISIBLE);
                break;
            case 2:
                layout3_bg.setVisibility(View.INVISIBLE);
                layout3_price.setTextColor(Color.WHITE);
                layout3_info.setTextColor(Color.WHITE);
                layout3_check_image.setVisibility(View.INVISIBLE);
                break;
            case 3:
                layout4_bg.setVisibility(View.INVISIBLE);
                layout4_price.setTextColor(Color.WHITE);
                layout4_info.setTextColor(Color.WHITE);
                layout4_check_image.setVisibility(View.INVISIBLE);
                break;
        }

        choosedIndex = index;
    }

    private void clickBuy() {
        pay();
    }

    private void pay() {
        int[] vipTimes = new int[]{60, 93, 183, 365};
        int[] moneys = new int[]{3400, 8800, 12800, 20800};
//        int[] moneys = new int[]{1, 2, 3, 4};
        String[] bodys = new String[]{"趣呗月会员", "趣呗季度会员",
                "趣呗半年会员", "趣呗年会员"};
         showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().qbWechatPay(Tool.User_Id, moneys[choosedIndex], vipTimes[choosedIndex], bodys[choosedIndex]), true, "new_year/web/index.php?r=api/qubei/request_wechat_pay", QBWechatEntity.class, new RequestListener<QBWechatEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, QBWechatEntity data) {
                Tool.GotoPay = true;
                Tool.Vip_Days = vipTimes[choosedIndex];

                api = WXAPIFactory.createWXAPI(getContext(), Config.WX_APPID);
                api.registerApp(Config.WX_APPID);
                PayReq request = new PayReq();
                request.appId = Config.WX_APPID;
                request.partnerId = data.getPartnerid();
                request.prepayId= data.getPrepayid();
                request.packageValue = data.getPackageValue();
                request.nonceStr= data.getNoncestr();
                request.timeStamp= data.getTimestamp();
                request.sign= data.getSign();
                api.sendReq(request);
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error);
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });

    }
}
