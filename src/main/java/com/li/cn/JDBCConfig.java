package com.li.cn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
//第一种读取配置文件的方式
@Configuration
@PropertySource("classpath:config/jdbcinfo.properties")
public class JDBCConfig {
    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return "JDBCConfig{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
