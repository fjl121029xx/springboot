package com.li.cn.enable_theory;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar
 * registerBeanDefinitions方法可以用来往spring容器中注入bean
 * 此时,我们就可以在registerBeanDefinitions动态的注入bean
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        BeanDefinitionBuilder bbd = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        beanDefinitionRegistry.registerBeanDefinition("user", bbd.getBeanDefinition());

        BeanDefinitionBuilder bbd2 = BeanDefinitionBuilder.rootBeanDefinition(Role.class);
        beanDefinitionRegistry.registerBeanDefinition("role", bbd2.getBeanDefinition());

        BeanDefinitionBuilder bbd3 = BeanDefinitionBuilder.rootBeanDefinition(MyConfiguration.class);
        beanDefinitionRegistry.registerBeanDefinition("myConfiguration", bbd3.getBeanDefinition());
    }
}
