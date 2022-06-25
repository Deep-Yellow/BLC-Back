package com.example.blcteam.vo;

import com.example.blcteam.po.PaperPO;
import lombok.Data;

import java.util.List;

@Data
public class PaperVO {
    private Integer id;
    private String name;
    private String author;
    private String year;
    private String conference;
    private String link;
    private String synopsis;
    private String keywords;
    private List<String> tags;


    public PaperVO(){}

    public PaperVO(Integer id, String name, String author, String year, String conference, String link, String synopsis, String keywords,List<String> tags) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.conference = conference;
        this.link = link;
        this.synopsis = synopsis;
        this.keywords = keywords;
        this.tags=tags;
    }

    public PaperPO getPaperPO(){
        return new PaperPO(this.id,this.name,this.author,this.year,this.conference,this.link,this.synopsis,this.keywords);
    }

}
