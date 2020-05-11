package com.pku45a.difference.module.QB;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pku45a.difference.R;

import per.goweii.anylayer.DialogLayer;

public class QBAddFriendPopView extends DialogLayer {
    private Context tempContext;
    private String phoneNumber;

    public interface AddFriendListener {
        void clickAdd(String phone);
    }

    private AddFriendListener headListener;

    public void setHeadListener(AddFriendListener headListener) {
        this.headListener = headListener;
    }

    public static QBAddFriendPopView create(Context context, String phone) {
        return new QBAddFriendPopView(context, phone);
    }

    private QBAddFriendPopView(Context context, String phone) {
        super(context);

        tempContext = context;
        phoneNumber = phone;
        contentView(R.layout.qb_add_friend_pop);
    }

    @Override
    public void onShow() {
        super.onShow();

        TextView infoTextView = getView(R.id.qb_add_friend_pop_info);
        infoTextView.setText(phoneNumber + "请求添加你为好友");

        Button acceptButton = getView(R.id.qb_add_friend_pop_button_accept);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });

        Button cancelButton = getView(R.id.qb_add_friend_pop_button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(true);
            }
        });
    }

    private void addFriend() {
        if(headListener != null) {
            headListener.clickAdd(phoneNumber);
        }
    }
}
