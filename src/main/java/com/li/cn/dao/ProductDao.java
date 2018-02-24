package com.li.cn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name) {

        String sql = "insert into product (product_name) values( '" + name + "' )";
        jdbcTemplate.execute(sql);
    }
}
