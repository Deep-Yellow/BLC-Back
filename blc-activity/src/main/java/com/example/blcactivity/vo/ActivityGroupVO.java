package com.example.blcactivity.vo;

import lombok.Data;

import java.util.List;

@Data
public class ActivityGroupVO {
    String title;
    Boolean hasMore;
    List<BriefActivityVO> items;

    public ActivityGroupVO(String title, Boolean hasMore, List<BriefActivityVO> items) {
        this.title = title;
        this.hasMore = hasMore;
        this.items = items;
    }

    public ActivityGroupVO() {
    }
}
