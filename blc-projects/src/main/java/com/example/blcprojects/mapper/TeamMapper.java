package com.example.blcprojects.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcprojects.po.TeamPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeamMapper extends BaseMapper<TeamPO> {

    @Select("SELECT * FROM TEAM WHERE id=#{tid}")
    TeamPO getTeamById(Integer tid);
}
