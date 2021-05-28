package com.zhuandian.apptest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * desc:
 * author: xiedong
 * date: 2/25/21
 **/
@Data
@TableName("movie_info")
public class MovieInfoEntity {
    private long id;
    private String movieName;
    private String author;
    private String awards;
    private String actor;
    private String movieDesc;
    private String movieImgUrl;
    private String movieLocation;
    private String startTime;
    private int ticketCount;
    private double ticketMoney;
    private String createAt;
    private String updateAt;
    private int sellCount;
    private String rowAndColumValue;
    private String seatInfoStr;
}
