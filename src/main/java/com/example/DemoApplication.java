package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
        //修改Banner的模式为OFF
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
//        builder.bannerMode(Banner.Mode.OFF).run(args);

    }
}