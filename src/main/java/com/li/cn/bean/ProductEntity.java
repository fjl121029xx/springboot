package com.li.cn.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 产品信息
 * @date 2016-09-23 12:44:55
 */
public class ProductEntity implements java.io.Serializable {

    private Integer pid;
    private String pname;
    private String type;
    private Double price;
    private Timestamp createTime;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
