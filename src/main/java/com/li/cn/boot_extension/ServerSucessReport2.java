package com.li.cn.boot_extension;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ServerSucessReport2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===应用已经成功启动2===");
    }
}
