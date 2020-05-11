package com.pku45a.difference.module.StarMap;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.event.LoginEvent;
import com.pku45a.difference.event.SettingChangeEvent;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.mine.presenter.MinePresenter;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseFragment;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

import com.pku45a.difference.module.StarMap.Adapter.SMMessageListAdapter;
import com.pku45a.difference.module.StarMap.Modal.SMMessageListEntity;

public class SMMessageFragment extends BaseFragment<MinePresenter> implements BaseView {
    @BindView(R.id.sm_message_list)
    RecyclerView listView;

    private SMMessageListAdapter adapter;
    private List<SMMessageListEntity> datas;

    public static SMMessageFragment create() {
        return new SMMessageFragment();
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
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.sm_message;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMMessageListAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (datas.get(position).getType()) {
                    case 1:
                        Intent intent = new Intent(getContext(), SMMessageSystemListActivity.class);
                        intent.putExtra("type", datas.get(position).getType());
                        getContext().startActivity(intent);
                        break;
                    case 2:
                        SMMessageActivityListActivity.start(getContext());
                        break;
                    case 3:
                        SMMessageCommentListActivity.start(getContext());
                        break;
                    case 4:
                        SMMessageLikeListActivity.start(getContext());
                        break;
                }
            }
        });

        loadMessageList();
    }

    @Override
    protected void loadData() {

    }

    private void loadMessageList() {
        showLoadingDialog();
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getMessageList(Config.userEntity.getUser_id()), true, "message/info", SMMessageListEntity.class, new RequestListener<List<SMMessageListEntity>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<SMMessageListEntity> data) {
//                for(int i = 0; i < data.size(); i ++) {
//                    SMMessageListEntity entity = data.get(i);
//                    if(entity.getType() == 1) {
//                        entity.setImageResoureId(R.drawable.ne_news_system);
//                        entity.setName("系统消息");
//                    }
//                    else if(entity.getType() == 2) {
//                        entity.setImageResoureId(R.drawable.ne_news_activity);
//                        entity.setName("活动消息");
//                    }
//                    else if(entity.getType() == 3) {
//                        entity.setImageResoureId(R.drawable.ne_news_comment);
//                        entity.setName("评论");
//                    }
//                    else if(entity.getType() == 4) {
//                        entity.setImageResoureId(R.drawable.ne_news_support);
//                        entity.setName("赞");
//                    }
//                }
                datas = data;
                adapter.setNewData(data);
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
