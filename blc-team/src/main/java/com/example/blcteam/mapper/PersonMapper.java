package com.example.blcteam.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcteam.po.PersonPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<PersonPO> {
}
