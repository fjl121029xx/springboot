package com.li.cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//第三读取配置文件的方式
@ConfigurationProperties(prefix = "ds"/*, locations="classpath:conf/ds.properties"*/)
@Component
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
