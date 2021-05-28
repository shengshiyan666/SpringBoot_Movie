package com.zhuandian.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuandian.base.BaseAdapter;
import com.zhuandian.base.BaseViewHolder;
import com.zhuandian.movie.R;
import com.zhuandian.movie.business.activity.MovieDetailActivity;
import com.zhuandian.movie.entity.MovieInfoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc:
 * author: xiedong
 * date: 3/25/21
 **/
public class MovieItemAdapter extends BaseAdapter<MovieInfoEntity, BaseViewHolder> {

    @BindView(R.id.iv_movie)
    ImageView ivMovie;
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
    @BindView(R.id.tv_movie_local)
    TextView tvMovieLocal;

    public MovieItemAdapter(List<MovieInfoEntity> mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected void converData(BaseViewHolder myViewHolder, MovieInfoEntity movieInfoEntity, int position) {
        ButterKnife.bind(this, myViewHolder.itemView);
        Glide.with(mContext).load(movieInfoEntity.getMovieImgUrl()).into(ivMovie);
        tvTitle.setText(movieInfoEntity.getMovieName());
        tvDesc.setText(movieInfoEntity.getMovieDesc());
        tvActor.setText("主演:" + movieInfoEntity.getActor());
        tvTime.setText("上映时间：" + movieInfoEntity.getStartTime());
        tvPrice.setText("¥" + movieInfoEntity.getTicketMoney());
        tvMovieLocal.setText(movieInfoEntity.getMovieLocation());

        myViewHolder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra("entity",movieInfoEntity);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_movie;
    }
}

