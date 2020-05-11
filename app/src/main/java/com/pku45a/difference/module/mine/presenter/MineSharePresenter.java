package com.pku45a.difference.module.mine.presenter;

import per.goweii.basic.core.base.BasePresenter;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.base.BaseBean;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import com.pku45a.difference.event.ArticleDeleteEvent;
import com.pku45a.difference.event.CollectionEvent;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.module.main.model.ArticleBean;
import com.pku45a.difference.module.main.model.MainRequest;
import com.pku45a.difference.module.main.model.UserPageBean;
import com.pku45a.difference.module.mine.model.MineRequest;
import com.pku45a.difference.module.mine.view.MineShareView;
import com.pku45a.difference.widget.CollectView;

/**
 * @author CuiZhen
 * @date 2019/5/17
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class MineSharePresenter extends BasePresenter<MineShareView> {

    public void getMineShareArticleList(int page, boolean refresh) {
        MineRequest.getMineShareArticleList(getRxLife(), refresh, page, new RequestListener<UserPageBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, UserPageBean data) {
                if (isAttach()) {
                    getBaseView().getMineShareArticleListSuccess(code, data.getShareArticles());
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttach()) {
                    getBaseView().getMineShareArticleListFailed(code, msg);
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

    public void deleteMineShareArticle(ArticleBean item) {
        addToRxLife(MineRequest.deleteMineShareArticle(item.getId(), new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                ArticleDeleteEvent.postWithArticleId(item.getId());
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg);
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
            }
        }));
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
        addToRxLife(MainRequest.uncollect(item.getId(), item.getOriginId(), new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                if (v.isChecked()) {
                    v.toggle();
                }
                CollectionEvent.postUncollect(item.getOriginId(), item.getId());
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
