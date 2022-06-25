package com.example.blcprojects.vo;

import lombok.Data;

@Data
public class BriefProjectVO {
    private Integer projectId;
    private String projectName;
    private String synopsis;
    private String teamName;

    public BriefProjectVO() {
    }

    public BriefProjectVO(Integer projectId,String projectName, String synopsis, String teamName) {
        this.projectId=projectId;
        this.projectName = projectName;
        this.synopsis = synopsis;
        this.teamName = teamName;
    }
}
