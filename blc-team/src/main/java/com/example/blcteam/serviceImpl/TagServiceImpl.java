package com.example.blcteam.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcteam.mapper.TagMapper;
import com.example.blcteam.po.PaperTag;
import com.example.blcteam.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, PaperTag> implements TagService {

    @Autowired
    TagMapper tagMapper;


    @Override
    public List<String> getTagCollection(){
        return tagMapper.getTagsCollection();
    }

    @Override
    public List<String> getTagsNameByPaper(int id) {
        return tagMapper.getTagsByPaper(id);
    }

    @Override
    public Boolean addTagToPaperByTagName(int paperId, String tagName) {
        int tagId=tagMapper.getTagIdByName(tagName);
        return tagMapper.addTagToPaper(paperId,tagId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addTagToPaperBatch(int paperId,List<String> tags){
        for(String tag: tags){
            try{
                Integer tagId=tagMapper.getTagIdByName(tag);
                tagMapper.addTagToPaper(paperId,tagId);
            }catch (NullPointerException e){
                e.printStackTrace();
                //回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return true;
    }


    @Override
    public Boolean deleteTags(int pid) {
        return tagMapper.deleteTagOfPaper(pid);
    }
}
