package com.pku45a.difference.module.StarMap.Adapter;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.module.StarMap.Modal.SMMessageCommentEntity;
import com.pku45a.difference.utils.ImageLoader;

import com.pku45a.difference.R;

public class SMMessageCommentListAdapter extends BaseQuickAdapter<SMMessageCommentEntity, BaseViewHolder> {
    public interface MessageCommentItemListener {
        void clickReply(SMMessageCommentEntity entity);
        void clickUser(String userId);
        void clickTopUser(String userId);
    }

    private MessageCommentItemListener messageListener;

    public void setMessageListener(MessageCommentItemListener listener) {
        this.messageListener = listener;
    }

    public SMMessageCommentListAdapter() {
        super(R.layout.sm_message_comment_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMMessageCommentEntity entity) {
        ImageView topHeadImageView = helper.getView(R.id.sm_message_comment_cell_top_image_head);
        ImageLoader.userIcon(topHeadImageView, entity.getComment().getComment_usericon());
        topHeadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickUser(entity.getComment().getComment_userid());
                }
            }
        });

        TextView topNameTextView = helper.getView(R.id.sm_message_comment_cell_top_text_name);
        topNameTextView.setText(entity.getComment().getComment_name());

        TextView topTimeTextView = helper.getView(R.id.sm_message_comment_cell_top_text_time);
        topTimeTextView.setText(Tool.getShowTime(entity.getComment().getComment_time()));

        TextView topInfoTextView = helper.getView(R.id.sm_message_comment_cell_top_text_info);
        topInfoTextView.setText("回复了你的评论:" + entity.getComment().getComment_content());

        TextView centerTextView = helper.getView(R.id.sm_message_comment_cell_center_text_info);
        if(entity.getRecomment() != null) {
            String showName = "";
            int index1 = 0;
            if (entity.getRecomment().getRecomment_name() != null) {
                showName += entity.getRecomment().getRecomment_name();
                index1 = entity.getRecomment().getRecomment_name().length();
            }
            showName += ":";
            if (entity.getRecomment().getRecomment_content() != null) {
                showName += entity.getRecomment().getRecomment_content();
            }
            SpannableStringBuilder style = new SpannableStringBuilder(showName);
            style.setSpan(new ForegroundColorSpan(Color.parseColor("#5B99EE")), 0, index1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (showName.length() > 1) {
                style.setSpan(new ForegroundColorSpan(Color.BLACK), index1 + 1, showName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            centerTextView.setText(style);
        }
        else {
            centerTextView.setText("");
        }

        ImageView bottomHeadImageView = helper.getView(R.id.sm_message_comment_cell_bottom_image_head);
        ImageLoader.userIcon(bottomHeadImageView, entity.getNews().getUser_icon());

        TextView bottomNameTextView = helper.getView(R.id.sm_message_comment_cell_bottom_text_name);
        bottomNameTextView.setText(entity.getNews().getUser_name());
        bottomNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickUser(entity.getNews().getUser_id());
                }
            }
        });

        TextView bottomTimeTextView = helper.getView(R.id.sm_message_comment_cell_bottom_text_time);
        bottomTimeTextView.setText(Tool.getShowTime(entity.getNews().getNews_title()));

        Button buttonReply = helper.getView(R.id.sm_message_comment_cell_top_button_reply);
        buttonReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickReply(entity);
                }
            }
        });
    }
}
