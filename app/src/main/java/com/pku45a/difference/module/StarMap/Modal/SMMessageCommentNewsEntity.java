package com.pku45a.difference.module.StarMap.Modal;

import java.util.List;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageCommentNewsEntity extends BaseBean {
    private String news_id;
    private String news_title;
    private List<String> news_img;
    private String user_icon;

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

    public List<String> getNews_img() {
        return news_img;
    }

    public void setNews_img(List<String> news_img) {
        this.news_img = news_img;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_name;
    private String news_time;
    private String user_id;
}
