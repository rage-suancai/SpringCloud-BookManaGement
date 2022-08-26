package com.user.controller;

import com.entity.User;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class UserController {
    @Resource
    UserService userservice;

    @GetMapping(value = "/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {

        //log.info("我被调用了 {}", uid);
        return userservice.getUserById(uid);

    }

}
