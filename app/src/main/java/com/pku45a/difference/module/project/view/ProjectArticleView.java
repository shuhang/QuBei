package com.pku45a.difference.module.project.view;

import per.goweii.basic.core.base.BaseView;
import com.pku45a.difference.module.main.model.ArticleListBean;

/**
 * @author CuiZhen
 * @date 2019/5/12
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public interface ProjectArticleView extends BaseView {
    void getProjectArticleListSuccess(int code, ArticleListBean data);
    void getProjectArticleListFailed(int code, String msg);
}
