package com.springboot.test.service.impl;

import com.springboot.test.dao.UserMapper;
import com.springboot.test.pojo.User;
import com.springboot.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author JCH
 * @date 2021/03/09 下午 03:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
        throw new RuntimeException();
    }

    @Override
    public User getUser() {
        return userMapper.getUser();
    }
}
