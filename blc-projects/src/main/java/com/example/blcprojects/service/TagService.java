package com.example.blcprojects.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcprojects.po.TagPO;
import com.example.blcprojects.vo.ResponseVO;

import java.util.List;

public interface TagService extends IService<TagPO> {

    /**
     * 找到文章对应的标签
     */
    List<String> getTagsByProj(Integer pid);

    /**
     * 删除文章的标签
     */
    ResponseVO deleteTag(String tagName,Integer projId);
}
