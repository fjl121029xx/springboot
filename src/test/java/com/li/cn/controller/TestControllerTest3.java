package com.li.cn.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * TestController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 5, 2018</pre>
 */

/**
 * @SpringBootTest 不能和 @WebMvcTest同时使用
 * 如果使用MockMvc 需要另外加上@AutoConfigureMockMvc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest3 {

    @Autowired
    private MockMvc mvc;

    /**
     * Method: home()
     */
    @Test
    public void testHome() throws Exception {

        //TODO: Test goes here...
        mvc.perform(MockMvcRequestBuilders.get("/test/home")).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/test/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("aaa"));
    }

    /**
     * Method: show()
     */
    @Test
    public void testShow() throws Exception {

        //TODO: Test goes here..
        mvc.perform(MockMvcRequestBuilders.get("/test/show").param("id", "1")).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/test/show").param("id", "1")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("aaa"));
    }


} 
