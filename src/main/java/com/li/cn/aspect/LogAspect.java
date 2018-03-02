package com.li.cn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.li.cn.dao.UserDao..*(..))")
    public void log() {

//        System.out.println("Before method log done" + AopContext.currentProxy().getClass());
    }

    @After("execution(* com.li.cn.dao.UserDao..*(..))")
    public void logAfter(JoinPoint point) {

        System.out.println("After method log done " + point.getTarget().getClass());

        for (int i = 0; i < point.getArgs().length; i++) {

            System.out.println(point.getArgs()[i]);
        }
    }
}
