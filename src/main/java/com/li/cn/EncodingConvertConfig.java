package com.li.cn;

import com.li.cn.auto_configuration.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
@Conditional({UTFCondition.class})  //基于条件的自动装配,一般配合Condition接口一起来使用,只有接口实现类返回true,才装配
public class EncodingConvertConfig {

    @Bean
//    @Conditional(UTFCondition.class)
    public EncodingConvert createUTF8() {

        return new UTF8EncodingConvert();
    }

    @Bean
//    @Conditional(GBKCondition.class)
    public EncodingConvert createGBK() {

        return new GBKEncodingConvert();
    }
}
