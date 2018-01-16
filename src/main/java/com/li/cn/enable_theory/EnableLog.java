package com.li.cn.enable_theory;

import org.springframework.context.annotation.Import;

//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegister.class)
public @interface EnableLog {

    String name();
}
