package com.li.cn.enable_theory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EchoBeanPostProcessor implements BeanPostProcessor {

    private List<String> packages = new ArrayList<>();

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        for (String pack : packages) {
            if (bean.getClass().getName().startsWith(pack)) {

                System.out.println("echo bean : " + bean.getClass().getName());
            }
        }

        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }
}
