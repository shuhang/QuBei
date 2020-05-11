package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.module.StarMap.Adapter.SMFocusUserListAdapter;
import com.pku45a.difference.module.StarMap.Modal.SMFocusUserEntity;
import com.pku45a.difference.module.StarMap.Modal.SMFocusUserResponse;
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

public class SMFocusUserListActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.sm_focus_user_list_list)
    RecyclerView listView;

    @BindView(R.id.sm_focus_user_list_srl)
    SmartRefreshLayout srl;

    @BindView(R.id.sm_focus_user_list_top_symbol)
    View symbolView;

    @BindView(R.id.sm_focus_user_list_top_text_left)
    TextView leftTextView;

    @BindView(R.id.sm_focus_user_list_top_text_right)
    TextView rightTextView;

    private int choosedIndex = 0;
    private List<SMFocusUserEntity> datas;

    private SMFocusUserListAdapter adapter;
    private SmartRefreshUtils mSmartRefreshUtils;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMFocusUserListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_focus_user_list;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMFocusUserListAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);

        mSmartRefreshUtils = SmartRefreshUtils.with(srl);
        mSmartRefreshUtils.pureScrollMode();
        mSmartRefreshUtils.setRefreshListener(new SmartRefreshUtils.RefreshListener() {
            @Override
            public void onRefresh() {
                loadFocusUserList();
            }
        });

        adapter.setEnableLoadMore(false);

        adapter.setMessageListener(new SMFocusUserListAdapter.FocusUserItemListener() {
            @Override
            public void clickHonor(String userId) {

            }

            @Override
            public void clickRisk(String userId) {

            }

            @Override
            public void clickFocus(int index) {
                focus(index);
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), SMUserInfoActivity.class);
                intent.putExtra("userId", datas.get(position).getUser_id());
                getContext().startActivity(intent);
            }
        });

        leftTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLeft();
            }
        });

        rightTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRight();
            }
        });

        loadFocusUserList();
    }

    @Override
    protected void loadData() {

    }

    private void clickLeft() {
        if(choosedIndex == 0) {
            return;
        }
        choosedIndex = 0;
        leftTextView.setTextColor(getResources().getColor(R.color.white));
        rightTextView.setTextColor(getResources().getColor(R.color.middle_gray));
        mSmartRefreshUtils.autoRefresh();
    }

    private void clickRight() {
        if(choosedIndex == 1) {
            return;
        }
        TranslateAnimation animation = new TranslateAnimation(symbolView.getX(), symbolView.getX() + symbolView.getWidth(), symbolView.getY(), symbolView.getY());
        animation.setDuration(200);
        animation.setRepeatCount(0);
        symbolView.setAnimation(animation);
        animation.startNow();

        choosedIndex = 1;
        rightTextView.setTextColor(getResources().getColor(R.color.white));
        leftTextView.setTextColor(getResources().getColor(R.color.middle_gray));
        mSmartRefreshUtils.autoRefresh();
    }

    private void loadFocusUserList() {
        if(choosedIndex == 0) {
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().getFocusUserList(Config.userEntity.getUser_id()), true, "like/lists", SMFocusUserResponse.class, new RequestListener<SMFocusUserResponse>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, SMFocusUserResponse data) {
                    datas = data.getFriendlist();
                    for(int i = 0; i < datas.size(); i ++) {
                        datas.get(i).setFocus(1);
                    }
                    adapter.setNewData(datas);
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
        else {
            BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getRecommendUserList(Config.userEntity.getUser_id()), true, "like/putlist", SMFocusUserEntity.class, new RequestListener<List<SMFocusUserEntity>>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, List<SMFocusUserEntity> data) {
                    datas = data;
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

    private void focus(int index) {
        if(datas.get(index).getFocus() == 0) {
            showLoadingDialog();
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smFocusUser(Config.userEntity.getUser_id(), datas.get(index).getUser_id()), true, "like/add", String.class, new RequestListener<String>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, String data) {
                    ToastMaker.showShort("关注成功");
                    datas.get(index).setFocus(1);
                    adapter.setData(index, datas.get(index));
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
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smUnfocusUser(Config.userEntity.getUser_id(), datas.get(index).getUser_id()), true, "like/remove", String.class, new RequestListener<String>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, String data) {
                    ToastMaker.showShort("取消关注成功");
                    datas.get(index).setFocus(0);
                    adapter.setData(index, datas.get(index));
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
