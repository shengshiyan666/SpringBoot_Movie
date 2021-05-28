package com.zhuandian.apptest;

import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.MovieInfoService;
import com.zhuandian.apptest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import utils.Response;

@SpringBootTest
class ApptestApplicationTests {

    @Autowired
    MovieInfoService movieInfoService;

    //	@Test
    void contextLoads() {

    }


    //登录测试方法
    void testLogin() {
    }

    //注册测试方法
    void testRegister() {
    }


    //添加新电影
    void testInsertMovie() {
    }

    //获取所有电影列表
    void testGetAllMovieList() {
    }


    //更新电影信息
    void testUpdateMovie() {
    }

    //	@Test
    void testGetThisWeekMoney() {

    }

    /**
     * 根据关键字搜索电影
     */
//	@Test
    void getMovieByKeyWord() {
        movieInfoService.getMovieByDate("流浪");
    }


	/**
	 * 根据日期检索电影
	 */
//	@Test
    void getMovieByDate() {
        movieInfoService.getMovieByDate("2021-02-03");
    }

	/**
	 * 检索制定时间段内段电影
	 */
//	@Test
	void getMovieByTime() {
		movieInfoService.getMovieByTime("2021-02-05","2021-02-07");
	}
}
