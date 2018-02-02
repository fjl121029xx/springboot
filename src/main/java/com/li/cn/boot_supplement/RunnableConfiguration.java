package com.li.cn.boot_supplement;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class RunnableConfiguration {

    @Bean
    public Runnable creatRunnable9() {

        return () -> {

        };
    }
}
