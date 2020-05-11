package com.pku45a.difference.module.StarMap.Modal;

import java.util.List;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMFocusUserResponse extends BaseBean {
    public List<SMFocusUserEntity> getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(List<SMFocusUserEntity> friendlist) {
        this.friendlist = friendlist;
    }

    private List<SMFocusUserEntity> friendlist;
}
