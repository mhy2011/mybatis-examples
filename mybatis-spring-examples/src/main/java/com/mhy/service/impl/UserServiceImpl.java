package com.mhy.service.impl;

import com.mhy.dao.UserMapper;
import com.mhy.model.User;
import com.mhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mahaiyuan on 16/7/17.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        int num = userMapper.insert(user);
        return num;
    }
}
