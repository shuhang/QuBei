package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.StarMap.Modal.SMUserEntity;
import com.pku45a.difference.module.mine.presenter.MinePresenter;
import com.pku45a.difference.utils.ImageLoader;

import java.util.Date;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

public class SMUserInfoActivity extends BaseActivity<MinePresenter> implements BaseView {
    @BindView(R.id.abc)
    ActionBarCommon actionBarCommon;

    @BindView(R.id.sm_user_info_head)
    ImageView headImageView;
    @BindView(R.id.sm_user_info_name)
    TextView nameTextView;
    @BindView(R.id.sm_user_info_tag)
    TextView tagTextView;
    @BindView(R.id.sm_user_info_rank_image)
    ImageView rankImageView;
    @BindView(R.id.sm_user_info_feed_count)
    TextView feedTextView;
    @BindView(R.id.sm_user_info_focus_count)
    TextView focusTextView;
    @BindView(R.id.sm_user_info_text_change_type)
    TextView changeTypeTextView;
    @BindView(R.id.sm_user_info_text_risk)
    TextView riskTextView;
    @BindView(R.id.sm_user_info_focus)
    Button focusButton;

    private SMUserEntity entity;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMUserInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_user_info;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        loadUserInfo();

        focusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFocus();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void loadUserInfo() {
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smGetUserInfo(getIntent().getStringExtra("userId")), true, "user/getUserInformation", SMUserEntity.class, new RequestListener<SMUserEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, SMUserEntity data) {
                entity = data;
                updateUserInfo();
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

    private void updateUserInfo() {
        Date nowDate = new Date();
        long diff = nowDate.getTime() - Long.valueOf(entity.getRegisterdate()) * 1000;
        if(diff > 0) {
            long month = diff / (1000 * 60 * 60 * 24);
            month = month / 30;
            if(month > 0) {
                if(month > 12) {
                    tagTextView.setText(month / 12 + "年前来到Star");
                }
                else {
                    tagTextView.setText(month + "个月前来到Star");
                }
            }
            else  {
                long day = diff / (1000 * 60 * 60 * 24);
                if(day > 0) {
                    tagTextView.setText(day + "天前来到Star");
                }
                else {
                    long hour = (diff-day*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                    tagTextView.setText(hour + "个小时前来到Star");
                }
            }
        }

        actionBarCommon.getTitleTextView().setText(entity.getUser_name() + "的主页");
        ImageLoader.userIcon(headImageView, entity.getUser_icon());
        nameTextView.setText(entity.getUser_name());
        final int[] rankImages = new int[] { };
        if(entity.getGlory_level() >= 1 && entity.getGlory_level() <= 7) {
            rankImageView.setImageResource(rankImages[entity.getGlory_level() - 1]);
        }
        else {
            rankImageView.setImageResource(rankImages[0]);
        }

        focusTextView.setText(entity.getAttentionCount() + "");
        feedTextView.setText((entity.getNews_sendcount() + entity.getTopic_sendcount() + entity.getVoice_sendcount()) + "");
        changeTypeTextView.setText(entity.getChange_type() + "");
        riskTextView.setText(entity.getRisk() + "");
    }

    private void clickFocus() {
        if(entity == null) {
            return;
        }
        if(entity.getFocus() == 0) {
            showLoadingDialog();
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smFocusUser(Config.userEntity.getUser_id(), entity.getUser_id()), true, "like/add", String.class, new RequestListener<String>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, String data) {
                    ToastMaker.showShort("关注成功");
                    entity.setFocus(1);
                    focusButton.setBackgroundResource(R.drawable.corner_bg_blue_15);
                    focusButton.setText("已关注");
                    focusButton.setTextColor(getContext().getResources().getColor(R.color.white));
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
        else {
            showLoadingDialog();
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smUnfocusUser(Config.userEntity.getUser_id(), entity.getUser_id()), true, "like/remove", String.class, new RequestListener<String>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, String data) {
                    ToastMaker.showShort("取消关注成功");
                    entity.setFocus(0);
                    focusButton.setBackgroundResource(R.drawable.corner_bg_solid_blue_15);
                    focusButton.setText("关注");
                    focusButton.setTextColor(getContext().getResources().getColor(R.color.sm_blue));
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
}
