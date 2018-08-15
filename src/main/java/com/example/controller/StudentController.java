package com.example.controller;

import com.example.bean.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentBean studentBean;

    @RequestMapping(value = "/stu")
    public String hello(){
        return studentBean.getName() + studentBean.getAge();
    }
}