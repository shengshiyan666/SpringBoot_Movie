package com.zhuandian.movie.entity;

/**
 * desc:
 * author: xiedong
 * date: 3/22/21
 **/

public class UserEntity {
    private String userName;
    private String passWord;
    private int age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
