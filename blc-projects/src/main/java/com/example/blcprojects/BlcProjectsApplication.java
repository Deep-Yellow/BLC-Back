package com.example.blcprojects;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blcprojects.mapper")
public class BlcProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlcProjectsApplication.class, args);
    }

}
