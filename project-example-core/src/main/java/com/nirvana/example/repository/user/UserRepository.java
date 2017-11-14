package com.nirvana.example.repository.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nirvana.example.mapper.user.UserMapper;
import com.nirvana.example.model.user.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Repository
public class UserRepository {

    @Resource
    private UserMapper userMapper;

    public User get(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User get(String username) {
        return userMapper.selectByUsername(username);
    }

    public int update(BigDecimal balance, String username, BigDecimal oldBalance) {
        return userMapper.updateBalanceByUsernameAndBalance(balance, username, oldBalance);
    }

    public Page<User> get(int page, int size) {
        return PageHelper.startPage(page, size).doSelectPage(() -> userMapper.selectAll());
    }

}
