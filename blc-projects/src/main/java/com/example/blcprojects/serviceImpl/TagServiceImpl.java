package com.example.blcprojects.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcprojects.mapper.TagMapper;
import com.example.blcprojects.po.TagPO;
import com.example.blcprojects.service.TagService;
import com.example.blcprojects.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagPO> implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<String> getTagsByProj(Integer pid) {
        return tagMapper.getTagsByProject(pid);
    }

    @Override
    public ResponseVO deleteTag(String tagName, Integer projId) {
        Integer tagId=tagMapper.getTagIdByName(tagName);
        try{
            tagMapper.deleteTag(projId,tagId);
            return ResponseVO.buildSuccess();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseVO.buildFailure("删除Tag失败");
    }
}
