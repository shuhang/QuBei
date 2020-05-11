package com.pku45a.difference.module.QB.Modal;

import com.pku45a.difference.module.QB.QBUserEntity;

import java.util.List;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBHeartResponse extends BaseBean {
    private QBUserEntity user_info;
    private QBHeartResponseFriend inviation;

    public QBUserEntity getUser_info() {
        return user_info;
    }

    public void setUser_info(QBUserEntity user_info) {
        this.user_info = user_info;
    }

    public QBHeartResponseFriend getInviation() {
        return inviation;
    }

    public void setInviation(QBHeartResponseFriend inviation) {
        this.inviation = inviation;
    }

    public List<QBUserEntity> getFriends() {
        return friends;
    }

    public void setFriends(List<QBUserEntity> friends) {
        this.friends = friends;
    }

    public QBHeartResponseLeave getLeave_reminder() {
        return leave_reminder;
    }

    public void setLeave_reminder(QBHeartResponseLeave leave_reminder) {
        this.leave_reminder = leave_reminder;
    }

    private List<QBUserEntity> friends;
    private QBHeartResponseLeave leave_reminder;
}
