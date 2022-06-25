package com.example.blccoin.serviceImpl;

import com.example.blccoin.pojo.ChinesePaper;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.service.ChinesePaperService;
import com.example.blccoin.utils.CSVHandler;
import com.example.blccoin.utils.FileListUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChinesePaperServiceImplTest {

    @Autowired
    private ChinesePaperService chinesePaperService;

    @Value("${filePath.LevelMappingC}")
    private String mappingFilePath;

    @Value("${filePath.PapersListC}")
    private String fileRootPath;

    @Value("${filePath.CSVSampleC}")
    private String csvSample;

    @Test
    void testValue(){
        System.out.println(fileRootPath);
    }

    @Test
    void BatchImportTest(){
        String root= fileRootPath;
        ArrayList<String> fileList = FileListUtil.getFileList(root);
        for (String s: fileList) {
            System.out.println("doing: "+s);
            String filePath=root+"\\"+s;
            ArrayList<ChinesePaper> paperList= CSVHandler.getChinesePaperList(filePath,mappingFilePath);
            chinesePaperService.saveBatch(paperList);
        }
    }

}