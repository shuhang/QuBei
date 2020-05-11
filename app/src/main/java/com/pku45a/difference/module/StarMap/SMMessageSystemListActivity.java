package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.Modal.SMMessageDetailEntity;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.core.utils.SmartRefreshUtils;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

import com.pku45a.difference.module.StarMap.Adapter.SMMessageSystemListAdapter;

public class SMMessageSystemListActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_message_system_list_list)
    RecyclerView listView;

    @BindView(R.id.sm_message_system_list_srl)
    SmartRefreshLayout srl;

    private SMMessageSystemListAdapter adapter;
    private SmartRefreshUtils mSmartRefreshUtils;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMMessageSystemListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_message_system_list;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMMessageSystemListAdapter();
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

        loadMessageList();
    }

    @Override
    protected void loadData() {

    }

    private void loadMessageList() {
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getMessageDetailList(Config.userEntity.getUser_id(), getIntent().getIntExtra("type", 1)), true, "message/detail", SMMessageDetailEntity.class, new RequestListener<List<SMMessageDetailEntity>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<SMMessageDetailEntity> data) {
                adapter.setNewData(data);
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
