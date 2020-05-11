package com.pku45a.difference.module.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pku45a.difference.module.mine.presenter.CoinRankPresenter;
import com.kennyc.view.MultiStateView;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.actionbarex.common.OnActionBarChildClickListener;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.utils.listener.SimpleListener;
import com.pku45a.difference.R;
import com.pku45a.difference.module.mine.adapter.CoinRankAdapter;
import com.pku45a.difference.module.mine.model.CoinRankBean;
import com.pku45a.difference.module.mine.view.CoinRankView;
import com.pku45a.difference.utils.MultiStateUtils;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

/**
 * @author CuiZhen
 * @date 2019/8/31
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class CoinRankActivity extends BaseActivity<CoinRankPresenter> implements CoinRankView {

    private static final int PAGE_START = 1;

    @BindView(R.id.abc)
    ActionBarCommon abc;
    @BindView(R.id.msv)
    MultiStateView msv;
    @BindView(R.id.rv)
    RecyclerView rv;

    private int currPage = PAGE_START;
    private CoinRankAdapter mAdapter = null;

    public static void start(Context context) {
        Intent intent = new Intent(context, CoinRankActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coin_rank;
    }

    @Nullable
    @Override
    protected CoinRankPresenter initPresenter() {
        return new CoinRankPresenter();
    }

    @Override
    protected void initView() {
        abc.setOnRightIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CoinRankAdapter();
        RvAnimUtils.setAnim(mAdapter, SettingUtils.getInstance().getRvAnim());
        mAdapter.setEnableLoadMore(false);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getCoinRankList(currPage);
            }
        }, rv);
        rv.setAdapter(mAdapter);
        MultiStateUtils.setEmptyAndErrorClick(msv, new SimpleListener() {
            @Override
            public void onResult() {
                MultiStateUtils.toLoading(msv);
                currPage = PAGE_START;
                presenter.getCoinRankList(currPage);
            }
        });
    }

    @Override
    protected void loadData() {
        MultiStateUtils.toLoading(msv);
        currPage = PAGE_START;
        presenter.getCoinRankList(currPage);
    }

    @Override
    public void getCoinRankListSuccess(int code, CoinRankBean data) {
        currPage = data.getCurPage() + PAGE_START;
        if (data.getCurPage() == 1) {
            mAdapter.setNewData(data.getDatas());
            mAdapter.setEnableLoadMore(true);
            if (data.getDatas() == null || data.getDatas().isEmpty()) {
                MultiStateUtils.toEmpty(msv);
            } else {
                MultiStateUtils.toContent(msv);
            }
        } else {
            mAdapter.addData(data.getDatas());
            mAdapter.loadMoreComplete();
        }
        if (data.isOver()) {
            mAdapter.loadMoreEnd();
        }
    }

    @Override
    public void getCoinRankListFail(int code, String msg) {
        mAdapter.loadMoreFail();
        if (currPage == PAGE_START) {
            MultiStateUtils.toError(msv);
        }
    }
}
