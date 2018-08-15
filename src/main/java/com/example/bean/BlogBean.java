package com.example.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("blog.properties")
public class BlogBean {

    @Value("${blog.id}")
    private String id;
    @Value("${blog.name}")
    private String name;
}