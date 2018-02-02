package com.li.cn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/role/show")
    public String show() {

        return "role show";
    }
}
