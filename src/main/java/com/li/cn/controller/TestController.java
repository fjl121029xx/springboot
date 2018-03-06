package com.li.cn.controller;

import com.li.cn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/test/home")
    public String home() {

        return "test home";
    }

    @GetMapping("/test/show")
    public String show(@RequestParam("id") Integer id) {

        return "test home";
    }
}
