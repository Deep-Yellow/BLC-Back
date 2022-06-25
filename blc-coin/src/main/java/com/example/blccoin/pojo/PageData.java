package com.example.blccoin.pojo;

import lombok.Data;

@Data
public class PageData {
    private Long total;
    private Integer size;

    public PageData(Long total, Integer size) {
        this.total = total;
        this.size = size;
    }

    public PageData() {
    }
}
