package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMFocusUserEntity extends BaseBean {
    private String user_id;
    private String user_name;
    private String user_icon;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public String getUser_tag() {
        return user_tag;
    }

    public void setUser_tag(String user_tag) {
        this.user_tag = user_tag;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public int getGlory_level() {
        return glory_level;
    }

    public void setGlory_level(int glory_level) {
        this.glory_level = glory_level;
    }

    private String user_tag;
    private String registerdate;
    private String addtime;
    private int glory_level;

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    private int focus = 0;
}
