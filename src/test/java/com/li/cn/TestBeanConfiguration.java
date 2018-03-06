package com.li.cn;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestBeanConfiguration {

    @Bean
    public Runnable createRunnable() {

        return () -> {
        };
    }
}
