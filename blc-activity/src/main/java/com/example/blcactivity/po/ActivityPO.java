package com.example.blcactivity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ACTIVITY")
public class ActivityPO {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String title;
    String time;
    String classify;
    Integer views;
    String content;
    String poster;

    public ActivityPO(Integer id, String title, String time, String classify, Integer views, String content, String poster) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.classify = classify;
        this.views = views;
        this.content = content;
        this.poster = poster;
    }

    public ActivityPO() {
    }
}
