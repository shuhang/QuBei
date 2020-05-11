package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageCommentCommentEntity extends BaseBean {
    private String comment_name;
    private String comment_content;
    private String comment_time;
    private String comment_usericon;

    public String getComment_name() {
        return comment_name;
    }

    public void setComment_name(String comment_name) {
        this.comment_name = comment_name;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_usericon() {
        return comment_usericon;
    }

    public void setComment_usericon(String comment_usericon) {
        this.comment_usericon = comment_usericon;
    }

    public String getComment_userid() {
        return comment_userid;
    }

    public void setComment_userid(String comment_userid) {
        this.comment_userid = comment_userid;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    private String comment_userid;
    private String comment_id;
}
