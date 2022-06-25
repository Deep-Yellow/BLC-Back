package com.example.blccoin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blccoin.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

    @Update("truncate table PAPERS")
    void deletePapers();

    @Select("SELECT * FROM PAPERS WHERE level='A'")
    List<Paper> selectALevelPapers();


    @Select("SELECT * FROM PAPERS WHERE level=#{level} AND year=#{year}")
    List<Paper> selectPapersByYearAndLevel(String year,String level);

}