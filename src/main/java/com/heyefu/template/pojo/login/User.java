package com.heyefu.template.pojo.login;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:11
 **/
@Data
public class User implements Serializable {
    private String userId;

    private String userName;

    private String password;

    private String nonce;
}
