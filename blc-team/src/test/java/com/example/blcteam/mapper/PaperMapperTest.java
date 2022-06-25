package com.example.blcteam.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaperMapperTest {

    @Autowired
    PaperMapper paperMapper;

    @Test
    void searchPaperByName() {
        System.out.println(paperMapper.searchPaperByName("3"));
    }

    @Test
    void searchPaperByTagName() {
        System.out.println(paperMapper.searchPaperByTagName("blockchain"));
    }
}