package com.zhuandian.movie.business.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuandian.movie.R;
import com.zhuandian.movie.adapter.SeatAdapter;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.entity.MovieInfoEntity;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * desc:
 * author: xiedong
 * date: 3/26/21
 **/
public class SelectedTicketActivity extends BaseActivity {
    @BindView(R.id.rv_movie_seat)
    RecyclerView rvMovieSeat;
    @BindView(R.id.btn_pay)
    Button btnPay;
    private MovieInfoEntity movieInfoEntity;
    private SeatAdapter adapter;
    private List<Integer> seatList;
    private int rows = 0;
    private int totalCount = 0;
    private SharedPreferences sharedPreferences;
    private Set<String> movieId;
    private int buyCount = 0;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_selected_ticket;
    }

    @Override
    protected void setUpView() {
        movieInfoEntity = ((MovieInfoEntity) getIntent().getSerializableExtra("entity"));

        sharedPreferences = getSharedPreferences("movie", Context.MODE_PRIVATE);

        movieId = sharedPreferences.getStringSet("movieId", null);


        if (movieInfoEntity.getSeatInfoStr() == null) {
            String[] split = movieInfoEntity.getRowAndColumValue().split(",");
            rows = Integer.parseInt(split[0]);
            totalCount = Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
            seatList = new ArrayList<>();
            for (int i = 0; i < totalCount; i++) {
                seatList.add(0);
            }
        } else {
            String[] split = movieInfoEntity.getRowAndColumValue().split(",");
            rows = Integer.parseInt(split[0]);
            totalCount = Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
            String seatInfoStr = movieInfoEntity.getSeatInfoStr();
            String[] strings = seatInfoStr.split(",");
            seatList = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                seatList.add(Integer.parseInt(strings[i]));
            }
        }


        adapter = new SeatAdapter(seatList, this, rows);
        rvMovieSeat.setAdapter(adapter);
        rvMovieSeat.setLayoutManager(new GridLayoutManager(this, rows));
        adapter.setOnItemClickListener(new SeatAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int value, int position) {
                if (value == 1) {
                    Toast.makeText(activity, "该座位已被预定...", Toast.LENGTH_SHORT).show();
                    return;
                }
                seatList.set(position, 1);
                buyCount++;
                adapter.notifyDataSetChanged();
            }
        });
    }


    @OnClick(R.id.btn_pay)
    public void onClick() {

        int age = getSharedPreferences("movie", Context.MODE_PRIVATE).getInt("age", 0);
        boolean isDiscount = (age < 16 || age > 65);
        new AlertDialog.Builder(this)
                .setTitle(isDiscount ? "你符合优惠政策" : "你不符合优惠政策")
                .setMessage(String.format("当前一共购买%d张票，需要支付%.2f", buyCount, buyCount * movieInfoEntity.getTicketMoney() * (isDiscount ? 0.8 : 1)))
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        updateMovieInfo();
                        dialog.cancel();
                    }
                })
                .create().show();
    }

    private void updateMovieInfo() {
        String seatInfoStr = "";
        for (Integer integer : seatList) {
            seatInfoStr += integer.intValue() + ",";
        }
        seatInfoStr = seatInfoStr.substring(0, seatInfoStr.length() - 1);
        movieInfoEntity.setSeatInfoStr(seatInfoStr);
        Observable observable = getApi().updateMovieById(movieInfoEntity);
        HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                if (result.intValue() == 1) {
                    Toast.makeText(activity, "购票成功", Toast.LENGTH_SHORT).show();
                    if (movieId == null) {
                        movieId = new HashSet<>();
                    }
                    movieId.add(movieInfoEntity.getId() + "");
                    sharedPreferences.edit().putStringSet("movieId", movieId).commit();
                }
            }

            @Override
            public void onError(Exception e) {
                String message = e.getMessage();
            }
        });
    }
}
