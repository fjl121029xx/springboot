package com.li.cn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfiguration.class, properties = {"app.version=1"})
/**
 *
 */
public class EnvTest {

    @Autowired
    private Environment environment;

    @Before
    public void init() {

        EnvironmentTestUtils.addEnvironment((ConfigurableApplicationContext) environment,"");
    }

    @Test
    public void testValue() {


    }
}
