package com.borrow.service.impl;

import com.borrow.entity.UserBorrowDetail;
import com.borrow.mapper.BorrowMapper;
import com.borrow.service.BorrowService;
import com.entity.Book;
import com.entity.Borrow;
import com.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;
    @Resource
    RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {

        //log.info("正常执行方法...");

        List<Borrow> borrow = borrowMapper.getBorrowByUid(uid);

        User user = template.getForObject("http://userservice/user/" + uid, User.class);
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://bookservice/book/" + b.getBid(), Book.class))
                .collect(Collectors.toList());

        return new UserBorrowDetail(user, bookList);

    }

}
