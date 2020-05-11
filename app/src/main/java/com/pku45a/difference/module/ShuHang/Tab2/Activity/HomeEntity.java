package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import java.util.List;

import per.goweii.rxhttp.request.base.BaseBean;

public class HomeEntity extends BaseBean {
    private int comment_count;
    private String user_icon;
    private int glory_level;
    private String news_content;
    private String news_time;
    private int support_state;
    private String registerdate;
    private List<HomeImageEntity> imglist;
    private int user_id;
    private int news_id;
    private String type;
    private String user_name;
    private String user_tag;
    private int support_count;

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public int getGlory_level() {
        return glory_level;
    }

    public void setGlory_level(int glory_level) {
        this.glory_level = glory_level;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public int getSupport_state() {
        return support_state;
    }

    public void setSupport_state(int support_state) {
        this.support_state = support_state;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public List<HomeImageEntity> getImglist() {
        return imglist;
    }

    public void setImglist(List<HomeImageEntity> imglist) {
        this.imglist = imglist;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_tag() {
        return user_tag;
    }

    public void setUser_tag(String user_tag) {
        this.user_tag = user_tag;
    }

    public int getSupport_count() {
        return support_count;
    }

    public void setSupport_count(int support_count) {
        this.support_count = support_count;
    }

    public class HomeImageEntity extends BaseBean {
        private String imgurl;
        private int img_width;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public int getImg_width() {
            return img_width;
        }

        public void setImg_width(int img_width) {
            this.img_width = img_width;
        }

        public int getImg_height() {
            return img_height;
        }

        public void setImg_height(int img_height) {
            this.img_height = img_height;
        }

        private int img_height;
    }
}
