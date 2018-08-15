package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
// 用于标记持久化类,Spring Boot项目加载后会自动根据持久化类建表
@Table(name = "t_user")
@Data
public class User {
    /**
     * 使用@Id指定主键. 使用代码@GeneratedValue(strategy=GenerationType.AUTO)
     * 指定主键的生成策略,mysql默认的是自增长。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String loginName;
    private char sex;
    private int age;
}