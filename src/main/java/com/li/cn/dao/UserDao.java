package com.li.cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void add(String username, String password) {

        System.out.println("username : " + username + ",password : " + password + "");
    }
}
