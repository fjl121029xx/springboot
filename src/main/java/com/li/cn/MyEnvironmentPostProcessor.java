package com.li.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 配置文件集中化管理
 * 动态获取配置文件
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        try {

            FileInputStream is = new FileInputStream("D:/springboot.properties");
            Properties source = new Properties();
            source.load(is);

            PropertySource<?> propertySource = new PropertiesPropertySource("my", source);
            environment.getPropertySources().addLast(propertySource);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
