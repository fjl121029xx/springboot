package com.li.cn.boot_extension;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartedApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(" 应用已经启动,参数为 : " + Arrays.deepHashCode(args.getSourceArgs()));
    }
}
