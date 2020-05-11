package com.pku45a.difference.module.project.view;

import java.util.List;

import per.goweii.basic.core.base.BaseView;
import com.pku45a.difference.module.main.model.ChapterBean;

/**
 * @author CuiZhen
 * @date 2019/5/12
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public interface ProjectView extends BaseView {
    void getProjectChaptersSuccess(int code, List<ChapterBean> data);
    void getProjectChaptersFailed(int code, String msg);
}
