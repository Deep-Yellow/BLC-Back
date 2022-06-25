package com.example.blcprojects.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TeamPO {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("teamName")
    private String teamName;
    @TableField("teamInfo")
    private String teamInfo;
    @TableField("teamMember")
    private String teamMember;

    public TeamPO() {
    }

    public TeamPO(Integer id, String teamName, String teamInfo, String teamMember) {
        this.id = id;
        this.teamName = teamName;
        this.teamInfo = teamInfo;
        this.teamMember = teamMember;
    }
}
