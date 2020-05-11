package com.pku45a.difference.module.QB.Modal;

import com.pku45a.difference.module.QB.QBUserEntity;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBLoginResponse extends BaseBean {
    public QBUserEntity getUser_info() {
        return user_info;
    }

    public void setUser_info(QBUserEntity user_info) {
        this.user_info = user_info;
    }

    private QBUserEntity user_info;
}
