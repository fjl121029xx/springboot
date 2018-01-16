package com.li.cn;

import com.li.cn.asyn.Jeep;
import com.li.cn.auto_configuration.EncodingConvert;
import com.li.cn.auto_configuration.GBKEncodingConvert;
import com.li.cn.auto_configuration.UTF8EncodingConvert;
import com.li.cn.enableAutoConfiguration_deep.Dog;
import com.li.cn.enable_theory.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@SpringBootApplication()
@EnableCaching
@RestController
@EnableAsync  //启用异步,一般适合@Async一起使用
@EnableAutoConfiguration()//引入第三方jar包,class...,
/**从classpath中搜索所有MATE-INF/spring.factories配置文件,然后将其中key对应的配置项加载到spring容器中
 * 1.ImportSelector 该接口的方法返回值都会被纳入到spring容器中
 * 2.SpringFactoriesLoader 可以搜索classpath下的WETA-INF/spring.factories配置文件,并读取配置,
 * 最终由该接口的selectImports方法返回
 * 3.只有spring.boot.enableautoconfiguration=true才起作用
 * */
@EnableConfigurationProperties  /**是用来启用一个特性,这个特性就是,可以把配置文件的属性注入到bean里面去,
                一般适合@ConfigurationProperties(prefix = "tomcat")*/
//@Import({User.class, Role.class, MyConfiguration.class})//用来导入一个或多个类,bean就会被spring容器托管
//@Import(MyImportSelector.class)
//ImportSelector,
// ImportBeanDefinitionRegistrar
//@EnableLog(name = "my springboot")
@EnableEcho(packages = {"com.li.cn.enable_theory.Cat"})
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
        properties.put("spring.config.location", "classpath:conf/app.properties");

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
        ((UserConfig) context.getBean("userConfig")).showIp();
        //第三种方式
        ((UserConfig) context.getBean("userConfig")).show();

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

        //切换spring boot 的配置文件
        System.out.println(context.getEnvironment().getProperty("jdbc.url"));

        //基于条件的自动配置
        System.out.println(context.getBeansOfType(EncodingConvert.class));
        System.out.println(context.getEnvironment().getProperty("file.encoding"));

        System.out.println(context.getBeansOfType(Runnable.class));

        //spring boot 09 @Enable*注解的工作原理47:07
        System.out.println(context.getBean(Tomcat2Properties.class));
        /*异步请求*/
        Object jeep = context.getBean("jeep");
        System.out.println(jeep);
        if (jeep instanceof Runnable) {

            System.out.println("----");
            Runnable j = (Runnable) jeep;
            j.run();
        }
        System.out.println("===end===");

        //@Enable*注解的工作原理47:07
        try {

            System.out.println(context.getBean(User.class));
            System.out.println(context.getBean(Role.class));
        } catch (Exception e) {

        }
        //@EnableAutoConfiguration 深入分析30:55
        System.out.println(context.getBean(Dog.class));


    }
}
