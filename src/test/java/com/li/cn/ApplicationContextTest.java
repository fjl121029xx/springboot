package com.li.cn;

import com.li.cn.bean.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfiguration.class)
public class ApplicationContextTest {

    @Autowired
    public ApplicationContext context;

    @Test
    public void testNULL() {

        Assert.assertNotNull(context.getBean(Shop.class));
    }
}
