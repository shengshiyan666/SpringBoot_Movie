package com.zhuandian.apptest.controller;

import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public Response getUserById(@RequestParam("id") long id) {
        UserEntity userEntity = userService.getById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("data", userEntity);
        return Response.ok(map);
    }


    @GetMapping("/getAllUser")
    public Response getAllUser() {
        List<UserEntity> list = userService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);
        return Response.ok(map);
    }

    @PostMapping("/addNewUser")
    public Response addNewUser(@RequestBody UserEntity userEntity) {
        return userService.addNewUser(userEntity);
    }

    @PostMapping("/login")
    public Response login(@RequestBody UserEntity userEntity) {
        return userService.login(userEntity.getUserName(),userEntity.getPassWord());
    }
}
