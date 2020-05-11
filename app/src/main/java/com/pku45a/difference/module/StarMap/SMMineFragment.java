package com.pku45a.difference.module.StarMap;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.event.LoginEvent;
import com.pku45a.difference.event.SettingChangeEvent;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.StarMap.Modal.SMUserEntity;
import com.pku45a.difference.module.mine.presenter.MinePresenter;
import com.pku45a.difference.utils.ImageLoader;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
import per.goweii.basic.core.base.BaseFragment;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

public class SMMineFragment extends BaseFragment<MinePresenter> implements BaseView {
    @BindView(R.id.sm_mine_head)
    ImageView headImageView;
    @BindView(R.id.sm_mine_name)
    TextView nameTextView;
    @BindView(R.id.sm_mine_tag)
    TextView tagTextView;
    @BindView(R.id.sm_mine_rank_image)
    ImageView rankImageView;
    @BindView(R.id.sm_mine_feed_count)
    TextView feedTextView;
    @BindView(R.id.sm_mine_focus_count)
    TextView focusTextView;
    @BindView(R.id.sm_mine_text_change_type)
    TextView changeTypeTextView;
    @BindView(R.id.sm_mine_text_risk)
    TextView riskTextView;

    public static SMMineFragment create() {
        return new SMMineFragment();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {
        if (isDetached()) {
            return;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSettingChangeEvent(SettingChangeEvent event) {
        if (isDetached()) {
            return;
        }
        if (event.isShowReadLaterChanged() || event.isHideAboutMeChanged() || event.isHideOpenChanged()) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUserInfo();
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.sm_mine;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        headImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMMyInfoActivity.start(getContext());
            }
        });

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMMyInfoActivity.start(getContext());
            }
        });

        tagTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMMyInfoActivity.start(getContext());
            }
        });

        updateUserInfo();
        loadUserInfo();
    }

    private void updateUserInfo() {
        ImageLoader.userIcon(headImageView, Config.userEntity.getUser_icon());
        nameTextView.setText(Config.userEntity.getUser_name());
        tagTextView.setText(Config.userEntity.getUser_tag());
        final int[] rankImages = new int[] { };
        if(Config.userEntity.getGlory_level() >= 1 && Config.userEntity.getGlory_level() <= 7) {
            rankImageView.setImageResource(rankImages[Config.userEntity.getGlory_level() - 1]);
        }
        else {
            rankImageView.setImageResource(rankImages[0]);
        }

        focusTextView.setText(Config.userEntity.getAttentionCount() + "");
        feedTextView.setText((Config.userEntity.getNews_sendcount() + Config.userEntity.getTopic_sendcount() + Config.userEntity.getVoice_sendcount()) + "");
        changeTypeTextView.setText(Config.userEntity.getChange_type() + "");
        riskTextView.setText(Config.userEntity.getRisk() + "");
    }

    @Override
    protected void loadData() {

    }

    @OnClick({
        R.id.sm_mine_like_record, R.id.sm_mine_vote_record,
            R.id.sm_mine_black_record, R.id.sm_mine_report_record,
            R.id.sm_mine_feedback, R.id.sm_mine_setting, R.id.sm_mine_focus_layout
    })
    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected void onClick2(View v) {
        switch (v.getId()) {
            case R.id.sm_mine_focus_layout:
                SMFocusUserListActivity.start(getContext());
                break;
            case R.id.sm_mine_like_record:
                SMLoginActivity.start(getContext());
                break;
            case R.id.sm_mine_setting:
                SMSettingActivity.start(getContext());
                break;
            default:
                break;
        }
    }

    private void loadUserInfo() {
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smGetUserInfo(Config.userEntity.getUser_id()), true, "user/getUserInformation", SMUserEntity.class, new RequestListener<SMUserEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, SMUserEntity data) {
                Config.userEntity = data;
                updateUserInfo();

                Tool.setObject(getContext(), "User", data);
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
