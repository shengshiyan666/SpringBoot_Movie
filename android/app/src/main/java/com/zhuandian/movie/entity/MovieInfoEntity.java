package com.zhuandian.movie.entity;

import java.io.Serializable;

/**
 * desc:
 * author: xiedong
 * date: 3/25/21
 **/
public class MovieInfoEntity implements Serializable {
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

    public String getRowAndColumValue() {
        return rowAndColumValue;
    }

    public void setRowAndColumValue(String rowAndColumValue) {
        this.rowAndColumValue = rowAndColumValue;
    }

    public String getSeatInfoStr() {
        return seatInfoStr;
    }

    public void setSeatInfoStr(String seatInfoStr) {
        this.seatInfoStr = seatInfoStr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public String getMovieLocation() {
        return movieLocation;
    }

    public void setMovieLocation(String movieLocation) {
        this.movieLocation = movieLocation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public double getTicketMoney() {
        return ticketMoney;
    }

    public void setTicketMoney(double ticketMoney) {
        this.ticketMoney = ticketMoney;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }
}
