package com.zhuandian.apptest.controller;

import com.zhuandian.apptest.pojo.MovieInfoEntity;
import com.zhuandian.apptest.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
@RestController
public class MovieInfoController {

    @Autowired
    MovieInfoService movieInfoService;

    @PostMapping("/insertMovieInfo")
    public Response insertMovieInfo(@RequestBody MovieInfoEntity movieInfoEntity) {
        return movieInfoService.insertMovieInfo(movieInfoEntity);
    }

    @GetMapping("/getAllInfoList")
    public Response getAllInfoList() {
        return movieInfoService.getAllInfoList();
    }


    @GetMapping("/getThisWeekMoney")
    public Response getThisWeekMoney() {
        return movieInfoService.getThisWeekMoney();
    }


    @GetMapping("/getMovieByKeyWord")
    public Response getMovieByKeyWord(@RequestParam("keyWord") String keyWord) {
        return movieInfoService.getMovieByKeyWord(keyWord);
    }

    @GetMapping("/getMovieByDate")
    public Response getMovieByDate(@RequestParam("date") String date) {
        return movieInfoService.getMovieByDate(date);
    }


    @GetMapping("/getMovieByTime")
    public Response getMovieByTime(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) {
        return movieInfoService.getMovieByTime(startTime, endTime);
    }

    @GetMapping("/getMovieById")
    public Response getMovieById(@RequestParam("id") long id) {
        return movieInfoService.getMovieById(id);
    }

    @PostMapping("/updateMovieById")
    public Response updateMovieById(@RequestBody MovieInfoEntity movieInfoEntity) {
        return movieInfoService.updateMovieById(movieInfoEntity);
    }


    @GetMapping("/deleteMovieById")
    public Response deleteMovieById(@RequestParam("id") long id){
        return movieInfoService.deleteMovieById(id);
    }

}
