package com.zhuandian.movie.network;

import com.zhuandian.movie.entity.MovieInfoEntity;
import com.zhuandian.movie.entity.UserEntity;
import com.zhuandian.network.HttpEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * desc:
 * author: xiedong
 * date: 3/1/21
 **/
public interface Api {
    @GET("/getAllInfoList")
    Observable<HttpEntity<List<MovieInfoEntity>>> getAllInfoList();

    @GET("/getMovieByKeyWord")
    Observable<HttpEntity<List<MovieInfoEntity>>> getMovieByKeyWord(@Query("keyWord") String keyword);


    @GET("/getMovieByDate")
    Observable<HttpEntity<List<MovieInfoEntity>>> getMovieByDate(@Query("date") String keyword);

    @POST("/login")
    Observable<HttpEntity<UserEntity>> login(@Body UserEntity userEntity);


    @POST("/addNewUser")
    Observable<HttpEntity<String>> addNewUser(@Body UserEntity userEntity);

    @POST("/updateMovieById")
    Observable<HttpEntity<Integer>> updateMovieById(@Body MovieInfoEntity movieInfoEntity);
}
