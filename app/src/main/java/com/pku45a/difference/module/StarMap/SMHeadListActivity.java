package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.StarMap.Adapter.SMHeadListAdapter;
import com.pku45a.difference.module.StarMap.Modal.SMHeadIconEntity;
import com.pku45a.difference.module.StarMap.Modal.SMHeadIconItemEntity;
import com.pku45a.difference.module.mine.presenter.MinePresenter;
import com.pku45a.difference.utils.ImageLoader;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

public class SMHeadListActivity extends BaseActivity <MinePresenter> implements BaseView {
    @BindView(R.id.sm_head_list_list)
    RecyclerView listView;

    private SMHeadListAdapter adapter;
    private View headerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMHeadListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_head_list;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SMHeadListAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);

        headerView = View.inflate(getContext(), R.layout.sm_head_list_header, null);
        adapter.addHeaderView(headerView);

        adapter.setHeadListener(new SMHeadListAdapter.HeadClickItemListener() {
            @Override
            public void clickHeadIcon(String imageUrl, String imageName) {
                changeUserIcon(imageUrl, imageName);
            }
        });

        ImageView headImageView = headerView.findViewById(R.id.sm_head_list_header_layout_image);
        ImageLoader.userIcon(headImageView, Config.userEntity.getUser_icon());

        if(Config.userEntity.getIconName() != null) {
            TextView nameImageView = headerView.findViewById(R.id.sm_head_list_header_layout_text);
            nameImageView.setText(Config.userEntity.getIconName());
        }

        loadHeadList();
    }

    @Override
    protected void loadData() {

    }

    private void loadHeadList() {
        showLoadingDialog();
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().getHeadIconList(Config.userEntity.getUser_id()), true, "user/getAllHeadpic", SMHeadIconEntity.class, new RequestListener<List<SMHeadIconEntity>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<SMHeadIconEntity> data) {
                List<SMHeadIconItemEntity> tempArray = new ArrayList<SMHeadIconItemEntity>(20);
                int count = data.size() / 3 + 1;
                if(data.size() % 3 == 0) {
                    count -= 1;
                }
                int index = 0;
                String name = "头像";
                for(int i = 0; i < count; i ++) {
                    SMHeadIconItemEntity itemEntity = new SMHeadIconItemEntity();
                    tempArray.add(itemEntity);
                    List<SMHeadIconEntity> childArray = new ArrayList<SMHeadIconEntity>(3);
                    itemEntity.setIconList(childArray);
                    childArray.add(data.get(index));
                    if(data.get(index).getHeadpic_img().equals(Config.userEntity.getUser_icon())) {
                        name = data.get(index).getHeadpic_name();
                    }

                    index += 1;
                    if(index >= data.size()) {
                        break;
                    }
                    childArray.add(data.get(index));
                    if(data.get(index).getHeadpic_img().equals(Config.userEntity.getUser_icon())) {
                        name = data.get(index).getHeadpic_name();
                    }

                    index += 1;
                    if(index >= data.size()) {
                        break;
                    }
                    childArray.add(data.get(index));
                    if(data.get(index).getHeadpic_img().equals(Config.userEntity.getUser_icon())) {
                        name = data.get(index).getHeadpic_name();
                    }

                    index += 1;
                    if(index >= data.size()) {
                        break;
                    }
                }
                adapter.setNewData(tempArray);
                TextView nameImageView = headerView.findViewById(R.id.sm_head_list_header_layout_text);
                nameImageView.setText(name);
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

    private void changeUserIcon(String imageUrl, String imageName) {
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smSetUserIcon(Config.userEntity.getUser_id(), imageUrl), true, "user/modifyHeadpic", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                ToastMaker.showShort("设置成功");

                Config.userEntity.setUser_icon(imageUrl);
                Config.userEntity.setIconName(imageName);
                Tool.setObject(getContext(), "User", Config.userEntity);

                ImageView headImageView = headerView.findViewById(R.id.sm_head_list_header_layout_image);
                ImageLoader.userIcon(headImageView, imageUrl);
                TextView nameImageView = headerView.findViewById(R.id.sm_head_list_header_layout_text);
                nameImageView.setText(imageName);
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
