package com.example.service.impl;

import com.example.bean.User;
import com.example.dao.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//定义业务实现层类
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * save,update ,delete 方法需要绑定事务. 使用@Transactional进行事务的绑定.
     */

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void update(User user) {

        User sessionUser = userRepository.findById(user.getId()).get();
        sessionUser.setUserName(user.getUserName());
        sessionUser.setLoginName(user.getLoginName());

    }
}