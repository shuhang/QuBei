package com.pku45a.difference.module.mine.activity;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import com.pku45a.difference.R;

import com.pku45a.difference.module.main.adapter.ChunjiediAdapter;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Chunjie1Activity extends BaseActivity {
    @BindView(R.id.get_money_record_list)
    RecyclerView listView;

    private ChunjiediAdapter adapter;
    private List<String> datas;

    public static void start(Context context) {
        Intent intent = new Intent(context, Chunjie1Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.get_money_record;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ChunjiediAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);

        List<String> tempArray = new ArrayList<String>(10);
        for(int i = 0; i < 10; i ++) {
            if(i % 2 == 0) {
                tempArray.add("的护肤股飞入呼和" + i);
            }
            else {
                tempArray.add("的护入呼和" + i);
            }
        }
        adapter.setNewData(tempArray);
    }

    @Override
    protected void loadData() {

    }
}
