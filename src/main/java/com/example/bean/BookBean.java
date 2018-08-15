package com.example.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "book")
@PropertySource("book.properties")
public class BookBean {
    private String name;
    private String author;
    private String price;

}
