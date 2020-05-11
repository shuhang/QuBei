package com.pku45a.difference.module.QB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pku45a.difference.R;
import com.pku45a.difference.common.Config;
import com.pku45a.difference.common.Tool;
import com.pku45a.difference.common.WanApp;
import com.pku45a.difference.http.BaseRequest;
import com.pku45a.difference.http.RequestListener;
import com.pku45a.difference.http.WanApi;
import com.pku45a.difference.module.QB.Modal.QBHeartResponse;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.MyPresenter;
import com.pku45a.difference.utils.RvAnimUtils;
import com.pku45a.difference.utils.SettingUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.toast.ToastMaker;
import per.goweii.rxhttp.request.exception.ExceptionHandle;

public class QBMainActivity extends BaseActivity<MyPresenter> implements BaseView, LocationSource,
        AMapLocationListener {
    @BindView(R.id.qb_main_button_add)
    Button addButton;

    @BindView(R.id.qb_main_button_location)
    Button locationButton;

    @BindView(R.id.qb_main_button_mine)
    Button mineButton;

    @BindView(R.id.qb_main_top_button_add)
    Button topAddButton;

    @BindView(R.id.qb_main_button_function)
    Button functionButton;

    @BindView(R.id.qb_main_top_list1)
    RecyclerView listView;

    @BindView(R.id.map)
    MapView mMapView;

    @BindView(R.id.qb_main_top_location)
    TextView locationTextView;

    @BindView(R.id.qb_main_top_text_distance)
    TextView distanceTextView;

    @BindView(R.id.qb_main_top_layout_distance)
    RelativeLayout layoutDistance;

    @BindView(R.id.qb_mine_top_warning)
    RelativeLayout layoutWarning;

    @BindView(R.id.qb_mine_text_warning)
    TextView warningTextView;

    @BindView(R.id.qb_main_time)
    TextView timeTextView;

    @BindView(R.id.qb_main_layout_notice)
    RelativeLayout layoutNotice;

    @BindView(R.id.qb_main_layout_function)
    RelativeLayout layoutFunction;

    @BindView(R.id.qb_main_layout_long_time)
    RelativeLayout layoutLongtime;

    @BindView(R.id.qb_main_long_time_text)
    TextView longtimeTextView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            heart();
        }
    };

    private AMap aMap;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;

    private QBUserAdapter adapter;
    private List<QBUserEntity> datas;
    private int choosedIndex = 0;
    private boolean preVip = false;

    private QBHeartResponse response;
    private double myLatitude = 0;
    private double myLongtitude = 0;
    private String myLocation = "";
    private List<Marker> markers = new ArrayList<Marker>();
    private boolean firstLocate = true;

    private float minZooomLevel = 8;

    private int[] imageIds = new int[]{R.mipmap.qb_user1, R.mipmap.qb_user2, R.mipmap.qb_user3, R.mipmap.qb_user4};

    public static void start(Context context) {
        Intent intent = new Intent(context, QBMainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMapView.onCreate(savedInstanceState);

        preVip = Tool.Vip;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();

        if(!preVip && Tool.Vip) {
            preVip = true;
            showVip();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
//        deactivate();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100) {
            if(Tool.Vip) {
                showVip();
            }
        }
        else if(requestCode == 200) {
            if(data != null && data.hasExtra("phone")) {
                QBUserEntity entity = new QBUserEntity();
                entity.setPhone(data.getStringExtra("phone"));
                entity.setNick_name(entity.getPhone());
                entity.setUser_id("");
                entity.setRelation("wait");
                int index = (int)(Math.random() * 4);
                entity.setImageIndex(index);
                entity.setImageId(imageIds[index]);
                datas.add(entity);
                adapter.setNewData(datas);
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.qb_main;
    }

    @Nullable
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        setUpMap();
        /////////
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });

        topAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseUser(0, true);
            }
        });

        mineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QBMineActivity.start(getContext());
            }
        });

        functionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QBBuyActivity.class);
                intent.putExtra("pay", true);
                startActivityForResult(intent, 100);
            }
        });

        layoutNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotice();
            }
        });

        SpannableStringBuilder style = new SpannableStringBuilder("长时间无法更新位置，可能是用户关机没有打开位置权限，去提醒他");
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#185CEE")), 27, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        longtimeTextView.setText(style);

        datas = new ArrayList<QBUserEntity>();
        QBUserEntity entity = new QBUserEntity();
        entity.setUser_id(Tool.User_Id);
        entity.setChoosed(true);
        entity.setPhone(Tool.Phone);
        entity.setNick_name("我");
        entity.setImageId(R.mipmap.qb_user0);
        datas.add(entity);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        listView.setLayoutManager(layoutManager);
        adapter = new QBUserAdapter();
        RvAnimUtils.setAnim(adapter, SettingUtils.getInstance().getRvAnim());
        listView.setAdapter(adapter);
        adapter.setNewData(datas);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                chooseUser(position, true);
            }
        });

        if(!Tool.Vip) {
            chooseUser(0, true);
        }
        else {
            showVip();
        }

        heart();
    }

    @Override
    protected void loadData() {

    }

    private void showReply(QBUserEntity friendEntity) {
        QBAddFriendPopView popView = QBAddFriendPopView.create(getContext(), friendEntity.getNick_name());
        popView.setHeadListener(new QBAddFriendPopView.AddFriendListener() {
            @Override
            public void clickAdd(String phone) {
                showLoadingDialog();
                BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().qbReply(Tool.User_Id, friendEntity.getUser_id(), "True"), true, "new_year/web/index.php?r=api/qubei/reply_invitation", String.class, new RequestListener<List<String>>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int code, List<String> data) {
                        popView.dismiss(true);
                        boolean exists = false;
                        for(int i = 0; i < data.size(); i ++) {
                            if(datas.get(i).getNick_name() != null && datas.get(i).getNick_name().equals(friendEntity.getNick_name())) {
                                exists = true;
                                datas.get(i).setRelation("");
                                break;
                            }
                        }
                        if(!exists) {
                            QBUserEntity entity = new QBUserEntity();
                            entity.setPhone(friendEntity.getNick_name());
                            entity.setNick_name(friendEntity.getNick_name());
                            entity.setUser_id(friendEntity.getUser_id());
                            entity.setLatitude(friendEntity.getLatitude());
                            entity.setLongitude(friendEntity.getLongitude());
                            int index = (int) (Math.random() * 4);
                            entity.setImageIndex(index);
                            entity.setImageId(imageIds[index]);
                            datas.add(entity);
                        }
                        adapter.setNewData(datas);
                        ToastMaker.showShort("添加成功", getContext());
                    }

                    @Override
                    public void onFailed(int code, String msg) {
                        ToastMaker.showShort(msg, getContext());
                    }

                    @Override
                    public void onError(ExceptionHandle handle) {
                        ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
                    }

                    @Override
                    public void onFinish() {
                        dismissLoadingDialog();
                    }
                });
            }
        });
        popView.show();
    }

    private void addFriend() {
        Intent intent = new Intent(getContext(), QBAddFriendActivity.class);
        intent.putExtra("main", true);
        startActivityForResult(intent, 200);
    }

    private void chooseUser(int index, boolean showMarker) {
        datas.get(choosedIndex).setChoosed(false);
        datas.get(index).setChoosed(true);
        adapter.setNewData(datas);
        choosedIndex = index;

        if(Tool.Vip) {
            locationTextView.setText(datas.get(choosedIndex).getLocation_name());
            if(choosedIndex == 0) {
                layoutNotice.setVisibility(View.GONE);
                distanceTextView.setText("现在");
                timeTextView.setVisibility(View.GONE);
                layoutLongtime.setVisibility(View.GONE);
            }
            else {
                layoutNotice.setVisibility(View.VISIBLE);
                timeTextView.setVisibility(View.VISIBLE);
                double meters = Tool.getDistance(myLongtitude, myLatitude, datas.get(choosedIndex).getLongitude(), datas.get(choosedIndex).getLatitude());
                java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.0");
                distanceTextView.setText(myformat.format(meters / 1000.0) + "公里 距离你");

                try {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date tempDate = new Date(datas.get(choosedIndex).getLocation_update_time() * (long)1000);
                    String timeString = df.format(tempDate);
                    timeTextView.setText("自" + timeString);
                }
                catch (Exception e) {}

                long diff = (new Date()).getTime() - datas.get(choosedIndex).getLocation_update_time() * (long)1000;
                if(diff >= 6 * 3600 * 1000) {
                    layoutLongtime.setVisibility(View.VISIBLE);
                }
                else {
                    layoutLongtime.setVisibility(View.GONE);
                }
            }
        }
        else {
            if (choosedIndex == 0) {
                locationTextView.setText(datas.get(choosedIndex).getLocation_name());
                distanceTextView.setText("现在");
                locationTextView.setVisibility(View.VISIBLE);
                layoutDistance.setVisibility(View.VISIBLE);
                warningTextView.setText("想要获取好友位置，需要先获取vip权限哦");
                functionButton.setText("去了解");
            } else {
                locationTextView.setVisibility(View.GONE);
                layoutDistance.setVisibility(View.GONE);
                warningTextView.setText("无法获取好友位置，请先获取vip权限");
                functionButton.setText("去获取");
            }
        }

        if(showMarker && aMap != null) {
            aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                    new LatLng(datas.get(choosedIndex).getLatitude(), datas.get(choosedIndex).getLongitude()), minZooomLevel, 30, 30)));
            aMap.moveCamera(CameraUpdateFactory.scrollBy(0, -300));
        }
    }

    private void showVip() {
        chooseUser(0, true);

        locationTextView.setVisibility(View.VISIBLE);
        layoutDistance.setVisibility(View.VISIBLE);
        timeTextView.setVisibility(View.VISIBLE);
        layoutWarning.setVisibility(View.GONE);
        layoutFunction.setVisibility(View.GONE);
    }

    private void addNotice() {
        showLoadingDialog();
        BaseRequest.cacheAndNetList(presenter.getRxLife(), WanApi.api().qbAddRemind(Tool.User_Id, datas.get(choosedIndex).getUser_id(), datas.get(choosedIndex).getLocation_name(), datas.get(choosedIndex).getLatitude(), datas.get(choosedIndex).getLongitude()), true, "new_year/web/index.php?r=api/qubei/add_leave_reminder", String.class, new RequestListener<List<String>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(int code, List<String> data) {
                ToastMaker.showShort("已添加提醒", getContext());
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastMaker.showShort(msg, getContext());
            }

            @Override
            public void onError(ExceptionHandle handle) {
                ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
            }

            @Override
            public void onFinish() {
                dismissLoadingDialog();
            }
        });
    }

    private void heart() {
        if(WanApp.isAppOnForeground()) {
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().qbHeartFront(Tool.User_Id, myLatitude, myLongtitude, myLocation, 0), true, "new_year/web/index.php?r=api/qubei/frontend_heartbeat", QBHeartResponse.class, new RequestListener<QBHeartResponse>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, QBHeartResponse data) {
                    response = data;
                    dealResponse();
                }

                @Override
                public void onFailed(int code, String msg) {
                    ToastMaker.showShort(msg, getContext());
                }

                @Override
                public void onError(ExceptionHandle handle) {
                    ToastMaker.showShort(Config.Common_NetWork_Error, getContext());
                }

                @Override
                public void onFinish() {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            handler.sendEmptyMessage(0);
                        }
                    }, 1000 * 60);
                }
            });
        }
        else {
            BaseRequest.cacheAndNetBean(presenter.getRxLife(), WanApi.api().qbHeartBackground(Tool.User_Id, myLatitude, myLongtitude, myLocation,0), true, "new_year/web/index.php?r=api/qubei/backend_heartbeat", QBHeartResponse.class, new RequestListener<QBHeartResponse>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(int code, QBHeartResponse data) {
                    response = data;
                    dealResponse();
                }

                @Override
                public void onFailed(int code, String msg) {

                }

                @Override
                public void onError(ExceptionHandle handle) {

                }

                @Override
                public void onFinish() {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            handler.sendEmptyMessage(0);
                        }
                    }, 1000 * 60);
                }
            });
        }
    }

    private void dealResponse() {
        if (response.getUser_info() != null && response.getUser_info().isIs_vip() && !Tool.Vip) {
            SharedPreferences sp = getContext().getSharedPreferences("QB", Context.MODE_PRIVATE);
            Tool.Vip = true;
            sp.edit().putBoolean("vip", Tool.Vip).commit();
            sp.edit().putLong("vip_time", response.getUser_info().getVip_end_time() * 1000).commit();

            showVip();
        }

        if (response.getInviation() != null && response.getInviation().getFriend() != null) {
            showReply(response.getInviation().getFriend());
        }

        List<QBUserEntity> tempDatas = new ArrayList<QBUserEntity>();
        tempDatas.add(datas.get(0));
        if(response.getFriends() != null) {
            for (int i = 0; i < response.getFriends().size(); i++) {
                if (response.getFriends().get(i).getNick_name().equals(datas.get(choosedIndex).getNick_name())) {
                    response.getFriends().get(i).setChoosed(true);
                    choosedIndex = i + 1;
                }
                tempDatas.add(response.getFriends().get(i));

                int index = (int) (Math.random() * 4);
                response.getFriends().get(i).setImageIndex(index);
                response.getFriends().get(i).setImageId(imageIds[index]);
            }
        }
        datas = tempDatas;
        adapter.setNewData(datas);

        if(Tool.Vip) {
            LatLngBounds.Builder b = LatLngBounds.builder();
            aMap.clear();
            int[] locationImageIds = new int[]{R.mipmap.qb_user_location1, R.mipmap.qb_user_location2, R.mipmap.qb_user_location3, R.mipmap.qb_user_location4};
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).getLatitude() > 0) {
                    View markerView = View.inflate(getContext(), R.layout.qb_map_marker, null);
                    ImageView imageView = markerView.findViewById(R.id.qb_map_marker_image);
                    if (i == 0) {
                        imageView.setImageResource(R.mipmap.qb_user_location0);
                    } else {
                        imageView.setImageResource(locationImageIds[datas.get(i).getImageIndex()]);
                    }
                    MarkerOptions markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                            .fromView(markerView))
                            .position(new LatLng(datas.get(i).getLatitude(), datas.get(i).getLongitude()))
                            .draggable(false);
                    Marker marker = aMap.addMarker(markerOption);
                    marker.setObject(i + "");
                    markers.add(marker);
                    b.include(new LatLng(datas.get(i).getLatitude(), datas.get(i).getLongitude()));
                }
            }
            aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(b.build(), 50));
        }

        chooseUser(choosedIndex, true);
    }
    //////////////////////
    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        aMap = mMapView.getMap();
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.getUiSettings().setMyLocationButtonEnabled(false);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false

        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                for(int i = 0; i < datas.size(); i ++) {
                    String temp = marker.getObject().toString();
                    if(marker.getObject().toString().equals(i + "")) {
                        chooseUser(i, false);
                        break;
                    }
                }
                return false;
            }
        });

        aMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                if(cameraPosition.zoom > minZooomLevel) {
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(minZooomLevel));
                }
            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {

            }
        });
    }
    /**
     * 定位成功后回调函数
     */
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation != null && amapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
                myLatitude = amapLocation.getLatitude();
                myLongtitude = amapLocation.getLongitude();
                myLocation = amapLocation.getAddress();
                datas.get(0).setLatitude(myLatitude);
                datas.get(0).setLongitude(myLongtitude);
                datas.get(0).setLocation_name(myLocation);
                Log.i("wdbcm", amapLocation.getLatitude() + "," + amapLocation.getLongitude() + "____" + amapLocation.getAddress());

                if(choosedIndex == 0) {
                    locationTextView.setText(myLocation);
                }

                if(firstLocate) {
                    firstLocate = false;
                    View markerView = View.inflate(getContext(), R.layout.qb_map_marker, null);
                    ImageView imageView = markerView.findViewById(R.id.qb_map_marker_image);
                    imageView.setImageResource(R.mipmap.qb_user_location0);
                    MarkerOptions markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                            .fromView(markerView))
                            .position(new LatLng(myLatitude, myLongtitude))
                            .draggable(false);
                    Marker marker = aMap.addMarker(markerOption);
                    marker.setObject("0");
                    markers.add(marker);
                }
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode()+ ": " + amapLocation.getErrorInfo();
                Log.e("wdbcm",errText);
            }
        }
    }

    /**
     * 激活定位
     */
    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            mLocationOption.setInterval(1000 * 10);
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();
        }
    }

    /**
     * 停止定位
     */
    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
