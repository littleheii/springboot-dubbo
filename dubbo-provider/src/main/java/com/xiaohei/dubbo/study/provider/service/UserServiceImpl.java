package com.xiaohei.dubbo.study.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaohei.dubbo.study.common.entity.User;
import com.xiaohei.dubbo.study.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User get(long id) {
        return userMapper.getUser(id);
    }

    @Override
    public int update(long id, User user) {
        return userMapper.update(id, user);
    }

    @Override
    public int delete(long id) {
        return userMapper.delete(id);
    }
}
