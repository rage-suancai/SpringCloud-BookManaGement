package com.user.service.impl;

import com.entity.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(Integer uid) {

        return userMapper.getUserById(uid);

    }

}
