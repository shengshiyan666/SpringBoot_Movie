package com.zhuandian.apptest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@Data
@TableName("user")
public class UserEntity {
    private long id;
    private String userName;
    private String passWord;
    private int isBlack;
    private int isvip;
}
