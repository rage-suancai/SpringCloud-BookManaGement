package com.book.service.impl;

import com.book.mapper.BookMapper;
import com.book.service.BookService;
import com.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bid) {

        return bookMapper.getBookById(bid);

    }

}
