package com.li.cn.enable_theory;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented

@Import(EchoImportBeanDefinitionRegistrar.class)
public @interface EnableEcho {

    String[] packages();
}
