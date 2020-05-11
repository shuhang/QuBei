package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMUserEntity extends BaseBean {
    private String user_id;
    private String user_icon;
    private String user_name;
    private String tell_number;
    private int state;
    private int glory;
    private int level;
    private int exp;
    private int risk;
    private int is_hide;
    private String user_tag;
    private int glory_level;
    private String registerdate;
    private String sign;
    private int attentionCount;

    private int isrobot;

    public int getIsrobot() {
        return isrobot;
    }

    public void setIsrobot(int isrobot) {
        this.isrobot = isrobot;
    }

    public int getChange_type() {
        return change_type;
    }

    public void setChange_type(int change_type) {
        this.change_type = change_type;
    }

    public int getApply_status() {
        return apply_status;
    }

    public void setApply_status(int apply_status) {
        this.apply_status = apply_status;
    }

    public int getNews_sendcount() {
        return news_sendcount;
    }

    public void setNews_sendcount(int news_sendcount) {
        this.news_sendcount = news_sendcount;
    }

    public int getTopic_sendcount() {
        return topic_sendcount;
    }

    public void setTopic_sendcount(int topic_sendcount) {
        this.topic_sendcount = topic_sendcount;
    }

    public int getVoice_sendcount() {
        return voice_sendcount;
    }

    public void setVoice_sendcount(int voice_sendcount) {
        this.voice_sendcount = voice_sendcount;
    }

    private int change_type;
    private int apply_status;
    private int news_sendcount;
    private int topic_sendcount;
    private int voice_sendcount;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getTell_number() {
        return tell_number;
    }

    public void setTell_number(String tell_number) {
        this.tell_number = tell_number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGlory() {
        return glory;
    }

    public void setGlory(int glory) {
        this.glory = glory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public int getIs_hide() {
        return is_hide;
    }

    public void setIs_hide(int is_hide) {
        this.is_hide = is_hide;
    }

    public String getUser_tag() {
        return user_tag;
    }

    public void setUser_tag(String user_tag) {
        this.user_tag = user_tag;
    }

    public int getGlory_level() {
        return glory_level;
    }

    public void setGlory_level(int glory_level) {
        this.glory_level = glory_level;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(int attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    private String iconName;

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    private int focus = 0;
}
