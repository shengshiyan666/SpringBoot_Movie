package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuandian.apptest.mapper.UserMapper;
import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Response addNewUser(UserEntity userEntity) {
        int insert = userMapper.insert(userEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", insert == 1 ? "success" : "error");
        return Response.ok(map);
    }

    @Override
    public Response login(String userName, String passWord) {
        List<UserEntity> userEntity = null;
        Map<String, Object> map = new HashMap<>();
        try {
            userEntity = userMapper.selectList(new QueryWrapper<UserEntity>()
                    .eq("userName", userName)
                    .eq("passWord", passWord)
            );
        } catch (Exception e) {
            map.put("msg", "登录失败");
        }
        if (userEntity != null) {
            map.put("msg", "登录成功");
            map.put("data", userEntity.get(0));
        } else {
            map.put("msg", "登录失败");
        }

        return Response.ok(map);
    }
}
