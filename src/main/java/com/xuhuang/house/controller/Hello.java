package com.xuhuang.house.controller;

import com.xuhuang.house.common.HashUtil;
import com.xuhuang.house.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam @Param("str") String str)
    {
        return HashUtil.encrypt(str);
    }
}
