package com.example.blccoin.serviceImpl;

import com.example.blccoin.pojo.Paper;
import com.example.blccoin.pojo.PaperQuery;
import com.example.blccoin.utils.CSVHandler;
import com.example.blccoin.utils.FileListUtil;
import com.example.blccoin.utils.KeywordsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class PaperServiceImplTest {

    @Value("${filePath.LevelMapping}")
    private String mappingFilePath;

    @Value("${filePath.PapersList}")
    private String fileRootPath;

    @Value("${filePath.CSVSample}")
    private String csvSample;

    @Autowired
    PaperServiceImpl paperService;

    @Test
    @Transactional
    void saveOrUpdateBatchTest(){
        ArrayList<Paper> paperList= CSVHandler.getPaperList(csvSample,mappingFilePath);
        paperService.saveBatch(paperList);
    }

    @Test
    void testValue(){
        System.out.println(mappingFilePath);
    }

    @Test
    void BatchImportTest(){
        String root= fileRootPath;
        ArrayList<String> fileList = FileListUtil.getFileList(root);
        for (String s: fileList) {
            System.out.println("doing: "+s);
            String filePath=root+"\\"+s;
            ArrayList<Paper> paperList= CSVHandler.getPaperList(filePath,mappingFilePath);
            paperService.saveBatch(paperList);
        }
    }

    @Test
    void getALevelPapers() {
        System.out.println(paperService.getALevelPapers().size());
    }

    @Test
    void getSampleList() {
        System.out.println(paperService.getSampleList());
    }

    @Test
    void keywordsTest(){
        List<Paper> paperList=paperService.getALevelPapers();
        ArrayList<String> arrayList=new ArrayList<>();
        for(Paper paper:paperList){
            arrayList.add(paper.getKeywords());
        }
        KeywordsUtil.count(arrayList);
    }

//    @Test
//    void getKeywords() {
////        System.out.println(paperService.getKeywords().size());
//    }

    @Test
    void paperListFilterTest1() {
        String[] year={"2021","2020","2019"};
        String[] level={"A"};
        System.out.println(paperService.paperListFilter(level, year).size());
    }

    @Test
    void paperListFilterTest2() {
        String[] year={"2021","2020","2019"};
        String[] level={"A","B"};
        System.out.println(paperService.paperListFilter(level, year).size());
    }

    @Test
    void paperListFilterTest3() {
        String[] year={"2021"};
        String[] level={"A"};
        System.out.println(paperService.paperListFilter(level, year).size());
    }

    @Test
    void getTest() {
        String[] level={"A"};
        String[] year={"2020","2022","2021"};
        String keyword="Privacy";
        PaperQuery paperQuery=new PaperQuery(keyword,level,year);
        List<Paper> paperList=paperService.getListByQuery(paperQuery,4);
        System.out.println(paperList.size());
        for(Paper p:paperList){
            System.out.print(p.getName()+"---");
            System.out.println(p.getKeywords());
        }
    }

    @Test
    void getListByQuery() {
        String[] level={"A"};
        String[] year={"2020","2022","2021"};
        String keyword="Decentralized";
        PaperQuery paperQuery=PaperQuery.initPaperQueryByWordInTitle(level,year,keyword);
        List<Paper> paperList=paperService.getListByQuery(paperQuery,1);
        System.out.println(paperList.size());
        for(Paper p:paperList){
            System.out.print(p.getName()+"---");
            System.out.println(p.getName());
        }
    }
}