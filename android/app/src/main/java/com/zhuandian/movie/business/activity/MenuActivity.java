package com.zhuandian.movie.business.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhuandian.movie.MainActivity;
import com.zhuandian.movie.R;
import com.zhuandian.movie.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_menu;
    }

    @Override
    protected void setUpView() {

    }



    @OnClick({R.id.btn_ticket, R.id.btn_history})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ticket:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_history:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
        }
    }
}