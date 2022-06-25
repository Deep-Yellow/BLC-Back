package com.example.blccoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blccoin.mapper")
public class BlcCoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlcCoinApplication.class, args);
    }

}
