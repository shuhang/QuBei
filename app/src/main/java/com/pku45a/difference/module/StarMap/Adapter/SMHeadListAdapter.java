package com.pku45a.difference.module.StarMap.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pku45a.difference.utils.ImageLoader;

import com.pku45a.difference.R;
import com.pku45a.difference.module.StarMap.Modal.SMHeadIconItemEntity;

public class SMHeadListAdapter extends BaseQuickAdapter<SMHeadIconItemEntity, BaseViewHolder>{
    public interface HeadClickItemListener {
        void clickHeadIcon(String imageUrl, String imageName);
    }

    private HeadClickItemListener headListener;

    public void setHeadListener(HeadClickItemListener headListener) {
        this.headListener = headListener;
    }

    public SMHeadListAdapter() {
        super(R.layout.sm_head_list_cell);
    }

    @Override
    protected void convert(BaseViewHolder helper, SMHeadIconItemEntity entity) {
        RelativeLayout layout1 = (RelativeLayout)helper.getView(R.id.sm_head_list_cell_layout1);
        ImageView imageView1 = (ImageView)helper.getView(R.id.sm_head_list_cell_layout1_image);
        TextView textView1 = (TextView)helper.getView(R.id.sm_head_list_cell_layout1_text);
        ImageLoader.userIcon(imageView1, entity.getIconList().get(0).getHeadpic_img());
        textView1.setText(entity.getIconList().get(0).getHeadpic_name());
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(headListener != null) {
                    headListener.clickHeadIcon(entity.getIconList().get(0).getHeadpic_img(), entity.getIconList().get(0).getHeadpic_name());
                }
            }
        });

        RelativeLayout layout2 = (RelativeLayout)helper.getView(R.id.sm_head_list_cell_layout2);
        if(entity.getIconList().size() > 1) {
            layout2.setVisibility(View.VISIBLE);
            ImageView imageView2 = (ImageView)helper.getView(R.id.sm_head_list_cell_layout2_image);
            TextView textView2 = (TextView)helper.getView(R.id.sm_head_list_cell_layout2_text);
            ImageLoader.userIcon(imageView2, entity.getIconList().get(1).getHeadpic_img());
            textView2.setText(entity.getIconList().get(1).getHeadpic_name());
            layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(headListener != null) {
                        headListener.clickHeadIcon(entity.getIconList().get(1).getHeadpic_img(), entity.getIconList().get(1).getHeadpic_name());
                    }
                }
            });
        }
        else  {
            layout2.setVisibility(View.INVISIBLE);
            layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        RelativeLayout layout3 = (RelativeLayout)helper.getView(R.id.sm_head_list_cell_layout3);
        if(entity.getIconList().size() > 2) {
            layout3.setVisibility(View.VISIBLE);
            ImageView imageView3 = (ImageView)helper.getView(R.id.sm_head_list_cell_layout3_image);
            TextView textView3 = (TextView)helper.getView(R.id.sm_head_list_cell_layout3_text);
            ImageLoader.userIcon(imageView3, entity.getIconList().get(2).getHeadpic_img());
            textView3.setText(entity.getIconList().get(2).getHeadpic_name());
            layout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(headListener != null) {
                        headListener.clickHeadIcon(entity.getIconList().get(2).getHeadpic_img(), entity.getIconList().get(2).getHeadpic_name());
                    }
                }
            });
        }
        else  {
            layout3.setVisibility(View.INVISIBLE);
            layout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
