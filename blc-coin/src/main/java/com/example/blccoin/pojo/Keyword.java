package com.example.blccoin.pojo;

import lombok.Data;

@Data
public class Keyword {
    private Integer value;
    private String name;

    public Keyword(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Keyword() {
    }
}
