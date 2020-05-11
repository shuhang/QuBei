package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.utils.ImageLoader;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

public class SMMyInfoActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_my_info_layout_head)
    RelativeLayout headLayout;

    @BindView(R.id.sm_my_info_layout_tag)
    RelativeLayout tagLayout;

    @BindView(R.id.sm_my_info_layout_password)
    RelativeLayout passwordLayout;

    @BindView(R.id.sm_my_info_image_head)
    ImageView headImageView;

    @BindView(R.id.sm_my_info_text_name)
    TextView nameTextView;

    @BindView(R.id.sm_my_info_text_phone)
    TextView phoneTextView;

    @BindView(R.id.sm_my_info_text_tag)
    TextView tagTextView;

    @BindView(R.id.sm_my_info_switch_hide)
    SwitchCompat hideSwitch;

    private boolean selfSwitch = false;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMMyInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ImageLoader.userIcon(headImageView, Config.userEntity.getUser_icon());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 100:
                String type = data.getStringExtra("type");
                if(type != null && type.equals("setTag")) {
                    ToastMaker.showShort("设置成功");
                    tagTextView.setText(Config.userEntity.getUser_tag());
                }
                break;
            case 101:
                ImageLoader.userIcon(headImageView, Config.userEntity.getUser_icon());
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_my_info;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        ImageLoader.userIcon(headImageView, Config.userEntity.getUser_icon());
        nameTextView.setText(Config.userEntity.getUser_name());
        phoneTextView.setText(Config.userEntity.getTell_number());
        tagTextView.setText(Config.userEntity.getUser_tag());

        if(Config.userEntity.getIs_hide() == 0) {
            hideSwitch.setChecked(true);
        }
        else {
            hideSwitch.setChecked(false);
        }
        hideSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(selfSwitch) {
                    selfSwitch = false;
                    return;
                }
                showLoadingDialog();
                BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smChangeHideState(Config.userEntity.getUser_id()), true, "user/changeName", String.class, new RequestListener<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int code, String data) {
                        ToastMaker.showShort("设置成功");
                    }

                    @Override
                    public void onFailed(int code, String msg) {
                        ToastMaker.showShort(msg);
                        selfSwitch = true;
                        hideSwitch.setChecked(!isChecked);
                    }

                    @Override
                    public void onError(ExceptionHandle handle) {
                        ToastMaker.showShort(Config.Common_NetWork_Error);
                        selfSwitch = true;
                        hideSwitch.setChecked(!isChecked);
                    }

                    @Override
                    public void onFinish() {
                        dismissLoadingDialog();
                    }
                });
            }
        });

        headLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMHeadListActivity.class);
                startActivityForResult(intent, 101);
            }
        });

        tagLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMSetTagActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        passwordLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SMCheckPhoneActivity.class);
                intent.putExtra("phone", Config.userEntity.getTell_number());
                intent.putExtra("name", Config.userEntity.getUser_name());
                intent.putExtra("type", "changePassword");
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
