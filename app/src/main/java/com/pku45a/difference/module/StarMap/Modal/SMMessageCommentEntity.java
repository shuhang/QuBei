package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageCommentEntity extends BaseBean {
    private SMMessageCommentCommentEntity comment;
    private SMMessageCommentRecommentEntity recomment;

    public SMMessageCommentCommentEntity getComment() {
        return comment;
    }

    public void setComment(SMMessageCommentCommentEntity comment) {
        this.comment = comment;
    }

    public SMMessageCommentRecommentEntity getRecomment() {
        return recomment;
    }

    public void setRecomment(SMMessageCommentRecommentEntity recomment) {
        this.recomment = recomment;
    }

    public SMMessageCommentNewsEntity getNews() {
        return news;
    }

    public void setNews(SMMessageCommentNewsEntity news) {
        this.news = news;
    }

    private SMMessageCommentNewsEntity news;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
}
