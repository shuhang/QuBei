// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.StarMap;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SMMineFragment_ViewBinding implements Unbinder {
  private SMMineFragment target;

  private View view2131231427;

  private View view2131231435;

  private View view2131231419;

  private View view2131231430;

  private View view2131231421;

  private View view2131231431;

  private View view2131231423;

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
    view2131231427 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_vote_record, "method 'onClick'");
    view2131231435 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_black_record, "method 'onClick'");
    view2131231419 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_report_record, "method 'onClick'");
    view2131231430 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_feedback, "method 'onClick'");
    view2131231421 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_setting, "method 'onClick'");
    view2131231431 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sm_mine_focus_layout, "method 'onClick'");
    view2131231423 = view;
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

    view2131231427.setOnClickListener(null);
    view2131231427 = null;
    view2131231435.setOnClickListener(null);
    view2131231435 = null;
    view2131231419.setOnClickListener(null);
    view2131231419 = null;
    view2131231430.setOnClickListener(null);
    view2131231430 = null;
    view2131231421.setOnClickListener(null);
    view2131231421 = null;
    view2131231431.setOnClickListener(null);
    view2131231431 = null;
    view2131231423.setOnClickListener(null);
    view2131231423 = null;
  }
}
