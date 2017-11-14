package com.nirvana.example.service.user;

import com.github.pagehelper.Page;
import com.nirvana.example.model.user.User;

import java.math.BigDecimal;

public interface UserService {

    User get(long id);

    User get(String username);

    Page<User> get(int page, int size);

    void deduct(String username, BigDecimal deduct);

}
