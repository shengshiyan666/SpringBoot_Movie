package com.zhuandian.movie.base;


import com.zhuandian.movie.network.Api;

/**
 * desc:
 * author: xiedong
 **/
abstract public class BaseActivity extends com.zhuandian.base.BaseActivity {

    @Override
    protected <T> T getBaseApiClass() {
        return (T) Api.class;
    }

    @Override
    protected String getBaseUrl() {
        return "http://192.168.43.181:8080/";
    }

    public Api getApi(){
        return activity.getApiService();
    }
}
