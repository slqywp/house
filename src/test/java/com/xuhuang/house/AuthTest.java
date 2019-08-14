package com.xuhuang.house;

import com.xuhuang.house.model.User;
import com.xuhuang.house.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthTest
{
    @Autowired
    private UserService userService;

    @Test
    public void testAuth()
    {
        User user = userService.auth("spring_boot@163.com", "1111");
        assert user != null;
    }


}
