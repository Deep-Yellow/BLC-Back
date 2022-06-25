package com.example.blcprojects.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcprojects.po.ProjectPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper extends BaseMapper<ProjectPO> {
}
