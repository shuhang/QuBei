package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.Modal.SMMessageCommentEntity;
import com.pku45a.difference.module.StarMap.Modal.SMMessageDetailEntity;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.core.utils.SmartRefreshUtils;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

import com.pku45a.difference.module.StarMap.Adapter.SMMessageCommentListAdapter;

public class SMMessageCommentListActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_message_comment_list_list)
    RecyclerView listView;

    @BindView(R.id.sm_message_comment_list_srl)
    SmartRefreshLayout srl;

    private SMMessageCommentListAdapter adapter;
    private SmartRefreshUtils mSmartRefreshUtils;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMMessageCommentListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_message_comment_list;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMMessageCommentListAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);

        mSmartRefreshUtils = SmartRefreshUtils.with(srl);
        mSmartRefreshUtils.pureScrollMode();
        mSmartRefreshUtils.setRefreshListener(new SmartRefreshUtils.RefreshListener() {
            @Override
            public void onRefresh() {
                loadMessageList();
            }
        });

        adapter.setEnableLoadMore(false);

        adapter.setMessageListener(new SMMessageCommentListAdapter.MessageCommentItemListener() {
            @Override
            public void clickReply(SMMessageCommentEntity entity) {

            }

            @Override
            public void clickUser(String userId) {
                Intent intent = new Intent(getContext(), SMUserInfoActivity.class);
                intent.putExtra("userId", userId);
                getContext().startActivity(intent);
            }

            @Override
            public void clickTopUser(String userId) {
                Intent intent = new Intent(getContext(), SMUserInfoActivity.class);
                intent.putExtra("userId", userId);
                getContext().startActivity(intent);
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        loadMessageList();
    }

    @Override
    protected void loadData() {

    }

    private void loadMessageList() {
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getMessageDetailList(Config.userEntity.getUser_id(), 3), true, "message/detail", SMMessageDetailEntity.class, new RequestListener<List<SMMessageDetailEntity>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<SMMessageDetailEntity> data) {
                List<SMMessageCommentEntity> tempArray = new ArrayList<SMMessageCommentEntity>();
                for(int i = 0; i < data.size(); i ++) {
                    Gson mGson = new Gson();
                    SMMessageDetailEntity detail = data.get(i);
                    SMMessageCommentEntity entity = mGson.fromJson(detail.getContent(), SMMessageCommentEntity.class);
                    tempArray.add(entity);
                }
                adapter.setNewData(tempArray);
                mSmartRefreshUtils.success();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
                mSmartRefreshUtils.fail();
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error);
                mSmartRefreshUtils.fail();
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
