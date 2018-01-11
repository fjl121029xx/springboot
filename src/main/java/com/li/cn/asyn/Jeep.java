package com.li.cn.asyn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Jeep implements Runnable {

    @Override
    @Async
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {

                System.out.println("=======" + i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
