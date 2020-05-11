package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageCommentRecommentEntity extends BaseBean {
    private String recomment_name;
    private String recomment_content;

    public String getRecomment_name() {
        return recomment_name;
    }

    public void setRecomment_name(String recomment_name) {
        this.recomment_name = recomment_name;
    }

    public String getRecomment_content() {
        return recomment_content;
    }

    public void setRecomment_content(String recomment_content) {
        this.recomment_content = recomment_content;
    }

    public String getRecomment_userid() {
        return recomment_userid;
    }

    public void setRecomment_userid(String recomment_userid) {
        this.recomment_userid = recomment_userid;
    }

    private String recomment_userid;
}
