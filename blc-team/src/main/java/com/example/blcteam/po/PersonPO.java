package com.example.blcteam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("PERSON")
public class PersonPO {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //type: 0=教师 1=博士研究生 2=硕士研究生 3=本科生
    private Integer type;
    private String introduction;
    private String link;
    @TableField("personName")
    private String personName;

    public PersonPO(){}

    public PersonPO(Integer id, Integer type, String introduction, String link, String personName) {
        this.id = id;
        this.type = type;
        this.introduction = introduction;
        this.link = link;
        this.personName = personName;
    }
}
