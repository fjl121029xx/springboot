package com.li.cn.controller;

import com.li.cn.pojo.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    /**
     * @return
     */
    @RequestMapping
    public String hello() {

        return "Hello spring-boot";
    }

    @RequestMapping("/map")
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三丰");
        map.put("age", 17);

        return map;
    }

    @RequestMapping("/list")
    public List<Object> list() {
        List<Object> l = new ArrayList<>();
        l.add("捻花功");
        l.add("无妄神功");

        return l;
    }

    @RequestMapping("/findStus")
    @ResponseBody
    public Object findStus() {
        List<Student> stus = new ArrayList<>();
        Student s = new Student();
        s.setId(1);
        s.setName("张三");
        s.setAge(23);
        s.setMarried(false);

        stus.add(s);

        return stus;

    }

}
