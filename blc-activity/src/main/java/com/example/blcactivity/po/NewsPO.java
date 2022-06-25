package com.example.blcactivity.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ACTIVITY")
public class NewsPO {
    Integer id;
    String title;
    String time;
    Integer views;
    String content;

    public NewsPO(Integer id, String title, String time, Integer views, String content) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.views = views;
        this.content = content;
    }

    public NewsPO() {
    }
}
