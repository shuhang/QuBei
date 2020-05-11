package com.pku45a.difference.module.StarMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.mine.presenter.MinePresenter;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.R;

public class SMSetTagActivity extends BaseActivity<MinePresenter> implements BaseView {
    @BindView(R.id.sm_set_tag_input)
    EditText inputEditText;

    @BindView(R.id.sm_set_tag_save)
    Button saveButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMSetTagActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_set_tag;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        inputEditText.setText(Config.userEntity.getUser_tag());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTag();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void saveTag() {
        if(inputEditText.getText().toString().length() == 0) {
            ToastMaker.showShort("请输入标签");
            return;
        }
        showLoadingDialog();
        BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().smSetTag(Config.userEntity.getUser_id(), inputEditText.getText().toString()), true, "user/setUserTag", String.class, new RequestListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, String data) {
                Config.userEntity.setUser_tag(inputEditText.getText().toString());
                Tool.setObject(getContext(), "User", Config.userEntity);

                setTagSuccess();
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

    private void setTagSuccess() {
        Intent intent = new Intent();
        intent.putExtra("type", "setTag");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
