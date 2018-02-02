package com.li.cn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("app startup at " + LocalDateTime.now().toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
