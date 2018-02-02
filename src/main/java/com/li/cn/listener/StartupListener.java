package com.li.cn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("===================");
        System.out.println("application is started ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
