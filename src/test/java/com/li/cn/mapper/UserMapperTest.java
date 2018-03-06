package com.li.cn.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

public class UserMapperTest {

    @MockBean
    private UserMapper userMapper;

    @Test(expected = NullPointerException.class)
    public void testCreateUser() {

        BDDMockito.given(userMapper.createUser("tom")).willReturn(1);
        BDDMockito.given(userMapper.createUser("")).willReturn(0);
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);

        Assert.assertEquals(Integer.valueOf(1),userMapper.createUser("tom"));
    }
}
