package com.heyefu.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 下午9:18
 **/
@Controller
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);


    @GetMapping("app/vote")
    public String goVotePage() {

        return "app/vote_app";
    }

    @PostMapping("app/save")
    @ResponseBody
    public Object saveApp() {

        return "ok";
    }
}
