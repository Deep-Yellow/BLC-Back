package com.example.blccoin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaperMapperTest {

    @Autowired
    PaperMapper paperMapper;


    @Test
    void selectPapersByYearAndLevel() {
        System.out.println(paperMapper.selectPapersByYearAndLevel("2017","A").size());
    }
}