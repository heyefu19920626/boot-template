package com.heyefu.template.service;

import com.heyefu.template.dao.login.UserDao;
import com.heyefu.template.pojo.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:14
 **/
@Service
public class LoginServiceImpl implements LoginService {

    UserDao userDao;

    @Override
    public List<User> getAllUser() {

        return userDao.getAllUser();
    }

    @Override
    public User getUser(User user) {

        return userDao.getUserById(user);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
