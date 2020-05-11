package com.pku45a.difference.module.mine.view;

import per.goweii.basic.core.base.BaseView;
import com.pku45a.difference.module.main.model.ArticleListBean;

/**
 * @author CuiZhen
 * @date 2019/5/17
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public interface MineShareView extends BaseView {
    void getMineShareArticleListSuccess(int code, ArticleListBean data);

    void getMineShareArticleListFailed(int code, String msg);
}