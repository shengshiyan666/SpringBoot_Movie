package com.zhuandian.apptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuandian.apptest.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
