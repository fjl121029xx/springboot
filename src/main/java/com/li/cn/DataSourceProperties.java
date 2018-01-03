package com.li.cn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

//第三读取配置文件的方式
@ConfigurationProperties(prefix = "ds")
public class DataSourceProperties {

    private String url;
    private String driver;

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "ds.url='" + url + '\'' +
                ", ds.driver='" + driver + '\'' +
                '}';
    }
}
