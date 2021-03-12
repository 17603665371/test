package com.springboot.test.dao;

import com.springboot.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JCH
 * @date 2021/03/09 下午 03:08
 */
public interface UserMapper {
    public User getUserByName(String username);

    public Integer insertUser(User user);

    public User getUser();
}
