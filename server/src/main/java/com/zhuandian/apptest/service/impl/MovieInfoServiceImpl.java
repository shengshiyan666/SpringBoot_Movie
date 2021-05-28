package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuandian.apptest.mapper.MovieInfoMapper;
import com.zhuandian.apptest.pojo.MovieInfoEntity;
import com.zhuandian.apptest.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Response;
import utils.TimeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
@Service
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper, MovieInfoEntity> implements MovieInfoService {
    @Autowired
    MovieInfoMapper movieInfoMapper;

    @Override
    public Response insertMovieInfo(MovieInfoEntity movieInfoEntity) {
        int insert = movieInfoMapper.insert(movieInfoEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", insert == 1 ? "success" : "error");
        return Response.ok(map);
    }

    @Override
    public Response getAllInfoList() {
        List<MovieInfoEntity> movieInfoEntityList = movieInfoMapper.selectList(null);
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieInfoEntityList);
        return Response.ok(map);
    }


    @Override
    public Response getThisWeekMoney() {
        List<MovieInfoEntity> movieInfoEntityList = movieInfoMapper.selectList(null);
        Map<String, List<MovieInfoEntity>> resultList = movieInfoEntityList.stream().collect(Collectors.groupingBy(MovieInfoEntity::getMovieName));


        double thisWeekMoney = 0.0;
        double totalMoney = 0.0;


        for (MovieInfoEntity movieInfoEntity : movieInfoEntityList) {
            totalMoney += movieInfoEntity.getSellCount() * movieInfoEntity.getTicketMoney();

            if (TimeUtils.isThisWeek(Long.parseLong(TimeUtils.date2TimeStamp(movieInfoEntity.getStartTime())))) {
                thisWeekMoney += movieInfoEntity.getSellCount() * movieInfoEntity.getTicketMoney();
            }
        }


        List<List<MovieInfoEntity>> movieGroup = new ArrayList<>();
        for (Map.Entry<String, List<MovieInfoEntity>> entry : resultList.entrySet()) {
            movieGroup.add(entry.getValue());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        map.put("thisWeekMoney", thisWeekMoney);
        map.put("totalMoney", totalMoney);
        map.put("movieGroup", movieGroup);


        return Response.ok(map);
    }

    @Override
    public Response getMovieByKeyWord(String keyWord) {
        List<MovieInfoEntity> movieInfoEntityList = movieInfoMapper.selectList(new QueryWrapper<MovieInfoEntity>()
                .like("movieName", keyWord));
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieInfoEntityList);
        return Response.ok(map);
    }

    @Override
    public Response getMovieByDate(String date) {
        List<MovieInfoEntity> movieInfoEntityList = movieInfoMapper.selectList(new QueryWrapper<MovieInfoEntity>()
                .like("startTime", date));
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieInfoEntityList);
        return Response.ok(map);
    }

    @Override
    public Response getMovieByTime(String startTime, String endTime) {
        List<MovieInfoEntity> movieInfoEntityList = movieInfoMapper.selectList(new QueryWrapper<MovieInfoEntity>()
                .ge("startTime", startTime)
                .le("startTime", endTime)
        );

        Map<String, Object> map = new HashMap<>();
        map.put("data", movieInfoEntityList);
        return Response.ok(map);
    }

    @Override
    public Response getMovieById(long id) {
        MovieInfoEntity movieInfoEntity = movieInfoMapper.selectById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieInfoEntity);
        return Response.ok(map);
    }

    @Override
    public Response updateMovieById(MovieInfoEntity newMovieInfoEntity) {
        int i = movieInfoMapper.updateById(newMovieInfoEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", i);
        return Response.ok(map);
    }

    @Override
    public Response deleteMovieById(long id) {
        int i = movieInfoMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("data", i);
        return Response.ok(map);
    }
}
