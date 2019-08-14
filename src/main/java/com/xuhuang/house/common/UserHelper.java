package com.xuhuang.house.common;

import com.xuhuang.house.model.User;
import org.springframework.util.StringUtils;

public class UserHelper
{
    public static ResultMsg validate(User account)
    {
        if (StringUtils.isEmpty(account.getEmail()))
        {
            return ResultMsg.errorMsg("Email不合法");
        }
        if (StringUtils.isEmpty(account.getPasswd()))
        {
            return ResultMsg.errorMsg("密码不合法");
        }
        if (StringUtils.isEmpty(account.getConfirmPasswd()))
        {
            return ResultMsg.errorMsg("确认密码不合法");
        }
        if (!account.getPasswd().equals(account.getConfirmPasswd()))
        {
            return ResultMsg.errorMsg("密码不一致");
        }
        return ResultMsg.successMsg("");
    }
}
