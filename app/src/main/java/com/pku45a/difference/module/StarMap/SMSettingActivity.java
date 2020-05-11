package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.base.BaseView;
import per.goweii.basic.ui.dialog.TipDialog;
import per.goweii.basic.utils.file.CacheUtils;
import per.goweii.basic.utils.listener.SimpleCallback;
import com.pku45a.difference.R;
import com.pku45a.difference.http.WanCache;
import com.pku45a.difference.module.mine.presenter.MinePresenter;

public class SMSettingActivity extends BaseActivity<MinePresenter> implements BaseView {
    @BindView(R.id.sm_setting_clear_memory)
    RelativeLayout clearMemoryLayout;

    @BindView(R.id.sm_setting_share)
    RelativeLayout shareLayout;

    @BindView(R.id.sm_setting_text_memory)
    TextView memoryTextView;

    @BindView(R.id.sm_setting_logout)
    Button logoutButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMSettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_setting;
    }

    @Nullable
    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                String size = CacheUtils.getTotalCacheSize();
                if (!emitter.isDisposed()) {
                    emitter.onNext(size);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                presenter.addToRxLife(d);
            }

            @Override
            public void onNext(String size) {
                memoryTextView.setText(size);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

        clearMemoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipDialog.with(getContext())
                        .message("确定要清除缓存吗？")
                        .onYes(new SimpleCallback<Void>() {
                            @Override
                            public void onResult(Void data) {
                                clearCache();
                            }
                        })
                        .show();
            }
        });

        shareLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipDialog.with(getContext())
                        .message("确定要退出登录吗？")
                        .onYes(new SimpleCallback<Void>() {
                            @Override
                            public void onResult(Void data) {
                                logout();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void share() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "星图");
        shareIntent = Intent.createChooser(shareIntent, "星图");
        startActivity(shareIntent);
    }

    private void clearCache() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                CacheUtils.clearAllCache();
                String size = CacheUtils.getTotalCacheSize();
                WanCache.getInstance().openDiskLruCache();
                if (!emitter.isDisposed()) {
                    emitter.onNext(size);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                presenter.addToRxLife(d);
            }

            @Override
            public void onNext(String size) {
                memoryTextView.setText(size);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void logout() {
        SharedPreferences sp = getContext().getSharedPreferences("StarMap", Context.MODE_PRIVATE);
        if (sp.contains("User")) {
            sp.edit().remove("User").commit();
        }
        Intent intent = new Intent(getContext(), WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }
}
