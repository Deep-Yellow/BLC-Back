package com.example.blccoin.serviceImpl;

import com.example.blccoin.service.InitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InitServiceImplTest {

    @Autowired
    InitService initService;


    @Test
    void initPaperTable() {
        initService.InitPaperTable();
    }
}