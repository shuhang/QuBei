package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pku45a.difference.R;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;

public class QBAddContactActivity extends BaseActivity<MyPresenter> implements BaseView {
    @BindView(R.id.qb_add_contact_button_add)
    Button button;

    @BindView(R.id.qb_add_contact_name)
    EditText nameEditText;

    @BindView(R.id.qb_add_contact_phone)
    EditText phoneEditText;

    public static void start(Context context) {
        Intent intent = new Intent(context, QBAddContactActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_add_contact;
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
        if(nameEditText.getText().toString().length() == 0) {
            ToastMaker.showShort("请输入紧急联系人姓名", getContext());
            return;
        }
        if(phoneEditText.getText().toString().length() != 11) {
            ToastMaker.showShort("请输入正确的手机号", getContext());
            return;
        }

        setResult(102);
        finish();
    }
}
