package com.heyefu.template.controller;

import com.heyefu.template.pojo.login.MyUser;
import com.heyefu.template.pojo.login.User;
import com.heyefu.template.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 18:21
 **/
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    LoginService loginService;

    @RequestMapping("/")
    public String index() {

        return "login";
    }

    //复杂对象
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //简单对象
    //@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object login(@RequestBody MyUser user) {

        LOGGER.info("接收浏览器JSON数据:" + user);

        return true;
    }

    @RequestMapping("/users")
    @ResponseBody
    public Object getAllUser(User user) {
        if (user.getUserId() == null) {
            LOGGER.info("getAllUser");
            return loginService.getAllUser();
        }
        LOGGER.info("getUser");
        return loginService.getUser(user);
    }

    @GetMapping("addUser")
    @ResponseBody
    public User add(User user) {

        return loginService.addUser(user);
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
