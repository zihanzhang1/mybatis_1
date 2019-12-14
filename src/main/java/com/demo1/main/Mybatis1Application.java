package com.demo1.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.demo1.mapper"})
@ComponentScan(basePackages = {"com.demo1.action","com.demo1.biz"})
public class Mybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis1Application.class, args);
    }

}
