package com.li.cn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//第二种读取配置文件的方式
@PropertySources(
        {
                @PropertySource("file:d:/peizhi.properties"),
                @PropertySource("classpath:config/jdbcinfo.properties")
        })
public class FileConfig {

    @Value("${name}")
    private String name;
    @Value("${url}")
    private String url;

    @Override
    public String toString() {
        return "FileConfig{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
