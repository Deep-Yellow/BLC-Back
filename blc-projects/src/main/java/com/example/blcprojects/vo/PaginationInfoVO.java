package com.example.blcprojects.vo;

import lombok.Data;

@Data
public class PaginationInfoVO {
    private Integer pageSize;
    private Long totalAmount;

    public PaginationInfoVO() {}

    public PaginationInfoVO(Integer pageSize, Long totalAmount) {
        this.pageSize = pageSize;
        this.totalAmount = totalAmount;
    }
}
