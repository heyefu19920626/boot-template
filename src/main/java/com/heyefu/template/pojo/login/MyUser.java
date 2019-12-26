package com.heyefu.template.pojo.login;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-26
 * Time: 14:17
 **/
@Getter
@Setter
public class MyUser {

    private int count;

    private List<User> users;

    @Override
    public String toString() {
        StringBuilder myUser = new StringBuilder();
        myUser.append("{count=").append(count).append(",users=[");
        users.forEach(user -> myUser.append(user.toString()));
        myUser.append("}");
        System.out.println(myUser.toString());
        return myUser.toString();
    }
}
