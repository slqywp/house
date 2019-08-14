package com.xuhuang.house.dao;

import com.xuhuang.house.mapper.UserMapper;
import com.xuhuang.house.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao
{
    @Autowired
    private UserMapper userMapper;

    public List<User> selectUsers()
    {
        return userMapper.selectUsers();
    }

    public void insertUser(User account)
    {
        userMapper.insertUser(account);
    }

    public List<User> getUserListByCondition(User user)
    {
        return userMapper.selectUserListByCondition(user);
    }
}
