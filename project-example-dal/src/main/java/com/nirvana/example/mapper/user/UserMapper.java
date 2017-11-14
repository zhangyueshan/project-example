package com.nirvana.example.mapper.user;

import com.nirvana.example.model.user.User;
import com.nirvana.web.common.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Update("update user set balance = #{balance} where username = #{username} and balance = #{oldBalance}")
    int updateBalanceByUsernameAndBalance(@Param("balance") BigDecimal balance, @Param("username") String username, @Param("oldBalance") BigDecimal oldBalance);
}
