package com.example.blcactivity.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcactivity.po.NewsPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper extends BaseMapper<NewsPO> {
}
