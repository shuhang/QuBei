package com.pku45a.difference.module.login.view;

import com.pku45a.difference.module.login.model.LoginBean;

import per.goweii.basic.core.base.BaseView;

/**
 * @author CuiZhen
 * @date 2019/5/15
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public interface RegisterView extends BaseView {
    void registerSuccess(int code, LoginBean data);
    void registerFailed(int code, String msg);
}
