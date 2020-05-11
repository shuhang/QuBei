package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pku45a.difference.R;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.SMWebActivity;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;

public class QBGuidePermissionActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_guide_permission_continue)
    Button buttonContinue;

    @BindView(R.id.qb_guide_permission_agreement)
    Button buttonAgreement;

    @BindView(R.id.qb_guide_permission_layout_agree)
    RelativeLayout layoutAgree;

    @BindView(R.id.qb_guide_permission_image_agree)
    ImageView imageAgree;

    private boolean agreed = true;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBGuidePermissionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return R.layout.qb_guide_permission;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agreed) {
                    Intent intent = new Intent(getContext(), QBBuyActivity.class);
                    intent.putExtra("first", true);
                    startActivityForResult(intent, 200);
                }
                else {
                    ToastMaker.showShort("请勾选同意用户者付费协议", getContext());
                }
            }
        });

        buttonAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMWebActivity.class);
                intent.putExtra("title", "用户付费协议");
                intent.putExtra("url", "https://ads.qunzhu.me/qubei/#/Pay");
                getContext().startActivity(intent);
            }
        });

        layoutAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agreed) {
                    imageAgree.setImageResource(R.drawable.corner_bg_solid_6);
                }
                else {
                    imageAgree.setImageResource(R.mipmap.qb_check_blue);
                }
                agreed = !agreed;
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
