package com.pku45a.difference.module.QB.Modal;

import com.pku45a.difference.module.QB.QBUserEntity;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBHeartResponseFriend extends BaseBean {
    public QBUserEntity getFriend() {
        return friend;
    }

    public void setFriend(QBUserEntity friend) {
        this.friend = friend;
    }

    private QBUserEntity friend;
}
