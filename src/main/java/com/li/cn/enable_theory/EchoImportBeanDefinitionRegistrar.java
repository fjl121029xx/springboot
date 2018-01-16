package com.li.cn.enable_theory;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EchoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        Map<String, Object> attr = annotationMetadata.getAnnotationAttributes(EnableEcho.class.getName());
        String[] packArr = (String[]) attr.get("packages");
        List<String> packages = Arrays.asList(packArr);

        System.out.println("packages : " + packages);
        BeanDefinitionBuilder bbd = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);

        bbd.addPropertyValue("packages",packages);
        beanDefinitionRegistry.registerBeanDefinition(EchoBeanPostProcessor.class.getName(), bbd.getBeanDefinition());
    }
}
