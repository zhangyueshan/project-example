package com.nirvana.example.service.user.impl;

import com.github.pagehelper.Page;
import com.nirvana.example.exception.ResultCode;
import com.nirvana.example.model.user.User;
import com.nirvana.example.repository.user.UserRepository;
import com.nirvana.example.service.user.UserService;
import com.nirvana.web.common.api.BaseApiException;
import com.nirvana.web.common.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.OptimisticLockException;
import java.math.BigDecimal;

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
    public User get(String username) {
        return userRepository.get(username);
    }

    @Override
    public Page<User> get(int page, int size) {
        LOGGER.info("start pager:{},{}", page, size);
        return userRepository.get(page, size);
    }

    @Override
    @Transactional
    public void deduct(String username, BigDecimal deduct) {
        User user = get(username);

        if (user == null) {
            return;
        }

        BigDecimal oldBalance = user.getBalance();
        BigDecimal balance = oldBalance.subtract(deduct);

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseApiException(ResultCode.FAILURE, "余额不足。");
        }

        //关键点：要带上原状态[oldBalance]
        int num = userRepository.update(balance, username, oldBalance);
        //乐观锁异常
        if (num == 0) {
            throw new OptimisticLockException();
        }
    }
}
