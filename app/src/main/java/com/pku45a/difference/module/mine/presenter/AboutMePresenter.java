package com.pku45a.difference.module.mine.presenter;

import per.goweii.basic.core.base.BasePresenter;
import com.pku45a.difference.http.RequestCallback;
import com.pku45a.difference.module.mine.model.AboutMeBean;
import com.pku45a.difference.module.mine.model.MineRequest;
import com.pku45a.difference.module.mine.view.AboutMeView;

/**
 * @author CuiZhen
 * @date 2019/5/23
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class AboutMePresenter extends BasePresenter<AboutMeView> {

    public void getAboutMe(){
        MineRequest.getAboutMe(getRxLife(), new RequestCallback<AboutMeBean>() {
            @Override
            public void onSuccess(int code, AboutMeBean data) {
                if (isAttach()) {
                    getBaseView().getAboutMeSuccess(code, data);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().getAboutMeFailed(code, msg);
                }
            }
        });
    }

}
