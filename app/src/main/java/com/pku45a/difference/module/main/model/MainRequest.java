package com.pku45a.difference.module.main.model;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import io.reactivex.disposables.Disposable;
import per.goweii.rxhttp.core.RxLife;
import per.goweii.rxhttp.request.base.BaseBean;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.http.WanCache;

/**
 * @author CuiZhen
 * @date 2019/5/16
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class MainRequest extends BaseRequest {

    public static Disposable collect(int id, @NonNull RequestListener<BaseBean> listener) {
        return request(WanApi.api().collect(id), listener);
    }

    public static Disposable collect(String title, String author, String link, @NonNull RequestListener<ArticleBean> listener) {
        return request(WanApi.api().collect(title, author, link), listener);
    }

    public static Disposable collect(String title, String link, @NonNull RequestListener<CollectionLinkBean> listener) {
        return request(WanApi.api().collect(title, link), listener);
    }

    public static Disposable uncollect(int id, @NonNull RequestListener<BaseBean> listener) {
        return request(WanApi.api().uncollect(id), listener);
    }

    public static Disposable uncollectLink(int id, @NonNull RequestListener<BaseBean> listener) {
        return request(WanApi.api().uncollectLink(id), listener);
    }

    public static Disposable uncollect(int id, int originId, @NonNull RequestListener<BaseBean> listener) {
        return request(WanApi.api().uncollect(id, originId), listener);
    }

    public static void update(RxLife rxLife, @NonNull RequestListener<UpdateBean> listener) {
        rxLife.add(request(WanApi.api().update(), listener));
    }

    public static void getConfig(RxLife rxLife, @NonNull RequestListener<ConfigBean> listener) {
        rxLife.add(request(WanApi.api().getConfig(), listener));
    }

    public static void getUserArticleList(RxLife rxLife, boolean refresh, @IntRange(from = 0) int page, @NonNull RequestListener<ArticleListBean> listener) {
        if (page == 0) {
            cacheAndNetBean(rxLife,
                    WanApi.api().getUserArticleList(page),
                    refresh,
                    WanCache.CacheKey.USER_ARTICLE_LIST(page),
                    ArticleListBean.class,
                    listener);
        } else {
            rxLife.add(request(WanApi.api().getUserArticleList(page), listener));
        }
    }

    public static void getUserPage(RxLife rxLife, boolean refresh, int userId, @IntRange(from = 1) int page, @NonNull RequestListener<UserPageBean> listener) {
        if (page == 1) {
            cacheAndNetBean(rxLife,
                    WanApi.api().getUserPage(userId, page),
                    refresh,
                    WanCache.CacheKey.USER_PAGE(userId, page),
                    UserPageBean.class,
                    listener);
        } else {
            rxLife.add(request(WanApi.api().getUserPage(userId, page), listener));
        }
    }

    public static Disposable shareArticle(String title, String link, @NonNull RequestListener<BaseBean> listener) {
        return request(WanApi.api().shareArticle(title, link), listener);
    }

}
