package com.example.blcteam.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("PAPERS")
public class PaperPO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String year;
    private String conference;
    private String link;
    private String synopsis;
    private String keywords;

    //两个构造函数都是mybatis需要用
    public PaperPO(){}
    public PaperPO(Integer id, String name, String author, String year, String conference, String link, String synopsis, String keywords) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.conference = conference;
        this.link = link;
        this.synopsis = synopsis;
        this.keywords = keywords;
    }
}
