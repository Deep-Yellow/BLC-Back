package com.example.blcprojects.vo;

import com.example.blcprojects.po.ProjectPO;
import lombok.Data;

import java.util.List;

@Data
public class ProjectDetailVO {
    private Integer id;
    private String projectName;
    private String teamName;//
    private List<String> tags;//
    private String synopsis;
    private String otherInfo;
    private String teamInfo;//
    private String teamMember;//
    private String currentProgress;
    private String historyRecord;

    public ProjectDetailVO() {}

    public ProjectDetailVO(Integer id,String projectName, String teamName, List<String> tags, String synopsis, String otherInfo, String teamInfo, String teamMember, String currentProgress, String historyRecord) {
        this.id=id;
        this.projectName = projectName;
        this.teamName = teamName;
        this.tags = tags;
        this.synopsis = synopsis;
        this.otherInfo = otherInfo;
        this.teamInfo = teamInfo;
        this.teamMember = teamMember;
        this.currentProgress = currentProgress;
        this.historyRecord = historyRecord;
    }

    public ProjectDetailVO(ProjectPO projectPO){
        this.id=projectPO.getId();
        this.projectName=projectPO.getProjectName();
        this.synopsis=projectPO.getSynopsis();
        this.otherInfo=projectPO.getOtherInfo();
        this.currentProgress=projectPO.getCurrentProgress();
        this.historyRecord=projectPO.getHistoryRecord();
    }

}
