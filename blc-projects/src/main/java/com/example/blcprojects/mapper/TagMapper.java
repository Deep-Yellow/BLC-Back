package com.example.blcprojects.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcprojects.po.TagPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<TagPO> {

    @Select("SELECT t1.tagName FROM TAG t1 WHERE t1.id IN (SELECT tid FROM PROJECTTAGS WHERE pid=#{pid});")
    List<String> getTagsByProject(int pid);

    @Select("SELECT id FROM TAG WHERE tagName=#{tagName} LIMIT 1")
    Integer getTagIdByName(String tagName);

    @Delete("DELETE FROM PROJECTTAGS WHERE tid=#{tid} AND pid=#{pid} ")
    void deleteTag(Integer pid, Integer tid);
}
