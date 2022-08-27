package com.borrow.service.client;

import com.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {

    @GetMapping(value = "/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);

}
