package com.nirvana.example.service.user.impl;

import com.nirvana.example.model.user.User;
import com.nirvana.example.repository.user.UserRepository;
import com.nirvana.example.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User get(long id) {
        return userRepository.get(id);
    }
}
