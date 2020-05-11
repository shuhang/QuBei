package com.pku45a.difference.module.StarMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.basic.core.base.BaseActivity;
import per.goweii.basic.core.mvp.MvpPresenter;
import com.pku45a.difference.R;

public class SMWebActivity extends BaseActivity {
    @BindView(R.id.sm_webview_webview)
    WebView webView;

    @BindView(R.id.abc)
    ActionBarCommon actionBarCommon;

    public static void start(Context context) {
        Intent intent = new Intent(context, SMWebActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sm_webview;
    }

    @Nullable
    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(getIntent().getStringExtra("url"));
        actionBarCommon.getTitleTextView().setText(getIntent().getStringExtra("title"));
    }

    @Override
    protected void loadData() {

    }
}
