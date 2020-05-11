package com.pku45a.difference.module.QB.Modal;

import com.pku45a.difference.module.QB.QBUserEntity;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBHeartResponseLeave extends BaseBean {
    private QBUserEntity friend_info;

    public QBUserEntity getFriend_info() {
        return friend_info;
    }

    public void setFriend_info(QBUserEntity friend_info) {
        this.friend_info = friend_info;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    private long time;
    private String location_name;
}
