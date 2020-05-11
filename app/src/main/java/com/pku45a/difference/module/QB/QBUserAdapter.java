package com.pku45a.difference.module.QB;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.R;

public class QBUserAdapter extends BaseQuickAdapter<QBUserEntity, BaseViewHolder> {
    public QBUserAdapter() {
        super(R.layout.qb_main_user_cell2);
    }

    @Override
    protected void convert(BaseViewHolder helper, QBUserEntity entity) {
        ImageView bgImageView = helper.getView(R.id.qb_main_user_cell2_temp);
        ImageView headImageView = helper.getView(R.id.qb_main_user_cell2_image);
        TextView nameTextView = helper.getView(R.id.qb_main_user_cell2_text);
        TextView symbolTextView = helper.getView(R.id.qb_main_user_cell2_symbol);

        if(entity.isChoosed()) {
            bgImageView.setVisibility(View.VISIBLE);
        }
        else {
            bgImageView.setVisibility(View.INVISIBLE);
        }

        headImageView.setImageResource(entity.getImageId());
        nameTextView.setText(entity.getNick_name());

        if(entity.getRelation() != null && entity.getRelation().equals("wait")) {
            symbolTextView.setVisibility(View.VISIBLE);
        }
        else {
            symbolTextView.setVisibility(View.INVISIBLE);
        }
    }
}
