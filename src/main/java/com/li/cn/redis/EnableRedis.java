package com.li.cn.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisAutoConfiguration.class)
public @interface EnableRedis {


}
