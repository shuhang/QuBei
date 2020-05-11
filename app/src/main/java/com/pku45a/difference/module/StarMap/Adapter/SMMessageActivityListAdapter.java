package com.pku45a.difference.module.StarMap.Adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.utils.ImageLoader;

import com.pku45a.difference.R;

import com.pku45a.difference.module.StarMap.Modal.SMMessageActivityEntity;

public class SMMessageActivityListAdapter extends BaseQuickAdapter<SMMessageActivityEntity, BaseViewHolder> {
    public SMMessageActivityListAdapter() {
        super(R.layout.sm_message_activity_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMMessageActivityEntity entity) {
        ImageView imageView = helper.getView(R.id.sm_message_activity_cell_image);
        ImageLoader.userIcon(imageView, entity.getNews().getNews_img());

        TextView timeTextView = helper.getView(R.id.sm_message_activity_cell_time);
        timeTextView.setText(Tool.getShowTime(entity.getTime()));

        TextView titleTextView = helper.getView(R.id.sm_message_activity_cell_title);
        titleTextView.setText(entity.getNews().getNews_title());

        TextView infoTextViw = helper.getView(R.id.sm_message_activity_cell_info);
        infoTextViw.setText(entity.getNews().getNews_content());
    }
}
