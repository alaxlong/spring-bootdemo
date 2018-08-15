package com.example.controller;

import com.example.bean.BlogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogBean blogBean;

    @GetMapping("/blog")
    public String say(){
        return blogBean.getId() + blogBean.getName();
    }
}