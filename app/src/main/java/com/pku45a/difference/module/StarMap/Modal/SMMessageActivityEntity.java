package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageActivityEntity extends BaseBean {
    private SMMessageActivityNewsEntity news;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public SMMessageActivityNewsEntity getNews() {
        return news;
    }

    public void setNews(SMMessageActivityNewsEntity news) {
        this.news = news;
    }
}
