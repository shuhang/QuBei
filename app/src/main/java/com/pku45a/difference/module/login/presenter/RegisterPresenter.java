package com.pku45a.difference.module.login.presenter;

import per.goweii.basic.core.base.BasePresenter;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.module.login.model.LoginBean;
import com.pku45a.difference.module.login.model.LoginRequest;
import com.pku45a.difference.module.login.view.RegisterView;
import com.pku45a.difference.utils.UserUtils;

/**
 * @author CuiZhen
 * @date 2019/5/15
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class RegisterPresenter extends BasePresenter<RegisterView> {

    public void register(String userName, String password, String repassword){
        addToRxLife(LoginRequest.register(userName, password, repassword, new RequestListener<LoginBean>() {
            @Override
            public void onStart() {
                showLoadingDialog();
            }

            @Override
            public void onSuccess(int code, LoginBean data) {
                UserUtils.getInstance().login(data);
                if (isAttach()) {
                    getBaseView().registerSuccess(code, data);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().registerFailed(code, msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {

            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        }));
    }
}