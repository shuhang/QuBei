package com.pku45a.difference.module.home.view;

import com.pku45a.difference.module.home.model.BannerBean;
import com.pku45a.difference.module.main.model.ArticleBean;
import com.pku45a.difference.module.main.model.ArticleListBean;
import com.pku45a.difference.module.main.model.ConfigBean;

import java.util.List;

import per.goweii.basic.core.base.BaseView;

/**
 * @author CuiZhen
 * @date 2019/5/12
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public interface HomeView extends BaseView {
    void allFail();
    void getBannerSuccess(int code, List<BannerBean> data);
    void getBannerFail(int code, String msg);

    void getArticleListSuccess(int code, ArticleListBean data);
    void getArticleListFailed(int code, String msg);
    void getTopArticleListSuccess(int code, List<ArticleBean> data);
    void getTopArticleListFailed(int code, String msg);

    void getConfigSuccess(ConfigBean configBean);
}
