package com.li.cn;

import com.li.cn.auto_configuration.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
public class EncodingConvertConfig {

    @Bean
    @Conditional(UTFCondition.class)
    public EncodingConvert createUTF8() {

        return new UTF8EncodingConvert();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvert createGBK() {

        return new GBKEncodingConvert();
    }
}
