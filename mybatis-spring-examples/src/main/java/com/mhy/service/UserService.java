package com.mhy.service;

import com.mhy.model.User;

/**
 * Created by mahaiyuan on 16/7/17.
 */
public interface UserService {
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int save(User user);
}
