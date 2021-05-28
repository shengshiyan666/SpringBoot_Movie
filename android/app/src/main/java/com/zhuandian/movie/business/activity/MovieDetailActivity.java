package com.zhuandian.movie.business.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuandian.movie.R;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.entity.MovieInfoEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * desc:
 * author: xiedong
 * date: 3/26/21
 **/
public class MovieDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_actor)
    TextView tvActor;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_buy_ticket)
    TextView tvBuyTicket;
    @BindView(R.id.iv_movie)
    ImageView ivMovie;
    @BindView(R.id.tv_movie_local)
    TextView tvMovieLocal;
    private MovieInfoEntity movieInfoEntity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void setUpView() {
        movieInfoEntity = ((MovieInfoEntity) getIntent().getSerializableExtra("entity"));
        initData(movieInfoEntity);
    }

    private void initData(MovieInfoEntity movieInfoEntity) {
        Glide.with(this).load(movieInfoEntity.getMovieImgUrl()).into(ivMovie);
        tvTitle.setText(movieInfoEntity.getMovieName());
        tvDesc.setText(movieInfoEntity.getMovieDesc());
        tvActor.setText("主演:" + movieInfoEntity.getActor());
        tvTime.setText("上映时间：" + movieInfoEntity.getStartTime());
        tvPrice.setText("¥" + movieInfoEntity.getTicketMoney());
        tvMovieLocal.setText(movieInfoEntity.getMovieLocation());
    }


    @OnClick(R.id.tv_buy_ticket)
    public void onClick() {
        Intent intent = new Intent(this, SelectedTicketActivity.class);
        intent.putExtra("entity", movieInfoEntity);
        startActivity(intent);
    }
}
