package com.zhuandian.apptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuandian.apptest.pojo.UserEntity;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
public interface UserService extends IService<UserEntity> {
    Response addNewUser(UserEntity userEntity);

    Response login(String userName, String passWord);
}
