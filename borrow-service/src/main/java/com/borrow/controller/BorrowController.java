package com.borrow.controller;

import com.borrow.entity.UserBorrowDetail;
import com.borrow.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@Slf4j
@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @HystrixCommand(fallbackMethod = "onError")
    @GetMapping(value = "/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid) {

        return borrowService.getUserBorrowDetailByUid(uid);

    }

    UserBorrowDetail onError(Integer uid) {

        log.info("执行补救措施...");
        return new UserBorrowDetail(null, Collections.emptyList());

    }

}
