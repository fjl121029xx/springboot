package com.li.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@RestController
@EnableAutoConfiguration
public class SpringBootSampleApplication {

    @RequestMapping("/")
    String home() {

        return "Hello World";
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
