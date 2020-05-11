package com.pku45a.difference.module.home.presenter;

import com.pku45a.difference.module.main.model.ArticleBean;
import com.pku45a.difference.module.main.model.MainRequest;
import com.pku45a.difference.module.main.model.UserPageBean;

import per.goweii.basic.core.base.BasePresenter;
import per.goweii.rxhttp.request.base.BaseBean;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.event.CollectionEvent;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.module.home.view.UserPageView;
import com.pku45a.difference.widget.CollectView;

/**
 * @author CuiZhen
 * @date 2019/10/3
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class UserPagePresenter extends BasePresenter<UserPageView> {

    public void getUserPage(int userId, int page, boolean refresh) {
        MainRequest.getUserPage(getRxLife(), refresh, userId, page, new RequestListener<UserPageBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, UserPageBean data) {
                if (isAttach()) {
                    getBaseView().getUserPageSuccess(code, data);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().getUserPageFailed(code, msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
            }
        });
    }

    public void collect(ArticleBean item, final CollectView v) {
        addToRxLife(MainRequest.collect(item.getId(), new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                item.setCollect(true);
                if (!v.isChecked()) {
                    v.toggle();
                }
                CollectionEvent.postCollectWithArticleId(item.getId());
            }

            @Override
            public void onFailed(int code, String msg) {
                if (v.isChecked()) {
                    v.toggle();
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
            }
        }));
    }

    public void uncollect(ArticleBean item, final CollectView v) {
        addToRxLife(MainRequest.uncollect(item.getId(), new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                item.setCollect(false);
                if (v.isChecked()) {
                    v.toggle();
                }
                CollectionEvent.postUnCollectWithArticleId(item.getId());
            }

            @Override
            public void onFailed(int code, String msg) {
                if (!v.isChecked()) {
                    v.toggle();
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
            }
        }));
    }
}
