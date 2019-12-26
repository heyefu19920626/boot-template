package com.heyefu.template.dao.login;

import com.heyefu.template.pojo.login.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-25
 * Time: 19:17
 **/
@Mapper
@Repository
public interface UserDao {

    /**
     * Description:
     * <p>
     * 获取所有用户
     *
     * @return java.util.List<com.heyefu.template.pojo.login.User>
     * @author heyefu 19:24 2019/12/25
     **/
    //@ResultMap("user")
    @Select("select * from users")
    List<User> getAllUser();

    /**
     * Description:
     * <p>
     * 通过用户id获取用户
     *
     * @param user 用户
     * @return java.util.List<com.heyefu.template.pojo.login.User>
     * @author heyefu 19:42 2019/12/25
     **/
    @Results(id = "user", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "nonce", column = "nonce"),
    })
    @Select("select * from users where user_id = #{userId}")
    User getUserById(User user);

    /**
     * Description:
     * <p>
     * 插入一条用户记录，并返回自增的主键值，将其赋予到userId字段上
     *
     * @param user 用户
     * @return int 影响行数
     * @author heyefu 9:18 2019/12/26
     **/
    @Insert("insert into users(user_id, name, password) values (#{userId}, #{userName}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int addUser(User user);

}
