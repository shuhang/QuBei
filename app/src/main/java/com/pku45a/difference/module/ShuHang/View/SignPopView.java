package com.pku45a.difference.module.ShuHang.View;

import android.animation.Animator;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import per.goweii.anydialog.AnimHelper;
import per.goweii.anydialog.AnyDialog;
import per.goweii.anydialog.IAnim;
import com.pku45a.difference.R;

public class SignPopView {
    private static final long ANIM_DURATION = 200;
    private final Context context;
    private AnyDialog mAnyDialog;
    private int count = 0;

    private SignPopView(Context context) {
        this.context = context;
    }

    public static SignPopView with(Context context) {
        return new SignPopView(context);
    }

    public void show() {
        if (count <= 0) {
            count = 0;
            mAnyDialog = AnyDialog.with(context)
                    .contentView(R.layout.sign_pop_view)
                    .cancelableOnClickKeyBack(false)
                    .cancelableOnTouchOutside(false)
                    .gravity(Gravity.CENTER)
                    .contentAnim(new IAnim() {
                        @Override
                        public Animator inAnim(View target) {
                            return AnimHelper.createZoomInAnim(target).setDuration(ANIM_DURATION);
                        }

                        @Override
                        public Animator outAnim(View target) {
                            return AnimHelper.createZoomOutAnim(target).setDuration(ANIM_DURATION);
                        }
                    });
            Button confirmButton = (Button)mAnyDialog.getContentView().findViewById(R.id.sign_pop_view_confirm);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
            mAnyDialog.show();
        }
        count++;
    }

    public void dismiss() {
        count--;
        if (count <= 0) {
            clear();
        }
    }

    public void clear() {
        if (mAnyDialog != null) {
            mAnyDialog.dismiss();
            mAnyDialog = null;
        }
        count = 0;
    }
}
