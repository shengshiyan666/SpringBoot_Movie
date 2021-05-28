package com.zhuandian.apptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuandian.apptest.pojo.MovieInfoEntity;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
public interface MovieInfoService extends IService<MovieInfoEntity> {
    Response insertMovieInfo(MovieInfoEntity movieInfoEntity);

    Response getAllInfoList();


    /**
     * 查看每周收入，整体和每部电影
     * @return
     */
    Response getThisWeekMoney();


    /**
     * 根据关键字检索电影
     * @param keyWord
     * @return
     */
    Response getMovieByKeyWord(String keyWord);

    /**
     * 根据日期检索电影
     * @param date
     * @return
     */
    Response getMovieByDate(String date);


    /**
     * 查看指定时间段内段电影
     * @param startTime
     * @param endTime
     * @return
     */
    Response getMovieByTime(String startTime,String endTime);


    /**
     * 根据id查询电影
     * @param id
     * @return
     */
    Response getMovieById(long id);




    /**
     * 更新电影信息
     * @return
     */
    Response updateMovieById(MovieInfoEntity movieInfoEntity);


    /**
     * 删除电影
     * @return
     */
    Response deleteMovieById(long id);
}
