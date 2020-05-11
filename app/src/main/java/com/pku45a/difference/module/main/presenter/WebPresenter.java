package com.pku45a.difference.module.main.presenter;

import android.graphics.PointF;

import per.goweii.basic.core.base.BasePresenter;
import per.goweii.rxhttp.request.base.BaseBean;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.event.CollectionEvent;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.module.main.model.ArticleBean;
import com.pku45a.difference.module.main.model.CollectionLinkBean;
import com.pku45a.difference.module.main.model.MainRequest;
import com.pku45a.difference.module.main.view.WebView;

/**
 * @author CuiZhen
 * @date 2019/5/20
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class WebPresenter extends BasePresenter<WebView> {

    public void collect(int id, PointF p) {
        addToRxLife(MainRequest.collect(id, new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                CollectionEvent.postCollectWithArticleId(id);
                if (isAttach()) {
                    getBaseView().collectSuccess(p);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }

    public void collect(String title, String author, String link, PointF p) {
        addToRxLife(MainRequest.collect(title, author, link, new RequestListener<ArticleBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, ArticleBean data) {
                CollectionEvent.postCollectWithCollectId(data.getId());
                if (isAttach()) {
                    getBaseView().collectSuccess(p);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }

    public void collect(String title, String link, PointF p) {
        addToRxLife(MainRequest.collect(title, link, new RequestListener<CollectionLinkBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, CollectionLinkBean data) {
                CollectionEvent.postCollectWithCollectId(data.getId());
                if (isAttach()) {
                    getBaseView().collectSuccess(p);
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }
}
