package com.li.cn;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * sprng boot 09 @Enable*注解的工作原理47:07
 */
@Component
@ConfigurationProperties(prefix = "tomcat")
public class Tomcat2Properties {

    private String hosts;
    private String ports;

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String port) {
        this.ports = port;
    }

    @Override
    public String toString() {
        return "Tomcat2Properties{" +
                "hosts='" + hosts + '\'' +
                ", port='" + ports + '\'' +
                '}';
    }
}
