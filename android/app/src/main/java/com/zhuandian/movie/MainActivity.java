package com.zhuandian.movie;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zhuandian.movie.adapter.MovieItemAdapter;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.business.activity.HistoryActivity;
import com.zhuandian.movie.business.activity.MoreMovieActivity;
import com.zhuandian.movie.business.login.LoginActivity;
import com.zhuandian.movie.entity.MovieInfoEntity;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.et_keyword)
    EditText etKeyword;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_keyword)
    LinearLayout llKeyword;
    private List<MovieInfoEntity> mDatas = new ArrayList<>();
    private MovieItemAdapter movieItemAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        this.setTitle("");
        movieItemAdapter = new MovieItemAdapter(mDatas, this);
        rvList.setAdapter(movieItemAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                    initData();
                }
            }
        });
        initData();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.addSubMenu("购票记录");
        menu.addSubMenu("更多电影");
        menu.addSubMenu("注销登录");

        return super.onCreateOptionsMenu(menu);
    }

    //    选项菜单的菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "购票记录":
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case "更多电影":
                startActivity(new Intent(this, MoreMovieActivity.class));
                break;
            case "注销登录":
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
        return true;
    }


    private void initData() {
        etKeyword.setText("");
        Observable observable = getApi().getAllInfoList();
        HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<List<MovieInfoEntity>>() {
            @Override
            public void onSuccess(List<MovieInfoEntity> result) {
                mDatas.clear();
                mDatas.addAll(result);
                movieItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


    @OnClick({R.id.tv_search, R.id.btn_time_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                getSearchByKeyword();
                break;
            case R.id.btn_time_search:
                getSearchByDate();
                break;
        }
    }

    private void getSearchByDate() {
        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {
                long maxDate = datePicker.getMaxDate();//日历最大能设置的时间的毫秒值
                int year = datePicker.getYear();//年
                int month = datePicker.getMonth();//月-1
                int dayOfMonth1 = datePicker.getDayOfMonth();//日
                //iyear:年，monthOfYear:月-1，dayOfMonth:日
//                Toast.makeText(getApplicationContext(), iyear +":"+ (monthOfYear+1)+":"+dayOfMonth , Toast.LENGTH_LONG).show();

                String date = String.format("%d-%02d-%02d", iyear, (monthOfYear + 1), dayOfMonth);
                getSearchByDate(date);
            }
        }, 2021, 2, 25);//2021:初始年份，2：初始月份-1 ，1：初始日期
        dp.show();
    }

    private void getSearchByDate(String date) {
        Toast.makeText(activity, "搜索中...", Toast.LENGTH_SHORT).show();
        Observable observable = getApi().getMovieByDate(date);
        HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<List<MovieInfoEntity>>() {
            @Override
            public void onSuccess(List<MovieInfoEntity> result) {
                mDatas.clear();
                mDatas.addAll(result);
                movieItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e) {

            }
        });


    }


    private void getSearchByKeyword() {
        String s = etKeyword.getText().toString();
        if (s.length() < 1) {
            Toast.makeText(activity, "请输入关键字...", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(activity, "搜索中...", Toast.LENGTH_SHORT).show();
        Observable observable = getApi().getMovieByKeyWord(s);
        HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<List<MovieInfoEntity>>() {
            @Override
            public void onSuccess(List<MovieInfoEntity> result) {
                mDatas.clear();
                mDatas.addAll(result);
                movieItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e) {

            }
        });


    }
}