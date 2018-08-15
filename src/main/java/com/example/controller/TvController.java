package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TvController {

    @Value(value = "${tv.author}")
    private String bookAuthor;
    @Value(value = "${tv.name}")
    private String bookName;
    @Value(value = "${tv.pinyin}")
    private String bookPinyyin;

//    @Autowired
//    private TvBean tvBean;

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot tv name is " + bookAuthor + bookName + bookPinyyin;
    }
}