package com.li.cn;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class MyConfig {

    @Bean
    public List createList() {

        return new ArrayList();
    }
}
