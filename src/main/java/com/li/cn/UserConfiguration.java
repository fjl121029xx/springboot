package com.li.cn;

import com.google.gson.Gson;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class UserConfiguration {

    @Bean
    @ConditionalOnProperty(name = "runnable.enabled", havingValue = "true")
    public Runnable createRunnable3() {

        return () -> {
        };
    }

    /**
     * 表示classpath中存在某个class的时候才装配
     *
     * @return
     */
    @Bean
    @ConditionalOnClass(name = "com.google.gson.Gson")
    public Runnable createRunnable4() {

        return () -> {

        };
    }

    @Bean
    @ConditionalOnBean(name = "user")
    public Runnable createRunnable5() {

        return () -> {

        };
    }
}
