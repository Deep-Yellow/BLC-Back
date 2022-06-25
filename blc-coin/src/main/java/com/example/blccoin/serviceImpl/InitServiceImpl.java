package com.example.blccoin.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blccoin.pojo.ChinesePaper;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.service.ChinesePaperService;
import com.example.blccoin.service.InitService;
import com.example.blccoin.service.PaperService;
import com.example.blccoin.utils.CSVHandler;
import com.example.blccoin.utils.FileListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
初始化工具，受InitController支配
 */
@Service
public class InitServiceImpl implements InitService {

    @Value("${filePath.PapersList}")
    private String fileRootPath;
    @Value("${filePath.LevelMapping}")
    private String mappingFilePath;
    @Value("${filePath.PapersListC}")
    private String fileRootPathCN;
    @Value("${filePath.LevelMappingC}")
    private String mappingFilePathCN;


    @Autowired
    private PaperService paperService;
    @Autowired
    private ChinesePaperService chinesePaperService;
    @Override
    public void InitPaperTable() {
        InitENPapers();
        InitCNPapers();
    }
    public void InitENPapers(){
        String root= fileRootPath;
        ArrayList<String> fileList = FileListUtil.getFileList(root);
        for (String s: fileList) {
            System.out.println("doing: "+s);
            String filePath=root+"/"+s;
            ArrayList<Paper> paperList= CSVHandler.getPaperList(filePath,mappingFilePath);
            paperService.saveBatch(paperList);
        }
    }
    public void InitCNPapers(){
        String root= fileRootPathCN;
        ArrayList<String> fileList = FileListUtil.getFileList(root);
        for (String s: fileList) {
            System.out.println("doing: "+s);
            String filePath=root+"/"+s;
            ArrayList<ChinesePaper> paperList= CSVHandler.getChinesePaperList(filePath,mappingFilePathCN);
            chinesePaperService.saveBatch(paperList);
        }
    }
}
