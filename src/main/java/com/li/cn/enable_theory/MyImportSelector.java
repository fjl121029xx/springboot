package com.li.cn.enable_theory;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 方法的返回值,必须是一个class的全称,该class会被spring容器所托管起来
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        System.out.println(annotationMetadata.getAnnotationAttributes(EnableLog.class.getName()));
        /**
         * 这里可以获取到注解的详细信息,然后根据信息去动态返回需要被spring容器管理的bean
         */
        return new String[]{
                "com.li.cn.enable_theory.User",
                Role.class.getName(),
                MyConfiguration.class.getName()
        };
    }
}
