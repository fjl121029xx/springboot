package com.li.cn.enableAutoConfiguration_deep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Cat createCat() {

        return new Cat();
    }

    @Bean
    public Dog createDog() {

        return new Dog();
    }
}
