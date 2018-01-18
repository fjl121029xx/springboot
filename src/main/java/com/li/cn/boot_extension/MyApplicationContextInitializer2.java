package com.li.cn.boot_extension;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitializer2 implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {


        ConfigurableListableBeanFactory factory = applicationContext.getBeanFactory();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {

            System.out.print(name + "\t");
        }

    }
}
