package com.nirvana.example.service.user.impl;

import com.github.pagehelper.Page;
import com.nirvana.example.model.user.User;
import com.nirvana.example.repository.user.UserRepository;
import com.nirvana.example.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    @Override
    public User get(long id) {
        return userRepository.get(id);
    }

    @Override
    public Page<User> get(int page, int size) {
        LOGGER.info("start pager:{},{}", page, size);
        return userRepository.get(page, size);
    }
}
