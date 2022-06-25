package com.example.blcteam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcteam.po.PaperTag;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TagMapper extends BaseMapper<PaperTag> {

    @Select("SELECT t1.tagName FROM TAGS t1 WHERE t1.id IN (SELECT tid FROM PAPERTAGS WHERE pid=#{pid});")
    List<String> getTagsByPaper(int pid);

    @Select("SELECT tagName FROM TAGS")
    List<String> getTagsCollection();

    @Select("SELECT id FROM TAGS WHERE tagName=#{tagName} LIMIT 1")
    Integer getTagIdByName(@Param(value = "tagName") String tagName);

    @Insert("INSERT INTO PAPERTAGS(id,pid,tid) VALUES(null,#{pid},#{tid})")
    Boolean addTagToPaper(int pid,int tid);

    @Delete("DELETE FROM PAPERTAGS WHERE pid=#{pid}")
    Boolean deleteTagOfPaper(int pid);


}
