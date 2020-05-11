package com.pku45a.difference.module.main.presenter;

import per.goweii.basic.core.base.BasePresenter;
import com.pku45a.difference.http.RequestCallback;
import com.pku45a.difference.module.main.model.MainRequest;
import com.pku45a.difference.module.main.model.UpdateBean;
import com.pku45a.difference.module.main.view.MainView;
import com.pku45a.difference.utils.UpdateUtils;

/**
 * @author CuiZhen
 * @date 2019/5/19
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class MainPresenter extends BasePresenter<MainView> {

    public void update(){
        if (UpdateUtils.newInstance().isTodayChecked()) {
            return;
        }
        MainRequest.update(getRxLife(), new RequestCallback<UpdateBean>() {
            @Override
            public void onSuccess(int code, UpdateBean data) {
                if (isAttach()) {
                    getBaseView().updateSuccess(code, data);
                }
            }

            @Override
            public void onFailed(int code, String msg) {

            }
        });
    }

}
