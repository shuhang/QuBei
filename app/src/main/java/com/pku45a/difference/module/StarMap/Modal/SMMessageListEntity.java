package com.pku45a.difference.module.StarMap.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMMessageListEntity extends BaseBean {
    public int getImageResoureId() {
        return imageResoureId;
    }

    public void setImageResoureId(int imageResoureId) {
        this.imageResoureId = imageResoureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int imageResoureId;
    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int type;
    private String type_name;
    private int count;
}
