package com.mhy.service;

import com.mhy.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by mahaiyuan on 16/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/beans.xml"
})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setAddTime(new Date());
        user.setLastLoginTime(new Date());
        user.setLoginTimes(1);
        user.setPassword("123456");
        user.setUsername("admin001");
        int num = userService.save(user);
        Assert.assertEquals(1, num);
    }
}
