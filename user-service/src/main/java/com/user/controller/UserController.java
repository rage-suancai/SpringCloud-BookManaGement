package com.user.controller;

import com.entity.User;
import com.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userservice;

    @GetMapping(value = "/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {

        return userservice.getUserById(uid);

    }

}
