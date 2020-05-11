// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMineFragment_ViewBinding implements Unbinder {
  private SMMineFragment target;

  private View view2131231388;

  private View view2131231396;

  private View view2131231380;

  private View view2131231391;

  private View view2131231382;

  private View view2131231392;

  private View view2131231384;

  @UiThread
  public SMMineFragment_ViewBinding(final SMMineFragment target, View source) {
    this.target = target;

    View view;
    target.headImageView = Utils.findRequiredViewAsType(source, R.id.sm_mine_head, "field 'headImageView'", ImageView.class);
    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_name, "field 'nameTextView'", TextView.class);
    target.tagTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_tag, "field 'tagTextView'", TextView.class);
    target.rankImageView = Utils.findRequiredViewAsType(source, R.id.sm_mine_rank_image, "field 'rankImageView'", ImageView.class);
    target.feedTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_feed_count, "field 'feedTextView'", TextView.class);
    target.focusTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_focus_count, "field 'focusTextView'", TextView.class);
    target.changeTypeTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_text_change_type, "field 'changeTypeTextView'", TextView.class);
    target.riskTextView = Utils.findRequiredViewAsType(source, R.id.sm_mine_text_risk, "field 'riskTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sm_mine_like_record, "method 'onClick'");
    view2131231388 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_vote_record, "method 'onClick'");
    view2131231396 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_black_record, "method 'onClick'");
    view2131231380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_report_record, "method 'onClick'");
    view2131231391 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_feedback, "method 'onClick'");
    view2131231382 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_setting, "method 'onClick'");
    view2131231392 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_focus_layout, "method 'onClick'");
    view2131231384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SMMineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headImageView = null;
    target.nameTextView = null;
    target.tagTextView = null;
    target.rankImageView = null;
    target.feedTextView = null;
    target.focusTextView = null;
    target.changeTypeTextView = null;
    target.riskTextView = null;

    view2131231388.setOnClickListener(null);
    view2131231388 = null;
    view2131231396.setOnClickListener(null);
    view2131231396 = null;
    view2131231380.setOnClickListener(null);
    view2131231380 = null;
    view2131231391.setOnClickListener(null);
    view2131231391 = null;
    view2131231382.setOnClickListener(null);
    view2131231382 = null;
    view2131231392.setOnClickListener(null);
    view2131231392 = null;
    view2131231384.setOnClickListener(null);
    view2131231384 = null;
  }
}
