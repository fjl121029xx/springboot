package com.li.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@SpringBootApplication
@EnableCaching
@RestController
@EnableAutoConfiguration
public class SpringBootSampleApplication {

    @RequestMapping("/")
    String home() {

        return "Hello World";
    }

    @Bean
    public Runnable createRunnable() {

        return () -> {
            System.out.println("spring boot is run");
        };
    }

    public static void main(String[] args) {
    //http://blog.csdn.net/isea533/article/details/50281151     Spring Boot 属性配置和使用

    //https://www.cnblogs.com/magicalSam/p/7189421.html     Spring Boot 系列（三）属性配置&自定义属性配置

        SpringApplication app = new SpringApplication(SpringBootSampleApplication.class);
        app.setAddCommandLineProperties(false);
        //--spring.profiles.active=test
        app.setAdditionalProfiles("dev");

        Properties properties = new Properties();
        //设置配置文件的路径和名字
        properties.put("spring.config.location","classpath:conf/app.properties");

        app.setDefaultProperties(properties);

        ConfigurableApplicationContext context = app.run(args);

//        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSampleApplication.class, args);
//        context.getBean(Runnable.class).run();
//        System.out.println(context.getBean(List.class));

        // spring boot 配置
        //第一种方式
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getProperty("local.ip"));
        //第二种方式
        ((UserConfig)context.getBean("userConfig")).showIp();
        //第三种方式
        ((UserConfig)context.getBean("userConfig")).show();

        // spring boot 读取其他配置文件

        System.out.println(context.getBean(JDBCConfig.class));
        System.out.println(context.getBean(FileConfig.class));
        System.out.println(context.getBean(DataSourceProperties.class));


        //application.yml
        System.out.println(context.getEnvironment().getProperty("jdbc.username"));
        System.out.println(context.getEnvironment().getProperty("jdbc.password"));

        //注入一个集合\数组
        System.out.println(context.getBean(TomcatProperties.class).getHosts());
        System.out.println(context.getBean(TomcatProperties.class).getPorts()[2]);

        //动态的读取配置文件
        System.out.println(context.getEnvironment().getProperty("springboot.name"));

        //
        System.out.println(context.getEnvironment().getProperty("jdbc.url"));




    }
}
