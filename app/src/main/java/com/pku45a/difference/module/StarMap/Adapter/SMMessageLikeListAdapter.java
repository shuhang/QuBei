package com.pku45a.difference.module.StarMap.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.utils.ImageLoader;

import com.pku45a.difference.R;

import com.pku45a.difference.module.StarMap.Modal.SMMessageCommentEntity;

public class SMMessageLikeListAdapter extends BaseQuickAdapter<SMMessageCommentEntity, BaseViewHolder> {
    public interface LikeCommentItemListener {
        void clickBottomUser(String userId);
        void clickTopUser(String userId);
    }

    private SMMessageLikeListAdapter.LikeCommentItemListener messageListener;

    public void setMessageListener(SMMessageLikeListAdapter.LikeCommentItemListener listener) {
        this.messageListener = listener;
    }

    public SMMessageLikeListAdapter() {
        super(R.layout.sm_message_like_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMMessageCommentEntity entity) {
        ImageView topHeadImageView = helper.getView(R.id.sm_message_like_cell_top_image_head);
        ImageLoader.userIcon(topHeadImageView, entity.getComment().getComment_usericon());
        topHeadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickTopUser(entity.getComment().getComment_userid());
                }
            }
        });

        TextView topNameTextView = helper.getView(R.id.sm_message_like_cell_top_text_name);
        topNameTextView.setText(entity.getComment().getComment_name());

        TextView topTimeTextView = helper.getView(R.id.sm_message_like_cell_top_text_time);
        topTimeTextView.setText(Tool.getShowTime(entity.getTime()));

        TextView topInfoTextView = helper.getView(R.id.sm_message_like_cell_top_text_info);
        topInfoTextView.setText("赞了你的动态");

        ImageView bottomHeadImageView = helper.getView(R.id.sm_message_like_cell_bottom_image_head);
        ImageLoader.userIcon(bottomHeadImageView, entity.getNews().getUser_icon());

        TextView bottomNameTextView = helper.getView(R.id.sm_message_like_cell_bottom_text_name);
        bottomNameTextView.setText(entity.getNews().getUser_name());
        bottomNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickBottomUser(entity.getNews().getUser_id());
                }
            }
        });

        TextView bottomTimeTextView = helper.getView(R.id.sm_message_like_cell_bottom_text_time);
        bottomTimeTextView.setText(Tool.getShowTime(entity.getNews().getNews_title()));
    }
}
