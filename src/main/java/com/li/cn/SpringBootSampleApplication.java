package com.li.cn;

import com.google.gson.Gson;
import com.li.cn.asyn.Jeep;
import com.li.cn.auto_configuration.EncodingConvert;
import com.li.cn.auto_configuration.GBKEncodingConvert;
import com.li.cn.auto_configuration.UTF8EncodingConvert;
import com.li.cn.boot_extension.MyApplicationContextInitializer;
import com.li.cn.dao.ProductDao;
import com.li.cn.dao.StudentDao;
import com.li.cn.dao.UserDao;
import com.li.cn.enableAutoConfiguration_deep.Dog;
import com.li.cn.enable_theory.*;
import com.li.cn.event_listen.MyApplicationEvent;
import com.li.cn.event_listen.MyApplicationListener;
import com.li.cn.redis.EnableRedis;
import com.sun.javaws.exceptions.ErrorCodeResponseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication(scanBasePackages = "com.li.cn", exclude = {GsonAutoConfiguration.class, ErrorMvcAutoConfiguration.class})
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
@EnableConfigurationProperties
/**是用来启用一个特性,这个特性就是,可以把配置文件的属性注入到bean里面去,
 一般适合@ConfigurationProperties(prefix = "tomcat")*/
//@Import({User.class, Role.class, MyConfiguration.class})//用来导入一个或多个类,bean就会被spring容器托管
//@Import(MyImportSelector.class)
//ImportSelector,
// ImportBeanDefinitionRegistrar
//@EnableLog(name = "my springboot")
//@EnableAspectJAutoProxy
@EnableEcho(packages = {"com.li.cn.enable_theory.Cat"})
@ServletComponentScan
@EnableTransactionManagement
//@EnableRedis
public class SpringBootSampleApplication {

    @Value("${server.host:localhost }")
    private String serverhost;

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

        //http://shiyanjun.cn/archives/1097.html

        //http://blog.csdn.net/qq_36348557/article/details/69396589
        SpringApplication app = new SpringApplication(SpringBootSampleApplication.class);
        //13 Spring Boot 补充讲解21:59
        /**
         * SpringApplication.setBannerMode(Banner.Mode.CONSOLE);
         * 自定义banner方法
         * 在classpath下放一个banner.txt文件即可
         * banner.location 配置项指定banner的文件路径
         * banner.chatset
         * banner.img.location 配置项指定图片banner的文件路径
         */
//        app.setBannerMode(Banner.Mode.CONSOLE);

        Map<String, Object> defaultProperties = new HashMap<>();
        defaultProperties.put("server.host", "192.168.1.100");
        app.setDefaultProperties(defaultProperties);


        app.setAddCommandLineProperties(false);
        //--spring.profiles.active=test
        app.setAdditionalProfiles("dev");

        Properties properties = new Properties();
        //设置配置文件的路径和名字
        properties.put("spring.config.location", "classpath:conf/app.properties");

        app.setDefaultProperties(properties);

        ConfigurableApplicationContext context = app.run("aa", "bb");

        //11 Spring Boot 事件监听27:53 --四种方式讲解如何配置事件监听
        /**
         * 1.自定义事件:一般继承ApplicationEvennt
         * 2.自定义监听器,一般实现ApplicationListener接口
         * 3.配置监听器,要把监听器加入到spring监听器容器中
         * 4.发布事件,使用ApplicationContext.pulishEvent发布事件
         *
         * 配置监听器
         *  1,app.addListeners(new MyApplicationListener ());
         *  2,@Compoent
         *  3,使用context.listener.classes配置项
         *  4,使用注解@Listener在方法上,并且改类要纳入到spring容器中管理  参照EventListenerMethodProcessor
         */
        //app.addListeners(new MyApplicationListener ());
        context.publishEvent(new MyApplicationEvent(new Object()));

        //12 Spring Boot 扩展分析33:54
        /**
         * ApplicationContextInitializer 接口是spring容器执行refreshed之前的一个回调
         * 使用步骤:
         *  1:写一个类,实现ApplicationContextInitializer接口
         *  2:注册实现ApplicationContextInitializer接口
         *
         * 注册方法:
         *  1:SpringApplication.addInitializers
         *  2:context.initializer.classes
         *  3:可以通过WETA-INF/spring.factories
         */
//        app.addInitializers(new MyApplicationContextInitializer());
        /**
         * CommandLineRunner 接口是容器启动成功后的最后一步回调
         *  1:写一个类,实现CommandLineRunner接口
         *  2:把该类纳入到spring容器管理中
         *
         *  CommandLineRunner  ApplicationRunner区别
         *   CommandLineRunner的参数是原始参数,没有处理
         *   ApplicationRunner的参数是ApplicationArguments,是对原始参数进一步的封装,
         *
         *  ApplicationArguments是对参数(main方法)做了进一步处理
         *  可以解析--name=value的,我们就可以通过name来获取value
         */

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
        System.out.println(context.getBean(MyDataSourceProperties.class));


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

