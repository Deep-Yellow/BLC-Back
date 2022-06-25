package com.example.blcprojects.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TagPO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("tagName")
    private String tagName;

    public TagPO(Integer id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public TagPO() {}
}
