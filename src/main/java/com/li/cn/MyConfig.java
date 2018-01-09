package com.li.cn;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class MyConfig {

    @Bean
    public List createList() {

        return new ArrayList();
    }

    @Bean
    public Runnable createRunnable() {

        System.out.println("======1======");
        return () -> {
        };
    }
    @Bean
    @Profile("dev")
    public Runnable createRunnable2() {

        System.out.println("======1======");
        return () -> {
        };
    }
    //指定--spring.profiles.active=test 生效
    @Bean
    @Profile("test")
    public Runnable createRunnable3() {

        System.out.println("======1======");
        return () -> {
        };
    }

}
