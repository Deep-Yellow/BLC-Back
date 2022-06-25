package com.example.blcteam.controller;

import com.example.blcteam.po.PaperTag;
import com.example.blcteam.service.TagService;
import com.example.blcteam.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping(value = "/tag")
    public List<String> getTagCollection(){
        return tagService.getTagCollection();
    }


    @PostMapping(value = "/tag")
    public ResponseVO updateTag(PaperTag paperTag){
        if(tagService.saveOrUpdate(paperTag)){
            return ResponseVO.buildSuccess();
        }else{
            return ResponseVO.buildFailure("更新标签失败");
        }
    }

    @DeleteMapping(value = "/tag")
    public ResponseVO updateTag(@RequestParam(value = "tag_id") int tag_id){
        if(tagService.removeById(tag_id)){
            return ResponseVO.buildSuccess();
        }else{
            return ResponseVO.buildFailure("删除标签失败");
        }
    }


}
