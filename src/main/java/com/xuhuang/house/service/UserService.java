package com.xuhuang.house.service;

import com.xuhuang.house.common.HashUtil;
import com.xuhuang.house.dao.UserDao;
import com.xuhuang.house.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Value("${server.port}")
    private String port;

    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(User account)
    {
        account.setPasswd(HashUtil.encrypt(account.getPasswd()));
        userDao.insertUser(account);
        registerNotify(account.getEmail());
        return true;
    }

    private void registerNotify(String email)
    {
        String url = new StringBuilder().append("http://127.0.0.1:").append(port)
                .append("/account/verify?key=").append(email).toString();
        mailService.send(url, email);

    }

    public User auth(String userName, String passwd)
    {
        User user = new User();
        user.setName(userName);
        user.setPasswd(HashUtil.encrypt(passwd));
        user.setEnable(1);
        List<User> userList = getUserListByCondition(user);
        if (CollectionUtils.isEmpty(userList))
        {
            return null;
        }
        return userList.get(0);
    }

    private List<User> getUserListByCondition(User user)
    {
        return userDao.getUserListByCondition(user);
    }
}
