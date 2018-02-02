package com.li.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

/**
 * @GetMapping
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    @ResponseBody
    public String home() {

        return "user home";
    }


    @ResponseBody
    @PostMapping("/user/show")
    public String show() {

        return "user show";
    }

    @ResponseBody
    @GetMapping("/user/create")
    public String create(@RequestParam(value = "useame") String username,
                         @RequestParam(value = "password") String password) {

        System.out.println("username : " + username + " , password : " + password);
        return "user create";
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public String display(@PathVariable("id") Integer id) {

        System.out.println("user display : id = " + id.toString());
        return "user displat";
    }

    @ResponseBody
    @GetMapping("/user/edit")
    public String edit(HttpServletRequest request) {

        System.out.println(request.getRequestURL());
        return "user request " + request.getRemoteHost();
    }
}
