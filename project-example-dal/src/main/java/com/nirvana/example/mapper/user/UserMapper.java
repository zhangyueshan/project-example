package com.nirvana.example.mapper.user;

import com.nirvana.example.model.user.User;
import com.nirvana.web.common.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
}
