package com.pku45a.difference.module.StarMap.Adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.module.StarMap.Modal.SMMessageDetailEntity;

import com.pku45a.difference.R;

public class SMMessageSystemListAdapter extends BaseQuickAdapter<SMMessageDetailEntity, BaseViewHolder> {
    public SMMessageSystemListAdapter() {
        super(R.layout.sm_message_system_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMMessageDetailEntity entity) {
        TextView timeTextView = helper.getView(R.id.sm_message_system_cell_time);
        timeTextView.setText(Tool.getShowTime(entity.getTime()));

        TextView infoTextView = helper.getView(R.id.sm_message_system_cell_info);
        infoTextView.setText(entity.getContent());
    }
}
