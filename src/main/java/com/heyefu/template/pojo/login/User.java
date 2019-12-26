package com.heyefu.template.pojo.login;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:11
 **/
@Getter
@Setter
public class User {
    private String userId;

    private String userName;

    private String password;

    private String nonce;

    @Override
    public String toString() {
        return "User{userId=" + userId + ", userName=" + userName + ", password=" + password + ",nonce=" + nonce + "}";
    }
}
