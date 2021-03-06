package com.heyefu.template.service;

import com.heyefu.template.common.ResultResponse;
import com.heyefu.template.pojo.login.User;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:14
 **/
public interface LoginService {

    /**
     * Description:
     * <p>
     * 用户登录。
     *
     * 返回登录状态
     *
     * @param user 用户
     * @return boolean
     * @author heyefu 15:53 2019/12/27
     **/
    ResultResponse<User> login(User user);

    /**
     * Description:
     * <p>
     * 获取所有用户.
     *
     * @return java.util.List<com.heyefu.template.pojo.login.User>
     * @author heyefu 19:25 2019/12/25
     **/
    List<User> getAllUser();

    /**
     * Description:
     * <p>
     * 获取指定用户.
     *
     * @param user 参数
     * @return com.heyefu.template.pojo.login.User
     * @author heyefu 19:45 2019/12/25
     **/
    User getUser(User user);

    /**
     * Description:
     * <p>
     * 添加用户,并返回完整用户
     *
     * @param user 要添加的用户信息
     * @return com.heyefu.template.pojo.login.User
     * @author heyefu 9:20 2019/12/26
     **/
    User addUser(User user);
}
