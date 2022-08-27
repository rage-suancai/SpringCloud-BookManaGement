package com.borrow.service.client;

import com.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookservice")
public interface BookClient {

    @GetMapping(value = "/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);

}
