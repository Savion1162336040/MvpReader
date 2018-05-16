package com.example.mvpreaderjava.ui.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.base.SimpleActivity;

import butterknife.BindView;

public class WebViewActivity extends SimpleActivity {
    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void onViewCreated() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setLoadsImagesAutomatically(true);
    }
}
