package com.li.cn.enable_theory;

import org.springframework.context.annotation.Bean;

public class MyConfiguration {

    @Bean
    public Runnable createRunable6() {

        return () -> {
        };
    }
}
