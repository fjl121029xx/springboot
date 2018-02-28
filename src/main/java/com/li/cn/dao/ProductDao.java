package com.li.cn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name) {

        String sql = String.format("insert into product (product_name) values( '%s' )", name);
        jdbcTemplate.execute(sql);
    }

    @Transactional(rollbackFor = Exception.class)
    public void batchAdd(String... name) {
        for (int r = 0; r < name.length; r++) {

            String sql = String.format("insert into product (product_name) values( '%s' )", name[r]);
            jdbcTemplate.execute(sql);
        }
    }


}
