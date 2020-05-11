package com.pku45a.difference.module.StarMap.Adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.pku45a.difference.R;
import com.pku45a.difference.module.StarMap.Modal.SMMessageListEntity;

public class SMMessageListAdapter extends BaseQuickAdapter<SMMessageListEntity, BaseViewHolder> {
    public SMMessageListAdapter() {
        super(R.layout.sm_message_list_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMMessageListEntity entity) {
        ImageView imageView = helper.getView(R.id.sm_message_list_cell_image);
        imageView.setImageResource(entity.getImageResoureId());

        TextView textView = helper.getView(R.id.sm_message_list_cell_text);
        textView.setText(entity.getName());
    }
}
