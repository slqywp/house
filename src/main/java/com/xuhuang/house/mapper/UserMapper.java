package com.xuhuang.house.mapper;

import com.xuhuang.house.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper
{
    List<User> selectUsers();

    void insertUser(User account);

    List<User> selectUserListByCondition(User user);
}
