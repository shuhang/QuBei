// Generated code from Butter Knife. Do not modify!
package com.yuzhix.idiom.module.knowledge.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yuzhix.idiom.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.lucode.hackware.magicindicator.MagicIndicator;
import per.goweii.actionbarex.common.ActionBarCommon;

public class KnowledgeArticleActivity_ViewBinding implements Unbinder {
  private KnowledgeArticleActivity target;

  @UiThread
  public KnowledgeArticleActivity_ViewBinding(KnowledgeArticleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public KnowledgeArticleActivity_ViewBinding(KnowledgeArticleActivity target, View source) {
    this.target = target;

    target.abc = Utils.findRequiredViewAsType(source, R.id.abc, "field 'abc'", ActionBarCommon.class);
    target.mi = Utils.findRequiredViewAsType(source, R.id.mi, "field 'mi'", MagicIndicator.class);
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    KnowledgeArticleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.abc = null;
    target.mi = null;
    target.vp = null;
  }
}
