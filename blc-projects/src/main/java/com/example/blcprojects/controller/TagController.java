package com.example.blcprojects.controller;

import com.example.blcprojects.service.TagService;
import com.example.blcprojects.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @DeleteMapping("/tag")
    ResponseVO deleteTag(@RequestParam(value = "tagName") String tagName,@RequestParam(value = "projectId") int projectId){
        return tagService.deleteTag(tagName,projectId);
    }
}
