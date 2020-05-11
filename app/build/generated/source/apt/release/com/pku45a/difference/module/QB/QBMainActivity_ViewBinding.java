// Generated code from Butter Knife. Do not modify!
package com.pku45a.difference.module.QB;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amap.api.maps2d.MapView;
import com.pku45a.difference.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QBMainActivity_ViewBinding implements Unbinder {
  private QBMainActivity target;

  @UiThread
  public QBMainActivity_ViewBinding(QBMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QBMainActivity_ViewBinding(QBMainActivity target, View source) {
    this.target = target;

    target.addButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_add, "field 'addButton'", Button.class);
    target.locationButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_location, "field 'locationButton'", Button.class);
    target.mineButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_mine, "field 'mineButton'", Button.class);
    target.topAddButton = Utils.findRequiredViewAsType(source, R.id.qb_main_top_button_add, "field 'topAddButton'", Button.class);
    target.functionButton = Utils.findRequiredViewAsType(source, R.id.qb_main_button_function, "field 'functionButton'", Button.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.qb_main_top_list1, "field 'listView'", RecyclerView.class);
    target.mMapView = Utils.findRequiredViewAsType(source, R.id.map, "field 'mMapView'", MapView.class);
    target.locationTextView = Utils.findRequiredViewAsType(source, R.id.qb_main_top_location, "field 'locationTextView'", TextView.class);
    target.distanceTextView = Utils.findRequiredViewAsType(source, R.id.qb_main_top_text_distance, "field 'distanceTextView'", TextView.class);
    target.layoutDistance = Utils.findRequiredViewAsType(source, R.id.qb_main_top_layout_distance, "field 'layoutDistance'", RelativeLayout.class);
    target.layoutWarning = Utils.findRequiredViewAsType(source, R.id.qb_mine_top_warning, "field 'layoutWarning'", RelativeLayout.class);
    target.warningTextView = Utils.findRequiredViewAsType(source, R.id.qb_mine_text_warning, "field 'warningTextView'", TextView.class);
    target.timeTextView = Utils.findRequiredViewAsType(source, R.id.qb_main_time, "field 'timeTextView'", TextView.class);
    target.layoutNotice = Utils.findRequiredViewAsType(source, R.id.qb_main_layout_notice, "field 'layoutNotice'", RelativeLayout.class);
    target.layoutFunction = Utils.findRequiredViewAsType(source, R.id.qb_main_layout_function, "field 'layoutFunction'", RelativeLayout.class);
    target.layoutLongtime = Utils.findRequiredViewAsType(source, R.id.qb_main_layout_long_time, "field 'layoutLongtime'", RelativeLayout.class);
    target.longtimeTextView = Utils.findRequiredViewAsType(source, R.id.qb_main_long_time_text, "field 'longtimeTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QBMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.addButton = null;
    target.locationButton = null;
    target.mineButton = null;
    target.topAddButton = null;
    target.functionButton = null;
    target.listView = null;
    target.mMapView = null;
    target.locationTextView = null;
    target.distanceTextView = null;
    target.layoutDistance = null;
    target.layoutWarning = null;
    target.warningTextView = null;
    target.timeTextView = null;
    target.layoutNotice = null;
    target.layoutFunction = null;
    target.layoutLongtime = null;
    target.longtimeTextView = null;
  }
}
