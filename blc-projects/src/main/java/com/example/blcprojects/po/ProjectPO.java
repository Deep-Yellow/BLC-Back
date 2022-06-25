package com.example.blcprojects.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("PROJECT")
public class ProjectPO {

    Integer id;
    @TableField("projectName")
    String projectName;
    String synopsis;
    @TableField("otherInfo")
    String otherInfo;
    @TableField("history_record")
    String historyRecord;
    @TableField("current_progress")
    String currentProgress;
    @TableField("teamId")
    Integer teamId;

    public ProjectPO() {}

    public ProjectPO(Integer id, String projectName, String synopsis, String historyRecord, String currentProgress, Integer teamId) {
        this.id = id;
        this.projectName = projectName;
        this.synopsis = synopsis;
        this.historyRecord = historyRecord;
        this.currentProgress = currentProgress;
        this.teamId = teamId;
    }
}
