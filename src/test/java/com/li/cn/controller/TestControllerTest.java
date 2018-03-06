package com.li.cn.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 5, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: home()
     */
    @Test
    public void testHome() throws Exception {

        //TODO: Test goes here...
        String content = testRestTemplate.getForObject("/test/home", String.class);
        Assert.assertEquals("test home", content);
    }
    /**
     * Method: show()
     */
    @Test
    public void testShow() throws Exception {

        //TODO: Test goes here...
        String content = testRestTemplate.getForObject("/test/show", String.class);
        Assert.assertEquals("test home", content);
    }


} 
