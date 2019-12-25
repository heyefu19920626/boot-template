package com.heyefu.template.controller;

import com.heyefu.template.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 18:21
 **/
@Controller
public class LoginController {

    LoginService loginService;

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/users")
    @ResponseBody
    public Object getAllUser() {

        return loginService.getAllUser();
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
