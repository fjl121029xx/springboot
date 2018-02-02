package com.li.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/reg")
    public String reg() {


        return "reg";
    }

    @GetMapping("/shop")
    public String shop(Model model) {

        model.addAttribute("userIconUrl","abc.com");
        return "shop";
    }
}
