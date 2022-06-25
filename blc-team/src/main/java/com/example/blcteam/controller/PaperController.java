package com.example.blcteam.controller;

import com.example.blcteam.service.PaperService;
import com.example.blcteam.service.TagService;
import com.example.blcteam.vo.PaperVO;
import com.example.blcteam.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    TagService tagService;

    /**
     * 根据标题中是否包含关键字搜索
     * @param keywords
     * @return
     */
    @GetMapping(value = "/papers")
    List<PaperVO> searchPapers(@RequestParam(value = "keywords",required = false)String keywords){
        if(keywords==null) {
            List<PaperVO> paperVOList=paperService.getPapers();
            System.out.println(paperVOList);
            return paperVOList;
        }
        return paperService.searchPaperByName(keywords);
    }

    /**
     * 根据tag筛选文章
     * @param tagName
     * @return
     */
    @GetMapping(value = "paper_with_tag")
    List<PaperVO> searchPapersWithTag(@RequestParam(value = "tagName")String tagName){
        return paperService.searchPaperByTag(tagName);
    }

    /**
     * 增、改文章
     */
    @PostMapping(value = "/papers")
    ResponseVO addOrUpdatePaper(PaperVO paperVO){
        if(paperVO.getId()==null){
            return paperService.savePaper(paperVO);
        }else{
            return paperService.updatePaper(paperVO);
        }
    }

    @DeleteMapping(value = "/papers")
    ResponseVO deletePaper(@RequestParam(value = "paper_id") int paperId){
        if(paperService.removeById(paperId)){
            return ResponseVO.buildSuccess();
        }else {
            return ResponseVO.buildFailure("删除文章失败");
        }
    }

    @PostMapping(value = "/test2")
    ResponseVO test(@RequestBody PaperVO paperVO){
        System.out.println(paperVO);
        return ResponseVO.buildSuccess();
    }
}
