package com.example.blcteam.serviceImpl;

import com.example.blcteam.po.PaperPO;
import com.example.blcteam.utils.FileReaderUtil;
import com.example.blcteam.vo.PaperVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaperServiceImplTest {

    @Autowired
    PaperServiceImpl paperService;


    @Test
    void testGetPapers() {
        System.out.println(paperService.getPapers().size());
    }

    @Test
    void testSearchPaperByName() {
        System.out.println(paperService.searchPaperByName("3").size());
    }

    @Test
    void searchPaperByTag() {
        System.out.println(paperService.searchPaperByName("blockchain").size());
    }

    @Test
    @Transactional
    void savePaper() {
        int formerSize=paperService.getPapers().size();
        List<String> tagList=new ArrayList<>();
        tagList.add("blockchain");
        tagList.add("bitcoin");
        PaperVO paperVO=new PaperVO(null,"testAddPaper","tester","2012","ICSE","http://www.hao123.com","no synopsis","keywords1;keywords2",tagList);
        paperService.savePaper(paperVO);
        int latterSize=paperService.getPapers().size();
        Assertions.assertEquals(formerSize+1, latterSize, "插入前后数目相等");
    }

    @Test
    @Transactional
    void updatePaper() {
        List<String> tagList=new ArrayList<>();
        tagList.add("tagTest1");
        tagList.add("tagTest2");
        PaperVO paperVO=new PaperVO(1,"testAddPaper","tester","2012","ICSE","http://www.hao123.com","no synopsis","keywords1;keywords2",tagList);
        paperService.updatePaper(paperVO);
        System.out.println(paperService.getPapers());
    }

    @Test
    void getPapers() {
        System.out.println(paperService.getPapers());
    }

    @Test
    void importTureData(){
        List<PaperPO> list = FileReaderUtil.test();
        paperService.saveOrUpdateBatch(list);
    }

}