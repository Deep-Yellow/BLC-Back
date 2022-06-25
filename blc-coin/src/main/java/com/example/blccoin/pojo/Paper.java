package com.example.blccoin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("PAPERS")
public class Paper {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String year;
    private String conference;
    private String link;
    private String synopsis;
    @TableField("keywords")
    private String keywords;
    private String level;

    public Paper(Integer id, String name, String author, String year, String conference, String link, String synopsis, String keywords, String level) {
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

    /*
    生成SQL脚本时使用
     */
    public String CommaSeparatedValue(){
        return '"'+this.name+"\",\""+this.author+"\",\""
                +this.year+"\",\""+this.conference+"\",\""+this.link
                +"\",\""+this.synopsis+"\",\""+this.keywords+"\",\""+this.level+'"';
    }
}

