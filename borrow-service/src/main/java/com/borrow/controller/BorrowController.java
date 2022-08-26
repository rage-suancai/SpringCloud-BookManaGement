package com.borrow.controller;

import com.borrow.entity.UserBorrowDetail;
import com.borrow.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @GetMapping(value = "/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid) {

        return borrowService.getUserBorrowDetailByUid(uid);

    }

}
