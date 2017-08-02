package com.nirvana.example.service.user;

import com.github.pagehelper.Page;
import com.nirvana.example.model.user.User;

public interface UserService {

    User get(long id);

    Page<User> get(int page, int size);

}
