package com.pku45a.difference.module.StarMap.Modal;

import java.util.List;

import per.goweii.rxhttp.request.base.BaseBean;

public class SMHeadIconItemEntity extends BaseBean {
    public List<SMHeadIconEntity> getIconList() {
        return iconList;
    }

    public void setIconList(List<SMHeadIconEntity> iconList) {
        this.iconList = iconList;
    }

    private List<SMHeadIconEntity> iconList;
}
