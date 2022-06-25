package com.example.blccoin.controller;

import com.example.blccoin.pojo.*;
import com.example.blccoin.service.ChinesePaperService;
import com.example.blccoin.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class GraphController {
    @Autowired
    ChinesePaperService chinesePaperService;
    @Autowired
    PaperService paperService;

    @GetMapping(value = "/enpapers")
    public List<Paper> getEnPapers(){
        return paperService.getSampleList();
    }

    @GetMapping(value = "/cnpapers")
    public List<ChinesePaper> getCnPapers(){
        return chinesePaperService.getSampleList();
    }

    @GetMapping(value = "/keywords")
    public List<Keyword> getKeywords(@RequestParam(value = "level",required = false) String[] level,@RequestParam(value = "year",required = false) String[] year){
        return paperService.getKeywords(level,year);
    }

    @GetMapping(value = "/papers_with_keyword")
    public List<Paper> getPaperWithKeyword(String keyword,
                                           @RequestParam(required = false) String[] level,
                                           @RequestParam(required = false) String[] year,
                                           Long current){
        PaperQuery paperQuery=new PaperQuery(keyword,level,year);
        return paperService.getListByQuery(paperQuery,current);
    }

    @GetMapping(value = "/papers_page")
    public PageData getPaperAmount(String keyword,
                                   @RequestParam(required = false) String[] level,
                                   @RequestParam(required = false) String[] year){
        PaperQuery paperQuery=new PaperQuery(keyword,level,year);
        return paperService.getPageData(paperQuery);
    }

    @GetMapping(value = "/retrieval_en")
    public List<Paper> paperRetrieval(@RequestParam(value = "keywords",required = false)String keywords,@RequestParam(required = false) String[] level,
                                      @RequestParam(required = false) String[] year,
                                      Long current){
        System.out.println(keywords==null);
        PaperQuery paperQuery=PaperQuery.initPaperQueryByWordInTitle(level,year,keywords);
        return paperService.getListByQuery(paperQuery,current);
    }

    @GetMapping(value = "/retrieval_en_page")
    public PageData getRetrievalPageData(@RequestParam(value = "keyword",required = false)String keyword,@RequestParam(required = false) String[] level,
                                         @RequestParam(required = false) String[] year){
        PaperQuery paperQuery=PaperQuery.initPaperQueryByWordInTitle(level,year,keyword);
        return paperService.getPageData(paperQuery);
    }

    @GetMapping(value = "/retrieval_cn_page")
    public PageData getRetrievalPageDataOfCN(@RequestParam(value = "keyword",required = false)String keyword,@RequestParam(required = false) String[] level,
                                             @RequestParam(required = false) String[] year){
        PaperQuery paperQuery=PaperQuery.initPaperQueryByWordInTitle(level,year,keyword);
        return chinesePaperService.getPageData(paperQuery);
    }

    @GetMapping(value = "/retrieval_cn")
    public List<ChinesePaper> paperRetrievalOfCN(@RequestParam(value = "keywords",required = false)String keywords,@RequestParam(required = false) String[] level,
                                      @RequestParam(required = false) String[] year,
                                      Long current){
        System.out.println(keywords==null);
        PaperQuery paperQuery=PaperQuery.initPaperQueryByWordInTitle(level,year,keywords);
        return chinesePaperService.getListByQuery(paperQuery,current);
    }
}
