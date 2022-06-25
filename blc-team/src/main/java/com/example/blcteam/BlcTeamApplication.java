package com.example.blcteam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blcteam.mapper")
public class BlcTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlcTeamApplication.class, args);
    }

}
