package com.li.cn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person/home")
    public String home() {

        return "person home";
    }

    @GetMapping("/person/help")
    public String help() {

        int i = 10 / 0;
        return "person home";
    }
}
