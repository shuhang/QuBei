package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;

public class QBAddFriendActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_addZ_friend_button)
    Button button;

    @BindView(R.id.qb_addZ_friend_input)
    EditText inputEditText;

    private boolean preVip = false;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBAddFriendActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preVip = Tool.Vip;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            finish();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_add_friend;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAdd();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void clickAdd() {
        if(inputEditText.getText().toString().length() != 11) {
            ToastMaker.showShort("请输入正确的手机号", getContext());
            return;
        }
        if(getIntent().getBooleanExtra("main", false)) {
            if(Tool.Vip) {
                addFriend(inputEditText.getText().toString());
            }
            else {
                QBUnlockPopView.create(getContext()).show();
            }
        }
        else {
            addFriend(inputEditText.getText().toString());
        }
    }

    private void addFriend(String phone) {
        showLoadingDialog();
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().qbInviteFriend(Tool.User_Id, phone), true, "new_year/web/index.php?r=api/qubei/invite_friend", String.class, new RequestListener<List<String>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<String> data) {
                Intent intent = new Intent();
                intent.putExtra("phone", phone);
                setResult(101, intent);
                finish();
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg, getContext());
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }
}
