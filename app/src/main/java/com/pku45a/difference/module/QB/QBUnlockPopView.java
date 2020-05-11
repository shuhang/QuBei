package com.pku45a.difference.module.QB;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.pku45a.difference.R;

import per.goweii.anylayer.DialogLayer;

public class QBUnlockPopView extends DialogLayer {
    private Context tempContext;

    public static QBUnlockPopView create(Context context) {
        return new QBUnlockPopView(context);
    }

    private QBUnlockPopView(Context context) {
        super(context);

        tempContext = context;
        contentView(R.layout.qb_unlock_pop);
    }

    @Override
    public void onShow() {
        super.onShow();

        Button acceptButton = getView(R.id.qb_unlock_pop_button_unlock);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tempContext, QBBuyActivity.class);
                intent.putExtra("pay", true);
                ((Activity)tempContext).startActivityForResult(intent, 200);
                dismiss(true);
            }
        });

        Button cancelButton = getView(R.id.qb_unlock_pop_button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(true);
            }
        });
    }
}
