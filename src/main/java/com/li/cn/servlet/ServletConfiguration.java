package com.li.cn.servlet;

import com.li.cn.filter.EchoFilter;
import com.li.cn.listener.StartupListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootConfiguration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean createBookServlet() {

        ServletRegistrationBean servlet = new ServletRegistrationBean(new BookServlet(), "/book.do");

        return servlet;
    }

    @Bean
    public FilterRegistrationBean createEchoFilter() {

        FilterRegistrationBean filter = new FilterRegistrationBean();

        filter.setFilter(new EchoFilter());
        filter.setUrlPatterns(Arrays.asList("/book.do"));

        return filter;
    }

    @Bean
    public ServletListenerRegistrationBean createStartuplistener(){

        ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean();

        listener.setListener(new StartupListener());
        return listener;
    }
}
