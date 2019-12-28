package com.heyefu.template.controller;

import com.heyefu.template.common.ResultResponse;
import com.heyefu.template.constant.GlobalConstant;
import com.heyefu.template.pojo.login.User;
import com.heyefu.template.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/")
    public String loginPage() {

        return "login";
    }

    /**
     * 这里误会拦截很多请求
     *
     * @param model   模板
     * @param request request
     */
    @GetMapping("/{userId}")
    public String goIndex(Model model, HttpServletRequest request, @PathVariable String userId) {
        User user = (User) request.getSession().getAttribute(GlobalConstant.USER_SESSION_KEY);
        //经常会有其他请求映射到这
        User currentUser = new User();
        currentUser.setUserId(userId);
        loginService.getUser(currentUser);
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "index";
    }

    /**
     * Description:
     * <p>
     * //简单对象
     * //@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
     * <p>
     * //复杂对象
     * //@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
     * <p>
     * 注意此处的请求路径，不能为与上面login.html前缀相同的login,否则会映射错误
     * <p>
     * 使用@PostMapping可以直接注入复杂与简单对象
     *
     * @param user 用户
     * @return java.lang.Object
     * @author heyefu 15:13 2019/12/27
     **/
    @PostMapping(value = "/loginUser")
    @ResponseBody
    public ResultResponse<String> login(@RequestBody User user, HttpServletRequest request) {
        ResultResponse<String> result = new ResultResponse<>();
        ResultResponse<User> response = loginService.login(user);

        if (response.isStatus()) {
            request.getSession().setAttribute(GlobalConstant.USER_SESSION_KEY, response.getT());
            result.setT("登录成功");
        } else {
            result.setT("用戶名或密码错误");
        }
        result.setStatus(response.isStatus());

        return result;
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(GlobalConstant.USER_SESSION_KEY);

        return "login";
    }

    @GetMapping("/users")
    @ResponseBody
    public Object getAllUser(User user) {
        if (user.getUserId() == null) {
            LOGGER.info("getAllUser");
            return loginService.getAllUser();
        }
        LOGGER.info("getUser");
        return loginService.getUser(user);
    }

    @GetMapping("/addUser")
    @ResponseBody
    public User add(User user) {

        return loginService.addUser(user);
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
