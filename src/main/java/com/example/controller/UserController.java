package com.example.controller;

import com.example.bean.User;
import com.example.dao.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String save(){
        User user = new User();
        user.setLoginName("shang");
        user.setUserName("shangsss");
        user.setAge(22);
        user.setSex('0');
        userService.save(user);
        return "Success！！！";
    }

    @RequestMapping("/update")
    public String update(){
        User user = new User();
        user.setId(1);
        user.setUserName("apple");
        user.setLoginName("swk");
        userService.update(user);
        return "update success!";
    }

    @RequestMapping("/delete")
    public String delete(){
        userService.delete(1);
        return "delete success";
    }

    @RequestMapping("/getAll")
    public Iterable<User> getAll(){
        return userService.getAll();
    }


}