package com.example.blcteam.po;

import lombok.Data;

@Data
public class Project {
    private Integer id;
    private String projectName;
    private String synopsis;
    private String historyRecord;
    private String currentProgress;
    private String team;

    @Override
    public String toString(){
        return "Project [id="+id+", name="+projectName;
    }

    public Project(Integer id, String projectName, String synopsis, String historyRecord, String currentProgress, String team) {
        this.id = id;
        this.projectName = projectName;
        this.synopsis = synopsis;
        this.historyRecord = historyRecord;
        this.currentProgress = currentProgress;
        this.team = team;
    }
}
