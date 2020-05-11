package com.pku45a.difference.module.StarMap.Adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.utils.ImageLoader;

import java.util.Date;

import com.pku45a.difference.R;
import com.pku45a.difference.module.StarMap.Modal.SMFocusUserEntity;

public class SMFocusUserListAdapter extends BaseQuickAdapter<SMFocusUserEntity, BaseViewHolder> {
    public interface FocusUserItemListener {
        void clickHonor(String userId);
        void clickRisk(String userId);
        void clickFocus(int index);
    }

    private FocusUserItemListener messageListener;

    public void setMessageListener(FocusUserItemListener listener) {
        this.messageListener = listener;
    }

    public SMFocusUserListAdapter() {
        super(R.layout.sm_focus_user_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMFocusUserEntity entity) {
        ImageView headImageView = helper.getView(R.id.sm_focus_user_head);
        ImageLoader.userIcon(headImageView, entity.getUser_icon());

        TextView nameTextView = helper.getView(R.id.sm_focus_user_name);
        nameTextView.setText(entity.getUser_name());

        TextView tagTextView = helper.getView(R.id.sm_focus_user_tag);
        Date nowDate = new Date();
        long diff = nowDate.getTime() - Long.valueOf(entity.getRegisterdate()) * 1000;
        if(diff > 0) {
            long month = diff / (1000 * 60 * 60 * 24);
            month = month / 30;
            if(month > 0) {
                if(month > 12) {
                    tagTextView.setText(month / 12 + "年前来到Star");
                }
                else {
                    tagTextView.setText(month + "个月前来到Star");
                }
            }
            else  {
                long day = diff / (1000 * 60 * 60 * 24);
                if(day > 0) {
                    tagTextView.setText(day + "天前来到Star");
                }
                else {
                    long hour = (diff-day*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                    tagTextView.setText(hour + "个小时前来到Star");
                }
            }
        }

        RelativeLayout layoutChangeType = helper.getView(R.id.sm_focus_user_layout_change_type);
        layoutChangeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickHonor(entity.getUser_id());
                }
            }
        });

        RelativeLayout layoutRisk = helper.getView(R.id.sm_focus_user_layout_risk);
        layoutRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickRisk(entity.getUser_id());
                }
            }
        });

        Button focusButton = helper.getView(R.id.sm_focus_user_focus);
        if(entity.getFocus() == 0) {
            focusButton.setBackgroundResource(R.drawable.corner_bg_solid_blue_15);
            focusButton.setText("关注");
            focusButton.setTextColor(Color.parseColor("#5B99EE"));
        }
        else {
            focusButton.setBackgroundResource(R.drawable.corner_bg_blue_15);
            focusButton.setText("已关注");
            focusButton.setTextColor(Color.WHITE);
        }
        focusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(messageListener != null) {
                    messageListener.clickFocus(helper.getLayoutPosition());
                }
            }
        });
    }
}
