package com.li.cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ShopDao {

    public Integer addShop(String name) {

        System.out.println("shop add " + name);
        return 1;
    }
}
