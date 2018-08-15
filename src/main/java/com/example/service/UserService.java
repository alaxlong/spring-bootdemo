package com.example.service;

import com.example.bean.User;

//定义业务层接口
public interface UserService {

    void save(User user);

    void delete(int id);

    Iterable<User> getAll();

    void update(User user);

}