package com.li.cn;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 异常处理
 * 如何去掉spring boot默认的异常处理逻辑
 *
 * @SpringBootApplication( exclude = { ErrorMvcAutoConfiguration.class})
 * <p>
 * 使用ErrorPageRegistrar接口的registerErrorPages
 * registry.addErrorPages
 *
 *
 * 全局异常处理
 * 1,写一个了,加上@ControllerAdvice注解
 * 2,写一个异常处理方法 @ExceptionHandler(Exception.class)
 */
//@Component
public class CommonErrorPageRegistry implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {

        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");

        ErrorPage args = new ErrorPage(IllegalArgumentException.class, "/otherror.html");

        registry.addErrorPages(e404, e500, args);
    }
}
