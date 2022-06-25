package com.example.blcactivity.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcactivity.po.ActivityPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMapper extends BaseMapper<ActivityPO> {

    @Select("SELECT * FROM ACTIVITY WHERE classify=#{classify} ORDER BY time DESC LIMIT 5")
    List<ActivityPO> getShortList(String classify);

    @Select("SELECT COUNT(*) FROM ACTIVITY WHERE classify=#{classify}")
    Integer getActivityCount(String classify);

    @Select("SELECT DISTINCT classify FROM ACTIVITY")
    List<String> getClassification();
}
