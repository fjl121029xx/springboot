package com.li.cn.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ShopDaoTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void addShop() throws Exception {

        System.out.println(shopDao);
        Assert.assertEquals(Integer.valueOf(1),shopDao.addShop("root"));
        Assert.assertEquals(Integer.valueOf(0),shopDao.addShop(null));
    }

}