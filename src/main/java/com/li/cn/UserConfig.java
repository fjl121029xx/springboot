package com.li.cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 两种获取配置的方法
 * 配置文件默认的文件名为application.propertes
 * 默认位置在classpath目录,或者classpath:/config,file:/,file:config/
 *
 * 默认的配置文件名字可以使用--spring.config.name来指定,只需要指定文件的名字,文件扩展名可以省略
 * 默认的配置文件路径可以使用--spring.config.location来指定,配置文件需要全路径,包括目录和文件名字,还可以指定多个
 * 文件的指定方式有两种:1,classpath:;2file:
 */
@Component
public class UserConfig {

    @Value("${local.port}")
    private Integer port;

    @Value("${app.name}")
    private String name;

    @Value("${tomcat.port:8080}")
    private String defaultPort;

    @Autowired
    private Environment environment;

    public void showIp() {

        System.out.println(environment.getProperty("local.ip"));
    }

    public void show() {

        System.out.println("port " + port);
        System.out.println("name " + name);
        System.out.println("tomcat.port " + defaultPort);
    }
}
