package com.zhuandian.movie.business.activity;


import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhuandian.movie.R;
import com.zhuandian.movie.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreMovieActivity extends BaseActivity {


    @BindView(R.id.wv_movie)
    WebView wvMovie;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more_movie;
    }

    @Override
    protected void setUpView() {
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        wvMovie.getSettings().setJavaScriptEnabled(true);
        wvMovie.getSettings().setDomStorageEnabled(true);
        wvMovie.setWebViewClient(new WebViewClient());
        wvMovie.setWebChromeClient(new WebChromeClient());
        wvMovie.loadUrl("https://m.maoyan.com/#movie");
    }


}