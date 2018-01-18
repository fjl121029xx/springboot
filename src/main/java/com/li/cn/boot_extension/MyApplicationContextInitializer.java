package com.li.cn.boot_extension;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("#### bean count : " + applicationContext.getBeanDefinitionCount());

        ConfigurableListableBeanFactory factory = applicationContext.getBeanFactory();

    }
}
