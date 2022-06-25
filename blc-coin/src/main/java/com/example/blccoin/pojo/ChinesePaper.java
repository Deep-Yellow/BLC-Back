package com.example.blccoin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("CHINESEPAPERS")
public class ChinesePaper {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String year;
    private String conference;
    private String link;
    private String synopsis;
    private String keywords;
    private String level;

    public ChinesePaper(Integer id, String name, String author, String year, String conference, String link, String synopsis, String keywords, String level) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.conference = conference;
        this.link = link;
        this.synopsis = synopsis;
        this.keywords = keywords;
        this.level = level;
    }
}
