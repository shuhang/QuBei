package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageActivityNewsEntity extends BaseBean {
    private String news_id;
    private String news_title;
    private String news_content;
    private String news_url;
    private String news_img;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getNews_img() {
        return news_img;
    }

    public void setNews_img(String news_img) {
        this.news_img = news_img;
    }
}
