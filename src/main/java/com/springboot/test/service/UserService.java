package com.springboot.test.service;

import com.springboot.test.pojo.User;

/**
 * @author JCH
 * @date 2021/03/09 下午 03:13
 */
public interface UserService {

    public User getUserByName(String username);

    public void insertUser(User user);

    public User getUser();
}
