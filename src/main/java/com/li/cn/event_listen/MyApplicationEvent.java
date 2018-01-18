package com.li.cn.event_listen;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 */
public class MyApplicationEvent extends ApplicationEvent {

    private static final long serialVersionUID = -9198522490677444417L;

    public MyApplicationEvent(Object source) {

        super(source);
    }
}
