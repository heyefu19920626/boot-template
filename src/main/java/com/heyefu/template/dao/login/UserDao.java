package com.heyefu.template.dao.login;

import com.heyefu.template.pojo.login.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:17
 **/
@Mapper
public interface UserDao {

    /**
     * Description:
     * <p>
     * 获取所有用户
     *
     * @return java.util.List<com.heyefu.template.pojo.login.User>
     * @author heyefu 19:24 2019/12/25
     **/
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "password", column = "passwd"),
            @Result(property = "nonce", column = "nonce"),
    })
    @Select("select * from users")
    List<User> getAllUser();
}
