package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import java.util.List;

import per.goweii.basic.core.base.BaseView;

public interface MyView extends BaseView {
    void getHomeListSuccess(int code, List<HomeEntity> datas);
}
