package com.heyefu.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 18:21
 **/
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        System.out.println("-----------");

        return "index";
    }
}
