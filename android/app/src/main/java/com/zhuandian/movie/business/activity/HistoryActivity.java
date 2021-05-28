package com.zhuandian.movie.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.movie.R;
import com.zhuandian.movie.adapter.MovieItemAdapter;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.entity.MovieInfoEntity;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import io.reactivex.Observable;

public class HistoryActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<MovieInfoEntity> mDatas = new ArrayList<>();
    private MovieItemAdapter movieItemAdapter;
    private SharedPreferences sharedPreferences;
    private Set<String> movieId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void setUpView() {
        this.setTitle("购票记录");
        sharedPreferences = getSharedPreferences("movie", Context.MODE_PRIVATE);

        movieId = sharedPreferences.getStringSet("movieId", null);
        if (movieId == null) {
            Toast.makeText(activity, "暂时没有购票记录...", Toast.LENGTH_SHORT).show();
            return;
        }
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

    private void initData() {
        Observable observable = getApi().getAllInfoList();
        HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<List<MovieInfoEntity>>() {
            @Override
            public void onSuccess(List<MovieInfoEntity> result) {
                mDatas.clear();
                List<MovieInfoEntity> tempList = new ArrayList<>();
                for (MovieInfoEntity infoEntity : result) {
                    if (movieId.contains(infoEntity.getId() + "")) {
                        tempList.add(infoEntity);
                    }

                }

                mDatas.addAll(tempList);
                movieItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

}