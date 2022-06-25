package com.example.blcactivity.vo;

import lombok.Data;

@Data
public class ActivityVO {
    Integer id;
    String title;
    String time;
    Integer views;
    String content;

    public ActivityVO(Integer id, String title, String time, Integer views, String content) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.views = views;
        this.content = content;
    }

    public ActivityVO() {
    }
}
