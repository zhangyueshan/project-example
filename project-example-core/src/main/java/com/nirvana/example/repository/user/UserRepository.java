package com.nirvana.example.repository.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nirvana.example.mapper.user.UserMapper;
import com.nirvana.example.model.user.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepository {

    @Resource
    private UserMapper userMapper;

    public User get(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public Page<User> get(int page, int size) {
        return PageHelper.startPage(page, size).doSelectPage(() -> userMapper.selectAll());
    }

}
