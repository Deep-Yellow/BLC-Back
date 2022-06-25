package com.example.blcactivity.vo;


import lombok.Data;

@Data
public class BriefActivityVO {
    Integer id;
    String title;
    String time;
    String poster;

    public BriefActivityVO(Integer id, String title, String time, String poster) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.poster = poster;
    }

    public BriefActivityVO() {

    }
}
