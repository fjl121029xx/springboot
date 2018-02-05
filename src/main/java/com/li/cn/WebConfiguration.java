package com.li.cn;

import com.li.cn.intercepter.LogHandlerIntercepter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器使用步骤
 * 1:写一个拦截器,实现HandlerInterceptor接口
 * 2:写一个配置类,继承WebMvcConfigurer,重写addInterceptors方法
 * 3:registry.addInterceptor
 */
//@SpringBootConfiguration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogHandlerIntercepter());
    }
}
