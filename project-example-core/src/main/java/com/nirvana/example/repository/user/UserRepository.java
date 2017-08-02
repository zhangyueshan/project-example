package com.nirvana.example.repository.user;

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

}
