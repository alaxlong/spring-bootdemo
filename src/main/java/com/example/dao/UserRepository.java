package com.example.dao;

import com.example.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//dao数据访问层
//在Spring Boot项目中数据访问层无需提供实现，直接继承数据访问接口即可。
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}