package com.pku45a.difference.module.knowledge.model;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.http.WanCache;
import com.pku45a.difference.module.main.model.ArticleListBean;
import com.pku45a.difference.module.main.model.ChapterBean;

import java.util.List;

import per.goweii.rxhttp.core.RxLife;

/**
 * @author CuiZhen
 * @date 2019/5/12
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class KnowledgeRequest extends BaseRequest {

    public static void getKnowledgeListCache(@NonNull RequestListener<List<ChapterBean>> listener) {
        cacheList(WanCache.CacheKey.KNOWLEDGE_LIST,
                ChapterBean.class,
                listener);
    }

    public static void getKnowledgeList(RxLife rxLife, @NonNull RequestListener<List<ChapterBean>> listener) {
        cacheAndNetList(rxLife,
                WanApi.api().getKnowledgeList(),
                true,
                WanCache.CacheKey.KNOWLEDGE_LIST,
                ChapterBean.class,
                listener);
    }

    public static void getKnowledgeArticleListCache(int id, @IntRange(from = 0) int page, @NonNull RequestListener<ArticleListBean> listener) {
        cacheBean(WanCache.CacheKey.KNOWLEDGE_ARTICLE_LIST(id, page),
                ArticleListBean.class,
                listener);
    }

    public static void getKnowledgeArticleList(RxLife rxLife, boolean refresh, int id, @IntRange(from = 0) int page, @NonNull RequestListener<ArticleListBean> listener) {
        if (page == 0) {
            cacheAndNetBean(rxLife,
                    WanApi.api().getKnowledgeArticleList(page, id),
                    refresh,
                    WanCache.CacheKey.KNOWLEDGE_ARTICLE_LIST(id, page),
                    ArticleListBean.class,
                    listener);
        } else {
            rxLife.add(request(WanApi.api().getKnowledgeArticleList(page, id), listener));
        }
    }

}