        //09 @Enable*注解的工作原理47:07
        try {

            System.out.println(context.getBean(User.class));
            System.out.println(context.getBean(Role.class));
        } catch (Exception e) {
            System.out.println("aya");
        }
        //10 @EnableAutoConfiguration 深入分析30:55
        System.out.println(context.getBean(Dog.class));

        //13 Spring Boot 补充讲解21:59
        System.out.println("13 :　" + context.getBean("creatRunnable9"));
        System.out.println(context.getBean(Gson.class));
        System.out.println(context.getEnvironment().getProperty("server.host", "aaa"));
        System.out.println(context.getBean(SpringBootSampleApplication.class).serverhost);

        //19 Spring Boot JDBC38:38 --多种数据源的配置、JdbcTemplate、事务的处理
        /**
         * 装配DataSourced的步骤:
         *  1:加入数据库驱动
         *  2:配置application.properties
         *      spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
         *      spring.datasource.url=jdbc:mysql://127.0.0.1:3306/sims?serverTimezone=UTC
         *      spring.datasource.username=root
         *      spring.datasource.password=root
         *      #spring.datasource.type=com.zaxxer.hikari.HikariDataSource
         *      spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
         *      以上操作,springboot会自动装配好DataSource,jdbctemplate,可以直接使用
         *
         *      sptring.datasource.type可以指定具体使用哪种数据源
         *      默认支持tomcat-jdbc,hikari,dbcp,dbp2
         *
         *      配置自己的DataSource
         *      只需要装配一个DataSource到spring容器中即可
         *
         */
        DataSource ds = context.getBean(DataSource.class);
        System.out.println(ds.getClass());
        Connection conn = null;
        try {
            conn = ds.getConnection();

            /*System.out.println(conn.getSchema());
            System.out.println(conn.getCatalog());*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {

                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(context.getBean(JdbcTemplate.class));
        context.getBean(ProductDao.class).add("12");
        context.getBean(ProductDao.class).batchAdd("1", "2", "3");

        //20 Spring Boot AOP 24:24
        /**
         * AOP开发流程
         * 1,spring-boot-starter-aop,加入依赖,默认开启了AOP的支持
         * 2,写一个Aspect,封装横切关注点(日志,监控等待),需要配置通知
         * 3,这个aspect需要纳入到spring容器管理,并且需要@Aspect
         *
         * spring.aop.auto=false  是否启用AOP
         * spring.aop.proxy-target-class=false 使用JDK
         */
        context.getBean(UserDao.class).add("tom", "123");

        //21 Spring Boot Starter18:31   --快速构建自定义的Spring Boot Starter
//        System.out.println(context.getBean(Jedis.class));
        /**
         * 自己开发一个spring-boot-starter的步骤
         * 1:新建一个项目,
         * 2:需要一个配置类,配置类里面需要装配好需要提供出去的类
         * 3:
         *      (1)使用@Enable,使用@Import导入需要装配的类
         *      (2)/META-INF/spring.factories,在org.springframework.boot.autoconfiguration.EnableAutoConfiguration配置需要装配的类
         */

        //22 Spring Boot 日志30:58    --演示了如何在Spring Boot里面使用日志配置，以及logback，log4j2等日志的使用
        /**
         * springboot默认日志的级别是Info
         * 可以通过logging.level.*=debug来设置, * 可以是包,也可以是某个类
         *
         * 日志级别:TRACE ,DEBUG ,INFO ,WARN ,ERROR ,FATAL ,OFF
         * 日志级别配置成OFF,表示关闭日志输出
         *
         * #logging.level.root=DEBUG
         * #指定文件路径
         * #logging.file=d:/tmp/my.log
         * #logging.path=d:/tmp/logs
         * #logging.pattern.console=
         * #logging.file.console=
         *
         */
        context.getBean(StudentDao.class).log();

        /*context.stop();
        context.close();*/
    }
}
