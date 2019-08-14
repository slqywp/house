package com.xuhuang.house.controller;

import com.xuhuang.house.common.ResultMsg;
import com.xuhuang.house.common.UserHelper;
import com.xuhuang.house.model.User;
import com.xuhuang.house.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.xuhuang.house.common.UrlConstant.*;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    /**
     * 注册提交；1.注册验证 2.发送邮件 3.验证失败重定向道注册页面
     * 注册页获取：根据account对象为一句判断是否注册页获取请求
     *
     * @param account
     * @param modelMap
     * @return
     */
    @RequestMapping("account/register")
    public String register(User account, ModelMap modelMap)
    {
        if (account == null || account.getName() == null)
        {
            return USER_REGISTER;
        }

        ResultMsg msg = UserHelper.validate(account);
        if (msg.isSuccess() && userService.addAccount(account))
        {
            return USER_REGISTER_SUBMIT;
        }
        return "redirect:" + USER_REGISTER + msg.asUrlParams();
    }


    @RequestMapping("/account/login")
    public String signIn(HttpServletRequest request)
    {
        String userName = request.getParameter("userName");
        String passwd = request.getParameter("password");
        String target = request.getParameter("target");

        if (userName == null || passwd == null)
        {
            request.setAttribute("target", target);
            return USER_ACCOUNT_SIGNIN;
        }
        User user = userService.auth(userName, passwd);
        if (user == null)
        {
            return new StringBuilder().append("redirect:").append(USER_ACCOUNT_SIGNIN)
                    .append("?target=").append(target)
                    .append("&username").append(userName)
                    .append("&").append(ResultMsg.errorMsg("用户名不存在").asUrlParams())
                    .toString();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        session.setAttribute("loginUser", user);
        if (StringUtils.isBlank(target))
        {
            target = "/index";
        }
        return "redirect:" + target;
    }

    @RequestMapping("account/logout")
    public String logOut(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "redirect:/index";
    }
}
