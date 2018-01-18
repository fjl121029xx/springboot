package com.li.cn.event_listen;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    public void event(MyApplicationEvent event) {

        System.out.println(" MyEventHandler 接收到事件 ========= : " + event.getClass().getName());
    }

    @EventListener
    public void event2(ContextStoppedEvent event) {

        System.out.println(" MyEventHandler 应用停止事件 ========= : " + event.getClass().getName());
    }
}
