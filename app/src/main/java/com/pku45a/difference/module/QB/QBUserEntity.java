package com.pku45a.difference.module.QB;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBUserEntity extends BaseBean {
    private String user_id;
    private String nick_name;
    private double latitude;
    private double longitude;
    private long location_update_time;
    private String battery;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getLocation_update_time() {
        return location_update_time;
    }

    public void setLocation_update_time(long location_update_time) {
        this.location_update_time = location_update_time;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }

    public long getVip_end_time() {
        return vip_end_time;
    }

    public void setVip_end_time(long vip_end_time) {
        this.vip_end_time = vip_end_time;
    }

    private String relation;
    private String phone;
    private boolean is_vip;
    private long vip_end_time;

    public boolean isChoosed() {
        return choosed;
    }

    public void setChoosed(boolean choosed) {
        this.choosed = choosed;
    }

    private boolean choosed = false;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private int imageId;

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    private int imageIndex;

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    private String location_name;
}
