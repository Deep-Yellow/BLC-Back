package com.example.blcteam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blcteam.po.PaperPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperMapper extends BaseMapper<PaperPO> {

    @Select("SELECT p.* FROM PAPERS p WHERE LOCATE(#{substring},p.name)>0;")
    List<PaperPO> searchPaperByName(@Param("substring") String substring);

    @Select("SELECT p.* FROM PAPERS p WHERE p.id IN (SELECT pid FROM TAGS t LEFT JOIN PAPERTAGS on t.id=PAPERTAGS.tid WHERE t.tagName=#{tagName})")
    List<PaperPO> searchPaperByTagName(@Param("tagName")String tagName);

    @Insert("INSERT INTO PAPERTAGS")
    Boolean addTagToPaper(@Param("paper_id") int pid,@Param("tagName") String tagName);

}
