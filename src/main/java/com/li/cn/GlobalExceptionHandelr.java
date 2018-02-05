package com.li.cn;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandelr {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String errorHandler() {

        return "global exception";
    }
}
