package com.example.blcteam;

import com.example.blcteam.mapper.PaperMapper;
import com.example.blcteam.po.PaperPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlcTeamApplicationTests {

    @Autowired
    PaperMapper paperMapper;

    @Test
    void selectListTest(){
        List<PaperPO> paperPOList =paperMapper.selectList(null);
        System.out.println(paperPOList);
    }

    @Test
    void contextLoads() {
    }

}
