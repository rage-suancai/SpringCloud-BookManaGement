package com.book.controller;

import com.book.service.BookService;
import com.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    BookService bookService;

    @GetMapping(value = "/book/{bid}")
    public Book findBookById(@PathVariable("bid") Integer bid) {

        return bookService.getBookById(bid);

    }

}
