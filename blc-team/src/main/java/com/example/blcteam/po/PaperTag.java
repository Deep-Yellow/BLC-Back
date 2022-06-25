package com.example.blcteam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("TAGS")
public class PaperTag {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("tagName")
    private String tagName;

    public PaperTag(){}
    public PaperTag(Integer id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }
}
