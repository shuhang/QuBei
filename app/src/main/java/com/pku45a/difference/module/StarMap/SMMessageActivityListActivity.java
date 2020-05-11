package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.pku45a.difference.module.StarMap.Modal.SMMessageDetailEntity;
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
import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.Adapter.SMMessageActivityListAdapter;
import com.pku45a.difference.module.StarMap.Modal.SMMessageActivityEntity;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

public class SMMessageActivityListActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_message_activity_list_list)
    RecyclerView listView;

    @BindView(R.id.sm_message_activity_list_srl)
    SmartRefreshLayout srl;

    private SMMessageActivityListAdapter adapter;
    private SmartRefreshUtils mSmartRefreshUtils;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMMessageActivityListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_message_activity_list;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMMessageActivityListAdapter();
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
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getMessageDetailList(Config.userEntity.getUser_id(), 2), true, "message/detail", SMMessageDetailEntity.class, new RequestListener<List<SMMessageDetailEntity>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<SMMessageDetailEntity> data) {
                List<SMMessageActivityEntity> tempArray = new ArrayList<SMMessageActivityEntity>();
                for(int i = 0; i < data.size(); i ++) {
                    Gson mGson = new Gson();
                    SMMessageDetailEntity detail = data.get(i);
                    SMMessageActivityEntity entity = mGson.fromJson(detail.getContent(), SMMessageActivityEntity.class);
                    entity.setTime(detail.getTime());
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
