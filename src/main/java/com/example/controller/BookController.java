package com.example.controller;

import com.example.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//bookbean -> bookcontroller
public class BookController {

    @Autowired
    private BookBean bookBean;

    @GetMapping("/book")
    public String bookdetial(){
        return bookBean.getName() + bookBean.getAuthor() + bookBean.getPrice();
    }
}