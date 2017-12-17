package com.xiaohei.dubbo.study.provider.service;

import com.xiaohei.dubbo.study.common.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    int save(User user);

    User get(long id);

    int update(long id, User user);

    int delete(long id);
}
